package ClassMetier;

import java.util.ArrayList;

public class Pharmacie {


    /// LISTE
    private final ArrayList<Clients> client = new ArrayList<Clients>();
    private final ArrayList<Medecins> medecin = new ArrayList<Medecins>();

    public ArrayList<Clients> getClient() {
        return client;
    }
    public ArrayList<Medecins> getMedecin() {
        return medecin;
    }
    // recherche une medecin
    // recherche un patient

    // CRUD


    // ajouter un client
    // 1 creer le patient
        // creer un objet patient à partir de la saisie
        // ajouter cet objet à la liste.

    /**
     *Creation du jeu de test client
     * @throws Exception
     */
    public void ajoutClient(Clients patient) throws Exception {
        client.add(patient);
    }

    public Medecins getMedecinByIndex(int index) {
        return this.medecin.get(index);
    }

    public Medecins getMedecinByName(String name) {

        for(Medecins value : this.medecin) {
            if (value.getNom().equals(name)) {
                return value;
            }
        }
        return null;

    }

    public void initialisationListe() throws Exception {

        medecin.add(new Medecins("aaa", "aa", "123 rue a", "10000", "abc",
                "4567891234", "aa.a@gmail.com", 458));
        medecin.add(new Medecins("bbb", "bb", "456 rue b", "20000", "efg",
                "5678912345", "b.bb@gmail.com", 126));
        medecin.add(new Medecins("ccc", "cc", "789 rue c", "30000", "hij",
                "6789123456", "c.cc@gmail.com", 824));

        ajoutClient(new Clients("Dupont", "Jean", "123 rue de la République", "75001", "Paris",
                "0612345678", "dupont.jean@gmail.com", "123456789123456", "01-08-1988", "CCMO",
                getMedecinByName("aaa"), "zzz"));

        ajoutClient(new Clients("Martin", "Marie", "456 avenue de la Gare", "92100", "Boulogne",
                "0789654321", "Martin.Marie@gmail.com", "234567891234567", "01-03-2000", "Mutami",
                getMedecinByName("bbb"), "yyy"));
        ajoutClient(new Clients("Durand", "Paul", "789 rue de la Liberté", "69002", "Lyon",
                "0476543210", "durand.paul@gmail.com", "345678912345678", "01-02-1958", "GFP",
                getMedecinByName("aaa"), "xxx"));

    }

}
