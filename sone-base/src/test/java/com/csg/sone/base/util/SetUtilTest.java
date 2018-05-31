package com.csg.sone.base.util;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p> Description:  SetUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class SetUtilTest {
    private Date date = new Date(1504534829398l);
    private Set set01 = new HashSet();

    @Before
    public void setUp() throws Exception {
        set01.add("a");
        set01.add(1);
        set01.add(1l);
        set01.add(new BigDecimal("123.456"));
        set01.add(date);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(SetUtil.isEmpty(null));
        assertTrue(SetUtil.isEmpty(Collections.EMPTY_SET));
        assertFalse(SetUtil.isEmpty(set01));
    }

    @Test
    public void isNotEmpty() throws Exception {
        assertFalse(SetUtil.isNotEmpty(null));
        assertFalse(SetUtil.isNotEmpty(Collections.EMPTY_SET));
        assertTrue(SetUtil.isNotEmpty(set01));
    }


}