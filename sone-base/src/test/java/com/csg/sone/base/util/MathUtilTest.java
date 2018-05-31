package com.csg.sone.base.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * <p> Description:  MathUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class MathUtilTest {

    @Test
    public void asNumber() throws Exception {
        int i = MathUtil.asNumber("111", int.class);
        assertEquals(i, 111);
        Double d = MathUtil.asNumber("11.11", double.class);
        assertEquals(d, new Double(11.11));
        d = MathUtil.asNumber("", double.class);
        d = MathUtil.asNumber(null, double.class);
        System.out.print(d);
    }

    @Test
    public void add() throws Exception {
        BigDecimal re = MathUtil.add(new BigDecimal(10.23), new BigDecimal(2));
        assertEquals(re, new BigDecimal(12.23));
        re = MathUtil.add((BigDecimal) null, null);
        assertEquals(re, BigDecimal.ZERO);
        re = MathUtil.add(new BigDecimal(10.23), null);
        assertEquals(re, new BigDecimal(10.23));
        re = MathUtil.add(null, new BigDecimal(10.23));
        assertEquals(re, new BigDecimal(10.23));

        BigInteger ret = MathUtil.add(new BigInteger("10"), new BigInteger("-2"));
        assertEquals(ret, new BigInteger("8"));
        ret = MathUtil.add((BigInteger) null, null);
        assertEquals(ret, BigInteger.ZERO);
        ret = MathUtil.add(new BigInteger("10"), null);
        assertEquals(ret, new BigInteger("10"));
        ret = MathUtil.add(null, new BigInteger("10"));
        assertEquals(ret, new BigInteger("10"));
    }

    @Test
    public void divide() throws Exception {
        BigDecimal re = MathUtil.divide(new BigDecimal(10), new BigDecimal(2));
        assertEquals(re, new BigDecimal("5.00"));
        String message = "";
        try {
            MathUtil.divide((BigDecimal) null, null);
        } catch (Exception e) {
            message = e.getMessage();
        }

        assertThat(message, containsString("by zero"));
        re = MathUtil.divide(null, new BigDecimal("10.23"));
        assertEquals(re.intValue(), 0);
        re = MathUtil.divide(new BigDecimal(10), new BigDecimal(3));
        assertEquals(re, new BigDecimal("3.33"));
        re = MathUtil.divide(new BigDecimal(18.235), new BigDecimal(1));
        assertEquals(re, new BigDecimal("18.23"));

        BigInteger ret = MathUtil.divide(new BigInteger("10"), new BigInteger("2"));
        assertEquals(ret, new BigInteger("5"));
        message = "";
        try {
            MathUtil.divide((BigInteger) null, null);
        } catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals(message, "BigInteger divide by zero");
        ret = MathUtil.divide(null, new BigInteger("10"));
        assertEquals(ret.intValue(), 0);
        ret = MathUtil.divide(new BigInteger("10"), new BigInteger("3"));
        assertEquals(ret, new BigInteger("3"));
        ret = MathUtil.divide(new BigInteger("18"), new BigInteger("1"));
        assertEquals(ret, new BigInteger("18"));

    }

    @Test
    public void formatDecimalToString() throws Exception {
        BigDecimal pi = new BigDecimal("3.1415");
        String re = MathUtil.formatDecimalToString(pi, "0");
        assertEquals(re, "3");

        re = MathUtil.formatDecimalToString(pi, "0.00");
        assertEquals(re, "3.14");
        re = MathUtil.formatDecimalToString(pi, "00.00000");
        assertEquals(re, "03.14150");

        pi = new BigDecimal("13.1415");
        re = MathUtil.formatDecimalToString(pi, "#");
        assertEquals(re, "13");
        pi = new BigDecimal("1113.14");
        re = MathUtil.formatDecimalToString(pi, ",###");
        assertEquals(re, "1,113");
        re = MathUtil.formatDecimalToString(null, ",###");
        assertNull(re, null);
    }


    @Test
    public void multiply() throws Exception {
        BigDecimal re = MathUtil.multiply(new BigDecimal("10.01"), new BigDecimal("2"));
        assertEquals(re, new BigDecimal("20.02"));
        re = MathUtil.multiply((BigDecimal) null, null);
        assertEquals(re, BigDecimal.ZERO);
        re = MathUtil.multiply(new BigDecimal("10.23"), null);
        assertEquals(re, BigDecimal.ZERO);
        re = MathUtil.multiply(null, new BigDecimal("1"));
        assertEquals(re, BigDecimal.ZERO);

        BigInteger ret = MathUtil.multiply(new BigInteger("10"), new BigInteger("2"));
        assertEquals(ret, new BigInteger("20"));
        ret = MathUtil.multiply((BigInteger) null, null);
        assertEquals(ret, BigInteger.ZERO);
        ret = MathUtil.multiply(new BigInteger("10"), null);
        assertEquals(ret, BigInteger.ZERO);
        ret = MathUtil.multiply(null, new BigInteger("10"));
        assertEquals(ret, BigInteger.ZERO);
    }

    @Test
    public void nextRandomDouble() throws Exception {
        MathUtil.nextRandomDouble(1D, 2D);
        MathUtil.nextRandomDouble(0, 0);

        Throwable t = null;
        try {
            MathUtil.nextRandomDouble(2, 1);
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof IllegalArgumentException);
        assertThat(t.getMessage(), containsString("Start value must be smaller or equal to end value"));

    }

    @Test
    public void nextRandomFloat() throws Exception {
        MathUtil.nextRandomFloat(1f, 2f);
        MathUtil.nextRandomFloat(0, 0);
        Throwable t = null;
        try {
            MathUtil.nextRandomFloat(2, 1);
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof IllegalArgumentException);
        assertThat(t.getMessage(), containsString("Start value must be smaller or equal to end value"));


    }

    @Test
    public void nextRandomInt() throws Exception {
        MathUtil.nextRandomInt(10, 20);
        MathUtil.nextRandomInt(0, 0);
        Throwable t = null;
        try {
            MathUtil.nextRandomInt(2, 1);
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof IllegalArgumentException);
        assertThat(t.getMessage(), containsString("Start value must be smaller or equal to end value"));

    }

    @Test
    public void nextRandomLong() throws Exception {
        MathUtil.nextRandomLong(0, 0);
        MathUtil.nextRandomLong(10, 20);
        Throwable t = null;
        try {
            MathUtil.nextRandomLong(2, 1);
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof IllegalArgumentException);
        assertThat(t.getMessage(), containsString("Start value must be smaller or equal to end value"));
    }

    @Test
    public void subtract() throws Exception {
        BigDecimal re = MathUtil.subtract(new BigDecimal("10.01"), new BigDecimal("2"));
        assertEquals(re, new BigDecimal("8.01"));
        re = MathUtil.subtract((BigDecimal) null, null);
        assertEquals(re, BigDecimal.ZERO);
        re = MathUtil.subtract(new BigDecimal("10.23"), null);
        assertEquals(re, new BigDecimal("10.23"));
        re = MathUtil.subtract(null, new BigDecimal("1"));
        assertEquals(re, new BigDecimal("-1"));

        BigInteger ret = MathUtil.subtract(new BigInteger("10"), new BigInteger("2"));
        assertEquals(ret, new BigInteger("8"));
        ret = MathUtil.subtract((BigInteger) null, null);
        assertEquals(ret, BigInteger.ZERO);
        ret = MathUtil.subtract(new BigInteger("10"), null);
        assertEquals(ret, new BigInteger("10"));
        ret = MathUtil.subtract(null, new BigInteger("10"));
        assertEquals(ret, new BigInteger("-10"));
    }

    @Test
    public void rounding() throws Exception {

        BigDecimal re = MathUtil.rounding(null, 0);
        assertEquals(re, BigDecimal.ZERO);
        re = MathUtil.rounding(new BigDecimal("10.01"), 0);
        assertEquals(re, new BigDecimal("10"));
        re = MathUtil.rounding(new BigDecimal("10.01"), 1);
        assertEquals(re, new BigDecimal("10.0"));
        re = MathUtil.rounding(new BigDecimal("10.0144"), 3);
        assertEquals(re, new BigDecimal("10.014"));

        re = MathUtil.rounding(new BigDecimal("10.0145"), 3);
        assertEquals(re, new BigDecimal("10.015"));
    }


    @Test
    public void toBigDecimal() throws Exception {
        assertEquals(MathUtil.toBigDecimal(""), new BigDecimal(0));
        assertEquals(MathUtil.toBigDecimal(null), new BigDecimal(0));
        assertEquals(MathUtil.toBigDecimal("123"), new BigDecimal(123));
        assertEquals(MathUtil.toBigDecimal("12.1231"), new BigDecimal("12.1231"));
        assertEquals(MathUtil.toBigDecimal("-12.123"), new BigDecimal("-12.123"));

        Throwable t = null;
        try {
            MathUtil.toBigDecimal("adsf");
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof NumberFormatException);


    }

    @Test
    public void toBigInteger() throws Exception {
        assertEquals(MathUtil.toBigInteger(""), new BigInteger("0"));
        assertEquals(MathUtil.toBigInteger(null), new BigInteger("0"));
        assertEquals(MathUtil.toBigInteger("123"), new BigInteger("123"));
        Throwable t = null;
        try {
            MathUtil.toBigInteger("adsf");
        } catch (Exception ex) {
            t = ex;
        }
        assertTrue(t instanceof NumberFormatException);

    }

    @Test
    public void toDouble() throws Exception {
        assertEquals(MathUtil.toDouble(""), new Double(0));
        assertEquals(MathUtil.toDouble(null), new Double(0));
        assertEquals(MathUtil.toDouble("123.1"), new Double("123.1"));
        assertEquals(MathUtil.toDouble("asdf"), new Double("0.0"));

    }

    @Test
    public void toFloat() throws Exception {
        assertEquals(MathUtil.toFloat(""), new Float(0));
        assertEquals(MathUtil.toFloat(null), new Float(0));
        assertEquals(MathUtil.toFloat("123.1"), new Float("123.1"));
        assertEquals(MathUtil.toFloat("asdf"), new Float("0.0"));

    }

    @Test
    public void toInteger() throws Exception {
        assertEquals(MathUtil.toInteger(""), new Integer(0));
        assertEquals(MathUtil.toInteger(null), new Integer(0));
        assertEquals(MathUtil.toInteger("123"), new Integer("123"));
        assertEquals(MathUtil.toInteger("asdf"), new Integer("0"));
    }

    @Test
    public void toLong() throws Exception {
        assertEquals(MathUtil.toLong(""), new Long(0));
        assertEquals(MathUtil.toLong(null), new Long(0));
        assertEquals(MathUtil.toLong("123"), new Long("123"));
        assertEquals(MathUtil.toLong("asdf"), new Long("0"));
    }
}