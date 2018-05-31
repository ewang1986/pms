package com.csg.sone.base.util;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * <p> Description:  MapUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class MapUtil {

    /**
     * <p>Gets a Object from a map in a null-safe manner.
     * </p>
     *
     * @param map
     * @param key
     * @return
     */
    public static <T> T get(Map map, Object key) {
        if (MapUtil.isEmpty(map)) {
            return null;
        } else {
            return (T) map.get(key);
        }
    }

    /**
     * <p>Null-safe check if the specified map is empty.
     * </p>
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * <p>Null-safe check if the specified map is notEmpty.
     * </p>
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map map) {
        return MapUtils.isNotEmpty(map);
    }
}
