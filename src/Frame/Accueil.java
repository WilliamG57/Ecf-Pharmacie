package Frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.nimbus.NimbusStyle;

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
        x.setSize(600, 400);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
        x.getContentPane().add(x.accueilChoix);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Accueil() {


    }
}
