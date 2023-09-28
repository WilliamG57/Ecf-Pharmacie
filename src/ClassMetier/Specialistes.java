package ClassMetier;

import java.util.ArrayList;

public class Specialistes extends Personnes {

    private String specialite;

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
}
