package Frame;

import ClassMetier.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class DetailClient extends JFrame {
    private JComboBox listeClient;
    private JPanel DetailClientPanel;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JLabel dateClient;
    private JLabel adresseClient;
    private JLabel postalClient;
    private JLabel villeClient;
    private JLabel secuClient;
    private JLabel mutuelleClient;
    private JLabel telClient;
    private JLabel mailclient;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField textNaissance;
    private JTextField textVille;
    private JTextField textPostal;
    private JTextField textMail;
    private JTextField textTelephone;
    private JTextField textAdresse;
    private JTextField textSecu;
    private JTextField textMutuelle;
    private JTextField textMedecin;
    private JLabel medecinClient;
    private JButton btnRetour;
    private JTextField textSpecialiste;
    private JLabel specialisteClient;


    public DetailClient() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(DetailClientPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Clients clients : Clients.getClient()) {
            listeClient.addItem(clients.getNom());
            listeClient.setSelectedIndex(-1);
            listeClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clients.getNom().equals(listeClient.getSelectedItem())) {
                        textPrenom.setText(clients.getPrenom());
                        textNom.setText(clients.getNom());
                        try {
                            textNaissance.setText(clients.getDateNaissance());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        textTelephone.setText(clients.getTelephone());
                        textMail.setText(clients.getEmail());
                        textAdresse.setText(clients.getAdresse());
                        textPostal.setText(clients.getCodePostal() + "");
                        textVille.setText(clients.getVille());
                        textSecu.setText(clients.getSecuriteSociale() + "");
                        textMutuelle.setText(clients.getMutuelle());
                        textMedecin.setText(clients.getMedecin());
                        textSpecialiste.setText(clients.getSpecialiste());
                    }
                }
            });
        }
        textSpecialiste.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Generique x = new Generique(textSpecialiste.getText(), "Specialiste");
                x.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        textMedecin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Generique x = new Generique(textMedecin.getText(), "Medecin");
                setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
