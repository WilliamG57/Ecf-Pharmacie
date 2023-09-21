package Controler;

import ClassMetier.*;
import Frame.Accueil;

public class App {
    public static void main(String[] args) {

        try {
            Pharmacie.ajoutClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Medecins.ajoutMedecins();
        Specialistes.ajoutSpecialiste();
        Medecins.ajoutMedecins();
        Medicaments.ajoutMedicament();
        Accueil.DesignAccueil();
    }
}