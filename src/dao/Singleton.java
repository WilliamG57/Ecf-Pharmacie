package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Singleton {
    private static final String PATHCONF = "./src/ressource/conf.Properties";
    private static final Properties props = new Properties();
    private static Connection connection;

    private Singleton() {
        try {
            FileInputStream file = new FileInputStream(PATHCONF);
            props.load(file);
            props.setProperty("user", props.getProperty("jdbc.login"));
            props.setProperty("password", props.getProperty("jdbc.password"));
            Class.forName(props.getProperty("jdbc.driver.class"));
            connection = DriverManager.getConnection(props.getProperty("jdbc.url"), props);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println("RelationWithBD connection : " + e.getMessage());
        }
    }

    private static Connection getConnection() {return connection; }

    public static Connection getInstanceDB() {
        if (getConnection() ==null) {
            new Singleton();
            System.out.println("RelationWithDB infos : Connection Etablished");
        } else {
            System.out.println("RelationWithDB infos : Connection already existing");
        }
        return getConnection();
    }

    public static void closeInstanceDB() {
        try{
            Singleton.getInstanceDB().close();
            System.out.println("RelationWithDB infos : Connection terminated");
        } catch (SQLException sqle) {
            System.out.println("RelationWithDB error : " + sqle.getMessage()+ "[SQL error code : " + sqle.getSQLState()+ "]");
        }
    }

//    public static void TestSingleton() {
//        try {
//            Connection connect = Singleton.getInstanceDB();
//            String sql = "select * from personne ";
//            PreparedStatement statement = connect.prepareStatement(sql);
//            ResultSet result = statement.executeQuery();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Erreur" + e.getMessage());
//            System.exit(0);
//        }
//    }
}
