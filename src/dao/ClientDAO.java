package dao;

import classmetier.Clients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        return false;
    }

    @Override
    public boolean update(Clients obj) {
        return false;
    }

    @Override
    public Clients find(Integer pID) {
        return null;
    }

    @Override
    public List<Clients> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Clients cl = new Clients();
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
