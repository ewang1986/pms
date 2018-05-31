package com.csg.sone.base.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * <p> Description:  DateUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class DateUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_STR);
    private Date date01;

    @Before
    public void setUp() throws Exception {
        date01 = sdf.parse("2017-6-23 09:10:11");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addDays() throws Exception {
        assertEquals(DateUtil.addDays(null, 2), null);

        Date date = DateUtil.addDays(date01, 2);
        String dateStr = DateUtil.formatDate(date);
        assertEquals(dateStr, "2017-06-25");

        date = DateUtil.addDays(date01, -2);
        dateStr = DateUtil.formatDate(date);
        assertEquals(dateStr, "2017-06-21");

        date = DateUtil.addDays(date01, 10);
        dateStr = DateUtil.formatDate(date);
        assertEquals(dateStr, "2017-07-03");

        date = DateUtil.addDays(date01, 365);
        dateStr = DateUtil.formatDate(date);
        assertEquals(dateStr, "2018-06-23");
    }

    @Test
    public void addHours() throws Exception {

        assertEquals(DateUtil.addHours(null, 2), null);

        Date date = DateUtil.addHours(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 11:10:11");

        date = DateUtil.addHours(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 07:10:11");

        date = DateUtil.addHours(date01, 24);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-24 09:10:11");

        date = DateUtil.addHours(date01, 24 * 30);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-07-23 09:10:11");

        date = DateUtil.addHours(date01, 8760);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2018-06-23 09:10:11");
    }

    @Test
    public void addMinutes() throws Exception {

        assertEquals(DateUtil.addMinutes(null, 2), null);
        Date date = DateUtil.addMinutes(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 09:12:11");

        date = DateUtil.addMinutes(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 09:08:11");

        date = DateUtil.addMinutes(date01, 60);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 10:10:11");

        date = DateUtil.addMinutes(date01, 60 * 24);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-24 09:10:11");

        date = DateUtil.addMinutes(date01, 60 * 24 * 30);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-07-23 09:10:11");

        date = DateUtil.addMinutes(date01, 60 * 8760);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2018-06-23 09:10:11");
    }

    @Test
    public void addMonths() throws Exception {

        assertEquals(DateUtil.addMonths(null, 2), null);

        Date date = DateUtil.addMonths(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertEquals(dateStr, "2017-08-23");

        date = DateUtil.addMonths(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertEquals(dateStr, "2017-04-23");

        date = DateUtil.addMonths(date01, 12);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertEquals(dateStr, "2018-06-23");
    }

    @Test
    public void addSeconds() throws Exception {

        assertEquals(DateUtil.addSeconds(null, 2), null);
        Date date = DateUtil.addSeconds(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 09:10:13");

        date = DateUtil.addSeconds(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 09:10:09");

        date = DateUtil.addSeconds(date01, 60);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 09:11:11");

        date = DateUtil.addSeconds(date01, 60 * 60);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-23 10:10:11");

        date = DateUtil.addSeconds(date01, 60 * 60 * 24);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-06-24 09:10:11");

        date = DateUtil.addSeconds(date01, 60 * 60 * 24 * 30);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-07-23 09:10:11");

        date = DateUtil.addSeconds(date01, 31536000);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2018-06-23 09:10:11");
    }

    @Test
    public void addWeeks() throws Exception {

        assertEquals(DateUtil.addWeeks(null, 2), null);
        Date date = DateUtil.addWeeks(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertThat(dateStr, equalTo("2017-07-07"));

        date = DateUtil.addWeeks(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertThat(dateStr, equalTo("2017-06-09"));

        date = DateUtil.addWeeks(date01, 52);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertThat(dateStr, equalTo("2018-06-22"));

    }

    @Test
    public void addYears() throws Exception {

        assertEquals(DateUtil.addYears(null, 2), null);
        Date date = DateUtil.addYears(date01, 2);
        String dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertThat(dateStr, equalTo("2019-06-23"));
        date = DateUtil.addYears(date01, -2);
        dateStr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_STR);
        assertThat(dateStr, equalTo("2015-06-23"));

    }

    @Test
    public void format() throws Exception {
        assertEquals(DateUtil.formatDate(date01), "2017-06-23");
        assertEquals(DateUtil.formatDatetime(date01), "2017-06-23 09:10:11");
        assertEquals(DateUtil.formatDate(date01, DateUtil.DATE_FORMAT_STR), "2017-06-23");
        assertEquals(DateUtil.formatDate(null, DateUtil.DATE_FORMAT_STR), "");
        assertEquals(DateUtil.formatDate(date01, DateUtil.DATE_FORMAT_STR), "2017-06-23");
        assertEquals(DateUtil.formatDate(date01, "yyyyMMdd"), "20170623");
        assertEquals(DateUtil.formatDate(date01, "yyyy\\MM\\dd"), "2017\\06\\23");
        assertEquals(DateUtil.formatDate(date01, DateUtil.DATE_TIME_FORMAT_STR), "2017-06-23 09:10:11");
    }

    @Test
    public void parseDate() throws Exception {

        String dateStr;
        assertEquals(DateUtil.parseDate(null, DateUtil.DATE_FORMAT_STR), null);

        date01 = DateUtil.parseDate("2017-19-12", DateUtil.DATE_FORMAT_STR);
        dateStr = DateUtil.formatDate(date01, DateUtil.DATE_FORMAT_STR);
        assertEquals(dateStr, "2018-07-12");

        date01 = DateUtil.parseDate("20170912", "yyyyMMdd");
        dateStr = DateUtil.formatDate(date01, "yyyyMMdd");
        assertEquals(dateStr, "20170912");

        date01 = DateUtil.parseDate("2017-09-12", DateUtil.DATE_FORMAT_STR);
        dateStr = DateUtil.formatDate(date01, DateUtil.DATE_FORMAT_STR);
        assertEquals(dateStr, "2017-09-12");

        date01 = DateUtil.parseDate("2017-09-12");
        dateStr = DateUtil.formatDate(date01);
        assertEquals(dateStr, "2017-09-12");

        date01 = DateUtil.parseDate("2017-09-12 09:09:09", DateUtil.DATE_TIME_FORMAT_STR);
        dateStr = DateUtil.formatDate(date01, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-09-12 09:09:09");

        date01 = DateUtil.parseDate("2017-09-12 09:09:09", DateUtil.DATE_FORMAT_STR, DateUtil.DATE_TIME_FORMAT_STR);
        dateStr = DateUtil.formatDate(date01, DateUtil.DATE_TIME_FORMAT_STR);
        assertEquals(dateStr, "2017-09-12 09:09:09");
    }

    @Test
    public void isSameDate() throws Exception {
        assertTrue(DateUtil.isSameDate(new Date(), new Date()));
        assertTrue(DateUtil.isSameDate(DateUtil.parseDate("2017-06-23 01:11:21", DateUtil.DATE_TIME_FORMAT_STR), date01));
        assertFalse(DateUtil.isSameDate(new Date(), date01));
        assertFalse(DateUtil.isSameDate(null, date01));
        assertFalse(DateUtil.isSameDate(date01, null));
        assertFalse(DateUtil.isSameDate(null, null));
    }

    @Test
    public void isIncludeEmpty() {
        List<Date> list = new ArrayList<Date>();
        assertTrue(DateUtil.isIncludeEmpty(list));
        list.add(new Date());
        assertFalse(DateUtil.isIncludeEmpty(list));
        list.add(null);
        assertTrue(DateUtil.isIncludeEmpty(list));

    }

    @Test
    public void compareDay() throws Exception {
        //  2017-6-23 09:10:11
        String message = "";
        try {
            DateUtil.compareDay(null, DateUtil.parseDate("2016-06-22 09:11:01", DateUtil.DATE_TIME_FORMAT_STR));
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(message, "时间参数不能为空");
        assertEquals(DateUtil.compareDay(date01, DateUtil.parseDate("2016-06-22 09:11:01", DateUtil.DATE_TIME_FORMAT_STR)), 366);
        assertEquals(DateUtil.compareDay(DateUtil.parseDate("2016-06-22 09:11:01", DateUtil.DATE_TIME_FORMAT_STR), date01), -366);
        assertEquals(DateUtil.compareDay(new Date(), new Date()), 0);
    }


}