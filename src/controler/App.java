package controler;

import connect.Connexion;
import connect.Singleton;
import frame.Accueil;

public class App {
    public static void main(String[] args) throws Exception {
        //Singleton.getInstanceDB();
        Singleton.TestSingleton();
        Accueil.designAccueil();
    }
}