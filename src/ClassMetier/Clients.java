package ClassMetier;

import utils.MyException;
import utils.DateManagment;

public class Clients extends Personnes {

    private int id;
    private String securiteSociale;
    private String dateNaissance;
    private String mutuelle;
    private Medecins medecin;
    private Specialistes specialiste;
    //private static final Pattern PATTERN = Pattern.compile("^[0-9]{13}$");

    /**
     * Constructeur client
     *
     * @param nom
     * @param prenom
     * @param adresse
     * @param codePostal
     * @param ville
     * @param telephone
     * @param email
     * @param securiteSociale
     * @param dateNaissance
     * @param mutuelle
     * @param medecin
     * @param specialiste
     * @throws Exception
     */
    public Clients(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                   String email, String securiteSociale, String dateNaissance, String mutuelle, Medecins medecin, Specialistes specialiste) throws Exception {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setSecuriteSociale(securiteSociale);
        this.setDateNaissance(dateNaissance);
        this.mutuelle = mutuelle;
        this.medecin = medecin;
        this.specialiste =specialiste;
    }

    /**
     * Mise en place des getters/setters
     */
    public String getSecuriteSociale() {
        return securiteSociale;
    }

    public void setSecuriteSociale(String securiteSociale) throws MyException {
        this.securiteSociale = securiteSociale;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws MyException {
        this.dateNaissance = dateNaissance;
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }

    public Medecins getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecins medecin) {
        this.medecin = medecin;
    }

    public Specialistes getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(Specialistes specialiste) {
        this.specialiste = specialiste;
    }
}