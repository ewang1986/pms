package com.csg.sone.base.util;

import java.util.Set;

/**
 * <p> Description:  SetUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class SetUtil {
    /**
     * <p>Null-safe check if the specified set is empty.
     * </p>
     *
     * @param set
     * @return
     */
    public static boolean isEmpty(Set set) {
        return set == null || set.isEmpty();
    }

    /**
     * <p>Null-safe check if the specified map is notEmpty.
     * </p>
     *
     * @param set
     * @return
     */
    public static boolean isNotEmpty(Set set) {
        return !SetUtil.isEmpty(set);
    }


}
