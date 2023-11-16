package service;

import classmetier.*;
import dao.CategorieMediDAO;
import dao.MedicamentDAO;

import java.util.List;

public class MedicamentService {

    private MedicamentDAO medicamentDAO = new MedicamentDAO();
    private CategorieMediDAO categorieMediDAO = new CategorieMediDAO();

    public List<Medicaments> findAll() {
        try {
            List<Medicaments> medicaments = medicamentDAO.findAll();
            for (Medicaments medi : medicaments) {
                CategorieMedi cm = categorieMediDAO.find(medi.getCategorie_id());
                if (cm != null) {
                    medi.setCategorieMedi(cm);
                }
            }
            return medicaments;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
