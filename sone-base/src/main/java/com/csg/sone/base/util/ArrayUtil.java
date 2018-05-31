package com.csg.sone.base.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Description:  ArrayUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author Duyang
 * @version 1.0
 */
public class ArrayUtil {
    /**
     * An empty immutable {@code Object} array.
     */
    public static final Object[] EMPTY_OBJECT_ARRAY = ArrayUtils.EMPTY_OBJECT_ARRAY;
    /**
     * An empty immutable {@code Class} array.
     */
    public static final Class<?>[] EMPTY_CLASS_ARRAY = ArrayUtils.EMPTY_CLASS_ARRAY;
    /**
     * An empty immutable {@code String} array.
     */
    public static final String[] EMPTY_STRING_ARRAY = ArrayUtils.EMPTY_STRING_ARRAY;
    /**
     * An empty immutable {@code long} array.
     */
    public static final long[] EMPTY_LONG_ARRAY = ArrayUtils.EMPTY_LONG_ARRAY;
    /**
     * An empty immutable {@code Long} array.
     */
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
    /**
     * An empty immutable {@code int} array.
     */
    public static final int[] EMPTY_INT_ARRAY = ArrayUtils.EMPTY_INT_ARRAY;
    /**
     * An empty immutable {@code Integer} array.
     */
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
    /**
     * An empty immutable {@code short} array.
     */
    public static final short[] EMPTY_SHORT_ARRAY = ArrayUtils.EMPTY_SHORT_ARRAY;
    /**
     * An empty immutable {@code Short} array.
     */
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY;
    /**
     * An empty immutable {@code byte} array.
     */
    public static final byte[] EMPTY_BYTE_ARRAY = ArrayUtils.EMPTY_BYTE_ARRAY;
    /**
     * An empty immutable {@code Byte} array.
     */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
    /**
     * An empty immutable {@code double} array.
     */
    public static final double[] EMPTY_DOUBLE_ARRAY = ArrayUtils.EMPTY_DOUBLE_ARRAY;
    /**
     * An empty immutable {@code Double} array.
     */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
    /**
     * An empty immutable {@code float} array.
     */
    public static final float[] EMPTY_FLOAT_ARRAY = ArrayUtils.EMPTY_FLOAT_ARRAY;
    /**
     * An empty immutable {@code Float} array.
     */
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY;
    /**
     * An empty immutable {@code boolean} array.
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
    /**
     * An empty immutable {@code Boolean} array.
     */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
    /**
     * An empty immutable {@code char} array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = ArrayUtils.EMPTY_CHAR_ARRAY;
    /**
     * An empty immutable {@code Character} array.
     */
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY;

    /**
     * The index value when an element is not found in a list or array.
     */
    public static final int INDEX_NOT_FOUND = ArrayUtils.INDEX_NOT_FOUND;

    /**
     * <p>Adds all the elements of the given arrays into a new array.
     * </p>
     * <pre>
     * ArrayUtil.addAll(null, null)     = null
     * ArrayUtil.addAll(array1, null)   = cloned copy of array1
     * ArrayUtil.addAll(array1)   = cloned copy of array1
     * ArrayUtil.addAll(null, array2)   = cloned copy of array2
     * ArrayUtil.addAll([], [])         = []
     * ArrayUtil.addAll([null], [null]) = [null, null]
     * ArrayUtil.addAll(["a", "b", "c"], ["1", "2", "3"]) = ["a", "b", "c", "1", "2", "3"]
     * ArrayUtil.addAll(["a", "b", "c"], "1", "2", "3") = ["a", "b", "c", "1", "2", "3"]
     * </pre>
     *
     * @param array1
     * @param array2
     * @param <T>
     * @return new array
     */
    public static <T> T[] addAll(T[] array1, T... array2) {
        return ArrayUtils.addAll(array1, array2);
    }

    /**
     * <p>Returns a fixed-size list backed by the specified array.
     * </p>
     * <pre>
     * ArrayUtil.asList(null)     = null
     * ArrayUtil.asList(new Object[]{}) = new ArrayList()
     * ArrayUtil.asList(new Object[]{"a", "b", "c"}) = new ArrayList("a", "b", "c")
     * </pre>
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(T[] arr) {
        if (ArrayUtil.isEmpty(arr)) {
            return new ArrayList<T>();
        } else {
            return Arrays.asList(arr);
        }
    }

    /**
     * <p>Shallow clones an array returning a typecast result and handling.
     * </p>
     * <pre>
     * ArrayUtil.clone(null) = null
     * ArrayUtil.clone(int[]{}) =int[]{}
     * ArrayUtil.clone(long[]{}) =long[]{}
     * ArrayUtil.clone(short[]{}) =short[]{}
     * ArrayUtil.clone(char[]{}) =char[]{}
     * ArrayUtil.clone(byte[]{}) =byte[]{}
     * ArrayUtil.clone(double[]{}) =double[]{}
     * ArrayUtil.clone(float[]{}) =float[]{}
     * ArrayUtil.clone(boolean[]{}) =boolean[]{}
     * </pre>
     *
     * @param array
     * @return
     */
    public static <T> T[] clone(T[] array) {
        return ArrayUtils.clone(array);
    }


