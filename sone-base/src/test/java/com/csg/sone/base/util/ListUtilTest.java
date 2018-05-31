package com.csg.sone.base.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

/**
 * <p> Description:  ArrayUtilsTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class ListUtilTest {
    private Date date = new Date(1504534829398l);
    private List lst01 = new ArrayList();

    @Before
    public void setUp() {
        lst01.add("a");
        lst01.add(1);
        lst01.add(1l);
        lst01.add(new BigDecimal("123.456"));
        lst01.add(date);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void get() {
        assertNull(ListUtil.get(null, 0));
        assertNull(ListUtil.get(Collections.EMPTY_LIST, 0));
        assertEquals(ListUtil.get(lst01, 0), "a");
        assertEquals(ListUtil.get(lst01, 1), new Integer(1));
        assertEquals(ListUtil.get(lst01, 2), new Long(1l));
        assertEquals(ListUtil.get(lst01, 3), new BigDecimal("123.456"));
        assertEquals(ListUtil.get(lst01, 4), date);
    }

    @Test
    public void isEmpty() {
        assertTrue(ListUtil.isEmpty(null));
        assertTrue(ListUtil.isEmpty(Collections.EMPTY_LIST));
        assertFalse(ListUtil.isEmpty(lst01));
    }

    @Test
    public void isNotEmpty() {
        assertFalse(ListUtil.isNotEmpty(null));
        assertFalse(ListUtil.isNotEmpty(Collections.EMPTY_LIST));
        assertTrue(ListUtil.isNotEmpty(lst01));
    }

    @Test
    public void partition() {
        assertEquals(ListUtil.partition(lst01, 2).size(), 3);
        assertEquals(ListUtil.partition(lst01, 8).size(), 1);
    }
}