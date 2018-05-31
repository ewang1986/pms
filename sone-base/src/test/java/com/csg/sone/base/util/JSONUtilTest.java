package com.csg.sone.base.util;

import com.csg.sone.base.bean.SourceBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * <p> Description:  JSONUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
public class JSONUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Date date = new Date(1504534829398l);
    private Map map01 = new HashMap();
    private List lst01 = new ArrayList();
    private SourceBean sourceBean01 = new SourceBean();
    private SourceBean sourceBean02 = new SourceBean();
    private List<SourceBean> lst02 = new ArrayList();

    @Before
    public void setUp() {
        map01.put("strField", "a");
        map01.put("intField", 1);
        map01.put("longField", 1l);
        map01.put("decimalField", new BigDecimal("123.456"));
        map01.put("dateField", date);

        lst01.add("a");
        lst01.add(1);
        lst01.add(1l);
        lst01.add(new BigDecimal("123.456"));
        lst01.add(date);

        sourceBean01.setStrField("a");
        sourceBean01.setIntField(1);
        sourceBean01.setLongField(1L);
        sourceBean01.setDecimalField(new BigDecimal("123.456"));
        sourceBean01.setDateField(date);
        sourceBean01.setDateTimeField(date);

        sourceBean02.setStrField("a");
        sourceBean02.setIntField(1);
        sourceBean02.setLongField(1L);
        sourceBean02.setDecimalField(new BigDecimal("123.456"));
        sourceBean02.setDateField(date);
        sourceBean02.setDateTimeField(date);

        lst02.add(sourceBean01);
        lst02.add(sourceBean02);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void format() {
        assertEquals(JSONUtil.format(map01), "{\n" +
                "\t\"decimalField\":123.456,\n" +
                "\t\"longField\":1,\n" +
                "\t\"strField\":\"a\",\n" +
                "\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"intField\":1\n" +
                "}");
        assertEquals(JSONUtil.format(lst01), "[\n" +
                "\t\"a\",\n" +
                "\t1,\n" +
                "\t1,\n" +
                "\t123.456,\n" +
                "\t\"2017-09-04T22:20:29.398+08:00\"\n" +
                "]");
        assertEquals(JSONUtil.format(sourceBean01), "{\n" +
                "\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"decimalField\":123.456,\n" +
                "\t\"intField\":1,\n" +
                "\t\"longField\":1,\n" +
                "\t\"sourceBean1\":null,\n" +
                "\t\"sourceBean2\":null,\n" +
                "\t\"strField\":\"a\"\n" +
                "}");
        assertEquals(JSONUtil.format(lst02), "[\n" +
                "\t{\n" +
                "\t\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"decimalField\":123.456,\n" +
                "\t\t\"intField\":1,\n" +
                "\t\t\"longField\":1,\n" +
                "\t\t\"sourceBean1\":null,\n" +
                "\t\t\"sourceBean2\":null,\n" +
                "\t\t\"strField\":\"a\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"decimalField\":123.456,\n" +
                "\t\t\"intField\":1,\n" +
                "\t\t\"longField\":1,\n" +
                "\t\t\"sourceBean1\":null,\n" +
                "\t\t\"sourceBean2\":null,\n" +
                "\t\t\"strField\":\"a\"\n" +
                "\t}\n" +
                "]");
    }

    @Test
    public void parseMap() {
        Map map = JSONUtil.parseMap("{\n" +
                "\t\"decimalField\":123.456,\n" +
                "\t\"longField\":1,\n" +
                "\t\"strField\":\"a\",\n" +
                "\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"intField\":1\n" +
                "}");
        assertEquals(map.get("strField"), "a");
        assertEquals((Integer) map.get("intField"), new Integer(1));
        assertEquals((Integer) map.get("longField"), new Integer(1));
        assertEquals((BigDecimal) map.get("decimalField"), new BigDecimal("123.456"));
        assertEquals(map.get("dateField"), "2017-09-04T22:20:29.398+08:00");
    }

    @Test
    public void parseList() {
        List lst = JSONUtil.parseList("[\n" +
                "\t\"a\",\n" +
                "\t1,\n" +
                "\t1,\n" +
                "\t123.456,\n" +
                "\t\"2017-09-04T22:20:29.398+08:00\"\n" +
                "]");
        assertEquals(lst.get(0), "a");
        assertEquals((Integer) lst.get(1), new Integer(1));
        assertEquals((Integer) lst.get(2), new Integer(1));
        assertEquals((BigDecimal) lst.get(3), new BigDecimal("123.456"));
        assertEquals(lst.get(4), "2017-09-04T22:20:29.398+08:00");
    }

    @Test
    public void parseBean() {
        SourceBean sourceBean = JSONUtil.parseBean("{\n" +
                "\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\"decimalField\":123.456,\n" +
                "\t\"intField\":1,\n" +
                "\t\"longField\":1,\n" +
                "\t\"sourceBean1\":null,\n" +
                "\t\"sourceBean2\":null,\n" +
                "\t\"strField\":\"a\"\n" +
                "}", SourceBean.class);
        assertEquals(sourceBean.getStrField(), "a");
        assertEquals(sourceBean.getIntField(), new Integer(1));
        assertEquals(sourceBean.getLongField(), new Long(1l));
        assertEquals(sourceBean.getDecimalField(), new BigDecimal("123.456"));
        assertEquals(sourceBean.getDateField(), date);
        assertEquals(sourceBean.getDateTimeField(), date);
    }

    @Test
    public void parseBeanList() {
        List<SourceBean> lst = JSONUtil.parseBeanList("[\n" +
                "\t{\n" +
                "\t\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"decimalField\":123.456,\n" +
                "\t\t\"intField\":1,\n" +
                "\t\t\"longField\":1,\n" +
                "\t\t\"sourceBean1\":null,\n" +
                "\t\t\"sourceBean2\":null,\n" +
                "\t\t\"strField\":\"a\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"dateField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"dateTimeField\":\"2017-09-04T22:20:29.398+08:00\",\n" +
                "\t\t\"decimalField\":123.456,\n" +
                "\t\t\"intField\":1,\n" +
                "\t\t\"longField\":1,\n" +
                "\t\t\"sourceBean1\":null,\n" +
                "\t\t\"sourceBean2\":null,\n" +
                "\t\t\"strField\":\"a\"\n" +
                "\t}\n" +
                "]", SourceBean.class);
        assertEquals(lst.get(0), sourceBean01);
        assertEquals(lst.get(1), sourceBean02);
    }
}
