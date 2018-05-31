package com.csg.sone.base.util;

import org.apache.commons.lang3.SerializationUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p> Description:  ObjectUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author Duyang
 * @version 1.0
 */
public class ObjectUtil {
    /**
     * <p>Create Class Object by class name.
     * </p>
     *
     * @param clazzName
     * @return
     */
    public static Class createClass(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>create Object By class obj or class name.
     * </p>
     * <pre>
     * ObjectUtil.createObject("com.csg.sone.base.bean.SourceBean")
     * ObjectUtil.createObject(SourceBean.class)
     * </pre>
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createObject(Object clazz) {
        try {
            if (clazz instanceof String) {
                return (T) Class.forName((String) clazz).newInstance();
            } else {
                return (T) (((Class) clazz).newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Deep clone an  Object using serialization.
     * </p>
     * <pre>
     * ObjectUtil.deepClone(null)  =null
     * ObjectUtil.deepClone("")  =""
     * ObjectUtil.deepClone(array)
     * ObjectUtil.deepClone(map)
     * ObjectUtil.deepClone(list)
     * ObjectUtil.deepClone(bean)
     * </pre>
     *
     * @param <T>
     * @param object
     * @return the cloned object
     */
    public static <T extends Serializable> T deepClone(T object) {
        return SerializationUtils.clone(object);
    }

    /**
     * <p>Deserializes a single Object from an array of bytes.
     * </p>
     * <pre>
     * ObjectUtil.deserialize(byte[])
     * </pre>
     *
     * @param objectData
     * @return the deserialized object
     */
    public static Object deserialize(byte[] objectData) {
        return SerializationUtils.deserialize(objectData);
    }

    /**
     * <p>Deserializes an Object from the specified stream.
     * </p>
     * <pre>
     * ObjectUtil.deserialize(InputStream)
     * </pre>
     *
     * @param <T>
     * @param inputStream
     * @return the deserialized object
     */
    public static <T> T deserialize(InputStream inputStream) {
        return SerializationUtils.deserialize(inputStream);
    }

    /**
     * <p>Check if an object is a string.
     * </p>
     * <pre>
     * ObjectUtil.isString(null) =false
     * ObjectUtil.isString("") =true
     * ObjectUtil.isString("a") =true
     * ObjectUtil.isString(1) =false
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isString(Object obj) {
        return obj instanceof String;
    }

    /**
     * <p>Check if an object is a Integer.
     * </p>
     * <pre>
     * ObjectUtil.isInteger(null) =false
     * ObjectUtil.isInteger("") =false
     * ObjectUtil.isInteger("a") =false
     * ObjectUtil.isInteger(1) =true
     * ObjectUtil.isInteger(new Integer(1)) =true
     * ObjectUtil.isInteger(1L) =false
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isInteger(Object obj) {
        return obj instanceof Integer;
    }

    /**
     * <p>Check if an object is a Long.
     * </p>
     * <pre>
     * ObjectUtil.isLong(null) =false
     * ObjectUtil.isLong("") =false
     * ObjectUtil.isLong("a") =false
     * ObjectUtil.isLong(1L) =true
     * ObjectUtil.isLong(new Long(1)) =true
     * ObjectUtil.isInteger(1) =false
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isLong(Object obj) {
        return obj instanceof Long;
    }

    /**
     * <p>Check if an object is a Float.
     * </p>
     * <pre>
     * ObjectUtil.isFloat(null) =false
     * ObjectUtil.isFloat("") =false
     * ObjectUtil.isFloat("a") =false
     * ObjectUtil.isFloat(1.0f) =true
     * ObjectUtil.isFloat(new Float(1.0f)) =true
     * ObjectUtil.isFloat(1.0) =false
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isFloat(Object obj) {
        return obj instanceof Float;
    }

    /**
     * <p>Check if an object is a Double.
     * </p>
     * <pre>
     * ObjectUtil.isDouble(null), false
     * ObjectUtil.isDouble(""), false
     * ObjectUtil.isDouble("a"), false
     * ObjectUtil.isDouble(1.0), true
     * ObjectUtil.isDouble(1.0d), true
     * ObjectUtil.isDouble(new Double(1.0)), true
     * ObjectUtil.isDouble(1.0f), false
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isDouble(Object obj) {
        return obj instanceof Double;
    }

    /**
     * <p>Check if an object is a BigDecimal.
     * </p>
     * <pre>
     * ObjectUtil.isBigDecimal(null), false
     * ObjectUtil.isBigDecimal("a"), false
     * ObjectUtil.isBigDecimal(1), false
     * ObjectUtil.isBigDecimal(1L), false
     * ObjectUtil.isBigDecimal(1.0f), false
     * ObjectUtil.isBigDecimal(1.0d), false
     * ObjectUtil.isBigDecimal(new BigDecimal("1.0")), true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isBigDecimal(Object obj) {
        return obj instanceof BigDecimal;
    }

    /**
     * <p>Check if an object is a BigDecimal.
     * </p>
     * <pre>
     * ObjectUtil.isBigInteger(null), false
     * ObjectUtil.isBigInteger("a"), false
     * ObjectUtil.isBigInteger(1), false
     * ObjectUtil.isBigInteger(1L), false
     * ObjectUtil.isBigInteger(1.0f), false
     * ObjectUtil.isBigInteger(1.0d), false
     * ObjectUtil.isBigInteger(new BigInteger("1")), true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isBigInteger(Object obj) {
        return obj instanceof BigInteger;
    }

    /**
     * <p>Check if an object is a Date.
     * </p>
     * <pre>
     * ObjectUtil.isDate(null) =false
     * ObjectUtil.isDate("a") =false
     * ObjectUtil.isDate(new Date()) =true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isDate(Object obj) {
        return obj instanceof Date;
    }

    /**
     * <p>Check if an object is a Array.
     * </p>
     * <pre>
     * ObjectUtil.isArray(null) =false
     * ObjectUtil.isArray("a") =false
     * ObjectUtil.isArray(new Object[]{}) =true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        } else {
            return obj.getClass().isArray();
        }
    }

    /**
     * <p>Check if an object is a List.
     * </p>
     * <pre>
     * ObjectUtil.isList(null) =false
     * ObjectUtil.isList("a") =false
     * ObjectUtil.isList(new ArrayList()) =true
     * ObjectUtil.isList(new LinkedList()) =true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isList(Object obj) {
        return obj instanceof List;
    }

    /**
     * <p>Check if an object is a Map.
     * </p>
     * <pre>
     * ObjectUtil.isMap(null) =false
     * ObjectUtil.isMap("a") =false
     * ObjectUtil.isMap(new HashMap()) =true
     * ObjectUtil.isMap(new Hashtable()) =true
     * ObjectUtil.isMap(new LinkedHashMap()) =true
     * ObjectUtil.isMap(new IdentityHashMap()) =true
     * ObjectUtil.isMap(new TreeMap()) =true
     * ObjectUtil.isMap(new WeakHashMap()) =true
     * ObjectUtil.isMap(new ConcurrentHashMap()) =true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isMap(Object obj) {
        return obj instanceof Map;
    }

    /**
     * <p>Check if an object is a Set.
     * </p>
     * <pre>
     * ObjectUtil.isMap(null) =false
     * ObjectUtil.isMap("a") =false
     * ObjectUtil.isSet(new HashSet()) =true
     * ObjectUtil.isSet(new TreeSet()) =true
     * ObjectUtil.isSet(new LinkedHashSet()) =true
     * </pre>
     *
     * @param obj
     * @return boolean
     */
    public static boolean isSet(Object obj) {
        return obj instanceof Set;
    }

    /**
     * <p>Serializes an Object to a byte array for storage/serialization.
     * </p>
     * <pre>
     * ObjectUtil.deserialize(Serializable)
     * </pre>
     *
     * @param obj the object to serialize to bytes
     * @return a byte[] with the converted Serializable
     */
    public static byte[] serialize(Serializable obj) {
        return SerializationUtils.serialize(obj);
    }

    /**
     * <p>Serializes an Object to the specified stream.
     * </p>
     * <pre>
     * ObjectUtil.deserialize(Serializable,OutputStream)
     * </pre>
     *
     * @param obj          the object to serialize to bytes, may be null
     * @param outputStream the stream to write to, must not be null
     */
    public static void serialize(Serializable obj, OutputStream outputStream) {
        SerializationUtils.serialize(obj, outputStream);
    }

    /**
     * <p>Print Object String for Debug.
     * </p>
     * <pre>
     * ObjectUtil.toString(null) =null
     * ObjectUtil.toString("") =""
     * ObjectUtil.toString(array)
     * ObjectUtil.toString(map)
     * ObjectUtil.toString(list)
     * ObjectUtil.toString(bean)
     * </pre>
     *
     * @param object
     */
    public static final String toString(Object object) {
        return JSONUtil.format(object);
    }
}
