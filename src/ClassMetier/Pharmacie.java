package ClassMetier;

import Utilitaire.MyException;

import java.util.ArrayList;

public class Pharmacie {
    public Pharmacie() throws Exception {
        initialisationListe();
    }


    /// LISTES
    private final ArrayList<Clients> client = new ArrayList<Clients>();
    private final ArrayList<Medecins> medecin = new ArrayList<Medecins>();
    private final ArrayList<Specialistes> specialiste = new ArrayList<Specialistes>();


    public ArrayList<Clients> getClient() {
        return client;
    }

    public ArrayList<Medecins> getMedecin() {
        return medecin;
    }

    public ArrayList<Specialistes> getSpecialiste() {
        return specialiste;
    }

    // CRUD


    // ajouter un client
    // 1 creer le patient
    // creer un objet patient à partir de la saisie
    // ajouter cet objet à la liste.

    /**
     * Creation du jeu de test client
     *
     * @throws Exception
     */
    public void ajoutClient(Clients patient) throws MyException {
        client.add(patient);
    }

    public void ajoutMedecin (Medecins medecins) throws MyException {
        medecin.add(medecins);
    }

    public void ajoutSpecialiste (Specialistes specialistes) throws MyException {
        specialiste.add(specialistes);
    }

//    public Medecins getMedecinByIndex(int index) {
//        return this.medecin.get(index);
//    }

    public Medecins getMedecinByName(String name) {
        for (Medecins value : this.medecin) {
            if (value.getNom().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public Specialistes getSpecialisteByName (String name) {
        for (Specialistes value : this.specialiste) {
            if (value.getNom().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public void initialisationListe() throws Exception {

        /**
         * Creation du jeu de test de medecins
         */
        ajoutMedecin(new Medecins("aaa", "aa", "123 rue a", "10000", "abc",
                "4567891234", "aa.a@gmail.com", 458));
        ajoutMedecin(new Medecins("bbb", "bb", "456 rue b", "20000", "efg",
                "5678912345", "b.bb@gmail.com", 126));
        ajoutMedecin(new Medecins("ccc", "cc", "789 rue c", "30000", "hij",
                "6789123456", "c.cc@gmail.com", 824));
        
        ajoutSpecialiste(new Specialistes("zzz", "zz", "321 rue z", "90000", "xyz",
                "9876543219", "z.zz@gmail.com", "Somnoliste"));
        ajoutSpecialiste(new Specialistes("yyy", "yy", "654 rue y", "80000", "uvw",
                "8765432198", "y.yy@gmail.com", "Ophtalmologiste"));
        ajoutSpecialiste(new Specialistes("xxx", "xx", "987 rue x", "70000", "rst",
                "7654321987", "x.xx@gmail.com", "Urologiste"));
        /**
         * Creation du jeu de test de clients
         */
        ajoutClient(new Clients("Dupont", "Jean", "123 rue de la République", "75001", "Paris",
                "0612345678", "dupont.jean@gmail.com", "123456789123456", "01-08-1988", "CCMO",
                getMedecinByName("aaa"), getSpecialisteByName("zzz")));
        ajoutClient(new Clients("Martin", "Marie", "456 avenue de la Gare", "92100", "Boulogne",
                "0789654321", "Martin.Marie@gmail.com", "234567891234567", "01-03-2000", "Mutami",
                getMedecinByName("bbb"), getSpecialisteByName("yyy")));
        ajoutClient(new Clients("Durand", "Paul", "789 rue de la Liberté", "69002", "Lyon",
                "0476543210", "durand.paul@gmail.com", "345678912345678", "01-02-1958", "GFP",
                getMedecinByName("aaa"), getSpecialisteByName("xxx")));




    }

}
