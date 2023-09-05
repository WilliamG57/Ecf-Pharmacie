package ClassMetier;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Medecins extends Personnes {
    /**
     * Déclaration de la liste des médecins
     */
    private static final ArrayList<Medecins> Medecin = new ArrayList<Medecins>();
    private int agreement;

    public static ArrayList<Medecins> getMedecin() {
        return Medecin;
    }

    /**
     * Constructeur de médecins
     *
     * @param nom
     * @param prenom
     * @param adresse
     * @param codePostal
     * @param ville
     * @param telephone
     * @param email
     * @param agreement
     */
    public Medecins(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                    String email, int agreement) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setAgreement(agreement);
    }

    /**
     * Déclaration getters/setters
     */
    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) throws IllegalArgumentException {
        if (!Pattern.matches("[0-9]{3}", "" + agreement)) {
            throw new IllegalArgumentException("Le numéro d'agréément n'est pas valide.");
        }
        this.agreement = agreement;
    }

    /**
     * Création du jeu de test de médecin
     */
    public static void ajoutMedecins() {

        Medecin.add(new Medecins("a", "aa", "123 rue a", "10000", "abc",
                "4567891234", "aa.a@gmail.com", 458));
        Medecin.add(new Medecins("b", "bb", "456 rue b", "20000", "efg",
                "5678912345", "b.bb@gmail.com", 126));
        Medecin.add(new Medecins("c", "cc", "789 rue c", "30000", "hij",
                "6789123456", "c.cc@gmail.com", 824));
    }
}
