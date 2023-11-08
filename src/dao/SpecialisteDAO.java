package dao;

import classmetier.Specialistes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialisteDAO extends DAO<Specialistes> {


    List<Specialistes> specialistes = new ArrayList<>();
    public List<Specialistes> getSpecialistes() {
        return specialistes;
    }

    @Override
    public int create(Specialistes obj) {

        return 0;
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
    public Specialistes find(Integer sID) {
        StringBuilder sqlFindSpecialiste = new StringBuilder();
        sqlFindSpecialiste.append("SELECT * FROM personne p JOIN specialiste s ON p.per_id = s.per_id");
        sqlFindSpecialiste.append(" WHERE spe_id=?");
        Specialistes spe = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindSpecialiste.toString())) {
            preparedStatement.setInt(1, sID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spe = new Specialistes();
                spe.setSpeId(resultSet.getInt("spe_id"));
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return spe;
    }

        @Override
    public List<Specialistes> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN specialiste s ON p.per_id = s.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Specialistes spe = new Specialistes();
            spe.setSpeId(resultSet.getInt("spe_id"));
            spe.setNom(resultSet.getString("per_nom"));
            spe.setPrenom(resultSet.getString("per_prenom"));
            spe.setAdresse(resultSet.getString("per_adr"));
            spe.setCodePostal(resultSet.getString("per_codepostal"));
            spe.setVille(resultSet.getString("per_ville"));
            spe.setTelephone(resultSet.getString("per_telephone"));
            spe.setEmail(resultSet.getString("per_email"));
            spe.setSpecialite(resultSet.getString("spe_specialite"));
            specialistes.add(spe);
        }
        resultSet.close();
        return specialistes;
    }
}
