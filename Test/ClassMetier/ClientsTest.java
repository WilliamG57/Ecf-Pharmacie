package ClassMetier;

import ClassMetier.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientsTest {

    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testSetDateNaissanceValide() throws Exception {
        Clients clients = new Clients("a", "a", "a", 9, "a",
                "a", "a", 1, "04-09-2023", "er", "a", "a");
        assertEquals("04-09-2023", clients.getDateNaissance());
    }

    @Test
    public void testSetDateNaissanceNull() throws Exception {
        Clients clients = new Clients("a", "a", "a", 9, "a",
                "a", "a", 1, null, "er", "a", "a");
        assertThrows(NullPointerException.class, () -> clients.setDateNaissance(null));
    }

    @Test
    public void testSetDateNaissanceInvalide() throws Exception {
        Clients clients = new Clients("a", "a", "a", 9, "a",
                "a", "a", 1, "04/09/2023", "er", "a", "a");
        assertThrows(IllegalArgumentException.class, () -> clients.setDateNaissance("04/09/2023"));
    }

}
