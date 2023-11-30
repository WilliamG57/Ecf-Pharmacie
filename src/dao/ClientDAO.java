package dao;

import classmetier.Clients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DateManagment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Clients> {
    List<Clients> client = new ArrayList<>();
    public List<Clients> getClient() {
        return client;
    }

    private static final Logger LOGGER = LogManager.getLogger();


    /**
     * Methode de creation de Client
     *
     * @param obj
     * @return
     * @throws ParseException
     */
    @Override
    public int create(Clients obj) throws ParseException {

        StringBuilder insertClient = new StringBuilder();
        insertClient.append("insert into client ");
        insertClient.append("(`cli_secu`, `cli_datenaissance`, `per_id`, `spe_id`, `med_id`, `mut_id`) ");
        insertClient.append("VALUES (?, ?, ?, ?, ?, ?)");

        int newId = 0;
        try (PreparedStatement ps = connect.prepareStatement(insertClient.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getSecuriteSociale());
            ps.setDate(2, DateManagment.convertString(obj.getDateNaissance()));
            ps.setInt(3, obj.getPerId());
            ps.setInt(4, obj.getSpecialiste_id());
            ps.setInt(5, obj.getMedecin_id());
            ps.setInt(6, obj.getMutuelle_id());
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

    /**
     * Methode de suppression de Client
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Clients obj) {
        StringBuilder sqlDeleteClient = new StringBuilder();
        sqlDeleteClient.append("DELETE FROM client ");
        sqlDeleteClient.append("WHERE per_id=?");
        boolean requeteOk;
        try (PreparedStatement ps = connect.prepareStatement(sqlDeleteClient.toString())) {
            ps.setInt(1, obj.getCliId());
            requeteOk = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requeteOk;
    }

    /**
     * Methode de mise à jours de Client
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Clients obj) throws SQLException {
        StringBuilder sqlUpdateClient = new StringBuilder();
        sqlUpdateClient.append("UPDATE client ");
        sqlUpdateClient.append("SET `cli_secu` = ?, `cli_datenaissance` = ?, `per_id` = ?, ");
        sqlUpdateClient.append("`spe_id` = ?, `med_id` = ?, `mut_id` = ? ");
        sqlUpdateClient.append("WHERE cli_id = ?");
        PreparedStatement ps = connect.prepareStatement(sqlUpdateClient.toString());
        ps.setString(1, obj.getSecuriteSociale());
        ps.setDate(2, DateManagment.convertString(obj.getDateNaissance()));
        ps.setInt(3, obj.getPerId());
        ps.setInt(4, obj.getSpecialiste_id());
        ps.setInt(5, obj.getMedecin_id());
        ps.setInt(6, obj.getMutuelle_id());
        ps.setInt(7, obj.getCliId());
        ps.executeUpdate();
        return true;
    }

    /**
     * Methode de recherche par id de Client
     *
     * @param cID
     * @return
     * @throws SQLException
     */
    @Override
    public Clients find(Integer cID) throws SQLException {
        StringBuilder sqlFindClient = new StringBuilder();
        sqlFindClient.append("SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id");
        sqlFindClient.append(" WHERE cli_id = ?");
        Clients cl = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindClient.toString())) {
            preparedStatement.setInt(1, cID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cl = new Clients();
                cl.setCliId(resultSet.getInt("cli_id"));
                cl.setNom(resultSet.getString("per_nom"));
                cl.setPrenom(resultSet.getString("per_prenom"));
                cl.setAdresse(resultSet.getString("per_adr"));
                cl.setCodePostal(resultSet.getString("per_codepostal"));
                cl.setVille(resultSet.getString("per_ville"));
                cl.setTelephone(resultSet.getString("per_telephone"));
                cl.setEmail(resultSet.getString("per_email"));
                cl.setSecuriteSociale(resultSet.getString("cli_secu"));
                cl.setDateNaissance(resultSet.getString("cli_datenaissance"));
                cl.setMutuelle_id(resultSet.getInt("mut_id"));
                cl.setMedecin_id(resultSet.getInt("med_id"));
                cl.setSpecialiste_id(resultSet.getInt("spe_id"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cl;
    }

    /**
     * Methode pour trouver tout les Client
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Clients> findAll() throws SQLException {
        String query = "SELECT * FROM personne p JOIN client c ON p.per_id = c.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Clients cl;
        while (resultSet.next()) {
            cl = new Clients();
            cl.setCliId(resultSet.getInt("cli_id"));
            cl.setNom(resultSet.getString("per_nom"));
            cl.setPrenom(resultSet.getString("per_prenom"));
            cl.setAdresse(resultSet.getString("per_adr"));
            cl.setCodePostal(resultSet.getString("per_codepostal"));
            cl.setVille(resultSet.getString("per_ville"));
            cl.setTelephone(resultSet.getString("per_telephone"));
            cl.setEmail(resultSet.getString("per_email"));
            cl.setSecuriteSociale(resultSet.getString("cli_secu"));
            cl.setDateNaissance(resultSet.getString("cli_datenaissance"));
            cl.setMutuelle_id(resultSet.getInt("mut_id"));
            cl.setMedecin_id(resultSet.getInt("med_id"));
            cl.setSpecialiste_id(resultSet.getInt("spe_id"));
            cl.setPerId(resultSet.getInt("per_id"));
            client.add(cl);
        }
        resultSet.close();
        return client;
    }
}

