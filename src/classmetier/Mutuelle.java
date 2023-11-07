package classmetier;

public class Mutuelle  {

    private int mutId;
    private String nom;

    public Mutuelle() {
    }

    public Mutuelle(int mutId, String nom) {
        this.mutId = mutId;
        this.nom = nom;
    }

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
}
