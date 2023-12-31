package dao;

import classmetier.Medecins;
import utils.DateManagment;
import utils.MyException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.log4j.builders.appender.SocketAppenderBuilder.LOGGER;

public class MedecinDAO extends DAO<Medecins> {

    List<Medecins> medecins = new ArrayList<>();

    public List<Medecins> getMedecins() {
        return medecins;
    }

    @Override
    public int create(Medecins obj) {

        StringBuilder insertMedecin = new StringBuilder();
        insertMedecin.append("insert into medecin ");
        insertMedecin.append("(`med_agreement`, `per_id`) ");
        insertMedecin.append("VALUES (?, ?)");

        int newId = 0;
        try (PreparedStatement ps = connect.prepareStatement(insertMedecin.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getAgreement());
            ps.setInt(2, obj.getPerId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.warn("RelationWithDB erreur : " + e.getMessage()
                    + "[SQL error code : " + e.getSQLState() + "]");
        }
        return newId;
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
    public Medecins find(Integer mID) throws SQLException {

        StringBuilder sqlFindMedecin = new StringBuilder();
        sqlFindMedecin.append("SELECT * FROM personne p JOIN medecin m ON p.per_id = m.per_id");
        sqlFindMedecin.append(" WHERE med_id=?");
        Medecins med = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindMedecin.toString())) {
            preparedStatement.setInt(1, mID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                med = new Medecins();
                med.setMedId(resultSet.getInt("med_id"));
                med.setNom(resultSet.getString("per_nom"));
                med.setPrenom(resultSet.getString("per_prenom"));
                med.setTelephone(resultSet.getString("per_telephone"));
                med.setEmail(resultSet.getString("per_email"));
                med.setAdresse(resultSet.getString("per_adr"));
                med.setCodePostal(resultSet.getString("per_codepostal"));
                med.setVille(resultSet.getString("per_ville"));
                med.setAgreement(resultSet.getInt("med_agreement"));
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return med;
    }

    @Override
    public List<Medecins> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN medecin m ON p.per_id = m.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Medecins med = new Medecins();
            med.setMedId(resultSet.getInt("med_id"));
            med.setNom(resultSet.getString("per_nom"));
            med.setPrenom(resultSet.getString("per_prenom"));
            med.setAdresse(resultSet.getString("per_adr"));
            med.setCodePostal(resultSet.getString("per_codepostal"));
            med.setVille(resultSet.getString("per_ville"));
            med.setTelephone(resultSet.getString("per_telephone"));
            med.setEmail(resultSet.getString("per_email"));
            med.setAgreement(resultSet.getInt("med_agreement"));
            medecins.add(med);
        }
        resultSet.close();
        return medecins;
    }
}
