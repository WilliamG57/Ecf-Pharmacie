package Controler;

import ClassMetier.*;
import Frame.Accueil;

public class App {
    public static void main(String[] args) {

        Clients.ajoutClient();
        Medecins.ajoutMedecins();
        Specialistes.ajoutSpecialiste();
        Medecins.ajoutMedecins();
        Medicaments.ajoutMedicament();
        Accueil.DesignAccueil();
    }
}