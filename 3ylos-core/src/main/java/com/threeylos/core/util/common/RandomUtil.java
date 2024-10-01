package com.threeylos.core.util.common;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

/**
 * <p>
 * Utility library that supplements the standard {@link Random} class.
 * </p>
 *
 * <p>
 * Caveat: Instances of {@link Random} are not cryptographically secure.
 * </p>
 *
 * <p>
 * Please note that the Apache Commons project provides a component dedicated to
 * pseudo-random number generation, namely
 * <a href="https://commons.apache.org/rng">Commons RNG</a>, that may be a
 * better choice for applications with more stringent requirements (performance
 * and/or correctness).
 * </p>
 *
 * 
 * @author AbhinitKumar
 */
public class RandomUtil {

	/**
	 * <p>
	 * {@code RandomUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code RandomUtils.nextBytes(5);}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public RandomUtil() {
		super();
	}

	/**
	 * <p>
	 * Returns a random boolean value
	 * </p>
	 *
	 * @return the random boolean
	 * @since 1.0
	 */
	public static boolean nextBoolean() {
		return RandomUtils.nextBoolean();
	}

	/**
	 * <p>
	 * Creates an array of random bytes.
	 * </p>
	 *
	 * @param count the size of the returned array
	 * @return the random byte array
	 * @throws IllegalArgumentException if {@code count} is negative
	 */
	public static byte[] nextBytes(final int count) {
		return RandomUtils.nextBytes(count);
	}

	/**
	 * <p>
	 * Returns a random integer within the specified range.
	 * </p>
	 *
	 * @param startInclusive the smallest value that can be returned, must be
	 *                       non-negative
	 * @param endExclusive   the upper bound (not included)
	 * @throws IllegalArgumentException if {@code startInclusive > endExclusive} or
	 *                                  if {@code startInclusive} is negative
	 * @return the random integer
	 */
	public static int nextInt(final int startInclusive, final int endExclusive) {
		return RandomUtils.nextInt(startInclusive, endExclusive);
	}

	/**
	 * <p>
	 * Returns a random int within 0 - Integer.MAX_VALUE
	 * </p>
	 *
	 * @return the random integer
	 * @see #nextInt(int, int)
	 * @since 1.0
	 */
	public static int nextInt() {
		return RandomUtils.nextInt();
	}

	/**
	 * <p>
	 * Returns a random long within the specified range.
	 * </p>
	 *
	 * @param startInclusive the smallest value that can be returned, must be
	 *                       non-negative
	 * @param endExclusive   the upper bound (not included)
	 * @throws IllegalArgumentException if {@code startInclusive > endExclusive} or
	 *                                  if {@code startInclusive} is negative
	 * @return the random long
	 */
	public static long nextLong(final long startInclusive, final long endExclusive) {
		return RandomUtils.nextLong(startInclusive, endExclusive);
	}

	/**
	 * <p>
	 * Returns a random long within 0 - Long.MAX_VALUE
	 * </p>
	 *
	 * @return the random long
	 * @see #nextLong(long, long)
	 * @since 1.0
	 */
	public static long nextLong() {
		return RandomUtils.nextLong();
	}

	/**
	 * <p>
	 * Returns a random double within the specified range.
	 * </p>
	 *
	 * @param startInclusive the smallest value that can be returned, must be
	 *                       non-negative
	 * @param endInclusive   the upper bound (included)
	 * @throws IllegalArgumentException if {@code startInclusive > endInclusive} or
	 *                                  if {@code startInclusive} is negative
	 * @return the random double
	 */
	public static double nextDouble(final double startInclusive, final double endInclusive) {
		return RandomUtils.nextDouble(startInclusive, endInclusive);
	}

	/**
	 * <p>
	 * Returns a random double within 0 - Double.MAX_VALUE
	 * </p>
	 *
	 * @return the random double
	 * @see #nextDouble(double, double)
	 * @since 1.0
	 */
	public static double nextDouble() {
		return RandomUtils.nextDouble();
	}

	/**
	 * <p>
	 * Returns a random float within the specified range.
	 * </p>
	 *
	 * @param startInclusive the smallest value that can be returned, must be
	 *                       non-negative
	 * @param endInclusive   the upper bound (included)
	 * @throws IllegalArgumentException if {@code startInclusive > endInclusive} or
	 *                                  if {@code startInclusive} is negative
	 * @return the random float
	 */
	public static float nextFloat(final float startInclusive, final float endInclusive) {
		return RandomUtils.nextFloat(startInclusive, endInclusive);
	}

	/**
	 * <p>
	 * Returns a random float within 0 - Float.MAX_VALUE
	 * </p>
	 *
	 * @return the random float
	 * @see #nextFloat()
	 * @since 1.0
	 */
	public static float nextFloat() {
		return RandomUtils.nextFloat();
	}

}
