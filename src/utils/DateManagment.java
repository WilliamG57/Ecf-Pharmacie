package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateManagment {

    public static String parse(String date, String message) throws MyException{
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
}
