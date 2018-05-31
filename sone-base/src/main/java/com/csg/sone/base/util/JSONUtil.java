package com.csg.sone.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * <p> Description:  JSONUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public class JSONUtil {
    /**
     * <p>对象转化为JSON字符串,支持bean、map、list，可多层嵌套</p>
     *
     * @param obj
     * @return
     */
    public static String format(Object obj) {
        if (obj != null) {
            return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.UseISO8601DateFormat,
                    SerializerFeature.PrettyFormat,
                    SerializerFeature.DisableCircularReferenceDetect);
        } else {
            return StringUtil.EMPTY_STR;
        }
    }

    /**
     * <p>JSON字符串对象转化Map.</p>
     *
     * @param jsonStr
     * @return
     */
    public static Map parseMap(String jsonStr) {
        return JSON.parseObject(jsonStr);
    }

    /**
     * <p>JSON字符串对象转化List.</p>
     *
     * @param jsonStr
     * @return
     */
    public static List parseList(String jsonStr) {
        return JSON.parseArray(jsonStr);
    }

    /**
     * <p>JSON字符串对象转化Bean.</p>
     *
     * @param jsonStr
     * @return
     */
    public static <T> T parseBean(String jsonStr, Class<T> beanClass) {
        return JSON.parseObject(jsonStr, beanClass);
    }

    /**
     * <p>JSON字符串对象转化BeanList.</p>
     *
     * @param jsonStr
     * @return
     */
    public static <T> List<T> parseBeanList(String jsonStr, Class<T> beanClass) {
        return JSON.parseArray(jsonStr, beanClass);
    }
}
