package controler;

import dao.Singleton;
import frame.AccueilFrame;
import utils.DateManagment;

public class App {
    public static void main(String[] args) throws Exception {
        Singleton.TestSingleton();
        AccueilFrame.designAccueil();
    }
}