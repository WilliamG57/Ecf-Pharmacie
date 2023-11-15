package classmetier;

public class CategorieMedi {

    private int catId;
    private String categorie;



    public CategorieMedi() {
    }

    public CategorieMedi(String categorie) {
        this.categorie = categorie;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}
