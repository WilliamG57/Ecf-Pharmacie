package service;

import classmetier.Clients;
import classmetier.Medecins;
import classmetier.Mutuelle;
import classmetier.Specialistes;
import dao.ClientDAO;
import dao.MedecinDAO;
import dao.MutuelleDAO;
import dao.SpecialisteDAO;
import utils.DateManagment;
import utils.MyException;

import javax.swing.*;
import java.util.List;

public class ClientService extends PersonneService {
    ClientDAO clientDAO = new ClientDAO();
    MedecinDAO medecinDAO = new MedecinDAO();
    SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    MutuelleDAO mutuelleDAO = new MutuelleDAO();

    public ClientService() {
    }

    public void validate(Clients client) throws MyException {
        validateSecuriteSociale(client.getSecuriteSociale());
        validateDateNaissance(client.getDateNaissance());
        validateCodePostal(client.getCodePostal());
        validateVille(client.getVille());
        validateTelephone(client.getTelephone());
        validateEmail(client.getEmail());
    }

    private void validateDateNaissance(String dateNaissance) throws MyException {
        DateManagment.parse(dateNaissance, "La date de naissance n'est pas au bon format");
        JOptionPane.showMessageDialog(null, "La date de naissance n'est pas au bon format");
    }

    private void validateSecuriteSociale(String securiteSociale) throws MyException {
        try {
            // test longueur
            if (securiteSociale.length() != 15) {
                throw new MyException("Le numéro de sécurité sociale doit contenir 15 chiffres");
            }

            for (int i = 0; i < securiteSociale.length(); i++) {
                if (securiteSociale.charAt(i) < '0' || securiteSociale.charAt(i) > '9') {
                    throw new MyException("Le numéro de sécurité sociale doit être composé uniquement de chiffres.");
                }
            }
            // test valeur null
        } catch (NullPointerException e) {
            throw new MyException("Merci de mettre un numéro de sécurité sociale");
        }
    }

    public void ajouterClient(Clients client) throws MyException {
        validate(client);
    }

    public void supprimerClient(Clients client) {

    }

    public void modifierClient(Clients client) {

    }

    public List<Clients> findAll() {
        try {
            List<Clients> clients = clientDAO.findAll();
            for (Clients cl : clients) {
                Medecins m = medecinDAO.find(cl.getMedecin_id());
                if (m != null) {
                    cl.setMedecin(m);
                }
                Specialistes s = specialisteDAO.find(cl.getSpecialiste_id());
                if (s != null) {
                    cl.setSpecialiste(s);
                }
                Mutuelle mut = mutuelleDAO.find(cl.getMutuelle_id());
                if (mut != null) {
                    cl.setMutuelle(mut);
                }
            }
            return clients;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
