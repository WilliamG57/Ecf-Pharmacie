package classmetier;

import utils.MyException;
import utils.DateManagment;

import java.util.ArrayList;

public class Paniers {

    private ArrayList<LigneArticle> ligneArticles = new ArrayList<>();

    public ArrayList<LigneArticle> getLigneArticles() {
        return ligneArticles;
    }

    public void setLigneArticles(ArrayList<LigneArticle> ligneArticles) {
        this.ligneArticles = ligneArticles;
    }

    private String nom;
    private String medecin;
    private String date;
    private String specialiste;
    private Boolean ordonnance;

    public Paniers() {
    }

    /**
     * Constructeur panier
     *
     * @param nom
     * @param date
     * @throws MyException
     */
    public Paniers(String nom, String date) throws MyException {
        this.setNom(nom);
        this.setDate(date);
    }

    /**
     * Constructeur de panier surcharge
     *
     * @param nom         nom du client
     * @param date        date d'achat
     * @param medecin     nom du medecin
     * @param specialiste nom du specialiste
     * @param ordonnance  boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
    public Paniers(String nom, String date, String medecin, String specialiste, boolean ordonnance) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedecin(medecin);
        this.setSpecialiste(specialiste);
        this.setOrdonnance(ordonnance);
    }

    /**
     * Mise en place des getters/setters
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMedecin() {
        return medecin;
    }

    public String getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Boolean ordonnance) {
        this.ordonnance = ordonnance;
    }

}
