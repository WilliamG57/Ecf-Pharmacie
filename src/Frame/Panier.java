package Frame;

import ClassMetier.Paniers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Panier extends JFrame {
    private JTable panierTable;
    private JButton btnSupprimer;
    private JButton btnValider;

    public void tablePanier() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Médicament", "Quantité", "Prix"}, 0);
        for (Paniers panier : Paniers.getPanier()) {
            model.addRow(new Object[]{
                    panier.getDate(),
                    panier.getMedicament(),
                    panier.getQuantite(),
                    panier.getPrix()
            });
        }
    }
}

