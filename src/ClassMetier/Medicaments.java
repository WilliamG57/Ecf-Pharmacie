package ClassMetier;

import utils.MyException;
import utils.DateManagment;

public class Medicaments {
    /**
     * Declaration de la liste de medicaments
     */

    private String nom;
    private String categorie;
    private String prix;
    private String miseEnService;
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
    public Medicaments(String nom, String categorie, String prix, String miseEnService, String quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.miseEnService = miseEnService;
        this.quantite = quantite;
    }

    /**
     * Declaration des getters/setters
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
        this.miseEnService = DateManagment.parse(miseEnService,"La date de mise en service n'est pas au bon format");
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

}
