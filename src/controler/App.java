package controler;

import dao.Singleton;
import frame.Accueil;

public class App {
    public static void main(String[] args) throws Exception {
        Singleton.TestSingleton();
        Accueil.designAccueil();
    }
}