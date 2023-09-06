package ClassMetier;

import Utilitaire.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoriqueTest {

    @Test
    public void testConstructeur() throws MyException {
        Historiques historiques = new Historiques("Dupont", "08-03-2023", "Doliprane",
                "10", "10.00", "Dr. Dupont", "Dr. Martin", true);
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
        Historiques historiques = new Historiques("Dupont", "08-03-2023", "Doliprane",
                "10", "10.00", "Dr. Dupont", "Dr. Martin", true);
        assertEquals("08-03-2023", historiques.getDate());
    }

    @Test
    public void setMiseEnServiceInvalide() throws Exception {
        Historiques historiques = new Historiques("Dupont", "08-03-2023", "Doliprane",
                "10", "10.00", "Dr. Dupont", "Dr. Martin", true);
        MyException message = assertThrows(
                MyException.class,
                () -> historiques.setDate("20/11/1988")
        );
        assertEquals("La date n'est pas au bon format", message.getMessage());
    }
}
