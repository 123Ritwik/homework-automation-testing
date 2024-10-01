
package com.threeylos.core.util.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <p>
 * Operations on arrays, primitive arrays (like {@code int[]}) and primitive
 * wrapper arrays (like {@code Integer[]}).
 *
 * <p>
 * This class tries to handle {@code null} input gracefully. An exception will
 * not be thrown for a {@code null} array input. However, an Object array that
 * contains a {@code null} element may throw an exception. Each method documents
 * its behaviour.
 *
 * <p>
 * #ThreadSafe#
 * 
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class ArrayUtil {

	/**
	 * <p>
	 * ArrayUtils instances should NOT be constructed in standard programming.
	 * Instead, the class should be used as
	 * <code>ArrayUtils.clone(new int[] {2})</code>.
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 */
	public ArrayUtil() {
		super();
	}

	// NOTE: Cannot use {@code} to enclose text which includes {}, but <code></code>
	// is OK

	// Basic methods handling multi-dimensional arrays
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Outputs an array as a String, treating {@code null} as an empty array.
	 *
	 * <p>
	 * Multi-dimensional arrays are handled correctly, including multi-dimensional
	 * primitive arrays.
	 *
	 * <p>
	 * The format is that of Java source code, for example <code>{a,b}</code>.
	 *
	 * @param array the array to get a toString for, may be {@code null}
	 * @return a String representation of the array, '{}' if null array input
	 */
	public static String toString(final Object array) {
		return ArrayUtils.toString(array);
	}

	/**
	 * <p>
	 * Outputs an array as a String handling {@code null}s.
	 *
	 * <p>
	 * Multi-dimensional arrays are handled correctly, including multi-dimensional
	 * primitive arrays.
	 *
	 * <p>
	 * The format is that of Java source code, for example <code>{a,b}</code>.
	 *
	 * @param array        the array to get a toString for, may be {@code null}
	 * @param stringIfNull the String to return if the array is {@code null}
	 * @return a String representation of the array
	 */
	public static String toString(final Object array, final String stringIfNull) {
		return ArrayUtils.toString(array, stringIfNull);
	}

	/**
	 * <p>
	 * Get a hash code for an array handling multi-dimensional arrays correctly.
	 *
	 * <p>
	 * Multi-dimensional primitive arrays are also handled correctly by this method.
	 *
	 * @param array the array to get a hash code for, {@code null} returns zero
	 * @return a hash code for the array
	 */
	public static int hashCode(final Object array) {
		return ArrayUtils.hashCode(array);
	}

	/**
	 * <p>
	 * Compares two arrays, using equals(), handling multi-dimensional arrays
	 * correctly.
	 *
	 * <p>
	 * Multi-dimensional primitive arrays are also handled correctly by this method.
	 *
	 * @param array1 the left hand array to compare, may be {@code null}
	 * @param array2 the right hand array to compare, may be {@code null}
	 * @return {@code true} if the arrays are equal
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.deepEquals(Object, Object)} and will be
	 *             removed from future releases.
	 */
	@Deprecated
	public static boolean isEquals(final Object array1, final Object array2) {
		return ArrayUtils.isEquals(array1, array2);
	}

	// To map
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the given array into a {@link java.util.Map}. Each element of the
	 * array must be either a {@link java.util.Map.Entry} or an Array, containing at
	 * least two elements, where the first element is used as key and the second as
	 * value.
	 *
	 * <p>
	 * This method can be used to initialize:
	 * 
	 * <pre>
	 * // Create a Map mapping colors.
	 * Map colorMap = ArrayUtils
	 * 		.toMap(new String[][] { { "RED", "#FF0000" }, { "GREEN", "#00FF00" }, { "BLUE", "#0000FF" } });
	 * </pre>
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array an array whose elements are either a {@link java.util.Map.Entry}
	 *              or an Array containing at least two elements, may be
	 *              {@code null}
	 * @return a {@code Map} that was created from the array
	 * @throws IllegalArgumentException if one element of this Array is itself an
	 *                                  Array containing less then two elements
	 * @throws IllegalArgumentException if the array contains elements other than
	 *                                  {@link java.util.Map.Entry} and an Array
	 */
	public static Map<Object, Object> toMap(final Object[] array) {
		return ArrayUtils.toMap(array);
	}

	// Generic array
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Create a type-safe generic array.
	 *
	 * <p>
	 * The Java language does not allow an array to be created from a generic type:
	 *
	 * <pre>
	 * public static &lt;T&gt; T[] createAnArray(int size) {
	 * 	return new T[size]; // compiler error here
	 * }
	 * 
	 * public static &lt;T&gt; T[] createAnArray(int size) {
	 * 	return (T[]) new Object[size]; // ClassCastException at runtime
	 * }
	 * </pre>
	 *
	 * <p>
	 * Therefore new arrays of generic types can be created with this method. For
	 * example, an array of Strings can be created:
	 *
	 * <pre>
	 * String[] array = ArrayUtils.toArray("1", "2");
	 * String[] emptyArray = ArrayUtils.&lt;String&gt;toArray();
	 * </pre>
	 *
	 * <p>
	 * The method is typically used in scenarios, where the caller itself uses
	 * generic types that have to be combined into an array.
	 *
	 * <p>
	 * Note, this method makes only sense to provide arguments of the same type so
	 * that the compiler can deduce the type of the array itself. While it is
	 * possible to select the type explicitly like in
	 * <code>Number[] array = ArrayUtils.&lt;Number&gt;toArray(Integer.valueOf(42), Double.valueOf(Math.PI))</code>,
	 * there is no real advantage when compared to
	 * <code>new Number[] {Integer.valueOf(42), Double.valueOf(Math.PI)}</code>.
	 *
	 * @param       <T> the array's element type
	 * @param items the varargs array items, null allowed
	 * @return the array, not null unless a null array is passed in
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T[] toArray(final T... items) {
		return ArrayUtils.toArray(items);
	}

	// Clone
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Shallow clones an array returning a typecast result and handling
	 * {@code null}.
	 *
	 * <p>
	 * The objects in the array are not cloned, thus there is no special handling
	 * for multi-dimensional arrays.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param       <T> the component type of the array
	 * @param array the array to shallow clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static <T> T[] clone(final T[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static long[] clone(final long[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static int[] clone(final int[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static short[] clone(final short[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static char[] clone(final char[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static byte[] clone(final byte[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static double[] clone(final double[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static float[] clone(final float[] array) {
		return ArrayUtils.clone(array);
	}

	/**
	 * <p>
	 * Clones an array returning a typecast result and handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array the array to clone, may be {@code null}
	 * @return the cloned array, {@code null} if {@code null} input
	 */
	public static boolean[] clone(final boolean[] array) {
		return ArrayUtils.clone(array);
	}

	// nullToEmpty
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @param type  the class representation of the desired array
	 * @param       <T> the class type
	 * @return the same array, {@code public static} empty array if {@code null}
	 * @throws IllegalArgumentException if the type argument is null
	 * @since 1.0
	 */
	public static <T> T[] nullToEmpty(final T[] array, final Class<T[]> type) {
		return ArrayUtils.nullToEmpty(array, type);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Object[] nullToEmpty(final Object[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Class<?>[] nullToEmpty(final Class<?>[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static String[] nullToEmpty(final String[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static long[] nullToEmpty(final long[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static int[] nullToEmpty(final int[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static short[] nullToEmpty(final short[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static char[] nullToEmpty(final char[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static byte[] nullToEmpty(final byte[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static double[] nullToEmpty(final double[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static float[] nullToEmpty(final float[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static boolean[] nullToEmpty(final boolean[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Long[] nullToEmpty(final Long[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Integer[] nullToEmpty(final Integer[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Short[] nullToEmpty(final Short[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Character[] nullToEmpty(final Character[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Byte[] nullToEmpty(final Byte[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Double[] nullToEmpty(final Double[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Float[] nullToEmpty(final Float[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	/**
	 * <p>
	 * Defensive programming technique to change a {@code null} reference to an
	 * empty one.
	 *
	 * <p>
	 * This method returns an empty array for a {@code null} input array.
	 *
	 * <p>
	 * As a memory optimizing technique an empty array passed in will be overridden
	 * with the empty {@code public static} references in this class.
	 *
	 * @param array the array to check for {@code null} or empty
	 * @return the same array, {@code public static} empty array if {@code null} or
	 *         empty input
	 * @since 1.0
	 */
	public static Boolean[] nullToEmpty(final Boolean[] array) {
		return ArrayUtils.nullToEmpty(array);
	}

	// Subarrays
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Produces a new array containing the elements between the start and end
	 * indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * <p>
	 * The component type of the subarray is always the same as that of the input
	 * array. Thus, if the input is an array of type {@code Date}, the following
	 * usage is envisaged:
	 *
	 * <pre>
	 * Date[] someDates = (Date[]) ArrayUtils.subarray(allDates, 2, 5);
	 * </pre>
	 *
	 * @param                     <T> the component type of the array
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(Object[], int, int)
	 */
	public static <T> T[] subarray(final T[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code long} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(long[], int, int)
	 */
	public static long[] subarray(final long[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code int} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(int[], int, int)
	 */
	public static int[] subarray(final int[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code short} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(short[], int, int)
	 */
	public static short[] subarray(final short[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code char} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(char[], int, int)
	 */
	public static char[] subarray(final char[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code byte} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(byte[], int, int)
	 */
	public static byte[] subarray(final byte[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code double} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(double[], int, int)
	 */
	public static double[] subarray(final double[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code float} array containing the elements between the start
	 * and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(float[], int, int)
	 */
	public static float[] subarray(final float[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Produces a new {@code boolean} array containing the elements between the
	 * start and end indices.
	 *
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 *
	 * @param array               the array
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in an
	 *                            empty array.
	 * @param endIndexExclusive   elements up to endIndex-1 are present in the
	 *                            returned subarray. Undervalue (&lt; startIndex)
	 *                            produces empty array, overvalue (&gt;array.length)
	 *                            is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 1.0
	 * @see Arrays#copyOfRange(boolean[], int, int)
	 */
	public static boolean[] subarray(final boolean[] array, int startIndexInclusive, int endIndexExclusive) {
		return ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
	}

	// Is same length
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * <p>
	 * Any multi-dimensional aspects of the arrays are ignored.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final Object[] array1, final Object[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final long[] array1, final long[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final int[] array1, final int[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final short[] array1, final short[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final char[] array1, final char[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final byte[] array1, final byte[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final double[] array1, final double[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final float[] array1, final float[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same length, treating {@code null} arrays
	 * as length {@code 0}.
	 *
	 * @param array1 the first array, may be {@code null}
	 * @param array2 the second array, may be {@code null}
	 * @return {@code true} if length of arrays matches, treating {@code null} as an
	 *         empty array
	 */
	public static boolean isSameLength(final boolean[] array1, final boolean[] array2) {
		return ArrayUtils.isSameLength(array1, array2);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns the length of the specified array. This method can deal with
	 * {@code Object} arrays and with primitive arrays.
	 *
	 * <p>
	 * If the input array is {@code null}, {@code 0} is returned.
	 *
	 * <pre>
	 * ArrayUtils.getLength(null)            = 0
	 * ArrayUtils.getLength([])              = 0
	 * ArrayUtils.getLength([null])          = 1
	 * ArrayUtils.getLength([true, false])   = 2
	 * ArrayUtils.getLength([1, 2, 3])       = 3
	 * ArrayUtils.getLength(["a", "b", "c"]) = 3
	 * </pre>
	 *
	 * @param array the array to retrieve the length from, may be null
	 * @return The length of the array, or {@code 0} if the array is {@code null}
	 * @throws IllegalArgumentException if the object argument is not an array.
	 * @since 1.0
	 */
	public static int getLength(final Object array) {
		return ArrayUtils.getLength(array);
	}

	/**
	 * <p>
	 * Checks whether two arrays are the same type taking into account
	 * multi-dimensional arrays.
	 *
	 * @param array1 the first array, must not be {@code null}
	 * @param array2 the second array, must not be {@code null}
	 * @return {@code true} if type of arrays matches
	 * @throws IllegalArgumentException if either array is {@code null}
	 */
	public static boolean isSameType(final Object array1, final Object array2) {
		return ArrayUtils.isSameType(array1, array2);
	}

	// Reverse
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final Object[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final long[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final int[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final short[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final char[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final byte[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final double[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final float[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array the array to reverse, may be {@code null}
	 */
	public static void reverse(final boolean[] array) {
		ArrayUtils.reverse(array);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final boolean[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final byte[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final char[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final double[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final float[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final long[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Under value (&lt;0) is
	 *                            promoted to 0, over value (&gt;array.length)
	 *                            results in no change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Under value (&lt; start index) results in
	 *                            no change. Over value (&gt;array.length) is
	 *                            demoted to array length.
	 * @since 1.0
	 */
	public static void reverse(final Object[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	/**
	 * <p>
	 * Reverses the order of the given array in the given range.
	 *
	 * <p>
	 * This method does nothing for a {@code null} input array.
	 *
	 * @param array               the array to reverse, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are reversed in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @since 1.0
	 */
	public static void reverse(final short[] array, final int startIndexInclusive, final int endIndexExclusive) {
		ArrayUtils.reverse(array, startIndexInclusive, endIndexExclusive);
	}

	// Swap
	// -----------------------------------------------------------------------
	/**
	 * Swaps two elements in the given array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap(["1", "2", "3"], 0, 2) -&gt; ["3", "2", "1"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3"], 0, 0) -&gt; ["1", "2", "3"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3"], 1, 0) -&gt; ["2", "1", "3"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3"], 0, 5) -&gt; ["1", "2", "3"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3"], -1, 1) -&gt; ["2", "1", "3"]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final Object[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given long array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([true, false, true], 0, 2) -&gt; [true, false, true]</li>
	 * <li>ArrayUtils.swap([true, false, true], 0, 0) -&gt; [true, false, true]</li>
	 * <li>ArrayUtils.swap([true, false, true], 1, 0) -&gt; [false, true, true]</li>
	 * <li>ArrayUtils.swap([true, false, true], 0, 5) -&gt; [true, false, true]</li>
	 * <li>ArrayUtils.swap([true, false, true], -1, 1) -&gt; [false, true,
	 * true]</li>
	 * </ul>
	 *
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final long[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given int array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final int[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given short array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final short[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given char array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final char[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given byte array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final byte[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given double array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final double[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given float array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final float[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps two elements in the given boolean array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for a {@code null} or empty input array or for overflow indices.
	 * Negative indices are promoted to 0(zero).
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
	 * <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0
	 */
	public static void swap(final boolean[] array, final int offset1, final int offset2) {
		ArrayUtils.swap(array, offset1, offset2);
	}

	/**
	 * Swaps a series of elements in the given boolean array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([true, false, true, false], 0, 2, 1) -&gt; [true, false,
	 * true, false]</li>
	 * <li>ArrayUtils.swap([true, false, true, false], 0, 0, 1) -&gt; [true, false,
	 * true, false]</li>
	 * <li>ArrayUtils.swap([true, false, true, false], 0, 2, 2) -&gt; [true, false,
	 * true, false]</li>
	 * <li>ArrayUtils.swap([true, false, true, false], -3, 2, 2) -&gt; [true, false,
	 * true, false]</li>
	 * <li>ArrayUtils.swap([true, false, true, false], 0, 3, 3) -&gt; [false, false,
	 * true, true]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final boolean[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given byte array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final byte[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given char array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final char[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given double array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final double[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given float array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final float[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);

	}

	/**
	 * Swaps a series of elements in the given int array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final int[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given long array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final long[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 2, 1) -&gt; ["3", "2", "1",
	 * "4"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 0, 1) -&gt; ["1", "2", "3",
	 * "4"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3", "4"], 2, 0, 2) -&gt; ["3", "4", "1",
	 * "2"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3", "4"], -3, 2, 2) -&gt; ["3", "4", "1",
	 * "2"]</li>
	 * <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 3, 3) -&gt; ["4", "2", "3",
	 * "1"]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final Object[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	/**
	 * Swaps a series of elements in the given short array.
	 *
	 * <p>
	 * This method does nothing for a {@code null} or empty input array or for
	 * overflow indices. Negative indices are promoted to 0(zero). If any of the
	 * sub-arrays to swap falls outside of the given array, then the swap is stopped
	 * at the end of the array and as many as possible elements are swapped.
	 * </p>
	 *
	 * Examples:
	 * <ul>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
	 * <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
	 * </ul>
	 *
	 * @param array   the array to swap, may be {@code null}
	 * @param offset1 the index of the first element in the series to swap
	 * @param offset2 the index of the second element in the series to swap
	 * @param len     the number of elements to swap starting with the given indices
	 * @since 1.0
	 */
	public static void swap(final short[] array, int offset1, int offset2, int len) {
		ArrayUtils.swap(array, offset1, offset2, len);
	}

	// Shift
	// -----------------------------------------------------------------------
	/**
	 * Shifts the order of the given array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final Object[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given long array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final long[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given int array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final int[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given short array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final short[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given char array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final char[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given byte array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final byte[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given double array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final double[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given float array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final float[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of the given boolean array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array  the array to shift, may be {@code null}
	 * @param offset The number of positions to rotate the elements. If the offset
	 *               is larger than the number of elements to rotate, than the
	 *               effective offset is modulo the number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final boolean[] array, final int offset) {
		ArrayUtils.shift(array, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given boolean array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final boolean[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given byte array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final byte[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given char array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final char[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given double array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final double[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given float array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final float[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given int array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final int[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given long array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final long[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final Object[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	/**
	 * Shifts the order of a series of elements in the given short array.
	 *
	 * <p>
	 * There is no special handling for multi-dimensional arrays. This method does
	 * nothing for {@code null} or empty input arrays.
	 * </p>
	 *
	 * @param array               the array to shift, may be {@code null}
	 * @param startIndexInclusive the starting index. Undervalue (&lt;0) is promoted
	 *                            to 0, overvalue (&gt;array.length) results in no
	 *                            change.
	 * @param endIndexExclusive   elements up to endIndex-1 are shifted in the
	 *                            array. Undervalue (&lt; start index) results in no
	 *                            change. Overvalue (&gt;array.length) is demoted to
	 *                            array length.
	 * @param offset              The number of positions to rotate the elements. If
	 *                            the offset is larger than the number of elements
	 *                            to rotate, than the effective offset is modulo the
	 *                            number of elements to rotate.
	 * @since 1.0
	 */
	public static void shift(final short[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
		ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
	}

	// IndexOf search
	// ----------------------------------------------------------------------

	// Object IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given object in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array        the array to search through for the object, may be
	 *                     {@code null}
	 * @param objectToFind the object to find, may be {@code null}
	 * @return the index of the object within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final Object[] array, final Object objectToFind) {
		return ArrayUtils.indexOf(array, objectToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given object in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array        the array to search through for the object, may be
	 *                     {@code null}
	 * @param objectToFind the object to find, may be {@code null}
	 * @param startIndex   the index to start searching at
	 * @return the index of the object within the array starting at the index,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int indexOf(final Object[] array, final Object objectToFind, int startIndex) {
		return ArrayUtils.indexOf(array, objectToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given object within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array        the array to traverse backwards looking for the object,
	 *                     may be {@code null}
	 * @param objectToFind the object to find, may be {@code null}
	 * @return the last index of the object within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final Object[] array, final Object objectToFind) {
		return ArrayUtils.lastIndexOf(array, objectToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given object in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array        the array to traverse for looking for the object, may be
	 *                     {@code null}
	 * @param objectToFind the object to find, may be {@code null}
	 * @param startIndex   the start index to traverse backwards from
	 * @return the last index of the object within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final Object[] array, final Object objectToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, objectToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the object is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array        the array to search through
	 * @param objectToFind the object to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final Object[] array, final Object objectToFind) {
		return ArrayUtils.contains(array, objectToFind);
	}

	// long IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final long[] array, final long valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final long[] array, final long valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final long[] array, final long valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final long[] array, final long valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final long[] array, final long valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// int IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final int[] array, final int valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final int[] array, final int valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final int[] array, final int valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final int[] array, final int valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final int[] array, final int valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// short IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final short[] array, final short valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final short[] array, final short valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final short[] array, final short valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final short[] array, final short valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final short[] array, final short valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// char IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 * @since 1.0
	 */
	public static int indexOf(final char[] array, final char valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 * @since 1.0
	 */
	public static int indexOf(final char[] array, final char valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 * @since 1.0
	 */
	public static int lastIndexOf(final char[] array, final char valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 * @since 1.0
	 */
	public static int lastIndexOf(final char[] array, final char valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 * @since 1.0
	 */
	public static boolean contains(final char[] array, final char valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// byte IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final byte[] array, final byte valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final byte[] array, final byte valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final byte[] array, final byte valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final byte[] array, final byte valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final byte[] array, final byte valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// double IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final double[] array, final double valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value within a given tolerance in the array.
	 * This method will return the index of the first value which falls between the
	 * region defined by valueToFind - tolerance and valueToFind + tolerance.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param tolerance   tolerance of the search
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final double[] array, final double valueToFind, final double tolerance) {
		return ArrayUtils.indexOf(array, valueToFind, tolerance);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final double[] array, final double valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 * This method will return the index of the first value which falls between the
	 * region defined by valueToFind - tolerance and valueToFind + tolerance.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @param tolerance   tolerance of the search
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final double[] array, final double valueToFind, int startIndex, final double tolerance) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final double[] array, final double valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within a given tolerance in the
	 * array. This method will return the index of the last value which falls
	 * between the region defined by valueToFind - tolerance and valueToFind +
	 * tolerance.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param tolerance   tolerance of the search
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int lastIndexOf(final double[] array, final double valueToFind, final double tolerance) {
		return ArrayUtils.lastIndexOf(array, valueToFind, tolerance);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final double[] array, final double valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index. This method will return the index of the last value which falls
	 * between the region defined by valueToFind - tolerance and valueToFind +
	 * tolerance.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @param tolerance   search for value within plus/minus this amount
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final double[] array, final double valueToFind, int startIndex,
			final double tolerance) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex, tolerance);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final double[] array, final double valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	/**
	 * <p>
	 * Checks if a value falling within the given tolerance is in the given array.
	 * If the array contains a value within the inclusive range defined by (value -
	 * tolerance) to (value + tolerance).
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search
	 * @param valueToFind the value to find
	 * @param tolerance   the array contains the tolerance of the search
	 * @return true if value falling within tolerance is in array
	 */
	public static boolean contains(final double[] array, final double valueToFind, final double tolerance) {
		return ArrayUtils.contains(array, valueToFind, tolerance);
	}

	// float IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final float[] array, final float valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final float[] array, final float valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final float[] array, final float valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final float[] array, final float valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final float[] array, final float valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// boolean IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the index of the given value in the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final boolean[] array, final boolean valueToFind) {
		return ArrayUtils.indexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the index of the given value in the array starting at the given index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex is treated as zero. A startIndex larger than the array
	 * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
	 *
	 * @param array       the array to search through for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the index to start searching at
	 * @return the index of the value within the array, {@link #INDEX_NOT_FOUND}
	 *         ({@code -1}) if not found or {@code null} array input
	 */
	public static int indexOf(final boolean[] array, final boolean valueToFind, int startIndex) {
		return ArrayUtils.indexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Finds the last index of the given value within the array.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) if {@code null}
	 * array input.
	 *
	 * @param array       the array to traverse backwards looking for the object,
	 *                    may be {@code null}
	 * @param valueToFind the object to find
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final boolean[] array, final boolean valueToFind) {
		return ArrayUtils.lastIndexOf(array, valueToFind);
	}

	/**
	 * <p>
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 *
	 * <p>
	 * This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null}
	 * input array.
	 *
	 * <p>
	 * A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array       the array to traverse for looking for the object, may be
	 *                    {@code null}
	 * @param valueToFind the value to find
	 * @param startIndex  the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
	 *         array input
	 */
	public static int lastIndexOf(final boolean[] array, final boolean valueToFind, int startIndex) {
		return ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
	}

	/**
	 * <p>
	 * Checks if the value is in the given array.
	 *
	 * <p>
	 * The method returns {@code false} if a {@code null} array is passed in.
	 *
	 * @param array       the array to search through
	 * @param valueToFind the value to find
	 * @return {@code true} if the array contains the object
	 */
	public static boolean contains(final boolean[] array, final boolean valueToFind) {
		return ArrayUtils.contains(array, valueToFind);
	}

	// Primitive/Object array converters
	// ----------------------------------------------------------------------

	// Character array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Characters to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Character} array, may be {@code null}
	 * @return a {@code char} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static char[] toPrimitive(final Character[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Character to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Character} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code char} array, {@code null} if null array input
	 */
	public static char[] toPrimitive(final Character[] array, final char valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive chars to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code char} array
	 * @return a {@code Character} array, {@code null} if null array input
	 */
	public static Character[] toObject(final char[] array) {
		return ArrayUtils.toObject(array);
	}

	// Long array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Longs to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Long} array, may be {@code null}
	 * @return a {@code long} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static long[] toPrimitive(final Long[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Long to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Long} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code long} array, {@code null} if null array input
	 */
	public static long[] toPrimitive(final Long[] array, final long valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive longs to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code long} array
	 * @return a {@code Long} array, {@code null} if null array input
	 */
	public static Long[] toObject(final long[] array) {
		return ArrayUtils.toObject(array);
	}

	// Int array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Integers to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Integer} array, may be {@code null}
	 * @return an {@code int} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static int[] toPrimitive(final Integer[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Integer to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Integer} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return an {@code int} array, {@code null} if null array input
	 */
	public static int[] toPrimitive(final Integer[] array, final int valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive ints to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array an {@code int} array
	 * @return an {@code Integer} array, {@code null} if null array input
	 */
	public static Integer[] toObject(final int[] array) {
		return ArrayUtils.toObject(array);
	}

	// Short array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Shorts to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Short} array, may be {@code null}
	 * @return a {@code byte} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static short[] toPrimitive(final Short[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Short to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Short} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code byte} array, {@code null} if null array input
	 */
	public static short[] toPrimitive(final Short[] array, final short valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive shorts to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code short} array
	 * @return a {@code Short} array, {@code null} if null array input
	 */
	public static Short[] toObject(final short[] array) {
		return ArrayUtils.toObject(array);
	}

	// Byte array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Bytes to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Byte} array, may be {@code null}
	 * @return a {@code byte} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static byte[] toPrimitive(final Byte[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Bytes to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Byte} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code byte} array, {@code null} if null array input
	 */
	public static byte[] toPrimitive(final Byte[] array, final byte valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive bytes to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code byte} array
	 * @return a {@code Byte} array, {@code null} if null array input
	 */
	public static Byte[] toObject(final byte[] array) {
		return ArrayUtils.toObject(array);
	}

	// Double array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Doubles to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Double} array, may be {@code null}
	 * @return a {@code double} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static double[] toPrimitive(final Double[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Doubles to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Double} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code double} array, {@code null} if null array input
	 */
	public static double[] toPrimitive(final Double[] array, final double valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive doubles to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code double} array
	 * @return a {@code Double} array, {@code null} if null array input
	 */
	public static Double[] toObject(final double[] array) {
		return ArrayUtils.toObject(array);
	}

	// Float array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Floats to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Float} array, may be {@code null}
	 * @return a {@code float} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static float[] toPrimitive(final Float[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Floats to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Float} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code float} array, {@code null} if null array input
	 */
	public static float[] toPrimitive(final Float[] array, final float valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive floats to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code float} array
	 * @return a {@code Float} array, {@code null} if null array input
	 */
	public static Float[] toObject(final float[] array) {
		return ArrayUtils.toObject(array);
	}

	/**
	 * <p>
	 * Create an array of primitive type from an array of wrapper types.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array an array of wrapper object
	 * @return an array of the corresponding primitive type, or the original array
	 * @since 1.0
	 */
	public static Object toPrimitive(final Object array) {
		return ArrayUtils.toPrimitive(array);
	}

	// Boolean array converters
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts an array of object Booleans to primitives.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code Boolean} array, may be {@code null}
	 * @return a {@code boolean} array, {@code null} if null array input
	 * @throws NullPointerException if array content is {@code null}
	 */
	public static boolean[] toPrimitive(final Boolean[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * <p>
	 * Converts an array of object Booleans to primitives handling {@code null}.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array        a {@code Boolean} array, may be {@code null}
	 * @param valueForNull the value to insert if {@code null} found
	 * @return a {@code boolean} array, {@code null} if null array input
	 */
	public static boolean[] toPrimitive(final Boolean[] array, final boolean valueForNull) {
		return ArrayUtils.toPrimitive(array, valueForNull);
	}

	/**
	 * <p>
	 * Converts an array of primitive booleans to objects.
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 *
	 * @param array a {@code boolean} array
	 * @return a {@code Boolean} array, {@code null} if null array input
	 */
	public static Boolean[] toObject(final boolean[] array) {
		return ArrayUtils.toObject(array);
	}

	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an array of Objects is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final Object[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive longs is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final long[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive ints is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final int[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive shorts is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final short[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive chars is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final char[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final byte[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive doubles is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final double[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive floats is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final float[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive booleans is empty or {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 1.0
	 */
	public static boolean isEmpty(final boolean[] array) {
		return ArrayUtils.isEmpty(array);
	}

	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an array of Objects is not empty and not {@code null}.
	 *
	 * @param       <T> the component type of the array
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static <T> boolean isNotEmpty(final T[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive longs is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final long[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive ints is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final int[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive shorts is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final short[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive chars is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final char[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final byte[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive doubles is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final double[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive floats is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final float[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Checks if an array of primitive booleans is not empty and not {@code null}.
	 *
	 * @param array the array to test
	 * @return {@code true} if the array is not empty and not {@code null}
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final boolean[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(null, null)     = null
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * ArrayUtils.addAll([null], [null]) = [null, null]
	 * ArrayUtils.addAll(["a", "b", "c"], ["1", "2", "3"]) = ["a", "b", "c", "1", "2", "3"]
	 * </pre>
	 *
	 * @param        <T> the component type of the array
	 * @param array1 the first array whose elements are added to the new array, may
	 *               be {@code null}
	 * @param array2 the second array whose elements are added to the new array, may
	 *               be {@code null}
	 * @return The new array, {@code null} if both arrays are {@code null}. The type
	 *         of the new array is the type of the first array, unless the first
	 *         array is null, in which case the type is the same as the second
	 *         array.
	 * @since 1.0
	 * @throws IllegalArgumentException if the array types are incompatible
	 */
	@SafeVarargs
	public static <T> T[] addAll(final T[] array1, final T... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new boolean[] array.
	 * @since 1.0
	 */
	public static boolean[] addAll(final boolean[] array1, final boolean... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new char[] array.
	 * @since 1.0
	 */
	public static char[] addAll(final char[] array1, final char... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new byte[] array.
	 * @since 1.0
	 */
	public static byte[] addAll(final byte[] array1, final byte... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new short[] array.
	 * @since 1.0
	 */
	public static short[] addAll(final short[] array1, final short... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new int[] array.
	 * @since 1.0
	 */
	public static int[] addAll(final int[] array1, final int... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new long[] array.
	 * @since 1.0
	 */
	public static long[] addAll(final long[] array1, final long... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new float[] array.
	 * @since 1.0
	 */
	public static float[] addAll(final float[] array1, final float... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * <p>
	 * The new array contains all of the element of {@code array1} followed by all
	 * of the elements {@code array2}. When an array is returned, it is always a new
	 * array.
	 *
	 * <pre>
	 * ArrayUtils.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtils.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtils.addAll([], [])         = []
	 * </pre>
	 *
	 * @param array1 the first array whose elements are added to the new array.
	 * @param array2 the second array whose elements are added to the new array.
	 * @return The new double[] array.
	 * @since 1.0
	 */
	public static double[] addAll(final double[] array1, final double... array2) {
		return ArrayUtils.addAll(array1, array2);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element, unless the element itself is null,
	 * in which case the return type is Object[]
	 *
	 * <pre>
	 * ArrayUtils.add(null, null)      = IllegalArgumentException
	 * ArrayUtils.add(null, "a")       = ["a"]
	 * ArrayUtils.add(["a"], null)     = ["a", null]
	 * ArrayUtils.add(["a"], "b")      = ["a", "b"]
	 * ArrayUtils.add(["a", "b"], "c") = ["a", "b", "c"]
	 * </pre>
	 *
	 * @param         <T> the component type of the array
	 * @param array   the array to "add" the element to, may be {@code null}
	 * @param element the object to add, may be {@code null}
	 * @return A new array containing the existing elements plus the new element The
	 *         returned array type will be that of the input array (unless null), in
	 *         which case it will have the same type as the element. If both are
	 *         null, an IllegalArgumentException is thrown
	 * @since 1.0
	 * @throws IllegalArgumentException if both arguments are null
	 */
	public static <T> T[] add(final T[] array, final T element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, true)          = [true]
	 * ArrayUtils.add([true], false)       = [true, false]
	 * ArrayUtils.add([true, false], true) = [true, false, true]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static boolean[] add(final boolean[] array, final boolean element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static byte[] add(final byte[] array, final byte element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, '0')       = ['0']
	 * ArrayUtils.add(['1'], '0')      = ['1', '0']
	 * ArrayUtils.add(['1', '0'], '1') = ['1', '0', '1']
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static char[] add(final char[] array, final char element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static double[] add(final double[] array, final double element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static float[] add(final float[] array, final float element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static int[] add(final int[] array, final int element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static long[] add(final long[] array, final long element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 *
	 * <p>
	 * The new array contains the same elements of the input array plus the given
	 * element in the last position. The component type of the new array is the same
	 * as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0)   = [0]
	 * ArrayUtils.add([1], 0)    = [1, 0]
	 * ArrayUtils.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 *
	 * @param array   the array to copy and add the element to, may be {@code null}
	 * @param element the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 1.0
	 */
	public static short[] add(final short[] array, final short element) {
		return ArrayUtils.add(array, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0, null)      = IllegalArgumentException
	 * ArrayUtils.add(null, 0, "a")       = ["a"]
	 * ArrayUtils.add(["a"], 1, null)     = ["a", null]
	 * ArrayUtils.add(["a"], 1, "b")      = ["a", "b"]
	 * ArrayUtils.add(["a", "b"], 3, "c") = ["a", "b", "c"]
	 * </pre>
	 *
	 * @param         <T> the component type of the array
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @throws IllegalArgumentException  if both array and element are null
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, Object[], Object...) insert(int, T[], T...)}
	 *             and may be removed in a future release. Please note the handling
	 *             of {@code null} input arrays differs in the new method: inserting
	 *             {@code X} into a {@code null} array results in {@code null} not
	 *             {@code X}.
	 */
	@Deprecated
	public static <T> T[] add(final T[] array, final int index, final T element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0, true)          = [true]
	 * ArrayUtils.add([true], 0, false)       = [false, true]
	 * ArrayUtils.add([false], 1, true)       = [false, true]
	 * ArrayUtils.add([true, false], 1, true) = [true, true, false]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, boolean[], boolean...)} and may be removed in
	 *             a future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static boolean[] add(final boolean[] array, final int index, final boolean element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add(null, 0, 'a')            = ['a']
	 * ArrayUtils.add(['a'], 0, 'b')           = ['b', 'a']
	 * ArrayUtils.add(['a', 'b'], 0, 'c')      = ['c', 'a', 'b']
	 * ArrayUtils.add(['a', 'b'], 1, 'k')      = ['a', 'k', 'b']
	 * ArrayUtils.add(['a', 'b', 'c'], 1, 't') = ['a', 't', 'b', 'c']
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, char[], char...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static char[] add(final char[] array, final int index, final char element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1], 0, 2)         = [2, 1]
	 * ArrayUtils.add([2, 6], 2, 3)      = [2, 6, 3]
	 * ArrayUtils.add([2, 6], 0, 1)      = [1, 2, 6]
	 * ArrayUtils.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, byte[], byte...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static byte[] add(final byte[] array, final int index, final byte element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1], 0, 2)         = [2, 1]
	 * ArrayUtils.add([2, 6], 2, 10)     = [2, 6, 10]
	 * ArrayUtils.add([2, 6], 0, -4)     = [-4, 2, 6]
	 * ArrayUtils.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, short[], short...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static short[] add(final short[] array, final int index, final short element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1], 0, 2)         = [2, 1]
	 * ArrayUtils.add([2, 6], 2, 10)     = [2, 6, 10]
	 * ArrayUtils.add([2, 6], 0, -4)     = [-4, 2, 6]
	 * ArrayUtils.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, int[], int...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static int[] add(final int[] array, final int index, final int element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1L], 0, 2L)           = [2L, 1L]
	 * ArrayUtils.add([2L, 6L], 2, 10L)      = [2L, 6L, 10L]
	 * ArrayUtils.add([2L, 6L], 0, -4L)      = [-4L, 2L, 6L]
	 * ArrayUtils.add([2L, 6L, 3L], 2, 1L)   = [2L, 6L, 1L, 3L]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, long[], long...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static long[] add(final long[] array, final int index, final long element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1.1f], 0, 2.2f)               = [2.2f, 1.1f]
	 * ArrayUtils.add([2.3f, 6.4f], 2, 10.5f)        = [2.3f, 6.4f, 10.5f]
	 * ArrayUtils.add([2.6f, 6.7f], 0, -4.8f)        = [-4.8f, 2.6f, 6.7f]
	 * ArrayUtils.add([2.9f, 6.0f, 0.3f], 2, 1.0f)   = [2.9f, 6.0f, 1.0f, 0.3f]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, float[], float...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static float[] add(final float[] array, final int index, final float element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, a new one element array is returned whose
	 * component type is the same as the element.
	 *
	 * <pre>
	 * ArrayUtils.add([1.1], 0, 2.2)              = [2.2, 1.1]
	 * ArrayUtils.add([2.3, 6.4], 2, 10.5)        = [2.3, 6.4, 10.5]
	 * ArrayUtils.add([2.6, 6.7], 0, -4.8)        = [-4.8, 2.6, 6.7]
	 * ArrayUtils.add([2.9, 6.0, 0.3], 2, 1.0)    = [2.9, 6.0, 1.0, 0.3]
	 * </pre>
	 *
	 * @param array   the array to add the element to, may be {@code null}
	 * @param index   the position of the new object
	 * @param element the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt; array.length).
	 * @deprecated this method has been superseded by
	 *             {@link #insert(int, double[], double...)} and may be removed in a
	 *             future release. Please note the handling of {@code null} input
	 *             arrays differs in the new method: inserting {@code X} into a
	 *             {@code null} array results in {@code null} not {@code X}.
	 */
	@Deprecated
	public static double[] add(final double[] array, final int index, final double element) {
		return ArrayUtils.add(array, index, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove(["a"], 0)           = []
	 * ArrayUtils.remove(["a", "b"], 0)      = ["b"]
	 * ArrayUtils.remove(["a", "b"], 1)      = ["a"]
	 * ArrayUtils.remove(["a", "b", "c"], 1) = ["a", "c"]
	 * </pre>
	 *
	 * @param       <T> the component type of the array
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	// @SuppressWarnings("unchecked") // remove() always creates an array of the
	// same type as its input
	public static <T> T[] remove(final T[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, "a")            = null
	 * ArrayUtils.removeElement([], "a")              = []
	 * ArrayUtils.removeElement(["a"], "b")           = ["a"]
	 * ArrayUtils.removeElement(["a", "b"], "a")      = ["b"]
	 * ArrayUtils.removeElement(["a", "b", "a"], "a") = ["b", "a"]
	 * </pre>
	 *
	 * @param         <T> the component type of the array
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static <T> T[] removeElement(final T[] array, final Object element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([true], 0)              = []
	 * ArrayUtils.remove([true, false], 0)       = [false]
	 * ArrayUtils.remove([true, false], 1)       = [true]
	 * ArrayUtils.remove([true, true, false], 1) = [true, false]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static boolean[] remove(final boolean[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, true)                = null
	 * ArrayUtils.removeElement([], true)                  = []
	 * ArrayUtils.removeElement([true], false)             = [true]
	 * ArrayUtils.removeElement([true, false], false)      = [true]
	 * ArrayUtils.removeElement([true, false, true], true) = [false, true]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static boolean[] removeElement(final boolean[] array, final boolean element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1], 0)          = []
	 * ArrayUtils.remove([1, 0], 0)       = [0]
	 * ArrayUtils.remove([1, 0], 1)       = [1]
	 * ArrayUtils.remove([1, 0, 1], 1)    = [1, 1]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static byte[] remove(final byte[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1)        = null
	 * ArrayUtils.removeElement([], 1)          = []
	 * ArrayUtils.removeElement([1], 0)         = [1]
	 * ArrayUtils.removeElement([1, 0], 0)      = [1]
	 * ArrayUtils.removeElement([1, 0, 1], 1)   = [0, 1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static byte[] removeElement(final byte[] array, final byte element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove(['a'], 0)           = []
	 * ArrayUtils.remove(['a', 'b'], 0)      = ['b']
	 * ArrayUtils.remove(['a', 'b'], 1)      = ['a']
	 * ArrayUtils.remove(['a', 'b', 'c'], 1) = ['a', 'c']
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static char[] remove(final char[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 'a')            = null
	 * ArrayUtils.removeElement([], 'a')              = []
	 * ArrayUtils.removeElement(['a'], 'b')           = ['a']
	 * ArrayUtils.removeElement(['a', 'b'], 'a')      = ['b']
	 * ArrayUtils.removeElement(['a', 'b', 'a'], 'a') = ['b', 'a']
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static char[] removeElement(final char[] array, final char element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1.1], 0)           = []
	 * ArrayUtils.remove([1.0, 6.0], 0)      = [6.0]
	 * ArrayUtils.remove([1.0, 6.0], 1)      = [1.0]
	 * ArrayUtils.remove([1.0, 6.0, 3.8], 1) = [1.0, 3.8]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static double[] remove(final double[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1.1)            = null
	 * ArrayUtils.removeElement([], 1.1)              = []
	 * ArrayUtils.removeElement([1.1], 1.2)           = [1.1]
	 * ArrayUtils.removeElement([1.1, 2.3], 1.1)      = [2.3]
	 * ArrayUtils.removeElement([1.1, 2.3, 1.1], 1.1) = [2.3, 1.1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static double[] removeElement(final double[] array, final double element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1.1], 0)           = []
	 * ArrayUtils.remove([1.0, 6.0], 0)      = [6.0]
	 * ArrayUtils.remove([1.0, 6.0], 1)      = [1.0]
	 * ArrayUtils.remove([1.0, 6.0, 3.8], 1) = [1.0, 3.8]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static float[] remove(final float[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1.1)            = null
	 * ArrayUtils.removeElement([], 1.1)              = []
	 * ArrayUtils.removeElement([1.1], 1.2)           = [1.1]
	 * ArrayUtils.removeElement([1.1, 2.3], 1.1)      = [2.3]
	 * ArrayUtils.removeElement([1.1, 2.3, 1.1], 1.1) = [2.3, 1.1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static float[] removeElement(final float[] array, final float element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1], 0)         = []
	 * ArrayUtils.remove([2, 6], 0)      = [6]
	 * ArrayUtils.remove([2, 6], 1)      = [2]
	 * ArrayUtils.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static int[] remove(final int[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1)      = null
	 * ArrayUtils.removeElement([], 1)        = []
	 * ArrayUtils.removeElement([1], 2)       = [1]
	 * ArrayUtils.removeElement([1, 3], 1)    = [3]
	 * ArrayUtils.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static int[] removeElement(final int[] array, final int element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1], 0)         = []
	 * ArrayUtils.remove([2, 6], 0)      = [6]
	 * ArrayUtils.remove([2, 6], 1)      = [2]
	 * ArrayUtils.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static long[] remove(final long[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1)      = null
	 * ArrayUtils.removeElement([], 1)        = []
	 * ArrayUtils.removeElement([1], 2)       = [1]
	 * ArrayUtils.removeElement([1, 3], 1)    = [3]
	 * ArrayUtils.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static long[] removeElement(final long[] array, final long element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array. All
	 * subsequent elements are shifted to the left (subtracts one from their
	 * indices).
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.remove([1], 0)         = []
	 * ArrayUtils.remove([2, 6], 0)      = [6]
	 * ArrayUtils.remove([2, 6], 1)      = [2]
	 * ArrayUtils.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 *
	 * @param array the array to remove the element from, may not be {@code null}
	 * @param index the position of the element to be removed
	 * @return A new array containing the existing elements except the element at
	 *         the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static short[] remove(final short[] array, final int index) {
		return ArrayUtils.remove(array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (subtracts one from
	 * their indices). If the array doesn't contains such an element, no elements
	 * are removed from the array.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type of
	 * the returned array is always the same as that of the input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElement(null, 1)      = null
	 * ArrayUtils.removeElement([], 1)        = []
	 * ArrayUtils.removeElement([1], 2)       = [1]
	 * ArrayUtils.removeElement([1, 3], 1)    = [3]
	 * ArrayUtils.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may be {@code null}
	 * @param element the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 1.0
	 */
	public static short[] removeElement(final short[] array, final short element) {
		return ArrayUtils.removeElement(array, element);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll(["a", "b", "c"], 0, 2) = ["b"]
	 * ArrayUtils.removeAll(["a", "b", "c"], 1, 2) = ["a"]
	 * </pre>
	 *
	 * @param         <T> the component type of the array
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	// @SuppressWarnings("unchecked") // removeAll() always creates an array of the
	// same type as its input
	public static <T> T[] removeAll(final T[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, "a", "b")            = null
	 * ArrayUtils.removeElements([], "a", "b")              = []
	 * ArrayUtils.removeElements(["a"], "b", "c")           = ["a"]
	 * ArrayUtils.removeElements(["a", "b"], "a", "c")      = ["b"]
	 * ArrayUtils.removeElements(["a", "b", "a"], "a")      = ["b", "a"]
	 * ArrayUtils.removeElements(["a", "b", "a"], "a", "a") = ["b"]
	 * </pre>
	 *
	 * @param        <T> the component type of the array
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T[] removeElements(final T[] array, final T... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static byte[] removeAll(final byte[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static byte[] removeElements(final byte[] array, final byte... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static short[] removeAll(final short[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static short[] removeElements(final short[] array, final short... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static int[] removeAll(final int[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static int[] removeElements(final int[] array, final int... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static char[] removeAll(final char[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static char[] removeElements(final char[] array, final char... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static long[] removeAll(final long[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static long[] removeElements(final long[] array, final long... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static float[] removeAll(final float[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static float[] removeElements(final float[] array, final float... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([1], 0)             = []
	 * ArrayUtils.removeAll([2, 6], 0)          = [6]
	 * ArrayUtils.removeAll([2, 6], 0, 1)       = []
	 * ArrayUtils.removeAll([2, 6, 3], 1, 2)    = [2]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 2)    = [6]
	 * ArrayUtils.removeAll([2, 6, 3], 0, 1, 2) = []
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static double[] removeAll(final double[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, 1, 2)      = null
	 * ArrayUtils.removeElements([], 1, 2)        = []
	 * ArrayUtils.removeElements([1], 2, 3)       = [1]
	 * ArrayUtils.removeElements([1, 3], 1, 2)    = [3]
	 * ArrayUtils.removeElements([1, 3, 1], 1)    = [3, 1]
	 * ArrayUtils.removeElements([1, 3, 1], 1, 1) = [3]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static double[] removeElements(final double[] array, final double... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * Removes the elements at the specified positions from the specified array. All
	 * remaining elements are shifted to the left.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except those at the specified positions. The component type of the returned
	 * array is always the same as that of the input array.
	 *
	 * <p>
	 * If the input array is {@code null}, an IndexOutOfBoundsException will be
	 * thrown, because in that case no valid index can be specified.
	 *
	 * <pre>
	 * ArrayUtils.removeAll([true, false, true], 0, 2) = [false]
	 * ArrayUtils.removeAll([true, false, true], 1, 2) = [true]
	 * </pre>
	 *
	 * @param array   the array to remove the element from, may not be {@code null}
	 * @param indices the positions of the elements to be removed
	 * @return A new array containing the existing elements except those at the
	 *         specified positions.
	 * @throws IndexOutOfBoundsException if any index is out of range (index &lt; 0
	 *                                   || index &gt;= array.length), or if the
	 *                                   array is {@code null}.
	 * @since 1.0
	 */
	public static boolean[] removeAll(final boolean[] array, final int... indices) {
		return ArrayUtils.removeAll(array, indices);
	}

	/**
	 * <p>
	 * Removes occurrences of specified elements, in specified quantities, from the
	 * specified array. All subsequent elements are shifted left. For any
	 * element-to-be-removed specified in greater quantities than contained in the
	 * original array, no change occurs beyond the removal of the existing matching
	 * items.
	 *
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except for the earliest-encountered occurrences of the specified elements.
	 * The component type of the returned array is always the same as that of the
	 * input array.
	 *
	 * <pre>
	 * ArrayUtils.removeElements(null, true, false)               = null
	 * ArrayUtils.removeElements([], true, false)                 = []
	 * ArrayUtils.removeElements([true], false, false)            = [true]
	 * ArrayUtils.removeElements([true, false], true, true)       = [false]
	 * ArrayUtils.removeElements([true, false, true], true)       = [false, true]
	 * ArrayUtils.removeElements([true, false, true], true, true) = [false]
	 * </pre>
	 *
	 * @param array  the array to remove the element from, may be {@code null}
	 * @param values the elements to be removed
	 * @return A new array containing the existing elements except the
	 *         earliest-encountered occurrences of the specified elements.
	 * @since 1.0
	 */
	public static boolean[] removeElements(final boolean[] array, final boolean... values) {
		return ArrayUtils.removeElements(array, values);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to the
	 * provided {@code Comparator}.
	 *
	 * @param array      the array to check
	 * @param comparator the {@code Comparator} to compare over
	 * @param            <T> the datatype of the array
	 * @return whether the array is sorted
	 * @since 1.0
	 */
	public static <T> boolean isSorted(final T[] array, final Comparator<T> comparator) {
		return ArrayUtils.isSorted(array, comparator);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final int[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final long[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final short[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final double[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final float[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final byte[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering.
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final char[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * <p>
	 * This method checks whether the provided array is sorted according to natural
	 * ordering ({@code false} before {@code true}).
	 *
	 * @param array the array to check
	 * @return whether the array is sorted according to natural ordering
	 * @since 1.0
	 */
	public static boolean isSorted(final boolean[] array) {
		return ArrayUtils.isSorted(array);
	}

	/**
	 * Removes the occurrences of the specified element from the specified boolean
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static boolean[] removeAllOccurences(final boolean[] array, final boolean element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified char
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static char[] removeAllOccurences(final char[] array, final char element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified byte
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static byte[] removeAllOccurences(final byte[] array, final byte element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified short
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static short[] removeAllOccurences(final short[] array, final short element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified int
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static int[] removeAllOccurences(final int[] array, final int element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified long
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static long[] removeAllOccurences(final long[] array, final long element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified float
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static float[] removeAllOccurences(final float[] array, final float element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified double
	 * array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static double[] removeAllOccurences(final double[] array, final double element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * Removes the occurrences of the specified element from the specified array.
	 *
	 * <p>
	 * All subsequent elements are shifted to the left (subtracts one from their
	 * indices). If the array doesn't contains such an element, no elements are
	 * removed from the array. <code>null</code> will be returned if the input array
	 * is <code>null</code>.
	 * </p>
	 *
	 * @param         <T> the type of object in the array
	 * @param element the element to remove
	 * @param array   the input array
	 *
	 * @return A new array containing the existing elements except the occurrences
	 *         of the specified element.
	 * @since 1.0
	 */
	@SuppressWarnings("deprecation")
	public static <T> T[] removeAllOccurences(final T[] array, final T element) {
		return ArrayUtils.removeAllOccurences(array, element);
	}

	/**
	 * <p>
	 * Returns an array containing the string representation of each element in the
	 * argument array.
	 * </p>
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 * </p>
	 *
	 * @param array the {@code Object[]} to be processed, may be null
	 * @return {@code String[]} of the same size as the source with its element's
	 *         string representation, {@code null} if null array input
	 * @throws NullPointerException if array contains {@code null}
	 * @since 1.0
	 */
	public static String[] toStringArray(final Object[] array) {
		return ArrayUtils.toStringArray(array);
	}

	/**
	 * <p>
	 * Returns an array containing the string representation of each element in the
	 * argument array handling {@code null} elements.
	 * </p>
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 * </p>
	 *
	 * @param array                the Object[] to be processed, may be null
	 * @param valueForNullElements the value to insert if {@code null} is found
	 * @return a {@code String} array, {@code null} if null array input
	 * @since 1.0
	 */
	public static String[] toStringArray(final Object[] array, final String valueForNullElements) {
		return ArrayUtils.toStringArray(array, valueForNullElements);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static boolean[] insert(final int index, final boolean[] array, final boolean... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static byte[] insert(final int index, final byte[] array, final byte... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static char[] insert(final int index, final char[] array, final char... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static double[] insert(final int index, final double[] array, final double... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static float[] insert(final int index, final float[] array, final float... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static int[] insert(final int index, final int[] array, final int... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static long[] insert(final int index, final long[] array, final long... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	public static short[] insert(final int index, final short[] array, final short... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * <p>
	 * Inserts elements into an array at the given index (starting from zero).
	 * </p>
	 *
	 * <p>
	 * When an array is returned, it is always a new array.
	 * </p>
	 *
	 * <pre>
	 * ArrayUtils.insert(index, null, null)      = null
	 * ArrayUtils.insert(index, array, null)     = cloned copy of 'array'
	 * ArrayUtils.insert(index, null, values)    = null
	 * </pre>
	 *
	 * @param        <T> The type of elements in {@code array} and {@code values}
	 * @param index  the position within {@code array} to insert the new values
	 * @param array  the array to insert the values into, may be {@code null}
	 * @param values the new values to insert, may be {@code null}
	 * @return The new array.
	 * @throws IndexOutOfBoundsException if {@code array} is provided and either
	 *                                   {@code index < 0} or
	 *                                   {@code index > array.length}
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T[] insert(final int index, final T[] array, final T... values) {
		return ArrayUtils.insert(index, array, values);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final Object[] array, final Random random) {
		ArrayUtils.shuffle(array, random);

	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final boolean[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final boolean[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final byte[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final byte[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final char[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final char[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final short[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final short[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final int[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final int[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final long[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final long[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final float[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final float[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array the array to shuffle
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final double[] array) {
		ArrayUtils.shuffle(array);
	}

	/**
	 * Randomly permutes the elements of the specified array using the Fisher-Yates
	 * algorithm.
	 *
	 * @param array  the array to shuffle
	 * @param random the source of randomness used to permute the elements
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates
	 *      shuffle algorithm</a>
	 * @since 1.0
	 */
	public static void shuffle(final double[] array, final Random random) {
		ArrayUtils.shuffle(array, random);
	}

	/**
	 * Returns whether a given array can safely be accessed at the given index.
	 * 
	 * @param       <T> the component type of the array
	 * @param array the array to inspect, may be null
	 * @param index the index of the array to be inspected
	 * @return Whether the given index is safely-accessible in the given array
	 * @since 1.0
	 */
	public static <T> boolean isArrayIndexValid(T[] array, int index) {
		return ArrayUtils.isArrayIndexValid(array, index);
	}
}
