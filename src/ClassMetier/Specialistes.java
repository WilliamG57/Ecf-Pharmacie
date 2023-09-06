package ClassMetier;

import java.util.ArrayList;

public class Specialistes extends Personnes {

    /**
     * Declaration de la liste contenant les specialitses
     */
    private static final ArrayList<Specialistes> Specialiste = new ArrayList<Specialistes>();
    private String specialite;

    public static ArrayList<Specialistes> getSpecialiste() {
        return Specialiste;
    }

    public Specialistes(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
                        String email, String specialite) {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setSpecialite(specialite);
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Creation du jeu de test specialiste
     */
    public static void ajoutSpecialiste() {
        Specialiste.add(new Specialistes("zzz", "zz", "321 rue z", "90000", "xyz",
                "9876543219", "z.zz@gmail.com", "Somnoliste"));
        Specialiste.add(new Specialistes("yyy", "yy", "654 rue y", "80000", "uvw",
                "8765432198", "y.yy@gmail.com", "Ophtalmologiste"));
        Specialiste.add(new Specialistes("xxx", "xx", "987 rue x", "70000", "rst",
                "7654321987", "x.xx@gmail.com", "Urologiste"));
    }
}
