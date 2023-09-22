package Controler;

import ClassMetier.*;
import Frame.Accueil;

public class App {
    public static void main(String[] args) throws Exception {
        Pharmacie p = new Pharmacie();

        Medecins.ajoutMedecins();
        Specialistes.ajoutSpecialiste();
        Medecins.ajoutMedecins();
        Medicaments.ajoutMedicament();
        Accueil.DesignAccueil();
    }
}