package service;

import classmetier.LigneArticle;
import classmetier.Paniers;
import utils.MyException;

import java.util.ArrayList;

public class PanierService {

    Paniers pa = new Paniers();
    private final ArrayList<Paniers> panier = new ArrayList<>();

    public  ArrayList<Paniers> getPanier() {
        return panier;
    }

    public PanierService() {
    }

    public void ajoutPanier(String nom, String date) throws MyException {
        panier.add(new Paniers(nom, date));
    }

    public void ajoutPanier(String nom, String date, String medecin, String specialiste, Boolean Ordonnance) throws MyException {
        panier.add(new Paniers(nom, date, medecin, specialiste, Ordonnance));
    }

    public void ajoutLigneArticle (String medicament, String quantite, String prix) throws MyException {
        pa.getLigneArticles().add(new LigneArticle(medicament, quantite, prix));
    }


}
