package dao;

import classmetier.Clients;
import classmetier.Medecins;
import classmetier.Personnes;
import classmetier.Specialistes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.ParseException;
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
        System.out.println(insertPersonne);

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
    public boolean update(Personnes obj) throws SQLException {
        StringBuilder sqlUpdatePersonne = new StringBuilder();
        sqlUpdatePersonne.append("UPDATE FROM personne ");
        sqlUpdatePersonne.append("(`per_nom`, `per_prenom`, `per_telephone`, `per_email`, `per_adr`," +
                "`per_codepostal`, `per_ville`)");
        sqlUpdatePersonne.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        sqlUpdatePersonne.append("WHERE per_id=?");
        PreparedStatement ps = connect.prepareStatement(sqlUpdatePersonne.toString());
        ps.setString(1, obj.getNom());
        ps.setString(2, obj.getPrenom());
        ps.setString(3, obj.getTelephone());
        ps.setString(4, obj.getEmail());
        ps.setString(5, obj.getAdresse());
        ps.setString(6, obj.getCodePostal());
        ps.setString(7, obj.getVille());
        ps.executeUpdate();
        return true;
    }

    @Override
    public Personnes find(Integer pID) throws SQLException {
        return null;
    }

    @Override
    public List<Personnes> findAll() {
        return null;
    }

    public void transactionCreate(Personnes obj) throws SQLException {
        ClientDAO clientDao = new ClientDAO();
        Clients clients = new Clients();
        Specialistes specialistes = new Specialistes();
        Medecins medecins = new Medecins();
        Savepoint save = null;
        try {
            connect.setAutoCommit(false);
            save = connect.setSavepoint("depart");
            // creation
            int pId = this.create(obj);
            obj.setPerId(pId);
            Boolean creerClient = clients instanceof Clients;
            Boolean creerMedecin = medecins instanceof Medecins;
            Boolean creerSpecialiste = specialistes instanceof Specialistes;
            clientDao.create((Clients) obj);
            connect.commit();
            connect.setAutoCommit(true);
        } catch (SQLException sqle) {
            connect.rollback(save);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void transactionUpdate(Personnes obj) throws SQLException {
        ClientDAO clientDAO = new ClientDAO();
        Savepoint save = null;
        try {
            connect.setAutoCommit(false);
            save = connect.setSavepoint("départ");
            clientDAO.update((Clients) obj);
            connect.commit();
            connect.setAutoCommit(true);
        } catch (SQLException sqle) {
            connect.rollback(save);
        }
    }
}
































