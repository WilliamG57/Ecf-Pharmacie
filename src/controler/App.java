package controler;

import dao.Singleton;
import frame.AccueilFrame;

public class App {
    public static void main(String[] args) throws Exception {
        Singleton.TestSingleton();
        AccueilFrame.designAccueil();
    }
}