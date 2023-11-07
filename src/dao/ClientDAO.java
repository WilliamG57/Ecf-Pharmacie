package dao;

import classmetier.Clients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Clients> {
    List<Clients> client = new ArrayList<>();

    public List<Clients> getClient() {
        return client;
    }

    @Override
    public void create(Clients obj) {

    }

    @Override
    public boolean delete(Clients obj) {
        StringBuilder sqlDeleteClient = new StringBuilder();
        sqlDeleteClient.append("DELETE FROM client ");
        sqlDeleteClient.append("WHERE cli_id=?");
        boolean requeteOk = false;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlDeleteClient.toString())) {
            preparedStatement.setInt(1, obj.getCli_id());
            requeteOk = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requeteOk;
    }

    @Override
    public boolean update(Clients obj) {
        return false;
    }

    @Override
    public Clients find(Integer cID) throws SQLException {
        StringBuilder sqlFindClient = new StringBuilder();
        sqlFindClient.append("SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id");
        sqlFindClient.append(" WHERE med_id=?");
        Clients cl = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindClient.toString())) {
            preparedStatement.setInt(1, cID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cl = new Clients();
                cl.setCli_id(resultSet.getInt("cli_id"));
                cl.setNom(resultSet.getString("per_nom"));
                cl.setPrenom(resultSet.getString("per_prenom"));
                cl.setAdresse(resultSet.getString("per_adr"));
                cl.setCodePostal(resultSet.getString("per_codepostal"));
                cl.setVille(resultSet.getString("per_ville"));
                cl.setTelephone(resultSet.getString("per_telephone"));
                cl.setEmail(resultSet.getString("per_email"));
                cl.setSecuriteSociale(resultSet.getString("cli_secu"));
                cl.setDateNaissance(resultSet.getString("cli_datenaissance"));
                //cl.setMutuelle(resultSet.getString("mutuelle"));
                cl.setMedecin_id(resultSet.getInt("med_id"));
                cl.setSpecialiste_id(resultSet.getInt("spe_id"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cl;
    }

    @Override
    public List<Clients> findAll() throws SQLException {
        String query = "SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Clients cl = null;
        while (resultSet.next()) {
            cl = new Clients();
            cl.setCli_id(resultSet.getInt("cli_id"));
            cl.setNom(resultSet.getString("per_nom"));
            cl.setPrenom(resultSet.getString("per_prenom"));
            cl.setAdresse(resultSet.getString("per_adr"));
            cl.setCodePostal(resultSet.getString("per_codepostal"));
            cl.setVille(resultSet.getString("per_ville"));
            cl.setTelephone(resultSet.getString("per_telephone"));
            cl.setEmail(resultSet.getString("per_email"));
            cl.setSecuriteSociale(resultSet.getString("cli_secu"));
            cl.setDateNaissance(resultSet.getString("cli_datenaissance"));
            //cl.setMutuelle(resultSet.getString("mutuelle"));
            cl.setMedecin_id(resultSet.getInt("med_id"));
            cl.setSpecialiste_id(resultSet.getInt("spe_id"));
            client.add(cl);
        }
        resultSet.close();
        return client;
    }
}

