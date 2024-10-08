package com.threeylos.core.util.common;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <p>
 * Operations for random {@code String}s.
 * </p>
 * <p>
 * Currently <em>private high surrogate</em> characters are ignored. These are
 * Unicode characters that fall between the values 56192 (db80) and 56319 (dbff)
 * as we don't know how to handle them. High and low surrogates are correctly
 * dealt with - that is if a high surrogate is randomly chosen, 55296 (d800) to
 * 56191 (db7f) then it is followed by a low surrogate. If a low surrogate is
 * chosen, 56320 (dc00) to 57343 (dfff) then it is placed after a randomly
 * chosen high surrogate.
 * </p>
 * <p>
 * RandomStringUtils is intended for simple use cases. For more advanced use
 * cases consider using commons-text <a href=
 * "https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/RandomStringGenerator.html">
 * RandomStringGenerator</a> instead.
 * </p>
 *
 * <p>
 * Caveat: Instances of {@link Random}, upon which the implementation of this
 * class relies, are not cryptographically secure.
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
 * <p>
 * #ThreadSafe#
 * </p>
 * 
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class RandomStringUtil {

	/**
	 * <p>
	 * {@code RandomStringUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code RandomStringUtils.random(5);}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public RandomStringUtil() {
		super();
	}

	// Random
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of all characters.
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 */
	public static String random(final int count) {
		return RandomStringUtils.random(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters whose ASCII value is
	 * between {@code 32} and {@code 126} (inclusive).
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 */
	public static String randomAscii(final int count) {
		return RandomStringUtils.randomAscii(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters whose ASCII value is
	 * between {@code 32} and {@code 126} (inclusive).
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomAscii(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomAscii(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of Latin alphabetic characters (a-z,
	 * A-Z).
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 */
	public static String randomAlphabetic(final int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of Latin alphabetic characters (a-z,
	 * A-Z).
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomAlphabetic(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomAlphabetic(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of Latin alphabetic characters (a-z,
	 * A-Z) and the digits 0-9.
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 */
	public static String randomAlphanumeric(final int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of Latin alphabetic characters (a-z,
	 * A-Z) and the digits 0-9.
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomAlphanumeric(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters which match the POSIX
	 * [:graph:] regular expression character class. This class contains all visible
	 * ASCII characters (i.e. anything except spaces and control characters).
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomGraph(final int count) {
		return RandomStringUtils.randomGraph(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of \p{Graph} characters.
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomGraph(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomGraph(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of numeric characters.
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 */
	public static String randomNumeric(final int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of \p{Digit} characters.
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomNumeric(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomNumeric(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters which match the POSIX
	 * [:print:] regular expression character class. This class includes all visible
	 * ASCII characters and spaces (i.e. anything except control characters).
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomPrint(final int count) {
		return RandomStringUtils.randomPrint(count);
	}

	/**
	 * <p>
	 * Creates a random string whose length is between the inclusive minimum and the
	 * exclusive maximum.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of \p{Print} characters.
	 * </p>
	 *
	 * @param minLengthInclusive the inclusive minimum length of the string to
	 *                           generate
	 * @param maxLengthExclusive the exclusive maximum length of the string to
	 *                           generate
	 * @return the random string
	 * @since 1.0
	 */
	public static String randomPrint(final int minLengthInclusive, final int maxLengthExclusive) {
		return RandomStringUtils.randomPrint(minLengthInclusive, maxLengthExclusive);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of alpha-numeric characters as
	 * indicated by the arguments.
	 * </p>
	 *
	 * @param count   the length of random string to create
	 * @param letters if {@code true}, generated string may include alphabetic
	 *                characters
	 * @param numbers if {@code true}, generated string may include numeric
	 *                characters
	 * @return the random string
	 */
	public static String random(final int count, final boolean letters, final boolean numbers) {
		return RandomStringUtils.random(count, letters, numbers);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of alpha-numeric characters as
	 * indicated by the arguments.
	 * </p>
	 *
	 * @param count   the length of random string to create
	 * @param start   the position in set of chars to start at
	 * @param end     the position in set of chars to end before
	 * @param letters if {@code true}, generated string may include alphabetic
	 *                characters
	 * @param numbers if {@code true}, generated string may include numeric
	 *                characters
	 * @return the random string
	 */
	public static String random(final int count, final int start, final int end, final boolean letters,
			final boolean numbers) {
		return RandomStringUtils.random(count, start, end, letters, numbers);
	}

	/**
	 * <p>
	 * Creates a random string based on a variety of options, using default source
	 * of randomness.
	 * </p>
	 *
	 * <p>
	 * This method has exactly the same semantics as
	 * {@link #random(int,int,int,boolean,boolean,char[],Random)}, but instead of
	 * using an externally supplied source of randomness, it uses the internal
	 * static {@link Random} instance.
	 * </p>
	 *
	 * @param count   the length of random string to create
	 * @param start   the position in set of chars to start at
	 * @param end     the position in set of chars to end before
	 * @param letters only allow letters?
	 * @param numbers only allow numbers?
	 * @param chars   the set of chars to choose randoms from. If {@code null}, then
	 *                it will use the set of all chars.
	 * @return the random string
	 * @throws ArrayIndexOutOfBoundsException if there are not
	 *                                        {@code (end - start) + 1} characters
	 *                                        in the set array.
	 */
	public static String random(final int count, final int start, final int end, final boolean letters,
			final boolean numbers, final char... chars) {
		return RandomStringUtils.random(count, start, end, letters, numbers, chars);
	}

	/**
	 * <p>
	 * Creates a random string based on a variety of options, using supplied source
	 * of randomness.
	 * </p>
	 *
	 * <p>
	 * If start and end are both {@code 0}, start and end are set to {@code ' '} and
	 * {@code 'z'}, the ASCII printable characters, will be used, unless letters and
	 * numbers are both {@code false}, in which case, start and end are set to
	 * {@code 0} and {@link Character#MAX_CODE_POINT}.
	 *
	 * <p>
	 * If set is not {@code null}, characters between start and end are chosen.
	 * </p>
	 *
	 * <p>
	 * This method accepts a user-supplied {@link Random} instance to use as a
	 * source of randomness. By seeding a single {@link Random} instance with a
	 * fixed seed and using it for each call, the same random sequence of strings
	 * can be generated repeatedly and predictably.
	 * </p>
	 *
	 * @param count   the length of random string to create
	 * @param start   the position in set of chars to start at (inclusive)
	 * @param end     the position in set of chars to end before (exclusive)
	 * @param letters only allow letters?
	 * @param numbers only allow numbers?
	 * @param chars   the set of chars to choose randoms from, must not be empty. If
	 *                {@code null}, then it will use the set of all chars.
	 * @param random  a source of randomness.
	 * @return the random string
	 * @throws ArrayIndexOutOfBoundsException if there are not
	 *                                        {@code (end - start) + 1} characters
	 *                                        in the set array.
	 * @throws IllegalArgumentException       if {@code count} &lt; 0 or the
	 *                                        provided chars array is empty.
	 * @since 1.0
	 */
	public static String random(int count, int start, int end, final boolean letters, final boolean numbers,
			final char[] chars, final Random random) {
		return RandomStringUtils.random(count, start, end, letters, numbers, chars, random);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters specified by the string,
	 * must not be empty. If null, the set of all characters is used.
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @param chars the String containing the set of characters to use, may be null,
	 *              but must not be empty
	 * @return the random string
	 * @throws IllegalArgumentException if {@code count} &lt; 0 or the string is
	 *                                  empty.
	 */
	public static String random(final int count, final String chars) {
		return RandomStringUtils.random(count, chars);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of characters specified.
	 * </p>
	 *
	 * @param count the length of random string to create
	 * @param chars the character array containing the set of characters to use, may
	 *              be null
	 * @return the random string
	 * @throws IllegalArgumentException if {@code count} &lt; 0.
	 */
	public static String random(final int count, final char... chars) {
		return RandomStringUtils.random(count, chars);
	}

}
