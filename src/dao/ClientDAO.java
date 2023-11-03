package dao;

import classmetier.Clients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List findAll() throws SQLException {
        String query = "SELECT * FROM client";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            listeClient.add(resultSet.getClient());
        }
        resultSet.close();
        return client;
        //        List<Client> clients = new ArrayList<>();
//        List<Client> results = new ("SELECT * FROM client").list();
//        clients.addAll(results);
//        return findAll();

    }
}
