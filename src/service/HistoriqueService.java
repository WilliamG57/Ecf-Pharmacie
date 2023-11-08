package service;

import classmetier.Historiques;
import classmetier.LigneArticle;
import classmetier.Paniers;
import utils.DateManagment;
import utils.MyException;

import java.util.ArrayList;

public class HistoriqueService {

    /**
     * Declaration de la liste contenant les historiques
     */
    private static final ArrayList<Historiques> historique = new ArrayList<>();

    public static ArrayList<Historiques> getHistorique() {
        return historique;
    }

    public HistoriqueService() {
    }

    /**
     * Methode pour transferer le panier dans l'historique
     */
    public Historiques transfertPanierHistorique(Paniers p) {
        Historiques h = new Historiques();
        h.setNom(p.getNom());
        h.setMedecin(p.getMedecin());
        try {
            DateManagment.parse(p.getDate(), "La date n'est pas au bon format");
            h.setDate(p.getDate());
        } catch (MyException ex) {
            throw new RuntimeException(ex);
        }
        h.setSpecialiste(p.getSpecialiste());
        h.setOrdonnance(p.getOrdonnance());
        for (LigneArticle la : p.getLigneArticles()) {
            h.setMedicament(la.getMedicament());
            h.setPrix(la.getPrix());
            h.setQuantite(la.getQuantite());
        }
        return h;
    }

    public void ajoutHistorique(Historiques h) throws MyException {
        historique.add(h);
    }
}
