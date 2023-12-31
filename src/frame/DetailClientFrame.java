package frame;

import classmetier.*;
import dao.MedecinDAO;
import dao.MutuelleDAO;
import dao.SpecialisteDAO;
import service.ClientService;
import utils.MyException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class DetailClientFrame extends JFrame {
    private JComboBox listeClient;
    private JPanel detailClientPanel;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JLabel dateClient;
    private JLabel adresseClient;
    private JLabel postalClient;
    private JLabel villeClient;
    private JLabel secuClient;
    private JLabel mutuelleClient;
    private JLabel telClient;
    private JLabel mailclient;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField textNaissance;
    private JTextField textVille;
    private JTextField textPostal;
    private JTextField textMail;
    private JTextField textTelephone;
    private JTextField textAdresse;
    private JTextField textSecu;
    private JLabel medecinClient;
    private JButton btnRetour;
    private JLabel specialisteClient;
    private JButton btnModifier;
    private JTextField textId;
    private JTextField textCliId;
    private JComboBox comboMedecin;
    private JComboBox comboSpecialiste;
    private JComboBox comboMutuelle;
    private boolean isNomEditable = false;
    private ClientService clientService = new ClientService();
    private MedecinDAO medecinDAO = new MedecinDAO();
    private SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    private MutuelleDAO mutuelleDAO = new MutuelleDAO();


    public DetailClientFrame() throws Exception {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Détail client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(detailClientPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TODO

        for (Medecins medecins : medecinDAO.findAll()) {
            comboMedecin.addItem(medecins);
            comboMedecin.setSelectedIndex(-1);
        }
        for (Specialistes specialistes : specialisteDAO.findAll()) {
            comboSpecialiste.addItem(specialistes);
            comboSpecialiste.setSelectedIndex(-1);
        }
        for (Mutuelle mutuelle : mutuelleDAO.findAll()) {
            comboMutuelle.addItem(mutuelle);
            comboMutuelle.setSelectedIndex(-1);
        }
        for (Clients clients : clientService.findAll()) {
            listeClient.addItem(clients.getNom());
            listeClient.setSelectedIndex(-1);
            listeClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clients.getNom().equals(listeClient.getSelectedItem())) {
                        textPrenom.setText(clients.getPrenom());
                        textNom.setText(clients.getNom());
                        try {
                            textNaissance.setText(clients.getDateNaissance());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        textCliId.setText(String.valueOf(clients.getCliId()));
                        textId.setText(String.valueOf(clients.getPerId()));
                        textTelephone.setText(clients.getTelephone());
                        textMail.setText(clients.getEmail());
                        textAdresse.setText(clients.getAdresse());
                        textPostal.setText(clients.getCodePostal());
                        textVille.setText(clients.getVille());
                        textSecu.setText(clients.getSecuriteSociale());
                        comboMutuelle.setSelectedItem(clients.getMutuelle());
                        comboMedecin.setSelectedItem(clients.getMedecin());
                        comboSpecialiste.setSelectedItem(clients.getSpecialiste());
                    }
                }
            });
        }
//        comboSpecialiste.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                GeneriqueFrame x = null;
//                try {
//                    x = new GeneriqueFrame(medecin.getNom, "Specialiste");
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                x.setVisible(true);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

//        textMedecin.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    GeneriqueFrame x = new GeneriqueFrame(textMedecin.getText(), "Medecin");
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                setVisible(true);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

        //Bouton 1er clik pour rendre les champs editable,
        //puis second clik pour valider la modification du client
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNom.setEditable(true);
                textPrenom.setEditable(true);
                textNaissance.setEditable(true);
                textTelephone.setEditable(true);
                textMail.setEditable(true);
                comboSpecialiste.setEditable(true);
                comboSpecialiste.setEnabled(false);
                textAdresse.setEditable(true);
                textPostal.setEditable(true);
                textVille.setEditable(true);
                textSecu.setEditable(true);
                comboMutuelle.setEditable(true);
                comboMedecin.setEditable(true);
                btnModifier.setText("Valider");
                int perId = Integer.parseInt(textId.getText());
                int clId = Integer.parseInt(textCliId.getText());
                Object selectItem = comboMutuelle.getSelectedItem();
                int muId = ((Mutuelle) selectItem).getMutId();
                Object selectItem1 = comboMedecin.getSelectedItem();
                int mId = ((Medecins) selectItem1).getMedId();
                Object selectItem2 = comboSpecialiste.getSelectedItem();
                int sId = ((Specialistes) selectItem2).getSpeId();
                if (isNomEditable == true) {
                    try {
                        Clients cl = getClients(muId, mId, sId, perId, clId);
                        clientService.modifierClient(cl);
                        JOptionPane.showMessageDialog(null, "Validé");
                        isNomEditable = false;
                        dispose();
                        AccueilFrame.designAccueil();
                    } catch (MyException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                isNomEditable = true;
            }
        });

        //Bouton pour retourner pas d'accueil
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });
    }

    private Clients getClients(int muId, int mId, int sId, int perId, int clId) {
        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String adresse = textAdresse.getText();
        String codePostal = textPostal.getText();
        String ville = textVille.getText();
        String telephone = textTelephone.getText();
        String email = textMail.getText();
        String securiteSocial = textSecu.getText();
        String dateNaissance = textNaissance.getText();
        int mutuelle = muId;
        int medecin = mId;
        int specialiste = sId;
        Clients cl =
                new Clients(nom, prenom, adresse, codePostal, ville, telephone, email,
                        securiteSocial, dateNaissance, mutuelle, medecin, specialiste);
        cl.setPerId(perId);
        cl.setCliId(clId);
        return cl;
    }
}
