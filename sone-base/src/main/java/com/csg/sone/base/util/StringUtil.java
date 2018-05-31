package com.csg.sone.base.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

/**
 * <p>Description:  StringUtil</p>
 * <pre></pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class StringUtil {
    /**
     * <p> A String for carriage return CR ("\r").</p>
     */
    public static final String CR_STR = StringUtils.CR;
    /**
     * <p> A String for linefeed LF ("\n").</p>
     */
    public static final String LF_STR = StringUtils.LF;
    /**
     * <p>
     * On UNIX systems, it returns {@code "\n"};
     * On Windows systems it returns {@code "\r\n"}.
     * </p>
     */
    public static final String CR_LF_STR = System.lineSeparator();
    /**
     * <p> The empty String {@code ""}.</p>
     */
    public static final String EMPTY_STR = StringUtils.EMPTY;
    /**
     * <p> A String for a space character.</p>
     */
    public static final String SPACE_STR = StringUtils.SPACE;
    /**
     * <p> A String for a underline character.</p>
     */
    public static final String UNDERLINE_STR = "_";
    /**
     * <p> A String for a dash character.</p>
     */
    public static final String DASH_STR = "-";
    /**
     * <p> The {@code file.separator} System Property.</p>
     */
    public static final String FILE_SEPARATOR_STR = SystemUtils.FILE_SEPARATOR;


    /**
     * <p>Remove underLine "_" in words and change the character to uppercase after it.
     * </p>
     * <pre>
     * StringUtil.camel(null)  = null
     * StringUtil.camel("")  = ""
     * StringUtil.camel(" ")  = " "
     * StringUtil.camel("ab_cd")  = "abCd"
     * StringUtil.camel("ab_cd_ef")  = "abCdEf"
     * StringUtil.camel("_ab_cd_ef")  = "AbCdEf"
     * StringUtil.camel("ab_cd_ef_")  = "abCdEf"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String camel(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        } else {
            String strRet = StringUtil.lowerCase(str);

            int loc = StringUtil.indexOf(str, StringUtil.UNDERLINE_STR);
            while (loc >= 0 && loc <= (strRet.length() - 1)) {
                if (loc == (strRet.length() - 1)) {
                    strRet = strRet.substring(0, loc);
                } else {
                    strRet = strRet.substring(0, loc)
                            + strRet.substring(loc + 1, loc + 2).toUpperCase()
                            + strRet.substring(loc + 2);
                    loc = strRet.indexOf(StringUtil.UNDERLINE_STR);
                }
            }
            return strRet;
        }
    }

    /**
     * <p>Capitalizes a String changing the first character to title case. No other characters are changed.
     * </p>
     * <pre>
     * StringUtil.capitalize(null)  = null
     * StringUtil.capitalize("")    = ""
     * StringUtil.capitalize(" ")    = " "
     * StringUtil.capitalize("cat") = "Cat"
     * StringUtil.capitalize("cAt") = "CAt"
     * StringUtil.capitalize("'cat'") = "'cat'"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String capitalize(String str) {
        return StringUtils.capitalize(str);
    }

    /**
     * <p>Centers a String in a larger String of size.
     * </p>
     * <pre>
     * StringUtil.center(null, *, *)     = null
     * StringUtil.center("", 4, ' ')     = "    "
     * StringUtil.center(" ", 4, ' ')     = "    "
     * StringUtil.center("ab", -1, ' ')  = "ab"
     * StringUtil.center("ab", 4, ' ')   = " ab "
     * StringUtil.center("abcd", 2, ' ') = "abcd"
     * StringUtil.center("a", 4, ' ')    = " a  "
     * StringUtil.center("a", 4, "yz")   = "yayz"
     * StringUtil.center("a", 3, 'yz')    = "yay"
     * StringUtil.center("abc", 7, null) = "  abc  "
     * StringUtil.center("abc", 7, "")   = "  abc  "
     * StringUtil.center("abc", 7, " ")   = "  abc  "
     * </pre>
     *
     * @param str
     * @param size
     * @param padChar
     */
    public static String center(String str, int size, String padChar) {
        return StringUtils.center(str, size, padChar);
    }

    /**
     * <p>Compare two Strings lexicographically.
     * </p>
     * <pre>
     * StringUtil.compare(null, null)   = 0
     * StringUtil.compare(null , "a")   &lt; 0
     * StringUtil.compare("a", null)    &gt; 0
     * StringUtil.compare("abc", "abc") = 0
     * StringUtil.compare("abc", new String("abc")) = 0
     * StringUtil.compare(new String("abc"), new String("abc")) = 0
     * StringUtil.compare("a", "b")     &lt; 0
     * StringUtil.compare("b", "a")     &gt; 0
     * StringUtil.compare("a", "B")     &gt; 0
     * StringUtil.compare("ab", "abc")  &lt; 0
     * StringUtil.compare("acb", "abc")  &gt; 0
     * </pre>
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int compare(String str1, String str2) {
        return StringUtils.compare(str1, str2);
    }

    /**
     * <p>Compare two Strings lexicographically, ignoring case differences.
     * </p>
     * <pre>
     * StringUtil.compareIgnoreCase(null, null)   = 0
     * StringUtil.compareIgnoreCase(null , "a")   &lt; 0
     * StringUtil.compareIgnoreCase("a", null)    &gt; 0
     * StringUtil.compareIgnoreCase("abc", "abc") = 0
     * StringUtil.compareIgnoreCase("abc", "ABC") = 0
     * StringUtil.compareIgnoreCase("abc", new String("ABC")) == 0
     * StringUtil.compareIgnoreCase(new String("abc"), new String("ABC")) == 0
     * StringUtil.compareIgnoreCase("a", "b")     &lt; 0
     * StringUtil.compareIgnoreCase("b", "a")     &gt; 0
     * StringUtil.compareIgnoreCase("a", "B")     &lt; 0
     * StringUtil.compareIgnoreCase("A", "b")     &lt; 0
     * StringUtil.compareIgnoreCase("ab", "ABC")  &lt; 0
     * </pre>
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int compareIgnoreCase(String str1, String str2) {
        return StringUtils.compareIgnoreCase(str1, str2);
    }

    /**
     * <p>Checks if CharSequence contains a search character.
     * </p>
     * <pre>
     * StringUtil.contains(null, *)    = false
     * StringUtil.contains(* ,null )   = false
     * StringUtil.contains("", "")      = true
     * StringUtil.contains(" ", " ")      = true
     * StringUtil.contains("abc", "a") = true
     * StringUtil.contains("abc", "z") = false
     * StringUtil.contains("abc", "")= true
     * StringUtil.contains("a b c", " ")= true
     * StringUtil.contains("a b c", "a c") = false
     * StringUtil.contains("abc", "a","c")= true
     * StringUtil.contains("abc", "a","d")= true
     * StringUtil.contains("abc", "d","e")= false
     * StringUtil.contains("abc")= false
     * </pre>
     *
     * @param seq
     * @param searchChar
     * @return
     */
    public static boolean contains(CharSequence seq, CharSequence... searchChar) {
        return StringUtils.containsAny(seq, searchChar);
    }

    /**
     * <p>Check if a CharSequence ends with a specified suffix.
     * </p>
     * <pre>
     * StringUtil.endsWith(null, null)      = true
     * StringUtil.endsWith("", "")      = true
     * StringUtil.endsWith(" ", " ")      = true
     * StringUtil.endsWith("", " ")      = false
     * StringUtil.endsWith(" ", "")      = true
     * StringUtil.endsWith(null, "def")     = false
     * StringUtil.endsWith("abcdef", null)  = false
     * StringUtil.endsWith("abcdef", "")  = true
     * StringUtil.endsWith("abcdef", " ")  = false
     * StringUtil.endsWith("abcdef", "def") = true
     * StringUtil.endsWith("ABCDEF", "def") = false
     * StringUtil.endsWith("ABCDEF", "cde") = false
     * StringUtilg.endsWith("ABCDEF", "")    = true
     * </pre>
     *
     * @param str    the CharSequence to check, may be null
     * @param suffix the suffix to find, may be null
     * @return true,  if the CharSequence ends with the suffix
     */
    public static boolean endsWith(CharSequence str, CharSequence suffix) {
        return StringUtils.endsWith(str, suffix);
    }

    /**
     * <p>Check if a CharSequence ends with a specified suffix, ignoring case differences.
     * </p>
     * <pre>
     * StringUtil.endsWithIgnoreCase(null, null)      = true
     * StringUtil.endsWithIgnoreCase("", "")      = true
     * StringUtil.endsWithIgnoreCase(" ", " ")      = true
     * StringUtil.endsWithIgnoreCase("", " ")      = false
     * StringUtil.endsWithIgnoreCase(" ", "")      = true
     * StringUtil.endsWithIgnoreCase(null, "def")     = false
     * StringUtil.endsWithIgnoreCase("abcdef", null)  = false
     * StringUtil.endsWithIgnoreCase("abcdef", "")  = true
     * StringUtil.endsWithIgnoreCase("abcdef", " ")  = false
     * StringUtil.endsWithIgnoreCase("abcdef", "def") = true
     * StringUtil.endsWithIgnoreCase("ABCDEF", "def") = true
     * StringUtil.endsWithIgnoreCase("ABCDEF", "cde") = false
     * </pre>
     *
     * @param str    the CharSequence to check, may be null
     * @param suffix the suffix to find, may be null
     * @return true ,if the CharSequence ends with the suffix
     */
    public static boolean endsWithIgnoreCase(CharSequence str, CharSequence suffix) {
        return StringUtils.endsWithIgnoreCase(str, suffix);
    }

    /**
     * <p>Compares two CharSequences.
     * </p>
     * <pre>
     * StringUtil.equals(null, null)   = true
     * StringUtil.equals("", "")   = true
     * StringUtil.equals(" ", " ")   = true
     * StringUtil.equals(null, "abc")  = false
     * StringUtil.equals("abc", null)  = false
     * StringUtil.equals("abc", "abc") = true
     * StringUtil.equals("abc", "ABC") = false
     * StringUtil.equals(new String("abc"), "abc") = true
     * </pre>
     *
     * @param cs1
     * @param cs2
     * @return
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return StringUtils.equals(cs1, cs2);
    }

    /**
     * <p>Compares two CharSequences, ignoring case differences.
     * </p>
     * <pre>
     * StringUtil.equalsIgnoreCase(null, null)   = true
     * StringUtil.equalsIgnoreCase("", "")   = true
     * StringUtil.equalsIgnoreCase(" ", " ")   = true
     * StringUtil.equalsIgnoreCase(null, "abc")  = false
     * StringUtil.equalsIgnoreCase("abc", null)  = false
     * StringUtil.equalsIgnoreCase("abc", "abc") = true
     * StringUtil.equalsIgnoreCase("abc", "ABC") = true
     * StringUtil.equalsIgnoreCase(new String("ABC"), "abc") = true
     * </pre>
     *
     * @param cs1
     * @param cs2
     * @return
     */
    public static boolean equalsIgnoreCase(CharSequence cs1, CharSequence cs2) {
        return StringUtils.equalsIgnoreCase(cs1, cs2);
    }

    /**
     * <p>Gets a CharSequence length.
     * </p>
     * <pre>
     * StringUtil.length(ABc)   = 3
     * StringUtils.length("")   = 0
     * StringUtils.length(" ")   = 1
     * StringUtils.length(null)   = 0
     * StringUtils.length("我")   = 1
     * StringUtils.length("我a") = 2
     * StringUtils.length("'我/a'") = 5
     * </pre>
     *
     * @param cs
     * @return
     */
    public static int getLength(CharSequence cs) {
        return StringUtils.length(cs);
    }

    /**
     * <p> Get uuid string(32 bit) without "-".</p>
     *
     * @return
     */
    public static String getUUID() {
        return StringUtil.replace(UUID.randomUUID().toString(), "-", "");
    }

    /**
     * <p>Finds the first index within a CharSequence.
     * </p>
     * <pre>
     * StringUtil.indexOf(null, *)          = -1
     * StringUtil.indexOf(*, null)          = -1
     * StringUtil.indexOf("", "")           = 0
     * StringUtil.indexOf("aabaabaa", "a")  = 0
     * StringUtil.indexOf("aabaabaa", "b")  = 2
     * StringUtil.indexOf("aabaabaa", "ab") = 1
     * StringUtil.indexOf("aabaabaa", "")   = 0
     * </pre>
     *
     * @param str
     * @param searchStr
     * @return
     */
    public static int indexOf(String str, String searchStr) {
        return StringUtils.indexOf(str, searchStr);
    }

    /**
     * <p>Finds the first index within a CharSequence, ignoring case differences.
     * </p>
     * <pre>
     * StringUtil.indexOfIgnoreCase(null, *)          = -1
     * StringUtil.indexOfIgnoreCase(*, null)          = -1
     * StringUtil.indexOfIgnoreCase("", "")           = 0
     * StringUtil.indexOfIgnoreCase("Aabaabaa", "a")  = 0
     * StringUtil.indexOfIgnoreCase("aaBaabaa", "b")  = 2
     * StringUtil.indexOfIgnoreCase("aabaabaa", "ab") = 1
     * </pre>
     *
     * @param str
     * @param searchStr
     * @return ,
     */
    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr) {
        return StringUtils.indexOfIgnoreCase(str, searchStr);
    }

    /**
     * <p>Checks if a CharSequence is empty ("") or null.
     * </p>
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    /**
     * <p>Checks if a CharSequence is not empty ("") or null.
     * </p>
     * <pre>
     * StringUtil.isNotEmpty(null)      = false
     * StringUtil.isNotEmpty("")        = false
     * StringUtil.isNotEmpty(" ")       = true
     * StringUtil.isNotEmpty("bob")     = true
     * StringUtil.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return StringUtils.isNotEmpty(cs);
    }

    /**
     * <p>Joins the elements of the provided array into a single String
     * containing the provided list of elements.
     * </p>
     * <pre>
     * StringUtil.join(null, *)                = null
     * StringUtil.join([], *)                  = ""
     * StringUtil.join([null], *)              = ""
     * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtil.join(["a", "b", "c"], null)  = "abc"
     * StringUtil.join(["a", "b", "c"], "")    = "abc"
     * StringUtil.join([null, "", "a"], ',')   = ",,a"
     * StringUtil.join( ["a","b","b"], "a") = "aabab"
     * </pre>
     *
     * @param array
     * @param separator
     * @return
     */
    public static String join(Object[] array, String separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * <p>Joins the elements of the provided Iterable into a single String
     * containing the provided elements.
     * </p>
     * <pre>
     * StringUtil.join(null, *)                = null
     * StringUtil.join([], *)                  = ""
     * StringUtil.join([null], *)              = ""
     * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtil.join(["a", "b", "c"], null)  = "abc"
     * StringUtil.join(["a", "b", "c"], "")    = "abc"
     * StringUtil.join([null, "", "a"], ',')   = ",,a"
     * StringUtil.join( ["a","b","b"], "a") = "aabab"
     * </pre>
     *
     * @param list
     * @param separator
     * @return
     */
    public static String join(List list, String separator) {
        return StringUtils.join(list, separator);
    }

    /**
     * <p>Returns the index within <code>seq</code> of the last occurrence of
     * the specified character.
     * </p>
     * <pre>
     * StringUtils.lastIndexOf(null, *)         = -1
     * StringUtils.lastIndexOf("", *)           = -1
     * StringUtils.lastIndexOf("aabaabaa", 'a') = 7
     * StringUtils.lastIndexOf("aabaabaa", 'b') = 5
     * </pre>
     *
     * @param str
     * @param separator
     * @return the last index of the search character,
     */
    public static int lastIndexOf(String str, String separator) {
        return StringUtils.lastIndexOf(str, separator);
    }

    /**
     * <p>Case in-sensitive find of the last index within a CharSequence.
     * </p>
     * <pre>
     * StringUtil.lastIndexOfIgnoreCase(null, *)         = -1
     * StringUtil.lastIndexOfIgnoreCase("", *)           = -1
     * StringUtil.lastIndexOfIgnoreCase("aabaabaa", 'A') = 7
     * StringUtil.lastIndexOfIgnoreCase("aabaabaa", 'B') = 5
     * </pre>
     *
     * @param str
     * @param separator
     * @return
     */
    public static int lastIndexOfIgnoreCase(String str, String separator) {
        return StringUtils.lastIndexOfIgnoreCase(str, separator);
    }

    /**
     * <p>Left pad a String with spaces (' ').
     * </p>
     * <pre>
     * StringUtil.leftPad(null, *, *)      = null
     * StringUtil.leftPad("", 3, "z")      = "zzz"
     * StringUtil.leftPad("bat", 3, "yz")  = "bat"
     * StringUtil.leftPad("bat", 5, "yz")  = "yzbat"
     * StringUtil.leftPad("bat", 8, "yz")  = "yzyzybat"
     * StringUtil.leftPad("bat", 1, "yz")  = "bat"
     * StringUtil.leftPad("bat", -1, "yz") = "bat"
     * StringUtil.leftPad("bat", 5, null)  = "  bat"
     * StringUtil.leftPad("bat", 5, "")    = "  bat"
     * </pre>
     *
     * @param str
     * @param size
     * @return
     */
    public static String leftPad(String str, int size, String padStr) {
        return StringUtils.leftPad(str, size, padStr);
    }

    /**
     * <p>Converts a String to lower case.
     * </p>
     * <pre>
     * StringUtil.lowerCase(null)  = null
     * StringUtil.lowerCase("")    = ""
     * StringUtil.lowerCase(" ")    = " "
     * StringUtil.lowerCase("aBc") = "abc"
     * StringUtil.lowerCase("I110oO") = "i110oo"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String lowerCase(String str) {
        return StringUtils.lowerCase(str);
    }

    /**
     * <p>Format msg template {0}...{1}...{2}... with params array.
     * </p>
     * <pre>
     * StringUtil.messageFormat(null)  = null
     * StringUtil.messageFormat("")    = ""
     * StringUtil.messageFormat(" ")    = " "
     * StringUtil.messageFormat("a{0}b{1}c{2}","A","B","C") = "abc"
     * </pre>
     *
     * @param msg
     * @param params
     * @return
     */
    public static String messageFormat(String msg, Object... params) {
        if (StringUtil.isEmpty(msg)) {
            return msg;
        } else {
            return MessageFormat.format(msg, params);
        }
    }

    /**
     * <p>Repeat a String.
     * </p>
     * <pre>
     * StringUtil.repeat(null, 2) = null
     * StringUtil.repeat("", 0)   = ""
     * StringUtil.repeat("", 2)   = ""
     * StringUtil.repeat(" ", 2)   = "  "
     * StringUtil.repeat("a", 3)  = "aaa"
     * StringUtil.repeat("ab", 2) = "abab"
     * StringUtil.repeat("a", -2) = ""
     * StringUtil.repeat("abc", 0) =""
     * StringUtil.repeat(" abc ", 2) = " abc  abc "
     * </pre>
     *
     * @param str
     * @param repeat
     */
    public static String repeat(String str, int repeat) {
        return StringUtils.repeat(str, repeat);
    }

    /**
     * <p>Replaces all occurrences of a String within another String.
     * </p>
     * <pre>
     * StringUtil.replace(null, *, *)        = null
     * StringUtil.replace("", *, *)          = ""
     * StringUtil.replace("any", null, *)    = "any"
     * StringUtil.replace("any", *, null)    = "any"
     * StringUtil.replace("any", "", *)      = "any"
     * StringUtil.replace("aba", "a", null)  = "aba"
     * StringUtil.replace("aba", "a", "")    = "b"
     * StringUtil.replace("aba", "a", "z")   = "zbz"
     * StringUtil.replace("ABab", "AB", "A")   = "Aab"
     * </pre>
     *
     * @param text
     * @param searchString
     * @param replacement
     * @return
     */
    public static String replace(String text, String searchString, String replacement) {
        return StringUtils.replace(text, searchString, replacement);
    }

    /**
     * <p>Replaces first String with another String inside a larger String.
     * </p>
     * <pre>
     * StringUtil.replaceOnce("aba", "a", null)  = "aba"
     * StringUtil.replaceOnce("aba", "a", "")    = "ba"
     * StringUtil.replaceOnce("aba", "a", "z")   = "zba"
     * StringUtil.replaceOnce("ababab", "ba", "y"),"aybab")
     * </pre>
     *
     * @param text
     * @param searchString
     * @param replacement
     */
    public static String replaceFirst(String text, String searchString, String replacement) {
        return StringUtils.replaceOnce(text, searchString, replacement);
    }

    /**
     * <p>Replaces each substring of the source String that matches the given regular expression with the given
     * replacement using the Pattern option. DOTALL is also know as single-line mode in Perl.
     * </p>
     * <pre>
     * StringUtils.replacePattern("ABCabc123", "[a-z]", "_")       = "ABC___123"
     * StringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "_")  = "ABC_123"
     * StringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "")   = "ABC123"
     * </pre>
     *
     * @param source
     * @param regex       the regular expression to which this string is to be matched
     * @param replacement
     * @return
     */
    public static String replacePattern(String source, String regex, String replacement) {
        return StringUtils.replacePattern(source, regex, replacement);
    }

    /**
     * <p>Reverses a String.
     * </p>
     * <pre>
     * StringUtil.reverse(null)  = null
     * StringUtil.reverse("")    = ""
     * StringUtil.reverse("bat") = "tab"
     * StringUtil.reverse("a a ") = " a a"
     * StringUtil.reverse("{1,2,3,4,5}") = "}5,4,3,2,1{"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String reverse(String str) {
        return StringUtils.reverse(str);
    }

    /**
     * <p>Right pad a String with a specified character.
     * </p>
     * <pre>
     * StringUtil.rightPad(null, *, *)     = null
     * StringUtil.rightPad("", 3, 'z')     = "zzz"
     * StringUtil.rightPad("bat", 3, 'z')  = "bat"
     * StringUtil.rightPad("bat", 5, 'z')  = "batzz"
     * StringUtil.rightPad("bat", 1, 'z')  = "bat"
     * StringUtil.rightPad("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String rightPad(String str, int size, String padChar) {
        return StringUtils.rightPad(str, size, padChar);
    }

    /**
     * <p>Remove the last character from a String.
     * </p>
     * <pre>
     * StringUtil.removeLastChar(null)          = null
     * StringUtil.removeLastChar("")            = ""
     * StringUtil.removeLastChar("abc \r")      = "abc "
     * StringUtil.removeLastChar("abc\n")       = "abc"
     * StringUtil.removeLastChar("abc\r\n")     = "abc"
     * StringUtil.removeLastChar("abc")         = "ab"
     * StringUtil.removeLastChar("abc\nabc")    = "abc\nab"
     * StringUtil.removeLastChar("a")           = ""
     * StringUtil.removeLastChar("\r")          = ""
     * StringUtil.removeLastChar("\n")          = ""
     * StringUtil.removeLastChar("\r\n")        = ""
     * </pre>
     *
     * @param str
     * @return
     */
    public static String removeLastChar(String str) {
        return StringUtils.chop(str);
    }

    /**
     * <p>Returns either the passed in String,if the String is null the value of defaultStr.
     * </p>
     * <pre>
     * StringUtil.replaceNull(null, "abc") return "abc";
     * StringUtil.replaceNull("", null) return "";
     * StringUtil.replaceNull("abc", "a") return "abc" ;
     * StringUtil.replaceNull("null", "ab") return "null");
     * </pre>
     *
     * @param str
     * @param defaultStr the default String to return
     * @return
     */
    public static String replaceNull(String str, String... defaultStr) {
        if (ArrayUtil.isEmpty(defaultStr)) {
            return StringUtils.defaultString(str, StringUtil.EMPTY_STR);
        } else {
            return StringUtils.defaultString(str, defaultStr[0]);
        }
    }

    /**
     * <p>Splits the provided text into an array.
     * </p>
     * <pre>
     * StringUtils.split(null,*)       = null
     * StringUtils.split("",*)         = []
     * StringUtils.split("abc def"," ")  = ["abc", "def"]
     * StringUtils.split("abc  def"," ") = ["abc", "def"]
     * StringUtils.split(" abc "," ")    = ["abc"]
     * StringUtil.split("a,b,c,",  ",") = ["a","b","c"];
     * StringUtil.split("a,b,c",  ",") =["a","b","c"];
     * StringUtil.split(",a,b,c",  ",") = ["a","b","c"];
     * StringUtil.split(",a, b,c,",  ",") = ["a"," b","c"];
     * </pre>
     *
     * @param str the String to parse, may be null
     * @return an array of parsed Strings, {@code null} if null String input
     */
    public static String[] split(String str, String separatorChars) {
        return StringUtils.split(str, separatorChars);
    }

    /**
     * <p>Splits this string around matches of the given regular expression.
     * </p>
     * <pre>
     * StringUtil.splitPattern("a1b2c3d","[0-9]" )  = ["a","b","c","d"];
     * StringUtil.splitPattern(null,"[0-9]" ) = null;
     * StringUtil.splitPattern("","[0-9]" ) = []
     * StringUtil.splitPattern("","" )  = []
     * StringUtil.splitPattern("234",null)  throw NullPointerException
     * StringUtil.splitPattern("a1b2c3d","[a-z]" ) ,new String[]{"","1","2","3"}
     * </pre>
     *
     * @param str
     * @param regx
     * @return
     */
    public static String[] splitPattern(String str, String regx) {
        if (str == null) {
            return null;
        } else if ("".equals(str)) {
            return new String[0];
        } else {
            return str.split(regx);
        }
    }

    /**
     * <p>Check if a CharSequence starts with a specified prefix.
     * </p>
     * <pre>
     * StringUtils.startsWith(null, null)      = true
     * StringUtils.startsWith(null, "abc")     = false
     * StringUtils.startsWith("abcdef", null)  = false
     * StringUtils.startsWith("abcdef", "abc") = true
     * StringUtils.startsWith("ABCDEF", "abc") = false
     * </pre>
     *
     * @param str
     * @param prefix t
     * @return
     */
    public static boolean startsWith(CharSequence str, CharSequence prefix) {
        return StringUtils.startsWith(str, prefix);
    }

    /**
     * <p>Case insensitive check if a CharSequence starts with a specified prefix.
     * </p>
     * <pre>
     * StringUtils.startsWithIgnoreCase(null, null)      = true
     * StringUtils.startsWithIgnoreCase(null, "abc")     = false
     * StringUtils.startsWithIgnoreCase("abcdef", null)  = false
     * StringUtils.startsWithIgnoreCase("abcdef", "abc") = true
     * StringUtils.startsWithIgnoreCase("ABCDEF", "abc") = true
     * </pre>
     *
     * @param str
     * @param prefix
     * @return
     */
    public static boolean startsWithIgnoreCase(CharSequence str, CharSequence prefix) {
        return StringUtils.startsWithIgnoreCase(str, prefix);
    }

    /**
     * <p>Gets a substring from the specified String avoiding exceptions.
     * </p>
     * <pre>
     * StringUtil.substring(null, *)   = null
     * StringUtil.substring("", *)     = ""
     * StringUtil.substring("abc", 0)  = "abc"
     * StringUtil.substring("abc", 2)  = "c"
     * StringUtil.substring("abc", 4)  = ""
     * StringUtil.substring("abc", -2) = "bc"
     * StringUtil.substring("abc", -4) = "abc"
     * StringUtil.substring("abcf", -1) = "f"
     * </pre>
     *
     * @param str
     * @param start
     * @return
     */
    public static String subString(String str, int start) {
        return StringUtils.substring(str, start);
    }

    /**
     * <p>Gets a substring from the specified String avoiding exceptions.
     * </p>
     * <pre>
     * StringUtil.substring("abc", 0, 2)   = "ab"
     * StringUtil.substring("abc", 2, 0)   = ""
     * StringUtil.substring("abc", 2, 4)   = "c"
     * StringUtil.substring("abc", 4, 6)   = ""
     * StringUtil.substring("abc", 2, 2)   = ""
     * StringUtil.substring("abc", -2, -1) = "b"
     * StringUtil.substring("abc", -4, 2)  = "ab"
     * </pre>
     *
     * @param str
     * @param start
     * @param end
     * @return s
     */
    public static String subString(String str, int start, int end) {
        return StringUtils.substring(str, start, end);
    }

    /**
     * <p>Removes control characters.
     * </p>
     * <pre>
     * StringUtil.trim(null)          = null
     * StringUtil.trim("")            = ""
     * StringUtil.trim("     ")       = ""
     * StringUtil.trim("abc")         = "abc"
     * StringUtil.trim("    abc    ") = "abc"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * <p>Uncapitalizes a String.
     * </p>
     * <pre>
     * StringUtil.uncapitalize(null)  = null
     * StringUtil.uncapitalize("")    = ""
     * StringUtil.uncapitalize("cat") = "cat"
     * StringUtil.uncapitalize("Cat") = "cat"
     * StringUtil.uncapitalize("CAT") = "cAT"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String uncapitalize(String str) {
        return StringUtils.uncapitalize(str);
    }

    /**
     * <p> Wraps a String with another String.
     * </p>
     * <pre>
     * StringUtil.wrap(null, *)         = null
     * StringUtil.wrap("", *)           = ""
     * StringUtil.wrap("ab", null)      = "ab"
     * StringUtil.wrap("ab", "x")       = "xabx"
     * StringUtil.wrap("ab", "\"")      = "\"ab\""
     * StringUtil.wrap("\"ab\"", "\"")  = "\"\"ab\"\""
     * StringUtil.wrap("ab", "'")       = "'ab'"
     * </pre>
     *
     * @param str
     * @param wrapWith
     * @return
     */
    public static String wrap(String str, String wrapWith) {
        return StringUtils.wrap(str, wrapWith);
    }

    /**
     * <p>Unwraps a given string from anther string.
     * </p>
     * <pre>
     * StringUtils.unwrap(null, null)         = null
     * StringUtils.unwrap(null, "")           = null
     * StringUtils.unwrap(null, "1")          = null
     * StringUtils.unwrap("\'abc\'", "\'")    = "abc"
     * StringUtils.unwrap("\"abc\"", "\"")    = "abc"
     * StringUtils.unwrap("AABabcBAA", "AA")  = "BabcB"
     * StringUtils.unwrap("A", "#")           = "A"
     * StringUtils.unwrap("#A", "#")          = "#A"
     * StringUtils.unwrap("A#", "#")          = "A#"
     * </pre>
     *
     * @param str
     * @param wrapToken
     * @return
     */
    public static String unwrap(String str, String wrapToken) {
        return StringUtils.unwrap(str, wrapToken);
    }

    /**
     * <p>Converts a String to upper case.
     * </p>
     * <pre>
     * StringUtils.upperCase(null)  = null
     * StringUtils.upperCase("")    = ""
     * StringUtils.upperCase("aBc") = "ABC"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        return StringUtils.upperCase(str);
    }

    /**
     * <p>Change the uppercase character to lowercase and add underline before it.
     * </p>
     * <pre>
     * StringUtil.uncamel(null)  = null
     * StringUtil.uncamel("")  = ""
     * StringUtil.uncamel(" ")  = " "
     * StringUtil.uncamel("abCd")  = "ab_cd"
     * StringUtil.uncamel("abCdEf")  = "ab_cd_ef"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String uncamel(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        } else {
            String retStr = "";
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    retStr = retStr + StringUtil.UNDERLINE_STR + (c + "").toLowerCase();
                } else {
                    retStr = retStr + c;
                }
            }
            return retStr;
        }
    }
}
