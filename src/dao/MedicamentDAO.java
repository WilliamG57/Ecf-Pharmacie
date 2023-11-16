package dao;

import classmetier.Medicaments;
import utils.DateManagment;
import utils.MyException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.log4j.builders.appender.SocketAppenderBuilder.LOGGER;

public class MedicamentDAO extends DAO<Medicaments> {

    List<Medicaments> medicaments = new ArrayList<>();

    public List<Medicaments> getMedicaments() {
        return medicaments;
    }

    @Override
    public int create(Medicaments obj) {
        StringBuilder insertMedicament = new StringBuilder();
        insertMedicament.append("insert into medicament ");
        insertMedicament.append("(`medi_nom`, `medi_prix`, `medi_miseenservice`, medi_stock, `cat_id`)");
        insertMedicament.append("VALUES (?, ?, ?, ?, ?)");

        int newId = 0;
        try (PreparedStatement ps = connect.prepareStatement(insertMedicament.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNom());
            ps.setDouble(2, obj.getPrix());
            ps.setDate(3, DateManagment.convertString(obj.getMiseEnService()));
            ps.setInt(4,obj.getStock());
            ps.setInt(4,obj.getCategorie_id());
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
    public boolean delete(Medicaments obj) {
        return false;
    }

    @Override
    public boolean update(Medicaments obj) {
        return false;
    }

    @Override
    public Medicaments find(Integer medID) throws SQLException {
        StringBuilder sqlFindMedicament = new StringBuilder();
        sqlFindMedicament.append("SELECT * FROM medicament m");
        sqlFindMedicament.append("JOIN categorie c ON c.cat_id = m.cat_id");
        sqlFindMedicament.append(" WHERE medi_id = ?");
        Medicaments medi = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindMedicament.toString())) {
            preparedStatement.setInt(1, medID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                medi = new Medicaments();
                medi.setMedicamentID(resultSet.getInt("medi_id"));
                medi.setNom(resultSet.getString("medi_nom"));
                medi.setPrix(resultSet.getDouble("medi_prix"));
                medi.setMiseEnService(resultSet.getString("medi_miseenservice"));
                medi.setStock(resultSet.getInt("medi_stock"));
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return medi;
    }

    @Override
    public List<Medicaments> findAll() throws Exception {
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM medicament m JOIN categorie c ON c.cat_id = m.cat_id");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Medicaments medi = new Medicaments();
            medi.setMedicamentID(resultSet.getInt("medi_id"));
            medi.setNom(resultSet.getString("medi_nom"));
            medi.setPrix(resultSet.getDouble("medi_prix"));
            medi.setMiseEnService(resultSet.getString("medi_miseenservice"));
            medi.setStock(resultSet.getInt("medi_stock"));
            medicaments.add(medi);
        }
        return medicaments;
    }
}
