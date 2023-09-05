package Frame;

import ClassMetier.Clients;
import ClassMetier.Historiques;
import ClassMetier.Medicaments;
import Utilitaire.MyException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Achats extends JFrame {
    private JPanel AchatPanel;
    private JComboBox comboClient;
    private JButton btnAchat;
    private JButton btnRetour;
    private JLabel textClient;
    private JLabel labelDate;
    private JTextField textQuantite;
    private JTextField textPrix;
    private JTextField textDate;
    private JComboBox comboMedicament;
    private JLabel labelQuantite;
    private JLabel labelPrix;
    private JLabel labelMedicament;
    private JLabel textTitre;

    public Achats() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(AchatPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Clients clients : Clients.getClient()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
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
        btnAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Historiques.ajoutHistorique((String) comboClient.getSelectedItem(),textDate.getText(),
                            (String) comboMedicament.getSelectedItem(),
                            textQuantite.getText(), textPrix.getText());
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
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

