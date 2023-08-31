package ClassMetier;

import java.util.ArrayList;

public class Medicaments {

    private static final ArrayList<Medicaments> Medicament = new ArrayList<>();

    public static ArrayList <Medicaments> getMedicament() {
        return Medicament;
    }
    private String nom;
    private String categorie;
    private String prix;
    private String miseEnService;
    private String quantite;

    public Medicaments(String nom, String categorie, String prix, String miseEnService, String quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(String miseEnService) {
        this.miseEnService = miseEnService;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public static void ajoutMedicament() {
        Medicament.add(new Medicaments("Doliprane", "Anti-douleur", "4,50", "Mars 1964", "14"));
        Medicament.add(new Medicaments("Millepertuis", "Somnifère", "7,90", "Juin 1985", "8"));
        Medicament.add(new Medicaments("Collyre", "Goutte", "3,39", "Mars 1954", "31"));
        Medicament.add(new Medicaments("Sildenafil", "Viagra", "9,99", "Avril 1998", "18"));
    }
}
