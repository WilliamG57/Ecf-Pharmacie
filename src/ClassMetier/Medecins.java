package ClassMetier;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Medecins extends Personnes {
    /**
     * Declaration de la liste des medecins
     */
    private static final ArrayList<Medecins> Medecin = new ArrayList<Medecins>();
    private int agreement;

    public static ArrayList<Medecins> getMedecin() {
        return Medecin;
    }

    /**
     * Constructeur de medecins
     *
     * @param nom nom du medecin
     * @param prenom prenom du medecin
     * @param adresse adresse du medecin
     * @param codePostal code postal du medecin
     * @param ville ville du medecin
     * @param telephone telephone du medecin
     * @param email email du medecin
     * @param agreement numero d'agreement du medecin
     */
    public Medecins(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                    String email, int agreement) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setAgreement(agreement);
    }

    /**
     * Declaration getters/setters
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
     * Creation du jeu de test de medecin
     */
    public static void ajoutMedecins() {

        Medecin.add(new Medecins("aaa", "aa", "123 rue a", "10000", "abc",
                "4567891234", "aa.a@gmail.com", 458));
        Medecin.add(new Medecins("bbb", "bb", "456 rue b", "20000", "efg",
                "5678912345", "b.bb@gmail.com", 126));
        Medecin.add(new Medecins("ccc", "cc", "789 rue c", "30000", "hij",
                "6789123456", "c.cc@gmail.com", 824));
    }
}
