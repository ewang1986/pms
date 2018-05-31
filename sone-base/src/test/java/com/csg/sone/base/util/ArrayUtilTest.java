package com.csg.sone.base.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <p> Description:  ArrayUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author Duyang
 * @version 1.0
 */
public class ArrayUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private List lst01 = new ArrayList();

    @Before
    public void setUp() {
        lst01.add("a");
        lst01.add("b");
        lst01.add("c");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addAll() {
        assertNull(ArrayUtil.addAll(null, null));
        assertArrayEquals(ArrayUtil.addAll(new Object[]{"a", "b", "c"}, null), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.addAll(new Object[]{"a", "b", "c"}), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.addAll(null, new Object[]{"a", "b", "c"}), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.addAll(new Object[0], new Object[]{}), new Object[0]);
        assertArrayEquals(ArrayUtil.addAll(new Object[]{null}, new Object[]{null}), new Object[]{null, null});
        assertArrayEquals(ArrayUtil.addAll(new Object[]{"a", "b", "c"}, new Object[]{"1", "2", "3"}), new Object[]{"a", "b", "c", "1", "2", "3"});
        assertArrayEquals(ArrayUtil.addAll(new Object[]{"a", "b", "c"}, "1", "2", "3"), new Object[]{"a", "b", "c", "1", "2", "3"});
    }

    @Test
    public void asList() {
        assertEquals(ArrayUtil.asList(null), new ArrayList());
        assertEquals(ArrayUtil.asList(new Object[0]), new ArrayList());
        assertEquals(ArrayUtil.asList(new Object[]{"a", "b", "c"}), lst01);
    }

    @Test
    public void clones() {
        assertNull(ArrayUtil.clone(null));
        assertArrayEquals(ArrayUtil.clone(new Integer[]{1, 2}), new Integer[]{1, 2});
        assertArrayEquals(ArrayUtil.clone(new Long[]{1L, 2L}), new Long[]{1L, 2L});
        assertArrayEquals(ArrayUtil.clone(new Short[]{1, 2}), new Short[]{1, 2});
        assertArrayEquals(ArrayUtil.clone(new Character[]{'1', '2'}), new Character[]{'1', '2'});
        assertArrayEquals(ArrayUtil.clone(new Double[]{1d, 2d}), new Double[]{1d, 2d});
        assertArrayEquals(ArrayUtil.clone(new Float[]{1f, 2f}), new Float[]{1f, 2f});
        assertArrayEquals(ArrayUtil.clone(new Boolean[]{true, false}), new Boolean[]{true, false});
    }

    @Test
    public void contains() {
        assertFalse(ArrayUtil.contains(null, "b"));
        assertTrue(ArrayUtil.contains(new Object[]{"a", "b", "c"}, "b"));
        assertFalse(ArrayUtil.contains(new Object[]{"a", "b", "c"}, null));
        assertFalse(ArrayUtil.contains(new Object[0], "b"));
        assertFalse(ArrayUtil.contains(new Object[]{"a", "b", "c"}, "d"));
        assertTrue(ArrayUtil.contains(new Object[]{"a", "b", "c"}, new String("b")));
    }

    @Test
    public void getLength() {
        assertEquals(ArrayUtil.getLength(null), 0);
        assertEquals(ArrayUtil.getLength(new Object[0]), 0);
        assertEquals(ArrayUtil.getLength(new Object[]{null}), 1);
        assertEquals(ArrayUtil.getLength(new Object[]{true, false}), 2);
        assertEquals(ArrayUtil.getLength(new Object[]{1, 2, 3}), 3);
        assertEquals(ArrayUtil.getLength(new Object[]{"a", "b", "c"}), 3);
    }

    @Test
    public void indexOf() {
        assertEquals(ArrayUtil.indexOf(null, null), -1);
        assertEquals(ArrayUtil.indexOf(null, "a"), -1);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "a"), 0);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "b"), 1);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, "d"), -1);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", "b", "c"}, null), -1);
        assertEquals(ArrayUtil.indexOf(new Object[]{null}, null), 0);
        assertEquals(ArrayUtil.indexOf(new Object[]{""}, ""), 0);
        assertEquals(ArrayUtil.indexOf(new Object[0], null), -1);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", null, "b", "c"}, null), 1);
        assertEquals(ArrayUtil.indexOf(new Object[]{"a", "", "b", "c"}, ""), 1);
    }

    @Test
    public void insert() {
        assertNull(ArrayUtil.insert(0, null, null));
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{"a", "b", "c"}, null), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{"a", "b", "c"}), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.insert(0, null, new Object[]{"a", "b", "c"}), null);
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{}, new Object[]{}), new Object[]{});
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{null}, new Object[]{null}), new Object[]{null, null});
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{"a", "b", "c"}, new Object[]{"1", "2", "3"}), new Object[]{"1", "2", "3", "a", "b", "c"});
        assertArrayEquals(ArrayUtil.insert(0, new Object[]{"a", "b", "c"}, "1", "2", "3"), new Object[]{"1", "2", "3", "a", "b", "c"});
        assertArrayEquals(ArrayUtil.insert(1, new Object[]{"a", "b", "c"}, "1", "2", "3"), new Object[]{"a", "1", "2", "3", "b", "c"});
    }

    @Test
    public void isEmpty() {
        assertEquals(ArrayUtil.isEmpty(null), true);
        assertEquals(ArrayUtil.isEmpty(new Object[0]), true);
        assertEquals(ArrayUtil.isEmpty(new Object[]{""}), false);
        assertEquals(ArrayUtil.isEmpty(new Object[]{1, 2, 3}), false);
    }

    @Test
    public void isNotEmpty() {
        assertEquals(ArrayUtil.isNotEmpty(null), false);
        assertEquals(ArrayUtil.isNotEmpty(new Object[0]), false);
        assertEquals(ArrayUtil.isNotEmpty(new Object[]{""}), true);
        assertEquals(ArrayUtil.isNotEmpty(new Object[]{1, 2, 3}), true);
    }

    @Test
    public void lastIndexOf() {
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "a"), 0);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "b"), 1);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, "d"), -1);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", "b", "c"}, null), -1);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{null}, null), 0);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{""}, ""), 0);
        assertEquals(ArrayUtil.lastIndexOf(new Object[0], null), -1);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", null, "b", "c"}, null), 1);
        assertEquals(ArrayUtil.lastIndexOf(new Object[]{"a", "", "b", "c"}, ""), 1);
    }

    @Test
    public void removeByIndex() {
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a"}, 0), new Object[]{});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a"}), new Object[]{"a"});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a", "b"}, 0), new Object[]{"b"});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a", "b"}, 1), new Object[]{"a"});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a", "b", "c"}, 1), new Object[]{"a", "c"});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a", "b", "c"}, 0, 1), new Object[]{"c"});
        assertArrayEquals(ArrayUtil.removeByIndex(new Object[]{"a", "b", "c"}, 0, 1, 2), new Object[]{});
        thrown.expect(IndexOutOfBoundsException.class);
        ArrayUtil.removeByIndex(new Object[]{"a", "b", "c"}, 0, 1, 2, 3);
    }

    @Test
    public void removeByElement() {
        assertNull(ArrayUtil.removeByElement(null, "a"));
        assertArrayEquals(ArrayUtil.removeByElement(new Object[0], "a"), new Object[0]);
        assertArrayEquals(ArrayUtil.removeByElement(new Object[]{"a"}, "b"), new Object[]{"a"});
        assertArrayEquals(ArrayUtil.removeByElement(new Object[]{"a", "b"}, "a"), new Object[]{"b"});
        assertArrayEquals(ArrayUtil.removeByElement(new Object[]{"a", "b", "a"}, "a"), new Object[]{"b"});
    }

    @Test
    public void reverse() {
        assertNull(ArrayUtil.reverse(null));
        assertArrayEquals(ArrayUtil.reverse(new Object[]{""}), new Object[]{""});
        assertArrayEquals(ArrayUtil.reverse(new Object[]{null}), new Object[]{null});
        assertArrayEquals(ArrayUtil.reverse(new Object[]{"a", "b", "c"}), new Object[]{"c", "b", "a"});
    }

    @Test
    public void subArray() {
        assertNull(ArrayUtil.subArray(null, 0));
        assertArrayEquals(ArrayUtil.subArray(new Object[0], 0), new Object[]{});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{""}, 0), new Object[]{""});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0), new Object[]{"a", "b", "c"});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 1), new Object[]{"b", "c"});

        assertNull(ArrayUtil.subArray(null, 0, 1));
        assertArrayEquals(ArrayUtil.subArray(new Object[0], 0, 1), new Object[]{});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{""}, 0, 1), new Object[]{""});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0, 1), new Object[]{"a"});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 0, 2), new Object[]{"a", "b"});
        assertArrayEquals(ArrayUtil.subArray(new Object[]{"a", "b", "c"}, 1, 2), new Object[]{"b"});
    }
}