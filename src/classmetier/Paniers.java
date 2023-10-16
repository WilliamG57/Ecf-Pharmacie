package classmetier;

import utils.MyException;
import utils.DateManagment;

import java.util.ArrayList;

public class Paniers {

    private static final ArrayList<Paniers> panier = new ArrayList<>();

    public static ArrayList<Paniers> getPanier() {
        return panier;
    }

    private String nom;
    private String medecin;
    private String date;
    private String medicament;
    private String quantite;
    private String prix;
    private String specialiste;
    private Boolean Ordonnance;

    /**
     * Constructeur panier
     *
     * @param nom
     * @param date
     * @param medicament
     * @param quantite
     * @param prix
     * @throws MyException
     */
    public Paniers(String nom, String date, String medicament, String quantite, String prix) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
    }

    /**
     * Constructeur de panier surcharge
     *
     * @param nom         nom du client
     * @param date        date d'achat
     * @param medicament  nom du medicament
     * @param quantite    quantite de medicament
     * @param prix        prix du medicament
     * @param medecin     nom du medecin
     * @param specialiste nom du specialiste
     * @param ordonnance  boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
    public Paniers(String nom, String date, String medicament, String quantite, String prix, String medecin, String specialiste, boolean ordonnance) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
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

    public void setDate(String date) throws MyException {
        this.date = DateManagment.parse(date, "La date n'est pas au bon format");
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Boolean getOrdonnance() {
        return Ordonnance;
    }

    public void setOrdonnance(Boolean ordonnance) {
        Ordonnance = ordonnance;
    }

    /**
     * Constructeur de base pour les achats sans ordonnance
     *
     * @param nom        nom du client
     * @param date       date d'achat
     * @param medicament nom du medicament
     * @param quantite   quantite de medicament
     * @param prix       prix du medicament
     * @throws MyException
     */
    public static void ajoutPanier(String nom, String date, String medicament, String quantite, String prix) throws MyException {
        panier.add(new Paniers(nom, date, medicament, quantite, prix));
    }

    /**
     * Constructeur surcharge pour les achats avec ordonnnance
     *
     * @param nom         nom du client
     * @param date        date d'achat
     * @param medicament  nom du medicament
     * @param quantite    quantite de medicament
     * @param prix        prix du medicament
     * @param medecin     nom du medecin
     * @param specialiste nom du specialiste
     * @param Ordonnance  boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
    public static void ajoutPanier(String nom, String date, String medicament, String quantite, String prix,
                                   String medecin, String specialiste, Boolean Ordonnance) throws MyException {
        panier.add(new Paniers(nom, date, medicament, quantite, prix, medecin, specialiste, Ordonnance));
    }
}
