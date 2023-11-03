package dao;

import classmetier.Clients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO {
    List<Clients> client = new ArrayList<>();

    public List<Clients> getClient() {
        return client;
    }


//    public static ResultSet addComboBox() throws SQLException {
//        String query = "SELECT * FROM client";
//        PreparedStatement statement = connect.prepareStatement(query);
//        ResultSet results = statement.executeQuery();
//        return results;
//    }

    @Override
    public void create(Object obj) {

    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public Object find(Integer pID) {
        return null;
    }

    @Override
    public List findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Clients cl = new Clients();
            cl.setNom(resultSet.getString("nom"));
            cl.setPrenom(resultSet.getString("prenom"));
            cl.setAdresse(resultSet.getString("adresse"));
            cl.setCodePostal(resultSet.getString("codePostal"));
            cl.setCodePostal(resultSet.getString("ville"));
            cl.setTelephone(resultSet.getString("telephone"));
            cl.setEmail(resultSet.getString("email"));
            cl.setSecuriteSociale(resultSet.getString("securiteSociale"));
            cl.setDateNaissance(resultSet.getString("dateNaissance"));
            cl.setMutuelle(resultSet.getString("mutuelle"));
            cl.setMedecin(resultSet.getObject("medecin");
            cl.setSpecialiste(resultSet.getObject("specialiste");
            client.add(cl);
        }
        resultSet.close();
        return client;
        //        List<Client> clients = new ArrayList<>();
//        List<Client> results = new ("SELECT * FROM client").list();
//        clients.addAll(results);
//        return findAll();

    }
}
