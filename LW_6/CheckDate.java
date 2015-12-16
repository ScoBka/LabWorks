package LW_6;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CheckDate {
    public String checkDate(Date date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return format.format(date);
    }
}

