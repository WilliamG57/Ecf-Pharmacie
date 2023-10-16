package frame;

import classmetier.Paniers;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panier extends JFrame {

    private JPanel panierPanel;
    private JTable tablePanier;

    public Panier() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        tablePanier();
        setTitle("Historique");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panierPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(40, 500, 150, 20);
        panierPanel.add(btnRetour);
        btnRetour.setVisible(true);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Accueil.designAccueil();
            }
        });
    }
    public void tablePanier() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Médicament", "Quantité", "Prix/u"}, 0);
        for (Paniers panier : Paniers.getPanier()) {
            model.addRow(new Object[]{
                    panier.getDate(),
                    panier.getMedicament(),
                    panier.getQuantite(),
                    panier.getPrix()
            });
        }
        tablePanier = new JTable(model);
        panierPanel.add(new JScrollPane(tablePanier));
        getContentPane().add(panierPanel);
        tablePanier.setDefaultEditor(Object.class, null);
    }
}

