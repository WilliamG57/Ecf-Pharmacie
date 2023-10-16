package service;

import classmetier.Historiques;
import utils.MyException;

import java.util.ArrayList;

public class HistoriqueService {

    private static final ArrayList<Historiques> historique = new ArrayList<>();

    public static ArrayList<Historiques> getHistorique() {
        return historique;
    }
    public HistoriqueService() {
    }

    /**
     * Constructeur de base pour les achats sans ordonnance
     * @param nom nom du client
     * @param date date d'achat
     * @param medicament nom du medicament
     * @param quantite quantite de medicament
     * @param prix prix du medicament
     * @throws MyException
     */
    public static void ajoutHistorique(String nom, String date, String medicament, String quantite, String prix) throws MyException {
        historique.add(new Historiques(nom, date, medicament, quantite, prix));
    }

    /**
     * Constructeur surcharge pour les achats avec ordonnnance
     * @param nom nom du client
     * @param date date d'achat
     * @param medicament nom du medicament
     * @param quantite quantite de medicament
     * @param prix prix du medicament
     * @param medecin nom du medecin
     * @param specialiste nom du specialiste
     * @param Ordonnance boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
    public static void ajoutHistorique(String nom, String date, String medicament, String quantite, String prix,
                                       String medecin, String specialiste, Boolean Ordonnance) throws MyException {
        historique.add(new Historiques(nom, date, medicament, quantite, prix, medecin, specialiste, Ordonnance));
    }
}
