package classmetier;

import utils.MyException;
import utils.DateManagment;

import java.util.Date;

public class Medicaments {
    /**
     * Declaration de la liste de medicaments
     */

    private int medicamentID;
    private String nom;
    private CategorieMedi categorieMedi;
    private double prix;
    private String miseEnService;
    private String quantite;
    private int catId;

    /**
     * Constructeur de medicaments
     *
     * @param nom
     * @param categorieMedi
     * @param prix
     * @param miseEnService
     * @param quantite
     */
    public Medicaments(String nom, CategorieMedi categorieMedi, double prix, String miseEnService, String quantite) {
        this.nom = nom;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
    }

    public Medicaments(int medicamentID, String nom, CategorieMedi categorieMedi, double prix, String miseEnService, String quantite, int catId) {
        this.medicamentID = medicamentID;
        this.nom = nom;
        this.categorieMedi = categorieMedi;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
        this.catId = catId;
    }

    public Medicaments() {

    }

    /**
     * Declaration des getters/setters
     */

    public int getMedicamentID() {
        return medicamentID;
    }
    public void setMedicamentID(int medicamentID) {
        this.medicamentID = medicamentID;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CategorieMedi getCategorieMedi() {
        return categorieMedi;
    }

    public void setCategorieMedi(CategorieMedi categorieMedi) {
        this.categorieMedi = categorieMedi;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix == 0) {
            throw new NullPointerException("Merci de mettre un prix");
        }
        this.prix = prix;
    }

    public String getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(String miseEnService) throws MyException {
        this.miseEnService = DateManagment.parse(miseEnService,"La date de mise en service n'est pas au bon format");
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public int getCategorie_id() {
        return catId;
    }

    public void setCategorie_id(int categorie_id) {
        this.catId = catId;
    }
}
