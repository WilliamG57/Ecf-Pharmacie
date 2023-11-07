package frame;

import classmetier.Clients;
import classmetier.Medecins;
import classmetier.Mutuelle;
import classmetier.Specialistes;
import dao.MedecinDAO;
import dao.MutuelleDAO;
import dao.SpecialisteDAO;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateClient extends JFrame {
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

    MedecinDAO medecinDAO = new MedecinDAO();
    SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    MutuelleDAO mutuelleDAO = new MutuelleDAO();

    public CreateClient() throws Exception {
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
            comboMedecin.addItem(medecins.getNom());
            comboMedecin.setSelectedIndex(-1);
        }

        for (Specialistes specialistes : specialisteDAO.findAll()) {
            comboSpecialiste.addItem(specialistes.getNom());
            comboSpecialiste.setSelectedIndex(-1);
        }
        for (Mutuelle mutuelle : mutuelleDAO.findAll()) {
            comboMutuelle.addItem(mutuelle.getNom());
            comboMutuelle.setSelectedIndex(-1);
        }
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Accueil.designAccueil();
            }
        });
    }
}
