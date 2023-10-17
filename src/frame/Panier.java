package frame;

import classmetier.Historiques;
import classmetier.LigneArticle;
import classmetier.Paniers;
import service.HistoriqueService;
import service.PanierService;
import utils.MyException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Panier extends JFrame {

    Paniers pa = new Paniers();
    private JPanel panierPanel;
    private JTable tablePanier;

    public Panier() throws MyException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        tablePanier();
        setTitle("Panier");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panierPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnValider = new JButton("Valider");
        btnValider.setBounds(80,500, 150,20);
        panierPanel.add(btnValider);
        btnValider.setVisible(true);
        JButton btnSupprimer = new JButton("Supprimer");
        btnValider.setBounds(80,500, 150,20);
        panierPanel.add(btnSupprimer);
        btnSupprimer.setVisible(true);
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(40, 500, 150, 20);
        panierPanel.add(btnRetour);
        btnRetour.setVisible(true);
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void tablePanier() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Médicament", "Quantité", "Prix/u"}, 0);
        for (LigneArticle ligneArticles : pa.getLigneArticles()) {
            model.addRow(new Object[]{
                    ligneArticles.getMedicament(),
                    ligneArticles.getQuantite(),
                    ligneArticles.getPrix()
            });
        }
        tablePanier = new JTable(model);
        panierPanel.add(new JScrollPane(tablePanier));
        getContentPane().add(panierPanel);
        tablePanier.setDefaultEditor(Object.class, null);
    }
}

