package dao;

import classmetier.Clients;
import classmetier.Medecins;
import classmetier.Specialistes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialisteDAO extends DAO<Specialistes> {


    List<Specialistes> specialistes = new ArrayList<>();
    public List<Specialistes> getSpecialistes() {
        return specialistes;
    }

    @Override
    public void create(Specialistes obj) {

    }

    @Override
    public boolean delete(Specialistes obj) {
        return false;
    }

    @Override
    public boolean update(Specialistes obj) {
        return false;
    }

    @Override
    public Specialistes find(Integer pID) {
        return null;
    }

    @Override
    public List<Specialistes> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN medecin m c ON p.per_id = m.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Specialistes spe = new Specialistes();
            spe.setNom(resultSet.getString("per_nom"));
            spe.setPrenom(resultSet.getString("per_prenom"));
            spe.setAdresse(resultSet.getString("per_adr"));
            spe.setCodePostal(resultSet.getString("per_codepostal"));
            spe.setVille(resultSet.getString("per_ville"));
            spe.setTelephone(resultSet.getString("per_telephone"));
            spe.setEmail(resultSet.getString("per_email"));
            spe.setSpecialite(resultSet.getString("spe_specialite"));
        }
        resultSet.close();
        return null;
    }
}
