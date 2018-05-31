package com.csg.sone.base.util;

import com.csg.sone.base.bean.SourceBean;
import com.csg.sone.base.bean.TargetBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * <p> Description:  ArrayUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author Duyang
 * @version 1.0
 */
public class ObjectUtilTest {
    private Object nullObjArr = new Object[0];
    private Date date = new Date(1504534829398l);
    private List lst01 = new ArrayList();
    private Map map01 = new HashMap();
    private SourceBean sourceBean01 = new SourceBean();
    private TargetBean targetBean01 = new TargetBean();
    private String beanClassStr = "com.csg.sone.base.bean.SourceBean";

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createClass() {
        assertEquals(ObjectUtil.createClass(beanClassStr), SourceBean.class);
    }

    @Test
    public void createObject() {
        SourceBean sourceBean = new SourceBean();
        assertEquals(ObjectUtil.createObject(beanClassStr), sourceBean);
        assertEquals(ObjectUtil.createObject(SourceBean.class), sourceBean);
    }

    @Test
    public void deepClone() {
        assertNull(ObjectUtil.deepClone(null));
        assertEquals(ObjectUtil.deepClone(""), "");
        assertEquals(ObjectUtil.deepClone((ArrayList) lst01), lst01);
        assertEquals(ObjectUtil.deepClone((HashMap) map01), map01);
        assertEquals(ObjectUtil.deepClone(sourceBean01), sourceBean01);
    }

    @Test
    public void serialize() throws Exception {
        assertEquals(ObjectUtil.deserialize(ObjectUtil.serialize(null)), null);
        assertEquals(ObjectUtil.deserialize(ObjectUtil.serialize((ArrayList) lst01)), lst01);
        assertEquals(ObjectUtil.deserialize(ObjectUtil.serialize((HashMap) map01)), map01);
        assertEquals(ObjectUtil.deserialize(ObjectUtil.serialize(sourceBean01)), sourceBean01);

        FileOutputStream fos1 = new FileOutputStream(SystemUtil.JAVA_IO_TMPDIR + "test1.dat");
        FileOutputStream fos2 = new FileOutputStream(SystemUtil.JAVA_IO_TMPDIR + "test2.dat");
        FileOutputStream fos3 = new FileOutputStream(SystemUtil.JAVA_IO_TMPDIR + "test3.dat");
        FileOutputStream fos4 = new FileOutputStream(SystemUtil.JAVA_IO_TMPDIR + "test4.dat");

        FileInputStream fis1 = new FileInputStream(SystemUtil.JAVA_IO_TMPDIR + "test1.dat");
        FileInputStream fis2 = new FileInputStream(SystemUtil.JAVA_IO_TMPDIR + "test2.dat");
        FileInputStream fis3 = new FileInputStream(SystemUtil.JAVA_IO_TMPDIR + "test3.dat");
        FileInputStream fis4 = new FileInputStream(SystemUtil.JAVA_IO_TMPDIR + "test4.dat");

        ObjectUtil.serialize(null, fos1);
        ObjectUtil.serialize((ArrayList) lst01, fos2);
        ObjectUtil.serialize((HashMap) map01, fos3);
        ObjectUtil.serialize(sourceBean01, fos4);

        assertNull(ObjectUtil.deserialize(fis1));
        assertEquals(ObjectUtil.deserialize(fis2), lst01);
        assertEquals(ObjectUtil.deserialize(fis3), map01);
        assertEquals(ObjectUtil.deserialize(fis4), sourceBean01);
    }

    @Test
    public void isString() {
        assertFalse(ObjectUtil.isString(null));
        assertTrue(ObjectUtil.isString(""));
        assertTrue(ObjectUtil.isString("a"));
        assertFalse(ObjectUtil.isString(1));
    }

    @Test
    public void isInteger() {
        assertFalse(ObjectUtil.isInteger(null));
        assertFalse(ObjectUtil.isInteger("a"));
        assertTrue(ObjectUtil.isInteger(1));
        assertTrue(ObjectUtil.isInteger(new Integer(1)));
        assertFalse(ObjectUtil.isInteger(1L));
    }

    @Test
    public void isLong() {
        assertFalse(ObjectUtil.isLong(null));
        assertFalse(ObjectUtil.isLong("a"));
        assertTrue(ObjectUtil.isLong(1L));
        assertTrue(ObjectUtil.isLong(new Long(1)));
        assertFalse(ObjectUtil.isLong(1));
    }

