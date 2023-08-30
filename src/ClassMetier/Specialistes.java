package ClassMetier;

import java.util.ArrayList;

public class Specialistes extends Personnes {

    private static final ArrayList<Specialistes> Specialiste = new ArrayList<Specialistes>();


    private String specialite;

    public static ArrayList<Specialistes> getSpecialiste() {
        return Specialiste;
    }

    public Specialistes(String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
                        String email, String specialite) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.getSpecialite();
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public static void ajoutSpecialiste() {

        Specialistes specialiste1 = new Specialistes("z", "zz", "321 rue z", 90000, "xyz",
                "9876543219", "z.zz@gmail.com", "Somnoliste");
        Specialistes specialiste2 = new Specialistes("y", "yy", "654 rue y", 80000,"uvw",
                "8765432198", "y.yy@gmail.com", "Ophtalmologiste");
        Specialistes specialiste3 = new Specialistes("x","xx", "987 rue x", 70000, "rst",
                "7654321987", "x.xx@gmail.com", "Podologiste");
        Specialiste.add(specialiste1);
        Specialiste.add(specialiste2);
        Specialiste.add(specialiste3);
    }


}
