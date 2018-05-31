package com.csg.sone.base.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * <p> Description:  BeanUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public final class BeanUtil {
    private static Log logger = LogFactory.getLog(BeanUtil.class);

    /**
     * 设置bean对象
     */
    public static void setProperty(Object objBean, String key, Object value) {
        try {
            PropertyUtils.setProperty(objBean, key, value);
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    /**
     * 根据属性名字获取bean对象中的值
     */
    public static <T> T getProperty(Object objBean, String key) {
        Object value = null;
        try {
            value = PropertyUtils.getProperty(objBean, key);
        } catch (Exception e) {
            logger.warn(e);
        }
        if (value != null) {
            return (T) value;
        } else {
            return null;
        }
    }

    /**
     * Map 2 Bean
     */
    public static <T> T map2Bean(Map map, Class<T> beanClass) {
        return JSONUtil.parseBean(JSONUtil.format(map), beanClass);
    }

    /**
     * Bean 2 Map
     */
    public static Map bean2Map(Object beanObj) {
        return JSONUtil.parseMap(JSONUtil.format(beanObj));
    }

    /**
     * Bean 2 Bean
     */
    public static <T> T bean2Bean(Object srcBeanObj, Class<T> targetBeanClass) {
        return JSONUtil.parseBean(JSONUtil.format(srcBeanObj), targetBeanClass);
    }
}
