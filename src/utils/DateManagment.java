package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//Methode de gestion des erreurs des dates
public class DateManagment {
    public static String parse(String date, String message) throws MyException {
        try {
            if (date == null) {
                throw new MyException(message);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(date);
            return date;
        } catch (ParseException pe) {
            throw new MyException(message);
        }
    }
//Methode de conversion des dates
    public static java.sql.Date convertString(String date) {
        java.util.Date tampon;
        java.sql.Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            tampon = sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        result = new java.sql.Date(tampon.getTime());
        System.out.println(result);
        return result;
    }
}
