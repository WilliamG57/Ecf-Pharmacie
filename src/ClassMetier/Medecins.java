package ClassMetier;

import java.util.ArrayList;

public class Medecins extends Personnes {
    private static final ArrayList<Medecins> Medecin = new ArrayList<Medecins>();
    private int agreement;

    public static ArrayList<Medecins> getMedecins(){
        return Medecin;
    }

    public Medecins(String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
                    String email, int agreement) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setAgreement(agreement);
    }
    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    public static void ajoutMedecins () {

        Medecins medecin1 = new Medecins("a", "aa", "123 rue a", 10000, "abc",
                "4567891234", "aa.a@gmail.com", 458);
        Medecins medecin2 = new Medecins("b", "bb", "456 rue b", 20000, "efg",
                "5678912345", "b.bb@gmail.com", 126);
        Medecins medecin3 = new Medecins("c", "cc", "789 rue c", 30000, "hij",
                "6789123456", "c.cc@gmail.com", 824);
        Medecin.add(medecin1);
        Medecin.add(medecin2);
        Medecin.add(medecin3);
    }


}
