package com.threeylos.core.util.common;

import org.apache.commons.lang3.BooleanUtils;

/**
 * <p>
 * Operations on boolean primitives and Boolean objects.
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
 */
public class BooleanUtil {

	/**
	 * <p>
	 * {@code BooleanUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code BooleanUtils.negate(true);}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public BooleanUtil() {
		super();
	}

	// Boolean utilities
	// --------------------------------------------------------------------------
	/**
	 * <p>
	 * Negates the specified boolean.
	 * </p>
	 *
	 * <p>
	 * If {@code null} is passed in, {@code null} will be returned.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 * BooleanUtils.negate(Boolean.TRUE) = Boolean.FALSE;
	 * BooleanUtils.negate(Boolean.FALSE) = Boolean.TRUE;
	 * BooleanUtils.negate(null) = null;
	 * </pre>
	 *
	 * @param bool the Boolean to negate, may be null
	 * @return the negated Boolean, or {@code null} if {@code null} input
	 */
	public static Boolean negate(final Boolean bool) {
		return BooleanUtils.negate(bool);
	}

	// boolean Boolean methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if a {@code Boolean} value is {@code true}, handling {@code null} by
	 * returning {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.isTrue(Boolean.TRUE)  = true
	 *   BooleanUtils.isTrue(Boolean.FALSE) = false
	 *   BooleanUtils.isTrue(null)          = false
	 * </pre>
	 *
	 * @param bool the boolean to check, null returns {@code false}
	 * @return {@code true} only if the input is non-null and true
	 * @since 1.0
	 */
	public static boolean isTrue(final Boolean bool) {
		return BooleanUtils.isTrue(bool);
	}

	/**
	 * <p>
	 * Checks if a {@code Boolean} value is <i>not</i> {@code true}, handling
	 * {@code null} by returning {@code true}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.isNotTrue(Boolean.TRUE)  = false
	 *   BooleanUtils.isNotTrue(Boolean.FALSE) = true
	 *   BooleanUtils.isNotTrue(null)          = true
	 * </pre>
	 *
	 * @param bool the boolean to check, null returns {@code true}
	 * @return {@code true} if the input is null or false
	 * @since 1.0
	 */
	public static boolean isNotTrue(final Boolean bool) {
		return BooleanUtils.isNotTrue(bool);
	}

	/**
	 * <p>
	 * Checks if a {@code Boolean} value is {@code false}, handling {@code null} by
	 * returning {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.isFalse(Boolean.TRUE)  = false
	 *   BooleanUtils.isFalse(Boolean.FALSE) = true
	 *   BooleanUtils.isFalse(null)          = false
	 * </pre>
	 *
	 * @param bool the boolean to check, null returns {@code false}
	 * @return {@code true} only if the input is non-null and false
	 * @since 1.0
	 */
	public static boolean isFalse(final Boolean bool) {
		return BooleanUtils.isFalse(bool);
	}

	/**
	 * <p>
	 * Checks if a {@code Boolean} value is <i>not</i> {@code false}, handling
	 * {@code null} by returning {@code true}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.isNotFalse(Boolean.TRUE)  = true
	 *   BooleanUtils.isNotFalse(Boolean.FALSE) = false
	 *   BooleanUtils.isNotFalse(null)          = true
	 * </pre>
	 *
	 * @param bool the boolean to check, null returns {@code true}
	 * @return {@code true} if the input is null or true
	 * @since 1.0
	 */
	public static boolean isNotFalse(final Boolean bool) {
		return BooleanUtils.isNotFalse(bool);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a Boolean to a boolean handling {@code null} by returning
	 * {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(Boolean.TRUE)  = true
	 *   BooleanUtils.toBoolean(Boolean.FALSE) = false
	 *   BooleanUtils.toBoolean(null)          = false
	 * </pre>
	 *
	 * @param bool the boolean to convert
	 * @return {@code true} or {@code false}, {@code null} returns {@code false}
	 */
	public static boolean toBoolean(final Boolean bool) {
		return BooleanUtils.toBoolean(bool);
	}

	/**
	 * <p>
	 * Converts a Boolean to a boolean handling {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false) = true
	 *   BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true) = false
	 *   BooleanUtils.toBooleanDefaultIfNull(null, true)          = true
	 * </pre>
	 *
	 * @param bool        the boolean to convert
	 * @param valueIfNull the boolean value to return if {@code null}
	 * @return {@code true} or {@code false}
	 */
	public static boolean toBooleanDefaultIfNull(final Boolean bool, final boolean valueIfNull) {
		return BooleanUtils.toBooleanDefaultIfNull(bool, valueIfNull);
	}

	// Integer to Boolean methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an int to a boolean using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(0) = false
	 *   BooleanUtils.toBoolean(1) = true
	 *   BooleanUtils.toBoolean(2) = true
	 * </pre>
	 *
	 * @param value the int to convert
	 * @return {@code true} if non-zero, {@code false} if zero
	 */
	public static boolean toBoolean(final int value) {
		return BooleanUtils.toBoolean(value);
	}

	/**
	 * <p>
	 * Converts an int to a Boolean using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(0) = Boolean.FALSE
	 *   BooleanUtils.toBoolean(1) = Boolean.TRUE
	 *   BooleanUtils.toBoolean(2) = Boolean.TRUE
	 * </pre>
	 *
	 * @param value the int to convert
	 * @return Boolean.TRUE if non-zero, Boolean.FALSE if zero, {@code null} if
	 *         {@code null}
	 */
	public static Boolean toBooleanObject(final int value) {
		return BooleanUtils.toBooleanObject(value);
	}

	/**
	 * <p>
	 * Converts an Integer to a Boolean using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <p>
	 * {@code null} will be converted to {@code null}.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(Integer.valueOf(0))    = Boolean.FALSE
	 *   BooleanUtils.toBoolean(Integer.valueOf(1))    = Boolean.TRUE
	 *   BooleanUtils.toBoolean(Integer.valueOf(null)) = null
	 * </pre>
	 *
	 * @param value the Integer to convert
	 * @return Boolean.TRUE if non-zero, Boolean.FALSE if zero, {@code null} if
	 *         {@code null} input
	 */
	public static Boolean toBooleanObject(final Integer value) {
		return BooleanUtils.toBooleanObject(value);
	}

	/**
	 * <p>
	 * Converts an int to a boolean specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(0, 1, 0) = false
	 *   BooleanUtils.toBoolean(1, 1, 0) = true
	 *   BooleanUtils.toBoolean(2, 1, 2) = false
	 *   BooleanUtils.toBoolean(2, 2, 0) = true
	 * </pre>
	 *
	 * @param value      the Integer to convert
	 * @param trueValue  the value to match for {@code true}
	 * @param falseValue the value to match for {@code false}
	 * @return {@code true} or {@code false}
	 * @throws IllegalArgumentException if no match
	 */
	public static boolean toBoolean(final int value, final int trueValue, final int falseValue) {
		return BooleanUtils.toBoolean(value, trueValue, falseValue);
	}

	/**
	 * <p>
	 * Converts an Integer to a boolean specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)) = false
	 *   BooleanUtils.toBoolean(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)) = true
	 *   BooleanUtils.toBoolean(Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2)) = false
	 *   BooleanUtils.toBoolean(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(0)) = true
	 *   BooleanUtils.toBoolean(null, null, Integer.valueOf(0))                     = true
	 * </pre>
	 *
	 * @param value      the Integer to convert
	 * @param trueValue  the value to match for {@code true}, may be {@code null}
	 * @param falseValue the value to match for {@code false}, may be {@code null}
	 * @return {@code true} or {@code false}
	 * @throws IllegalArgumentException if no match
	 */
	public static boolean toBoolean(final Integer value, final Integer trueValue, final Integer falseValue) {
		return BooleanUtils.toBoolean(value, trueValue, falseValue);

	}

	/**
	 * <p>
	 * Converts an int to a Boolean specifying the conversion values.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBooleanObject(0, 0, 2, 3) = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject(2, 1, 2, 3) = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject(3, 1, 2, 3) = null
	 * </pre>
	 *
	 * @param value      the Integer to convert
	 * @param trueValue  the value to match for {@code true}
	 * @param falseValue the value to match for {@code false}
	 * @param nullValue  the value to to match for {@code null}
	 * @return Boolean.TRUE, Boolean.FALSE, or {@code null}
	 * @throws IllegalArgumentException if no match
	 */
	public static Boolean toBooleanObject(final int value, final int trueValue, final int falseValue,
			final int nullValue) {
		return BooleanUtils.toBooleanObject(value, trueValue, falseValue, nullValue);
	}

	/**
	 * <p>
	 * Converts an Integer to a Boolean specifying the conversion values.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBooleanObject(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3)) = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject(Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)) = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject(Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)) = null
	 * </pre>
	 *
	 * @param value      the Integer to convert
	 * @param trueValue  the value to match for {@code true}, may be {@code null}
	 * @param falseValue the value to match for {@code false}, may be {@code null}
	 * @param nullValue  the value to to match for {@code null}, may be {@code null}
	 * @return Boolean.TRUE, Boolean.FALSE, or {@code null}
	 * @throws IllegalArgumentException if no match
	 */
	public static Boolean toBooleanObject(final Integer value, final Integer trueValue, final Integer falseValue,
			final Integer nullValue) {
		return BooleanUtils.toBooleanObject(value, trueValue, falseValue, nullValue);
	}

	// Boolean to Integer methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a boolean to an int using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toInteger(true)  = 1
	 *   BooleanUtils.toInteger(false) = 0
	 * </pre>
	 *
	 * @param bool the boolean to convert
	 * @return one if {@code true}, zero if {@code false}
	 */
	public static int toInteger(final boolean bool) {
		return BooleanUtils.toInteger(bool);
	}

	/**
	 * <p>
	 * Converts a boolean to an Integer using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toIntegerObject(true)  = Integer.valueOf(1)
	 *   BooleanUtils.toIntegerObject(false) = Integer.valueOf(0)
	 * </pre>
	 *
	 * @param bool the boolean to convert
	 * @return one if {@code true}, zero if {@code false}
	 */
	public static Integer toIntegerObject(final boolean bool) {
		return BooleanUtils.toIntegerObject(bool);
	}

	/**
	 * <p>
	 * Converts a Boolean to a Integer using the convention that {@code zero} is
	 * {@code false}.
	 * </p>
	 *
	 * <p>
	 * {@code null} will be converted to {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toIntegerObject(Boolean.TRUE)  = Integer.valueOf(1)
	 *   BooleanUtils.toIntegerObject(Boolean.FALSE) = Integer.valueOf(0)
	 * </pre>
	 *
	 * @param bool the Boolean to convert
	 * @return one if Boolean.TRUE, zero if Boolean.FALSE, {@code null} if
	 *         {@code null}
	 */
	public static Integer toIntegerObject(final Boolean bool) {
		return BooleanUtils.toIntegerObject(bool);
	}

	/**
	 * <p>
	 * Converts a boolean to an int specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toInteger(true, 1, 0)  = 1
	 *   BooleanUtils.toInteger(false, 1, 0) = 0
	 * </pre>
	 *
	 * @param bool       the to convert
	 * @param trueValue  the value to return if {@code true}
	 * @param falseValue the value to return if {@code false}
	 * @return the appropriate value
	 */
	public static int toInteger(final boolean bool, final int trueValue, final int falseValue) {
		return BooleanUtils.toInteger(bool, trueValue, falseValue);
	}

	/**
	 * <p>
	 * Converts a Boolean to an int specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toInteger(Boolean.TRUE, 1, 0, 2)  = 1
	 *   BooleanUtils.toInteger(Boolean.FALSE, 1, 0, 2) = 0
	 *   BooleanUtils.toInteger(null, 1, 0, 2)          = 2
	 * </pre>
	 *
	 * @param bool       the Boolean to convert
	 * @param trueValue  the value to return if {@code true}
	 * @param falseValue the value to return if {@code false}
	 * @param nullValue  the value to return if {@code null}
	 * @return the appropriate value
	 */
	public static int toInteger(final Boolean bool, final int trueValue, final int falseValue, final int nullValue) {
		return BooleanUtils.toInteger(bool, trueValue, falseValue, nullValue);
	}

	/**
	 * <p>
	 * Converts a boolean to an Integer specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toIntegerObject(true, Integer.valueOf(1), Integer.valueOf(0))  = Integer.valueOf(1)
	 *   BooleanUtils.toIntegerObject(false, Integer.valueOf(1), Integer.valueOf(0)) = Integer.valueOf(0)
	 * </pre>
	 *
	 * @param bool       the to convert
	 * @param trueValue  the value to return if {@code true}, may be {@code null}
	 * @param falseValue the value to return if {@code false}, may be {@code null}
	 * @return the appropriate value
	 */
	public static Integer toIntegerObject(final boolean bool, final Integer trueValue, final Integer falseValue) {
		return BooleanUtils.toIntegerObject(bool, trueValue, falseValue);
	}

	/**
	 * <p>
	 * Converts a Boolean to an Integer specifying the conversion values.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toIntegerObject(Boolean.TRUE, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2))  = Integer.valueOf(1)
	 *   BooleanUtils.toIntegerObject(Boolean.FALSE, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)) = Integer.valueOf(0)
	 *   BooleanUtils.toIntegerObject(null, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2))          = Integer.valueOf(2)
	 * </pre>
	 *
	 * @param bool       the Boolean to convert
	 * @param trueValue  the value to return if {@code true}, may be {@code null}
	 * @param falseValue the value to return if {@code false}, may be {@code null}
	 * @param nullValue  the value to return if {@code null}, may be {@code null}
	 * @return the appropriate value
	 */
	public static Integer toIntegerObject(final Boolean bool, final Integer trueValue, final Integer falseValue,
			final Integer nullValue) {
		return BooleanUtils.toInteger(bool, trueValue, falseValue, nullValue);
	}

	// String to Boolean methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to a Boolean.
	 * </p>
	 *
	 * <p>
	 * {@code 'true'}, {@code 'on'}, {@code 'y'}, {@code 't'} or {@code 'yes'} (case
	 * insensitive) will return {@code true}. {@code 'false'}, {@code 'off'},
	 * {@code 'n'}, {@code 'f'} or {@code 'no'} (case insensitive) will return
	 * {@code false}. Otherwise, {@code null} is returned.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 *   // N.B. case is not significant
	 *   BooleanUtils.toBooleanObject(null)    = null
	 *   BooleanUtils.toBooleanObject("true")  = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject("T")     = Boolean.TRUE // i.e. T[RUE]
	 *   BooleanUtils.toBooleanObject("false") = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject("f")     = Boolean.FALSE // i.e. f[alse]
	 *   BooleanUtils.toBooleanObject("No")    = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject("n")     = Boolean.FALSE // i.e. n[o]
	 *   BooleanUtils.toBooleanObject("on")    = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject("ON")    = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject("off")   = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject("oFf")   = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject("yes")   = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject("Y")     = Boolean.TRUE // i.e. Y[ES]
	 *   BooleanUtils.toBooleanObject("blue")  = null
	 *   BooleanUtils.toBooleanObject("true ") = null // trailing space (too long)
	 *   BooleanUtils.toBooleanObject("ono")   = null // does not match on or no
	 * </pre>
	 *
	 * @param str the String to check; upper and lower case are treated as the same
	 * @return the Boolean value of the string, {@code null} if no match or
	 *         {@code null} input
	 */
	public static Boolean toBooleanObject(final String str) {
		return BooleanUtils.toBooleanObject(str);
	}

	/**
	 * <p>
	 * Converts a String to a Boolean throwing an exception if no match.
	 * </p>
	 *
	 * <p>
	 * NOTE: This returns null and will throw a NullPointerException if unboxed to a
	 * boolean.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBooleanObject("true", "true", "false", "null")  = Boolean.TRUE
	 *   BooleanUtils.toBooleanObject("false", "true", "false", "null") = Boolean.FALSE
	 *   BooleanUtils.toBooleanObject("null", "true", "false", "null")  = null
	 * </pre>
	 *
	 * @param str         the String to check
	 * @param trueString  the String to match for {@code true} (case sensitive), may
	 *                    be {@code null}
	 * @param falseString the String to match for {@code false} (case sensitive),
	 *                    may be {@code null}
	 * @param nullString  the String to match for {@code null} (case sensitive), may
	 *                    be {@code null}
	 * @return the Boolean value of the string, {@code null} if either the String
	 *         matches {@code nullString} or if {@code null} input and
	 *         {@code nullString} is {@code null}
	 * @throws IllegalArgumentException if the String doesn't match
	 */
	public static Boolean toBooleanObject(final String str, final String trueString, final String falseString,
			final String nullString) {
		return BooleanUtils.toBooleanObject(str, trueString, falseString, nullString);
	}

	// String to boolean methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to a boolean (optimised for performance).
	 * </p>
	 *
	 * <p>
	 * {@code 'true'}, {@code 'on'}, {@code 'y'}, {@code 't'} or {@code 'yes'} (case
	 * insensitive) will return {@code true}. Otherwise, {@code false} is returned.
	 * </p>
	 *
	 * <p>
	 * This method performs 4 times faster (JDK1.4) than
	 * {@code Boolean.valueOf(String)}. However, this method accepts 'on' and 'yes',
	 * 't', 'y' as true values.
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean(null)    = false
	 *   BooleanUtils.toBoolean("true")  = true
	 *   BooleanUtils.toBoolean("TRUE")  = true
	 *   BooleanUtils.toBoolean("tRUe")  = true
	 *   BooleanUtils.toBoolean("on")    = true
	 *   BooleanUtils.toBoolean("yes")   = true
	 *   BooleanUtils.toBoolean("false") = false
	 *   BooleanUtils.toBoolean("x gti") = false
	 *   BooleanUtils.toBooleanObject("y") = true
	 *   BooleanUtils.toBooleanObject("n") = false
	 *   BooleanUtils.toBooleanObject("t") = true
	 *   BooleanUtils.toBooleanObject("f") = false
	 * </pre>
	 *
	 * @param str the String to check
	 * @return the boolean value of the string, {@code false} if no match or the
	 *         String is null
	 */
	public static boolean toBoolean(final String str) {
		return BooleanUtils.toBoolean(str);
	}

	/**
	 * <p>
	 * Converts a String to a Boolean throwing an exception if no match found.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toBoolean("true", "true", "false")  = true
	 *   BooleanUtils.toBoolean("false", "true", "false") = false
	 * </pre>
	 *
	 * @param str         the String to check
	 * @param trueString  the String to match for {@code true} (case sensitive), may
	 *                    be {@code null}
	 * @param falseString the String to match for {@code false} (case sensitive),
	 *                    may be {@code null}
	 * @return the boolean value of the string
	 * @throws IllegalArgumentException if the String doesn't match
	 */
	public static boolean toBoolean(final String str, final String trueString, final String falseString) {
		return BooleanUtils.toBoolean(str, trueString, falseString);
	}

	// Boolean to String methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a Boolean to a String returning {@code 'true'}, {@code 'false'}, or
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringTrueFalse(Boolean.TRUE)  = "true"
	 *   BooleanUtils.toStringTrueFalse(Boolean.FALSE) = "false"
	 *   BooleanUtils.toStringTrueFalse(null)          = null;
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'true'}, {@code 'false'}, or {@code null}
	 */
	public static String toStringTrueFalse(final Boolean bool) {
		return toString(bool, "true", "false", null);
	}

	/**
	 * <p>
	 * Converts a Boolean to a String returning {@code 'on'}, {@code 'off'}, or
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringOnOff(Boolean.TRUE)  = "on"
	 *   BooleanUtils.toStringOnOff(Boolean.FALSE) = "off"
	 *   BooleanUtils.toStringOnOff(null)          = null;
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'on'}, {@code 'off'}, or {@code null}
	 */
	public static String toStringOnOff(final Boolean bool) {
		return toString(bool, "on", "off", null);
	}

	/**
	 * <p>
	 * Converts a Boolean to a String returning {@code 'yes'}, {@code 'no'}, or
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringYesNo(Boolean.TRUE)  = "yes"
	 *   BooleanUtils.toStringYesNo(Boolean.FALSE) = "no"
	 *   BooleanUtils.toStringYesNo(null)          = null;
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'yes'}, {@code 'no'}, or {@code null}
	 */
	public static String toStringYesNo(final Boolean bool) {
		return toString(bool, "yes", "no", null);
	}

	/**
	 * <p>
	 * Converts a Boolean to a String returning one of the input Strings.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toString(Boolean.TRUE, "true", "false", null)   = "true"
	 *   BooleanUtils.toString(Boolean.FALSE, "true", "false", null)  = "false"
	 *   BooleanUtils.toString(null, "true", "false", null)           = null;
	 * </pre>
	 *
	 * @param bool        the Boolean to check
	 * @param trueString  the String to return if {@code true}, may be {@code null}
	 * @param falseString the String to return if {@code false}, may be {@code null}
	 * @param nullString  the String to return if {@code null}, may be {@code null}
	 * @return one of the three input Strings
	 */
	public static String toString(final Boolean bool, final String trueString, final String falseString,
			final String nullString) {
		return BooleanUtils.toString(bool, trueString, falseString, nullString);
	}

	// boolean to String methods
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a boolean to a String returning {@code 'true'} or {@code 'false'}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringTrueFalse(true)   = "true"
	 *   BooleanUtils.toStringTrueFalse(false)  = "false"
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'true'}, {@code 'false'}, or {@code null}
	 */
	public static String toStringTrueFalse(final boolean bool) {
		return BooleanUtils.toStringTrueFalse(bool);
	}

	/**
	 * <p>
	 * Converts a boolean to a String returning {@code 'on'} or {@code 'off'}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringOnOff(true)   = "on"
	 *   BooleanUtils.toStringOnOff(false)  = "off"
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'on'}, {@code 'off'}, or {@code null}
	 */
	public static String toStringOnOff(final boolean bool) {
		return BooleanUtils.toStringOnOff(bool);
	}

	/**
	 * <p>
	 * Converts a boolean to a String returning {@code 'yes'} or {@code 'no'}.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toStringYesNo(true)   = "yes"
	 *   BooleanUtils.toStringYesNo(false)  = "no"
	 * </pre>
	 *
	 * @param bool the Boolean to check
	 * @return {@code 'yes'}, {@code 'no'}, or {@code null}
	 */
	public static String toStringYesNo(final boolean bool) {
		return BooleanUtils.toStringYesNo(bool);
	}

	/**
	 * <p>
	 * Converts a boolean to a String returning one of the input Strings.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.toString(true, "true", "false")   = "true"
	 *   BooleanUtils.toString(false, "true", "false")  = "false"
	 * </pre>
	 *
	 * @param bool        the Boolean to check
	 * @param trueString  the String to return if {@code true}, may be {@code null}
	 * @param falseString the String to return if {@code false}, may be {@code null}
	 * @return one of the two input Strings
	 */
	public static String toString(final boolean bool, final String trueString, final String falseString) {
		return BooleanUtils.toString(bool, trueString, falseString);
	}

	// logical operations
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Performs an and on a set of booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.and(true, true)         = true
	 *   BooleanUtils.and(false, false)       = false
	 *   BooleanUtils.and(true, false)        = false
	 *   BooleanUtils.and(true, true, false)  = false
	 *   BooleanUtils.and(true, true, true)   = true
	 * </pre>
	 *
	 * @param array an array of {@code boolean}s
	 * @return {@code true} if the and is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 * @since 1.0
	 */
	public static boolean and(final boolean... array) {
		return BooleanUtils.and(array);
	}

	/**
	 * <p>
	 * Performs an and on an array of Booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.and(Boolean.TRUE, Boolean.TRUE)                 = Boolean.TRUE
	 *   BooleanUtils.and(Boolean.FALSE, Boolean.FALSE)               = Boolean.FALSE
	 *   BooleanUtils.and(Boolean.TRUE, Boolean.FALSE)                = Boolean.FALSE
	 *   BooleanUtils.and(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE)   = Boolean.TRUE
	 *   BooleanUtils.and(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE) = Boolean.FALSE
	 *   BooleanUtils.and(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE)  = Boolean.FALSE
	 * </pre>
	 *
	 * @param array an array of {@code Boolean}s
	 * @return {@code true} if the and is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 * @throws IllegalArgumentException if {@code array} contains a {@code null}
	 * @since 1.0
	 */
	public static Boolean and(final Boolean... array) {
		return BooleanUtils.and(array);
	}

	/**
	 * <p>
	 * Performs an or on a set of booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.or(true, true)          = true
	 *   BooleanUtils.or(false, false)        = false
	 *   BooleanUtils.or(true, false)         = true
	 *   BooleanUtils.or(true, true, false)   = true
	 *   BooleanUtils.or(true, true, true)    = true
	 *   BooleanUtils.or(false, false, false) = false
	 * </pre>
	 *
	 * @param array an array of {@code boolean}s
	 * @return {@code true} if the or is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 * @since 1.0
	 */
	public static boolean or(final boolean... array) {
		return BooleanUtils.or(array);
	}

	/**
	 * <p>
	 * Performs an or on an array of Booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.or(Boolean.TRUE, Boolean.TRUE)                  = Boolean.TRUE
	 *   BooleanUtils.or(Boolean.FALSE, Boolean.FALSE)                = Boolean.FALSE
	 *   BooleanUtils.or(Boolean.TRUE, Boolean.FALSE)                 = Boolean.TRUE
	 *   BooleanUtils.or(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE)    = Boolean.TRUE
	 *   BooleanUtils.or(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE)  = Boolean.TRUE
	 *   BooleanUtils.or(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE)   = Boolean.TRUE
	 *   BooleanUtils.or(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE) = Boolean.FALSE
	 * </pre>
	 *
	 * @param array an array of {@code Boolean}s
	 * @return {@code true} if the or is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 * @throws IllegalArgumentException if {@code array} contains a {@code null}
	 * @since 1.0
	 */
	public static Boolean or(final Boolean... array) {
		return BooleanUtils.or(array);
	}

	/**
	 * <p>
	 * Performs an xor on a set of booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.xor(true, true)   = false
	 *   BooleanUtils.xor(false, false) = false
	 *   BooleanUtils.xor(true, false)  = true
	 * </pre>
	 *
	 * @param array an array of {@code boolean}s
	 * @return {@code true} if the xor is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 */
	public static boolean xor(final boolean... array) {
		return BooleanUtils.xor(array);
	}

	/**
	 * <p>
	 * Performs an xor on an array of Booleans.
	 * </p>
	 *
	 * <pre>
	 *   BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE })   = Boolean.FALSE
	 *   BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) = Boolean.FALSE
	 *   BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE })  = Boolean.TRUE
	 * </pre>
	 *
	 * @param array an array of {@code Boolean}s
	 * @return {@code true} if the xor is successful.
	 * @throws IllegalArgumentException if {@code array} is {@code null}
	 * @throws IllegalArgumentException if {@code array} is empty.
	 * @throws IllegalArgumentException if {@code array} contains a {@code null}
	 */
	public static Boolean xor(final Boolean... array) {
		return BooleanUtils.xor(array);
	}

	/**
	 * <p>
	 * Compares two {@code boolean} values. This is the same functionality as
	 * provided in Java 7.
	 * </p>
	 *
	 * @param x the first {@code boolean} to compare
	 * @param y the second {@code boolean} to compare
	 * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if
	 *         {@code !x && y}; and a value greater than {@code 0} if
	 *         {@code x && !y}
	 * @since 1.0
	 */
	public static int compare(final boolean x, final boolean y) {
		return BooleanUtils.compare(x, y);
	}
}
