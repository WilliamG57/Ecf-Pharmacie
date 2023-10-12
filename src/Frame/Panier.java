package Frame;

import ClassMetier.Paniers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Panier extends JFrame {
    private JTable PanierTable;
    private JButton BtnSupprimer;
    private JButton BtnValider;

    public void TablePanier() {
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

