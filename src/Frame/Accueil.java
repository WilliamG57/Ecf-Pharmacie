package Frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.nimbus.NimbusStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Frame.*;

public class Accueil extends JFrame {
    private JButton btnAchat;
    private JPanel accueilChoix;
    private JButton btnClient;
    private JButton btnHistorique;
    private JButton btnQuitter;

    public static void DesignAccueil() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        Accueil x = new Accueil();
        x.setSize(1000, 600);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
        x.getContentPane().add(x.accueilChoix);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Accueil() {
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailClient y = new DetailClient();
                y.setVisible(true);
                dispose();
            }
        });
    }
}
