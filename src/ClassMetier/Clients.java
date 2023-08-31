package ClassMetier;

import java.util.ArrayList;
import java.util.Collections;

public class Clients extends Personnes {

    private static final ArrayList<Clients> Client = new ArrayList<Clients>();

    public static ArrayList<Clients> getClient() {

        return Client;
    }

    private int securiteSociale;
    private String dateNaissance;
    private String mutuelle;
    private String medecin;



    private String specialiste;

//    public static ArrayList<Clients> getClients() {
//
//        return Client;
//    }




    public Clients(String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
                   String email, int securiteSociale, String dateNaissance, String mutuelle, String medecin,String specialiste) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setSecuriteSociale(securiteSociale);
        this.setDateNaissance(dateNaissance);
        this.setMutuelle(mutuelle);
        this.setMedecin(medecin);
        this.setSpecialiste(specialiste);
        //Client.sort(null);
    }

    public int getSecuriteSociale() {
        return securiteSociale;
    }

    public void setSecuriteSociale(int securiteSociale) {

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
    public String getMedecin() {

        return medecin;
    }

    public void setMedecin(String medecin) {

        this.medecin = medecin;
    }
    public String getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }


    public static void ajoutClient() {

        Client.add(new Clients("Dupont", "Jean", "123 rue de la République", 75001, "Paris",
                "0612345678", "dupont.jean@gmail.com", 123456789, "01-08-1988", "CCMO",
                "a", "z"));
        Client.add(new Clients("Martin", "Marie", "456 avenue de la Gare", 92100, "Boulogne",
                "0789654321", "Martin.Marie@gmail.com", 234567891, "01-03-2000", "Mutami",
                "b", "y"));
        Client.add(new Clients("Durand", "Paul", "789 rue de la Liberté", 69002, "Lyon",
                "0476543210", "durand.paul@gmail.com", 345678912, "01-02-1958", "GFP",
                "a", "x"));
    }

     public static void ajoutClient(Clients obj) {
        Client.add(obj);
     }
}
