package classmetier;

import utils.MyException;

import java.util.regex.Pattern;

public class Medecins extends Personnes {

    private int medId;
    private int agreement;

    /**
     * Constructeur de medecins
     *
     * @param nom        nom du medecin
     * @param prenom     prenom du medecin
     * @param adresse    adresse du medecin
     * @param codePostal code postal du medecin
     * @param ville      ville du medecin
     * @param telephone  telephone du medecin
     * @param email      email du medecin
     * @param agreement  numero d'agreement du medecin
     */
    public Medecins(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                    String email, int agreement) throws MyException {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setAgreement(agreement);
    }

    public Medecins() {
    }

    /**
     * Declaration getters/setters
     */
    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) throws MyException {
        if (!Pattern.matches("[0-9]{3}", "" + agreement)) {
            throw new MyException("Le numéro d'agréément n'est pas valide.");
        }
        this.agreement = agreement;
    }
    public String toString() {
        return getNom();
    }
}
