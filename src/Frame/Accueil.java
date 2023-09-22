package Frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accueil extends JFrame {
    private JButton btnAchat;
    private JPanel accueilChoix;
    private JButton btnClient;
    private JButton btnHistorique;
    private JButton btnQuitter;
    private JButton btnOrdonnance;

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

        btnAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Achats y = null;
                try {
                    y = new Achats();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });

        btnOrdonnance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AchatOrdonnance y = null;
                try {
                    y = new AchatOrdonnance();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailClient y = null;
                try {
                    y = new DetailClient();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });

        btnHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historique y = new Historique();
                y.setVisible(true);
                dispose();
            }
        });
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
