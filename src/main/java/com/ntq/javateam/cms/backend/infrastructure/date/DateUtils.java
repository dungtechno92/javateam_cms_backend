package com.ntq.javateam.cms.backend.infrastructure.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date convertStringToDate(String dateText, String dateFormat) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.parse(dateText);
    }
    
    public static String convertDateToString(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
}