    @Test
    public void isFloat() {
        assertFalse(ObjectUtil.isFloat(null));
        assertFalse(ObjectUtil.isFloat("a"));
        assertTrue(ObjectUtil.isFloat(1.0f));
        assertTrue(ObjectUtil.isFloat(new Float(1.0f)));
        assertFalse(ObjectUtil.isFloat(1.0));
    }

    @Test
    public void isDouble() {
        assertFalse(ObjectUtil.isDouble(null));
        assertFalse(ObjectUtil.isDouble("a"));
        assertTrue(ObjectUtil.isDouble(1.0));
        assertTrue(ObjectUtil.isDouble(1.0d));
        assertTrue(ObjectUtil.isDouble(new Double(1.0)));
        assertFalse(ObjectUtil.isDouble(1.0f));
    }

    @Test
    public void isBigDecimal() {
        assertFalse(ObjectUtil.isBigDecimal(null));
        assertFalse(ObjectUtil.isBigDecimal("a"));
        assertFalse(ObjectUtil.isBigDecimal(1));
        assertFalse(ObjectUtil.isBigDecimal(1L));
        assertFalse(ObjectUtil.isBigDecimal(1.0f));
        assertFalse(ObjectUtil.isBigDecimal(1.0d));
        assertTrue(ObjectUtil.isBigDecimal(new BigDecimal("1.0")));
    }

    @Test
    public void isBigInteger() {
        assertFalse(ObjectUtil.isBigInteger(null));
        assertFalse(ObjectUtil.isBigInteger("a"));
        assertFalse(ObjectUtil.isBigInteger(1));
        assertFalse(ObjectUtil.isBigInteger(1L));
        assertFalse(ObjectUtil.isBigInteger(1.0f));
        assertFalse(ObjectUtil.isBigInteger(1.0d));
        assertTrue(ObjectUtil.isBigInteger(new BigInteger("1")));
    }

    @Test
    public void isDate() {
        assertFalse(ObjectUtil.isDate(null));
        assertFalse(ObjectUtil.isDate("a"));
        assertTrue(ObjectUtil.isDate(new Date()));
    }

    @Test
    public void isArray() {
        assertFalse(ObjectUtil.isArray(null));
        assertFalse(ObjectUtil.isArray("a"));
        assertTrue(ObjectUtil.isArray(new Object[0]));
        assertTrue(ObjectUtil.isArray(new Object[]{""}));
        assertTrue(ObjectUtil.isArray(new Object[]{"a", "b", "c"}));
        assertTrue(ObjectUtil.isArray(new Object[]{null}));
    }

    @Test
    public void isList() {
        assertFalse(ObjectUtil.isList(null));
        assertFalse(ObjectUtil.isList("a"));
        assertTrue(ObjectUtil.isList(new ArrayList()));
        assertTrue(ObjectUtil.isList(new LinkedList()));
    }

    @Test
    public void isMap() {
        assertFalse(ObjectUtil.isMap(null));
        assertFalse(ObjectUtil.isMap("a"));
        assertTrue(ObjectUtil.isMap(new HashMap()));
        assertTrue(ObjectUtil.isMap(new Hashtable()));
        assertTrue(ObjectUtil.isMap(new LinkedHashMap()));
        assertTrue(ObjectUtil.isMap(new IdentityHashMap()));
        assertTrue(ObjectUtil.isMap(new TreeMap()));
        assertTrue(ObjectUtil.isMap(new WeakHashMap()));
        assertTrue(ObjectUtil.isMap(new ConcurrentHashMap()));
    }

    @Test
    public void isSet() {
        assertFalse(ObjectUtil.isSet(null));
        assertFalse(ObjectUtil.isSet("a"));
        assertTrue(ObjectUtil.isSet(new HashSet()));
        assertTrue(ObjectUtil.isSet(new TreeSet()));
        assertTrue(ObjectUtil.isSet(new LinkedHashSet()));
    }

    @Test
    public void toStringTest() {
        assertNotNull(ObjectUtil.toString(null));
        assertNotNull(ObjectUtil.toString(""));
        assertNotNull(ObjectUtil.toString("a"));
        assertNotNull(ObjectUtil.toString(nullObjArr));
        assertNotNull(ObjectUtil.toString(lst01));
        assertNotNull(ObjectUtil.toString(map01));
        assertNotNull(ObjectUtil.toString(sourceBean01));
    }
}