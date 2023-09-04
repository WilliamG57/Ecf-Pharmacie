package Frame;

import ClassMetier.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AchatOrdonnance extends JFrame {
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

    public AchatOrdonnance() {
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

        for (Clients clients : Clients.getClient()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
        }

        for (Medecins medecins : Medecins.getMedecin()) {
            comboMedecin.addItem(medecins.getNom());
            comboMedecin.setSelectedIndex(-1);
        }

        for (Specialistes specialistes : Specialistes.getSpecialiste()) {
            comboSpecialiste.addItem(specialistes.getNom());
            comboSpecialiste.setSelectedIndex(-1);
        }

        for (Medicaments medicaments : Medicaments.getMedicament()) {
            comboMedicament.addItem(medicaments.getNom());
            comboMedicament.setSelectedIndex(-1);
            comboMedicament.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (medicaments.getNom().equals(comboMedicament.getSelectedItem())) {
                        textPrix.setText(medicaments.getPrix());
                    }
                }
            });
        }

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historiques.ajoutHistorique((String) comboClient.getSelectedItem(),textDate.getText(), (String) comboMedicament.getSelectedItem(),
                        textQuantite.getText(),textPrix.getText(), (String) comboMedecin.getSelectedItem(), (String) comboSpecialiste.getSelectedItem());
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Accueil.DesignAccueil();
            }
        });
    }
}
