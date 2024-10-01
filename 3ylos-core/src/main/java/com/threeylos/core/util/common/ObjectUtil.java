package com.threeylos.core.util.common;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.CloneFailedException;

/**
 * <p>
 * Operations on {@code Object}.
 * </p>
 *
 * <p>
 * This class tries to handle {@code null} input gracefully. An exception will
 * generally not be thrown for a {@code null} input. Each method documents its
 * behaviour in more detail.
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
//@Immutable

public class ObjectUtil {

	/**
	 * <p>
	 * {@code ObjectUtils} instances should NOT be constructed in standard
	 * programming. Instead, the static methods on the class should be used, such as
	 * {@code ObjectUtils.defaultIfNull("a","b");}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public ObjectUtil() {
		super();
	}

	// Empty checks
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an Object is empty or null.
	 * </p>
	 *
	 * The following types are supported:
	 * <ul>
	 * <li>{@link CharSequence}: Considered empty if its length is zero.</li>
	 * <li>{@code Array}: Considered empty if its length is zero.</li>
	 * <li>{@link Collection}: Considered empty if it has zero elements.</li>
	 * <li>{@link Map}: Considered empty if it has zero key-value mappings.</li>
	 * </ul>
	 *
	 * <pre>
	 * ObjectUtils.isEmpty(null)             = true
	 * ObjectUtils.isEmpty("")               = true
	 * ObjectUtils.isEmpty("ab")             = false
	 * ObjectUtils.isEmpty(new int[]{})      = true
	 * ObjectUtils.isEmpty(new int[]{1,2,3}) = false
	 * ObjectUtils.isEmpty(1234)             = false
	 * </pre>
	 *
	 * @param object the {@code Object} to test, may be {@code null}
	 * @return {@code true} if the object has a supported type and is empty or null,
	 *         {@code false} otherwise
	 * @since 1.0
	 */
	public static boolean isEmpty(final Object object) {
		return ObjectUtils.isEmpty(object);

	}

	/**
	 * <p>
	 * Checks if an Object is not empty and not null.
	 * </p>
	 *
	 * The following types are supported:
	 * <ul>
	 * <li>{@link CharSequence}: Considered empty if its length is zero.</li>
	 * <li>{@code Array}: Considered empty if its length is zero.</li>
	 * <li>{@link Collection}: Considered empty if it has zero elements.</li>
	 * <li>{@link Map}: Considered empty if it has zero key-value mappings.</li>
	 * </ul>
	 *
	 * <pre>
	 * ObjectUtils.isNotEmpty(null)             = false
	 * ObjectUtils.isNotEmpty("")               = false
	 * ObjectUtils.isNotEmpty("ab")             = true
	 * ObjectUtils.isNotEmpty(new int[]{})      = false
	 * ObjectUtils.isNotEmpty(new int[]{1,2,3}) = true
	 * ObjectUtils.isNotEmpty(1234)             = true
	 * </pre>
	 *
	 * @param object the {@code Object} to test, may be {@code null}
	 * @return {@code true} if the object has an unsupported type or is not empty
	 *         and not null, {@code false} otherwise
	 * @since 1.0
	 */
	public static boolean isNotEmpty(final Object object) {
		return ObjectUtils.isNotEmpty(object);
	}

	// Defaulting
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns a default value if the object passed is {@code null}.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.defaultIfNull(null, null)      = null
	 * ObjectUtils.defaultIfNull(null, "")        = ""
	 * ObjectUtils.defaultIfNull(null, "zz")      = "zz"
	 * ObjectUtils.defaultIfNull("abc", *)        = "abc"
	 * ObjectUtils.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
	 * </pre>
	 *
	 * @param              <T> the type of the object
	 * @param object       the {@code Object} to test, may be {@code null}
	 * @param defaultValue the default value to return, may be {@code null}
	 * @return {@code object} if it is not {@code null}, defaultValue otherwise
	 */
	public static <T> T defaultIfNull(final T object, final T defaultValue) {
		return ObjectUtils.defaultIfNull(object, defaultValue);
	}

	/**
	 * <p>
	 * Returns the first value in the array which is not {@code null}. If all the
	 * values are {@code null} or the array is {@code null} or empty then
	 * {@code null} is returned.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.firstNonNull(null, null)      = null
	 * ObjectUtils.firstNonNull(null, "")        = ""
	 * ObjectUtils.firstNonNull(null, null, "")  = ""
	 * ObjectUtils.firstNonNull(null, "zz")      = "zz"
	 * ObjectUtils.firstNonNull("abc", *)        = "abc"
	 * ObjectUtils.firstNonNull(null, "xyz", *)  = "xyz"
	 * ObjectUtils.firstNonNull(Boolean.TRUE, *) = Boolean.TRUE
	 * ObjectUtils.firstNonNull()                = null
	 * </pre>
	 *
	 * @param        <T> the component type of the array
	 * @param values the values to test, may be {@code null} or empty
	 * @return the first value from {@code values} which is not {@code null}, or
	 *         {@code null} if there are no non-null values
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T firstNonNull(final T... values) {
		return ObjectUtils.firstNonNull(values);
	}

	/**
	 * Checks if any value in the given array is not {@code null}.
	 *
	 * <p>
	 * If all the values are {@code null} or the array is {@code null} or empty then
	 * {@code false} is returned. Otherwise {@code true} is returned.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.anyNotNull(*)                = true
	 * ObjectUtils.anyNotNull(*, null)          = true
	 * ObjectUtils.anyNotNull(null, *)          = true
	 * ObjectUtils.anyNotNull(null, null, *, *) = true
	 * ObjectUtils.anyNotNull(null)             = false
	 * ObjectUtils.anyNotNull(null, null)       = false
	 * </pre>
	 *
	 * @param values the values to test, may be {@code null} or empty
	 * @return {@code true} if there is at least one non-null value in the array,
	 *         {@code false} if all values in the array are {@code null}s. If the
	 *         array is {@code null} or empty {@code false} is also returned.
	 * @since 1.0
	 */
	public static boolean anyNotNull(final Object... values) {
		return ObjectUtils.anyNotNull(values);
	}

	/**
	 * Checks if all values in the array are not {@code nulls}.
	 *
	 * <p>
	 * If any value is {@code null} or the array is {@code null} then {@code false}
	 * is returned. If all elements in array are not {@code null} or the array is
	 * empty (contains no elements) {@code true} is returned.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.allNotNull(*)             = true
	 * ObjectUtils.allNotNull(*, *)          = true
	 * ObjectUtils.allNotNull(null)          = false
	 * ObjectUtils.allNotNull(null, null)    = false
	 * ObjectUtils.allNotNull(null, *)       = false
	 * ObjectUtils.allNotNull(*, null)       = false
	 * ObjectUtils.allNotNull(*, *, null, *) = false
	 * </pre>
	 *
	 * @param values the values to test, may be {@code null} or empty
	 * @return {@code false} if there is at least one {@code null} value in the
	 *         array or the array is {@code null}, {@code true} if all values in the
	 *         array are not {@code null}s or array contains no elements.
	 * @since 1.0
	 */
	public static boolean allNotNull(final Object... values) {
		return ObjectUtils.allNotNull(values);
	}

	// Null-safe equals/hashCode
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compares two objects for equality, where either one or both objects may be
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.equals(null, null)                  = true
	 * ObjectUtils.equals(null, "")                    = false
	 * ObjectUtils.equals("", null)                    = false
	 * ObjectUtils.equals("", "")                      = true
	 * ObjectUtils.equals(Boolean.TRUE, null)          = false
	 * ObjectUtils.equals(Boolean.TRUE, "true")        = false
	 * ObjectUtils.equals(Boolean.TRUE, Boolean.TRUE)  = true
	 * ObjectUtils.equals(Boolean.TRUE, Boolean.FALSE) = false
	 * </pre>
	 *
	 * @param object1 the first object, may be {@code null}
	 * @param object2 the second object, may be {@code null}
	 * @return {@code true} if the values of both objects are the same
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.equals(Object, Object)} in Java 7 and
	 *             will be removed from future releases.
	 */
	@Deprecated
	public static boolean equals(final Object object1, final Object object2) {
		return ObjectUtils.equals(object1, object2);
	}

	/**
	 * <p>
	 * Compares two objects for inequality, where either one or both objects may be
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.notEqual(null, null)                  = false
	 * ObjectUtils.notEqual(null, "")                    = true
	 * ObjectUtils.notEqual("", null)                    = true
	 * ObjectUtils.notEqual("", "")                      = false
	 * ObjectUtils.notEqual(Boolean.TRUE, null)          = true
	 * ObjectUtils.notEqual(Boolean.TRUE, "true")        = true
	 * ObjectUtils.notEqual(Boolean.TRUE, Boolean.TRUE)  = false
	 * ObjectUtils.notEqual(Boolean.TRUE, Boolean.FALSE) = true
	 * </pre>
	 *
	 * @param object1 the first object, may be {@code null}
	 * @param object2 the second object, may be {@code null}
	 * @return {@code false} if the values of both objects are the same
	 */
	public static boolean notEqual(final Object object1, final Object object2) {
		return ObjectUtils.notEqual(object1, object2);
	}

	/**
	 * <p>
	 * Gets the hash code of an object returning zero when the object is
	 * {@code null}.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.hashCode(null)   = 0
	 * ObjectUtils.hashCode(obj)    = obj.hashCode()
	 * </pre>
	 *
	 * @param obj the object to obtain the hash code of, may be {@code null}
	 * @return the hash code of the object, or zero if null
	 * @since 2.1
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.hashCode(Object)} in Java 7 and will be
	 *             removed in future releases
	 */
	@Deprecated
	public static int hashCode(final Object obj) {
		return ObjectUtils.hashCode(obj);
	}

	/**
	 * <p>
	 * Gets the hash code for multiple objects.
	 * </p>
	 *
	 * <p>
	 * This allows a hash code to be rapidly calculated for a number of objects. The
	 * hash code for a single object is the <em>not</em> same as
	 * {@link #hashCode(Object)}. The hash code for multiple objects is the same as
	 * that calculated by an {@code ArrayList} containing the specified objects.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.hashCodeMulti()                 = 1
	 * ObjectUtils.hashCodeMulti((Object[]) null)  = 1
	 * ObjectUtils.hashCodeMulti(a)                = 31 + a.hashCode()
	 * ObjectUtils.hashCodeMulti(a,b)              = (31 + a.hashCode()) * 31 + b.hashCode()
	 * ObjectUtils.hashCodeMulti(a,b,c)            = ((31 + a.hashCode()) * 31 + b.hashCode()) * 31 + c.hashCode()
	 * </pre>
	 *
	 * @param objects the objects to obtain the hash code of, may be {@code null}
	 * @return the hash code of the objects, or zero if null
	 * @since 3.0
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.hash(Object...)} in Java 7 and will be
	 *             removed in future releases.
	 */
	@Deprecated
	public static int hashCodeMulti(final Object... objects) {
		return ObjectUtils.hashCodeMulti(objects);
	}

	// Identity ToString
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the toString that would be produced by {@code Object} if a class did not
	 * override toString itself. {@code null} will return {@code null}.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.identityToString(null)         = null
	 * ObjectUtils.identityToString("")           = "java.lang.String@1e23"
	 * ObjectUtils.identityToString(Boolean.TRUE) = "java.lang.Boolean@7fa"
	 * </pre>
	 *
	 * @param object the object to create a toString for, may be {@code null}
	 * @return the default toString text, or {@code null} if {@code null} passed in
	 */
	public static String identityToString(final Object object) {
		return ObjectUtils.identityToString(object);
	}

	// ToString
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the {@code toString} of an {@code Object} returning an empty string ("")
	 * if {@code null} input.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null)         = ""
	 * ObjectUtils.toString("")           = ""
	 * ObjectUtils.toString("bat")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE) = "true"
	 * </pre>
	 *
	 * @see StringUtils#defaultString(String)
	 * @see String#valueOf(Object)
	 * @param obj the Object to {@code toString}, may be null
	 * @return the passed in Object's toString, or {@code ""} if {@code null} input
	 * @since 1.0
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.toString(Object)} in Java 7 and will be
	 *             removed in future releases. Note however that said method will
	 *             return "null" for null references, while this method returns an
	 *             empty String. To preserve behavior use
	 *             {@code java.util.Objects.toString(myObject, "")}
	 */
	@Deprecated
	public static String toString(final Object obj) {
		return ObjectUtils.toString(obj);
	}

	/**
	 * <p>
	 * Gets the {@code toString} of an {@code Object} returning a specified text if
	 * {@code null} input.
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null, null)           = null
	 * ObjectUtils.toString(null, "null")         = "null"
	 * ObjectUtils.toString("", "null")           = ""
	 * ObjectUtils.toString("bat", "null")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE, "null") = "true"
	 * </pre>
	 *
	 * @see StringUtils#defaultString(String,String)
	 * @see String#valueOf(Object)
	 * @param obj     the Object to {@code toString}, may be null
	 * @param nullStr the String to return if {@code null} input, may be null
	 * @return the passed in Object's toString, or {@code nullStr} if {@code null}
	 *         input
	 * @since 1.0
	 * @deprecated this method has been replaced by
	 *             {@code java.util.Objects.toString(Object, String)} in Java 7 and
	 *             will be removed in future releases.
	 */
	@Deprecated
	public static String toString(final Object obj, final String nullStr) {
		return ObjectUtils.toString(obj, nullStr);
	}

	/**
	 * <p>
	 * Null safe comparison of Comparables.
	 * </p>
	 *
	 * @param             <T> type of the values processed by this method
	 * @param c1          the first comparable, may be null
	 * @param c2          the second comparable, may be null
	 * @param nullGreater if true {@code null} is considered greater than a
	 *                    non-{@code null} value or if false {@code null} is
	 *                    considered less than a Non-{@code null} value
	 * @return a negative value if c1 &lt; c2, zero if c1 = c2 and a positive value
	 *         if c1 &gt; c2
	 * @see java.util.Comparator#compare(Object, Object)
	 */
	public static <T extends Comparable<? super T>> int compare(final T c1, final T c2, final boolean nullGreater) {
		return ObjectUtils.compare(c1, c2, nullGreater);
	}

	/**
	 * Find the "best guess" middle value among comparables. If there is an even
	 * number of total values, the lower of the two middle values will be returned.
	 * 
	 * @param       <T> type of values processed by this method
	 * @param items to compare
	 * @return T at middle position
	 * @throws NullPointerException     if items is {@code null}
	 * @throws IllegalArgumentException if items is empty or contains {@code null}
	 *                                  values
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T extends Comparable<? super T>> T median(final T... items) {
		return ObjectUtils.median(items);
	}

	/**
	 * Find the "best guess" middle value among comparables. If there is an even
	 * number of total values, the lower of the two middle values will be returned.
	 * 
	 * @param            <T> type of values processed by this method
	 * @param comparator to use for comparisons
	 * @param items      to compare
	 * @return T at middle position
	 * @throws NullPointerException     if items or comparator is {@code null}
	 * @throws IllegalArgumentException if items is empty or contains {@code null}
	 *                                  values
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T median(final Comparator<T> comparator, final T... items) {
		return ObjectUtils.median(comparator, items);
	}

	// Mode
	// -----------------------------------------------------------------------
	/**
	 * Find the most frequently occurring item.
	 *
	 * @param       <T> type of values processed by this method
	 * @param items to check
	 * @return most populous T, {@code null} if non-unique or no items supplied
	 * @since 1.0
	 */
	@SafeVarargs
	public static <T> T mode(final T... items) {
		return ObjectUtils.mode(items);
	}

	// cloning
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Clone an object.
	 * </p>
	 *
	 * @param     <T> the type of the object
	 * @param obj the object to clone, null returns null
	 * @return the clone if the object implements {@link Cloneable} otherwise
	 *         {@code null}
	 * @throws CloneFailedException if the object is cloneable and the clone
	 *                              operation fails
	 * @since 1.0
	 */
	public static <T> T clone(final T obj) {
		return ObjectUtils.clone(obj);
	}

	/**
	 * <p>
	 * Clone an object if possible.
	 * </p>
	 *
	 * <p>
	 * This method is similar to {@link #clone(Object)}, but will return the
	 * provided instance as the return value instead of {@code null} if the instance
	 * is not cloneable. This is more convenient if the caller uses different
	 * implementations (e.g. of a service) and some of the implementations do not
	 * allow concurrent processing or have state. In such cases the implementation
	 * can simply provide a proper clone implementation and the caller's code does
	 * not have to change.
	 * </p>
	 *
	 * @param     <T> the type of the object
	 * @param obj the object to clone, null returns null
	 * @return the clone if the object implements {@link Cloneable} otherwise the
	 *         object itself
	 * @throws CloneFailedException if the object is cloneable and the clone
	 *                              operation fails
	 * @since 1.0
	 */
	public static <T> T cloneIfPossible(final T obj) {
		return ObjectUtils.cloneIfPossible(obj);
	}

	// Constants (LANG-816):
	/*
	 * These methods ensure constants are not inlined by javac. For example,
	 * typically a developer might declare a constant like so:
	 * 
	 * public final static int MAGIC_NUMBER = 5;
	 * 
	 * Should a different jar file refer to this, and the MAGIC_NUMBER is changed a
	 * later date (e.g., MAGIC_NUMBER = 6), the different jar file will need to
	 * recompile itself. This is because javac typically inlines the primitive or
	 * String constant directly into the bytecode, and removes the reference to the
	 * MAGIC_NUMBER field.
	 * 
	 * To help the other jar (so that it does not need to recompile when constants
	 * are changed) the original developer can declare their constant using one of
	 * the CONST() utility methods, instead:
	 * 
	 * public final static int MAGIC_NUMBER = CONST(5);
	 */

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static boolean MAGIC_FLAG = ObjectUtils.CONST(true);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the boolean value to return
	 * @return the boolean v, unchanged
	 * @since 1.0
	 */
	public static boolean CONST(final boolean v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static byte MAGIC_BYTE = ObjectUtils.CONST((byte) 127);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the byte value to return
	 * @return the byte v, unchanged
	 * @since 1.0
	 */
	public static byte CONST(final byte v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static byte MAGIC_BYTE = ObjectUtils.CONST_BYTE(127);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the byte literal (as an int) value to return
	 * @throws IllegalArgumentException if the value passed to v is larger than a
	 *                                  byte, that is, smaller than -128 or larger
	 *                                  than 127.
	 * @return the byte v, unchanged
	 * @since 1.0
	 */
	public static byte CONST_BYTE(final int v) {
		return ObjectUtils.CONST_BYTE(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static char MAGIC_CHAR = ObjectUtils.CONST('a');
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the char value to return
	 * @return the char v, unchanged
	 * @since 1.0
	 */
	public static char CONST(final char v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static short MAGIC_SHORT = ObjectUtils.CONST((short) 123);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the short value to return
	 * @return the short v, unchanged
	 * @since 1.0
	 */
	public static short CONST(final short v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static short MAGIC_SHORT = ObjectUtils.CONST_SHORT(127);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the short literal (as an int) value to return
	 * @throws IllegalArgumentException if the value passed to v is larger than a
	 *                                  short, that is, smaller than -32768 or
	 *                                  larger than 32767.
	 * @return the byte v, unchanged
	 * @since 1.0
	 */
	public static short CONST_SHORT(final int v) {
		return ObjectUtils.CONST_SHORT(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static int MAGIC_INT = ObjectUtils.CONST(123);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the int value to return
	 * @return the int v, unchanged
	 * @since 1.0
	 */
	public static int CONST(final int v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static long MAGIC_LONG = ObjectUtils.CONST(123L);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the long value to return
	 * @return the long v, unchanged
	 * @since 1.0
	 */
	public static long CONST(final long v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static float MAGIC_FLOAT = ObjectUtils.CONST(1.0f);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the float value to return
	 * @return the float v, unchanged
	 * @since 1.0
	 */
	public static float CONST(final float v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static double MAGIC_DOUBLE = ObjectUtils.CONST(1.0);
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param v the double value to return
	 * @return the double v, unchanged
	 * @since 1.0
	 */
	public static double CONST(final double v) {
		return ObjectUtils.CONST(v);
	}

	/**
	 * This method returns the provided value unchanged. This can prevent javac from
	 * inlining a constant field, e.g.,
	 *
	 * <pre>
	 * public final static String MAGIC_STRING = ObjectUtils.CONST("abc");
	 * </pre>
	 *
	 * This way any jars that refer to this field do not have to recompile
	 * themselves if the field's value changes at some future date.
	 *
	 * @param   <T> the Object type
	 * @param v the genericized Object value to return (typically a String).
	 * @return the genericized Object v, unchanged (typically a String).
	 * @since 1.0
	 */
	public static <T> T CONST(final T v) {
		return ObjectUtils.CONST(v);
	}

}
