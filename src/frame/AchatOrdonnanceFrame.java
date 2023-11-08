package frame;

import classmetier.*;
import dao.MedecinDAO;
import dao.MedicamentDAO;
import dao.MutuelleDAO;
import dao.SpecialisteDAO;
import service.ClientService;
import service.PanierService;
import utils.MyException;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AchatOrdonnanceFrame extends JFrame {
    private JTextField textPrix;
    private JTextField textQuantite;
    private JTextField textDate;
    private JComboBox comboMedecin;
    private JComboBox comboClient;
    private JLabel textTitre;
    private JLabel labelClient;
    private JLabel labelMedecin;
    private JLabel labelMedicament;
    private JComboBox comboMedicament;
    private JLabel labelDate;
    private JPanel OrdonnancePanel;
    private JLabel labelQuantite;
    private JLabel labelPrix;
    private JButton btnConfirmer;
    private JButton btnRetour;
    private JComboBox comboSpecialiste;
    private JLabel textSpecialiste;
    private JTextField textBoolean;
    Pharmacie p = new Pharmacie();
    private PanierService panierService = new PanierService();
    ClientService clientService = new ClientService();
    MedecinDAO medecinDAO = new MedecinDAO();
    SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    MutuelleDAO mutuelleDAO = new MutuelleDAO();
    MedicamentDAO medicamentDAO = new MedicamentDAO();



    public AchatOrdonnanceFrame() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Traitement Ordonnance");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(OrdonnancePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Clients clients : clientService.findAll()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
        }

        for (Medecins medecins : medecinDAO.findAll()) {
            comboMedecin.addItem(medecins.getNom());
            comboMedecin.setSelectedIndex(-1);
        }

        for (Specialistes specialistes : specialisteDAO.findAll()) {
            comboSpecialiste.addItem(specialistes.getNom());
            comboSpecialiste.setSelectedIndex(-1);
        }

        for (Medicaments medicaments : medicamentDAO.findAll()) {
            comboMedicament.addItem(medicaments.getNom());
            comboMedicament.setSelectedIndex(-1);
            comboMedicament.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (medicaments.getNom().equals(comboMedicament.getSelectedItem())) {
                        double prix = medicaments.getPrix();
                        textPrix.setText(String.valueOf(prix));
                    }
                }
            });
        }

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panierService.ajoutPanier((String) comboClient.getSelectedItem(), textDate.getText(), (String) comboMedecin.getSelectedItem(),
                            (String) comboSpecialiste.getSelectedItem(), Boolean.valueOf(textBoolean.getText()));
                    panierService.ajoutLigneArticle((String) comboMedicament.getSelectedItem(), Integer.parseInt(textQuantite.getText()), textPrix.getText());
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                try {
                    Ordonnances.ajoutOrdonnances((String) comboClient.getSelectedItem(), textDate.getText(), (String) comboMedicament.getSelectedItem(),
                            textQuantite.getText(), textPrix.getText(), (String) comboMedecin.getSelectedItem(), (String) comboSpecialiste.getSelectedItem());
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Enregistré dans le panier");
                PanierFrame y = null;
                try {
                    y = new PanierFrame(panierService.getPanier());
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });
    }
}
