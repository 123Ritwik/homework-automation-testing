package com.threeylos.core.util.common;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;

/**
 * <p>
 * Operations on {@code CharSet} instances.
 * </p>
 *
 * <p>
 * This class handles {@code null} input gracefully. An exception will not be
 * thrown for a {@code null} input. Each method documents its behaviour in more
 * detail.
 * </p>
 *
 * <p>
 * #ThreadSafe#
 * </p>
 * 
 * @see CharSet
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class CharSetUtil {

	/**
	 * <p>
	 * CharSetUtils instances should NOT be constructed in standard programming.
	 * Instead, the class should be used as {@code CharSetUtils.evaluateSet(null);}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public CharSetUtil() {
		super();
	}

	// Squeeze
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Squeezes any repetitions of a character that is mentioned in the supplied
	 * set.
	 * </p>
	 *
	 * <pre>
	 * CharSetUtils.squeeze(null, *)        = null
	 * CharSetUtils.squeeze("", *)          = ""
	 * CharSetUtils.squeeze(*, null)        = *
	 * CharSetUtils.squeeze(*, "")          = *
	 * CharSetUtils.squeeze("hello", "k-p") = "helo"
	 * CharSetUtils.squeeze("hello", "a-e") = "hello"
	 * </pre>
	 *
	 * @see CharSet#getInstance(java.lang.String...) for set-syntax.
	 * @param str the string to squeeze, may be null
	 * @param set the character set to use for manipulation, may be null
	 * @return the modified String, {@code null} if null string input
	 */
	public static String squeeze(final String str, final String... set) {
		return CharSetUtils.squeeze(str, set);
	}

	// ContainsAny
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Takes an argument in set-syntax, see evaluateSet, and identifies whether any
	 * of the characters are present in the specified string.
	 * </p>
	 *
	 * <pre>
	 * CharSetUtils.containsAny(null, *)        = false
	 * CharSetUtils.containsAny("", *)          = false
	 * CharSetUtils.containsAny(*, null)        = false
	 * CharSetUtils.containsAny(*, "")          = false
	 * CharSetUtils.containsAny("hello", "k-p") = true
	 * CharSetUtils.containsAny("hello", "a-d") = false
	 * </pre>
	 *
	 * @see CharSet#getInstance(java.lang.String...) for set-syntax.
	 * @param str String to look for characters in, may be null
	 * @param set String[] set of characters to identify, may be null
	 * @return whether or not the characters in the set are in the primary string
	 * @since 1.0
	 */
	public static boolean containsAny(final String str, final String... set) {
		return CharSetUtils.containsAny(str, set);
	}

	// Count
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Takes an argument in set-syntax, see evaluateSet, and returns the number of
	 * characters present in the specified string.
	 * </p>
	 *
	 * <pre>
	 * CharSetUtils.count(null, *)        = 0
	 * CharSetUtils.count("", *)          = 0
	 * CharSetUtils.count(*, null)        = 0
	 * CharSetUtils.count(*, "")          = 0
	 * CharSetUtils.count("hello", "k-p") = 3
	 * CharSetUtils.count("hello", "a-e") = 1
	 * </pre>
	 *
	 * @see CharSet#getInstance(java.lang.String...) for set-syntax.
	 * @param str String to count characters in, may be null
	 * @param set String[] set of characters to count, may be null
	 * @return the character count, zero if null string input
	 */
	public static int count(final String str, final String... set) {
		return CharSetUtils.count(str, set);
	}

	// Keep
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Takes an argument in set-syntax, see evaluateSet, and keeps any of characters
	 * present in the specified string.
	 * </p>
	 *
	 * <pre>
	 * CharSetUtils.keep(null, *)        = null
	 * CharSetUtils.keep("", *)          = ""
	 * CharSetUtils.keep(*, null)        = ""
	 * CharSetUtils.keep(*, "")          = ""
	 * CharSetUtils.keep("hello", "hl")  = "hll"
	 * CharSetUtils.keep("hello", "le")  = "ell"
	 * </pre>
	 *
	 * @see CharSet#getInstance(java.lang.String...) for set-syntax.
	 * @param str String to keep characters from, may be null
	 * @param set String[] set of characters to keep, may be null
	 * @return the modified String, {@code null} if null string input
	 * @since 1.0
	 */
	public static String keep(final String str, final String... set) {
		return CharSetUtils.keep(str, set);
	}

	// Delete
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Takes an argument in set-syntax, see evaluateSet, and deletes any of
	 * characters present in the specified string.
	 * </p>
	 *
	 * <pre>
	 * CharSetUtils.delete(null, *)        = null
	 * CharSetUtils.delete("", *)          = ""
	 * CharSetUtils.delete(*, null)        = *
	 * CharSetUtils.delete(*, "")          = *
	 * CharSetUtils.delete("hello", "hl")  = "eo"
	 * CharSetUtils.delete("hello", "le")  = "ho"
	 * </pre>
	 *
	 * @see CharSet#getInstance(java.lang.String...) for set-syntax.
	 * @param str String to delete characters from, may be null
	 * @param set String[] set of characters to delete, may be null
	 * @return the modified String, {@code null} if null string input
	 */
	public static String delete(final String str, final String... set) {
		return CharSetUtils.delete(str, set);
	}

}
