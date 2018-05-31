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
 * <p> Description:  StringUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public class StringUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void camel() {
        assertNull(StringUtil.camel(null));
        assertEquals(StringUtil.camel(""), "");
        assertEquals(StringUtil.camel(" "), " ");
        assertEquals(StringUtil.camel("ab_cd_ef"), "abCdEf");
        assertEquals(StringUtil.camel("ab_cd"), "abCd");
        assertEquals(StringUtil.camel("_ab_cd_ef"), "AbCdEf");
        assertEquals(StringUtil.camel("ab_cd_ef_"), "abCdEf");
    }

    @Test
    public void capitalize() {
        assertNull(StringUtil.capitalize(null));
        assertEquals(StringUtil.capitalize(""), "");
        assertEquals(StringUtil.capitalize(" "), " ");
        assertEquals(StringUtil.capitalize("cat"), "Cat");
        assertEquals(StringUtil.capitalize("cAt"), "CAt");
        assertEquals(StringUtil.capitalize("'cat'"), "'cat'");
    }

    @Test
    public void center() {
        assertNull(StringUtil.center(null, 2, "ab"));
        assertEquals(StringUtil.center("", 4, " "), "    ");
        assertEquals(StringUtil.center(" ", 4, " "), "    ");
        assertEquals(StringUtil.center("ab", -1, " "), "ab");
        assertEquals(StringUtil.center("ab", 4, " "), " ab ");
        assertEquals(StringUtil.center("abcd", 2, " "), "abcd");
        assertEquals(StringUtil.center("a", 4, " "), " a  ");
        assertEquals(StringUtil.center("a", 4, "yz"), "yayz");
        assertEquals(StringUtil.center("a", 3, "yz"), "yay");
        assertEquals(StringUtil.center("abc", 7, null), "  abc  ");
        assertEquals(StringUtil.center("abc", 7, ""), "  abc  ");
        assertEquals(StringUtil.center("abc", 7, " "), "  abc  ");
    }

    @Test
    public void compare() {
        assertEquals(StringUtil.compare(null, null), 0);
        assertTrue(StringUtil.compare(null, "a") < 0);
        assertTrue(StringUtil.compare("a", null) > 0);
        assertTrue(StringUtil.compare("abc", "abc") == 0);
        assertTrue(StringUtil.compare("abc", new String("abc")) == 0);
        assertTrue(StringUtil.compare(new String("abc"), new String("abc")) == 0);
        assertTrue(StringUtil.compare("a", "b") < 0);
        assertTrue(StringUtil.compare("b", "a") > 0);
        assertTrue(StringUtil.compare("a", "B") > 0);
        assertTrue(StringUtil.compare("ab", "abc") < 0);
        assertTrue(StringUtil.compare("acb", "abc") > 0);
    }


    @Test
    public void compareIgnoreCase() {
        assertEquals(StringUtil.compareIgnoreCase(null, null), 0);
        assertTrue(StringUtil.compareIgnoreCase(null, "a") < 0);
        assertTrue(StringUtil.compareIgnoreCase("a", null) > 0);
        assertTrue(StringUtil.compareIgnoreCase("abc", "abc") == 0);
        assertTrue(StringUtil.compareIgnoreCase("abc", "ABC") == 0);
        assertTrue(StringUtil.compareIgnoreCase("abc", new String("ABC")) == 0);
        assertTrue(StringUtil.compareIgnoreCase(new String("abc"), new String("ABC")) == 0);
        assertTrue(StringUtil.compareIgnoreCase("a", "b") < 0);
        assertTrue(StringUtil.compareIgnoreCase("b", "a") > 0);
        assertTrue(StringUtil.compareIgnoreCase("a", "B") < 0);
        assertTrue(StringUtil.compareIgnoreCase("A", "b") < 0);
        assertTrue(StringUtil.compareIgnoreCase("ab", "ABC") < 0);
        assertTrue(StringUtil.compareIgnoreCase("ba", "abc") > 0);
    }

    @Test
    public void contains() {
        assertFalse(StringUtil.contains(null, "ABC"));
        assertFalse(StringUtil.contains("ABC", null));
        assertFalse(StringUtil.contains("", ""));
        assertTrue(StringUtil.contains(" ", " "));
        assertTrue(StringUtil.contains("abc", "a"));
        assertFalse(StringUtil.contains("abc", "z"));
        assertTrue(StringUtil.contains("a b c", " "));
        assertFalse(StringUtil.contains("a b c", "a c"));
        assertTrue(StringUtil.contains("abc", "a", "c"));
        assertTrue(StringUtil.contains("abc", "d", "c"));
        assertFalse(StringUtil.contains("abc", "d", "e"));
        assertFalse(StringUtil.contains("abc"));
        assertTrue(StringUtil.contains("abc", null, "a"));
    }

    @Test
    public void endsWith() {
        assertTrue(StringUtil.endsWith(null, null));
        assertTrue(StringUtil.endsWith("", ""));
        assertTrue(StringUtil.endsWith(" ", " "));
        assertFalse(StringUtil.endsWith("", " "));
        assertTrue(StringUtil.endsWith(" ", ""));
        assertFalse(StringUtil.endsWith(null, "def"));
        assertFalse(StringUtil.endsWith("abcdef", null));
        assertTrue(StringUtil.endsWith("abcdef", ""));
        assertFalse(StringUtil.endsWith("abcdef", " "));
        assertTrue(StringUtil.endsWith("abcdef", "def"));
        assertFalse(StringUtil.endsWith("ABCDEF", "def"));
        assertFalse(StringUtil.endsWith("ABCDEF", "cde"));
        assertTrue(StringUtil.endsWith("ABCDEF", ""));
    }

    @Test
    public void endsWithIgnoreCase() {
        assertTrue(StringUtil.endsWithIgnoreCase(null, null));
        assertTrue(StringUtil.endsWithIgnoreCase("", ""));
        assertTrue(StringUtil.endsWithIgnoreCase(" ", " "));
        assertFalse(StringUtil.endsWithIgnoreCase("", " "));
        assertTrue(StringUtil.endsWithIgnoreCase(" ", ""));
        assertFalse(StringUtil.endsWithIgnoreCase(null, "def"));
        assertFalse(StringUtil.endsWithIgnoreCase("abcdef", null));
        assertTrue(StringUtil.endsWithIgnoreCase("abcdef", ""));
        assertFalse(StringUtil.endsWithIgnoreCase("abcdef", " "));
        assertTrue(StringUtil.endsWithIgnoreCase("abcdef", "def"));
        assertTrue(StringUtil.endsWithIgnoreCase("ABCDEF", "def"));
        assertFalse(StringUtil.endsWithIgnoreCase("ABCDEF", "cde"));
        assertTrue(StringUtil.endsWithIgnoreCase("ABCDEF", ""));
    }

    @Test
    public void equals() {
        assertTrue(StringUtil.equals(null, null));
        assertTrue(StringUtil.equals("", ""));
        assertTrue(StringUtil.equals(" ", " "));
        assertFalse(StringUtil.equals(null, "abc"));
        assertFalse(StringUtil.equals("abc", null));
        assertTrue(StringUtil.equals("abc", "abc"));
        assertFalse(StringUtil.equals("abc", "ABC"));
        assertTrue(StringUtil.equals(new String("abc"), "abc"));
    }

    @Test
    public void equalsIgnoreCase() {
        assertTrue(StringUtil.equalsIgnoreCase(null, null));
        assertTrue(StringUtil.equalsIgnoreCase("", ""));
        assertTrue(StringUtil.equalsIgnoreCase(" ", " "));
        assertFalse(StringUtil.equalsIgnoreCase(null, "abc"));
        assertFalse(StringUtil.equalsIgnoreCase("abc", null));
        assertTrue(StringUtil.equalsIgnoreCase("abc", "abc"));
        assertTrue(StringUtil.equalsIgnoreCase("abc", "ABC"));
        assertTrue(StringUtil.equalsIgnoreCase(new String("abc"), "abc"));
        assertTrue(StringUtil.equalsIgnoreCase(new String("ABC"), "abc"));
    }

    @Test
    public void getLength() {
        assertEquals(StringUtil.getLength("ABc"), 3);
        assertEquals(StringUtil.getLength(null), 0);
        assertEquals(StringUtil.getLength(""), 0);
        assertEquals(StringUtil.getLength(" "), 1);
        assertEquals(StringUtil.getLength("我"), 1);
        assertEquals(StringUtil.getLength("我a"), 2);
        assertEquals(StringUtil.getLength("'我/a'"), 5);
    }

    @Test
    public void getUUID() {
        assertEquals(StringUtil.getLength(StringUtil.getUUID()), 32);
    }

    @Test
    public void indexOf() {
        assertEquals(StringUtil.indexOf("abf", null), -1);
        assertEquals(StringUtil.indexOf("", ""), 0);
        assertEquals(StringUtil.indexOf("aabaabaa", "a"), 0);
        assertEquals(StringUtil.indexOf("aabaabaa", "b"), 2);
        assertEquals(StringUtil.indexOf("aabaabaa", "ab"), 1);
        assertEquals(StringUtil.indexOf("aabaabaa", ""), 0);
    }

    @Test
    public void indexOfIgnoreCase() {
        assertEquals(StringUtil.indexOfIgnoreCase("abf", null), -1);
        assertEquals(StringUtil.indexOfIgnoreCase("", ""), 0);
        assertEquals(StringUtil.indexOfIgnoreCase("aAbaabaa", "a"), 0);
        assertEquals(StringUtil.indexOfIgnoreCase("aaBaabaa", "b"), 2);
        assertEquals(StringUtil.indexOfIgnoreCase("aabaabaa", "ab"), 1);
        assertEquals(StringUtil.indexOfIgnoreCase("aabaabaa", ""), 0);
    }

    @Test
    public void isEmpty() {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertFalse(StringUtil.isEmpty(" "));
        assertFalse(StringUtil.isEmpty("bob"));
        assertFalse(StringUtil.isEmpty("  bob  "));
    }

    @Test
    public void isNotEmpty() {
        assertFalse(StringUtil.isNotEmpty(null));
        assertFalse(StringUtil.isNotEmpty(""));
        assertTrue(StringUtil.isNotEmpty(" "));
        assertTrue(StringUtil.isNotEmpty("bob"));
        assertTrue(StringUtil.isNotEmpty("  bob  "));
    }

    @Test
    public void joinArray() {
        String[] nullStrArr = null;
        assertNull(StringUtil.join(nullStrArr, "abc"));
        assertEquals(StringUtil.join(new String[]{}, "abc"), "");
        assertEquals(StringUtil.join(new String[]{null}, "abc"), "");
        assertEquals(StringUtil.join(new String[]{"a", "b", "c"}, null), "abc");
        assertEquals(StringUtil.join(new String[]{"a", "b", "c"}, ""), "abc");
        assertEquals(StringUtil.join(new String[]{"a", "b", "c"}, " "), "a b c");
        assertEquals(StringUtil.join(new String[]{"a", "b", "c"}, ","), "a,b,c");
        assertEquals(StringUtil.join(new String[]{null, "", "a"}, ","), ",,a");
        assertEquals(StringUtil.join(new String[]{"a", "b", "b"}, "a"), "aabab");
    }

    @Test
    public void joinList() {
        List nullList = null;
        List lst01 = new ArrayList();
        List lst02 = new ArrayList();
        lst02.add(null);
        List lst03 = new ArrayList();
        lst03.add("a");
        lst03.add("b");
        lst03.add("c");
        List lst04 = new ArrayList();
        lst04.add(null);
        lst04.add("");
        lst04.add("a");
        List lst05 = new ArrayList();
        lst05.add("a");
        lst05.add("b");
        lst05.add("b");
        assertNull(StringUtil.join(nullList, "abc"));
        assertEquals(StringUtil.join(lst01, "abc"), "");
        assertEquals(StringUtil.join(lst02, "abc"), "");
        assertEquals(StringUtil.join(lst03, null), "abc");
        assertEquals(StringUtil.join(lst03, ""), "abc");
        assertEquals(StringUtil.join(lst03, " "), "a b c");
        assertEquals(StringUtil.join(lst03, ","), "a,b,c");
        assertEquals(StringUtil.join(lst04, ","), ",,a");
        assertEquals(StringUtil.join(lst05, "a"), "aabab");
    }


    @Test
    public void lastIndexOf() {
        assertEquals(StringUtil.lastIndexOf(null, "abc"), -1);
        assertEquals(StringUtil.lastIndexOf("aabaabaa", "a"), 7);
        assertEquals(StringUtil.lastIndexOf("aabaabaa", "b"), 5);
    }

    @Test
    public void lastIndexOfIgnoreCase() {
        assertEquals(StringUtil.lastIndexOfIgnoreCase(null, "abc"), -1);
        assertEquals(StringUtil.lastIndexOfIgnoreCase("aabaabaa", "A"), 7);
        assertEquals(StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B"), 5);
    }

    @Test
    public void leftPad() {
        assertNull(StringUtil.leftPad(null, 100, "z"));
        assertEquals(StringUtil.leftPad("", 3, "z"), "zzz");
        assertEquals(StringUtil.leftPad("bat", 3, "yz"), "bat");
        assertEquals(StringUtil.leftPad("bat", 5, "yz"), "yzbat");
        assertEquals(StringUtil.leftPad("bat", 8, "yz"), "yzyzybat");
        assertEquals(StringUtil.leftPad("bat", 1, "yz"), "bat");
        assertEquals(StringUtil.leftPad("bat", -1, "yz"), "bat");
        assertEquals(StringUtil.leftPad("bat", 5, null), "  bat");
        assertEquals(StringUtil.leftPad("bat", 5, ""), "  bat");
        assertEquals(StringUtil.leftPad("bat", 5, " "), "  bat");
        assertEquals(StringUtil.leftPad("bat", 0, ""), "bat");
    }

    @Test
    public void lowerCase() {
        assertNull(StringUtil.lowerCase(null));
        assertEquals(StringUtil.lowerCase(""), "");
        assertEquals(StringUtil.lowerCase(" "), " ");
        assertEquals(StringUtil.lowerCase("aBc"), "abc");
        assertEquals(StringUtil.lowerCase("I110oO"), "i110oo");
    }

    @Test
    public void messageFormat() {
        assertNull(StringUtil.messageFormat(null));
        assertEquals(StringUtil.messageFormat(""), "");
        assertEquals(StringUtil.messageFormat(" "), " ");
        assertEquals(StringUtil.messageFormat("a{0}b{1}c{2}", "A", "B", "C"), "aAbBcC");
    }

    @Test
    public void repeat() {
        assertNull(StringUtil.repeat(null, 2));
        assertEquals(StringUtil.repeat("", 0), "");
        assertEquals(StringUtil.repeat("", 2), "");
        assertEquals(StringUtil.repeat(" ", 2), "  ");
        assertEquals(StringUtil.repeat("a", 3), "aaa");
        assertEquals(StringUtil.repeat("ab", 2), "abab");
        assertEquals(StringUtil.repeat("a", -2), "");
        assertEquals(StringUtil.repeat("abc", 0), "");
        assertEquals(StringUtil.repeat(" abc ", 2), " abc  abc ");
    }


    @Test
    public void replace() {
        assertNull(StringUtil.replace(null, "123", "abc"));
        assertEquals(StringUtil.replace("", "123", "abc"), "");
        assertEquals(StringUtil.replace("any", null, "abc"), "any");
        assertEquals(StringUtil.replace("any", "any", null), "any");
        assertEquals(StringUtil.replace("aba", "a", ""), "b");
        assertEquals(StringUtil.replace("aba", "a", "z"), "zbz");
        assertEquals(StringUtil.replace("aba", "ab", "a"), "aa");
    }


    @Test
    public void replaceFirst() {
        assertNull(StringUtil.replaceFirst(null, "a", null));
        assertEquals(StringUtil.replaceFirst("", "a", null), "");
        assertEquals(StringUtil.replaceFirst("aba", "a", null), "aba");
        assertEquals(StringUtil.replaceFirst("aba", "a", ""), "ba");
        assertEquals(StringUtil.replaceFirst("aaaa", "a", ""), "aaa");
        assertEquals(StringUtil.replaceFirst("ababab", "ba", "y"), "aybab");
    }

    @Test
    public void replacePattern() {
        assertNull(StringUtil.replacePattern(null, "[<>]", "z"));
        assertEquals(StringUtil.replacePattern("", "[<>]", "z"), "");
        assertEquals(StringUtil.replacePattern("<__><__>", "[<>]", "z"), "z__zz__z");
        assertEquals(StringUtil.replacePattern("ABCabc123", "[a-z]", "_"), "ABC___123");
        assertEquals(StringUtil.replacePattern("ABCabc123", "[^A-Z0-9]+", "_"), "ABC_123");
        assertEquals(StringUtil.replacePattern("ABCabc123", "[^A-Z0-9]+", ""), "ABC123");
    }

    @Test
    public void reverse() {
        assertNull(StringUtil.reverse(null));
        assertEquals(StringUtil.reverse(""), "");
        assertEquals(StringUtil.reverse("bat"), "tab");
        assertEquals(StringUtil.reverse("a a "), " a a");
        assertEquals(StringUtil.reverse("{1,2,3,4,5}"), "}5,4,3,2,1{");
    }

    @Test
    public void rightPad() {
        assertNull(StringUtil.rightPad(null, 23, "abc"));
        assertEquals(StringUtil.rightPad("", 3, "z"), "zzz");
        assertEquals(StringUtil.rightPad("bat", 5, "z"), "batzz");
        assertEquals(StringUtil.rightPad("bat", 1, "z"), "bat");
        assertEquals(StringUtil.rightPad("bat", -1, "z"), "bat");
    }

    @Test
    public void removeLastChar() {
        assertNull(StringUtil.removeLastChar(null));
        assertEquals(StringUtil.removeLastChar("abc \r"), "abc ");
        assertEquals(StringUtil.removeLastChar("abc\n"), "abc");
        assertEquals(StringUtil.removeLastChar("abc\r\n"), "abc");
        assertEquals(StringUtil.removeLastChar("abc"), "ab");
        assertEquals(StringUtil.removeLastChar("abc\nabc"), "abc\nab");
        assertEquals(StringUtil.removeLastChar("a"), "");
        assertEquals(StringUtil.removeLastChar("\r"), "");
        assertEquals(StringUtil.removeLastChar("\n"), "");
        assertEquals(StringUtil.removeLastChar("\r\n"), "");
    }

    @Test
    public void replaceNull() {
        assertEquals(StringUtil.replaceNull(null, "abc"), "abc");
        assertEquals(StringUtil.replaceNull("", null), "");
        assertEquals(StringUtil.replaceNull("abc", "A"), "abc");
        assertEquals(StringUtil.replaceNull("null", "AB"), "null");
    }

    @Test
    public void split() {
        assertNull(StringUtil.split(null, "abc"));
        assertArrayEquals(StringUtil.split("", "z"), new String[]{});
        assertArrayEquals(StringUtil.split("abc def", " "), new String[]{"abc", "def"});
        assertArrayEquals(StringUtil.split("abc  def", " "), new String[]{"abc", "def"});
        assertArrayEquals(StringUtil.split("  abc ", " "), new String[]{"abc"});
        assertArrayEquals(StringUtil.split("a,b,c,", ","), new String[]{"a", "b", "c"});
        assertArrayEquals(StringUtil.split("a,b,c, ", ","), new String[]{"a", "b", "c", " "});
        assertArrayEquals(StringUtil.split("a,b,c", ","), new String[]{"a", "b", "c"});
        assertArrayEquals(StringUtil.split(",a,b,c", ","), new String[]{"a", "b", "c"});
        assertArrayEquals(StringUtil.split(" ,a,b,c", ","), new String[]{" ", "a", "b", "c"});
        assertArrayEquals(StringUtil.split(",a, b,c,", ","), new String[]{"a", " b", "c"});
    }

    @Test
    public void splitPattern() {
        assertArrayEquals(StringUtil.splitPattern("a1b2c3d", "[0-9]"), new String[]{"a", "b", "c", "d"});
        assertArrayEquals(StringUtil.splitPattern(null, "[0-9]"), null);
        assertArrayEquals(StringUtil.splitPattern("", "[0-9]"), new String[0]);
        assertArrayEquals(StringUtil.splitPattern("", ""), new String[0]);
        assertArrayEquals(StringUtil.splitPattern("a1b2c3d", "[a-z]"), new String[]{"", "1", "2", "3"});
        thrown.expect(NullPointerException.class);
        StringUtil.splitPattern("234", null);
    }

    @Test
    public void startsWith() {
        assertTrue(StringUtil.startsWith(null, null));
        assertTrue(StringUtil.startsWith("", ""));
        assertFalse(StringUtil.startsWith(null, "abc"));
        assertFalse(StringUtil.startsWith("abcdef", null));
        assertTrue(StringUtil.startsWith("abcdef", "abc"));
        assertFalse(StringUtil.startsWith("ABCDEF", "abc"));
    }

    @Test
    public void startsWithIgnoreCase() {
        assertTrue(StringUtil.startsWithIgnoreCase(null, null));
        assertFalse(StringUtil.startsWithIgnoreCase("", "abc"));
        assertFalse(StringUtil.startsWithIgnoreCase(null, "abc"));
        assertFalse(StringUtil.startsWithIgnoreCase("abcdef", null));
        assertTrue(StringUtil.startsWithIgnoreCase("abcdef", "abc"));
        assertTrue(StringUtil.startsWithIgnoreCase("ABCDEF", "abc"));
    }

    @Test
    public void subString() {
        assertNull(StringUtil.subString(null, 10));
        assertEquals(StringUtil.subString("", 10), "");
        assertEquals(StringUtil.subString("abc", 0), "abc");
        assertEquals(StringUtil.subString("abc", 2), "c");
        assertEquals(StringUtil.subString("abc", 4), "");
        assertEquals(StringUtil.subString("abc", -2), "bc");
        assertEquals(StringUtil.subString("abc", -4), "abc");
        assertEquals(StringUtil.subString("abcf", -1), "f");

        assertNull(StringUtil.subString(null, 0, 2));
        assertEquals(StringUtil.subString("", 0, 2), "");
        assertEquals(StringUtil.subString("abc", 0, 2), "ab");
        assertEquals(StringUtil.subString("abc", 2, 0), "");
        assertEquals(StringUtil.subString("abc", 2, 4), "c");
        assertEquals(StringUtil.subString("abc", 4, 6), "");
        assertEquals(StringUtil.subString("abc", 2, 2), "");
        assertEquals(StringUtil.subString("abc", -2, -1), "b");
        assertEquals(StringUtil.subString("abc", -4, 2), "ab");
    }

    @Test
    public void trim() {
        assertNull(StringUtil.trim(null));
        assertEquals(StringUtil.trim(""), "");
        assertEquals(StringUtil.trim("     "), "");
        assertEquals(StringUtil.trim("abc"), "abc");
        assertEquals(StringUtil.trim("    abc    "), "abc");
        assertEquals(StringUtil.trim("a bc"), "a bc");
    }

    @Test
    public void uncapitalize() {
        assertNull(StringUtil.uncapitalize(null));
        assertEquals(StringUtil.uncapitalize(""), "");
        assertEquals(StringUtil.uncapitalize("cat"), "cat");
        assertEquals(StringUtil.uncapitalize("Cat"), "cat");
        assertEquals(StringUtil.uncapitalize("CAT"), "cAT");
    }

    @Test
    public void wrap() {
        assertEquals(StringUtil.wrap(null, null), null);
        assertEquals(StringUtil.wrap("", "x"), "");
        assertEquals(StringUtil.wrap("ab", null), "ab");
        assertEquals(StringUtil.wrap("ab", "x"), "xabx");
        assertEquals(StringUtil.wrap("ab", "\""), "\"ab\"");
        assertEquals(StringUtil.wrap("ab", ","), ",ab,");
        assertEquals(StringUtil.wrap("ab", " "), " ab ");
    }

    @Test
    public void unwrap() {
        assertNull(StringUtil.unwrap(null, "ab"));
        assertEquals(StringUtil.unwrap("", "ab"), "");
        assertEquals(StringUtil.unwrap("ab", null), "ab");
        assertEquals(StringUtil.unwrap("xabx", "x"), "ab");
        assertEquals(StringUtil.unwrap("\"ab\"", "\""), "ab");
        assertEquals(StringUtil.unwrap("AABabcBAA", "AA"), "BabcB");
        assertEquals(StringUtil.unwrap("#A", "#"), "#A");
        assertEquals(StringUtil.unwrap("A$", "$"), "A$");
    }

    @Test
    public void upperCase() {
        assertNull(StringUtil.upperCase(null));
        assertEquals(StringUtil.upperCase(""), "");
        assertEquals(StringUtil.upperCase("A s"), "A S");
        assertEquals(StringUtil.upperCase("abc"), "ABC");
    }

    @Test
    public void unCamel() {
        assertNull(StringUtil.uncamel(null));
        assertEquals(StringUtil.uncamel(""), "");
        assertEquals(StringUtil.uncamel(" "), " ");
        assertEquals(StringUtil.uncamel("abCdEf"), "ab_cd_ef");
        assertEquals(StringUtil.uncamel("abCd"), "ab_cd");
    }
}
