package classmetier;

public class Specialistes extends Personnes {


    private int speId;
    private String specialite;


    /**
     * Constructeur de specialiste
     *
     * @param nom        nom du specialiste
     * @param prenom     prenom du specialiste
     * @param adresse    adresse du specialiste
     * @param codePostal code postal du specialiste
     * @param ville      ville du specialiste
     * @param telephone  telephone du specialiste
     * @param email      email du specialiste
     * @param specialite specialite du specialiste
     */
    public Specialistes(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                        String email, String specialite) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setSpecialite(specialite);
    }

    public Specialistes() {
    }

    /**
     * Declaration getters/setters
     */
    public int getSpeId() {
        return speId;
    }

    public void setSpeId(int speId) {
        this.speId = speId;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    //toString pour l'affichage dans les comboBox
    public String toString() {
        return getNom();
    }
}
