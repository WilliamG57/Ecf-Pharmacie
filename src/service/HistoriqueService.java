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
    public Historiques transfertPanierHistorique (Paniers p) {
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
        } return h;
    }
    /**
     * Constructeur de base pour les achats sans ordonnance
     * @param nom nom du client
     * @param date date d'achat
     * @param medicament nom du medicament
     * @param quantite quantite de medicament
     * @param prix prix du medicament
     * @throws MyException
     */
    //public void ajoutHistorique(String nom, String date, String medicament, int quantite, String prix) throws MyException {
    //    historique.add(new Historiques(nom, date, medicament, quantite, prix));
   //}

    public void ajoutHistorique(Historiques h) throws MyException {
        historique.add(h);
    }

    /**
     * Constructeur surcharge pour les achats avec ordonnnance
     * @param nom nom du client
     * @param date date d'achat
     * @param medicament nom du medicament
     * @param quantite quantite de medicament
     * @param prix prix du medicament
     * @param medecin nom du medecin
     * @param specialiste nom du specialiste
     * @param Ordonnance boolean pour savoir si il y a une ordonnance ou non
     * @throws MyException
     */
//    public void ajoutHistorique(String nom, String date, String medicament, int quantite, String prix,
//                                       String medecin, String specialiste, Boolean Ordonnance) throws MyException {
//        historique.add(new Historiques(nom, date, medicament, quantite, prix, medecin, specialiste, Ordonnance));
//    }


}
