package ClassMetier;

import Utilitaire.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Historiques {
    /**
     * Declaration de la liste contenant les historiques
     */
    private static final ArrayList<Historiques> Historique = new ArrayList<>();

    public static ArrayList<Historiques> getHistorique() {
        return Historique;
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
     * Constructeur historique
     * @param nom
     * @param date
     * @param medicament
     * @param quantite
     * @param prix
     * @throws MyException
     */
    public Historiques(String nom, String date, String medicament, String quantite, String prix) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
    }

    /**
     * Constructeur d'historique surcharge
     * @param nom nom du client
     * @param date date d'achat
     * @param medicament nom du medicament
     * @param quantite quantite de medicament
     * @param prix prix du medicament
     * @param medecin nom du medecin
     * @param specialiste nom du specialiste
     * @param ordonnance boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
    public Historiques(String nom, String date, String medicament, String quantite, String prix, String medecin, String specialiste, boolean ordonnance) throws MyException {
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

    public Boolean getOrdonnance() {
        return Ordonnance;
    }
    public void setOrdonnance(Boolean ordonnance) {
        Ordonnance = ordonnance;
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
        Historique.add(new Historiques(nom, date, medicament, quantite, prix));
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
        Historique.add(new Historiques(nom, date, medicament, quantite, prix, medecin, specialiste, Ordonnance));
    }

}
