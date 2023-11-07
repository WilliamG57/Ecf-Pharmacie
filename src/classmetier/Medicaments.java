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
    private String categorie;
    private double prix;
    private Date miseEnService;
    private String quantite;

    /**
     * Constructeur de medicaments
     *
     * @param nom
     * @param categorie
     * @param prix
     * @param miseEnService
     * @param quantite
     */
    public Medicaments(String nom, String categorie, double prix, Date miseEnService, String quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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

    public Date getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(Date miseEnService) throws MyException {
        this.miseEnService = DateManagment.parse(miseEnService,"La date de mise en service n'est pas au bon format");
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

}
