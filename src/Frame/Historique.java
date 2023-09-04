package Frame;

import ClassMetier.Historiques;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Historique extends JFrame {
    private JPanel HistoriquePanel;
    private JTable table1;
    private JTextField textField;

    public Historique() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        TableHistorique();
        setTitle("Historique");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(HistoriquePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void TableHistorique() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Client","Date", "Médecin", "Médicament", "Spécialiste"}, 0);
        for (Historiques historique : Historiques.getHistorique()) {
            model.addRow(new Object[]{
                    historique.getNom(),
                    historique.getDate(),
                    historique.getMedecin(),
                    historique.getMedicament(),
                    historique.getSpecialiste()
            });
        }
        table1 = new JTable(model);
        HistoriquePanel.add(new JScrollPane(table1));
        getContentPane().add(HistoriquePanel);
        textField = new JTextField();
        add(textField);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String terme = textField.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                sorter.setRowFilter(RowFilter.regexFilter(terme));
                table1.setRowSorter(sorter);
            }
        });
    }
}
