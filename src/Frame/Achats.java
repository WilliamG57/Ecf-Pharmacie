package Frame;

import ClassMetier.Clients;
import ClassMetier.Historiques;
import ClassMetier.Medicaments;
import ClassMetier.Pharmacie;
import service.HistoriqueService;
import utils.MyException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Achats extends JFrame {
    private JPanel achatPanel;
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
    private JTextField textBoolean;
    Pharmacie p = new Pharmacie();

    public Achats() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(achatPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Clients clients : p.getClient()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
        }
        for (Medicaments medicaments : p.getMedicament()) {
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
                    HistoriqueService.ajoutHistorique((String) comboClient.getSelectedItem(),textDate.getText(),
                            (String) comboMedicament.getSelectedItem(),
                            textQuantite.getText(), textPrix.getText());
                    JOptionPane.showMessageDialog(null,"Achat réalisé");
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Accueil.designAccueil();
            }
        });
    }
}

