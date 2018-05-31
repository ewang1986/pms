package com.csg.sone.base.util;

import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * <p> Description:  ListUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class ListUtil {

    /**
     * <p>Gets a element from a List in a null-safe manner.
     * </p>
     *
     * @param list
     * @param index
     * @return
     */
    public static <T> T get(List list, int index) {
        if (ListUtil.isEmpty(list)) {
            return null;
        } else {
            return (T) list.get(index);
        }
    }

    /**
     * <p>Null-safe check if the specified list is empty.
     * </p>
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    /**
     * <p>Null-safe check if the specified list is not Empty.
     * </p>
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(List list) {
        return !ListUtil.isEmpty(list);
    }

    /**
     * <p>Returns consecutive sublists of a list, each of the same size (the final list may be smaller).</p>
     *
     * @param list
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        return ListUtils.partition(list, size);
    }
}
