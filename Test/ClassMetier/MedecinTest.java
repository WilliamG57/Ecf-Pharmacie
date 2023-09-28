package ClassMetier;

import Utilitaire.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedecinTest {

    @Test
    public void testConstructeur() throws MyException {
        Medecins medecin = new Medecins("Dupont", "Jean", "12 rue de la Paix", "75008",
                "Paris", "06 12 34 56 78", "jean.dupont@gmail.com", 111);

        assertEquals("Dupont", medecin.getNom());
        assertEquals("Jean", medecin.getPrenom());
        assertEquals("12 rue de la Paix", medecin.getAdresse());
        assertEquals("75008", medecin.getCodePostal());
        assertEquals("Paris", medecin.getVille());
        assertEquals("06 12 34 56 78", medecin.getTelephone());
        assertEquals("jean.dupont@gmail.com", medecin.getEmail());
        assertEquals(111, medecin.getAgreement());
    }

    @Test
    public void setAgreementInvalide() throws IllegalArgumentException, MyException {
        Medecins medecins = new Medecins("a", "a", "a", "88888",
                                        "aaa", "0123456789",
                                        "a.aa@gmail.com", 222);
        MyException message = assertThrows(
                MyException.class,
                () -> medecins.setAgreement(2222)
        );
        assertEquals("Le numéro d'agréément n'est pas valide.", message.getMessage());
    }
}