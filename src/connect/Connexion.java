package connect;

import utils.MyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    public static void connexion () throws ClassNotFoundException {
        String BDD = "sparadrap";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connecter");

            conn.close();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
