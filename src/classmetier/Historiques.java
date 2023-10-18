package classmetier;

import utils.MyException;
import utils.DateManagment;

public class Historiques {


    private String nom;
    private String medecin;
    private String date;
    private String medicament;
    private int quantite;
    private String prix;
    private String specialiste;
    private Boolean Ordonnance;

    public Historiques() {
    }


    /**
     * Constructeur historique
     *
     * @param nom
     * @param date
     * @param medicament
     * @param quantite
     * @param prix
     * @throws MyException
     */
    public Historiques(String nom, String date, String medicament, int quantite, String prix) throws MyException {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
    }

    /**
     * Constructeur d'historique surcharge
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
    public Historiques(String nom, String date, String medicament, int quantite, String prix, String medecin, String specialiste, boolean ordonnance) throws MyException {
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
        this.date = date;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
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

}
