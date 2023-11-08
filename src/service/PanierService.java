package service;

import classmetier.LigneArticle;
import classmetier.Paniers;
import utils.DateManagment;
import utils.MyException;

public class PanierService {

    Paniers panier = new Paniers();

    public PanierService() {
    }

    public void ajoutPanier(String nom, String date) throws MyException {
        validationDate(date);
        if (!panierDejaExistant()) {
            panier = new Paniers(nom, date);
        }
    }

    public void ajoutPanier(String nom, String date, String medecin, String specialiste, Boolean Ordonnance) throws MyException {
        validationDate(date);
        if (!panierDejaExistant()) {
            panier = new Paniers(nom, date, medecin, specialiste, Ordonnance);
        }
    }

    public Paniers getPanier() {
        return panier;
    }

    private boolean panierDejaExistant() {
        if (panier == null) {
            return false;
        } else if (panier.getNom() == null || panier.getNom().isEmpty()) {
            return false;
        }
        return true;
    }

    public void ajoutLigneArticle(String medicament, int quantite, String prix) throws MyException {
        panier.getLigneArticles().add(new LigneArticle(medicament, quantite, prix));
    }
    public void supprimerPanier() {
        this.panier=null;
        System.gc();
    }

    private void validationQte (int quantite, String message) throws MyException{

    }
    private void validationDate(String date) throws MyException {
        DateManagment.parse(date, "La date n'est pas au bon format");
    }

}