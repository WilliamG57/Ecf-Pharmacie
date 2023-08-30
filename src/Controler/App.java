package Controler;

import ClassMetier.Clients;
import ClassMetier.Medecins;
import Frame.Accueil;

public class App {
    public static void main(String[] args) {

        Clients.ajoutClient();
        Medecins.ajoutMedecins();
        Accueil.DesignAccueil();
    }
}