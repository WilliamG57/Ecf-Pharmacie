package classmetier;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import utils.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoriqueTest {
    static Historiques historiques;
    @BeforeAll
    public static void before() throws MyException {
        historiques = new Historiques("Dupont", "08-03-2023", "Doliprane",
                "10", "10.00", "Dr. Dupont", "Dr. Martin", true);
    }

    @Test
    public void testConstructeur() throws MyException {
        assertEquals("Dupont", historiques.getNom());
        assertEquals("08-03-2023", historiques.getDate());
        assertEquals("Doliprane", historiques.getMedicament());
        assertEquals("10", historiques.getQuantite());
        assertEquals("10.00", historiques.getPrix());
        assertEquals("Dr. Dupont", historiques.getMedecin());
        assertEquals("Dr. Martin", historiques.getSpecialiste());
    }

    @Test
    public void setDateValide() throws MyException {
        assertEquals("08-03-2023", historiques.getDate());
    }

    @Test
    public void setMiseEnServiceInvalide() throws Exception {
        MyException message = assertThrows(
                MyException.class,
                () -> historiques.setDate("20/11/1988")
        );
        assertEquals("La date n'est pas au bon format", message.getMessage());
    }
}
