package Frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import ClassMetier.Medecins;

public class Generique extends JFrame {
    private JPanel generiquePanel;
    private JTextField textNom;
    private JTextField textAdresse;
    private JTextField textTelephone;
    private JTextField textPrenom;
    private JTextField textPostal;
    private JTextField textEmail;
    private JTextField textVille;
    private JTextField textAgrement;
    private JLabel Medecin;
    private JLabel Agreement;
    private JLabel Email;
    private JLabel Telephone;
    private JLabel Adresse;
    private JLabel Nom;
    private JLabel Prenom;
    private JLabel Postal;
    private JLabel Ville;

    public Generique(String nom, String type) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Info");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(generiquePanel);
        if (type.equals("Medecin")) PourMedecin(nom);
        // if (type.equals("Specialiste")) P

    }
    public void PourMedecin(String nomMedecin) {
        textNom.setText(nomMedecin);
        for (Medecins medecins : Medecins.getMedecin()) {
            if (medecins.getNom().equals(textNom.getText())) {
                textPrenom.setText(medecins.getPrenom());
                textAdresse.setText(medecins.getAdresse());
                textPostal.setText(medecins.getCodePostal()+"");
                textVille.setText(medecins.getVille());
                textTelephone.setText(medecins.getTelephone());
                textEmail.setText(medecins.getEmail());
                textAgrement.setText(medecins.getAgreement()+"");
            }
        }
    }
}
