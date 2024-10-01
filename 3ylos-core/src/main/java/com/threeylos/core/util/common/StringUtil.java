package com.threeylos.core.util.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * Operations on {@link java.lang.String} that are {@code null} safe.
 * </p>
 *
 * <ul>
 * <li><b>IsEmpty/IsBlank</b> - checks if a String contains text</li>
 * <li><b>Trim/Strip</b> - removes leading and trailing whitespace</li>
 * <li><b>Equals/Compare</b> - compares two strings null-safe</li>
 * <li><b>startsWith</b> - check if a String starts with a prefix null-safe</li>
 * <li><b>endsWith</b> - check if a String ends with a suffix null-safe</li>
 * <li><b>IndexOf/LastIndexOf/Contains</b> - null-safe index-of checks
 * <li><b>IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut</b> -
 * index-of any of a set of Strings</li>
 * <li><b>ContainsOnly/ContainsNone/ContainsAny</b> - does String contains
 * only/none/any of these characters</li>
 * <li><b>Substring/Left/Right/Mid</b> - null-safe substring extractions</li>
 * <li><b>SubstringBefore/SubstringAfter/SubstringBetween</b> - substring
 * extraction relative to other strings</li>
 * <li><b>Split/Join</b> - splits a String into an array of substrings and vice
 * versa</li>
 * <li><b>Remove/Delete</b> - removes part of a String</li>
 * <li><b>Replace/Overlay</b> - Searches a String and replaces one String with
 * another</li>
 * <li><b>Chomp/Chop</b> - removes the last part of a String</li>
 * <li><b>AppendIfMissing</b> - appends a suffix to the end of the String if not
 * present</li>
 * <li><b>PrependIfMissing</b> - prepends a prefix to the start of the String if
 * not present</li>
 * <li><b>LeftPad/RightPad/Center/Repeat</b> - pads a String</li>
 * <li><b>UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize</b> - changes the
 * case of a String</li>
 * <li><b>CountMatches</b> - counts the number of occurrences of one String in
 * another</li>
 * <li><b>IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable</b> - checks the
 * characters in a String</li>
 * <li><b>DefaultString</b> - protects against a null input String</li>
 * <li><b>Rotate</b> - rotate (circular shift) a String</li>
 * <li><b>Reverse/ReverseDelimited</b> - reverses a String</li>
 * <li><b>Abbreviate</b> - abbreviates a string using ellipsis or another given
 * String</li>
 * <li><b>Difference</b> - compares Strings and reports on their
 * differences</li>
 * <li><b>LevenshteinDistance</b> - the number of changes needed to change one
 * String into another</li>
 * </ul>
 *
 * <p>
 * The {@code StringUtils} class defines certain words related to String
 * handling.
 * </p>
 *
 * <ul>
 * <li>null - {@code null}</li>
 * <li>empty - a zero-length string ({@code ""})</li>
 * <li>space - the space character ({@code ' '}, char 32)</li>
 * <li>whitespace - the characters defined by
 * {@link Character#isWhitespace(char)}</li>
 * <li>trim - the characters &lt;= 32 as in {@link String#trim()}</li>
 * </ul>
 *
 * <p>
 * {@code StringUtils} handles {@code null} input Strings quietly. That is to
 * say that a {@code null} input will return {@code null}. Where a
 * {@code boolean} or {@code int} is being returned details vary by method.
 * </p>
 *
 * <p>
 * A side effect of the {@code null} handling is that a
 * {@code NullPointerException} should be considered a bug in
 * {@code StringUtils}.
 * </p>
 *
 * <p>
 * Methods in this class give sample code to explain their operation. The symbol
 * {@code *} is used to indicate any input including {@code null}.
 * </p>
 *
 * <p>
 * #ThreadSafe#
 * </p>
 * 
 * @see java.lang.String
 * @since 1.0
 * 
 * 
 * @author AbhinitKumar
 */
//@Immutable
public class StringUtil {

	/**
	 * <p>
	 * {@code StringUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code StringUtils.trim(" foo ");}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	private StringUtil() {
		super();
	}

	// Empty checks
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if a CharSequence is empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 *
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer trims the
	 * CharSequence. That functionality is available in isBlank().
	 * </p>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since 1.0 Changed signature from isEmpty(String) to isEmpty(CharSequence)
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return StringUtils.isEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty ("") and not null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotEmpty(null)      = false
	 * StringUtils.isNotEmpty("")        = false
	 * StringUtils.isNotEmpty(" ")       = true
	 * StringUtils.isNotEmpty("bob")     = true
	 * StringUtils.isNotEmpty("  bob  ") = true
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null
	 * @since 1.0 Changed signature from isNotEmpty(String) to
	 *        isNotEmpty(CharSequence)
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return StringUtils.isNotEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if any of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAnyEmpty((String) null)    = true
	 * StringUtils.isAnyEmpty((String[]) null)  = false
	 * StringUtils.isAnyEmpty(null, "foo")      = true
	 * StringUtils.isAnyEmpty("", "bar")        = true
	 * StringUtils.isAnyEmpty("bob", "")        = true
	 * StringUtils.isAnyEmpty("  bob  ", null)  = true
	 * StringUtils.isAnyEmpty(" ", "bar")       = false
	 * StringUtils.isAnyEmpty("foo", "bar")     = false
	 * StringUtils.isAnyEmpty(new String[]{})   = false
	 * StringUtils.isAnyEmpty(new String[]{""}) = true
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if any of the CharSequences are empty or null
	 * @since 1.0
	 */
	public static boolean isAnyEmpty(final CharSequence... css) {
		return StringUtils.isAnyEmpty(css);
	}

	/**
	 * <p>
	 * Checks if none of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNoneEmpty((String) null)    = false
	 * StringUtils.isNoneEmpty((String[]) null)  = true
	 * StringUtils.isNoneEmpty(null, "foo")      = false
	 * StringUtils.isNoneEmpty("", "bar")        = false
	 * StringUtils.isNoneEmpty("bob", "")        = false
	 * StringUtils.isNoneEmpty("  bob  ", null)  = false
	 * StringUtils.isNoneEmpty(new String[] {})  = true
	 * StringUtils.isNoneEmpty(new String[]{""}) = false
	 * StringUtils.isNoneEmpty(" ", "bar")       = true
	 * StringUtils.isNoneEmpty("foo", "bar")     = true
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if none of the CharSequences are empty or null
	 * @since 1.0
	 */
	public static boolean isNoneEmpty(final CharSequence... css) {
		return StringUtils.isNoneEmpty(css);
	}

	/**
	 * <p>
	 * Checks if all of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllEmpty(null)             = true
	 * StringUtils.isAllEmpty(null, "")         = true
	 * StringUtils.isAllEmpty(new String[] {})  = true
	 * StringUtils.isAllEmpty(null, "foo")      = false
	 * StringUtils.isAllEmpty("", "bar")        = false
	 * StringUtils.isAllEmpty("bob", "")        = false
	 * StringUtils.isAllEmpty("  bob  ", null)  = false
	 * StringUtils.isAllEmpty(" ", "bar")       = false
	 * StringUtils.isAllEmpty("foo", "bar")     = false
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if all of the CharSequences are empty or null
	 * @since 1.0
	 */
	public static boolean isAllEmpty(final CharSequence... css) {
		return StringUtils.isAllEmpty(css);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is empty (""), null or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace only
	 * @since 1.0
	 * @since 1.0 Changed signature from isBlank(String) to isBlank(CharSequence)
	 */
	public static boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotBlank(null)      = false
	 * StringUtils.isNotBlank("")        = false
	 * StringUtils.isNotBlank(" ")       = false
	 * StringUtils.isNotBlank("bob")     = true
	 * StringUtils.isNotBlank("  bob  ") = true
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and not
	 *         whitespace only
	 * @since 1.0
	 * @since 1.0 Changed signature from isNotBlank(String) to
	 *        isNotBlank(CharSequence)
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return StringUtils.isNotBlank(cs);
	}

	/**
	 * <p>
	 * Checks if any of the CharSequences are empty ("") or null or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAnyBlank((String) null)    = true
	 * StringUtils.isAnyBlank((String[]) null)  = false
	 * StringUtils.isAnyBlank(null, "foo")      = true
	 * StringUtils.isAnyBlank(null, null)       = true
	 * StringUtils.isAnyBlank("", "bar")        = true
	 * StringUtils.isAnyBlank("bob", "")        = true
	 * StringUtils.isAnyBlank("  bob  ", null)  = true
	 * StringUtils.isAnyBlank(" ", "bar")       = true
	 * StringUtils.isAnyBlank(new String[] {})  = false
	 * StringUtils.isAnyBlank(new String[]{""}) = true
	 * StringUtils.isAnyBlank("foo", "bar")     = false
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if any of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 1.0
	 */
	public static boolean isAnyBlank(final CharSequence... css) {
		return StringUtils.isAnyBlank(css);
	}

	/**
	 * <p>
	 * Checks if none of the CharSequences are empty (""), null or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNoneBlank((String) null)    = false
	 * StringUtils.isNoneBlank((String[]) null)  = true
	 * StringUtils.isNoneBlank(null, "foo")      = false
	 * StringUtils.isNoneBlank(null, null)       = false
	 * StringUtils.isNoneBlank("", "bar")        = false
	 * StringUtils.isNoneBlank("bob", "")        = false
	 * StringUtils.isNoneBlank("  bob  ", null)  = false
	 * StringUtils.isNoneBlank(" ", "bar")       = false
	 * StringUtils.isNoneBlank(new String[] {})  = true
	 * StringUtils.isNoneBlank(new String[]{""}) = false
	 * StringUtils.isNoneBlank("foo", "bar")     = true
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if none of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 1.0
	 */
	public static boolean isNoneBlank(final CharSequence... css) {
		return StringUtils.isNoneBlank(css);
	}

	/**
	 * <p>
	 * Checks if all of the CharSequences are empty (""), null or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllBlank(null)             = true
	 * StringUtils.isAllBlank(null, "foo")      = false
	 * StringUtils.isAllBlank(null, null)       = true
	 * StringUtils.isAllBlank("", "bar")        = false
	 * StringUtils.isAllBlank("bob", "")        = false
	 * StringUtils.isAllBlank("  bob  ", null)  = false
	 * StringUtils.isAllBlank(" ", "bar")       = false
	 * StringUtils.isAllBlank("foo", "bar")     = false
	 * StringUtils.isAllBlank(new String[] {})  = true
	 * </pre>
	 *
	 * @param css the CharSequences to check, may be null or empty
	 * @return {@code true} if all of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 1.0
	 */
	public static boolean isAllBlank(final CharSequence... css) {
		return StringUtils.isAllBlank(css);
	}

	// Trim
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String,
	 * handling {@code null} by returning {@code null}.
	 * </p>
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and end
	 * characters &lt;= 32. To strip whitespace use {@link #strip(String)}.
	 * </p>
	 *
	 * <p>
	 * To trim your choice of characters, use the {@link #strip(String, String)}
	 * methods.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trim(null)          = null
	 * StringUtils.trim("")            = ""
	 * StringUtils.trim("     ")       = ""
	 * StringUtils.trim("abc")         = "abc"
	 * StringUtils.trim("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str the String to be trimmed, may be null
	 * @return the trimmed string, {@code null} if null String input
	 */
	public static String trim(final String str) {
		return StringUtils.trim(str);
	}

	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String
	 * returning {@code null} if the String is empty ("") after the trim or if it is
	 * {@code null}.
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and end
	 * characters &lt;= 32. To strip whitespace use {@link #stripToNull(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trimToNull(null)          = null
	 * StringUtils.trimToNull("")            = null
	 * StringUtils.trimToNull("     ")       = null
	 * StringUtils.trimToNull("abc")         = "abc"
	 * StringUtils.trimToNull("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str the String to be trimmed, may be null
	 * @return the trimmed String, {@code null} if only chars &lt;= 32, empty or
	 *         null String input
	 * @since 1.0
	 */
	public static String trimToNull(final String str) {
		return StringUtils.trimToNull(str);
	}

	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String
	 * returning an empty String ("") if the String is empty ("") after the trim or
	 * if it is {@code null}.
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and end
	 * characters &lt;= 32. To strip whitespace use {@link #stripToEmpty(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trimToEmpty(null)          = ""
	 * StringUtils.trimToEmpty("")            = ""
	 * StringUtils.trimToEmpty("     ")       = ""
	 * StringUtils.trimToEmpty("abc")         = "abc"
	 * StringUtils.trimToEmpty("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str the String to be trimmed, may be null
	 * @return the trimmed String, or an empty String if {@code null} input
	 * @since 1.0
	 */
	public static String trimToEmpty(final String str) {
		return StringUtils.trimToEmpty(str);
	}

	/**
	 * <p>
	 * Truncates a String. This will turn "Now is the time for all good men" into
	 * "Now is the time for".
	 * </p>
	 *
	 * <p>
	 * Specifically:
	 * </p>
	 * <ul>
	 * <li>If {@code str} is less than {@code maxWidth} characters long, return
	 * it.</li>
	 * <li>Else truncate it to {@code substring(str, 0, maxWidth)}.</li>
	 * <li>If {@code maxWidth} is less than {@code 0}, throw an
	 * {@code IllegalArgumentException}.</li>
	 * <li>In no case will it return a String of length greater than
	 * {@code maxWidth}.</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.truncate(null, 0)       = null
	 * StringUtils.truncate(null, 2)       = null
	 * StringUtils.truncate("", 4)         = ""
	 * StringUtils.truncate("abcdefg", 4)  = "abcd"
	 * StringUtils.truncate("abcdefg", 6)  = "abcdef"
	 * StringUtils.truncate("abcdefg", 7)  = "abcdefg"
	 * StringUtils.truncate("abcdefg", 8)  = "abcdefg"
	 * StringUtils.truncate("abcdefg", -1) = throws an IllegalArgumentException
	 * </pre>
	 *
	 * @param str      the String to truncate, may be null
	 * @param maxWidth maximum length of result String, must be positive
	 * @return truncated String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String truncate(final String str, final int maxWidth) {
		return StringUtils.truncate(str, maxWidth);
	}

	/**
	 * <p>
	 * Truncates a String. This will turn "Now is the time for all good men" into
	 * "is the time for all".
	 * </p>
	 *
	 * <p>
	 * Works like {@code truncate(String, int)}, but allows you to specify a "left
	 * edge" offset.
	 *
	 * <p>
	 * Specifically:
	 * </p>
	 * <ul>
	 * <li>If {@code str} is less than {@code maxWidth} characters long, return
	 * it.</li>
	 * <li>Else truncate it to {@code substring(str, offset, maxWidth)}.</li>
	 * <li>If {@code maxWidth} is less than {@code 0}, throw an
	 * {@code IllegalArgumentException}.</li>
	 * <li>If {@code offset} is less than {@code 0}, throw an
	 * {@code IllegalArgumentException}.</li>
	 * <li>In no case will it return a String of length greater than
	 * {@code maxWidth}.</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.truncate(null, 0, 0) = null
	 * StringUtils.truncate(null, 2, 4) = null
	 * StringUtils.truncate("", 0, 10) = ""
	 * StringUtils.truncate("", 2, 10) = ""
	 * StringUtils.truncate("abcdefghij", 0, 3) = "abc"
	 * StringUtils.truncate("abcdefghij", 5, 6) = "fghij"
	 * StringUtils.truncate("raspberry peach", 10, 15) = "peach"
	 * StringUtils.truncate("abcdefghijklmno", 0, 10) = "abcdefghij"
	 * StringUtils.truncate("abcdefghijklmno", -1, 10) = throws an IllegalArgumentException
	 * StringUtils.truncate("abcdefghijklmno", Integer.MIN_VALUE, 10) = "abcdefghij"
	 * StringUtils.truncate("abcdefghijklmno", Integer.MIN_VALUE, Integer.MAX_VALUE) = "abcdefghijklmno"
	 * StringUtils.truncate("abcdefghijklmno", 0, Integer.MAX_VALUE) = "abcdefghijklmno"
	 * StringUtils.truncate("abcdefghijklmno", 1, 10) = "bcdefghijk"
	 * StringUtils.truncate("abcdefghijklmno", 2, 10) = "cdefghijkl"
	 * StringUtils.truncate("abcdefghijklmno", 3, 10) = "defghijklm"
	 * StringUtils.truncate("abcdefghijklmno", 4, 10) = "efghijklmn"
	 * StringUtils.truncate("abcdefghijklmno", 5, 10) = "fghijklmno"
	 * StringUtils.truncate("abcdefghijklmno", 5, 5) = "fghij"
	 * StringUtils.truncate("abcdefghijklmno", 5, 3) = "fgh"
	 * StringUtils.truncate("abcdefghijklmno", 10, 3) = "klm"
	 * StringUtils.truncate("abcdefghijklmno", 10, Integer.MAX_VALUE) = "klmno"
	 * StringUtils.truncate("abcdefghijklmno", 13, 1) = "n"
	 * StringUtils.truncate("abcdefghijklmno", 13, Integer.MAX_VALUE) = "no"
	 * StringUtils.truncate("abcdefghijklmno", 14, 1) = "o"
	 * StringUtils.truncate("abcdefghijklmno", 14, Integer.MAX_VALUE) = "o"
	 * StringUtils.truncate("abcdefghijklmno", 15, 1) = ""
	 * StringUtils.truncate("abcdefghijklmno", 15, Integer.MAX_VALUE) = ""
	 * StringUtils.truncate("abcdefghijklmno", Integer.MAX_VALUE, Integer.MAX_VALUE) = ""
	 * StringUtils.truncate("abcdefghij", 3, -1) = throws an IllegalArgumentException
	 * StringUtils.truncate("abcdefghij", -2, 4) = throws an IllegalArgumentException
	 * </pre>
	 *
	 * @param str      the String to check, may be null
	 * @param offset   left edge of source String
	 * @param maxWidth maximum length of result String, must be positive
	 * @return truncated String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String truncate(final String str, final int offset, final int maxWidth) {
		return StringUtils.truncate(str, offset, maxWidth);
	}

	// Stripping
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Strips whitespace from the start and end of a String.
	 * </p>
	 *
	 * <p>
	 * This is similar to {@link #trim(String)} but removes whitespace. Whitespace
	 * is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.strip(null)     = null
	 * StringUtils.strip("")       = ""
	 * StringUtils.strip("   ")    = ""
	 * StringUtils.strip("abc")    = "abc"
	 * StringUtils.strip("  abc")  = "abc"
	 * StringUtils.strip("abc  ")  = "abc"
	 * StringUtils.strip(" abc ")  = "abc"
	 * StringUtils.strip(" ab c ") = "ab c"
	 * </pre>
	 *
	 * @param str the String to remove whitespace from, may be null
	 * @return the stripped String, {@code null} if null String input
	 */
	public static String strip(final String str) {
		return StringUtils.strip(str);
	}

	/**
	 * <p>
	 * Strips whitespace from the start and end of a String returning {@code null}
	 * if the String is empty ("") after the strip.
	 * </p>
	 *
	 * <p>
	 * This is similar to {@link #trimToNull(String)} but removes whitespace.
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripToNull(null)     = null
	 * StringUtils.stripToNull("")       = null
	 * StringUtils.stripToNull("   ")    = null
	 * StringUtils.stripToNull("abc")    = "abc"
	 * StringUtils.stripToNull("  abc")  = "abc"
	 * StringUtils.stripToNull("abc  ")  = "abc"
	 * StringUtils.stripToNull(" abc ")  = "abc"
	 * StringUtils.stripToNull(" ab c ") = "ab c"
	 * </pre>
	 *
	 * @param str the String to be stripped, may be null
	 * @return the stripped String, {@code null} if whitespace, empty or null String
	 *         input
	 * @since 1.0
	 */
	public static String stripToNull(String str) {
		return StringUtils.stripToNull(str);
	}

	/**
	 * <p>
	 * Strips whitespace from the start and end of a String returning an empty
	 * String if {@code null} input.
	 * </p>
	 *
	 * <p>
	 * This is similar to {@link #trimToEmpty(String)} but removes whitespace.
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripToEmpty(null)     = ""
	 * StringUtils.stripToEmpty("")       = ""
	 * StringUtils.stripToEmpty("   ")    = ""
	 * StringUtils.stripToEmpty("abc")    = "abc"
	 * StringUtils.stripToEmpty("  abc")  = "abc"
	 * StringUtils.stripToEmpty("abc  ")  = "abc"
	 * StringUtils.stripToEmpty(" abc ")  = "abc"
	 * StringUtils.stripToEmpty(" ab c ") = "ab c"
	 * </pre>
	 *
	 * @param str the String to be stripped, may be null
	 * @return the trimmed String, or an empty String if {@code null} input
	 * @since 1.0
	 */
	public static String stripToEmpty(final String str) {
		return StringUtils.stripToEmpty(str);
	}

	/**
	 * <p>
	 * Strips any of a set of characters from the start and end of a String. This is
	 * similar to {@link String#trim()} but allows the characters to be stripped to
	 * be controlled.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. An empty string ("") input
	 * returns the empty string.
	 * </p>
	 *
	 * <p>
	 * If the stripChars String is {@code null}, whitespace is stripped as defined
	 * by {@link Character#isWhitespace(char)}. Alternatively use
	 * {@link #strip(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.strip(null, *)          = null
	 * StringUtils.strip("", *)            = ""
	 * StringUtils.strip("abc", null)      = "abc"
	 * StringUtils.strip("  abc", null)    = "abc"
	 * StringUtils.strip("abc  ", null)    = "abc"
	 * StringUtils.strip(" abc ", null)    = "abc"
	 * StringUtils.strip("  abcyx", "xyz") = "  abc"
	 * </pre>
	 *
	 * @param str        the String to remove characters from, may be null
	 * @param stripChars the characters to remove, null treated as whitespace
	 * @return the stripped String, {@code null} if null String input
	 */
	public static String strip(String str, final String stripChars) {
		return StringUtils.strip(stripChars);
	}

	/**
	 * <p>
	 * Strips any of a set of characters from the start of a String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. An empty string ("") input
	 * returns the empty string.
	 * </p>
	 *
	 * <p>
	 * If the stripChars String is {@code null}, whitespace is stripped as defined
	 * by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripStart(null, *)          = null
	 * StringUtils.stripStart("", *)            = ""
	 * StringUtils.stripStart("abc", "")        = "abc"
	 * StringUtils.stripStart("abc", null)      = "abc"
	 * StringUtils.stripStart("  abc", null)    = "abc"
	 * StringUtils.stripStart("abc  ", null)    = "abc  "
	 * StringUtils.stripStart(" abc ", null)    = "abc "
	 * StringUtils.stripStart("yxabc  ", "xyz") = "abc  "
	 * </pre>
	 *
	 * @param str        the String to remove characters from, may be null
	 * @param stripChars the characters to remove, null treated as whitespace
	 * @return the stripped String, {@code null} if null String input
	 */
	public static String stripStart(final String str, final String stripChars) {
		return StringUtils.stripStart(str, stripChars);
	}

	/**
	 * <p>
	 * Strips any of a set of characters from the end of a String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. An empty string ("") input
	 * returns the empty string.
	 * </p>
	 *
	 * <p>
	 * If the stripChars String is {@code null}, whitespace is stripped as defined
	 * by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripEnd(null, *)          = null
	 * StringUtils.stripEnd("", *)            = ""
	 * StringUtils.stripEnd("abc", "")        = "abc"
	 * StringUtils.stripEnd("abc", null)      = "abc"
	 * StringUtils.stripEnd("  abc", null)    = "  abc"
	 * StringUtils.stripEnd("abc  ", null)    = "abc"
	 * StringUtils.stripEnd(" abc ", null)    = " abc"
	 * StringUtils.stripEnd("  abcyx", "xyz") = "  abc"
	 * StringUtils.stripEnd("120.00", ".0")   = "12"
	 * </pre>
	 *
	 * @param str        the String to remove characters from, may be null
	 * @param stripChars the set of characters to remove, null treated as whitespace
	 * @return the stripped String, {@code null} if null String input
	 */
	public static String stripEnd(final String str, final String stripChars) {
		return StringUtils.stripEnd(str, stripChars);
	}

	// StripAll
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Strips whitespace from the start and end of every String in an array.
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * A new array is returned each time, except for length zero. A {@code null}
	 * array will return {@code null}. An empty array will return itself. A
	 * {@code null} array entry will be ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripAll(null)             = null
	 * StringUtils.stripAll([])               = []
	 * StringUtils.stripAll(["abc", "  abc"]) = ["abc", "abc"]
	 * StringUtils.stripAll(["abc  ", null])  = ["abc", null]
	 * </pre>
	 *
	 * @param strs the array to remove whitespace from, may be null
	 * @return the stripped Strings, {@code null} if null array input
	 */
	public static String[] stripAll(final String... strs) {
		return StringUtils.stripAll(strs);
	}

	/**
	 * <p>
	 * Strips any of a set of characters from the start and end of every String in
	 * an array.
	 * </p>
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * A new array is returned each time, except for length zero. A {@code null}
	 * array will return {@code null}. An empty array will return itself. A
	 * {@code null} array entry will be ignored. A {@code null} stripChars will
	 * strip whitespace as defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripAll(null, *)                = null
	 * StringUtils.stripAll([], *)                  = []
	 * StringUtils.stripAll(["abc", "  abc"], null) = ["abc", "abc"]
	 * StringUtils.stripAll(["abc  ", null], null)  = ["abc", null]
	 * StringUtils.stripAll(["abc  ", null], "yz")  = ["abc  ", null]
	 * StringUtils.stripAll(["yabcz", null], "yz")  = ["abc", null]
	 * </pre>
	 *
	 * @param strs       the array to remove characters from, may be null
	 * @param stripChars the characters to remove, null treated as whitespace
	 * @return the stripped Strings, {@code null} if null array input
	 */
	public static String[] stripAll(final String[] strs, final String stripChars) {
		return StringUtils.stripAll(strs, stripChars);
	}

	/**
	 * <p>
	 * Removes diacritics (~= accents) from a string. The case will not be altered.
	 * </p>
	 * <p>
	 * For instance, '&agrave;' will be replaced by 'a'.
	 * </p>
	 * <p>
	 * Note that ligatures will be left as is.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.stripAccents(null)                = null
	 * StringUtils.stripAccents("")                  = ""
	 * StringUtils.stripAccents("control")           = "control"
	 * StringUtils.stripAccents("&eacute;clair")     = "eclair"
	 * </pre>
	 *
	 * @param input String to be stripped
	 * @return input text with diacritics removed
	 *
	 * @since 1.0
	 */
	// See also Lucene's ASCIIFoldingFilter (Lucene 2.9) that replaces accented
	// characters by their unaccented equivalent (and uncommitted bug fix:
	// https://issues.apache.org/jira/browse/LUCENE-1343?focusedCommentId=12858907&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#action_12858907).
	public static String stripAccents(final String input) {
		return StringUtils.stripAccents(input);
	}

	// Equals
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compares two CharSequences, returning {@code true} if they represent equal
	 * sequences of characters.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references are
	 * considered to be equal. The comparison is <strong>case sensitive</strong>.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.equals(null, null)   = true
	 * StringUtils.equals(null, "abc")  = false
	 * StringUtils.equals("abc", null)  = false
	 * StringUtils.equals("abc", "abc") = true
	 * StringUtils.equals("abc", "ABC") = false
	 * </pre>
	 *
	 * @param cs1 the first CharSequence, may be {@code null}
	 * @param cs2 the second CharSequence, may be {@code null}
	 * @return {@code true} if the CharSequences are equal (case-sensitive), or both
	 *         {@code null}
	 * @since 1.0 Changed signature from equals(String, String) to
	 *        equals(CharSequence, CharSequence)
	 * @see Object#equals(Object)
	 * @see #equalsIgnoreCase(CharSequence, CharSequence)
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		return StringUtils.equals(cs1, cs2);
	}

	// Compare
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compare two Strings lexicographically, as per
	 * {@link String#compareTo(String)}, returning :
	 * </p>
	 * <ul>
	 * <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both
	 * {@code null})</li>
	 * <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
	 * <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
	 * </ul>
	 *
	 * <p>
	 * This is a {@code null} safe version of :
	 * </p>
	 * <blockquote>
	 * 
	 * <pre>
	 * str1.compareTo(str2)
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * <p>
	 * {@code null} value is considered less than non-{@code null} value. Two
	 * {@code null} references are considered equal.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.compare(null, null)   = 0
	 * StringUtils.compare(null , "a")   &lt; 0
	 * StringUtils.compare("a", null)    &gt; 0
	 * StringUtils.compare("abc", "abc") = 0
	 * StringUtils.compare("a", "b")     &lt; 0
	 * StringUtils.compare("b", "a")     &gt; 0
	 * StringUtils.compare("a", "B")     &gt; 0
	 * StringUtils.compare("ab", "abc")  &lt; 0
	 * </pre>
	 *
	 * @see #compare(String, String, boolean)
	 * @see String#compareTo(String)
	 * @param str1 the String to compare from
	 * @param str2 the String to compare to
	 * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal or
	 *         greater than {@code str2}
	 * @since 1.0
	 */
	public static int compare(final String str1, final String str2) {
		return StringUtils.compare(str1, str2);
	}

	/**
	 * <p>
	 * Compare two Strings lexicographically, as per
	 * {@link String#compareTo(String)}, returning :
	 * </p>
	 * <ul>
	 * <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both
	 * {@code null})</li>
	 * <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
	 * <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
	 * </ul>
	 *
	 * <p>
	 * This is a {@code null} safe version of :
	 * </p>
	 * <blockquote>
	 * 
	 * <pre>
	 * str1.compareTo(str2)
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * <p>
	 * {@code null} inputs are handled according to the {@code nullIsLess}
	 * parameter. Two {@code null} references are considered equal.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.compare(null, null, *)     = 0
	 * StringUtils.compare(null , "a", true)  &lt; 0
	 * StringUtils.compare(null , "a", false) &gt; 0
	 * StringUtils.compare("a", null, true)   &gt; 0
	 * StringUtils.compare("a", null, false)  &lt; 0
	 * StringUtils.compare("abc", "abc", *)   = 0
	 * StringUtils.compare("a", "b", *)       &lt; 0
	 * StringUtils.compare("b", "a", *)       &gt; 0
	 * StringUtils.compare("a", "B", *)       &gt; 0
	 * StringUtils.compare("ab", "abc", *)    &lt; 0
	 * </pre>
	 *
	 * @see String#compareTo(String)
	 * @param str1       the String to compare from
	 * @param str2       the String to compare to
	 * @param nullIsLess whether consider {@code null} value less than
	 *                   non-{@code null} value
	 * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou
	 *         greater than {@code str2}
	 * @since 1.0
	 */
	public static int compare(final String str1, final String str2, final boolean nullIsLess) {
		return StringUtils.compare(str1, str2, nullIsLess);
	}

	/**
	 * <p>
	 * Compare two Strings lexicographically, ignoring case differences, as per
	 * {@link String#compareToIgnoreCase(String)}, returning :
	 * </p>
	 * <ul>
	 * <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both
	 * {@code null})</li>
	 * <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
	 * <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
	 * </ul>
	 *
	 * <p>
	 * This is a {@code null} safe version of :
	 * </p>
	 * <blockquote>
	 * 
	 * <pre>
	 * str1.compareToIgnoreCase(str2)
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * <p>
	 * {@code null} value is considered less than non-{@code null} value. Two
	 * {@code null} references are considered equal. Comparison is case insensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.compareIgnoreCase(null, null)   = 0
	 * StringUtils.compareIgnoreCase(null , "a")   &lt; 0
	 * StringUtils.compareIgnoreCase("a", null)    &gt; 0
	 * StringUtils.compareIgnoreCase("abc", "abc") = 0
	 * StringUtils.compareIgnoreCase("abc", "ABC") = 0
	 * StringUtils.compareIgnoreCase("a", "b")     &lt; 0
	 * StringUtils.compareIgnoreCase("b", "a")     &gt; 0
	 * StringUtils.compareIgnoreCase("a", "B")     &lt; 0
	 * StringUtils.compareIgnoreCase("A", "b")     &lt; 0
	 * StringUtils.compareIgnoreCase("ab", "ABC")  &lt; 0
	 * </pre>
	 *
	 * @see #compareIgnoreCase(String, String, boolean)
	 * @see String#compareToIgnoreCase(String)
	 * @param str1 the String to compare from
	 * @param str2 the String to compare to
	 * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou
	 *         greater than {@code str2}, ignoring case differences.
	 * @since 1.0
	 */
	public static int compareIgnoreCase(final String str1, final String str2) {
		return StringUtils.compareIgnoreCase(str1, str2);
	}

	/**
	 * <p>
	 * Compare two Strings lexicographically, ignoring case differences, as per
	 * {@link String#compareToIgnoreCase(String)}, returning :
	 * </p>
	 * <ul>
	 * <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both
	 * {@code null})</li>
	 * <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
	 * <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
	 * </ul>
	 *
	 * <p>
	 * This is a {@code null} safe version of :
	 * </p>
	 * <blockquote>
	 * 
	 * <pre>
	 * str1.compareToIgnoreCase(str2)
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * <p>
	 * {@code null} inputs are handled according to the {@code nullIsLess}
	 * parameter. Two {@code null} references are considered equal. Comparison is
	 * case insensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.compareIgnoreCase(null, null, *)     = 0
	 * StringUtils.compareIgnoreCase(null , "a", true)  &lt; 0
	 * StringUtils.compareIgnoreCase(null , "a", false) &gt; 0
	 * StringUtils.compareIgnoreCase("a", null, true)   &gt; 0
	 * StringUtils.compareIgnoreCase("a", null, false)  &lt; 0
	 * StringUtils.compareIgnoreCase("abc", "abc", *)   = 0
	 * StringUtils.compareIgnoreCase("abc", "ABC", *)   = 0
	 * StringUtils.compareIgnoreCase("a", "b", *)       &lt; 0
	 * StringUtils.compareIgnoreCase("b", "a", *)       &gt; 0
	 * StringUtils.compareIgnoreCase("a", "B", *)       &lt; 0
	 * StringUtils.compareIgnoreCase("A", "b", *)       &lt; 0
	 * StringUtils.compareIgnoreCase("ab", "abc", *)    &lt; 0
	 * </pre>
	 *
	 * @see String#compareToIgnoreCase(String)
	 * @param str1       the String to compare from
	 * @param str2       the String to compare to
	 * @param nullIsLess whether consider {@code null} value less than
	 *                   non-{@code null} value
	 * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou
	 *         greater than {@code str2}, ignoring case differences.
	 * @since 1.0
	 */
	public static int compareIgnoreCase(final String str1, final String str2, final boolean nullIsLess) {
		return StringUtils.compareIgnoreCase(str1, str2, nullIsLess);
	}

	/**
	 * <p>
	 * Compares given <code>string</code> to a CharSequences vararg of
	 * <code>searchStrings</code>, returning {@code true} if the <code>string</code>
	 * is equal to any of the <code>searchStrings</code>.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.equalsAny(null, (CharSequence[]) null) = false
	 * StringUtils.equalsAny(null, null, null)    = true
	 * StringUtils.equalsAny(null, "abc", "def")  = false
	 * StringUtils.equalsAny("abc", null, "def")  = false
	 * StringUtils.equalsAny("abc", "abc", "def") = true
	 * StringUtils.equalsAny("abc", "ABC", "DEF") = false
	 * </pre>
	 *
	 * @param string        to compare, may be {@code null}.
	 * @param searchStrings a vararg of strings, may be {@code null}.
	 * @return {@code true} if the string is equal (case-sensitive) to any other
	 *         element of <code>searchStrings</code>; {@code false} if
	 *         <code>searchStrings</code> is null or contains no matches.
	 * @since 1.0
	 */
	public static boolean equalsAny(final CharSequence string, final CharSequence... searchStrings) {
		return StringUtils.equalsAny(string, searchStrings);
	}

	/**
	 * <p>
	 * Check whether the given CharSequence contains any whitespace characters.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param seq the CharSequence to check (may be {@code null})
	 * @return {@code true} if the CharSequence is not empty and contains at least 1
	 *         (breaking) whitespace character
	 * @since 1.0
	 */
	// From org.springframework.util.StringUtils, under Apache License 2.0
	public static boolean containsWhitespace(final CharSequence seq) {
		return StringUtils.containsWhitespace(seq);
	}

	// IndexOfAny chars
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Search a CharSequence to find the first index of any character in the given
	 * set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code -1}. A {@code null} or zero length
	 * search array will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAny(null, *)                  = -1
	 * StringUtils.indexOfAny("", *)                    = -1
	 * StringUtils.indexOfAny(*, null)                  = -1
	 * StringUtils.indexOfAny(*, [])                    = -1
	 * StringUtils.indexOfAny("zzabyycdxx", ['z', 'a']) = 0
	 * StringUtils.indexOfAny("zzabyycdxx", ['b', 'y']) = 3
	 * StringUtils.indexOfAny("aba", ['z'])             = -1
	 * </pre>
	 *
	 * @param cs          the CharSequence to check, may be null
	 * @param searchChars the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 1.0
	 * @since 1.0 Changed signature from indexOfAny(String, char[]) to
	 *        indexOfAny(CharSequence, char...)
	 */
	public static int indexOfAny(final CharSequence cs, final char... searchChars) {
		return StringUtils.indexOfAny(cs, searchChars);
	}

	/**
	 * <p>
	 * Search a CharSequence to find the first index of any character in the given
	 * set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code -1}. A {@code null} search string
	 * will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAny(null, *)            = -1
	 * StringUtils.indexOfAny("", *)              = -1
	 * StringUtils.indexOfAny(*, null)            = -1
	 * StringUtils.indexOfAny(*, "")              = -1
	 * StringUtils.indexOfAny("zzabyycdxx", "za") = 0
	 * StringUtils.indexOfAny("zzabyycdxx", "by") = 3
	 * StringUtils.indexOfAny("aba", "z")         = -1
	 * </pre>
	 *
	 * @param cs          the CharSequence to check, may be null
	 * @param searchChars the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 1.0
	 * @since 1.0 Changed signature from indexOfAny(String, String) to
	 *        indexOfAny(CharSequence, String)
	 */
	public static int indexOfAny(final CharSequence cs, final String searchChars) {
		return StringUtils.indexOfAny(cs, searchChars);
	}

	// ContainsAny
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains any character in the given set of
	 * characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null} or zero
	 * length search array will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsAny(null, *)                  = false
	 * StringUtils.containsAny("", *)                    = false
	 * StringUtils.containsAny(*, null)                  = false
	 * StringUtils.containsAny(*, [])                    = false
	 * StringUtils.containsAny("zzabyycdxx", ['z', 'a']) = true
	 * StringUtils.containsAny("zzabyycdxx", ['b', 'y']) = true
	 * StringUtils.containsAny("zzabyycdxx", ['z', 'y']) = true
	 * StringUtils.containsAny("aba", ['z'])             = false
	 * </pre>
	 *
	 * @param cs          the CharSequence to check, may be null
	 * @param searchChars the chars to search for, may be null
	 * @return the {@code true} if any of the chars are found, {@code false} if no
	 *         match or null input
	 * @since 1.0
	 * @since 1.0 Changed signature from containsAny(String, char[]) to
	 *        containsAny(CharSequence, char...)
	 */
	public static boolean containsAny(final CharSequence cs, final char... searchChars) {
		return StringUtils.containsAny(cs, searchChars);
	}

	// IndexOfAnyBut chars
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Searches a CharSequence to find the first index of any character not in the
	 * given set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A {@code null} or zero
	 * length search array will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAnyBut(null, *)                              = -1
	 * StringUtils.indexOfAnyBut("", *)                                = -1
	 * StringUtils.indexOfAnyBut(*, null)                              = -1
	 * StringUtils.indexOfAnyBut(*, [])                                = -1
	 * StringUtils.indexOfAnyBut("zzabyycdxx", new char[] {'z', 'a'} ) = 3
	 * StringUtils.indexOfAnyBut("aba", new char[] {'z'} )             = 0
	 * StringUtils.indexOfAnyBut("aba", new char[] {'a', 'b'} )        = -1
	 * 
	 * </pre>
	 *
	 * @param cs          the CharSequence to check, may be null
	 * @param searchChars the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 1.0
	 * @since 1.0 Changed signature from indexOfAnyBut(String, char[]) to
	 *        indexOfAnyBut(CharSequence, char...)
	 */
	public static int indexOfAnyBut(final CharSequence cs, final char... searchChars) {
		return StringUtils.indexOfAnyBut(cs, searchChars);
	}

	// ContainsOnly
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains only certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null} valid
	 * character array will return {@code false}. An empty CharSequence (length()=0)
	 * always returns {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsOnly(null, *)       = false
	 * StringUtils.containsOnly(*, null)       = false
	 * StringUtils.containsOnly("", *)         = true
	 * StringUtils.containsOnly("ab", '')      = false
	 * StringUtils.containsOnly("abab", 'abc') = true
	 * StringUtils.containsOnly("ab1", 'abc')  = false
	 * StringUtils.containsOnly("abz", 'abc')  = false
	 * </pre>
	 *
	 * @param cs    the String to check, may be null
	 * @param valid an array of valid chars, may be null
	 * @return true if it only contains valid chars and is non-null
	 * @since 1.0 Changed signature from containsOnly(String, char[]) to
	 *        containsOnly(CharSequence, char...)
	 */
	public static boolean containsOnly(final CharSequence cs, final char... valid) {
		return StringUtils.containsOnly(cs, valid);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null} valid
	 * character String will return {@code false}. An empty String (length()=0)
	 * always returns {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsOnly(null, *)       = false
	 * StringUtils.containsOnly(*, null)       = false
	 * StringUtils.containsOnly("", *)         = true
	 * StringUtils.containsOnly("ab", "")      = false
	 * StringUtils.containsOnly("abab", "abc") = true
	 * StringUtils.containsOnly("ab1", "abc")  = false
	 * StringUtils.containsOnly("abz", "abc")  = false
	 * </pre>
	 *
	 * @param cs         the CharSequence to check, may be null
	 * @param validChars a String of valid chars, may be null
	 * @return true if it only contains valid chars and is non-null
	 * @since 1.0
	 * @since 1.0 Changed signature from containsOnly(String, String) to
	 *        containsOnly(CharSequence, String)
	 */
	public static boolean containsOnly(final CharSequence cs, final String validChars) {
		return StringUtils.containsOnly(cs, validChars);
	}

	// ContainsNone
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks that the CharSequence does not contain certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code true}. A {@code null} invalid
	 * character array will return {@code true}. An empty CharSequence (length()=0)
	 * always returns true.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsNone(null, *)       = true
	 * StringUtils.containsNone(*, null)       = true
	 * StringUtils.containsNone("", *)         = true
	 * StringUtils.containsNone("ab", '')      = true
	 * StringUtils.containsNone("abab", 'xyz') = true
	 * StringUtils.containsNone("ab1", 'xyz')  = true
	 * StringUtils.containsNone("abz", 'xyz')  = false
	 * </pre>
	 *
	 * @param cs          the CharSequence to check, may be null
	 * @param searchChars an array of invalid chars, may be null
	 * @return true if it contains none of the invalid chars, or is null
	 * @since 1.0
	 * @since 1.0 Changed signature from containsNone(String, char[]) to
	 *        containsNone(CharSequence, char...)
	 */
	public static boolean containsNone(final CharSequence cs, final char... searchChars) {
		return StringUtils.containsNone(cs, searchChars);
	}

	/**
	 * <p>
	 * Checks that the CharSequence does not contain certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code true}. A {@code null} invalid
	 * character array will return {@code true}. An empty String ("") always returns
	 * true.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsNone(null, *)       = true
	 * StringUtils.containsNone(*, null)       = true
	 * StringUtils.containsNone("", *)         = true
	 * StringUtils.containsNone("ab", "")      = true
	 * StringUtils.containsNone("abab", "xyz") = true
	 * StringUtils.containsNone("ab1", "xyz")  = true
	 * StringUtils.containsNone("abz", "xyz")  = false
	 * </pre>
	 *
	 * @param cs           the CharSequence to check, may be null
	 * @param invalidChars a String of invalid chars, may be null
	 * @return true if it contains none of the invalid chars, or is null
	 * @since 1.0
	 * @since 1.0 Changed signature from containsNone(String, String) to
	 *        containsNone(CharSequence, String)
	 */
	public static boolean containsNone(final CharSequence cs, final String invalidChars) {
		return StringUtils.containsNone(cs, invalidChars);
	}

	// Substring
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets a substring from the specified String avoiding exceptions.
	 * </p>
	 *
	 * <p>
	 * A negative start position can be used to start {@code n} characters from the
	 * end of the String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code null}. An empty ("") String will
	 * return "".
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substring(null, *)   = null
	 * StringUtils.substring("", *)     = ""
	 * StringUtils.substring("abc", 0)  = "abc"
	 * StringUtils.substring("abc", 2)  = "c"
	 * StringUtils.substring("abc", 4)  = ""
	 * StringUtils.substring("abc", -2) = "bc"
	 * StringUtils.substring("abc", -4) = "abc"
	 * </pre>
	 *
	 * @param str   the String to get the substring from, may be null
	 * @param start the position to start from, negative means count back from the
	 *              end of the String by this many characters
	 * @return substring from start position, {@code null} if null String input
	 */
	public static String substring(final String str, int start) {
		return StringUtils.substring(str, start);
	}

	/**
	 * <p>
	 * Gets a substring from the specified String avoiding exceptions.
	 * </p>
	 *
	 * <p>
	 * A negative start position can be used to start/end {@code n} characters from
	 * the end of the String.
	 * </p>
	 *
	 * <p>
	 * The returned substring starts with the character in the {@code start}
	 * position and ends before the {@code end} position. All position counting is
	 * zero-based -- i.e., to start at the beginning of the string use
	 * {@code start = 0}. Negative start and end positions can be used to specify
	 * offsets relative to the end of the String.
	 * </p>
	 *
	 * <p>
	 * If {@code start} is not strictly to the left of {@code end}, "" is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substring(null, *, *)    = null
	 * StringUtils.substring("", * ,  *)    = "";
	 * StringUtils.substring("abc", 0, 2)   = "ab"
	 * StringUtils.substring("abc", 2, 0)   = ""
	 * StringUtils.substring("abc", 2, 4)   = "c"
	 * StringUtils.substring("abc", 4, 6)   = ""
	 * StringUtils.substring("abc", 2, 2)   = ""
	 * StringUtils.substring("abc", -2, -1) = "b"
	 * StringUtils.substring("abc", -4, 2)  = "ab"
	 * </pre>
	 *
	 * @param str   the String to get the substring from, may be null
	 * @param start the position to start from, negative means count back from the
	 *              end of the String by this many characters
	 * @param end   the position to end at (exclusive), negative means count back
	 *              from the end of the String by this many characters
	 * @return substring from start position to end position, {@code null} if null
	 *         String input
	 */
	public static String substring(final String str, int start, int end) {
		return StringUtils.substring(str, start, end);
	}

	// Left/Right/Mid
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the leftmost {@code len} characters of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, or the String is {@code null},
	 * the String will be returned without an exception. An empty String is returned
	 * if len is negative.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.left(null, *)    = null
	 * StringUtils.left(*, -ve)     = ""
	 * StringUtils.left("", *)      = ""
	 * StringUtils.left("abc", 0)   = ""
	 * StringUtils.left("abc", 2)   = "ab"
	 * StringUtils.left("abc", 4)   = "abc"
	 * </pre>
	 *
	 * @param str the String to get the leftmost characters from, may be null
	 * @param len the length of the required String
	 * @return the leftmost characters, {@code null} if null String input
	 */
	public static String left(final String str, final int len) {
		return StringUtils.left(str, len);
	}

	/**
	 * <p>
	 * Gets the rightmost {@code len} characters of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, or the String is {@code null},
	 * the String will be returned without an an exception. An empty String is
	 * returned if len is negative.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.right(null, *)    = null
	 * StringUtils.right(*, -ve)     = ""
	 * StringUtils.right("", *)      = ""
	 * StringUtils.right("abc", 0)   = ""
	 * StringUtils.right("abc", 2)   = "bc"
	 * StringUtils.right("abc", 4)   = "abc"
	 * </pre>
	 *
	 * @param str the String to get the rightmost characters from, may be null
	 * @param len the length of the required String
	 * @return the rightmost characters, {@code null} if null String input
	 */
	public static String right(final String str, final int len) {
		return StringUtils.right(str, len);
	}

	/**
	 * <p>
	 * Gets {@code len} characters from the middle of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, the remainder of the String will
	 * be returned without an exception. If the String is {@code null}, {@code null}
	 * will be returned. An empty String is returned if len is negative or exceeds
	 * the length of {@code str}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.mid(null, *, *)    = null
	 * StringUtils.mid(*, *, -ve)     = ""
	 * StringUtils.mid("", 0, *)      = ""
	 * StringUtils.mid("abc", 0, 2)   = "ab"
	 * StringUtils.mid("abc", 0, 4)   = "abc"
	 * StringUtils.mid("abc", 2, 4)   = "c"
	 * StringUtils.mid("abc", 4, 2)   = ""
	 * StringUtils.mid("abc", -2, 2)  = "ab"
	 * </pre>
	 *
	 * @param str the String to get the characters from, may be null
	 * @param pos the position to start from, negative treated as zero
	 * @param len the length of the required String
	 * @return the middle characters, {@code null} if null String input
	 */
	public static String mid(final String str, int pos, final int len) {
		return StringUtils.mid(str, pos, len);
	}

	// SubStringAfter/SubStringBefore
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the substring before the first occurrence of a separator. The separator
	 * is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("") string
	 * input will return the empty string. A {@code null} separator will return the
	 * input string.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the string input is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBefore(null, *)      = null
	 * StringUtils.substringBefore("", *)        = ""
	 * StringUtils.substringBefore("abc", "a")   = ""
	 * StringUtils.substringBefore("abcba", "b") = "a"
	 * StringUtils.substringBefore("abc", "c")   = "ab"
	 * StringUtils.substringBefore("abc", "d")   = "abc"
	 * StringUtils.substringBefore("abc", "")    = ""
	 * StringUtils.substringBefore("abc", null)  = "abc"
	 * </pre>
	 *
	 * @param str       the String to get a substring from, may be null
	 * @param separator the String to search for, may be null
	 * @return the substring before the first occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String substringBefore(final String str, final String separator) {
		return StringUtils.substringAfter(str, separator);
	}

	/**
	 * <p>
	 * Gets the substring after the first occurrence of a separator. The separator
	 * is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("") string
	 * input will return the empty string. A {@code null} separator will return the
	 * empty string if the input string is not {@code null}.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the empty string is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringAfter(null, *)      = null
	 * StringUtils.substringAfter("", *)        = ""
	 * StringUtils.substringAfter(*, null)      = ""
	 * StringUtils.substringAfter("abc", "a")   = "bc"
	 * StringUtils.substringAfter("abcba", "b") = "cba"
	 * StringUtils.substringAfter("abc", "c")   = ""
	 * StringUtils.substringAfter("abc", "d")   = ""
	 * StringUtils.substringAfter("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str       the String to get a substring from, may be null
	 * @param separator the String to search for, may be null
	 * @return the substring after the first occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String substringAfter(final String str, final String separator) {
		return StringUtils.substringAfter(str, separator);
	}

	/**
	 * <p>
	 * Gets the substring before the last occurrence of a separator. The separator
	 * is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("") string
	 * input will return the empty string. An empty or {@code null} separator will
	 * return the input string.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the string input is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBeforeLast(null, *)      = null
	 * StringUtils.substringBeforeLast("", *)        = ""
	 * StringUtils.substringBeforeLast("abcba", "b") = "abc"
	 * StringUtils.substringBeforeLast("abc", "c")   = "ab"
	 * StringUtils.substringBeforeLast("a", "a")     = ""
	 * StringUtils.substringBeforeLast("a", "z")     = "a"
	 * StringUtils.substringBeforeLast("a", null)    = "a"
	 * StringUtils.substringBeforeLast("a", "")      = "a"
	 * </pre>
	 *
	 * @param str       the String to get a substring from, may be null
	 * @param separator the String to search for, may be null
	 * @return the substring before the last occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String substringBeforeLast(final String str, final String separator) {
		return StringUtils.substringBeforeLast(str, separator);
	}

	/**
	 * <p>
	 * Gets the substring after the last occurrence of a separator. The separator is
	 * not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("") string
	 * input will return the empty string. An empty or {@code null} separator will
	 * return the empty string if the input string is not {@code null}.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the empty string is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringAfterLast(null, *)      = null
	 * StringUtils.substringAfterLast("", *)        = ""
	 * StringUtils.substringAfterLast(*, "")        = ""
	 * StringUtils.substringAfterLast(*, null)      = ""
	 * StringUtils.substringAfterLast("abc", "a")   = "bc"
	 * StringUtils.substringAfterLast("abcba", "b") = "a"
	 * StringUtils.substringAfterLast("abc", "c")   = ""
	 * StringUtils.substringAfterLast("a", "a")     = ""
	 * StringUtils.substringAfterLast("a", "z")     = ""
	 * </pre>
	 *
	 * @param str       the String to get a substring from, may be null
	 * @param separator the String to search for, may be null
	 * @return the substring after the last occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String substringAfterLast(final String str, final String separator) {
		return StringUtils.substringAfterLast(str, separator);
	}

	// Substring between
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the String that is nested in between two instances of the same String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} tag returns
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBetween(null, *)            = null
	 * StringUtils.substringBetween("", "")             = ""
	 * StringUtils.substringBetween("", "tag")          = null
	 * StringUtils.substringBetween("tagabctag", null)  = null
	 * StringUtils.substringBetween("tagabctag", "")    = ""
	 * StringUtils.substringBetween("tagabctag", "tag") = "abc"
	 * </pre>
	 *
	 * @param str the String containing the substring, may be null
	 * @param tag the String before and after the substring, may be null
	 * @return the substring, {@code null} if no match
	 * @since 1.0
	 */
	public static String substringBetween(final String str, final String tag) {
		return StringUtils.substringBetween(str, tag);
	}

	/**
	 * <p>
	 * Gets the String that is nested in between two Strings. Only the first match
	 * is returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} open/close
	 * returns {@code null} (no match). An empty ("") open and close returns an
	 * empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
	 * StringUtils.substringBetween(null, *, *)          = null
	 * StringUtils.substringBetween(*, null, *)          = null
	 * StringUtils.substringBetween(*, *, null)          = null
	 * StringUtils.substringBetween("", "", "")          = ""
	 * StringUtils.substringBetween("", "", "]")         = null
	 * StringUtils.substringBetween("", "[", "]")        = null
	 * StringUtils.substringBetween("yabcz", "", "")     = ""
	 * StringUtils.substringBetween("yabcz", "y", "z")   = "abc"
	 * StringUtils.substringBetween("yabczyabcz", "y", "z")   = "abc"
	 * </pre>
	 *
	 * @param str   the String containing the substring, may be null
	 * @param open  the String before the substring, may be null
	 * @param close the String after the substring, may be null
	 * @return the substring, {@code null} if no match
	 * @since 1.0
	 */
	public static String substringBetween(final String str, final String open, final String close) {
		return StringUtils.substringBetween(str, open, close);
	}

	/**
	 * <p>
	 * Searches a String for substrings delimited by a start and end tag, returning
	 * all matching substrings in an array.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} open/close
	 * returns {@code null} (no match). An empty ("") open/close returns
	 * {@code null} (no match).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
	 * StringUtils.substringsBetween(null, *, *)            = null
	 * StringUtils.substringsBetween(*, null, *)            = null
	 * StringUtils.substringsBetween(*, *, null)            = null
	 * StringUtils.substringsBetween("", "[", "]")          = []
	 * </pre>
	 *
	 * @param str   the String containing the substrings, null returns null, empty
	 *              returns empty
	 * @param open  the String identifying the start of the substring, empty returns
	 *              null
	 * @param close the String identifying the end of the substring, empty returns
	 *              null
	 * @return a String Array of substrings, or {@code null} if no match
	 * @since 1.0
	 */
	public static String substringsBetween(final String str, final String open, final String close) {
		return StringUtils.substringBetween(str, open, close);
	}

	// Nested extraction
	// -----------------------------------------------------------------------

	// Splitting
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Splits the provided text into an array, using whitespace as the separator.
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as one separator. For more control over the split use
	 * the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.split(null)       = null
	 * StringUtils.split("")         = []
	 * StringUtils.split("abc def")  = ["abc", "def"]
	 * StringUtils.split("abc  def") = ["abc", "def"]
	 * StringUtils.split(" abc ")    = ["abc"]
	 * </pre>
	 *
	 * @param str the String to parse, may be null
	 * @return an array of parsed Strings, {@code null} if null String input
	 */
	public static String[] split(final String str) {
		return StringUtils.split(str);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator specified. This is an
	 * alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as one separator. For more control over the split use
	 * the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.split(null, *)         = null
	 * StringUtils.split("", *)           = []
	 * StringUtils.split("a.b.c", '.')    = ["a", "b", "c"]
	 * StringUtils.split("a..b.c", '.')   = ["a", "b", "c"]
	 * StringUtils.split("a:b:c", '.')    = ["a:b:c"]
	 * StringUtils.split("a b c", ' ')    = ["a", "b", "c"]
	 * </pre>
	 *
	 * @param str           the String to parse, may be null
	 * @param separatorChar the character used as the delimiter
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] split(final String str, final char separatorChar) {
		return StringUtils.split(str, separatorChar);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separators specified. This is an
	 * alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as one separator. For more control over the split use
	 * the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * separatorChars splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.split(null, *)         = null
	 * StringUtils.split("", *)           = []
	 * StringUtils.split("abc def", null) = ["abc", "def"]
	 * StringUtils.split("abc def", " ")  = ["abc", "def"]
	 * StringUtils.split("abc  def", " ") = ["abc", "def"]
	 * StringUtils.split("ab:cd:ef", ":") = ["ab", "cd", "ef"]
	 * </pre>
	 *
	 * @param str            the String to parse, may be null
	 * @param separatorChars the characters used as the delimiters, {@code null}
	 *                       splits on whitespace
	 * @return an array of parsed Strings, {@code null} if null String input
	 */
	public static String[] split(final String str, final String separatorChars) {
		return StringUtils.split(str, separatorChars);
	}

	/**
	 * <p>
	 * Splits the provided text into an array with a maximum length, separators
	 * specified.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as one separator.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * separatorChars splits on whitespace.
	 * </p>
	 *
	 * <p>
	 * If more than {@code max} delimited substrings are found, the last returned
	 * string includes all characters after the first {@code max - 1} returned
	 * strings (including separator characters).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.split(null, *, *)            = null
	 * StringUtils.split("", *, *)              = []
	 * StringUtils.split("ab cd ef", null, 0)   = ["ab", "cd", "ef"]
	 * StringUtils.split("ab   cd ef", null, 0) = ["ab", "cd", "ef"]
	 * StringUtils.split("ab:cd:ef", ":", 0)    = ["ab", "cd", "ef"]
	 * StringUtils.split("ab:cd:ef", ":", 2)    = ["ab", "cd:ef"]
	 * </pre>
	 *
	 * @param str            the String to parse, may be null
	 * @param separatorChars the characters used as the delimiters, {@code null}
	 *                       splits on whitespace
	 * @param max            the maximum number of elements to include in the array.
	 *                       A zero or negative value implies no limit
	 * @return an array of parsed Strings, {@code null} if null String input
	 */
	public static String[] split(final String str, final String separatorChars, final int max) {
		return StringUtils.split(str, separatorChars, max);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator string specified.
	 * </p>
	 *
	 * <p>
	 * The separator(s) will not be included in the returned String array. Adjacent
	 * separators are treated as one separator.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} separator
	 * splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitByWholeSeparator(null, *)               = null
	 * StringUtils.splitByWholeSeparator("", *)                 = []
	 * StringUtils.splitByWholeSeparator("ab de fg", null)      = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparator("ab   de fg", null)    = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparator("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
	 * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
	 * </pre>
	 *
	 * @param str       the String to parse, may be null
	 * @param separator String containing the String to be used as a delimiter,
	 *                  {@code null} splits on whitespace
	 * @return an array of parsed Strings, {@code null} if null String was input
	 */
	public static String[] splitByWholeSeparator(final String str, final String separator) {
		return StringUtils.splitByWholeSeparator(str, separator);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator string specified. Returns a
	 * maximum of {@code max} substrings.
	 * </p>
	 *
	 * <p>
	 * The separator(s) will not be included in the returned String array. Adjacent
	 * separators are treated as one separator.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} separator
	 * splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitByWholeSeparator(null, *, *)               = null
	 * StringUtils.splitByWholeSeparator("", *, *)                 = []
	 * StringUtils.splitByWholeSeparator("ab de fg", null, 0)      = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparator("ab   de fg", null, 0)    = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparator("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
	 * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
	 * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
	 * </pre>
	 *
	 * @param str       the String to parse, may be null
	 * @param separator String containing the String to be used as a delimiter,
	 *                  {@code null} splits on whitespace
	 * @param max       the maximum number of elements to include in the returned
	 *                  array. A zero or negative value implies no limit.
	 * @return an array of parsed Strings, {@code null} if null String was input
	 */
	public static String[] splitByWholeSeparator(final String str, final String separator, final int max) {
		return StringUtils.splitByWholeSeparator(str, separator, max);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator string specified.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control over
	 * the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} separator
	 * splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *)               = null
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *)                 = []
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null)      = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null)    = ["ab", "", "", "de", "fg"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
	 * </pre>
	 *
	 * @param str       the String to parse, may be null
	 * @param separator String containing the String to be used as a delimiter,
	 *                  {@code null} splits on whitespace
	 * @return an array of parsed Strings, {@code null} if null String was input
	 * @since 1.0
	 */
	public static String[] splitByWholeSeparatorPreserveAllTokens(final String str, final String separator) {
		return StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator string specified. Returns a
	 * maximum of {@code max} substrings.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control over
	 * the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} separator
	 * splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *, *)               = null
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *, *)                 = []
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null, 0)      = ["ab", "de", "fg"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null, 0)    = ["ab", "", "", "de", "fg"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
	 * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
	 * </pre>
	 *
	 * @param str       the String to parse, may be null
	 * @param separator String containing the String to be used as a delimiter,
	 *                  {@code null} splits on whitespace
	 * @param max       the maximum number of elements to include in the returned
	 *                  array. A zero or negative value implies no limit.
	 * @return an array of parsed Strings, {@code null} if null String was input
	 * @since 1.0
	 */
	public static String[] splitByWholeSeparatorPreserveAllTokens(final String str, final String separator,
			final int max) {
		return StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator, max);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Splits the provided text into an array, using whitespace as the separator,
	 * preserving all tokens, including empty tokens created by adjacent separators.
	 * This is an alternative to using StringTokenizer. Whitespace is defined by
	 * {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control over
	 * the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitPreserveAllTokens(null)       = null
	 * StringUtils.splitPreserveAllTokens("")         = []
	 * StringUtils.splitPreserveAllTokens("abc def")  = ["abc", "def"]
	 * StringUtils.splitPreserveAllTokens("abc  def") = ["abc", "", "def"]
	 * StringUtils.splitPreserveAllTokens(" abc ")    = ["", "abc", ""]
	 * </pre>
	 *
	 * @param str the String to parse, may be {@code null}
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitPreserveAllTokens(final String str) {
		return StringUtils.splitPreserveAllTokens(str);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator specified, preserving all
	 * tokens, including empty tokens created by adjacent separators. This is an
	 * alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control over
	 * the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitPreserveAllTokens(null, *)         = null
	 * StringUtils.splitPreserveAllTokens("", *)           = []
	 * StringUtils.splitPreserveAllTokens("a.b.c", '.')    = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a..b.c", '.')   = ["a", "", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a:b:c", '.')    = ["a:b:c"]
	 * StringUtils.splitPreserveAllTokens("a\tb\nc", null) = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a b c", ' ')    = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a b c ", ' ')   = ["a", "b", "c", ""]
	 * StringUtils.splitPreserveAllTokens("a b c  ", ' ')   = ["a", "b", "c", "", ""]
	 * StringUtils.splitPreserveAllTokens(" a b c", ' ')   = ["", a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("  a b c", ' ')  = ["", "", a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens(" a b c ", ' ')  = ["", a", "b", "c", ""]
	 * </pre>
	 *
	 * @param str           the String to parse, may be {@code null}
	 * @param separatorChar the character used as the delimiter, {@code null} splits
	 *                      on whitespace
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitPreserveAllTokens(final String str, final char separatorChar) {
		return StringUtils.splitPreserveAllTokens(str, separatorChar);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separators specified, preserving all
	 * tokens, including empty tokens created by adjacent separators. This is an
	 * alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control over
	 * the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * separatorChars splits on whitespace.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitPreserveAllTokens(null, *)           = null
	 * StringUtils.splitPreserveAllTokens("", *)             = []
	 * StringUtils.splitPreserveAllTokens("abc def", null)   = ["abc", "def"]
	 * StringUtils.splitPreserveAllTokens("abc def", " ")    = ["abc", "def"]
	 * StringUtils.splitPreserveAllTokens("abc  def", " ")   = ["abc", "", def"]
	 * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":")   = ["ab", "cd", "ef"]
	 * StringUtils.splitPreserveAllTokens("ab:cd:ef:", ":")  = ["ab", "cd", "ef", ""]
	 * StringUtils.splitPreserveAllTokens("ab:cd:ef::", ":") = ["ab", "cd", "ef", "", ""]
	 * StringUtils.splitPreserveAllTokens("ab::cd:ef", ":")  = ["ab", "", cd", "ef"]
	 * StringUtils.splitPreserveAllTokens(":cd:ef", ":")     = ["", cd", "ef"]
	 * StringUtils.splitPreserveAllTokens("::cd:ef", ":")    = ["", "", cd", "ef"]
	 * StringUtils.splitPreserveAllTokens(":cd:ef:", ":")    = ["", cd", "ef", ""]
	 * </pre>
	 *
	 * @param str            the String to parse, may be {@code null}
	 * @param separatorChars the characters used as the delimiters, {@code null}
	 *                       splits on whitespace
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitPreserveAllTokens(final String str, final String separatorChars) {
		return StringUtils.splitPreserveAllTokens(str, separatorChars);
	}

	/**
	 * <p>
	 * Splits the provided text into an array with a maximum length, separators
	 * specified, preserving all tokens, including empty tokens created by adjacent
	 * separators.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. Adjacent separators
	 * are treated as one separator.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * separatorChars splits on whitespace.
	 * </p>
	 *
	 * <p>
	 * If more than {@code max} delimited substrings are found, the last returned
	 * string includes all characters after the first {@code max - 1} returned
	 * strings (including separator characters).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitPreserveAllTokens(null, *, *)            = null
	 * StringUtils.splitPreserveAllTokens("", *, *)              = []
	 * StringUtils.splitPreserveAllTokens("ab de fg", null, 0)   = ["ab", "cd", "ef"]
	 * StringUtils.splitPreserveAllTokens("ab   de fg", null, 0) = ["ab", "cd", "ef"]
	 * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":", 0)    = ["ab", "cd", "ef"]
	 * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":", 2)    = ["ab", "cd:ef"]
	 * StringUtils.splitPreserveAllTokens("ab   de fg", null, 2) = ["ab", "  de fg"]
	 * StringUtils.splitPreserveAllTokens("ab   de fg", null, 3) = ["ab", "", " de fg"]
	 * StringUtils.splitPreserveAllTokens("ab   de fg", null, 4) = ["ab", "", "", "de fg"]
	 * </pre>
	 *
	 * @param str            the String to parse, may be {@code null}
	 * @param separatorChars the characters used as the delimiters, {@code null}
	 *                       splits on whitespace
	 * @param max            the maximum number of elements to include in the array.
	 *                       A zero or negative value implies no limit
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitPreserveAllTokens(final String str, final String separatorChars, final int max) {
		return StringUtils.splitPreserveAllTokens(str, separatorChars, max);
	}

	/**
	 * <p>
	 * Splits a String by Character type as returned by
	 * {@code java.lang.Character.getType(char)}. Groups of contiguous characters of
	 * the same type are returned as complete tokens.
	 * 
	 * <pre>
	 * StringUtils.splitByCharacterType(null)         = null
	 * StringUtils.splitByCharacterType("")           = []
	 * StringUtils.splitByCharacterType("ab de fg")   = ["ab", " ", "de", " ", "fg"]
	 * StringUtils.splitByCharacterType("ab   de fg") = ["ab", "   ", "de", " ", "fg"]
	 * StringUtils.splitByCharacterType("ab:cd:ef")   = ["ab", ":", "cd", ":", "ef"]
	 * StringUtils.splitByCharacterType("number5")    = ["number", "5"]
	 * StringUtils.splitByCharacterType("fooBar")     = ["foo", "B", "ar"]
	 * StringUtils.splitByCharacterType("foo200Bar")  = ["foo", "200", "B", "ar"]
	 * StringUtils.splitByCharacterType("ASFRules")   = ["ASFR", "ules"]
	 * </pre>
	 * 
	 * @param str the String to split, may be {@code null}
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitByCharacterType(final String str) {
		return StringUtils.splitByCharacterType(str);
	}

	/**
	 * <p>
	 * Splits a String by Character type as returned by
	 * {@code java.lang.Character.getType(char)}. Groups of contiguous characters of
	 * the same type are returned as complete tokens, with the following exception:
	 * the character of type {@code Character.UPPERCASE_LETTER}, if any, immediately
	 * preceding a token of type {@code Character.LOWERCASE_LETTER} will belong to
	 * the following token rather than to the preceding, if any,
	 * {@code Character.UPPERCASE_LETTER} token.
	 * 
	 * <pre>
	 * StringUtils.splitByCharacterTypeCamelCase(null)         = null
	 * StringUtils.splitByCharacterTypeCamelCase("")           = []
	 * StringUtils.splitByCharacterTypeCamelCase("ab de fg")   = ["ab", " ", "de", " ", "fg"]
	 * StringUtils.splitByCharacterTypeCamelCase("ab   de fg") = ["ab", "   ", "de", " ", "fg"]
	 * StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef")   = ["ab", ":", "cd", ":", "ef"]
	 * StringUtils.splitByCharacterTypeCamelCase("number5")    = ["number", "5"]
	 * StringUtils.splitByCharacterTypeCamelCase("fooBar")     = ["foo", "Bar"]
	 * StringUtils.splitByCharacterTypeCamelCase("foo200Bar")  = ["foo", "200", "Bar"]
	 * StringUtils.splitByCharacterTypeCamelCase("ASFRules")   = ["ASF", "Rules"]
	 * </pre>
	 * 
	 * @param str the String to split, may be {@code null}
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 1.0
	 */
	public static String[] splitByCharacterTypeCamelCase(final String str) {
		return StringUtils.splitByCharacterTypeCamelCase(str);
	}

	// Joining
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No separator is added to the joined String. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null)            = null
	 * StringUtils.join([])              = ""
	 * StringUtils.join([null])          = ""
	 * StringUtils.join(["a", "b", "c"]) = "abc"
	 * StringUtils.join([null, "", "a"]) = "a"
	 * </pre>
	 *
	 * @param          <T> the specific type of values to join together
	 * @param elements the values to join together, may be null
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 * @since 1.0 Changed signature to use varargs
	 */
	@SafeVarargs
	public static <T> String join(final T... elements) {
		return StringUtils.join(elements);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final Object[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final long[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final int[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final short[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final byte[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final char[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final float[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final double[] array, final char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final Object[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final long[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final int[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final byte[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final short[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final char[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final double[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the array
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 1.0
	 */
	public static String join(final float[] array, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator is
	 * the same as an empty String (""). Null objects or empty strings within the
	 * array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)                = null
	 * StringUtils.join([], *)                  = ""
	 * StringUtils.join([null], *)              = ""
	 * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], null)  = "abc"
	 * StringUtils.join(["a", "b", "c"], "")    = "abc"
	 * StringUtils.join([null, "", "a"], ',')   = ",,a"
	 * </pre>
	 *
	 * @param array     the array of values to join together, may be null
	 * @param separator the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null array input
	 */
	public static String join(final Object[] array, final String separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing the
	 * provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator is
	 * the same as an empty String (""). Null objects or empty strings within the
	 * array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *, *, *)                = null
	 * StringUtils.join([], *, *, *)                  = ""
	 * StringUtils.join([null], *, *, *)              = ""
	 * StringUtils.join(["a", "b", "c"], "--", 0, 3)  = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 1, 3)  = "b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 3)  = "c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 2)  = ""
	 * StringUtils.join(["a", "b", "c"], null, 0, 3)  = "abc"
	 * StringUtils.join(["a", "b", "c"], "", 0, 3)    = "abc"
	 * StringUtils.join([null, "", "a"], ',', 0, 3)   = ",,a"
	 * </pre>
	 *
	 * @param array      the array of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @param startIndex the first index to start joining from.
	 * @param endIndex   the index to stop joining from (exclusive).
	 * @return the joined String, {@code null} if null array input; or the empty
	 *         string if {@code endIndex - startIndex <= 0}. The number of joined
	 *         entries is given by {@code endIndex - startIndex}
	 * @throws ArrayIndexOutOfBoundsException ife<br>
	 *                                        {@code startIndex < 0} or <br>
	 *                                        {@code startIndex >= array.length()}
	 *                                        or <br>
	 *                                        {@code endIndex < 0} or <br>
	 *                                        {@code endIndex > array.length()}
	 */
	public static String join(final Object[] array, String separator, final int startIndex, final int endIndex) {
		return StringUtils.join(array, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterator} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the iteration are represented by empty strings.
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],char)}.
	 * </p>
	 *
	 * @param iterator  the {@code Iterator} of values to join together, may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 1.0
	 */
	public static String join(final Iterator<?> iterator, final char separator) {
		return StringUtils.join(iterator, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterator} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator is
	 * the same as an empty String ("").
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],String)}.
	 * </p>
	 *
	 * @param iterator  the {@code Iterator} of values to join together, may be null
	 * @param separator the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 */
	public static String join(final Iterator<?> iterator, final String separator) {
		return StringUtils.join(iterator, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterable} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the iteration are represented by empty strings.
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],char)}.
	 * </p>
	 *
	 * @param iterable  the {@code Iterable} providing the values to join together,
	 *                  may be null
	 * @param separator the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 1.0
	 */
	public static String join(final Iterable<?> iterable, final char separator) {
		return StringUtils.join(iterable, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterable} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator is
	 * the same as an empty String ("").
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],String)}.
	 * </p>
	 *
	 * @param iterable  the {@code Iterable} providing the values to join together,
	 *                  may be null
	 * @param separator the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 * @since 1.0
	 */
	public static String join(final Iterable<?> iterable, final String separator) {
		return StringUtils.join(iterable, separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code List} into a single String
	 * containing the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 *
	 * @param list       the {@code List} of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the list
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the list
	 * @return the joined String, {@code null} if null list input
	 * @since 1.0
	 */
	public static String join(final List<?> list, final char separator, final int startIndex, final int endIndex) {
		return StringUtils.join(list, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code List} into a single String
	 * containing the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 *
	 * @param list       the {@code List} of values to join together, may be null
	 * @param separator  the separator character to use
	 * @param startIndex the first index to start joining from. It is an error to
	 *                   pass in a start index past the end of the list
	 * @param endIndex   the index to stop joining from (exclusive). It is an error
	 *                   to pass in an end index past the end of the list
	 * @return the joined String, {@code null} if null list input
	 * @since 1.0
	 */
	public static String join(final List<?> list, final String separator, final int startIndex, final int endIndex) {
		return StringUtils.join(list, separator, startIndex, endIndex);
	}

	/**
	 * <p>
	 * Joins the elements of the provided varargs into a single String containing
	 * the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. {@code null} elements and
	 * separator are treated as empty Strings ("").
	 * </p>
	 *
	 * <pre>
	 * StringUtils.joinWith(",", {"a", "b"})        = "a,b"
	 * StringUtils.joinWith(",", {"a", "b",""})     = "a,b,"
	 * StringUtils.joinWith(",", {"a", null, "b"})  = "a,,b"
	 * StringUtils.joinWith(null, {"a", "b"})       = "ab"
	 * </pre>
	 *
	 * @param separator the separator character to use, null treated as ""
	 * @param objects   the varargs providing the values to join together.
	 *                  {@code null} elements are treated as ""
	 * @return the joined String.
	 * @throws java.lang.IllegalArgumentException if a null varargs is provided
	 * @since 1.0
	 */
	public static String joinWith(final String separator, final Object... objects) {
		return StringUtils.joinWith(separator, objects);
	}

	// Delete
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Deletes all whitespaces from a String as defined by
	 * {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.deleteWhitespace(null)         = null
	 * StringUtils.deleteWhitespace("")           = ""
	 * StringUtils.deleteWhitespace("abc")        = "abc"
	 * StringUtils.deleteWhitespace("   ab  c  ") = "abc"
	 * </pre>
	 *
	 * @param str the String to delete whitespace from, may be null
	 * @return the String without whitespaces, {@code null} if null String input
	 */
	public static String deleteWhitespace(final String str) {
		return StringUtils.deleteWhitespace(str);
	}

	// Remove
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes a substring only if it is at the beginning of a source string,
	 * otherwise returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("") source
	 * string will return the empty string. A {@code null} search string will return
	 * the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeStart(null, *)      = null
	 * StringUtils.removeStart("", *)        = ""
	 * StringUtils.removeStart(*, null)      = *
	 * StringUtils.removeStart("www.domain.com", "www.")   = "domain.com"
	 * StringUtils.removeStart("domain.com", "www.")       = "domain.com"
	 * StringUtils.removeStart("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeStart("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str    the source String to search, may be null
	 * @param remove the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if null
	 *         String input
	 * @since 1.0
	 */
	public static String removeStart(final String str, final String remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * <p>
	 * Removes a substring only if it is at the end of a source string, otherwise
	 * returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("") source
	 * string will return the empty string. A {@code null} search string will return
	 * the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeEnd(null, *)      = null
	 * StringUtils.removeEnd("", *)        = ""
	 * StringUtils.removeEnd(*, null)      = *
	 * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
	 * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
	 * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeEnd("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str    the source String to search, may be null
	 * @param remove the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if null
	 *         String input
	 * @since 1.0
	 */
	public static String removeEnd(final String str, final String remove) {
		return StringUtils.removeEnd(str, remove);
	}

	/**
	 * <p>
	 * Removes all occurrences of a substring from within the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("") source
	 * string will return the empty string. A {@code null} remove string will return
	 * the source string. An empty ("") remove string will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.remove(null, *)        = null
	 * StringUtils.remove("", *)          = ""
	 * StringUtils.remove(*, null)        = *
	 * StringUtils.remove(*, "")          = *
	 * StringUtils.remove("queued", "ue") = "qd"
	 * StringUtils.remove("queued", "zz") = "queued"
	 * </pre>
	 *
	 * @param str    the source String to search, may be null
	 * @param remove the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if null
	 *         String input
	 * @since 1.0
	 */
	public static String remove(final String str, final String remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * <p>
	 * Case insensitive removal of all occurrences of a substring from within the
	 * source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("") source
	 * string will return the empty string. A {@code null} remove string will return
	 * the source string. An empty ("") remove string will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeIgnoreCase(null, *)        = null
	 * StringUtils.removeIgnoreCase("", *)          = ""
	 * StringUtils.removeIgnoreCase(*, null)        = *
	 * StringUtils.removeIgnoreCase(*, "")          = *
	 * StringUtils.removeIgnoreCase("queued", "ue") = "qd"
	 * StringUtils.removeIgnoreCase("queued", "zz") = "queued"
	 * StringUtils.removeIgnoreCase("quEUed", "UE") = "qd"
	 * StringUtils.removeIgnoreCase("queued", "zZ") = "queued"
	 * </pre>
	 *
	 * @param str    the source String to search, may be null
	 * @param remove the String to search for (case insensitive) and remove, may be
	 *               null
	 * @return the substring with the string removed if found, {@code null} if null
	 *         String input
	 * @since 1.0
	 */
	public static String removeIgnoreCase(final String str, final String remove) {
		return StringUtils.removeIgnoreCase(str, remove);
	}

	/**
	 * <p>
	 * Removes all occurrences of a character from within the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("") source
	 * string will return the empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.remove(null, *)       = null
	 * StringUtils.remove("", *)         = ""
	 * StringUtils.remove("queued", 'u') = "qeed"
	 * StringUtils.remove("queued", 'z') = "queued"
	 * </pre>
	 *
	 * @param str    the source String to search, may be null
	 * @param remove the char to search for and remove, may be null
	 * @return the substring with the char removed if found, {@code null} if null
	 *         String input
	 * @since 1.0
	 */
	public static String remove(final String str, final char remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * <p>
	 * Removes each substring of the text String that matches the given regular
	 * expression.
	 * </p>
	 *
	 * This method is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code text.replaceAll(regex, StringUtils.EMPTY)}</li>
	 * <li>{@code Pattern.compile(regex).matcher(text).replaceAll(StringUtils.EMPTY)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <p>
	 * Unlike in the {@link #removePattern(String, String)} method, the
	 * {@link Pattern#DOTALL} option is NOT automatically added. To use the DOTALL
	 * option prepend <code>"(?s)"</code> to the regex. DOTALL is also known as
	 * single-line mode in Perl.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeAll(null, *)      = null
	 * StringUtils.removeAll("any", (String) null)  = "any"
	 * StringUtils.removeAll("any", "")    = "any"
	 * StringUtils.removeAll("any", ".*")  = ""
	 * StringUtils.removeAll("any", ".+")  = ""
	 * StringUtils.removeAll("abc", ".?")  = ""
	 * StringUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;")      = "A\nB"
	 * StringUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", "(?s)&lt;.*&gt;")  = "AB"
	 * StringUtils.removeAll("ABCabc123abc", "[a-z]")     = "ABC123"
	 * </pre>
	 *
	 * @param text  text to remove from, may be null
	 * @param regex the regular expression to which this string is to be matched
	 * @return the text with any removes processed, {@code null} if null String
	 *         input
	 *
	 * @throws java.util.regex.PatternSyntaxException if the regular expression's
	 *         syntax is invalid
	 *
	 * @see #replaceAll(String, String, String)
	 * @see #removePattern(String, String)
	 * @see String#replaceAll(String, String)
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Pattern#DOTALL
	 * @since 1.0
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String removeAll(final String text, final String regex) {
		return StringUtils.removeAll(text, regex);
	}

	/**
	 * <p>
	 * Removes the first substring of the text string that matches the given regular
	 * expression.
	 * </p>
	 *
	 * This method is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code text.replaceFirst(regex, StringUtils.EMPTY)}</li>
	 * <li>{@code Pattern.compile(regex).matcher(text).replaceFirst(StringUtils.EMPTY)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <p>
	 * The {@link Pattern#DOTALL} option is NOT automatically added. To use the
	 * DOTALL option prepend <code>"(?s)"</code> to the regex. DOTALL is also known
	 * as single-line mode in Perl.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeFirst(null, *)      = null
	 * StringUtils.removeFirst("any", (String) null)  = "any"
	 * StringUtils.removeFirst("any", "")    = "any"
	 * StringUtils.removeFirst("any", ".*")  = ""
	 * StringUtils.removeFirst("any", ".+")  = ""
	 * StringUtils.removeFirst("abc", ".?")  = "bc"
	 * StringUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;")      = "A\n&lt;__&gt;B"
	 * StringUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "(?s)&lt;.*&gt;")  = "AB"
	 * StringUtils.removeFirst("ABCabc123", "[a-z]")          = "ABCbc123"
	 * StringUtils.removeFirst("ABCabc123abc", "[a-z]+")      = "ABC123abc"
	 * </pre>
	 *
	 * @param text  text to remove from, may be null
	 * @param regex the regular expression to which this string is to be matched
	 * @return the text with the first replacement processed, {@code null} if null
	 *         String input
	 *
	 * @throws java.util.regex.PatternSyntaxException if the regular expression's
	 *         syntax is invalid
	 *
	 * @see #replaceFirst(String, String, String)
	 * @see String#replaceFirst(String, String)
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Pattern#DOTALL
	 * @since 1.0
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String removeFirst(final String text, final String regex) {
		return StringUtils.removeFirst(text, regex);
	}

	// Replacing
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, once.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceOnce(null, *, *)        = null
	 * StringUtils.replaceOnce("", *, *)          = ""
	 * StringUtils.replaceOnce("any", null, *)    = "any"
	 * StringUtils.replaceOnce("any", *, null)    = "any"
	 * StringUtils.replaceOnce("any", "", *)      = "any"
	 * StringUtils.replaceOnce("aba", "a", null)  = "aba"
	 * StringUtils.replaceOnce("aba", "a", "")    = "ba"
	 * StringUtils.replaceOnce("aba", "a", "z")   = "zba"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int max)
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement  the String to replace with, may be null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 */
	public static String replaceOnce(final String text, final String searchString, final String replacement) {
		return StringUtils.replaceOnce(text, searchString, replacement);
	}

	/**
	 * <p>
	 * Case insensitively replaces a String with another String inside a larger
	 * String, once.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceOnceIgnoreCase(null, *, *)        = null
	 * StringUtils.replaceOnceIgnoreCase("", *, *)          = ""
	 * StringUtils.replaceOnceIgnoreCase("any", null, *)    = "any"
	 * StringUtils.replaceOnceIgnoreCase("any", *, null)    = "any"
	 * StringUtils.replaceOnceIgnoreCase("any", "", *)      = "any"
	 * StringUtils.replaceOnceIgnoreCase("aba", "a", null)  = "aba"
	 * StringUtils.replaceOnceIgnoreCase("aba", "a", "")    = "ba"
	 * StringUtils.replaceOnceIgnoreCase("aba", "a", "z")   = "zba"
	 * StringUtils.replaceOnceIgnoreCase("FoOFoofoo", "foo", "") = "Foofoo"
	 * </pre>
	 *
	 * @see #replaceIgnoreCase(String text, String searchString, String replacement,
	 *      int max)
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for (case insensitive), may be null
	 * @param replacement  the String to replace with, may be null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 * @since 1.0
	 */
	public static String replaceOnceIgnoreCase(final String text, final String searchString, final String replacement) {
		return StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);
	}

	/**
	 * <p>
	 * Replaces each substring of the source String that matches the given regular
	 * expression with the given replacement using the {@link Pattern#DOTALL}
	 * option. DOTALL is also known as single-line mode in Perl.
	 * </p>
	 *
	 * This call is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code source.replaceAll(&quot;(?s)&quot; + regex, replacement)}</li>
	 * <li>{@code Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll(replacement)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replacePattern(null, *, *)       = null
	 * StringUtils.replacePattern("any", (String) null, *)   = "any"
	 * StringUtils.replacePattern("any", *, null)   = "any"
	 * StringUtils.replacePattern("", "", "zzz")    = "zzz"
	 * StringUtils.replacePattern("", ".*", "zzz")  = "zzz"
	 * StringUtils.replacePattern("", ".+", "zzz")  = ""
	 * StringUtils.replacePattern("&lt;__&gt;\n&lt;__&gt;", "&lt;.*&gt;", "z")       = "z"
	 * StringUtils.replacePattern("ABCabc123", "[a-z]", "_")       = "ABC___123"
	 * StringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "_")  = "ABC_123"
	 * StringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "")   = "ABC123"
	 * StringUtils.replacePattern("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2")  = "Lorem_ipsum_dolor_sit"
	 * </pre>
	 *
	 * @param source      the source string
	 * @param regex       the regular expression to which this string is to be
	 *                    matched
	 * @param replacement the string to be substituted for each match
	 * @return The resulting {@code String}
	 * @see #replaceAll(String, String, String)
	 * @see String#replaceAll(String, String)
	 * @see Pattern#DOTALL
	 * @since 1.0
	 * @since 1.0 Changed {@code null} reference passed to this method is a no-op.
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String replacePattern(final String source, final String regex, final String replacement) {
		return StringUtils.replacePattern(source, regex, replacement);
	}

	/**
	 * <p>
	 * Removes each substring of the source String that matches the given regular
	 * expression using the DOTALL option.
	 * </p>
	 *
	 * This call is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code source.replaceAll(&quot;(?s)&quot; + regex, StringUtils.EMPTY)}</li>
	 * <li>{@code Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll(StringUtils.EMPTY)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removePattern(null, *)       = null
	 * StringUtils.removePattern("any", (String) null)   = "any"
	 * StringUtils.removePattern("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;")  = "AB"
	 * StringUtils.removePattern("ABCabc123", "[a-z]")    = "ABC123"
	 * </pre>
	 *
	 * @param source the source string
	 * @param regex  the regular expression to which this string is to be matched
	 * @return The resulting {@code String}
	 * @see #replacePattern(String, String, String)
	 * @see String#replaceAll(String, String)
	 * @see Pattern#DOTALL
	 * @since 1.0
	 * @since 1.0 Changed {@code null} reference passed to this method is a no-op.
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String removePattern(final String source, final String regex) {
		return StringUtils.removePattern(source, regex);
	}

	/**
	 * <p>
	 * Replaces each substring of the text String that matches the given regular
	 * expression with the given replacement.
	 * </p>
	 *
	 * This method is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code text.replaceAll(regex, replacement)}</li>
	 * <li>{@code Pattern.compile(regex).matcher(text).replaceAll(replacement)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <p>
	 * Unlike in the {@link #replacePattern(String, String, String)} method, the
	 * {@link Pattern#DOTALL} option is NOT automatically added. To use the DOTALL
	 * option prepend <code>"(?s)"</code> to the regex. DOTALL is also known as
	 * single-line mode in Perl.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceAll(null, *, *)       = null
	 * StringUtils.replaceAll("any", (String) null, *)   = "any"
	 * StringUtils.replaceAll("any", *, null)   = "any"
	 * StringUtils.replaceAll("", "", "zzz")    = "zzz"
	 * StringUtils.replaceAll("", ".*", "zzz")  = "zzz"
	 * StringUtils.replaceAll("", ".+", "zzz")  = ""
	 * StringUtils.replaceAll("abc", "", "ZZ")  = "ZZaZZbZZcZZ"
	 * StringUtils.replaceAll("&lt;__&gt;\n&lt;__&gt;", "&lt;.*&gt;", "z")      = "z\nz"
	 * StringUtils.replaceAll("&lt;__&gt;\n&lt;__&gt;", "(?s)&lt;.*&gt;", "z")  = "z"
	 * StringUtils.replaceAll("ABCabc123", "[a-z]", "_")       = "ABC___123"
	 * StringUtils.replaceAll("ABCabc123", "[^A-Z0-9]+", "_")  = "ABC_123"
	 * StringUtils.replaceAll("ABCabc123", "[^A-Z0-9]+", "")   = "ABC123"
	 * StringUtils.replaceAll("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2")  = "Lorem_ipsum_dolor_sit"
	 * </pre>
	 *
	 * @param text        text to search and replace in, may be null
	 * @param regex       the regular expression to which this string is to be
	 *                    matched
	 * @param replacement the string to be substituted for each match
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 *
	 * @throws java.util.regex.PatternSyntaxException if the regular expression's
	 *         syntax is invalid
	 *
	 * @see #replacePattern(String, String, String)
	 * @see String#replaceAll(String, String)
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Pattern#DOTALL
	 * @since 1.0
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String replaceAll(final String text, final String regex, final String replacement) {
		return StringUtils.replaceAll(text, regex, replacement);
	}

	/**
	 * <p>
	 * Replaces the first substring of the text string that matches the given
	 * regular expression with the given replacement.
	 * </p>
	 *
	 * This method is a {@code null} safe equivalent to:
	 * <ul>
	 * <li>{@code text.replaceFirst(regex, replacement)}</li>
	 * <li>{@code Pattern.compile(regex).matcher(text).replaceFirst(replacement)}</li>
	 * </ul>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <p>
	 * The {@link Pattern#DOTALL} option is NOT automatically added. To use the
	 * DOTALL option prepend <code>"(?s)"</code> to the regex. DOTALL is also known
	 * as single-line mode in Perl.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceFirst(null, *, *)       = null
	 * StringUtils.replaceFirst("any", (String) null, *)   = "any"
	 * StringUtils.replaceFirst("any", *, null)   = "any"
	 * StringUtils.replaceFirst("", "", "zzz")    = "zzz"
	 * StringUtils.replaceFirst("", ".*", "zzz")  = "zzz"
	 * StringUtils.replaceFirst("", ".+", "zzz")  = ""
	 * StringUtils.replaceFirst("abc", "", "ZZ")  = "ZZabc"
	 * StringUtils.replaceFirst("&lt;__&gt;\n&lt;__&gt;", "&lt;.*&gt;", "z")      = "z\n&lt;__&gt;"
	 * StringUtils.replaceFirst("&lt;__&gt;\n&lt;__&gt;", "(?s)&lt;.*&gt;", "z")  = "z"
	 * StringUtils.replaceFirst("ABCabc123", "[a-z]", "_")          = "ABC_bc123"
	 * StringUtils.replaceFirst("ABCabc123abc", "[^A-Z0-9]+", "_")  = "ABC_123abc"
	 * StringUtils.replaceFirst("ABCabc123abc", "[^A-Z0-9]+", "")   = "ABC123abc"
	 * StringUtils.replaceFirst("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2")  = "Lorem_ipsum  dolor   sit"
	 * </pre>
	 *
	 * @param text        text to search and replace in, may be null
	 * @param regex       the regular expression to which this string is to be
	 *                    matched
	 * @param replacement the string to be substituted for the first match
	 * @return the text with the first replacement processed, {@code null} if null
	 *         String input
	 *
	 * @throws java.util.regex.PatternSyntaxException if the regular expression's
	 *         syntax is invalid
	 *
	 * @see String#replaceFirst(String, String)
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Pattern#DOTALL
	 * @since 1.0
	 *
	 * @deprecated Moved to RegExUtils.
	 */
	@Deprecated
	public static String replaceFirst(final String text, final String regex, final String replacement) {
		return StringUtils.replaceFirst(text, regex, replacement);
	}

	/**
	 * <p>
	 * Replaces all occurrences of a String within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *)        = null
	 * StringUtils.replace("", *, *)          = ""
	 * StringUtils.replace("any", null, *)    = "any"
	 * StringUtils.replace("any", *, null)    = "any"
	 * StringUtils.replace("any", "", *)      = "any"
	 * StringUtils.replace("aba", "a", null)  = "aba"
	 * StringUtils.replace("aba", "a", "")    = "b"
	 * StringUtils.replace("aba", "a", "z")   = "zbz"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int max)
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement  the String to replace it with, may be null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 */
	public static String replace(final String text, final String searchString, final String replacement) {
		return StringUtils.replace(text, searchString, replacement);
	}

	/**
	 * <p>
	 * Case insensitively replaces all occurrences of a String within another
	 * String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceIgnoreCase(null, *, *)        = null
	 * StringUtils.replaceIgnoreCase("", *, *)          = ""
	 * StringUtils.replaceIgnoreCase("any", null, *)    = "any"
	 * StringUtils.replaceIgnoreCase("any", *, null)    = "any"
	 * StringUtils.replaceIgnoreCase("any", "", *)      = "any"
	 * StringUtils.replaceIgnoreCase("aba", "a", null)  = "aba"
	 * StringUtils.replaceIgnoreCase("abA", "A", "")    = "b"
	 * StringUtils.replaceIgnoreCase("aba", "A", "z")   = "zbz"
	 * </pre>
	 *
	 * @see #replaceIgnoreCase(String text, String searchString, String replacement,
	 *      int max)
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for (case insensitive), may be null
	 * @param replacement  the String to replace it with, may be null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 * @since 1.0
	 */
	public static String replaceIgnoreCase(final String text, final String searchString, final String replacement) {
		return StringUtils.replaceIgnoreCase(text, searchString, replacement);
	}

	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, for the first
	 * {@code max} values of the search String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *, *)         = null
	 * StringUtils.replace("", *, *, *)           = ""
	 * StringUtils.replace("any", null, *, *)     = "any"
	 * StringUtils.replace("any", *, null, *)     = "any"
	 * StringUtils.replace("any", "", *, *)       = "any"
	 * StringUtils.replace("any", *, *, 0)        = "any"
	 * StringUtils.replace("abaa", "a", null, -1) = "abaa"
	 * StringUtils.replace("abaa", "a", "", -1)   = "b"
	 * StringUtils.replace("abaa", "a", "z", 0)   = "abaa"
	 * StringUtils.replace("abaa", "a", "z", 1)   = "zbaa"
	 * StringUtils.replace("abaa", "a", "z", 2)   = "zbza"
	 * StringUtils.replace("abaa", "a", "z", -1)  = "zbzz"
	 * </pre>
	 *
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement  the String to replace it with, may be null
	 * @param max          maximum number of values to replace, or {@code -1} if no
	 *                     maximum
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 */
	public static String replace(final String text, final String searchString, final String replacement,
			final int max) {
		return StringUtils.replace(text, searchString, replacement, max);
	}

	/**
	 * <p>
	 * Case insensitively replaces a String with another String inside a larger
	 * String, for the first {@code max} values of the search String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceIgnoreCase(null, *, *, *)         = null
	 * StringUtils.replaceIgnoreCase("", *, *, *)           = ""
	 * StringUtils.replaceIgnoreCase("any", null, *, *)     = "any"
	 * StringUtils.replaceIgnoreCase("any", *, null, *)     = "any"
	 * StringUtils.replaceIgnoreCase("any", "", *, *)       = "any"
	 * StringUtils.replaceIgnoreCase("any", *, *, 0)        = "any"
	 * StringUtils.replaceIgnoreCase("abaa", "a", null, -1) = "abaa"
	 * StringUtils.replaceIgnoreCase("abaa", "a", "", -1)   = "b"
	 * StringUtils.replaceIgnoreCase("abaa", "a", "z", 0)   = "abaa"
	 * StringUtils.replaceIgnoreCase("abaa", "A", "z", 1)   = "zbaa"
	 * StringUtils.replaceIgnoreCase("abAa", "a", "z", 2)   = "zbza"
	 * StringUtils.replaceIgnoreCase("abAa", "a", "z", -1)  = "zbzz"
	 * </pre>
	 *
	 * @param text         text to search and replace in, may be null
	 * @param searchString the String to search for (case insensitive), may be null
	 * @param replacement  the String to replace it with, may be null
	 * @param max          maximum number of values to replace, or {@code -1} if no
	 *                     maximum
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 * @since 1.0
	 */
	public static String replaceIgnoreCase(final String text, final String searchString, final String replacement,
			final int max) {
		return StringUtils.replaceIgnoreCase(text, searchString, replacement, max);
	}

	/**
	 * <p>
	 * Replaces all occurrences of Strings within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op, or if any "search
	 * string" or "string to replace" is null, that replace will be ignored. This
	 * will not repeat. For repeating replaces, call the overloaded method.
	 * </p>
	 *
	 * <pre>
	 *  StringUtils.replaceEach(null, *, *)        = null
	 *  StringUtils.replaceEach("", *, *)          = ""
	 *  StringUtils.replaceEach("aba", null, null) = "aba"
	 *  StringUtils.replaceEach("aba", new String[0], null) = "aba"
	 *  StringUtils.replaceEach("aba", null, new String[0]) = "aba"
	 *  StringUtils.replaceEach("aba", new String[]{"a"}, null)  = "aba"
	 *  StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""})  = "b"
	 *  StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"})  = "aba"
	 *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"})  = "wcte"
	 *  (example of how it does not repeat)
	 *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"})  = "dcte"
	 * </pre>
	 *
	 * @param text            text to search and replace in, no-op if null
	 * @param searchList      the Strings to search for, no-op if null
	 * @param replacementList the Strings to replace them with, no-op if null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 * @throws IllegalArgumentException if the lengths of the arrays are not the
	 *                                  same (null is ok, and/or size 0)
	 * @since 1.0
	 */
	public static String replaceEach(final String text, final String[] searchList, final String[] replacementList) {
		return StringUtils.replaceEach(text, searchList, replacementList);
	}

	/**
	 * <p>
	 * Replaces all occurrences of Strings within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op, or if any "search
	 * string" or "string to replace" is null, that replace will be ignored.
	 * </p>
	 *
	 * <pre>
	 *  StringUtils.replaceEachRepeatedly(null, *, *) = null
	 *  StringUtils.replaceEachRepeatedly("", *, *) = ""
	 *  StringUtils.replaceEachRepeatedly("aba", null, null) = "aba"
	 *  StringUtils.replaceEachRepeatedly("aba", new String[0], null) = "aba"
	 *  StringUtils.replaceEachRepeatedly("aba", null, new String[0]) = "aba"
	 *  StringUtils.replaceEachRepeatedly("aba", new String[]{"a"}, null) = "aba"
	 *  StringUtils.replaceEachRepeatedly("aba", new String[]{"a"}, new String[]{""}) = "b"
	 *  StringUtils.replaceEachRepeatedly("aba", new String[]{null}, new String[]{"a"}) = "aba"
	 *  StringUtils.replaceEachRepeatedly("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}) = "wcte"
	 *  (example of how it repeats)
	 *  StringUtils.replaceEachRepeatedly("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}) = "tcte"
	 *  StringUtils.replaceEachRepeatedly("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}) = IllegalStateException
	 * </pre>
	 *
	 * @param text            text to search and replace in, no-op if null
	 * @param searchList      the Strings to search for, no-op if null
	 * @param replacementList the Strings to replace them with, no-op if null
	 * @return the text with any replacements processed, {@code null} if null String
	 *         input
	 * @throws IllegalStateException    if the search is repeating and there is an
	 *                                  endless loop due to outputs of one being
	 *                                  inputs to another
	 * @throws IllegalArgumentException if the lengths of the arrays are not the
	 *                                  same (null is ok, and/or size 0)
	 * @since 1.0
	 */
	public static String replaceEachRepeatedly(final String text, final String[] searchList,
			final String[] replacementList) {
		return StringUtils.replaceEachRepeatedly(text, searchList, replacementList);
	}

	// Replace, character based
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Replaces all occurrences of a character in a String with another. This is a
	 * null-safe version of {@link String#replace(char, char)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. An empty ("") string input
	 * returns an empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceChars(null, *, *)        = null
	 * StringUtils.replaceChars("", *, *)          = ""
	 * StringUtils.replaceChars("abcba", 'b', 'y') = "aycya"
	 * StringUtils.replaceChars("abcba", 'z', 'y') = "abcba"
	 * </pre>
	 *
	 * @param str         String to replace characters in, may be null
	 * @param searchChar  the character to search for, may be null
	 * @param replaceChar the character to replace, may be null
	 * @return modified String, {@code null} if null string input
	 * @since 1.0
	 */
	public static String replaceChars(final String str, final char searchChar, final char replaceChar) {
		return StringUtils.replaceChars(str, searchChar, replaceChar);
	}

	/**
	 * <p>
	 * Replaces multiple characters in a String in one go. This method can also be
	 * used to delete characters.
	 * </p>
	 *
	 * <p>
	 * For example:<br>
	 * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. An empty ("") string input
	 * returns an empty string. A null or empty set of search characters returns the
	 * input string.
	 * </p>
	 *
	 * <p>
	 * The length of the search characters should normally equal the length of the
	 * replace characters. If the search characters is longer, then the extra search
	 * characters are deleted. If the search characters is shorter, then the extra
	 * replace characters are ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceChars(null, *, *)           = null
	 * StringUtils.replaceChars("", *, *)             = ""
	 * StringUtils.replaceChars("abc", null, *)       = "abc"
	 * StringUtils.replaceChars("abc", "", *)         = "abc"
	 * StringUtils.replaceChars("abc", "b", null)     = "ac"
	 * StringUtils.replaceChars("abc", "b", "")       = "ac"
	 * StringUtils.replaceChars("abcba", "bc", "yz")  = "ayzya"
	 * StringUtils.replaceChars("abcba", "bc", "y")   = "ayya"
	 * StringUtils.replaceChars("abcba", "bc", "yzx") = "ayzya"
	 * </pre>
	 *
	 * @param str          String to replace characters in, may be null
	 * @param searchChars  a set of characters to search for, may be null
	 * @param replaceChars a set of characters to replace, may be null
	 * @return modified String, {@code null} if null string input
	 * @since 1.0
	 */
	public static String replaceChars(final String str, final String searchChars, String replaceChars) {
		return StringUtils.replaceChars(str, searchChars, replaceChars);
	}

	// Overlay
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Overlays part of a String with another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. A negative index is treated
	 * as zero. An index greater than the string length is treated as the string
	 * length. The start index is always the smaller of the two indices.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.overlay(null, *, *, *)            = null
	 * StringUtils.overlay("", "abc", 0, 0)          = "abc"
	 * StringUtils.overlay("abcdef", null, 2, 4)     = "abef"
	 * StringUtils.overlay("abcdef", "", 2, 4)       = "abef"
	 * StringUtils.overlay("abcdef", "", 4, 2)       = "abef"
	 * StringUtils.overlay("abcdef", "zzzz", 2, 4)   = "abzzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", 4, 2)   = "abzzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", -1, 4)  = "zzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", 2, 8)   = "abzzzz"
	 * StringUtils.overlay("abcdef", "zzzz", -2, -3) = "zzzzabcdef"
	 * StringUtils.overlay("abcdef", "zzzz", 8, 10)  = "abcdefzzzz"
	 * </pre>
	 *
	 * @param str     the String to do overlaying in, may be null
	 * @param overlay the String to overlay, may be null
	 * @param start   the position to start overlaying at
	 * @param end     the position to stop overlaying before
	 * @return overlayed String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String overlay(final String str, String overlay, int start, int end) {
		return StringUtils.overlay(str, overlay, start, end);
	}

	// Chomping
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes one newline from end of a String if it's there, otherwise leave it
	 * alone. A newline is &quot;{@code \n}&quot;, &quot;{@code \r}&quot;, or
	 * &quot;{@code \r\n}&quot;.
	 * </p>
	 *
	 * <p>
	 * NOTE: This method changed in 2.0. It now more closely matches Perl chomp.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chomp(null)          = null
	 * StringUtils.chomp("")            = ""
	 * StringUtils.chomp("abc \r")      = "abc "
	 * StringUtils.chomp("abc\n")       = "abc"
	 * StringUtils.chomp("abc\r\n")     = "abc"
	 * StringUtils.chomp("abc\r\n\r\n") = "abc\r\n"
	 * StringUtils.chomp("abc\n\r")     = "abc\n"
	 * StringUtils.chomp("abc\n\rabc")  = "abc\n\rabc"
	 * StringUtils.chomp("\r")          = ""
	 * StringUtils.chomp("\n")          = ""
	 * StringUtils.chomp("\r\n")        = ""
	 * </pre>
	 *
	 * @param str the String to chomp a newline from, may be null
	 * @return String without newline, {@code null} if null String input
	 */
	public static String chomp(final String str) {
		return StringUtils.chomp(str);
	}

	/**
	 * <p>
	 * Removes {@code separator} from the end of {@code str} if it's there,
	 * otherwise leave it alone.
	 * </p>
	 *
	 * <p>
	 * NOTE: This method changed in version 2.0. It now more closely matches Perl
	 * chomp. For the previous behavior, use
	 * {@link #substringBeforeLast(String, String)}. This method uses
	 * {@link String#endsWith(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chomp(null, *)         = null
	 * StringUtils.chomp("", *)           = ""
	 * StringUtils.chomp("foobar", "bar") = "foo"
	 * StringUtils.chomp("foobar", "baz") = "foobar"
	 * StringUtils.chomp("foo", "foo")    = ""
	 * StringUtils.chomp("foo ", "foo")   = "foo "
	 * StringUtils.chomp(" foo", "foo")   = " "
	 * StringUtils.chomp("foo", "foooo")  = "foo"
	 * StringUtils.chomp("foo", "")       = "foo"
	 * StringUtils.chomp("foo", null)     = "foo"
	 * </pre>
	 *
	 * @param str       the String to chomp from, may be null
	 * @param separator separator String, may be null
	 * @return String without trailing separator, {@code null} if null String input
	 * @deprecated This feature will be removed in Lang 4.0, use
	 *             {@link StringUtils#removeEnd(String, String)} instead
	 */
	@Deprecated
	public static String chomp(final String str, final String separator) {
		return StringUtils.chomp(str, separator);
	}

	// Chopping
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Remove the last character from a String.
	 * </p>
	 *
	 * <p>
	 * If the String ends in {@code \r\n}, then remove both of them.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chop(null)          = null
	 * StringUtils.chop("")            = ""
	 * StringUtils.chop("abc \r")      = "abc "
	 * StringUtils.chop("abc\n")       = "abc"
	 * StringUtils.chop("abc\r\n")     = "abc"
	 * StringUtils.chop("abc")         = "ab"
	 * StringUtils.chop("abc\nabc")    = "abc\nab"
	 * StringUtils.chop("a")           = ""
	 * StringUtils.chop("\r")          = ""
	 * StringUtils.chop("\n")          = ""
	 * StringUtils.chop("\r\n")        = ""
	 * </pre>
	 *
	 * @param str the String to chop last character from, may be null
	 * @return String without last character, {@code null} if null String input
	 */
	public static String chop(final String str) {
		return StringUtils.chop(str);
	}

	// Conversion
	// -----------------------------------------------------------------------

	// Padding
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Repeat a String {@code repeat} times to form a new String.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat(null, 2) = null
	 * StringUtils.repeat("", 0)   = ""
	 * StringUtils.repeat("", 2)   = ""
	 * StringUtils.repeat("a", 3)  = "aaa"
	 * StringUtils.repeat("ab", 2) = "abab"
	 * StringUtils.repeat("a", -2) = ""
	 * </pre>
	 *
	 * @param str    the String to repeat, may be null
	 * @param repeat number of times to repeat str, negative treated as zero
	 * @return a new String consisting of the original String repeated, {@code null}
	 *         if null String input
	 */
	public static String repeat(final String str, final int repeat) {
		return StringUtils.repeat(str, repeat);
	}

	/**
	 * <p>
	 * Repeat a String {@code repeat} times to form a new String, with a String
	 * separator injected each time.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat(null, null, 2) = null
	 * StringUtils.repeat(null, "x", 2)  = null
	 * StringUtils.repeat("", null, 0)   = ""
	 * StringUtils.repeat("", "", 2)     = ""
	 * StringUtils.repeat("", "x", 3)    = "xxx"
	 * StringUtils.repeat("?", ", ", 3)  = "?, ?, ?"
	 * </pre>
	 *
	 * @param str       the String to repeat, may be null
	 * @param separator the String to inject, may be null
	 * @param repeat    number of times to repeat str, negative treated as zero
	 * @return a new String consisting of the original String repeated, {@code null}
	 *         if null String input
	 * @since 1.0
	 */
	public static String repeat(final String str, final String separator, final int repeat) {
		return StringUtils.repeat(str, separator, repeat);
	}

	/**
	 * <p>
	 * Returns padding using the specified delimiter repeated to a given length.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat('e', 0)  = ""
	 * StringUtils.repeat('e', 3)  = "eee"
	 * StringUtils.repeat('e', -2) = ""
	 * </pre>
	 *
	 * <p>
	 * Note: this method does not support padding with
	 * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode
	 * Supplementary Characters</a> as they require a pair of {@code char}s to be
	 * represented. If you are needing to support full I18N of your applications
	 * consider using {@link #repeat(String, int)} instead.
	 * </p>
	 *
	 * @param ch     character to repeat
	 * @param repeat number of times to repeat char, negative treated as zero
	 * @return String with repeated character
	 * @see #repeat(String, int)
	 */
	public static String repeat(final char ch, final int repeat) {
		return StringUtils.repeat(ch, repeat);
	}

	/**
	 * <p>
	 * Right pad a String with spaces (' ').
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *)   = null
	 * StringUtils.rightPad("", 3)     = "   "
	 * StringUtils.rightPad("bat", 3)  = "bat"
	 * StringUtils.rightPad("bat", 5)  = "bat  "
	 * StringUtils.rightPad("bat", 1)  = "bat"
	 * StringUtils.rightPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size the size to pad to
	 * @return right padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String rightPad(final String str, final int size) {
		return StringUtils.rightPad(str, size);
	}

	/**
	 * <p>
	 * Right pad a String with a specified character.
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *, *)     = null
	 * StringUtils.rightPad("", 3, 'z')     = "zzz"
	 * StringUtils.rightPad("bat", 3, 'z')  = "bat"
	 * StringUtils.rightPad("bat", 5, 'z')  = "batzz"
	 * StringUtils.rightPad("bat", 1, 'z')  = "bat"
	 * StringUtils.rightPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str     the String to pad out, may be null
	 * @param size    the size to pad to
	 * @param padChar the character to pad with
	 * @return right padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String rightPad(final String str, final int size, final char padChar) {
		return StringUtils.rightPad(str, size, padChar);
	}

	/**
	 * <p>
	 * Right pad a String with a specified String.
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *, *)      = null
	 * StringUtils.rightPad("", 3, "z")      = "zzz"
	 * StringUtils.rightPad("bat", 3, "yz")  = "bat"
	 * StringUtils.rightPad("bat", 5, "yz")  = "batyz"
	 * StringUtils.rightPad("bat", 8, "yz")  = "batyzyzy"
	 * StringUtils.rightPad("bat", 1, "yz")  = "bat"
	 * StringUtils.rightPad("bat", -1, "yz") = "bat"
	 * StringUtils.rightPad("bat", 5, null)  = "bat  "
	 * StringUtils.rightPad("bat", 5, "")    = "bat  "
	 * </pre>
	 *
	 * @param str    the String to pad out, may be null
	 * @param size   the size to pad to
	 * @param padStr the String to pad with, null or empty treated as single space
	 * @return right padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String rightPad(final String str, final int size, String padStr) {
		return StringUtils.rightPad(str, size, padStr);
	}

	/**
	 * <p>
	 * Left pad a String with spaces (' ').
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *)   = null
	 * StringUtils.leftPad("", 3)     = "   "
	 * StringUtils.leftPad("bat", 3)  = "bat"
	 * StringUtils.leftPad("bat", 5)  = "  bat"
	 * StringUtils.leftPad("bat", 1)  = "bat"
	 * StringUtils.leftPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size the size to pad to
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String leftPad(final String str, final int size) {
		return StringUtils.leftPad(str, size);
	}

	/**
	 * <p>
	 * Left pad a String with a specified character.
	 * </p>
	 *
	 * <p>
	 * Pad to a size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *, *)     = null
	 * StringUtils.leftPad("", 3, 'z')     = "zzz"
	 * StringUtils.leftPad("bat", 3, 'z')  = "bat"
	 * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
	 * StringUtils.leftPad("bat", 1, 'z')  = "bat"
	 * StringUtils.leftPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str     the String to pad out, may be null
	 * @param size    the size to pad to
	 * @param padChar the character to pad with
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String leftPad(final String str, final int size, final char padChar) {
		return StringUtils.leftPad(str, size, padChar);
	}

	/**
	 * <p>
	 * Left pad a String with a specified String.
	 * </p>
	 *
	 * <p>
	 * Pad to a size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *, *)      = null
	 * StringUtils.leftPad("", 3, "z")      = "zzz"
	 * StringUtils.leftPad("bat", 3, "yz")  = "bat"
	 * StringUtils.leftPad("bat", 5, "yz")  = "yzbat"
	 * StringUtils.leftPad("bat", 8, "yz")  = "yzyzybat"
	 * StringUtils.leftPad("bat", 1, "yz")  = "bat"
	 * StringUtils.leftPad("bat", -1, "yz") = "bat"
	 * StringUtils.leftPad("bat", 5, null)  = "  bat"
	 * StringUtils.leftPad("bat", 5, "")    = "  bat"
	 * </pre>
	 *
	 * @param str    the String to pad out, may be null
	 * @param size   the size to pad to
	 * @param padStr the String to pad with, null or empty treated as single space
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String leftPad(final String str, final int size, String padStr) {
		return StringUtils.leftPad(str, size, padStr);
	}

	/**
	 * Gets a CharSequence length or {@code 0} if the CharSequence is {@code null}.
	 *
	 * @param cs a CharSequence or {@code null}
	 * @return CharSequence length or {@code 0} if the CharSequence is {@code null}.
	 * @since 1.0
	 * @since 1.0 Changed signature from length(String) to length(CharSequence)
	 */
	public static int length(final CharSequence cs) {
		return StringUtils.length(cs);
	}

	// Centering
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size} using the space
	 * character (' ').
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as zero.
	 * </p>
	 *
	 * <p>
	 * Equivalent to {@code center(str, size, " ")}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *)   = null
	 * StringUtils.center("", 4)     = "    "
	 * StringUtils.center("ab", -1)  = "ab"
	 * StringUtils.center("ab", 4)   = " ab "
	 * StringUtils.center("abcd", 2) = "abcd"
	 * StringUtils.center("a", 4)    = " a  "
	 * </pre>
	 *
	 * @param str  the String to center, may be null
	 * @param size the int size of new String, negative treated as zero
	 * @return centered String, {@code null} if null String input
	 */
	public static String center(final String str, final int size) {
		return StringUtils.center(str, size);
	}

	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size}. Uses a supplied
	 * character as the value to pad the String with.
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as zero.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *, *)     = null
	 * StringUtils.center("", 4, ' ')     = "    "
	 * StringUtils.center("ab", -1, ' ')  = "ab"
	 * StringUtils.center("ab", 4, ' ')   = " ab "
	 * StringUtils.center("abcd", 2, ' ') = "abcd"
	 * StringUtils.center("a", 4, ' ')    = " a  "
	 * StringUtils.center("a", 4, 'y')    = "yayy"
	 * </pre>
	 *
	 * @param str     the String to center, may be null
	 * @param size    the int size of new String, negative treated as zero
	 * @param padChar the character to pad the new String with
	 * @return centered String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String center(String str, final int size, final char padChar) {
		return StringUtils.center(str, size, padChar);
	}

	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size}. Uses a supplied
	 * String as the value to pad the String with.
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as zero.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *, *)     = null
	 * StringUtils.center("", 4, " ")     = "    "
	 * StringUtils.center("ab", -1, " ")  = "ab"
	 * StringUtils.center("ab", 4, " ")   = " ab "
	 * StringUtils.center("abcd", 2, " ") = "abcd"
	 * StringUtils.center("a", 4, " ")    = " a  "
	 * StringUtils.center("a", 4, "yz")   = "yayz"
	 * StringUtils.center("abc", 7, null) = "  abc  "
	 * StringUtils.center("abc", 7, "")   = "  abc  "
	 * </pre>
	 *
	 * @param str    the String to center, may be null
	 * @param size   the int size of new String, negative treated as zero
	 * @param padStr the String to pad the new String with, must not be null or
	 *               empty
	 * @return centered String, {@code null} if null String input
	 * @throws IllegalArgumentException if padStr is {@code null} or empty
	 */
	public static String center(String str, final int size, String padStr) {
		return StringUtils.center(str, size, padStr);
	}

	// Case conversion
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to upper case as per {@link String#toUpperCase()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.upperCase(null)  = null
	 * StringUtils.upperCase("")    = ""
	 * StringUtils.upperCase("aBc") = "ABC"
	 * </pre>
	 *
	 * <p>
	 * <strong>Note:</strong> As described in the documentation for
	 * {@link String#toUpperCase()}, the result of this method is affected by the
	 * current locale. For platform-independent case transformations, the method
	 * {@link #lowerCase(String, Locale)} should be used with a specific locale
	 * (e.g. {@link Locale#ENGLISH}).
	 * </p>
	 *
	 * @param str the String to upper case, may be null
	 * @return the upper cased String, {@code null} if null String input
	 */
	public static String upperCase(final String str) {
		return StringUtils.upperCase(str);
	}

	/**
	 * <p>
	 * Converts a String to lower case as per {@link String#toLowerCase()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lowerCase(null)  = null
	 * StringUtils.lowerCase("")    = ""
	 * StringUtils.lowerCase("aBc") = "abc"
	 * </pre>
	 *
	 * <p>
	 * <strong>Note:</strong> As described in the documentation for
	 * {@link String#toLowerCase()}, the result of this method is affected by the
	 * current locale. For platform-independent case transformations, the method
	 * {@link #lowerCase(String, Locale)} should be used with a specific locale
	 * (e.g. {@link Locale#ENGLISH}).
	 * </p>
	 *
	 * @param str the String to lower case, may be null
	 * @return the lower cased String, {@code null} if null String input
	 */
	public static String lowerCase(final String str) {
		return StringUtils.lowerCase(str);
	}

	/**
	 * <p>
	 * Capitalizes a String changing the first character to title case as per
	 * {@link Character#toTitleCase(int)}. No other characters are changed.
	 * </p>
	 *
	 * <p>
	 * For a word based algorithm, see
	 * {@link org.apache.commons.lang3.text.WordUtils#capitalize(String)}. A
	 * {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.capitalize(null)  = null
	 * StringUtils.capitalize("")    = ""
	 * StringUtils.capitalize("cat") = "Cat"
	 * StringUtils.capitalize("cAt") = "CAt"
	 * StringUtils.capitalize("'cat'") = "'cat'"
	 * </pre>
	 *
	 * @param str the String to capitalize, may be null
	 * @return the capitalized String, {@code null} if null String input
	 * @see org.apache.commons.lang3.text.WordUtils#capitalize(String)
	 * @see #uncapitalize(String)
	 * @since 1.0
	 */
	public static String capitalize(final String str) {
		return StringUtils.capitalize(str);
	}

	/**
	 * <p>
	 * Uncapitalizes a String, changing the first character to lower case as per
	 * {@link Character#toLowerCase(int)}. No other characters are changed.
	 * </p>
	 *
	 * <p>
	 * For a word based algorithm, see
	 * {@link org.apache.commons.lang3.text.WordUtils#uncapitalize(String)}. A
	 * {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.uncapitalize(null)  = null
	 * StringUtils.uncapitalize("")    = ""
	 * StringUtils.uncapitalize("cat") = "cat"
	 * StringUtils.uncapitalize("Cat") = "cat"
	 * StringUtils.uncapitalize("CAT") = "cAT"
	 * </pre>
	 *
	 * @param str the String to uncapitalize, may be null
	 * @return the uncapitalized String, {@code null} if null String input
	 * @see org.apache.commons.lang3.text.WordUtils#uncapitalize(String)
	 * @see #capitalize(String)
	 * @since 1.0
	 */
	public static String uncapitalize(final String str) {
		return StringUtils.uncapitalize(str);
	}

	/**
	 * <p>
	 * Swaps the case of a String changing upper and title case to lower case, and
	 * lower case to upper case.
	 * </p>
	 *
	 * <ul>
	 * <li>Upper case character converts to Lower case</li>
	 * <li>Title case character converts to Lower case</li>
	 * <li>Lower case character converts to Upper case</li>
	 * </ul>
	 *
	 * <p>
	 * For a word based algorithm, see
	 * {@link org.apache.commons.lang3.text.WordUtils#swapCase(String)}. A
	 * {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.swapCase(null)                 = null
	 * StringUtils.swapCase("")                   = ""
	 * StringUtils.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
	 * </pre>
	 *
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer performs a word
	 * based algorithm. If you only use ASCII, you will notice no change. That
	 * functionality is available in org.apache.commons.lang3.text.WordUtils.
	 * </p>
	 *
	 * @param str the String to swap case, may be null
	 * @return the changed String, {@code null} if null String input
	 */
	public static String swapCase(final String str) {
		return StringUtils.swapCase(str);
	}

	/**
	 * <p>
	 * Counts how many times the char appears in the given string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") String input returns {@code 0}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.countMatches(null, *)       = 0
	 * StringUtils.countMatches("", *)         = 0
	 * StringUtils.countMatches("abba", 0)  = 0
	 * StringUtils.countMatches("abba", 'a')   = 2
	 * StringUtils.countMatches("abba", 'b')  = 2
	 * StringUtils.countMatches("abba", 'x') = 0
	 * </pre>
	 *
	 * @param str the CharSequence to check, may be null
	 * @param ch  the char to count
	 * @return the number of occurrences, 0 if the CharSequence is {@code null}
	 * @since 1.0
	 */
	public static int countMatches(final CharSequence str, final char ch) {
		return StringUtils.countMatches(str, ch);
	}

	// Character Tests
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlpha(null)   = false
	 * StringUtils.isAlpha("")     = false
	 * StringUtils.isAlpha("  ")   = false
	 * StringUtils.isAlpha("abc")  = true
	 * StringUtils.isAlpha("ab2c") = false
	 * StringUtils.isAlpha("ab-c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, and is non-null
	 * @since 1.0 Changed signature from isAlpha(String) to isAlpha(CharSequence)
	 * @since 1.0 Changed "" to return false and not true
	 */
	public static boolean isAlpha(final CharSequence cs) {
		return StringUtils.isAlpha(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters and space (' ').
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false} An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphaSpace(null)   = false
	 * StringUtils.isAlphaSpace("")     = true
	 * StringUtils.isAlphaSpace("  ")   = true
	 * StringUtils.isAlphaSpace("abc")  = true
	 * StringUtils.isAlphaSpace("ab c") = true
	 * StringUtils.isAlphaSpace("ab2c") = false
	 * StringUtils.isAlphaSpace("ab-c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains letters and space, and is non-null
	 * @since 1.0 Changed signature from isAlphaSpace(String) to
	 *        isAlphaSpace(CharSequence)
	 */
	public static boolean isAlphaSpace(final CharSequence cs) {
		return StringUtils.isAlphaSpace(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters or digits.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphanumeric(null)   = false
	 * StringUtils.isAlphanumeric("")     = false
	 * StringUtils.isAlphanumeric("  ")   = false
	 * StringUtils.isAlphanumeric("abc")  = true
	 * StringUtils.isAlphanumeric("ab c") = false
	 * StringUtils.isAlphanumeric("ab2c") = true
	 * StringUtils.isAlphanumeric("ab-c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains letters or digits, and is non-null
	 * @since 1.0 Changed signature from isAlphanumeric(String) to
	 *        isAlphanumeric(CharSequence)
	 * @since 1.0 Changed "" to return false and not true
	 */
	public static boolean isAlphanumeric(final CharSequence cs) {
		return StringUtils.isAlphanumeric(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters, digits or space
	 * ({@code ' '}).
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphanumericSpace(null)   = false
	 * StringUtils.isAlphanumericSpace("")     = true
	 * StringUtils.isAlphanumericSpace("  ")   = true
	 * StringUtils.isAlphanumericSpace("abc")  = true
	 * StringUtils.isAlphanumericSpace("ab c") = true
	 * StringUtils.isAlphanumericSpace("ab2c") = true
	 * StringUtils.isAlphanumericSpace("ab-c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, digits or space, and is
	 *         non-null
	 * @since 1.0 Changed signature from isAlphanumericSpace(String) to
	 *        isAlphanumericSpace(CharSequence)
	 */
	public static boolean isAlphanumericSpace(final CharSequence cs) {
		return StringUtils.isAlphanumericSpace(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only ASCII printable characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAsciiPrintable(null)     = false
	 * StringUtils.isAsciiPrintable("")       = true
	 * StringUtils.isAsciiPrintable(" ")      = true
	 * StringUtils.isAsciiPrintable("Ceki")   = true
	 * StringUtils.isAsciiPrintable("ab2c")   = true
	 * StringUtils.isAsciiPrintable("!ab-c~") = true
	 * StringUtils.isAsciiPrintable("\u0020") = true
	 * StringUtils.isAsciiPrintable("\u0021") = true
	 * StringUtils.isAsciiPrintable("\u007e") = true
	 * StringUtils.isAsciiPrintable("\u007f") = false
	 * StringUtils.isAsciiPrintable("Ceki G\u00fclc\u00fc") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if every character is in the range 32 thru 126
	 * @since 1.0
	 * @since 1.0 Changed signature from isAsciiPrintable(String) to
	 *        isAsciiPrintable(CharSequence)
	 */
	public static boolean isAsciiPrintable(final CharSequence cs) {
		return StringUtils.isAsciiPrintable(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits. A decimal point is
	 * not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code false}.
	 * </p>
	 *
	 * <p>
	 * Note that the method does not allow for a leading sign, either positive or
	 * negative. Also, if a String passes the numeric test, it may still generate a
	 * NumberFormatException when parsed by Integer.parseInt or Long.parseLong, e.g.
	 * if the value is outside the range for int or long respectively.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNumeric(null)   = false
	 * StringUtils.isNumeric("")     = false
	 * StringUtils.isNumeric("  ")   = false
	 * StringUtils.isNumeric("123")  = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969")  = true
	 * StringUtils.isNumeric("12 3") = false
	 * StringUtils.isNumeric("ab2c") = false
	 * StringUtils.isNumeric("12-3") = false
	 * StringUtils.isNumeric("12.3") = false
	 * StringUtils.isNumeric("-123") = false
	 * StringUtils.isNumeric("+123") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains digits, and is non-null
	 * @since 1.0 Changed signature from isNumeric(String) to
	 *        isNumeric(CharSequence)
	 * @since 1.0 Changed "" to return false and not true
	 */
	public static boolean isNumeric(final CharSequence cs) {
		return StringUtils.isNumeric(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits or space
	 * ({@code ' '}). A decimal point is not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNumericSpace(null)   = false
	 * StringUtils.isNumericSpace("")     = true
	 * StringUtils.isNumericSpace("  ")   = true
	 * StringUtils.isNumericSpace("123")  = true
	 * StringUtils.isNumericSpace("12 3") = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969")  = true
	 * StringUtils.isNumeric("\u0967\u0968 \u0969")  = true
	 * StringUtils.isNumericSpace("ab2c") = false
	 * StringUtils.isNumericSpace("12-3") = false
	 * StringUtils.isNumericSpace("12.3") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains digits or space, and is non-null
	 * @since 1.0 Changed signature from isNumericSpace(String) to
	 *        isNumericSpace(CharSequence)
	 */
	public static boolean isNumericSpace(final CharSequence cs) {
		return StringUtils.isNumericSpace(cs);
	}

	/**
	 * <p>
	 * Checks if a String {@code str} contains Unicode digits, if yes then
	 * concatenate all the digits in {@code str} and return it as a String.
	 * </p>
	 *
	 * <p>
	 * An empty ("") String will be returned if no digits found in {@code str}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getDigits(null)  = null
	 * StringUtils.getDigits("")    = ""
	 * StringUtils.getDigits("abc") = ""
	 * StringUtils.getDigits("1000$") = "1000"
	 * StringUtils.getDigits("1123~45") = "112345"
	 * StringUtils.getDigits("(541) 754-3010") = "5417543010"
	 * StringUtils.getDigits("\u0967\u0968\u0969") = "\u0967\u0968\u0969"
	 * </pre>
	 *
	 * @param str the String to extract digits from, may be null
	 * @return String with only digits, or an empty ("") String if no digits found,
	 *         or {@code null} String if {@code str} is null
	 * @since 1.0
	 */
	public static String getDigits(final String str) {
		return StringUtils.getDigits(str);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only whitespace.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isWhitespace(null)   = false
	 * StringUtils.isWhitespace("")     = true
	 * StringUtils.isWhitespace("  ")   = true
	 * StringUtils.isWhitespace("abc")  = false
	 * StringUtils.isWhitespace("ab2c") = false
	 * StringUtils.isWhitespace("ab-c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains whitespace, and is non-null
	 * @since 1.0
	 * @since 1.0 Changed signature from isWhitespace(String) to
	 *        isWhitespace(CharSequence)
	 */
	public static boolean isWhitespace(final CharSequence cs) {
		return StringUtils.isWhitespace(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only lowercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence (length()=0)
	 * will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllLowerCase(null)   = false
	 * StringUtils.isAllLowerCase("")     = false
	 * StringUtils.isAllLowerCase("  ")   = false
	 * StringUtils.isAllLowerCase("abc")  = true
	 * StringUtils.isAllLowerCase("abC")  = false
	 * StringUtils.isAllLowerCase("ab c") = false
	 * StringUtils.isAllLowerCase("ab1c") = false
	 * StringUtils.isAllLowerCase("ab/c") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains lowercase characters, and is non-null
	 * @since 1.0
	 * @since 1.0 Changed signature from isAllLowerCase(String) to
	 *        isAllLowerCase(CharSequence)
	 */
	public static boolean isAllLowerCase(final CharSequence cs) {
		return StringUtils.isAllLowerCase(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only uppercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty String (length()=0) will
	 * return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllUpperCase(null)   = false
	 * StringUtils.isAllUpperCase("")     = false
	 * StringUtils.isAllUpperCase("  ")   = false
	 * StringUtils.isAllUpperCase("ABC")  = true
	 * StringUtils.isAllUpperCase("aBC")  = false
	 * StringUtils.isAllUpperCase("A C")  = false
	 * StringUtils.isAllUpperCase("A1C")  = false
	 * StringUtils.isAllUpperCase("A/C")  = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if only contains uppercase characters, and is non-null
	 * @since 1.0
	 * @since 1.0 Changed signature from isAllUpperCase(String) to
	 *        isAllUpperCase(CharSequence)
	 */
	public static boolean isAllUpperCase(final CharSequence cs) {
		return StringUtils.isAllUpperCase(cs);
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains mixed casing of both uppercase and
	 * lowercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * ({@code length()=0}) will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isMixedCase(null)    = false
	 * StringUtils.isMixedCase("")      = false
	 * StringUtils.isMixedCase("ABC")   = false
	 * StringUtils.isMixedCase("abc")   = false
	 * StringUtils.isMixedCase("aBc")   = true
	 * StringUtils.isMixedCase("A c")   = true
	 * StringUtils.isMixedCase("A1c")   = true
	 * StringUtils.isMixedCase("a/C")   = true
	 * StringUtils.isMixedCase("aC\t")  = true
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence contains both uppercase and
	 *         lowercase characters
	 * @since 1.0
	 */
	public static boolean isMixedCase(final CharSequence cs) {
		return StringUtils.isMixedCase(cs);
	}

	// Defaults
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null}, an
	 * empty String ("").
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultString(null)  = ""
	 * StringUtils.defaultString("")    = ""
	 * StringUtils.defaultString("bat") = "bat"
	 * </pre>
	 *
	 * @see ObjectUtils#toString(Object)
	 * @see String#valueOf(Object)
	 * @param str the String to check, may be null
	 * @return the passed in String, or the empty String if it was {@code null}
	 */
	public static String defaultString(final String str) {
		return StringUtils.defaultString(str);
	}

	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null}, the
	 * value of {@code defaultStr}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultString(null, "NULL")  = "NULL"
	 * StringUtils.defaultString("", "NULL")    = ""
	 * StringUtils.defaultString("bat", "NULL") = "bat"
	 * </pre>
	 *
	 * @see ObjectUtils#toString(Object,String)
	 * @see String#valueOf(Object)
	 * @param str        the String to check, may be null
	 * @param defaultStr the default String to return if the input is {@code null},
	 *                   may be null
	 * @return the passed in String, or the default if it was {@code null}
	 */
	public static String defaultString(final String str, final String defaultStr) {
		return StringUtils.defaultString(defaultStr);
	}

	/**
	 * <p>
	 * Returns the first value in the array which is not empty (""), {@code null} or
	 * whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * If all values are blank or the array is {@code null} or empty then
	 * {@code null} is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.firstNonBlank(null, null, null)     = null
	 * StringUtils.firstNonBlank(null, "", " ")        = null
	 * StringUtils.firstNonBlank("abc")                = "abc"
	 * StringUtils.firstNonBlank(null, "xyz")          = "xyz"
	 * StringUtils.firstNonBlank(null, "", " ", "xyz") = "xyz"
	 * StringUtils.firstNonBlank(null, "xyz", "abc")   = "xyz"
	 * StringUtils.firstNonBlank()                     = null
	 * </pre>
	 *
	 * @param        <T> the specific kind of CharSequence
	 * @param values the values to test, may be {@code null} or empty
	 * @return the first value from {@code values} which is not blank, or
	 *         {@code null} if there are no non-blank values
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> T firstNonBlank(final T... values) {
		return StringUtils.firstNonBlank(values);
	}

	/**
	 * <p>
	 * Returns the first value in the array which is not empty.
	 * </p>
	 *
	 * <p>
	 * If all values are empty or the array is {@code null} or empty then
	 * {@code null} is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.firstNonEmpty(null, null, null)   = null
	 * StringUtils.firstNonEmpty(null, null, "")     = null
	 * StringUtils.firstNonEmpty(null, "", " ")      = " "
	 * StringUtils.firstNonEmpty("abc")              = "abc"
	 * StringUtils.firstNonEmpty(null, "xyz")        = "xyz"
	 * StringUtils.firstNonEmpty("", "xyz")          = "xyz"
	 * StringUtils.firstNonEmpty(null, "xyz", "abc") = "xyz"
	 * StringUtils.firstNonEmpty()                   = null
	 * </pre>
	 *
	 * @param        <T> the specific kind of CharSequence
	 * @param values the values to test, may be {@code null} or empty
	 * @return the first value from {@code values} which is not empty, or
	 *         {@code null} if there are no non-empty values
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> T firstNonEmpty(final T... values) {
		return StringUtils.firstNonEmpty(values);
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is
	 * whitespace, empty ("") or {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultIfBlank(null, "NULL")  = "NULL"
	 * StringUtils.defaultIfBlank("", "NULL")    = "NULL"
	 * StringUtils.defaultIfBlank(" ", "NULL")   = "NULL"
	 * StringUtils.defaultIfBlank("bat", "NULL") = "bat"
	 * StringUtils.defaultIfBlank("", null)      = null
	 * </pre>
	 * 
	 * @param            <T> the specific kind of CharSequence
	 * @param str        the CharSequence to check, may be null
	 * @param defaultStr the default CharSequence to return if the input is
	 *                   whitespace, empty ("") or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static <T extends CharSequence> T defaultIfBlank(final T str, final T defaultStr) {
		return StringUtils.defaultIfBlank(str, defaultStr);
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is empty or
	 * {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultIfEmpty(null, "NULL")  = "NULL"
	 * StringUtils.defaultIfEmpty("", "NULL")    = "NULL"
	 * StringUtils.defaultIfEmpty(" ", "NULL")   = " "
	 * StringUtils.defaultIfEmpty("bat", "NULL") = "bat"
	 * StringUtils.defaultIfEmpty("", null)      = null
	 * </pre>
	 * 
	 * @param            <T> the specific kind of CharSequence
	 * @param str        the CharSequence to check, may be null
	 * @param defaultStr the default CharSequence to return if the input is empty
	 *                   ("") or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultStr) {
		return StringUtils.defaultIfBlank(str, defaultStr);
	}

	// Rotating (circular shift)
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Rotate (circular shift) a String of {@code shift} characters.
	 * </p>
	 * <ul>
	 * <li>If {@code shift > 0}, right circular shift (ex : ABCDEF =&gt;
	 * FABCDE)</li>
	 * <li>If {@code shift < 0}, left circular shift (ex : ABCDEF =&gt; BCDEFA)</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.rotate(null, *)        = null
	 * StringUtils.rotate("", *)          = ""
	 * StringUtils.rotate("abcdefg", 0)   = "abcdefg"
	 * StringUtils.rotate("abcdefg", 2)   = "fgabcde"
	 * StringUtils.rotate("abcdefg", -2)  = "cdefgab"
	 * StringUtils.rotate("abcdefg", 7)   = "abcdefg"
	 * StringUtils.rotate("abcdefg", -7)  = "abcdefg"
	 * StringUtils.rotate("abcdefg", 9)   = "fgabcde"
	 * StringUtils.rotate("abcdefg", -9)  = "cdefgab"
	 * </pre>
	 *
	 * @param str   the String to rotate, may be null
	 * @param shift number of time to shift (positive : right shift, negative : left
	 *              shift)
	 * @return the rotated String, or the original String if {@code shift == 0}, or
	 *         {@code null} if null String input
	 * @since 1.0
	 */
	public static String rotate(final String str, final int shift) {
		return StringUtils.rotate(str, shift);
	}

	// Reversing
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Reverses a String as per {@link StringBuilder#reverse()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.reverse(null)  = null
	 * StringUtils.reverse("")    = ""
	 * StringUtils.reverse("bat") = "tab"
	 * </pre>
	 *
	 * @param str the String to reverse, may be null
	 * @return the reversed String, {@code null} if null String input
	 */
	public static String reverse(final String str) {
		return StringUtils.reverse(str);
	}

	/**
	 * <p>
	 * Reverses a String that is delimited by a specific character.
	 * </p>
	 *
	 * <p>
	 * The Strings between the delimiters are not reversed. Thus java.lang.String
	 * becomes String.lang.java (if the delimiter is {@code '.'}).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.reverseDelimited(null, *)      = null
	 * StringUtils.reverseDelimited("", *)        = ""
	 * StringUtils.reverseDelimited("a.b.c", 'x') = "a.b.c"
	 * StringUtils.reverseDelimited("a.b.c", ".") = "c.b.a"
	 * </pre>
	 *
	 * @param str           the String to reverse, may be null
	 * @param separatorChar the separator character to use
	 * @return the reversed String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String reverseDelimited(final String str, final char separatorChar) {
		return StringUtils.reverseDelimited(str, separatorChar);
	}

	// Abbreviating
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Abbreviates a String using ellipses. This will turn "Now is the time for all
	 * good men" into "Now is the time for..."
	 * </p>
	 *
	 * <p>
	 * Specifically:
	 * </p>
	 * <ul>
	 * <li>If the number of characters in {@code str} is less than or equal to
	 * {@code maxWidth}, return {@code str}.</li>
	 * <li>Else abbreviate it to {@code (substring(str, 0, max-3) + "...")}.</li>
	 * <li>If {@code maxWidth} is less than {@code 4}, throw an
	 * {@code IllegalArgumentException}.</li>
	 * <li>In no case will it return a String of length greater than
	 * {@code maxWidth}.</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, *)      = null
	 * StringUtils.abbreviate("", 4)        = ""
	 * StringUtils.abbreviate("abcdefg", 6) = "abc..."
	 * StringUtils.abbreviate("abcdefg", 7) = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", 8) = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", 4) = "a..."
	 * StringUtils.abbreviate("abcdefg", 3) = IllegalArgumentException
	 * </pre>
	 *
	 * @param str      the String to check, may be null
	 * @param maxWidth maximum length of result String, must be at least 4
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 1.0
	 */
	public static String abbreviate(final String str, final int maxWidth) {
		return StringUtils.abbreviate(str, maxWidth);
	}

	/**
	 * <p>
	 * Abbreviates a String using ellipses. This will turn "Now is the time for all
	 * good men" into "...is the time for..."
	 * </p>
	 *
	 * <p>
	 * Works like {@code abbreviate(String, int)}, but allows you to specify a "left
	 * edge" offset. Note that this left edge is not necessarily going to be the
	 * leftmost character in the result, or the first character following the
	 * ellipses, but it will appear somewhere in the result.
	 *
	 * <p>
	 * In no case will it return a String of length greater than {@code maxWidth}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, *, *)                = null
	 * StringUtils.abbreviate("", 0, 4)                  = ""
	 * StringUtils.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
	 * StringUtils.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
	 * StringUtils.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
	 * StringUtils.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
	 * </pre>
	 *
	 * @param str      the String to check, may be null
	 * @param offset   left edge of source String
	 * @param maxWidth maximum length of result String, must be at least 4
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 1.0
	 */
	public static String abbreviate(final String str, final int offset, final int maxWidth) {
		return StringUtils.abbreviate(str, offset, maxWidth);
	}

	/**
	 * <p>
	 * Abbreviates a String using another given String as replacement marker. This
	 * will turn "Now is the time for all good men" into "Now is the time for..." if
	 * "..." was defined as the replacement marker.
	 * </p>
	 *
	 * <p>
	 * Specifically:
	 * </p>
	 * <ul>
	 * <li>If the number of characters in {@code str} is less than or equal to
	 * {@code maxWidth}, return {@code str}.</li>
	 * <li>Else abbreviate it to
	 * {@code (substring(str, 0, max-abbrevMarker.length) + abbrevMarker)}.</li>
	 * <li>If {@code maxWidth} is less than {@code abbrevMarker.length + 1}, throw
	 * an {@code IllegalArgumentException}.</li>
	 * <li>In no case will it return a String of length greater than
	 * {@code maxWidth}.</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, "...", *)      = null
	 * StringUtils.abbreviate("abcdefg", null, *)  = "abcdefg"
	 * StringUtils.abbreviate("", "...", 4)        = ""
	 * StringUtils.abbreviate("abcdefg", ".", 5)   = "abcd."
	 * StringUtils.abbreviate("abcdefg", ".", 7)   = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", ".", 8)   = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", "..", 4)  = "ab.."
	 * StringUtils.abbreviate("abcdefg", "..", 3)  = "a.."
	 * StringUtils.abbreviate("abcdefg", "..", 2)  = IllegalArgumentException
	 * StringUtils.abbreviate("abcdefg", "...", 3) = IllegalArgumentException
	 * </pre>
	 *
	 * @param str          the String to check, may be null
	 * @param abbrevMarker the String used as replacement marker
	 * @param maxWidth     maximum length of result String, must be at least
	 *                     {@code abbrevMarker.length + 1}
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 1.0
	 */
	public static String abbreviate(final String str, final String abbrevMarker, final int maxWidth) {
		return StringUtils.abbreviate(str, abbrevMarker, maxWidth);
	}

	/**
	 * <p>
	 * Abbreviates a String using a given replacement marker. This will turn "Now is
	 * the time for all good men" into "...is the time for..." if "..." was defined
	 * as the replacement marker.
	 * </p>
	 *
	 * <p>
	 * Works like {@code abbreviate(String, String, int)}, but allows you to specify
	 * a "left edge" offset. Note that this left edge is not necessarily going to be
	 * the leftmost character in the result, or the first character following the
	 * replacement marker, but it will appear somewhere in the result.
	 *
	 * <p>
	 * In no case will it return a String of length greater than {@code maxWidth}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, null, *, *)                 = null
	 * StringUtils.abbreviate("abcdefghijklmno", null, *, *)    = "abcdefghijklmno"
	 * StringUtils.abbreviate("", "...", 0, 4)                  = ""
	 * StringUtils.abbreviate("abcdefghijklmno", "---", -1, 10) = "abcdefg---"
	 * StringUtils.abbreviate("abcdefghijklmno", ",", 0, 10)    = "abcdefghi,"
	 * StringUtils.abbreviate("abcdefghijklmno", ",", 1, 10)    = "abcdefghi,"
	 * StringUtils.abbreviate("abcdefghijklmno", ",", 2, 10)    = "abcdefghi,"
	 * StringUtils.abbreviate("abcdefghijklmno", "::", 4, 10)   = "::efghij::"
	 * StringUtils.abbreviate("abcdefghijklmno", "...", 6, 10)  = "...ghij..."
	 * StringUtils.abbreviate("abcdefghijklmno", "*", 9, 10)    = "*ghijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", "'", 10, 10)   = "'ghijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", "!", 12, 10)   = "!ghijklmno"
	 * StringUtils.abbreviate("abcdefghij", "abra", 0, 4)       = IllegalArgumentException
	 * StringUtils.abbreviate("abcdefghij", "...", 5, 6)        = IllegalArgumentException
	 * </pre>
	 *
	 * @param str          the String to check, may be null
	 * @param abbrevMarker the String used as replacement marker
	 * @param offset       left edge of source String
	 * @param maxWidth     maximum length of result String, must be at least 4
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 1.0
	 */
	public static String abbreviate(final String str, final String abbrevMarker, int offset, final int maxWidth) {
		return StringUtils.abbreviate(str, abbrevMarker, offset, maxWidth);
	}

	/**
	 * <p>
	 * Abbreviates a String to the length passed, replacing the middle characters
	 * with the supplied replacement String.
	 * </p>
	 *
	 * <p>
	 * This abbreviation only occurs if the following criteria is met:
	 * </p>
	 * <ul>
	 * <li>Neither the String for abbreviation nor the replacement String are null
	 * or empty</li>
	 * <li>The length to truncate to is less than the length of the supplied
	 * String</li>
	 * <li>The length to truncate to is greater than 0</li>
	 * <li>The abbreviated String will have enough room for the length supplied
	 * replacement String and the first and last characters of the supplied String
	 * for abbreviation</li>
	 * </ul>
	 * <p>
	 * Otherwise, the returned String will be the same as the supplied String for
	 * abbreviation.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.abbreviateMiddle(null, null, 0)      = null
	 * StringUtils.abbreviateMiddle("abc", null, 0)      = "abc"
	 * StringUtils.abbreviateMiddle("abc", ".", 0)      = "abc"
	 * StringUtils.abbreviateMiddle("abc", ".", 3)      = "abc"
	 * StringUtils.abbreviateMiddle("abcdef", ".", 4)     = "ab.f"
	 * </pre>
	 *
	 * @param str    the String to abbreviate, may be null
	 * @param middle the String to replace the middle characters with, may be null
	 * @param length the length to abbreviate {@code str} to.
	 * @return the abbreviated String if the above criteria is met, or the original
	 *         String supplied for abbreviation.
	 * @since 1.0
	 */
	public static String abbreviateMiddle(final String str, final String middle, final int length) {
		return StringUtils.abbreviateMiddle(str, middle, length);
	}

	// Difference
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compares two Strings, and returns the portion where they differ. More
	 * precisely, return the remainder of the second String, starting from where
	 * it's different from the first. This means that the difference between "abc"
	 * and "ab" is the empty String and not "c".
	 * </p>
	 *
	 * <p>
	 * For example, {@code difference("i am a machine", "i am a robot") -> "robot"}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.difference(null, null) = null
	 * StringUtils.difference("", "") = ""
	 * StringUtils.difference("", "abc") = "abc"
	 * StringUtils.difference("abc", "") = ""
	 * StringUtils.difference("abc", "abc") = ""
	 * StringUtils.difference("abc", "ab") = ""
	 * StringUtils.difference("ab", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "xyz") = "xyz"
	 * </pre>
	 *
	 * @param str1 the first String, may be null
	 * @param str2 the second String, may be null
	 * @return the portion of str2 where it differs from str1; returns the empty
	 *         String if they are equal
	 * @see #indexOfDifference(CharSequence,CharSequence)
	 * @since 1.0
	 */
	public static String difference(final String str1, final String str2) {
		return StringUtils.difference(str1, str2);
	}

	/**
	 * <p>
	 * Compares two CharSequences, and returns the index at which the CharSequences
	 * begin to differ.
	 * </p>
	 *
	 * <p>
	 * For example, {@code indexOfDifference("i am a machine", "i am a robot") -> 7}
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfDifference(null, null) = -1
	 * StringUtils.indexOfDifference("", "") = -1
	 * StringUtils.indexOfDifference("", "abc") = 0
	 * StringUtils.indexOfDifference("abc", "") = 0
	 * StringUtils.indexOfDifference("abc", "abc") = -1
	 * StringUtils.indexOfDifference("ab", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "xyz") = 0
	 * </pre>
	 *
	 * @param cs1 the first CharSequence, may be null
	 * @param cs2 the second CharSequence, may be null
	 * @return the index where cs1 and cs2 begin to differ; -1 if they are equal
	 * @since 1.0
	 * @since 1.0 Changed signature from indexOfDifference(String, String) to
	 *        indexOfDifference(CharSequence, CharSequence)
	 */
	public static int indexOfDifference(final CharSequence cs1, final CharSequence cs2) {
		return StringUtils.indexOfDifference(cs1, cs2);
	}

	/**
	 * <p>
	 * Compares all CharSequences in an array and returns the index at which the
	 * CharSequences begin to differ.
	 * </p>
	 *
	 * <p>
	 * For example, {@code indexOfDifference(new String[] {"i am a machine", "i am a
	 * robot"}) -> 7}
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfDifference(null) = -1
	 * StringUtils.indexOfDifference(new String[] {}) = -1
	 * StringUtils.indexOfDifference(new String[] {"abc"}) = -1
	 * StringUtils.indexOfDifference(new String[] {null, null}) = -1
	 * StringUtils.indexOfDifference(new String[] {"", ""}) = -1
	 * StringUtils.indexOfDifference(new String[] {"", null}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", null, null}) = 0
	 * StringUtils.indexOfDifference(new String[] {null, null, "abc"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"", "abc"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", ""}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", "abc"}) = -1
	 * StringUtils.indexOfDifference(new String[] {"abc", "a"}) = 1
	 * StringUtils.indexOfDifference(new String[] {"ab", "abxyz"}) = 2
	 * StringUtils.indexOfDifference(new String[] {"abcde", "abxyz"}) = 2
	 * StringUtils.indexOfDifference(new String[] {"abcde", "xyz"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"xyz", "abcde"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"i am a machine", "i am a robot"}) = 7
	 * </pre>
	 *
	 * @param css array of CharSequences, entries may be null
	 * @return the index where the strings begin to differ; -1 if they are all equal
	 * @since 1.0
	 * @since 1.0 Changed signature from indexOfDifference(String...) to
	 *        indexOfDifference(CharSequence...)
	 */
	public static int indexOfDifference(final CharSequence... css) {
		return StringUtils.indexOfDifference(css);
	}

	/**
	 * <p>
	 * Compares all Strings in an array and returns the initial sequence of
	 * characters that is common to all of them.
	 * </p>
	 *
	 * <p>
	 * For example,
	 * <code>getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) -&gt; "i am a "</code>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getCommonPrefix(null) = ""
	 * StringUtils.getCommonPrefix(new String[] {}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc"}) = "abc"
	 * StringUtils.getCommonPrefix(new String[] {null, null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", ""}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", null, null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {null, null, "abc"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", "abc"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", ""}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", "abc"}) = "abc"
	 * StringUtils.getCommonPrefix(new String[] {"abc", "a"}) = "a"
	 * StringUtils.getCommonPrefix(new String[] {"ab", "abxyz"}) = "ab"
	 * StringUtils.getCommonPrefix(new String[] {"abcde", "abxyz"}) = "ab"
	 * StringUtils.getCommonPrefix(new String[] {"abcde", "xyz"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"xyz", "abcde"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) = "i am a "
	 * </pre>
	 *
	 * @param strs array of String objects, entries may be null
	 * @return the initial sequence of characters that are common to all Strings in
	 *         the array; empty String if the array is null, the elements are all
	 *         null or if there is no common prefix.
	 * @since 1.0
	 */
	public static String getCommonPrefix(final String... strs) {
		return StringUtils.getCommonPrefix(strs);
	}

	// Misc
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Find the Levenshtein distance between two Strings.
	 * </p>
	 *
	 * <p>
	 * This is the number of changes needed to change one String into another, where
	 * each change is a single character modification (deletion, insertion or
	 * substitution).
	 * </p>
	 *
	 * <p>
	 * The implementation uses a single-dimensional array of length s.length() + 1.
	 * See <a href=
	 * "http://blog.softwx.net/2014/12/optimizing-levenshtein-algorithm-in-c.html">
	 * http://blog.softwx.net/2014/12/optimizing-levenshtein-algorithm-in-c.html</a>
	 * for details.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getLevenshteinDistance(null, *)             = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, null)             = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance("", "")              = 0
	 * StringUtils.getLevenshteinDistance("", "a")             = 1
	 * StringUtils.getLevenshteinDistance("aaapppp", "")       = 7
	 * StringUtils.getLevenshteinDistance("frog", "fog")       = 1
	 * StringUtils.getLevenshteinDistance("fly", "ant")        = 3
	 * StringUtils.getLevenshteinDistance("elephant", "hippo") = 7
	 * StringUtils.getLevenshteinDistance("hippo", "elephant") = 7
	 * StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz") = 8
	 * StringUtils.getLevenshteinDistance("hello", "hallo")    = 1
	 * </pre>
	 *
	 * @param s the first String, must not be null
	 * @param t the second String, must not be null
	 * @return result distance
	 * @throws IllegalArgumentException if either String input {@code null}
	 * @since 1.0 Changed signature from getLevenshteinDistance(String, String) to
	 *        getLevenshteinDistance(CharSequence, CharSequence)
	 * @deprecated as of 3.6, use commons-text <a href=
	 *             "https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/LevenshteinDistance.html">
	 *             LevenshteinDistance</a> instead
	 */
	@Deprecated
	public static int getLevenshteinDistance(CharSequence s, CharSequence t) {
		return StringUtils.getLevenshteinDistance(s, t);
	}

	/**
	 * <p>
	 * Find the Levenshtein distance between two Strings if it's less than or equal
	 * to a given threshold.
	 * </p>
	 *
	 * <p>
	 * This is the number of changes needed to change one String into another, where
	 * each change is a single character modification (deletion, insertion or
	 * substitution).
	 * </p>
	 *
	 * <p>
	 * This implementation follows from Algorithms on Strings, Trees and Sequences
	 * by Dan Gusfield and Chas Emerick's implementation of the Levenshtein distance
	 * algorithm from <a href=
	 * "http://www.merriampark.com/ld.htm">http://www.merriampark.com/ld.htm</a>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getLevenshteinDistance(null, *, *)             = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, null, *)             = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, *, -1)               = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance("", "", 0)              = 0
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 8)       = 7
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 7)       = 7
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 6))      = -1
	 * StringUtils.getLevenshteinDistance("elephant", "hippo", 7) = 7
	 * StringUtils.getLevenshteinDistance("elephant", "hippo", 6) = -1
	 * StringUtils.getLevenshteinDistance("hippo", "elephant", 7) = 7
	 * StringUtils.getLevenshteinDistance("hippo", "elephant", 6) = -1
	 * </pre>
	 *
	 * @param s         the first String, must not be null
	 * @param t         the second String, must not be null
	 * @param threshold the target threshold, must not be negative
	 * @return result distance, or {@code -1} if the distance would be greater than
	 *         the threshold
	 * @throws IllegalArgumentException if either String input {@code null} or
	 *                                  negative threshold
	 * @deprecated as of 3.6, use commons-text <a href=
	 *             "https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/LevenshteinDistance.html">
	 *             LevenshteinDistance</a> instead
	 */
	@Deprecated
	public static int getLevenshteinDistance(CharSequence s, CharSequence t, final int threshold) {
		return StringUtils.getLevenshteinDistance(s, t, threshold);
	}

	/**
	 * <p>
	 * Find the Jaro Winkler Distance which indicates the similarity score between
	 * two Strings.
	 * </p>
	 *
	 * <p>
	 * The Jaro measure is the weighted sum of percentage of matched characters from
	 * each file and transposed characters. Winkler increased this measure for
	 * matching initial characters.
	 * </p>
	 *
	 * <p>
	 * This implementation is based on the Jaro Winkler similarity algorithm from
	 * <a href=
	 * "http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance">http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance</a>.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getJaroWinklerDistance(null, null)          = IllegalArgumentException
	 * StringUtils.getJaroWinklerDistance("", "")              = 0.0
	 * StringUtils.getJaroWinklerDistance("", "a")             = 0.0
	 * StringUtils.getJaroWinklerDistance("aaapppp", "")       = 0.0
	 * StringUtils.getJaroWinklerDistance("frog", "fog")       = 0.93
	 * StringUtils.getJaroWinklerDistance("fly", "ant")        = 0.0
	 * StringUtils.getJaroWinklerDistance("elephant", "hippo") = 0.44
	 * StringUtils.getJaroWinklerDistance("hippo", "elephant") = 0.44
	 * StringUtils.getJaroWinklerDistance("hippo", "zzzzzzzz") = 0.0
	 * StringUtils.getJaroWinklerDistance("hello", "hallo")    = 0.88
	 * StringUtils.getJaroWinklerDistance("ABC Corporation", "ABC Corp") = 0.93
	 * StringUtils.getJaroWinklerDistance("D N H Enterprises Inc", "D &amp; H Enterprises, Inc.") = 0.95
	 * StringUtils.getJaroWinklerDistance("My Gym Children's Fitness Center", "My Gym. Childrens Fitness") = 0.92
	 * StringUtils.getJaroWinklerDistance("PENNSYLVANIA", "PENNCISYLVNIA") = 0.88
	 * </pre>
	 *
	 * @param first  the first String, must not be null
	 * @param second the second String, must not be null
	 * @return result distance
	 * @throws IllegalArgumentException if either String input {@code null}
	 * @since 3.3
	 * @deprecated as of 3.6, use commons-text <a href=
	 *             "https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/JaroWinklerDistance.html">
	 *             JaroWinklerDistance</a> instead
	 */
	@Deprecated
	public static double getJaroWinklerDistance(final CharSequence first, final CharSequence second) {
		return StringUtils.getJaroWinklerDistance(first, second);
	}

	/**
	 * <p>
	 * Similar to <a href=
	 * "http://www.w3.org/TR/xpath/#function-normalize-space">http://www.w3.org/TR/xpath/#function-normalize
	 * -space</a>
	 * </p>
	 * <p>
	 * The function returns the argument string with whitespace normalized by using
	 * <code>{@link #trim(String)}</code> to remove leading and trailing whitespace
	 * and then replacing sequences of whitespace characters by a single space.
	 * </p>
	 * In XML Whitespace characters are the same as those allowed by the
	 * <a href="http://www.w3.org/TR/REC-xml/#NT-S">S</a> production, which is S ::=
	 * (#x20 | #x9 | #xD | #xA)+
	 * <p>
	 * Java's regexp pattern \s defines whitespace as [ \t\n\x0B\f\r]
	 *
	 * <p>
	 * For reference:
	 * </p>
	 * <ul>
	 * <li>\x0B = vertical tab</li>
	 * <li>\f = #xC = form feed</li>
	 * <li>#x20 = space</li>
	 * <li>#x9 = \t</li>
	 * <li>#xA = \n</li>
	 * <li>#xD = \r</li>
	 * </ul>
	 *
	 * <p>
	 * The difference is that Java's whitespace includes vertical tab and form feed,
	 * which this functional will also normalize. Additionally
	 * <code>{@link #trim(String)}</code> removes control characters (char &lt;= 32)
	 * from both ends of this String.
	 * </p>
	 *
	 * @see Pattern
	 * @see #trim(String)
	 * @see <a href=
	 *      "http://www.w3.org/TR/xpath/#function-normalize-space">http://www.w3.org/TR/xpath/#function-normalize-space</a>
	 * @param str the source String to normalize whitespaces from, may be null
	 * @return the modified string with whitespace normalized, {@code null} if null
	 *         String input
	 *
	 * @since 1.0
	 */
	public static String normalizeSpace(final String str) {
		return StringUtils.normalizeSpace(str);
	}

	/**
	 * Converts a <code>byte[]</code> to a String using the specified character
	 * encoding.
	 *
	 * @param bytes       the byte array to read from
	 * @param charsetName the encoding to use, if null then use the platform default
	 * @return a new String
	 * @throws UnsupportedEncodingException If the named charset is not supported
	 * @throws NullPointerException         if the input is null
	 * @deprecated use {@link StringUtils#toEncodedString(byte[], Charset)} instead
	 *             of String constants in your code
	 * @since 1.0
	 */
	@Deprecated
	public static String toString(final byte[] bytes, final String charsetName) throws UnsupportedEncodingException {
		return StringUtils.toString(bytes, charsetName);
	}

	/**
	 * Converts a <code>byte[]</code> to a String using the specified character
	 * encoding.
	 *
	 * @param bytes   the byte array to read from
	 * @param charset the encoding to use, if null then use the platform default
	 * @return a new String
	 * @throws NullPointerException if {@code bytes} is null
	 * @since 1.0
	 * @since 1.0 No longer throws {@link UnsupportedEncodingException}.
	 */
	public static String toEncodedString(final byte[] bytes, final Charset charset) {
		return StringUtils.toEncodedString(bytes, charset);
	}

	/**
	 * <p>
	 * Wraps a string with a char.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrap(null, *)        = null
	 * StringUtils.wrap("", *)          = ""
	 * StringUtils.wrap("ab", '\0')     = "ab"
	 * StringUtils.wrap("ab", 'x')      = "xabx"
	 * StringUtils.wrap("ab", '\'')     = "'ab'"
	 * StringUtils.wrap("\"ab\"", '\"') = "\"\"ab\"\""
	 * </pre>
	 *
	 * @param str      the string to be wrapped, may be {@code null}
	 * @param wrapWith the char that will wrap {@code str}
	 * @return the wrapped string, or {@code null} if {@code str==null}
	 * @since 1.0
	 */
	public static String wrap(final String str, final char wrapWith) {
		return StringUtils.wrap(str, wrapWith);
	}

	/**
	 * <p>
	 * Wraps a String with another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrap(null, *)         = null
	 * StringUtils.wrap("", *)           = ""
	 * StringUtils.wrap("ab", null)      = "ab"
	 * StringUtils.wrap("ab", "x")       = "xabx"
	 * StringUtils.wrap("ab", "\"")      = "\"ab\""
	 * StringUtils.wrap("\"ab\"", "\"")  = "\"\"ab\"\""
	 * StringUtils.wrap("ab", "'")       = "'ab'"
	 * StringUtils.wrap("'abcd'", "'")   = "''abcd''"
	 * StringUtils.wrap("\"abcd\"", "'") = "'\"abcd\"'"
	 * StringUtils.wrap("'abcd'", "\"")  = "\"'abcd'\""
	 * </pre>
	 *
	 * @param str      the String to be wrapper, may be null
	 * @param wrapWith the String that will wrap str
	 * @return wrapped String, {@code null} if null String input
	 * @since 1.0
	 */
	public static String wrap(final String str, final String wrapWith) {
		return StringUtils.wrap(str, wrapWith);
	}

	/**
	 * <p>
	 * Wraps a string with a char if that char is missing from the start or end of
	 * the given string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrapIfMissing(null, *)        = null
	 * StringUtils.wrapIfMissing("", *)          = ""
	 * StringUtils.wrapIfMissing("ab", '\0')     = "ab"
	 * StringUtils.wrapIfMissing("ab", 'x')      = "xabx"
	 * StringUtils.wrapIfMissing("ab", '\'')     = "'ab'"
	 * StringUtils.wrapIfMissing("\"ab\"", '\"') = "\"ab\""
	 * StringUtils.wrapIfMissing("/", '/')  = "/"
	 * StringUtils.wrapIfMissing("a/b/c", '/')  = "/a/b/c/"
	 * StringUtils.wrapIfMissing("/a/b/c", '/')  = "/a/b/c/"
	 * StringUtils.wrapIfMissing("a/b/c/", '/')  = "/a/b/c/"
	 * </pre>
	 *
	 * @param str      the string to be wrapped, may be {@code null}
	 * @param wrapWith the char that will wrap {@code str}
	 * @return the wrapped string, or {@code null} if {@code str==null}
	 * @since 1.0
	 */
	public static String wrapIfMissing(final String str, final char wrapWith) {
		return StringUtils.wrapIfMissing(str, wrapWith);
	}

	/**
	 * <p>
	 * Wraps a string with a string if that string is missing from the start or end
	 * of the given string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrapIfMissing(null, *)         = null
	 * StringUtils.wrapIfMissing("", *)           = ""
	 * StringUtils.wrapIfMissing("ab", null)      = "ab"
	 * StringUtils.wrapIfMissing("ab", "x")       = "xabx"
	 * StringUtils.wrapIfMissing("ab", "\"")      = "\"ab\""
	 * StringUtils.wrapIfMissing("\"ab\"", "\"")  = "\"ab\""
	 * StringUtils.wrapIfMissing("ab", "'")       = "'ab'"
	 * StringUtils.wrapIfMissing("'abcd'", "'")   = "'abcd'"
	 * StringUtils.wrapIfMissing("\"abcd\"", "'") = "'\"abcd\"'"
	 * StringUtils.wrapIfMissing("'abcd'", "\"")  = "\"'abcd'\""
	 * StringUtils.wrapIfMissing("/", "/")  = "/"
	 * StringUtils.wrapIfMissing("a/b/c", "/")  = "/a/b/c/"
	 * StringUtils.wrapIfMissing("/a/b/c", "/")  = "/a/b/c/"
	 * StringUtils.wrapIfMissing("a/b/c/", "/")  = "/a/b/c/"
	 * </pre>
	 *
	 * @param str      the string to be wrapped, may be {@code null}
	 * @param wrapWith the char that will wrap {@code str}
	 * @return the wrapped string, or {@code null} if {@code str==null}
	 * @since 1.0
	 */
	public static String wrapIfMissing(final String str, final String wrapWith) {
		return StringUtils.wrapIfMissing(str, wrapWith);
	}

	/**
	 * <p>
	 * Unwraps a given string from a character.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.unwrap(null, null)         = null
	 * StringUtils.unwrap(null, '\0')         = null
	 * StringUtils.unwrap(null, '1')          = null
	 * StringUtils.unwrap("\'abc\'", '\'')    = "abc"
	 * StringUtils.unwrap("AABabcBAA", 'A')  = "ABabcBA"
	 * StringUtils.unwrap("A", '#')           = "A"
	 * StringUtils.unwrap("#A", '#')          = "#A"
	 * StringUtils.unwrap("A#", '#')          = "A#"
	 * </pre>
	 *
	 * @param str      the String to be unwrapped, can be null
	 * @param wrapChar the character used to unwrap
	 * @return unwrapped String or the original string if it is not quoted properly
	 *         with the wrapChar
	 * @since 1.0
	 */
	public static String unwrap(final String str, final char wrapChar) {
		return StringUtils.unwrap(str, wrapChar);
	}

	/**
	 * <p>
	 * Converts a {@code CharSequence} into an array of code points.
	 * </p>
	 *
	 * <p>
	 * Valid pairs of surrogate code units will be converted into a single
	 * supplementary code point. Isolated surrogate code units (i.e. a high
	 * surrogate not followed by a low surrogate or a low surrogate not preceded by
	 * a high surrogate) will be returned as-is.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.toCodePoints(null)   =  null
	 * StringUtils.toCodePoints("")     =  []  // empty array
	 * </pre>
	 *
	 * @param str the character sequence to convert
	 * @return an array of code points
	 * @since 1.0
	 */
	public static int[] toCodePoints(final CharSequence str) {
		return StringUtils.toCodePoints(str);
	}

	/**
	 * Returns the string representation of the {@code char} array or null.
	 *
	 * @param value the character array.
	 * @return a String or null
	 * @see String#valueOf(char[])
	 * @since 1.0
	 */
	public static String valueOf(final char[] value) {
		return StringUtils.valueOf(value);
	}

	public static boolean isCaptalLetter(String value) {
		// TODO Auto-generated method stub
		return false;
	}

}
