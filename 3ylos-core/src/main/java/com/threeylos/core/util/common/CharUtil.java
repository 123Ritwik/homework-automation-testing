package com.threeylos.core.util.common;

import org.apache.commons.lang3.CharUtils;

/**
 * <p>
 * Operations on char primitives and Character objects.
 * </p>
 *
 * <p>
 * This class tries to handle {@code null} input gracefully. An exception will
 * not be thrown for a {@code null} input. Each method documents its behaviour
 * in more detail.
 * </p>
 *
 * <p>
 * #ThreadSafe#
 * </p>
 * 
 * @since 1.0
 * 
 * @author AbhinitKumar
 * 
 */
public class CharUtil {

	/**
	 * <p>
	 * {@code CharUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code CharUtils.toString('c');}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public CharUtil() {
		super();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the character to a Character.
	 * </p>
	 *
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * Character object each time.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toCharacterObject(' ')  = ' '
	 *   CharUtils.toCharacterObject('A')  = 'A'
	 * </pre>
	 *
	 * @deprecated Java 5 introduced {@link Character#valueOf(char)} which caches
	 *             chars 0 through 127.
	 * @param ch the character to convert
	 * @return a Character of the specified character
	 */
	@Deprecated
	public static Character toCharacterObject(final char ch) {
		return CharUtils.toCharacterObject(ch);
	}

