package ClassMetier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonneTest {
    @Test
    public void setCodePostalValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "99999", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        assertEquals("99999", clients.getCodePostal());
    }

    @Test
    public void setCodePostalInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "99999", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setCodePostal("1234")
        );
        assertEquals("Le code postal n'est pas valide.", message.getMessage());
    }

    @Test
    public void setVilleValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "99999", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        assertEquals("a", clients.getVille());
    }

    @Test
    public void setVilleNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", "99999", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        NullPointerException message = assertThrows(
                NullPointerException.class,
                ()  -> clients.setVille(null)
        );
        assertEquals("Merci de remplir une ville.", message.getMessage());
    }

    @Test
    public void setTelephoneValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        assertEquals("0123456789", clients.getTelephone());
    }

    @Test
    public void setTelephoneNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setTelephone(null)
        );
        assertEquals("Merci de mettre un numéro de téléphone", message.getMessage());
    }

    @Test
    public void setTelephoneInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setTelephone("9876543210")
        );
        assertEquals("Le numéro de téléphone est invalide", message.getMessage());
    }


    @Test
    public void setEmailValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        assertEquals("a.aa@gmail.com", clients.getEmail());
    }

    @Test
    public void setEmailNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setEmail(null)
        );
        assertEquals("Merci de mettre une adresse email", message.getMessage());
    }

    @Test
    public void setEmailInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", "a", "a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setEmail("a.aa@a.a")
        );
        assertEquals("L'adresse email est invalide", message.getMessage());
    }
}
