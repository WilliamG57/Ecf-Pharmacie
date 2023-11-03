package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public abstract class DAO<T> {
    protected static Connection connect = Singleton.getInstanceDB();

    public abstract void create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(Integer pID);

    public abstract List<T> findAll() throws SQLException;
}
