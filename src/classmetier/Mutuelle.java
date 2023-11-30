package classmetier;

public class Mutuelle {

    private int mutId;
    private String nom;


    /**
     * Constructeur
     * @param mutId
     * @param nom
     */
    public Mutuelle(int mutId, String nom) {
        this.mutId = mutId;
        this.nom = nom;
    }

    public Mutuelle() {
    }

    /**
     * Mise en place des getters/setters
     */
    public int getMutId() {
        return mutId;
    }

    public void setMutId(int mutId) {
        this.mutId = mutId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    //toString pour l'affichage dans les comboBox
    public String toString() {
        return nom;
    }
}
