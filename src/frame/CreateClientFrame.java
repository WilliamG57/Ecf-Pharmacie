package frame;

import classmetier.*;
import dao.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateClientFrame extends JFrame {
    private JPanel createPanel;
    private JButton btnRetour;
    private JTextField textNom;
    private JTextField textMail;
    private JTextField textAdresse;
    private JTextField textPrenom;
    private JTextField textTelephone;
    private JTextField textPostal;
    private JTextField textNaissance;
    private JButton btnCreate;
    private JTextField textSecu;
    private JTextField textVille;
    private JComboBox comboSpecialiste;
    private JComboBox comboMedecin;
    private JComboBox comboMutuelle;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JLabel dateClient;
    private JLabel mailClient;
    private JLabel telClient;
    private JLabel secuClient;
    private JLabel adresseClient;
    private JLabel postalClient;
    private JLabel villeClient;
    private JLabel mutuelleClient;
    private JLabel medecinClient;
    private JLabel specialisteClient;

    private PersonneDAO personneDAO = new PersonneDAO();
    private ClientDAO clientDAO = new ClientDAO();
    private MedecinDAO medecinDAO = new MedecinDAO();
    private SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    private MutuelleDAO mutuelleDAO = new MutuelleDAO();

    public CreateClientFrame() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(createPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectItem = comboMutuelle.getSelectedItem();
                int muId = ((Mutuelle) selectItem).getMutId();
                Object selectItem1 = comboMedecin.getSelectedItem();
                int mId = ((Medecins) selectItem1).getMedId();
                Object selectItem2 = comboSpecialiste.getSelectedItem();
                int sId = ((Specialistes) selectItem2).getSpeId();
                try {
                    Clients cl = getClients(muId, mId, sId);
                    System.out.println(cl.getNom());
                    personneDAO.transactionCreate(cl);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private Clients getClients(int muId, int mId, int sId) {
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
        return cl;
    }
}










































