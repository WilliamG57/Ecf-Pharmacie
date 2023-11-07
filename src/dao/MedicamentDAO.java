package dao;

import classmetier.Medicaments;
import utils.MyException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentDAO extends DAO<Medicaments> {

    List<Medicaments> medicaments = new ArrayList<>();

    public List<Medicaments> getMedicaments() {
        return medicaments;
    }

    @Override
    public void create(Medicaments obj) {

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
        sqlFindMedicament.append("SELECT * FROM medicament");
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
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Medicaments> findAll() throws Exception {
        return null;
    }
}