    /**
     * <p>Checks if the object is in the given array.
     * </p>
     * <pre>
     * ArrayUtil.contains(null, "b"), false)  =false
     * ArrayUtil.contains(new Object[]{"a", "b", "c"}, "b")  =true
     * ArrayUtil.contains(new Object[]{"a", "b", "c"}, null)  =false
     * ArrayUtil.contains(new Object[]{}, "b")  =false
     * ArrayUtil.contains(ArrayUtil.contains(new Object[]{"a", "b", "c"}, "d")  =false
     * ArrayUtil.contains(ArrayUtil.contains(new Object[]{"a", "b", "c"}, new String("b"))  =true
     * </pre>
     *
     * @param array
     * @param objectToFind
     * @return boolean
     */
    public static boolean contains(Object[] array, Object objectToFind) {
        return ArrayUtils.contains(array, objectToFind);
    }

    /**
     * <p>Returns the length of the specified array.
     * </p>
     * <pre>
     * ArrayUtil.getLength(null)            = 0
     * ArrayUtil.getLength([])              = 0
     * ArrayUtil.getLength([null])          = 1
     * ArrayUtil.getLength([true, false])   = 2
     * ArrayUtil.getLength([1, 2, 3])       = 3
     * ArrayUtil.getLength(["a", "b", "c"]) = 3
     * </pre>
     *
     * @param array
     * @return
     */
    public static int getLength(Object[] array) {
        return ArrayUtils.getLength(array);
    }


    /**
     * <p>Finds the index of the given object in the array.
     * </p>
     * <pre>
     * ArrayUtil.indexOf(null, null) = -1
     * ArrayUtil.indexOf(null, "a") = -1
     * ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "a") = 0
     * ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "b") = 1
     * ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "d") = -1
     * ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, null) = -1
     * ArrayUtil.indexOf(new Object[]{null}, null)) = 0
     * ArrayUtil.indexOf(new Object[]{""}, "") = 0
     * ArrayUtil.indexOf(new Object[]{}, null) = -1
     * ArrayUtil.indexOf(new Object[]{"a", null, "b", "c"}, null) = 1
     * ArrayUtil.indexOf(new Object[]{"a", "", "b", "c"}, "") = 1
     * </pre>
     *
     * @param array
     * @param objectToFind
     * @return
     */
    public static int indexOf(Object[] array, Object objectToFind) {
        return ArrayUtils.indexOf(array, objectToFind);
    }

    /**
     * <p>Insert elements into an array at the given index (starting from zero).
     * </p>
     * <pre>
     * ArrayUtil.insert(0，null, null)     = null
     * ArrayUtil.insert(0，array1, null)   = cloned copy of array1
     * ArrayUtil.insert(0，array1)   = cloned copy of array1
     * ArrayUtil.insert(0，null, array2)   = null
     * ArrayUtil.insert(0，[], [])         = []
     * ArrayUtil.insert(0，[null], [null]) = [null, null]
     * ArrayUtil.insert(0，["a", "b", "c"], ["1", "2", "3"]) = ["1", "2", "3", "a", "b", "c"]
     * ArrayUtil.insert(0，["a", "b", "c"], "1", "2", "3") = ["1", "2", "3", "a", "b", "c"]
     * </pre>
     *
     * @param <T>
     * @param index
     * @param array
     * @param values
     * @return a new array
     */
    public static <T> T[] insert(int index, T[] array, T... values) {
        return ArrayUtils.insert(index, array, values);
    }

