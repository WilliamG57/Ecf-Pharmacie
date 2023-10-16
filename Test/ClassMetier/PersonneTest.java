package ClassMetier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.MyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonneTest {
    static Pharmacie p;
    static Clients clients;
    public PersonneTest() throws Exception {
    }

    @BeforeAll
    public static void before() throws Exception {
        p = new Pharmacie();
        clients = new Clients("a", "a", "a", "99999", "a", "0123456789", "a.aa@gmail.com",
                "111111111111111", "04-09-2020", "er", p.getMedecinByName("a"), p.getSpecialisteByName("a"));

    }

    @Test
    public void setCodePostalValide() throws Exception {
       assertEquals("99999", clients.getCodePostal());
    }

    @Test
    public void setCodePostalInvalide() throws Exception {
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setCodePostal("1234")
        );
        assertEquals("Le code postal n'est pas valide.", message.getMessage());
    }

    @Test
    public void setVilleValide() throws Exception {
       assertEquals("a", clients.getVille());
    }

    @Test
    public void setVilleNull() throws Exception {
        NullPointerException message = assertThrows(
                NullPointerException.class,
                ()  -> clients.setVille(null)
        );
        assertEquals("Merci de remplir une ville.", message.getMessage());
    }

    @Test
    public void setTelephoneValide() throws Exception {
        assertEquals("0123456789", clients.getTelephone());
    }

    @Test
    public void setTelephoneNull() throws Exception {
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setTelephone(null)
        );
        assertEquals("Merci de mettre un numéro de téléphone", message.getMessage());
    }

    @Test
    public void setTelephoneInvalide() throws Exception {
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setTelephone("9876543210")
        );
        assertEquals("Le numéro de téléphone est invalide", message.getMessage());
    }


    @Test
    public void setEmailValide() throws Exception {
        assertEquals("a.aa@gmail.com", clients.getEmail());
    }

    @Test
    public void setEmailNull() throws Exception {
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setEmail(null)
        );
        assertEquals("Merci de mettre une adresse email", message.getMessage());
    }

    @Test
    public void setEmailInvalide() throws Exception {
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> clients.setEmail("a.aa@a.a")
        );
        assertEquals("L'adresse email est invalide", message.getMessage());
    }
}
