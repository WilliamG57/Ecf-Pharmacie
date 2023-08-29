package Controler;

import ClassMetier.Clients;
import Frame.Accueil;

public class App {
    public static void main(String[] args) {

        Clients.ajoutClient();

        Accueil.DesignAccueil();
    }
}