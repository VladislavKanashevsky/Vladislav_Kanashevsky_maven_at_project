package project.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public String setDay(int day) {
        SimpleDateFormat needFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(new Date());
        myCalendar.add(Calendar.DAY_OF_MONTH, day);
        return needFormat.format(myCalendar.getTime());
    }
}
