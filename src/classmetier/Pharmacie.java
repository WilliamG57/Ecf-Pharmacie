package classmetier;

import utils.MyException;
import java.util.ArrayList;

public class Pharmacie {
    public Pharmacie() throws Exception {
        //initialisationListe();
    }

    /// LISTES
    //private final ArrayList<Clients> client = new ArrayList<Clients>();
    //private final ArrayList<Medecins> medecin = new ArrayList<Medecins>();
    //private final ArrayList<Specialistes> specialiste = new ArrayList<Specialistes>();
    //private final ArrayList<Medicaments> medicament = new ArrayList<>();
    private final ArrayList<Mutuelle> mutuelle = new ArrayList<>();

    //public ArrayList<Clients> getClient() {
   //     return client;
    //}

//    public ArrayList<Medecins> getMedecin() {
//        return medecin;
//    }

//    public ArrayList<Specialistes> getSpecialiste() {
//        return specialiste;
//    }

//    public ArrayList<Medicaments> getMedicament() {
//        return medicament;
//    }

//    public void ajoutMedicament(Medicaments medicaments) throws MyException {
//        medicament.add(medicaments);
//    }

//    public void ajoutMedecin(Medecins medecins) throws MyException {
//        medecin.add(medecins);
//    }

//    public void ajoutSpecialiste(Specialistes specialistes) throws MyException {
//        specialiste.add(specialistes);
//    }

//    public void ajoutClient(Clients patient) throws MyException {
//        client.add(patient);
//    }
//    public Adresse getAdresseById(int id) {
//        return this.adresse.get(id);
//    }

    public Mutuelle getMutuelleByName(String name) {
        for (Mutuelle value : this.mutuelle) {
            if (value.getNom().equals(name)) {
                return value;
            }
        }
        return null;
    }
//    public Medecins getMedecinByName(String name) {
//        for (Medecins value : this.medecin) {
//            if (value.getNom().equals(name)) {
//                return value;
//            }
//        }
//        return null;
//    }

//    public Specialistes getSpecialisteByName(String name) {
//        for (Specialistes value : this.specialiste) {
//            if (value.getNom().equals(name)) {
//                return value;
//            }
//        }
//        return null;
//    }

//    public void initialisationListe() throws Exception {

        /**
         * Creation du jeu de test de medicaments
         */
//        ajoutMedicament(new Medicaments("Doliprane", "Anti-douleur", 4.50, "Mars 1964", "14"));
//        ajoutMedicament(new Medicaments("Millepertuis", "Somnifère", 7.90, "Juin 1985", "8"));
//        ajoutMedicament(new Medicaments("Collyre", "Goutte", 3.39, "Mars 1954", "31"));
//        ajoutMedicament(new Medicaments("Sildenafil", "Viagra", 9.99, "Avril 1998", "18"));

        /**
         * Creation du jeu de test de medecins
         */
//        ajoutMedecin(new Medecins("aaa", "aa", "123 rue a", "10000", "abc",
//                "4567891234", "aa.a@gmail.com", 458));
//        ajoutMedecin(new Medecins("bbb", "bb", "456 rue b", "20000", "efg",
//                "5678912345", "b.bb@gmail.com", 126));
//        ajoutMedecin(new Medecins("ccc", "cc", "789 rue c", "30000", "hij",
//                "6789123456", "c.cc@gmail.com", 824));

        /**
         * Ceation du jeu de test de specialistes
         */
//        ajoutSpecialiste(new Specialistes("zzz", "zz", "321 rue z", "90000", "xyz",
//                "9876543219", "z.zz@gmail.com", "Somnoliste"));
//        ajoutSpecialiste(new Specialistes("yyy", "yy", "654 rue y", "80000", "uvw",
//                "8765432198", "y.yy@gmail.com", "Ophtalmologiste"));
//        ajoutSpecialiste(new Specialistes("xxx", "xx", "987 rue x", "70000", "rst",
//                "7654321987", "x.xx@gmail.com", "Urologiste"));

        /**
         * Creation du jeu de test de clients
         */
//        ajoutClient(new Clients("Dupont", "Jean", "123 rue de la République", "75001", "Paris",
//                "0612345678", "dupont.jean@gmail.com", "123456789123456", "01-08-1988", getMutuelleByName("CCMO"),
//                getMedecinByName("aaa"), getSpecialisteByName("zzz")));
//        ajoutClient(new Clients("Martin", "Marie", "456 avenue de la Gare", "92100", "Boulogne",
//                "0789654321", "Martin.Marie@gmail.com", "234567891234567", "01-03-2000", getMutuelleByName("Mutami"),
//                getMedecinByName("bbb"), getSpecialisteByName("yyy")));
//        ajoutClient(new Clients("Durand", "Paul", "789 rue de la Liberté", "69002", "Lyon",
//                "0476543210", "durand.paul@gmail.com", "345678912345678", "01-02-1958", getMutuelleByName("GFP"),
//                getMedecinByName("aaa"), getSpecialisteByName("xxx")));
//    }
}
