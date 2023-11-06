package dao;

import classmetier.Clients;
import classmetier.Medecins;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO extends DAO<Medecins> {

    List<Medecins> medecins = new ArrayList<>();

    public List<Medecins> getMedecins() {
        return medecins;
    }

    @Override
    public void create(Medecins obj) {

    }

    @Override
    public boolean delete(Medecins obj) {
        return false;
    }

    @Override
    public boolean update(Medecins obj) {
        return false;
    }

    @Override
    public Medecins find(Integer pID) {
        return null;
    }

    @Override
    public List<Medecins> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN medecin m c ON p.per_id = m.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Medecins med = new Medecins();
            med.setNom(resultSet.getString("per_nom"));
            med.setPrenom(resultSet.getString("per_prenom"));
            med.setAdresse(resultSet.getString("per_adr"));
            med.setCodePostal(resultSet.getString("per_codepostal"));
            med.setVille(resultSet.getString("per_ville"));
            med.setTelephone(resultSet.getString("per_telephone"));
            med.setEmail(resultSet.getString("per_email"));
            med.setAgreement(resultSet.getInt("med_agreement"));
        }
        resultSet.close();
        return medecins;
    }
}
