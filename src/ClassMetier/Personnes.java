package ClassMetier;

public abstract class Personnes {

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;

    public Personnes() {
    }

    public Personnes(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        try {
            if (codePostal == null) {
                throw new NullPointerException("Merci de remplir le code postal.");
            }
            if (!codePostal.matches("[0-9]{5}")) {
                throw new IllegalArgumentException("Le code postal n'est pas valide.");
            }
            this.codePostal = codePostal;
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de remplir le code postal.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le code postal n'est pas valide.");
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        try {
            if (telephone == null) {
                throw new NullPointerException("Merci de mettre un numéro de téléphone");
            }
            if (!telephone.matches("^(?:(?:\\+|00)33\\s?|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$")) {
                throw new IllegalArgumentException("Le numéro de téléphone est invalide");
            }
            this.telephone = telephone;
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de mettre un numéro de téléphone");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le numéro de téléphone est invalide");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            if (email == null) {
                throw new NullPointerException("Merci de mettre une adresse email");
            }
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("L'adresse email est invalide");
            }
            this.email = email;
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de mettre une adresse email");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("L'adresse email est invalide");
        }
    }
}
