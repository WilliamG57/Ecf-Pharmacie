package dao;

import classmetier.Clients;
import classmetier.Personnes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO extends DAO<Personnes> {

    List<Personnes> personnes = new ArrayList<>();

    public List<Personnes> getPersonnes() {
        return personnes;
    }

    @Override
    public int create(Personnes obj) {
        StringBuilder insertPersonne = new StringBuilder();
        insertPersonne.append("insert into personne");
        insertPersonne.append("(`per_nom`, `per_prenom`, `per_telephone`, `per_email`, `per_adr`," +
                " `per_codepostal`, `per_ville`)");
        insertPersonne.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        System.out.println(insertPersonne.toString());

        int newId = 0;
        try (PreparedStatement ps = this.connect.prepareStatement(insertPersonne.toString(),
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getPrenom());
            ps.setString(3, obj.getTelephone());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getAdresse());
            ps.setString(6, obj.getCodePostal());
            ps.setString(7, obj.getVille());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                newId = rs.getInt(1);
                System.out.println(newId);
            }
        } catch (SQLException e) {
            System.out.println("RelationWithDB erreur : " + e.getMessage()
                    + "[SQL error code : " + e.getSQLState() + "]");
        }
        return newId;
    }

    @Override
    public boolean delete(Personnes obj) {
        StringBuilder sqlDeletePersonne = new StringBuilder();
        sqlDeletePersonne.append("DELETE FROM personne ");
        sqlDeletePersonne.append("WHERE per_id=?");
        boolean requeteOk;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlDeletePersonne.toString())) {
            preparedStatement.setInt(1, obj.getPerId());
            requeteOk = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requeteOk;
    }

    @Override
    public boolean update(Personnes obj) {
        StringBuilder sqlUpdatePersonne = new StringBuilder();
        sqlUpdatePersonne.append("UPDATE FROM personne ");
        sqlUpdatePersonne.append("WHERE per_id=?");
        boolean requeteOk;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlUpdatePersonne.toString())) {
            preparedStatement.setInt(1, obj.getPerId());
            requeteOk = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requeteOk;
    }

    @Override
    public Personnes find(Integer pID) throws SQLException {
//        StringBuilder sqlFindPersonne = new StringBuilder();
//        sqlFindPersonne.append("SELECT * FROM personne");
//        sqlFindPersonne.append("WHERE id=?");
//        Personnes per = null;
//        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindPersonne.toString())) {
//            preparedStatement.setInt(1, pID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                per = new Personnes();
//                        per.setPer_id(resultSet.getInt("per_id")),
//                        resultSet.getString("per_nom"),
//                        resultSet.getString("per_prenom"),
//                        resultSet.getString("per_adr"),
//                        resultSet.getString("per_codepostal"),
//                        resultSet.getString("per_ville"),
//                        resultSet.getString("per_telephone"),
//                        resultSet.getString("per_email")
//                );
//            }
//        }
        return null;
    }

    @Override
    public List<Personnes> findAll() {
        return null;
    }

    public void transactionCreate(Personnes obj) throws SQLException {
        ClientDAO clientDao = new ClientDAO();
        Savepoint save = null;
        try {
            connect.setAutoCommit(false);
            save = connect.setSavepoint("depart");
            // creation
            int pId = this.create(obj);
            obj.setPerId(pId);
            clientDao.create((Clients) obj);
            connect.commit();
            connect.setAutoCommit(true);
        } catch (SQLException sqle) {
            connect.rollback(save);
        }
    }
//    public void transactionModifier(Personnes obj) {
//        ClientDAO clientDAO = new ClientDAO();
//        Savepoint save = null;
//        try {
//            connect.setAutoCommit(false);
//            save = connect.setSavepoint("depart");
//            int pId = this.update(obj);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
































