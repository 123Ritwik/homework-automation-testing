package com.threeylos.core.util.common;

import java.math.BigDecimal;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * <p>
 * Provides extra functionality for Java Number classes.
 * </p>
 *
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class NumberUtil {

	/**
	 * <p>
	 * <code>NumberUtils</code> instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * <code>NumberUtils.toInt("6");</code>.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	private NumberUtil() {

	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Convert a <code>String</code> to an <code>int</code>, returning
	 * <code>zero</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string is <code>null</code>, <code>zero</code> is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toInt(null) = 0
	 *   NumberUtils.toInt("")   = 0
	 *   NumberUtils.toInt("1")  = 1
	 * </pre>
	 *
	 * @param str the string to convert, may be null
	 * @return the int represented by the string, or <code>zero</code> if conversion
	 *         fails
	 * @since 2.1
	 */
	public static int toInt(final String str) {
		return NumberUtils.toInt(str);
	}

	/**
	 * <p>
	 * Convert a <code>String</code> to a <code>long</code>, returning
	 * <code>zero</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string is <code>null</code>, <code>zero</code> is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toLong(null) = 0L
	 *   NumberUtils.toLong("")   = 0L
	 *   NumberUtils.toLong("1")  = 1L
	 * </pre>
	 *
	 * @param str the string to convert, may be null
	 * @return the long represented by the string, or <code>0</code> if conversion
	 *         fails
	 * @since 2.1
	 */
	public static long toLong(final String str) {
		return NumberUtils.toLong(str);
	}

	/**
	 * <p>
	 * Convert a <code>String</code> to a <code>float</code>, returning
	 * <code>0.0f</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string <code>str</code> is <code>null</code>, <code>0.0f</code> is
	 * returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toFloat(null)   = 0.0f
	 *   NumberUtils.toFloat("")     = 0.0f
	 *   NumberUtils.toFloat("1.5")  = 1.5f
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @return the float represented by the string, or <code>0.0f</code> if
	 *         conversion fails
	 * @since 2.1
	 */
	public static float toFloat(final String str) {
		return NumberUtils.toFloat(str);
	}

	/**
	 * <p>
	 * Convert a <code>String</code> to a <code>double</code>, returning
	 * <code>0.0d</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string <code>str</code> is <code>null</code>, <code>0.0d</code> is
	 * returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toDouble(null)   = 0.0d
	 *   NumberUtils.toDouble("")     = 0.0d
	 *   NumberUtils.toDouble("1.5")  = 1.5d
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @return the double represented by the string, or <code>0.0d</code> if
	 *         conversion fails
	 * @since 2.1
	 */
	public static double toDouble(final String str) {
		return NumberUtils.toDouble(str);
	}

	/**
	 * <p>
	 * Convert a <code>BigDecimal</code> to a <code>double</code>.
	 * </p>
	 *
	 * <p>
	 * If the <code>BigDecimal</code> <code>value</code> is <code>null</code>, then
	 * the specified default value is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toDouble(null)                     = 0.0d
	 *   NumberUtils.toDouble(BigDecimal.valudOf(8.5d)) = 8.5d
	 * </pre>
	 *
	 * @param value the <code>BigDecimal</code> to convert, may be
	 *              <code>null</code>.
	 * @return the double represented by the <code>BigDecimal</code> or
	 *         <code>0.0d</code> if the <code>BigDecimal</code> is
	 *         <code>null</code>.
	 * @since 3.8
	 */
	public static double toDouble(final BigDecimal value) {
		return NumberUtils.toDouble(value);
	}

	/**
	 * <p>
	 * Convert a <code>BigDecimal</code> to a <code>double</code>.
	 * </p>
	 *
	 * <p>
	 * If the <code>BigDecimal</code> <code>value</code> is <code>null</code>, then
	 * the specified default value is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toDouble(null, 1.1d)                     = 1.1d
	 *   NumberUtils.toDouble(BigDecimal.valudOf(8.5d), 1.1d) = 8.5d
	 * </pre>
	 *
	 * @param value        the <code>BigDecimal</code> to convert, may be
	 *                     <code>null</code>.
	 * @param defaultValue the default value
	 * @return the double represented by the <code>BigDecimal</code> or the
	 *         defaultValue if the <code>BigDecimal</code> is <code>null</code>.
	 * @since 3.8
	 */
	public static double toDouble(final BigDecimal value, final double defaultValue) {
		return NumberUtils.toDouble(value, defaultValue);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Convert a <code>String</code> to a <code>byte</code>, returning
	 * <code>zero</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string is <code>null</code>, <code>zero</code> is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toByte(null) = 0
	 *   NumberUtils.toByte("")   = 0
	 *   NumberUtils.toByte("1")  = 1
	 * </pre>
	 *
	 * @param str the string to convert, may be null
	 * @return the byte represented by the string, or <code>zero</code> if
	 *         conversion fails
	 * @since 2.5
	 */
	public static byte toByte(final String str) {
		return NumberUtils.toByte(str);
	}

	/**
	 * <p>
	 * Convert a <code>String</code> to a <code>short</code>, returning
	 * <code>zero</code> if the conversion fails.
	 * </p>
	 *
	 * <p>
	 * If the string is <code>null</code>, <code>zero</code> is returned.
	 * </p>
	 *
	 * <pre>
	 *   NumberUtils.toShort(null) = 0
	 *   NumberUtils.toShort("")   = 0
	 *   NumberUtils.toShort("1")  = 1
	 * </pre>
	 *
	 * @param str the string to convert, may be null
	 * @return the short represented by the string, or <code>zero</code> if
	 *         conversion fails
	 * @since 2.5
	 */
	public static short toShort(final String str) {
		return NumberUtils.toShort(str);
	}

	/**
	 * Convert a <code>BigDecimal</code> to a <code>BigDecimal</code> with a scale
	 * of two that has been rounded using <code>RoundingMode.HALF_EVEN</code>. If
	 * the supplied <code>value</code> is null, then <code>BigDecimal.ZERO</code> is
	 * returned.
	 *
	 * <p>
	 * Note, the scale of a <code>BigDecimal</code> is the number of digits to the
	 * right of the decimal point.
	 * </p>
	 *
	 * @param value the <code>BigDecimal</code> to convert, may be null.
	 * @return the scaled, with appropriate rounding, <code>BigDecimal</code>.
	 * @since 3.8
	 */
	public static BigDecimal toScaledBigDecimal(final BigDecimal value) {
		return NumberUtils.toScaledBigDecimal(value);
	}

	/**
	 * Convert a <code>Float</code> to a <code>BigDecimal</code> with a scale of two
	 * that has been rounded using <code>RoundingMode.HALF_EVEN</code>. If the
	 * supplied <code>value</code> is null, then <code>BigDecimal.ZERO</code> is
	 * returned.
	 *
	 * <p>
	 * Note, the scale of a <code>BigDecimal</code> is the number of digits to the
	 * right of the decimal point.
	 * </p>
	 *
	 * @param value the <code>Float</code> to convert, may be null.
	 * @return the scaled, with appropriate rounding, <code>BigDecimal</code>.
	 * @since 3.8
	 */
	public static BigDecimal toScaledBigDecimal(final Float value) {
		return NumberUtils.toScaledBigDecimal(value);
	}

	/**
	 * Convert a <code>Double</code> to a <code>BigDecimal</code> with a scale of
	 * two that has been rounded using <code>RoundingMode.HALF_EVEN</code>. If the
	 * supplied <code>value</code> is null, then <code>BigDecimal.ZERO</code> is
	 * returned.
	 *
	 * <p>
	 * Note, the scale of a <code>BigDecimal</code> is the number of digits to the
	 * right of the decimal point.
	 * </p>
	 *
	 * @param value the <code>Double</code> to convert, may be null.
	 * @return the scaled, with appropriate rounding, <code>BigDecimal</code>.
	 * @since 3.8
	 */
	public static BigDecimal toScaledBigDecimal(final Double value) {
		return NumberUtils.toScaledBigDecimal(value);
	}

	/**
	 * Convert a <code>String</code> to a <code>BigDecimal</code> with a scale of
	 * two that has been rounded using <code>RoundingMode.HALF_EVEN</code>. If the
	 * supplied <code>value</code> is null, then <code>BigDecimal.ZERO</code> is
	 * returned.
	 *
	 * <p>
	 * Note, the scale of a <code>BigDecimal</code> is the number of digits to the
	 * right of the decimal point.
	 * </p>
	 *
	 * @param value the <code>String</code> to convert, may be null.
	 * @return the scaled, with appropriate rounding, <code>BigDecimal</code>.
	 * @since 3.8
	 */
	public static BigDecimal toScaledBigDecimal(final String value) {
		return NumberUtils.toScaledBigDecimal(value);
	}

	/**
	 * <p>
	 * Gets the maximum of three <code>double</code> values.
	 * </p>
	 *
	 * <p>
	 * If any value is <code>NaN</code>, <code>NaN</code> is returned. Infinity is
	 * handled.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the largest of the values
	 * @see IEEE754rUtils#max(double, double, double) for a version of this method
	 *      that handles NaN differently
	 */
	public static double max(final double a, final double b, final double c) {
		return NumberUtils.max(a, b, c);
	}

	/**
	 * <p>
	 * Gets the maximum of three <code>float</code> values.
	 * </p>
	 *
	 * <p>
	 * If any value is <code>NaN</code>, <code>NaN</code> is returned. Infinity is
	 * handled.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the largest of the values
	 * @see IEEE754rUtils#max(float, float, float) for a version of this method that
	 *      handles NaN differently
	 */
	public static float max(final float a, final float b, final float c) {
		return NumberUtils.max(a, b, c);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks whether the <code>String</code> contains only digit characters.
	 * </p>
	 *
	 * <p>
	 * <code>Null</code> and empty String will return <code>false</code>.
	 * </p>
	 *
	 * @param str the <code>String</code> to check
	 * @return <code>true</code> if str contains only Unicode numeric
	 */
	public static boolean isDigits(final String str) {
		return NumberUtils.isDigits(str);
	}

	/**
	 * <p>
	 * Checks whether the String a valid Java number.
	 * </p>
	 *
	 * <p>
	 * Valid numbers include hexadecimal marked with the <code>0x</code> or
	 * <code>0X</code> qualifier, octal numbers, scientific notation and numbers
	 * marked with a type qualifier (e.g. 123L).
	 * </p>
	 *
	 * <p>
	 * Non-hexadecimal strings beginning with a leading zero are treated as octal
	 * values. Thus the string <code>09</code> will return <code>false</code>, since
	 * <code>9</code> is not a valid octal value. However, numbers beginning with
	 * {@code 0.} are treated as decimal.
	 * </p>
	 *
	 * <p>
	 * <code>null</code> and empty/blank {@code String} will return
	 * <code>false</code>.
	 * </p>
	 *
	 * <p>
	 * Note, {@link #createNumber(String)} should return a number for every input
	 * resulting in <code>true</code>.
	 * </p>
	 *
	 * @param str the <code>String</code> to check
	 * @return <code>true</code> if the string is a correctly formatted number
	 * @since 3.3 the code supports hex {@code 0Xhhh} an octal {@code 0ddd}
	 *        validation
	 * @deprecated This feature will be removed in Lang 4.0, use
	 *             {@link NumberUtils#isCreatable(String)} instead
	 */
	@Deprecated
	public static boolean isNumber(final String str) {
		return NumberUtils.isNumber(str);
	}

}
