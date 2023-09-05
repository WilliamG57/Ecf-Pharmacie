package ClassMetier;

import java.util.ArrayList;

public class Historiques {

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

    public Historiques(String nom, String date, String medicament, String quantite, String prix) {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
    }

    public Historiques(String nom, String date, String medicament, String quantite, String prix, String medecin, String specialiste) {
        this.setNom(nom);
        this.setDate(date);
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
        this.setMedecin(medecin);
        this.setSpecialiste(specialiste);
    }

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


    public static void ajoutHistorique(String nom, String date, String medicament, String quantite, String prix) {
        Historique.add(new Historiques(nom, date, medicament, quantite, prix));
    }

    public static void ajoutHistorique(String nom, String date, String medicament, String quantite, String prix,
                                       String medecin, String specialiste) {
        Historique.add(new Historiques(nom, date, medicament, quantite, prix, medecin, specialiste));
    }

}
