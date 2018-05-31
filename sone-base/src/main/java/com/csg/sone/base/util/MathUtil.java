package com.csg.sone.base.util;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * <p> Description:  MathUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public final class MathUtil {


    /**
     * <p>Object对象转换成你需要的数字类型.
     * </p>
     * <per>
     * MathUtil.asNumber(null,*) = 0
     * MathUtil.asNumber("",*) = 0
     * MathUtil.asNumber("123",int.Class) = 123
     * </per>
     *
     * @param value
     * @param c
     * @return
     */
    public static <V> V asNumber(Object value, Class c) {
        if (value == null) {
            return null;
        }
        String str = value.toString();
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        if (c.getName().equals("int") || c.getName().equals("java.lang.Integer")) {
            return (V) MathUtil.toInteger(str);
        }

        if (c.getName().equals("double") || c.getName().equals("java.lang.Double")) {
            return (V) MathUtil.toDouble(str);
        }
        if (c.getName().equals("long") || c.getName().equals("java.lang.Long")) {
            return (V) MathUtil.toLong(str);
        }
        if (c.getName().equals("float") || c.getName().equals("java.lang.Float")) {
            return (V) MathUtil.toFloat(str);
        }
        if (c.getName().equals("java.math.BigDecimal")) {
            return (V) MathUtil.toBigDecimal(str);
        }
        if (c.getName().equals("java.math.BigInteger")) {
            return (V) MathUtil.toBigInteger(str);
        }
        return null;
    }

    /**
     * <p>BigDecimal的加法运算.
     * </p>
     * <per>
     * MathUtil.add(null,null) = 0
     * MathUtil.add(10,null) = 10
     * MathUtil.add(null,10) = 10
     * MathUtil.add(10,10) = 20
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null || b2.compareTo(BigDecimal.ZERO) == 0) {
            return b1;
        }
        return b1.add(b2);
    }

    /**
     * <p>BigInteger的加法运算.
     * </p>
     * <per>
     * MathUtil.add(null,null) = 0
     * MathUtil.add(10,null) = 10
     * MathUtil.add(null,10) = 10
     * MathUtil.add(10,10) = 20
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigInteger add(BigInteger b1, BigInteger b2) {
        if (b1 == null) {
            b1 = BigInteger.ZERO;
        }
        if (b2 == null || b2.compareTo(BigInteger.ZERO) == 0) {
            return b1;
        }
        return b1.add(b2);
    }


    /**
     * <p>BigDecimal的除法运算,保留2位小数.
     * </p>
     * <per>
     * MathUtil.divide(*,null) = Exception
     * MathUtil.divide(10,3) = 3.33
     * MathUtil.divide(null,10) = 0.00
     * MathUtil.divide(10,10) = 1.00
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal divide(BigDecimal b1, BigDecimal b2) {

        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * <p>BigInteger的除法运算.
     * </p>
     * <per>
     * MathUtil.divide(*,null) = Exception
     * MathUtil.divide(null,10) = 0
     * MathUtil.divide(10,10) = 1
     * MathUtil.divide(10,3) = 3
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigInteger divide(BigInteger b1, BigInteger b2) {

        return b1.divide(b2);
    }

    /**
     * <p>格式化BigDecimal.
     * </p>
     * <pre>
     *   MathUtil.formatDecimalToString(3.14,"0") = 3
     *   MathUtil.formatDecimalToString(3.14,"0.00") = 3.14
     *   MathUtil.formatDecimalToString(3.14,"00.000") = 03.140
     *   MathUtil.formatDecimalToString(3.1415,"00.000") = 03.142
     *   MathUtil.formatDecimalToString(3.1414,"00.000") = 03.141
     *   MathUtil.formatDecimalToString(13.1414,"#") = 13
     *   MathUtil.formatDecimalToString(1314.14,",###") = 1,314
     * </pre>
     *
     * @param input   原始数据
     * @param pattern eg:##,##0.000
     * @return 格式化之后的字符串
     */
    public static String formatDecimalToString(BigDecimal input, String pattern) {

        if (StringUtil.isEmpty(pattern)) return null;
        if (input != null)
            return new DecimalFormat(pattern).format(input);
        else return null;

    }

    /**
     * <p>BigDecimal的乘法运算.
     * </p>
     * <per>
     * MathUtil.multiply(*,null) = 0
     * MathUtil.multiply(null,*) = 0
     * MathUtil.multiply(10,10) = 100
     * MathUtil.multiply(0.1,0.3) = 0.03
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal multiply(BigDecimal b1, BigDecimal b2) {
        return b1.multiply(b2);
    }

    /**
     * <p>BigInteger的乘法运算.
     * </p>
     * <per>
     * MathUtil.multiply(*,null) = 0
     * MathUtil.multiply(null,*) = 0
     * MathUtil.multiply(10,10) = 100
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigInteger multiply(BigInteger b1, BigInteger b2) {
        return b1.multiply(b2);
    }


    /**
     * <p>Returns a random double within the specified range.
     * </p>
     * <per>
     * MathUtil.nextRandomDouble(10D,20D) = random double 10.00 - 20.00
     * MathUtil.nextRandomDouble(20D,10D) = Exception   Start value must be smaller or equal to end value
     * MathUtil.nextRandomDouble(-1,2) = Exception  both non-negative
     * MathUtil.nextRandomDouble(-2,-1) = Exception  both non-negative
     * </per>
     *
     * @param startInclusive
     * @param endInclusive
     * @return the random double
     */
    static double nextRandomDouble(double startInclusive, double endInclusive) {
        return RandomUtils.nextDouble(startInclusive, endInclusive);
    }

    /**
     * <p>Returns a random float within the specified range.
     * </p>
     * <per>
     * MathUtil.nextRandomFloat(10f,20f) = random double 10.00 - 20.00
     * MathUtil.nextRandomFloat(20f,10f) = Exception   Start value must be smaller or equal to end value
     * MathUtil.nextRandomFloat(-1,2) = Exception  Both range values must be non-negative.
     * MathUtil.nextRandomFloat(-2,-1) = Exception  Both range values must be non-negative.
     * </per>
     *
     * @param startInclusive
     * @param endInclusive
     * @return the random float
     * @throws
     */
    static float nextRandomFloat(float startInclusive, float endInclusive) {
        return RandomUtils.nextFloat(startInclusive, endInclusive);
    }

    /**
     * <p>Returns a random int within the specified range.
     * </p>
     * <per>
     * MathUtil.nextRandomInt(10,20) = random double 10- 20
     * MathUtil.nextRandomInt(20,10) = Exception   Start value must be smaller or equal to end value
     * MathUtil.nextRandomInt(-1,2) = Exception  Both range values must be non-negative.
     * MathUtil.nextRandomInt(-2,-1) = Exception  Both range values must be non-negative.
     * </per>
     *
     * @param startInclusive
     * @param endInclusive
     * @return the random int
     */
    static int nextRandomInt(int startInclusive, int endInclusive) {
        return RandomUtils.nextInt(startInclusive, endInclusive);
    }

    /**
     * <p>Returns a random long within the specified range.
     * </p>
     * <per>
     * MathUtil.nextRandomLong(10L,20L) = random double 10- 20
     * MathUtil.nextRandomLong(20L,10L) = Exception   Start value must be smaller or equal to end value
     * MathUtil.nextRandomLong(-1,2) = Exception  Both range values must be non-negative.
     * MathUtil.nextRandomLong(-2,-1) = Exception  Both range values must be non-negative.
     * </per>
     *
     * @param startInclusive
     * @param endInclusive
     * @return the random long
     */
    static long nextRandomLong(long startInclusive, long endInclusive) {
        return RandomUtils.nextLong(startInclusive, endInclusive);
    }


    /**
     * <p>BigDecimal的减法运算.
     * </p>
     * <per>
     * MathUtil.subtract(*,null) = *
     * MathUtil.subtract(null,10) = -10
     * MathUtil.subtract(10,10) = 0
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal subtract(BigDecimal b1, BigDecimal b2) {

        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null || b2.compareTo(BigDecimal.ZERO) == 0) {
            return b1;
        }

        return b1.subtract(b2);
    }

    /**
     * <p>BigInteger的减法运算.
     * </p>
     * <per>
     * MathUtil.subtract(*,null) = *
     * MathUtil.subtract(null,10) = -10
     * MathUtil.subtract(10,10) = 0
     * </per>
     *
     * @param b1
     * @param b2
     * @return
     */
    public static BigInteger subtract(BigInteger b1, BigInteger b2) {

        if (b1 == null) {
            b1 = BigInteger.ZERO;
        }
        if (b2 == null || b2.compareTo(BigInteger.ZERO) == 0) {
            return b1;
        }

        return b1.subtract(b2);
    }

    /**
     * <p>BigDecimal的四舍五入运算.
     * </p>
     * <per>
     * MathUtil.rounding(null,*) = 0
     * MathUtil.rounding(3.14,0) = 3
     * MathUtil.rounding(3.14,3) = 3.140
     * MathUtil.rounding(3.1415,2) = 3.14
     * MathUtil.rounding(3.1415,3) = 3.142
     * </per>
     *
     * @param b1
     * @param scale
     * @return
     */
    public static BigDecimal rounding(BigDecimal b1, int scale) {

        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        return b1.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>BigDecimal</code>, returning
     * <code>0.0d</code> if the conversion fails.
     * </p>
     * <per>
     * MathUtil.toBigDecimal(null) = 0
     * MathUtil.toBigDecimal("") = 0
     * MathUtil.toBigDecimal("123.12") = 123.12
     * </per>
     *
     * @param str
     * @return
     */
    static BigDecimal toBigDecimal(String str) {
        if (StringUtil.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(str);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>BigInteger</code>, returning
     * <code>0.0d</code> if the conversion fails.
     * </p>
     * <per>
     * MathUtil.toBigInteger(null) = 0
     * MathUtil.toBigInteger("") = 0
     * MathUtil.toBigInteger("123.12") = 123.12
     * </per>
     *
     * @param str
     * @return
     */
    static BigInteger toBigInteger(String str) {
        if (StringUtil.isEmpty(str)) {
            return BigInteger.ZERO;
        }
        return new BigInteger(str);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>double</code>, returning
     * <code>0.0d</code> if the conversion fails.
     * </p>
     * <pre>
     *  NumberUtil.toDouble(null)   = 0.0d
     *  NumberUtil.toDouble("")     = 0.0d
     *  NumberUtil.toDouble("1.5")  = 1.5d
     *  NumberUtil.toDouble("abc")     = 0.0d
     * </pre>
     *
     * @param str
     * @return
     */
    static Double toDouble(String str) {
        return NumberUtils.toDouble(str);

    }

    /**
     * <p>Convert a <code>String</code> to a <code>float</code>, returning
     * <code>0.0d</code> if the conversion fails.</p>
     * <pre>
     *  NumberUtil.toFloat(null)   = 0.0f
     *  NumberUtil.toFloat("")     = 0.0f
     *  NumberUtil.toFloat("1.5")  = 1.5f
     *  NumberUtil.toFloat("abc")  =  0.0f
     * </pre>
     *
     * @param str
     * @return
     */
    static Float toFloat(String str) {
        return NumberUtils.toFloat(str);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>Integer</code>, returning
     * <code>0.0d</code> if the conversion fails.
     * </p>
     * <pre>
     *  NumberUtil.toInteger(null)   = 0
     *  NumberUtil.toInteger("")     = 0
     *  NumberUtil.toInteger("15")  = 15
     *  NumberUtil.toInteger("abc")  = 0
     * </pre>
     *
     * @param str
     * @return
     */
    static Integer toInteger(String str) {
        return NumberUtils.toInt(str);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>Long</code>, returning
     * <code>0.0d</code> if the conversion fails.
     * </p>
     * <pre>
     *  NumberUtil.toLong(null)   = 0
     *  NumberUtil.toLong("")     = 0
     *  NumberUtil.toLong("15")  = 15L
     *  NumberUtil.toLong("abc")  = 0
     * </pre>
     *
     * @param str
     * @return
     */
    static Long toLong(String str) {
        return NumberUtils.toLong(str);
    }
}
