package com.csg.sone.base.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

/**
 * <p> Description:  MapUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 CSST. All rights reserved.
 * Company: CSST
 *
 * @author Sultan
 * @version 1.0
 */
public class MapUtilTest {
    private Date date = new Date(1504534829398l);
    private Map map01 = new HashMap();

    @Before
    public void setUp() {
        map01.put("strField", "a");
        map01.put("intField", 1);
        map01.put("longField", 1l);
        map01.put("decimalField", new BigDecimal("123.456"));
        map01.put("dateField", date);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void get() {
        assertNull(MapUtil.get(null, 0));
        assertNull(MapUtil.get(Collections.EMPTY_MAP, 0));
        assertEquals(MapUtil.get(map01, "strField"), "a");
        assertEquals(MapUtil.get(map01, "intField"), new Integer(1));
        assertEquals(MapUtil.get(map01, "longField"), new Long(1l));
        assertEquals(MapUtil.get(map01, "decimalField"), new BigDecimal("123.456"));
        assertEquals(MapUtil.get(map01, "dateField"), date);
    }

    @Test
    public void isEmpty() {
        assertTrue(MapUtil.isEmpty(null));
        assertTrue(MapUtil.isEmpty(Collections.EMPTY_MAP));
        assertFalse(MapUtil.isEmpty(map01));
    }

    @Test
    public void isNotEmpty() {
        assertFalse(MapUtil.isNotEmpty(null));
        assertFalse(MapUtil.isNotEmpty(Collections.EMPTY_MAP));
        assertTrue(MapUtil.isNotEmpty(map01));
    }
}