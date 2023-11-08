package dao;

import classmetier.Personnes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        insertPersonne.append("(per_id, per_nom, per_prenom, per_telephone, per_email, per_adr," +
                " per_codepostal, per_ville)");
        insertPersonne.append("values(?, ?, ?, ?, ?, ?, ?, ?");

        int newId = 0;
        try (PreparedStatement ps = this.connect.prepareStatement(insertPersonne.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            //ps.setInt(1, obj.getPerId());
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
                newId = rs.getInt("per_id");
            }
        } catch (SQLException e) {
            System.out.println("RelationWithDB erreur : " + e.getMessage()
                    + "[SQL error code : " + e.getSQLState() + "]");
        }
        return newId;
    }

    @Override
    public boolean delete(Personnes obj) {
        return false;
    }

    @Override
    public boolean update(Personnes obj) {
        return false;
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
}
