package com.csg.sone.base.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p> Description:  DateUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class DateUtil {
    /**
     * <p> A String for time format "HH:mm:ss".</p>
     */
    public static final String TIME_FORMAT_STR = "HH:mm:ss";
    /**
     * <p> A String for date format "yyyy-MM-dd".</p>
     */
    public static final String DATE_FORMAT_STR = "yyyy-MM-dd";
    /**
     * <p> A String for datetime format "yyyy-MM-dd HH:mm:ss".</p>
     */
    public static final String DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    /**
     * <p> A String for datetime format "yyyy-MM-dd HH:mm:ss".</p>
     */
    public static final String ISO_DATE_TIME_FORMAT_STR = "yyyy-MM-ddTHH:mm:ss";

    /**
     * <p> Adds a number of days to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23
     * DateUtil.addDays(null,2) = null ;
     * DateUtil.addDays(date,2) = 2017-09-25 ;
     * DateUtil.addDays(date,20) = 2017-10-03 ;
     * DateUtil.addDays(date,-2) = 2017-09-21;
     * DateUtil.addDays(date,356) = 2018-09-23;
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addDays(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addDays(date, amount);
    }

    /**
     * <p>Adds a number of hours to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11
     * DateUtil.addHours(null,2) = null ;
     * DateUtil.addHours(date,2) = 2017-09-23 11:10:11;
     * DateUtil.addHours(date,24) = 2017-09-24 09:10:11
     * DateUtil.addHours(date,-2) = 2017-09-23 07:10:11;
     * DateUtil.addHours(date,24 * 30) = 2017-10-23 09:10:11
     * DateUtil.addHours(date,8760) = 2018-09-23 09:10:11
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addHours(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addHours(date, amount);
    }


    /**
     * <p> Adds a Millisecond of hours to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11 000
     * DateUtil.addMilliseconds(null,2) = null ;
     * DateUtil.addMilliseconds(date,100) = 2017-09-23 09:10:11 100
     * DateUtil.addMilliseconds(date,1000) = 2017-09-23 09:10:12 000
     * DateUtil.addMilliseconds(date, 1000 * 60 * 60 * 24 ) =  2017-09-24 09:10:11 000
     * DateUtil.addMilliseconds(date, 1000 * 60 * 60 * 24 *30) =  DateUtil.addMilliseconds(date,-1702967296)
     *
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMilliseconds(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addMilliseconds(date, amount);
    }


    /**
     * <p>Adds a number of minutes to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11 000
     * DateUtil.addMinutes(null,2) = null ;
     * DateUtil.addMinutes(date,2) = 2017-09-23 09:12:11
     * DateUtil.addMinutes(date,51) = 2017-09-23 10:01:11
     * DateUtil.addMinutes(date,-2) =2017-09-23 09:08:11;
     * DateUtil.addMinutes(date,60 * 24) = 2017-09-24 09:10:11 000
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMinutes(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * <p> Adds a number of months to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11 000
     * DateUtil.addMonths(null,2) = null ;
     * DateUtil.addMonths(date,2) =  2017-11-23 09:10:11 000
     * DateUtil.addMonths(date,12) =  2018-09-23 09:10:11 000
     * DateUtil.addMonths(date,-2) =  2017-07-23 09:10:11 000
     *
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMonths(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addMonths(date, amount);
    }

    /**
     * <p>Adds a number of seconds to a date returning a new object.
     * </p>
     * date = 2017-09-23 09:10:11 000
     * DateUtil.addSeconds(null,2) = null ;
     * DateUtil.addSeconds(date,2) = 2017-09-23 09:10:13 000
     * DateUtil.addSeconds(date,60) =  2017-09-23 09:11:11 000
     * DateUtil.addSeconds(date,-2) =  2017-09-23 09:10:09 000
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addSeconds(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * <p>Adds a number of weeks to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23
     * DateUtil.addWeeks(null,2) = null ;
     * DateUtil.addWeeks(date,1) =  2017-09-30
     * DateUtil.addWeeks(date,4) =  2017-10-21
     * DateUtil.addWeeks(date,-2) =  2017-09-09
     * DateUtil.addWeeks(date,52) =  2018-09-22
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addWeeks(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * <p>Adds a number of years to a date returning a new object.
     * </p>
     * <pre>
     * date = 2017-09-23
     * DateUtil.addYears(null,2) = null ;
     * DateUtil.addYears(date,1) =  2018-09-23
     * DateUtil.addYears(date,-2) =  2015-09-23
     * </pre>
     *
     * @param date
     * @param amount
     * @return
     */
    static Date addYears(Date date, int amount) {
        if (date == null) {
            return null;
        }
        return DateUtils.addYears(date, amount);
    }

    /**
     * <p>比较时间，计算出间隔天数,只比较天，不比较时分秒.
     * </p>
     * <pre>
     * date1 = 2017-01-02 00:00:00
     * date2 = 2017-01-01 23:00:00
     * date3 = 2017-01-01 23:00:00
     * DateUtil.compareDay(date1,date2) = 1 ;
     * DateUtil.compareDay(date2,date1) = -1 ;
     * DateUtil.compareDay(date2,date3) = 0 ;
     * </pre>
     *
     * @param date1
     * @param date2
     * @return
     */
    static int compareDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new NullPointerException("时间参数不能为空");
        }

        date1 = DateUtil.parseDate(DateUtil.formatDate(date1));
        date2 = DateUtil.parseDate(DateUtil.formatDate(date2));
        int days = (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * <p> Formats a Date into a date string.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11
     * DateUtil.addYears(null,"yyyyMMdd") = "" ;
     * DateUtil.format(date) = "2017-09-23"
     * DateUtil.format(date,"yyyyMMdd") = "20170923"
     * DateUtil.format(date,"yyyy\MM\dd") = "2017\09\23"
     * </pre>
     *
     * @param date
     * @param pattern
     * @return the formatted time string.
     */
    public static String formatDate(Date date, String... pattern) {
        String strPattern = DateUtil.DATE_FORMAT_STR;
        if (date == null) {
            return "";
        }
        if (ArrayUtil.isNotEmpty(pattern)) {
            strPattern = pattern[0];
        }
        SimpleDateFormat format = new SimpleDateFormat(strPattern);
        return format.format(date);
    }

    /**
     * <p> Formats a Date into a time string.
     * </p>
     * <pre>
     * date = 2017-09-23 09:10:11
     * DateUtil.formatDatetime(null,"yyyyMMdd") = "" ;
     * DateUtil.formatDatetime(date,"yyyyMMdd") = 20170923
     * DateUtil.formatDatetime(date,"yyyy\MM\dd") = 2017\09\23
     * DateUtil.formatDatetime(date) = "2017-09-23 09:10:11"
     * </pre>
     *
     * @param date
     * @param pattern
     * @return the formatted time string.
     */
    public static String formatDatetime(Date date, String... pattern) {
        String strPattern = DateUtil.DATE_TIME_FORMAT_STR;

        if (date == null) {
            return "";
        }
        if (ArrayUtil.isNotEmpty(pattern)) {
            strPattern = pattern[0];
        }
        SimpleDateFormat format = new SimpleDateFormat(strPattern);
        return format.format(date);
    }

    /**
     * <p>Checks if two date objects are on the same day ignoring time.
     * </p>
     * <pre>
     *  date1 = 2017-01-01 02:02:02
     *  date2 = 2017-01-02
     *  date3 = 2017-01-01 01:01:01
     *  DateUtil.isSameDate(null,null) = false
     *  DateUtil.isSameDate(date1,null) = false
     *  DateUtil.isSameDate(null,date1) = false
     *  DateUtil.isSameDate(date1,date3) = true
     * </pre>
     *
     * @param date1
     * @param date2
     * @return true if they represent the same day
     */
    public static boolean isSameDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * <p>Checks if Date list is  null.
     * </p>
     * <pre>
     * list = null
     * DateUtil.isIncludeEmpty(list) = true;
     * list = [date1,date2]
     * DateUtil.isIncludeEmpty(list) = true;
     * list = [date1,date2,null]
     * DateUtil.isIncludeEmpty(list) = false;
     * </pre>
     *
     * @param dateList
     * @return
     */
    public static final boolean isIncludeEmpty(final List<Date> dateList) {
        boolean flag = false;
        if (ListUtil.isEmpty(dateList)) {
            return true;
        }
        for (Date date : dateList) {
            if (date == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * <p>Checks if Date list is  null.
     * </p>
     * <p>
     * <pre>
     * list = null
     * DateUtil.isIncludeEmpty(list) = true;
     * list = [date1,date2]
     * DateUtil.isIncludeEmpty(list) = true;
     * list = [date1,date2,null]
     * DateUtil.isIncludeEmpty(list) = false;
     * </pre>
     *
     * @param dateList
     * @return
     */
    public static final boolean isIncludeEmpty(final Date[] dateList) {
        boolean flag = false;
        if (ArrayUtil.isEmpty(dateList)) {
            return true;
        }
        for (Date date : dateList) {
            if (date == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * <p>Parses a string representing a date by trying a variety of different parsers.
     * </p>
     * <pre>
     * DateUtil.parseDate("2017-09-12","yyyy-MM-dd");  =  Date : 2017-09-12
     * DateUtil.parseDate("2017-19-12","yyyy-MM-dd");  =  Date : 2018-07-12
     * DateUtil.parseDate("2017-09-12","yyyyMMdd");  = nul
     * DateUtil.parseDate("2017-09-12","yyyyMMdd","yyyy-MM-dd");  Date : 2017-09-12
     * DateUtil.parseDate("2017-09-12");
     * </pre>
     *
     * @param str
     * @param parsePatterns
     * @return
     */
    public static Date parseDate(String str, String... parsePatterns) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            if (ArrayUtil.isEmpty(parsePatterns)) {
                return DateUtils.parseDate(str, DateUtil.DATE_FORMAT_STR);
            } else {
                return DateUtils.parseDate(str, parsePatterns);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
