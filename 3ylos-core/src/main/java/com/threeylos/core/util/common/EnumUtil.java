package com.threeylos.core.util.common;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;

/**
 * <p>
 * Utility library to provide helper methods for Java enums.
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
public class EnumUtil {

	/**
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 */
	public EnumUtil() {
	}

	/**
	 * <p>
	 * Gets the {@code Map} of enums by name.
	 * </p>
	 *
	 * <p>
	 * This method is useful when you need a map of enums by name.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @return the modifiable map of enum names to enums, never null
	 */
	public static <E extends Enum<E>> Map<String, E> getEnumMap(final Class<E> enumClass) {
		return EnumUtils.getEnumMap(enumClass);
	}

	/**
	 * <p>
	 * Gets the {@code List} of enums.
	 * </p>
	 *
	 * <p>
	 * This method is useful when you need a list of enums rather than an array.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @return the modifiable list of enums, never null
	 */
	public static <E extends Enum<E>> List<E> getEnumList(final Class<E> enumClass) {
		return EnumUtils.getEnumList(enumClass);
	}

	/**
	 * <p>
	 * Checks if the specified name is a valid enum for the class.
	 * </p>
	 *
	 * <p>
	 * This method differs from {@link Enum#valueOf} in that checks if the name is a
	 * valid enum without needing to catch the exception.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @param enumName  the enum name, null returns false
	 * @return true if the enum name is valid, otherwise false
	 */
	public static <E extends Enum<E>> boolean isValidEnum(final Class<E> enumClass, final String enumName) {
		return EnumUtils.isValidEnum(enumClass, enumName);
	}

	/**
	 * <p>
	 * Checks if the specified name is a valid enum for the class.
	 * </p>
	 *
	 * <p>
	 * This method differs from {@link Enum#valueOf} in that checks if the name is a
	 * valid enum without needing to catch the exception and performs case
	 * insensitive matching of the name.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @param enumName  the enum name, null returns false
	 * @return true if the enum name is valid, otherwise false
	 * @since 1.0
	 */
	public static <E extends Enum<E>> boolean isValidEnumIgnoreCase(final Class<E> enumClass, final String enumName) {
		return EnumUtils.isValidEnumIgnoreCase(enumClass, enumName);
	}

	/**
	 * <p>
	 * Gets the enum for the class, returning {@code null} if not found.
	 * </p>
	 *
	 * <p>
	 * This method differs from {@link Enum#valueOf} in that it does not throw an
	 * exception for an invalid enum name.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @param enumName  the enum name, null returns null
	 * @return the enum, null if not found
	 */
	public static <E extends Enum<E>> E getEnum(final Class<E> enumClass, final String enumName) {
		return EnumUtils.getEnum(enumClass, enumName);
	}

	/**
	 * <p>
	 * Gets the enum for the class, returning {@code null} if not found.
	 * </p>
	 *
	 * <p>
	 * This method differs from {@link Enum#valueOf} in that it does not throw an
	 * exception for an invalid enum name and performs case insensitive matching of
	 * the name.
	 * </p>
	 *
	 * @param           <E> the type of the enumeration
	 * @param enumClass the class of the enum to query, not null
	 * @param enumName  the enum name, null returns null
	 * @return the enum, null if not found
	 * @since 1.0
	 */
	public static <E extends Enum<E>> E getEnumIgnoreCase(final Class<E> enumClass, final String enumName) {
		return EnumUtils.getEnumIgnoreCase(enumClass, enumName);
	}

	/**
	 * <p>
	 * Creates a long bit vector representation of the given subset of an Enum.
	 * </p>
	 *
	 * <p>
	 * This generates a value that is usable by {@link EnumUtils#processBitVector}.
	 * </p>
	 *
	 * <p>
	 * Do not use this method if you have more than 64 values in your Enum, as this
	 * would create a value greater than a long can hold.
	 * </p>
	 *
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param values    the values we want to convert, not {@code null}, neither
	 *                  containing {@code null}
	 * @param           <E> the type of the enumeration
	 * @return a long whose value provides a binary representation of the given set
	 *         of enum values.
	 * @throws NullPointerException     if {@code enumClass} or {@code values} is
	 *                                  {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class or
	 *                                  has more than 64 values, or if any
	 *                                  {@code values} {@code null}
	 * @since 1.0
	 * @see #generateBitVectors(Class, Iterable)
	 */
	public static <E extends Enum<E>> long generateBitVector(final Class<E> enumClass,
			final Iterable<? extends E> values) {
		return EnumUtils.generateBitVector(enumClass, values);
	}

	/**
	 * <p>
	 * Creates a bit vector representation of the given subset of an Enum using as
	 * many {@code long}s as needed.
	 * </p>
	 *
	 * <p>
	 * This generates a value that is usable by {@link EnumUtils#processBitVectors}.
	 * </p>
	 *
	 * <p>
	 * Use this method if you have more than 64 values in your Enum.
	 * </p>
	 *
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param values    the values we want to convert, not {@code null}, neither
	 *                  containing {@code null}
	 * @param           <E> the type of the enumeration
	 * @return a long[] whose values provide a binary representation of the given
	 *         set of enum values with least significant digits rightmost.
	 * @throws NullPointerException     if {@code enumClass} or {@code values} is
	 *                                  {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class,
	 *                                  or if any {@code values} {@code null}
	 * @since 1.0
	 */
	public static <E extends Enum<E>> long[] generateBitVectors(final Class<E> enumClass,
			final Iterable<? extends E> values) {
		return EnumUtils.generateBitVectors(enumClass, values);
	}

	/**
	 * <p>
	 * Creates a long bit vector representation of the given array of Enum values.
	 * </p>
	 *
	 * <p>
	 * This generates a value that is usable by {@link EnumUtils#processBitVector}.
	 * </p>
	 *
	 * <p>
	 * Do not use this method if you have more than 64 values in your Enum, as this
	 * would create a value greater than a long can hold.
	 * </p>
	 *
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param values    the values we want to convert, not {@code null}
	 * @param           <E> the type of the enumeration
	 * @return a long whose value provides a binary representation of the given set
	 *         of enum values.
	 * @throws NullPointerException     if {@code enumClass} or {@code values} is
	 *                                  {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class or
	 *                                  has more than 64 values
	 * @since 1.0
	 * @see #generateBitVectors(Class, Iterable)
	 */
	@SafeVarargs
	public static <E extends Enum<E>> long generateBitVector(final Class<E> enumClass, final E... values) {
		return EnumUtils.generateBitVector(enumClass, values);
	}

	/**
	 * <p>
	 * Creates a bit vector representation of the given subset of an Enum using as
	 * many {@code long}s as needed.
	 * </p>
	 *
	 * <p>
	 * This generates a value that is usable by {@link EnumUtils#processBitVectors}.
	 * </p>
	 *
	 * <p>
	 * Use this method if you have more than 64 values in your Enum.
	 * </p>
	 *
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param values    the values we want to convert, not {@code null}, neither
	 *                  containing {@code null}
	 * @param           <E> the type of the enumeration
	 * @return a long[] whose values provide a binary representation of the given
	 *         set of enum values with least significant digits rightmost.
	 * @throws NullPointerException     if {@code enumClass} or {@code values} is
	 *                                  {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class,
	 *                                  or if any {@code values} {@code null}
	 * @since 1.0
	 */

	@SafeVarargs
	public static <E extends Enum<E>> long[] generateBitVectors(final Class<E> enumClass, final E... values) {
		return EnumUtils.generateBitVectors(enumClass, values);
	}

	/**
	 * <p>
	 * Convert a long value created by {@link EnumUtils#generateBitVector} into the
	 * set of enum values that it represents.
	 * </p>
	 *
	 * <p>
	 * If you store this value, beware any changes to the enum that would affect
	 * ordinal values.
	 * </p>
	 * 
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param value     the long value representation of a set of enum values
	 * @param           <E> the type of the enumeration
	 * @return a set of enum values
	 * @throws NullPointerException     if {@code enumClass} is {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class or
	 *                                  has more than 64 values
	 * @since 1.0
	 */
	public static <E extends Enum<E>> EnumSet<E> processBitVector(final Class<E> enumClass, final long value) {
		return EnumUtils.processBitVector(enumClass, value);
	}

	/**
	 * <p>
	 * Convert a {@code long[]} created by {@link EnumUtils#generateBitVectors} into
	 * the set of enum values that it represents.
	 * </p>
	 *
	 * <p>
	 * If you store this value, beware any changes to the enum that would affect
	 * ordinal values.
	 * </p>
	 * 
	 * @param enumClass the class of the enum we are working with, not {@code null}
	 * @param values    the long[] bearing the representation of a set of enum
	 *                  values, least significant digits rightmost, not {@code null}
	 * @param           <E> the type of the enumeration
	 * @return a set of enum values
	 * @throws NullPointerException     if {@code enumClass} is {@code null}
	 * @throws IllegalArgumentException if {@code enumClass} is not an enum class
	 * @since 1.0
	 */
	public static <E extends Enum<E>> EnumSet<E> processBitVectors(final Class<E> enumClass, final long... values) {
		return EnumUtils.processBitVectors(enumClass, values);
	}

}
