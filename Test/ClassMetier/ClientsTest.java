package ClassMetier;


import Utilitaire.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientsTest {

    @Test
    public void testConstructeur() throws Exception {
        Clients clients = new Clients("Dupont", "Jean", "12 rue de la Paix",
                "75008", "Paris", "06 12 34 56 78",
                "jean.dupont@gmail.com", "123456789123456",
                "04-09-1980", "Mutuelle 123", "Dr. Dupont", "Dr. Martin");

        assertEquals("Dupont", clients.getNom());
        assertEquals("Jean", clients.getPrenom());
        assertEquals("12 rue de la Paix", clients.getAdresse());
        assertEquals("75008", clients.getCodePostal());
        assertEquals("Paris", clients.getVille());
        assertEquals("06 12 34 56 78", clients.getTelephone());
        assertEquals("jean.dupont@gmail.com", clients.getEmail());
        assertEquals("123456789123456", clients.getSecuriteSociale());
        assertEquals("04-09-1980", clients.getDateNaissance());
        assertEquals("Mutuelle 123", clients.getMutuelle());
        assertEquals("Dr. Dupont", clients.getMedecin());
        assertEquals("Dr. Martin", clients.getSpecialiste());
    }

    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testSetDateNaissanceValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a",
                "a", "a", "111111111111111", "04-09-2023", "er", "a", "a");
        assertEquals("04-09-2023", clients.getDateNaissance());
    }

    @Test
    public void testSetDateNaissanceNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a",
                "a", "a", "111111111111111", "17-12-1974", "er", "a", "a");
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setDateNaissance(null)
        );
        assertEquals("Merci de mettre une date de naissance", message.getMessage());
    }

    @Test
    public void testSetDateNaissanceInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a",
                "a", "a", "111111111111111", "04-09-2020", "er", "a", "a");
        MyException message = assertThrows(
                MyException.class,
                () -> clients.setDateNaissance("04/09/2023")
        );
        assertEquals("La date de naissance n'est pas au bon format", message.getMessage());
    }

    @Test
    public void testSecuriteSocialValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a",
                "a", "111111111111111", "04-09-2020", "er", "a", "a");
        assertEquals("111111111111111", clients.getSecuriteSociale());
    }

    @Test
    public void testSecuriteSocialeNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a",
                "111111111111111", "04-09-2020", "er", "a", "a");
        NullPointerException message = assertThrows(
                NullPointerException.class,
                () -> clients.setSecuriteSociale(null)
        );
        assertEquals("Merci de mettre un numéro de sécurité sociale", message.getMessage());
    }

    @Test
    public void testSecuriteSocialInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a",
                "111111111111111", "04-09-2020", "er", "a", "a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () ->clients.setSecuriteSociale("11111111111111")
        );
        assertEquals("Le numéro de sécurité sociale est invalide", message.getMessage());
    }

    @Test
    public void testSecuriteSocialInvalideNumber() throws Exception {
        Clients clients = new Clients("a", "a", "a", "9", "a", "a", "a",
                "111111111111111", "04-09-2020", "er", "a", "a");
        IllegalArgumentException message = assertThrows(
                IllegalArgumentException.class,
                () ->clients.setSecuriteSociale("1111111111111aa")
        );
        assertEquals("Le numéro de sécurité sociale est invalide", message.getMessage());
    }
}
