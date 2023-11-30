package classmetier;

import utils.MyException;
import utils.DateManagment;

public class Medicaments {
    /**
     * Declaration de la liste de medicaments
     */

    private int medicamentID;
    private String nom;
    private CategorieMedi categorieMedi;
    private double prix;
    private String miseEnService;
    private int stock;
    private int categorie_id;

    /**
     * Constructeur de medicaments
     *
     * @param nom
     * @param categorieMedi
     * @param prix
     * @param miseEnService
     * @param stock
     */
    public Medicaments(String nom, CategorieMedi categorieMedi, double prix, String miseEnService, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.stock = stock;
    }

    /**
     * Constructeur
     *
     * @param medicamentID
     * @param nom
     * @param categorieMedi
     * @param prix
     * @param miseEnService
     * @param stock
     * @param categorie_Id
     */
    public Medicaments(int medicamentID, String nom, CategorieMedi categorieMedi, double prix, String miseEnService, int stock, int categorie_Id) {
        this.medicamentID = medicamentID;
        this.nom = nom;
        this.categorieMedi = categorieMedi;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.stock = stock;
        this.categorie_id = categorie_Id;
    }

    public Medicaments() {

    }

    /**
     * Mise en place des getters/setters
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }
}
