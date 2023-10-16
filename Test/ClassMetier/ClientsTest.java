package ClassMetier;


import org.junit.jupiter.api.BeforeAll;
import service.ClientService;
import utils.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientsTest {
    static Pharmacie p;
    static Clients clients;
    ClientService clientService = new ClientService();

    public ClientsTest() throws Exception {
    }

    @BeforeAll
    public static void before() throws MyException, Exception {
        p = new Pharmacie();
        clients = new Clients("a", "a", "a", "9", "a", "a", "a",
                "111111111111111", "04-09-2020", "er", p.getMedecinByName("a"), p.getSpecialisteByName("a"));

    }

    @Test
    public void testConstructeur() throws Exception {
        Medecins medecin = p.getMedecinByName("aaa");
        Specialistes specialiste = p.getSpecialisteByName("zzz");
        Clients clients = new Clients("Dupont", "Jean", "12 rue de la Paix",
                "75008", "Paris", "06 12 34 56 78",
                "jean.dupont@gmail.com", "123456789123456",
                "04-09-1980", "Mutuelle 123", medecin, specialiste);

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
        assertEquals("aaa", clients.getMedecin().getNom());
        assertEquals("zzz", clients.getSpecialiste().getNom());
    }

    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testSetDateNaissanceValide() throws Exception {
        clients.setDateNaissance("04-09-2023");
        clients.setSecuriteSociale("123456789123456");
        assertEquals("04-09-2023", clients.getDateNaissance());
    }

    @Test
    public void testSetDateNaissanceNull() throws Exception {
        clients.setDateNaissance(null);
        clients.setSecuriteSociale("123456789123456");
        MyException message = assertThrows(
                MyException.class,
                () -> clientService.ajouterClient(clients)
        );
        assertEquals("Merci de mettre une date de naissance", message.getMessage());
    }

    @Test
    public void testSetDateNaissanceInvalide() throws Exception {
        clients.setDateNaissance("04/09/2023");
        clients.setSecuriteSociale("123456789123456");
        MyException message = assertThrows(
                MyException.class,
                () -> clientService.ajouterClient(clients)
        );
        assertEquals("La date de naissance n'est pas au bon format", message.getMessage());
    }

    @Test
    public void testSecuriteSocialValide() throws Exception {
        clients.setDateNaissance("04-09-2023");
        clients.setSecuriteSociale("111111111111111");
        assertEquals("111111111111111", clients.getSecuriteSociale());
    }

    @Test
    public void testSecuriteSocialeNull() throws Exception {
        clients.setDateNaissance("04-09-2023");
        clients.setSecuriteSociale(null);
        MyException message = assertThrows(
                MyException.class,
                () -> clientService.ajouterClient(clients)
        );
        assertEquals("Merci de mettre un numéro de sécurité sociale", message.getMessage());
    }

    @Test
    public void testSecuriteSocialInvalide() throws Exception {
        clients.setDateNaissance("04-09-2023");
        clients.setSecuriteSociale("11111111111111");
        MyException message = assertThrows(
                MyException.class,
                () -> clientService.ajouterClient(clients)
        );
        assertEquals("Le numéro de sécurité sociale doit contenir 15 chiffres", message.getMessage());
    }

    @Test
    public void testSecuriteSocialInvalideNumber() throws Exception {
        clients.setDateNaissance("04-09-2023");
        clients.setSecuriteSociale("1111111111111aa");
        MyException message = assertThrows(
                MyException.class,
                () -> clientService.ajouterClient(clients)
        );
        assertEquals("Le numéro de sécurité sociale doit être composé uniquement de chiffres.", message.getMessage());
    }
}
