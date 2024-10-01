package com.threeylos.core.util.common;

import org.apache.commons.lang3.math.IEEE754rUtils;

/**
 * <p>
 * Provides IEEE-754r variants of NumberUtils methods.
 * </p>
 *
 * <p>
 * See: <a href=
 * "http://en.wikipedia.org/wiki/IEEE_754r">http://en.wikipedia.org/wiki/IEEE_754r</a>
 * </p>
 *
 * @since 2.4
 * 
 * @author AbhinitKumar
 * 
 */
public class IEEE754rUtil {

	private IEEE754rUtil() {

	}

	/**
	 * <p>
	 * Gets the minimum of three <code>double</code> values.
	 * </p>
	 *
	 * <p>
	 * NaN is only returned if all numbers are NaN as per IEEE-754r.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the smallest of the values
	 */
	public static double min(final double a, final double b, final double c) {
		return IEEE754rUtils.min(a, b, c);
	}

	/**
	 * <p>
	 * Gets the minimum of three <code>float</code> values.
	 * </p>
	 *
	 * <p>
	 * NaN is only returned if all numbers are NaN as per IEEE-754r.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the smallest of the values
	 */
	public static float min(final float a, final float b, final float c) {
		return IEEE754rUtils.min(a, b, c);
	}

	/**
	 * <p>
	 * Gets the maximum of three <code>double</code> values.
	 * </p>
	 *
	 * <p>
	 * NaN is only returned if all numbers are NaN as per IEEE-754r.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the largest of the values
	 */
	public static double max(final double a, final double b, final double c) {
		return IEEE754rUtils.max(a, b, c);
	}

	/**
	 * <p>
	 * Gets the maximum of three <code>float</code> values.
	 * </p>
	 *
	 * <p>
	 * NaN is only returned if all numbers are NaN as per IEEE-754r.
	 * </p>
	 *
	 * @param a value 1
	 * @param b value 2
	 * @param c value 3
	 * @return the largest of the values
	 */
	public static float max(final float a, final float b, final float c) {
		return IEEE754rUtils.max(a, b, c);
	}

}
