package classmetier;

import utils.MyException;

public class LigneArticle {
    private String prix;
    private String medicament;
    private int quantite;


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


    /**
     * Constructeur panier
     *
     * @param medicament
     * @param quantite
     * @param prix
     * @throws MyException
     */
    public LigneArticle(String medicament, int quantite, String prix) throws MyException {
        this.setMedicament(medicament);
        this.setQuantite(quantite);
        this.setPrix(prix);
    }
}
