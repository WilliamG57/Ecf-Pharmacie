package classmetier;

import utils.MyException;
import java.util.ArrayList;

public class Pharmacie {
    public Pharmacie() {
    }

    private final ArrayList<Mutuelle> mutuelle = new ArrayList<>();

    public Mutuelle getMutuelleByName(String name) {
        for (Mutuelle value : this.mutuelle) {
            if (value.getNom().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
