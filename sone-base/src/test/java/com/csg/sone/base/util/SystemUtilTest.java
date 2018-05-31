package com.csg.sone.base.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * <p> Description:  SystemUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public class SystemUtilTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFileEncoding() {
        assertNotNull(SystemUtil.getFileEncoding());
    }

    @Test
    public void getHostName() {
        assertNotNull(SystemUtil.getHostName());
    }

    @Test
    public void getUserHome() {
        assertNotNull(SystemUtil.getUserHome().getPath());
    }

    @Test
    public void getTmpDir() {
        assertNotNull(SystemUtil.getTmpDir().getPath());
    }
}
