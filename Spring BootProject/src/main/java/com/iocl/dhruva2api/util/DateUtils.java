package com.iocl.dhruva2api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.Date;

/**
 * DateUtils
 */
public class DateUtils {

    public static Date convertStringToDate(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String convertDateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String fetchCurrentFinancialQuarter() {

        int quarterNo = LocalDate.now().get(IsoFields.QUARTER_OF_YEAR);

        return "" + LocalDate.now().getYear() + "-" + (LocalDate.now().getYear() + 1) + "/Q"
                + (quarterNo == 1 ? 4 : quarterNo - 1);
        // return "2019-2020/Q1";
    }

    public static int fetchCurrentFinancialYear() {

        int year = LocalDate.now().getYear();
        if (LocalDate.now().getMonthValue() < 4) {
            year--;
        }
        return year;
    }

    public static boolean isMonthInQuarterRange(int month, int quarter) {
    	switch (quarter) {
        case 1:
            return month >= 4 && month <= 6;
        case 2:
            return month >= 7 && month <= 9;
        case 3:
            return month >= 10 && month <= 12;
        case 4:
            return month >= 1 && month <= 3;
        default:
            return false;
        }
    }

    public static Date fetchCurrentDate() {
        return new Date();
    }
    
    public static long calculateDateTimeDifference(LocalDateTime dateTimeBefore, LocalDateTime dateTimeAfter) {
		return ChronoUnit.HOURS.between(dateTimeBefore, dateTimeAfter);
	}
}