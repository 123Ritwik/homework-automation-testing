package com.threeylos.core.util.common;

import org.apache.commons.lang3.CharSequenceUtils;

/**
 * <p>
 * Operations on {@link CharSequence} that are {@code null} safe.
 * </p>
 *
 * @see CharSequence
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class CharSequenceUtil {

	/**
	 * <p>
	 * {@code CharSequenceUtils} instances should NOT be constructed in standard
	 * programming.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public CharSequenceUtil() {
		super();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns a new {@code CharSequence} that is a subsequence of this sequence
	 * starting with the {@code char} value at the specified index.
	 * </p>
	 *
	 * <p>
	 * This provides the {@code CharSequence} equivalent to
	 * {@link String#substring(int)}. The length (in {@code char}) of the returned
	 * sequence is {@code length() - start}, so if {@code start == end} then an
	 * empty sequence is returned.
	 * </p>
	 *
	 * @param cs    the specified subsequence, null returns null
	 * @param start the start index, inclusive, valid
	 * @return a new subsequence, may be null
	 * @throws IndexOutOfBoundsException if {@code start} is negative or if
	 *                                   {@code start} is greater than
	 *                                   {@code length()}
	 */
	public static CharSequence subSequence(final CharSequence cs, final int start) {
		return CharSequenceUtils.subSequence(cs, start);
	}

}
