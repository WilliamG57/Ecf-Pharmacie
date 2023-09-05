package ClassMetier;

import Utilitaire.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Medicaments {
    /**
     * Déclaration de la liste de médicaments
     */
    private static final ArrayList<Medicaments> Medicament = new ArrayList<>();

    public static ArrayList <Medicaments> getMedicament() {
        return Medicament;
    }
    private String nom;
    private String categorie;
    private String prix;
    private String miseEnService;
    private String quantite;

    /**
     * Constructeur de médicaments
     * @param nom
     * @param categorie
     * @param prix
     * @param miseEnService
     * @param quantite
     */
    public Medicaments(String nom, String categorie, String prix, String miseEnService, String quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
    }

    /**
     * Déclaration des getters/setters
     */
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
        if (prix == null) {
            throw new NullPointerException("Merci de mettre un prix");
        }
        this.prix = prix;
    }

    public String getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(String miseEnService) throws MyException {
        try {
            if (miseEnService == null) {
                throw new NullPointerException("Merci de mettre une date de mise en service");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(miseEnService);
            this.miseEnService = miseEnService;
        } catch (
                ParseException pe) {
            throw new MyException("La date de mise en service n'est pas au bon format");
        }
    }
    public String getQuantite() {
        return quantite;
    }


    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    /**
     * Création du jeu de test de médicaments
     */
    public static void ajoutMedicament() {
        Medicament.add(new Medicaments("Doliprane", "Anti-douleur", "4,50", "Mars 1964", "14"));
        Medicament.add(new Medicaments("Millepertuis", "Somnifère", "7,90", "Juin 1985", "8"));
        Medicament.add(new Medicaments("Collyre", "Goutte", "3,39", "Mars 1954", "31"));
        Medicament.add(new Medicaments("Sildenafil", "Viagra", "9,99", "Avril 1998", "18"));
    }
}
