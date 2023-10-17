package classmetier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.PersonneService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonneTest {
    static Pharmacie p;
    static Clients clients;

    PersonneService personneService = new PersonneService();

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
        clients.setCodePostal("1234");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> personneService.validate(clients)
        );
        assertEquals("Le code postal n'est pas valide.", message.getMessage());
    }

    @Test
    public void setVilleValide() throws Exception {
        assertEquals("a", clients.getVille());
    }

    @Test
    public void setVilleNull() throws Exception {
        clients.setVille(null);
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> personneService.validate(clients)
        );
        //reset
        clients.setVille("a");
        assertEquals("Merci de remplir une ville.", message.getMessage());
    }

    @Test
    public void setTelephoneValide() throws Exception {
        assertEquals("0123456789", clients.getTelephone());
    }

    @Test
    public void setTelephoneNull() throws Exception {
        clients.setTelephone(null);
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> personneService.validate(clients)
        );
        //reset
        clients.setTelephone("1122334455");
        assertEquals("Merci de mettre un numéro de téléphone", message.getMessage());
    }

    @Test
    public void setTelephoneInvalide() throws Exception {
        clients.setTelephone("9876543210");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> personneService.validate(clients)
        );
        //reset
        clients.setTelephone("1122334455");
        assertEquals("Le numéro de téléphone est invalide", message.getMessage());
    }


    @Test
    public void setEmailValide() throws Exception {
        assertEquals("a.aa@gmail.com", clients.getEmail());
    }

    @Test
    public void setEmailNull() throws Exception {
        clients.setEmail(null);
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> personneService.validate(clients)
        );
        //reset
        clients.setEmail("a.aa@gmail.com");
        assertEquals("Merci de mettre une adresse email", message.getMessage());
    }

    @Test
    public void setEmailInvalide() throws Exception {
        clients.setEmail("a.aa@a.a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () -> personneService.validate(clients)
        );
        //reset
        clients.setEmail("a.aa@gmail.com");
        assertEquals("L'adresse email est invalide", message.getMessage());
    }
}