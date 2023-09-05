package ClassMetier;

import Utilitaire.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicamentTest {
    @Test
    public void testConstructeur() {
        Medicaments medicaments = new Medicaments("Doliprane", "Anti-douleur", "10.00", "2023-03-08", "10");

        assertEquals("Doliprane", medicaments.getNom());
        assertEquals("Anti-douleur", medicaments.getCategorie());
        assertEquals("10.00", medicaments.getPrix());
        assertEquals("2023-03-08", medicaments.getMiseEnService());
        assertEquals("10", medicaments.getQuantite());
    }

    @Test
    public void setMiseEnServiceValide() throws MyException {
        Medicaments medicaments = new Medicaments("h", "h", "40", "20-11-1988", "4");
        assertEquals("20-11-1988", medicaments.getMiseEnService());
    }

    @Test
    public void setMiseEnServiceInvalide() throws Exception {
        Medicaments medicaments = new Medicaments("h", "h", "40", "20-11-1988", "4");
        MyException message = assertThrows(
                MyException.class,
                () -> medicaments.setMiseEnService("20/11/1988")
        );
        assertEquals("La date de mise en service n'est pas au bon format", message.getMessage());
    }
}
