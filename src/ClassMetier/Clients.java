package ClassMetier;

import Utilitaire.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Clients extends Personnes {
    /**
     * Declaration de la liste contenant les clients
     */
    //private static final ArrayList<Clients> Client = new ArrayList<Clients>();

    //public static ArrayList<Clients> getClient() {

     //   return Client;
   // }
            private int id;
    private String securiteSociale;
    private String dateNaissance;
    private String mutuelle;
    private Medecins medecin;
    private String specialiste;
    //private static final Pattern PATTERN = Pattern.compile("^[0-9]{13}$");

    /**
     * Constructeur client
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
                   String email, String securiteSociale, String dateNaissance, String mutuelle, Medecins medecin, String specialiste) throws Exception {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setSecuriteSociale(securiteSociale);
        this.setDateNaissance(dateNaissance);
        this.setMutuelle(mutuelle);
        this.setMedecin(medecin);
        this.setSpecialiste(specialiste);
    }
    /**
     * Mise en place des getters/setters
     */
    public String getSecuriteSociale() {
        return securiteSociale;
    }

    public void setSecuriteSociale(String securiteSociale) throws MyException {
        try {
            // test valeur null
            if (securiteSociale == null) {
                throw new NullPointerException("Merci de mettre un numéro de sécurité sociale");
            }
            // test longueur
            if (securiteSociale.length() != 15) {
                throw new IllegalArgumentException("Le numéro de sécurité sociale doit contenir 15 chiffres");
            }

            for (int i = 0; i < securiteSociale.length(); i++) {
                if (securiteSociale.charAt(i) < '0' || securiteSociale.charAt(i) > '9') {
                    throw new IllegalArgumentException("Le numéro de sécurité sociale doit être composé uniquement de chiffres.");
                }
            }
            this.securiteSociale = securiteSociale;
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de mettre un numéro de sécurité sociale");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le numéro de sécurité sociale est invalide");
        }
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws MyException {
        try {
            if (dateNaissance == null) {
                throw new NullPointerException("Merci de mettre une date de naissance");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(dateNaissance);
            this.dateNaissance = dateNaissance;
        } catch (ParseException pe) {
            throw new MyException("La date de naissance n'est pas au bon format");
        }
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

    public String getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }



//    public static void ajoutClient(Clients obj) {
//        Client.add(obj);
//    }
}
