package dao;

import classmetier.Personnes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonneDAO extends DAO<Personnes> {

    @Override
    public void create(Personnes obj) {
        StringBuilder insertPersonne = new StringBuilder();
        insertPersonne.append("insert into personne");

        insertPersonne.append("(per_nom, per_prenom, per_telephone, per_email, per_adr," +
                                 " per_codepostal, per_ville)");

        insertPersonne.append("values(?, ?, ?, ?, ?, ?, ?");

        try (PreparedStatement preparedStatement =
                     this.connect.prepareStatement(insertPersonne.toString(), Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setString(3,obj.getTelephone());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setString(5,obj.getAdresse());
            preparedStatement.setString(6, obj.getCodePostal());
            preparedStatement.setString(7,obj.getVille());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("RelationWithDB erreur : " + e.getMessage()
                                + "[SQL error code : " + e.getSQLState() + "]");
        }
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
    public Personnes find(Integer pID) {
        return null;
    }

    @Override
    public List<Personnes> findAll() {
        return null;
    }
}