    /**
     * <p>Checks if an array of Objects is empty or.
     * </p>
     * <pre>
     * ArrayUtil.isEmpty(null) =true
     * ArrayUtil.isEmpty(new Object[]{}) =true
     * ArrayUtil.isEmpty(new Object[]{""}) =false
     * ArrayUtil.isEmpty(new Object[]{1,2,3}) =false
     * </pre>
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

    /**
     * <p>Checks if an array of Objects is not empty and not .
     * </p>
     * <pre>
     * ArrayUtil.isNotEmpty(null) =false
     * ArrayUtil.isNotEmpty(new Object[]{}) =false
     * ArrayUtil.isNotEmpty(new Object[]{""}) =true
     * ArrayUtil.isNotEmpty(new Object[]{1,2,3}) =true
     * </pre>
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return ArrayUtils.isNotEmpty(array);
    }

    /**
     * <p>Finds the last index of the given object within the array.
     * </p>
     * <pre>
     * ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "a") = 0
     * ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "b") = 1
     * ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "d") = -1
     * ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, null) = -1
     * ArrayUtil.lastIndexOf(new Object[]{null}, null)) = 0
     * ArrayUtil.lastIndexOf(new Object[]{""}, "") = 0
     * ArrayUtil.lastIndexOf(new Object[]{}, null) = -1
     * ArrayUtil.lastIndexOf(new Object[]{"a", null, "b", "c"}, null) = 1
     * ArrayUtil.lastIndexOf(new Object[]{"a", "", "b", "c"}, "") = 1
     * </pre>
     *
     * @param array
     * @param objectToFind
     * @return
     */
    public static int lastIndexOf(Object[] array, Object objectToFind) {
        return ArrayUtils.lastIndexOf(array, objectToFind);
    }

    /**
     * <p>Removes the element at the specified position from the specified array.
     * </p>
     * <pre>
     * ArrayUtil.removeByIndex(["a"], 0)           = []
     * ArrayUtil.removeByIndex(["a"])           = ["a"]
     * ArrayUtil.removeByIndex(["a", "b"], 0)      = ["b"]
     * ArrayUtil.removeByIndex(["a", "b"], 1)      = ["a"]
     * ArrayUtil.removeByIndex(["a", "b", "c"], 1) = ["a", "c"]
     * ArrayUtil.removeByIndex(["a", "b", "c"], 0,1) = ["c"]
     * ArrayUtil.removeByIndex(["a", "b", "c"], 0,1,2) = []
     * </pre>
     *
     * @param <T>
     * @param array
     * @param indices
     * @return
     */
    public static <T> T[] removeByIndex(T[] array, int... indices) {
        return ArrayUtils.removeAll(array, indices);
    }


    /**
     * <p>Removes the occurrences of the specified element from the specified array.
     * </p>
     * <pre>
     * ArrayUtil.removeByElement(null, "a")            = null
     * ArrayUtil.removeByElement([], "a")              = []
     * ArrayUtil.removeByElement(["a"], "b")           = ["a"]
     * ArrayUtil.removeByElement(["a", "b"], "a")      = ["b"]
     * ArrayUtil.removeByElement(["a", "b", "a"], "a")      = ["b"]
     * </pre>
     *
     * @param <T>
     * @param array
     * @param element
     * @return
     */
    public static <T> T[] removeByElement(T[] array, T element) {
        return ArrayUtils.removeAllOccurences(array, element);
    }

    /**
     * <p>Reverses the order of the given array.
     * </p>
     * <pre>
     * ArrayUtil.reverse(null)  =null
     * ArrayUtil.reverse([""])  =[""]
     * ArrayUtil.reverse([null])  =[null]
     * ArrayUtil.reverse(["a", "b","c"])  =["c", "b","a"]
     * </pre>
     *
     * @param arrays
     */
    public static <T> T[] reverse(T[] arrays) {
        ArrayUtils.reverse(arrays);
        return arrays;
    }

    /**
     * <p>Produces a new array containing the elements from the start to the end.
     * </p>
     * <pre>
     * ArrayUtil.subArray(null, 0) =null
     * ArrayUtil.subArray(new Object[]{}, 0)) =new Object[]{}
     * ArrayUtil.subArray(new Object[]{""}, 0) =new Object[]{""}
     * ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0) =new Object[]{"a","b","c"}
     * ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 1) =new Object[]{"b","c"}
     * </pre>
     *
     * @param <T>
     * @param array
     * @param start
     * @return
     */
    public static <T> T[] subArray(T[] array, int start) {
        if (ArrayUtil.isEmpty(array)) {
            return array;
        } else {
            return ArrayUtils.subarray(array, start, ArrayUtil.getLength(array));
        }
    }


    /**
     * <p>Produces a new array containing the elements between the start and end indices.
     * </p>
     * <pre>
     * ArrayUtil.subArray(null, 0, 1) =null
     * ArrayUtil.subArray(new Object[]{}, 0, 1)) =new Object[]{}
     * ArrayUtil.subArray(new Object[]{""}, 0, 1) =new Object[]{""}
     * ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0, 1) =new Object[]{"a"}
     * ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0, 2) =new Object[]{"a", "b"}
     * ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 1, 2) =new Object[]{"b"}
     * </pre>
     *
     * @param <T>
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static <T> T[] subArray(T[] array, int start, int end) {
        return ArrayUtils.subarray(array, start, end);
    }
}
