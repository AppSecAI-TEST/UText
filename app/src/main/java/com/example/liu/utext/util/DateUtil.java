package com.example.liu.utext.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getInstance();

    public static int getDay(String format, Date date){
        simpleDateFormat.applyPattern(format);
        return Integer.valueOf(simpleDateFormat.format(date));
    }

    public static int getMonth(String format, Date date){
        simpleDateFormat.applyPattern(format);
        return Integer.valueOf(simpleDateFormat.format(date));
    }

    public static int getYear(String format, Date date){
        simpleDateFormat.applyPattern(format);
        return Integer.valueOf(simpleDateFormat.format(date));
    }
}
