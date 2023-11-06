package classmetier;

public class Clients extends Personnes {

    private int cli_id;
    private String securiteSociale;
    private String dateNaissance;
    private String mutuelle;
    private Medecins medecin;
    private Specialistes specialiste;

    private int medecin_id;
    private int specialiste_id;

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
        this.specialiste = specialiste;
    }

    public Clients() {
        super();
    }


    /**
     * Mise en place des getters/setters
     */

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getSecuriteSociale() {
        return securiteSociale;
    }

    public void setSecuriteSociale(String securiteSociale) {
        this.securiteSociale = securiteSociale;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
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

    public int getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }

    public int getSpecialiste_id() {
        return specialiste_id;
    }

    public void setSpecialiste_id(int specialiste_id) {
        this.specialiste_id = specialiste_id;
    }
}