	/**
	 * <p>
	 * Converts the String to a Character using the first character, returning null
	 * for empty Strings.
	 * </p>
	 *
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * Character object each time.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toCharacterObject(null) = null
	 *   CharUtils.toCharacterObject("")   = null
	 *   CharUtils.toCharacterObject("A")  = 'A'
	 *   CharUtils.toCharacterObject("BA") = 'B'
	 * </pre>
	 *
	 * @param str the character to convert
	 * @return the Character value of the first letter of the String
	 */
	public static Character toCharacterObject(final String str) {
		return CharUtils.toCharacterObject(str);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the Character to a char throwing an exception for {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toChar(' ')  = ' '
	 *   CharUtils.toChar('A')  = 'A'
	 *   CharUtils.toChar(null) throws IllegalArgumentException
	 * </pre>
	 *
	 * @param ch the character to convert
	 * @return the char value of the Character
	 * @throws IllegalArgumentException if the Character is null
	 */
	public static char toChar(final Character ch) {
		return CharUtils.toChar(ch);
	}

	/**
	 * <p>
	 * Converts the Character to a char handling {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toChar(null, 'X') = 'X'
	 *   CharUtils.toChar(' ', 'X')  = ' '
	 *   CharUtils.toChar('A', 'X')  = 'A'
	 * </pre>
	 *
	 * @param ch           the character to convert
	 * @param defaultValue the value to use if the Character is null
	 * @return the char value of the Character or the default if null
	 */
	public static char toChar(final Character ch, final char defaultValue) {
		return CharUtils.toChar(ch, defaultValue);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the String to a char using the first character, throwing an
	 * exception on empty Strings.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toChar("A")  = 'A'
	 *   CharUtils.toChar("BA") = 'B'
	 *   CharUtils.toChar(null) throws IllegalArgumentException
	 *   CharUtils.toChar("")   throws IllegalArgumentException
	 * </pre>
	 *
	 * @param str the character to convert
	 * @return the char value of the first letter of the String
	 * @throws IllegalArgumentException if the String is empty
	 */
	public static char toChar(final String str) {
		return CharUtils.toChar(str);
	}

	/**
	 * <p>
	 * Converts the String to a char using the first character, defaulting the value
	 * on empty Strings.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toChar(null, 'X') = 'X'
	 *   CharUtils.toChar("", 'X')   = 'X'
	 *   CharUtils.toChar("A", 'X')  = 'A'
	 *   CharUtils.toChar("BA", 'X') = 'B'
	 * </pre>
	 *
	 * @param str          the character to convert
	 * @param defaultValue the value to use if the Character is null
	 * @return the char value of the first letter of the String or the default if
	 *         null
	 */
	public static char toChar(final String str, final char defaultValue) {
		return CharUtils.toChar(str, defaultValue);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an exception if
	 * the character is not numeric.
	 * </p>
	 *
	 * <p>
	 * This method converts the char '1' to the int 1 and so on.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toIntValue('3')  = 3
	 *   CharUtils.toIntValue('A')  throws IllegalArgumentException
	 * </pre>
	 *
	 * @param ch the character to convert
	 * @return the int value of the character
	 * @throws IllegalArgumentException if the character is not ASCII numeric
	 */
	public static int toIntValue(final char ch) {
		return CharUtils.toIntValue(ch);
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an exception if
	 * the character is not numeric.
	 * </p>
	 *
	 * <p>
	 * This method converts the char '1' to the int 1 and so on.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toIntValue('3', -1)  = 3
	 *   CharUtils.toIntValue('A', -1)  = -1
	 * </pre>
	 *
	 * @param ch           the character to convert
	 * @param defaultValue the default value to use if the character is not numeric
	 * @return the int value of the character
	 */
	public static int toIntValue(final char ch, final int defaultValue) {
		return CharUtils.toIntValue(ch, defaultValue);
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an exception if
	 * the character is not numeric.
	 * </p>
	 *
	 * <p>
	 * This method converts the char '1' to the int 1 and so on.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toIntValue('3')  = 3
	 *   CharUtils.toIntValue(null) throws IllegalArgumentException
	 *   CharUtils.toIntValue('A')  throws IllegalArgumentException
	 * </pre>
	 *
	 * @param ch the character to convert, not null
	 * @return the int value of the character
	 * @throws IllegalArgumentException if the Character is not ASCII numeric or is
	 *                                  null
	 */
	public static int toIntValue(final Character ch) {
		return CharUtils.toIntValue(ch);
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an exception if
	 * the character is not numeric.
	 * </p>
	 *
	 * <p>
	 * This method converts the char '1' to the int 1 and so on.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toIntValue(null, -1) = -1
	 *   CharUtils.toIntValue('3', -1)  = 3
	 *   CharUtils.toIntValue('A', -1)  = -1
	 * </pre>
	 *
	 * @param ch           the character to convert
	 * @param defaultValue the default value to use if the character is not numeric
	 * @return the int value of the character
	 */
	public static int toIntValue(final Character ch, final int defaultValue) {
		return CharUtils.toIntValue(ch, defaultValue);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the character to a String that contains the one character.
	 * </p>
	 *
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * String object each time.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toString(' ')  = " "
	 *   CharUtils.toString('A')  = "A"
	 * </pre>
	 *
	 * @param ch the character to convert
	 * @return a String containing the one specified character
	 */
	public static String toString(final char ch) {
		return CharUtils.toString(ch);
	}

	/**
	 * <p>
	 * Converts the character to a String that contains the one character.
	 * </p>
	 *
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * String object each time.
	 * </p>
	 *
	 * <p>
	 * If {@code null} is passed in, {@code null} will be returned.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.toString(null) = null
	 *   CharUtils.toString(' ')  = " "
	 *   CharUtils.toString('A')  = "A"
	 * </pre>
	 *
	 * @param ch the character to convert
	 * @return a String containing the one specified character
	 */
	public static String toString(final Character ch) {
		return CharUtils.toString(ch);
	}

	// --------------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the string to the Unicode format '\u0020'.
	 * </p>
	 *
	 * <p>
	 * This format is the Java source code format.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.unicodeEscaped(' ') = "\u0020"
	 *   CharUtils.unicodeEscaped('A') = "\u0041"
	 * </pre>
	 *
	 * @param ch the character to convert
	 * @return the escaped Unicode string
	 */
	public static String unicodeEscaped(final char ch) {
		return CharUtils.unicodeEscaped(ch);
	}

	/**
	 * <p>
	 * Converts the string to the Unicode format '\u0020'.
	 * </p>
	 *
	 * <p>
	 * This format is the Java source code format.
	 * </p>
	 *
	 * <p>
	 * If {@code null} is passed in, {@code null} will be returned.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.unicodeEscaped(null) = null
	 *   CharUtils.unicodeEscaped(' ')  = "\u0020"
	 *   CharUtils.unicodeEscaped('A')  = "\u0041"
	 * </pre>
	 *
	 * @param ch the character to convert, may be null
	 * @return the escaped Unicode string, null if null input
	 */
	public static String unicodeEscaped(final Character ch) {
		return CharUtils.unicodeEscaped(ch);
	}

	// --------------------------------------------------------------------------
	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAscii('a')  = true
	 *   CharUtils.isAscii('A')  = true
	 *   CharUtils.isAscii('3')  = true
	 *   CharUtils.isAscii('-')  = true
	 *   CharUtils.isAscii('\n') = true
	 *   CharUtils.isAscii('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if less than 128
	 */
	public static boolean isAscii(final char ch) {
		return CharUtils.isAscii(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit printable.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiPrintable('a')  = true
	 *   CharUtils.isAsciiPrintable('A')  = true
	 *   CharUtils.isAsciiPrintable('3')  = true
	 *   CharUtils.isAsciiPrintable('-')  = true
	 *   CharUtils.isAsciiPrintable('\n') = false
	 *   CharUtils.isAsciiPrintable('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 32 and 126 inclusive
	 */
	public static boolean isAsciiPrintable(final char ch) {
		return CharUtils.isAsciiPrintable(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit control.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiControl('a')  = false
	 *   CharUtils.isAsciiControl('A')  = false
	 *   CharUtils.isAsciiControl('3')  = false
	 *   CharUtils.isAsciiControl('-')  = false
	 *   CharUtils.isAsciiControl('\n') = true
	 *   CharUtils.isAsciiControl('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if less than 32 or equals 127
	 */
	public static boolean isAsciiControl(final char ch) {
		return CharUtils.isAsciiControl(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit alphabetic.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiAlpha('a')  = true
	 *   CharUtils.isAsciiAlpha('A')  = true
	 *   CharUtils.isAsciiAlpha('3')  = false
	 *   CharUtils.isAsciiAlpha('-')  = false
	 *   CharUtils.isAsciiAlpha('\n') = false
	 *   CharUtils.isAsciiAlpha('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 65 and 90 or 97 and 122 inclusive
	 */
	public static boolean isAsciiAlpha(final char ch) {
		return CharUtils.isAsciiAlpha(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit alphabetic upper case.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiAlphaUpper('a')  = false
	 *   CharUtils.isAsciiAlphaUpper('A')  = true
	 *   CharUtils.isAsciiAlphaUpper('3')  = false
	 *   CharUtils.isAsciiAlphaUpper('-')  = false
	 *   CharUtils.isAsciiAlphaUpper('\n') = false
	 *   CharUtils.isAsciiAlphaUpper('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 65 and 90 inclusive
	 */
	public static boolean isAsciiAlphaUpper(final char ch) {
		return CharUtils.isAsciiAlphaUpper(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit alphabetic lower case.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiAlphaLower('a')  = true
	 *   CharUtils.isAsciiAlphaLower('A')  = false
	 *   CharUtils.isAsciiAlphaLower('3')  = false
	 *   CharUtils.isAsciiAlphaLower('-')  = false
	 *   CharUtils.isAsciiAlphaLower('\n') = false
	 *   CharUtils.isAsciiAlphaLower('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 97 and 122 inclusive
	 */
	public static boolean isAsciiAlphaLower(final char ch) {
		return CharUtils.isAsciiAlphaLower(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit numeric.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiNumeric('a')  = false
	 *   CharUtils.isAsciiNumeric('A')  = false
	 *   CharUtils.isAsciiNumeric('3')  = true
	 *   CharUtils.isAsciiNumeric('-')  = false
	 *   CharUtils.isAsciiNumeric('\n') = false
	 *   CharUtils.isAsciiNumeric('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 48 and 57 inclusive
	 */
	public static boolean isAsciiNumeric(final char ch) {
		return CharUtils.isAsciiNumeric(ch);
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit numeric.
	 * </p>
	 *
	 * <pre>
	 *   CharUtils.isAsciiAlphanumeric('a')  = true
	 *   CharUtils.isAsciiAlphanumeric('A')  = true
	 *   CharUtils.isAsciiAlphanumeric('3')  = true
	 *   CharUtils.isAsciiAlphanumeric('-')  = false
	 *   CharUtils.isAsciiAlphanumeric('\n') = false
	 *   CharUtils.isAsciiAlphanumeric('&copy;') = false
	 * </pre>
	 *
	 * @param ch the character to check
	 * @return true if between 48 and 57 or 65 and 90 or 97 and 122 inclusive
	 */
	public static boolean isAsciiAlphanumeric(final char ch) {
		return CharUtils.isAsciiAlphanumeric(ch);
	}

	/**
	 * <p>
	 * Compares two {@code char} values numerically. This is the same functionality
	 * as provided in Java 7.
	 * </p>
	 *
	 * @param x the first {@code char} to compare
	 * @param y the second {@code char} to compare
	 * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if
	 *         {@code x < y}; and a value greater than {@code 0} if {@code x > y}
	 * @since 1.0
	 */
	public static int compare(final char x, final char y) {
		return CharUtils.compare(x, y);
	}

}
