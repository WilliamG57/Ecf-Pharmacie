package ClassMetier;

import Utilitaire.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Ordonnances {

    private static final ArrayList<Ordonnances> Ordonnance = new ArrayList<>();

    public static ArrayList<Ordonnances> getOrdonnance() {
        return Ordonnance;
    }

    private String nom;
    private String medecin;
    private String date;
    private String medicament;
    private String quantite;
    private String prix;
    private String specialiste;


    /**
     * Constructeur d'ordonnance
     *
     * @param nom
     * @param date
     * @param medicament
     * @param quantite
     * @param prix
     * @param medecin
     * @param specialiste
     * @throws MyException
     */
    public Ordonnances(String nom, String date, String medicament, String quantite, String prix, String medecin, String specialiste) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
        this.setMedecin(medecin);
        this.setSpecialiste(specialiste);
    }

    /**
     * Mise en place des getters/setters
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
        try {
            if (date == null) {
                throw new NullPointerException("Merci de mettre une date");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(date);
            this.date = date;
        } catch (
                ParseException pe) {
            throw new MyException("La date n'est pas au bon format");
        }
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

    /**
     * Constructeur pour l'ajout dans la liste ordonnance
     * @param nom
     * @param date
     * @param medicament
     * @param quantite
     * @param prix
     * @param medecin
     * @param specialiste
     * @throws MyException
     */
    public static void ajoutOdonnances(String nom, String date, String medicament, String quantite, String prix,
                                       String medecin, String specialiste) throws MyException {
        Ordonnance.add(new Ordonnances(nom, date, medicament, quantite, prix, medecin, specialiste));
    }
}
