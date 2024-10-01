package com.threeylos.core.util.common;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;

/**
 * <p>
 * Operates on classes without using reflection.
 * </p>
 *
 * <p>
 * This class handles invalid {@code null} inputs as best it can. Each method
 * documents its behaviour in more detail.
 * </p>
 *
 * <p>
 * The notion of a {@code canonical name} includes the human readable name for
 * the type, for example {@code int[]}. The non-canonical method variants work
 * with the JVM names, such as {@code [I}.
 * </p>
 *
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class ClassUtil {

	/**
	 * <p>
	 * ClassUtils instances should NOT be constructed in standard programming.
	 * Instead, the class should be used as
	 * {@code ClassUtils.getShortClassName(cls)}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public ClassUtil() {
		super();
	}

	// Short class name
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the class name minus the package name for an {@code Object}.
	 * </p>
	 *
	 * @param object      the class to get the short name for, may be null
	 * @param valueIfNull the value to return if null
	 * @return the class name of the object without the package name, or the null
	 *         value
	 */
	public static String getShortClassName(final Object object, final String valueIfNull) {
		return ClassUtils.getShortCanonicalName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the class name minus the package name from a {@code Class}.
	 * </p>
	 *
	 * <p>
	 * Consider using the Java 5 API {@link Class#getSimpleName()} instead. The one
	 * known difference is that this code will return {@code "Map.Entry"} while the
	 * {@code java.lang.Class} variant will simply return {@code "Entry"}.
	 * </p>
	 *
	 * @param cls the class to get the short name for.
	 * @return the class name without the package name or an empty string
	 */
	public static String getShortClassName(final Class<?> cls) {
		return ClassUtils.getShortClassName(cls);
	}

	/**
	 * <p>
	 * Gets the class name minus the package name from a String.
	 * </p>
	 *
	 * <p>
	 * The string passed in is assumed to be a class name - it is not checked.
	 * </p>
	 * 
	 * <p>
	 * Note that this method differs from Class.getSimpleName() in that this will
	 * return {@code "Map.Entry"} whilst the {@code java.lang.Class} variant will
	 * simply return {@code "Entry"}.
	 * </p>
	 *
	 * @param className the className to get the short name for
	 * @return the class name of the class without the package name or an empty
	 *         string
	 */
	public static String getShortClassName(String className) {
		return ClassUtils.getShortClassName(className);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getSimpleName()</code>
	 * </p>
	 *
	 * @param cls the class for which to get the simple name; may be null
	 * @return the simple class name.
	 * @since 1.0
	 * @see Class#getSimpleName()
	 */
	public static String getSimpleName(final Class<?> cls) {
		return ClassUtils.getSimpleName(cls);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getSimpleName()</code>
	 * </p>
	 *
	 * @param cls         the class for which to get the simple name; may be null
	 * @param valueIfNull the value to return if null
	 * @return the simple class name or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getSimpleName()
	 */
	public static String getSimpleName(final Class<?> cls, String valueIfNull) {
		return ClassUtils.getSimpleName(cls, valueIfNull);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getSimpleName()</code>
	 * </p>
	 *
	 * @param object the object for which to get the simple class name; may be null
	 * @return the simple class name or the empty String
	 * @since 1.0
	 * @see Class#getSimpleName()
	 */
	public static String getSimpleName(final Object object) {
		return ClassUtils.getSimpleName(object);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getSimpleName()</code>
	 * </p>
	 *
	 * @param object      the object for which to get the simple class name; may be
	 *                    null
	 * @param valueIfNull the value to return if <code>object</code> is
	 *                    <code>null</code>
	 * @return the simple class name or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getSimpleName()
	 */
	public static String getSimpleName(final Object object, final String valueIfNull) {
		return ClassUtils.getSimpleName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Null-safe version of <code>Class.getName()</code>
	 * </p>
	 *
	 * @param cls the class for which to get the class name; may be null
	 * @return the class name or the empty String.
	 * @since 1.0
	 * @see Class#getSimpleName()
	 */
	public static String getName(final Class<?> cls) {
		return ClassUtils.getName(cls);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getName()</code>
	 * </p>
	 *
	 * @param cls         the class for which to get the class name; may be null
	 * @param valueIfNull the return value if <code>cls</code> is <code>null</code>
	 * @return the class name or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getName()
	 */
	public static String getName(final Class<?> cls, final String valueIfNull) {
		return ClassUtils.getName(cls, valueIfNull);
	}

	/**
	 * <p>
	 * Null-safe version of <code>Class.getName()</code>
	 * </p>
	 *
	 * @param object the object for which to get the class name; may be null
	 * @return the class name or the empty String
	 * @since 3.7
	 * @see Class#getSimpleName()
	 */
	public static String getName(final Object object) {
		return ClassUtils.getName(object);
	}

	/**
	 * <p>
	 * Null-safe version of <code>aClass.getSimpleName()</code>
	 * </p>
	 *
	 * @param object      the object for which to get the class name; may be null
	 * @param valueIfNull the value to return if <code>object</code> is
	 *                    <code>null</code>
	 * @return the class name or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getName()
	 */
	public static String getName(final Object object, final String valueIfNull) {
		return ClassUtils.getName(object, valueIfNull);
	}

	// Package name
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the package name of an {@code Object}.
	 * </p>
	 *
	 * @param object      the class to get the package name for, may be null
	 * @param valueIfNull the value to return if null
	 * @return the package name of the object, or the null value
	 */
	public static String getPackageName(final Object object, final String valueIfNull) {
		return ClassUtils.getPackageName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the package name of a {@code Class}.
	 * </p>
	 *
	 * @param cls the class to get the package name for, may be {@code null}.
	 * @return the package name or an empty string
	 */
	public static String getPackageName(final Class<?> cls) {
		return ClassUtils.getPackageName(cls);
	}

	/**
	 * <p>
	 * Gets the package name from a {@code String}.
	 * </p>
	 *
	 * <p>
	 * The string passed in is assumed to be a class name - it is not checked.
	 * </p>
	 * <p>
	 * If the class is unpackaged, return an empty string.
	 * </p>
	 *
	 * @param className the className to get the package name for, may be
	 *                  {@code null}
	 * @return the package name or an empty string
	 */
	public static String getPackageName(String className) {
		return ClassUtils.getPackageName(className);
	}

	// Abbreviated name
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the abbreviated name of a {@code Class}.
	 * </p>
	 *
	 * @param cls the class to get the abbreviated name for, may be {@code null}
	 * @param len the desired length of the abbreviated name
	 * @return the abbreviated name or an empty string
	 * @throws IllegalArgumentException if len &lt;= 0
	 * @see #getAbbreviatedName(String, int)
	 * @since 1.0
	 */
	public static String getAbbreviatedName(final Class<?> cls, final int len) {
		return ClassUtils.getAbbreviatedName(cls, len);
	}

	/**
	 * <p>
	 * Gets the abbreviated class name from a {@code String}.
	 * </p>
	 *
	 * <p>
	 * The string passed in is assumed to be a class name - it is not checked.
	 * </p>
	 *
	 * <p>
	 * The abbreviation algorithm will shorten the class name, usually without
	 * significant loss of meaning.
	 * </p>
	 * <p>
	 * The abbreviated class name will always include the complete package
	 * hierarchy. If enough space is available, rightmost sub-packages will be
	 * displayed in full length.
	 * </p>
	 *
	 * <table>
	 * <caption>Examples</caption>
	 * <tr>
	 * <td>className</td>
	 * <td>len</td>
	 * <td>return</td>
	 * </tr>
	 * <tr>
	 * <td>null</td>
	 * <td>1</td>
	 * <td>""</td>
	 * </tr>
	 * <tr>
	 * <td>"java.lang.String"</td>
	 * <td>5</td>
	 * <td>"j.l.String"</td>
	 * </tr>
	 * <tr>
	 * <td>"java.lang.String"</td>
	 * <td>15</td>
	 * <td>"j.lang.String"</td>
	 * </tr>
	 * <tr>
	 * <td>"java.lang.String"</td>
	 * <td>30</td>
	 * <td>"java.lang.String"</td>
	 * </tr>
	 * </table>
	 * 
	 * @param className the className to get the abbreviated name for, may be
	 *                  {@code null}
	 * @param len       the desired length of the abbreviated name
	 * @return the abbreviated name or an empty string
	 * @throws IllegalArgumentException if len &lt;= 0
	 * @since 1.0
	 */
	public static String getAbbreviatedName(final String className, final int len) {
		return ClassUtils.getAbbreviatedName(className, len);
	}

	// Superclasses/Superinterfaces
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets a {@code List} of superclasses for the given class.
	 * </p>
	 *
	 * @param cls the class to look up, may be {@code null}
	 * @return the {@code List} of superclasses in order going up from this one
	 *         {@code null} if null input
	 */
	public static List<Class<?>> getAllSuperclasses(final Class<?> cls) {
		return ClassUtils.getAllSuperclasses(cls);
	}

	/**
	 * <p>
	 * Gets a {@code List} of all interfaces implemented by the given class and its
	 * superclasses.
	 * </p>
	 *
	 * <p>
	 * The order is determined by looking through each interface in turn as declared
	 * in the source file and following its hierarchy up. Then each superclass is
	 * considered in the same way. Later duplicates are ignored, so the order is
	 * maintained.
	 * </p>
	 *
	 * @param cls the class to look up, may be {@code null}
	 * @return the {@code List} of interfaces in order, {@code null} if null input
	 */
	public static List<Class<?>> getAllInterfaces(final Class<?> cls) {
		return ClassUtils.getAllInterfaces(cls);
	}

	// Convert list
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Given a {@code List} of class names, this method converts them into classes.
	 * </p>
	 *
	 * <p>
	 * A new {@code List} is returned. If the class name cannot be found,
	 * {@code null} is stored in the {@code List}. If the class name in the
	 * {@code List} is {@code null}, {@code null} is stored in the output
	 * {@code List}.
	 * </p>
	 *
	 * @param classNames the classNames to change
	 * @return a {@code List} of Class objects corresponding to the class names,
	 *         {@code null} if null input
	 * @throws ClassCastException if classNames contains a non String entry
	 */
	public static List<Class<?>> convertClassNamesToClasses(final List<String> classNames) {
		return ClassUtils.convertClassNamesToClasses(classNames);
	}

	/**
	 * <p>
	 * Given a {@code List} of {@code Class} objects, this method converts them into
	 * class names.
	 * </p>
	 *
	 * <p>
	 * A new {@code List} is returned. {@code null} objects will be copied into the
	 * returned list as {@code null}.
	 * </p>
	 *
	 * @param classes the classes to change
	 * @return a {@code List} of class names corresponding to the Class objects,
	 *         {@code null} if null input
	 * @throws ClassCastException if {@code classes} contains a non-{@code Class}
	 *                            entry
	 */
	public static List<String> convertClassesToClassNames(final List<Class<?>> classes) {
		return ClassUtils.convertClassesToClassNames(classes);
	}

	// Is assignable
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an array of Classes can be assigned to another array of Classes.
	 * </p>
	 *
	 * <p>
	 * This method calls {@link #isAssignable(Class, Class) isAssignable} for each
	 * Class pair in the input arrays. It can be used to check if a set of arguments
	 * (the first parameter) are suitably compatible with a set of method parameter
	 * types (the second parameter).
	 * </p>
	 *
	 * <p>
	 * Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this
	 * method takes into account widenings of primitive classes and {@code null}s.
	 * </p>
	 *
	 * <p>
	 * Primitive widenings allow an int to be assigned to a {@code long},
	 * {@code float} or {@code double}. This method returns the correct result for
	 * these cases.
	 * </p>
	 *
	 * <p>
	 * {@code Null} may be assigned to any reference type. This method will return
	 * {@code true} if {@code null} is passed in and the toClass is non-primitive.
	 * </p>
	 *
	 * <p>
	 * Specifically, this method tests whether the type represented by the specified
	 * {@code Class} parameter can be converted to the type represented by this
	 * {@code Class} object via an identity conversion widening primitive or
	 * widening reference conversion. See
	 * <em><a href="http://docs.oracle.com/javase/specs/">The Java Language
	 * Specification</a></em>, sections 5.1.1, 5.1.2 and 5.1.4 for details.
	 * </p>
	 *
	 * <p>
	 * <strong>Since Lang 3.0,</strong> this method will default behavior for
	 * calculating assignability between primitive and wrapper types
	 * <em>corresponding to the running Java version</em>; i.e. autoboxing will be
	 * the default behavior in VMs running Java versions &gt; 1.5.
	 * </p>
	 *
	 * @param classArray   the array of Classes to check, may be {@code null}
	 * @param toClassArray the array of Classes to try to assign into, may be
	 *                     {@code null}
	 * @return {@code true} if assignment possible
	 */
	public static boolean isAssignable(final Class<?>[] classArray, final Class<?>... toClassArray) {
		return ClassUtils.isAssignable(classArray, toClassArray);
	}

	/**
	 * <p>
	 * Checks if an array of Classes can be assigned to another array of Classes.
	 * </p>
	 *
	 * <p>
	 * This method calls {@link #isAssignable(Class, Class) isAssignable} for each
	 * Class pair in the input arrays. It can be used to check if a set of arguments
	 * (the first parameter) are suitably compatible with a set of method parameter
	 * types (the second parameter).
	 * </p>
	 *
	 * <p>
	 * Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this
	 * method takes into account widenings of primitive classes and {@code null}s.
	 * </p>
	 *
	 * <p>
	 * Primitive widenings allow an int to be assigned to a {@code long},
	 * {@code float} or {@code double}. This method returns the correct result for
	 * these cases.
	 * </p>
	 *
	 * <p>
	 * {@code Null} may be assigned to any reference type. This method will return
	 * {@code true} if {@code null} is passed in and the toClass is non-primitive.
	 * </p>
	 *
	 * <p>
	 * Specifically, this method tests whether the type represented by the specified
	 * {@code Class} parameter can be converted to the type represented by this
	 * {@code Class} object via an identity conversion widening primitive or
	 * widening reference conversion. See
	 * <em><a href="http://docs.oracle.com/javase/specs/">The Java Language
	 * Specification</a></em>, sections 5.1.1, 5.1.2 and 5.1.4 for details.
	 * </p>
	 *
	 * @param classArray   the array of Classes to check, may be {@code null}
	 * @param toClassArray the array of Classes to try to assign into, may be
	 *                     {@code null}
	 * @param autoboxing   whether to use implicit autoboxing/unboxing between
	 *                     primitives and wrappers
	 * @return {@code true} if assignment possible
	 */
	public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, final boolean autoboxing) {
		return ClassUtils.isAssignable(classArray, toClassArray, autoboxing);
	}

	/**
	 * Returns whether the given {@code type} is a primitive or primitive wrapper
	 * ({@link Boolean}, {@link Byte}, {@link Character}, {@link Short},
	 * {@link Integer}, {@link Long}, {@link Double}, {@link Float}).
	 *
	 * @param type The class to query or null.
	 * @return true if the given {@code type} is a primitive or primitive wrapper
	 *         ({@link Boolean}, {@link Byte}, {@link Character}, {@link Short},
	 *         {@link Integer}, {@link Long}, {@link Double}, {@link Float}).
	 * @since 1.0
	 */
	public static boolean isPrimitiveOrWrapper(final Class<?> type) {
		return ClassUtils.isPrimitiveOrWrapper(type);
	}

	/**
	 * Returns whether the given {@code type} is a primitive wrapper
	 * ({@link Boolean}, {@link Byte}, {@link Character}, {@link Short},
	 * {@link Integer}, {@link Long}, {@link Double}, {@link Float}).
	 *
	 * @param type The class to query or null.
	 * @return true if the given {@code type} is a primitive wrapper
	 *         ({@link Boolean}, {@link Byte}, {@link Character}, {@link Short},
	 *         {@link Integer}, {@link Long}, {@link Double}, {@link Float}).
	 * @since 1.0
	 */
	public static boolean isPrimitiveWrapper(final Class<?> type) {
		return ClassUtils.isPrimitiveWrapper(type);
	}

	/**
	 * <p>
	 * Checks if one {@code Class} can be assigned to a variable of another
	 * {@code Class}.
	 * </p>
	 *
	 * <p>
	 * Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this
	 * method takes into account widenings of primitive classes and {@code null}s.
	 * </p>
	 *
	 * <p>
	 * Primitive widenings allow an int to be assigned to a long, float or double.
	 * This method returns the correct result for these cases.
	 * </p>
	 *
	 * <p>
	 * {@code Null} may be assigned to any reference type. This method will return
	 * {@code true} if {@code null} is passed in and the toClass is non-primitive.
	 * </p>
	 *
	 * <p>
	 * Specifically, this method tests whether the type represented by the specified
	 * {@code Class} parameter can be converted to the type represented by this
	 * {@code Class} object via an identity conversion widening primitive or
	 * widening reference conversion. See
	 * <em><a href="http://docs.oracle.com/javase/specs/">The Java Language
	 * Specification</a></em>, sections 5.1.1, 5.1.2 and 5.1.4 for details.
	 * </p>
	 *
	 * <p>
	 * <strong>Since Lang 3.0,</strong> this method will default behavior for
	 * calculating assignability between primitive and wrapper types
	 * <em>corresponding to the running Java version</em>; i.e. autoboxing will be
	 * the default behavior in VMs running Java versions &gt; 1.5.
	 * </p>
	 *
	 * @param cls     the Class to check, may be null
	 * @param toClass the Class to try to assign into, returns false if null
	 * @return {@code true} if assignment possible
	 */
	public static boolean isAssignable(final Class<?> cls, final Class<?> toClass) {
		return ClassUtils.isAssignable(cls, toClass);
	}

	/**
	 * <p>
	 * Checks if one {@code Class} can be assigned to a variable of another
	 * {@code Class}.
	 * </p>
	 *
	 * <p>
	 * Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this
	 * method takes into account widenings of primitive classes and {@code null}s.
	 * </p>
	 *
	 * <p>
	 * Primitive widenings allow an int to be assigned to a long, float or double.
	 * This method returns the correct result for these cases.
	 * </p>
	 *
	 * <p>
	 * {@code Null} may be assigned to any reference type. This method will return
	 * {@code true} if {@code null} is passed in and the toClass is non-primitive.
	 * </p>
	 *
	 * <p>
	 * Specifically, this method tests whether the type represented by the specified
	 * {@code Class} parameter can be converted to the type represented by this
	 * {@code Class} object via an identity conversion widening primitive or
	 * widening reference conversion. See
	 * <em><a href="http://docs.oracle.com/javase/specs/">The Java Language
	 * Specification</a></em>, sections 5.1.1, 5.1.2 and 5.1.4 for details.
	 * </p>
	 *
	 * @param cls        the Class to check, may be null
	 * @param toClass    the Class to try to assign into, returns false if null
	 * @param autoboxing whether to use implicit autoboxing/unboxing between
	 *                   primitives and wrappers
	 * @return {@code true} if assignment possible
	 */
	public static boolean isAssignable(Class<?> cls, final Class<?> toClass, final boolean autoboxing) {
		return ClassUtils.isAssignable(cls, toClass, autoboxing);
	}

	/**
	 * <p>
	 * Converts the specified primitive Class object to its corresponding wrapper
	 * Class object.
	 * </p>
	 *
	 * <p>
	 * NOTE: From v2.2, this method handles {@code Void.TYPE}, returning
	 * {@code Void.TYPE}.
	 * </p>
	 *
	 * @param cls the class to convert, may be null
	 * @return the wrapper class for {@code cls} or {@code cls} if {@code cls} is
	 *         not a primitive. {@code null} if null input.
	 * @since 1.0
	 */
	public static Class<?> primitiveToWrapper(final Class<?> cls) {
		return ClassUtils.primitiveToWrapper(cls);
	}

	/**
	 * <p>
	 * Converts the specified array of primitive Class objects to an array of its
	 * corresponding wrapper Class objects.
	 * </p>
	 *
	 * @param classes the class array to convert, may be null or empty
	 * @return an array which contains for each given class, the wrapper class or
	 *         the original class if class is not a primitive. {@code null} if null
	 *         input. Empty array if an empty array passed in.
	 * @since 1.0
	 */
	public static Class<?>[] primitivesToWrappers(final Class<?>... classes) {
		return ClassUtils.primitivesToWrappers(classes);
	}

	/**
	 * <p>
	 * Converts the specified wrapper class to its corresponding primitive class.
	 * </p>
	 *
	 * <p>
	 * This method is the counter part of {@code primitiveToWrapper()}. If the
	 * passed in class is a wrapper class for a primitive type, this primitive type
	 * will be returned (e.g. {@code Integer.TYPE} for {@code Integer.class}). For
	 * other classes, or if the parameter is <b>null</b>, the return value is
	 * <b>null</b>.
	 * </p>
	 *
	 * @param cls the class to convert, may be <b>null</b>
	 * @return the corresponding primitive type if {@code cls} is a wrapper class,
	 *         <b>null</b> otherwise
	 * @see #primitiveToWrapper(Class)
	 * @since 1.0
	 */
	public static Class<?> wrapperToPrimitive(final Class<?> cls) {
		return ClassUtils.wrapperToPrimitive(cls);
	}

	/**
	 * <p>
	 * Converts the specified array of wrapper Class objects to an array of its
	 * corresponding primitive Class objects.
	 * </p>
	 *
	 * <p>
	 * This method invokes {@code wrapperToPrimitive()} for each element of the
	 * passed in array.
	 * </p>
	 *
	 * @param classes the class array to convert, may be null or empty
	 * @return an array which contains for each given class, the primitive class or
	 *         <b>null</b> if the original class is not a wrapper class.
	 *         {@code null} if null input. Empty array if an empty array passed in.
	 * @see #wrapperToPrimitive(Class)
	 * @since 1.0
	 */
	public static Class<?>[] wrappersToPrimitives(final Class<?>... classes) {
		return ClassUtils.wrappersToPrimitives(classes);
	}

	// Inner class
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Is the specified class an inner class or static nested class.
	 * </p>
	 *
	 * @param cls the class to check, may be null
	 * @return {@code true} if the class is an inner or static nested class, false
	 *         if not or {@code null}
	 */
	public static boolean isInnerClass(final Class<?> cls) {
		return ClassUtils.isInnerClass(cls);
	}

	// Class loading
	// ----------------------------------------------------------------------
	/**
	 * Returns the class represented by {@code className} using the
	 * {@code classLoader}. This implementation supports the syntaxes
	 * "{@code java.util.Map.Entry[]}", "{@code java.util.Map$Entry[]}",
	 * "{@code [Ljava.util.Map.Entry;}", and "{@code [Ljava.util.Map$Entry;}".
	 *
	 * @param classLoader the class loader to use to load the class
	 * @param className   the class name
	 * @param initialize  whether the class must be initialized
	 * @return the class represented by {@code className} using the
	 *         {@code classLoader}
	 * @throws ClassNotFoundException if the class is not found
	 */
	public static Class<?> getClass(final ClassLoader classLoader, final String className, final boolean initialize)
			throws ClassNotFoundException {
		return ClassUtils.getClass(classLoader, className, initialize);
	}

	/**
	 * Returns the (initialized) class represented by {@code className} using the
	 * {@code classLoader}. This implementation supports the syntaxes
	 * "{@code java.util.Map.Entry[]}", "{@code java.util.Map$Entry[]}",
	 * "{@code [Ljava.util.Map.Entry;}", and "{@code [Ljava.util.Map$Entry;}".
	 *
	 * @param classLoader the class loader to use to load the class
	 * @param className   the class name
	 * @return the class represented by {@code className} using the
	 *         {@code classLoader}
	 * @throws ClassNotFoundException if the class is not found
	 */
	public static Class<?> getClass(final ClassLoader classLoader, final String className)
			throws ClassNotFoundException {
		return ClassUtils.getClass(classLoader, className);
	}

	/**
	 * Returns the (initialized) class represented by {@code className} using the
	 * current thread's context class loader. This implementation supports the
	 * syntaxes "{@code java.util.Map.Entry[]}", "{@code java.util.Map$Entry[]}",
	 * "{@code [Ljava.util.Map.Entry;}", and "{@code [Ljava.util.Map$Entry;}".
	 *
	 * @param className the class name
	 * @return the class represented by {@code className} using the current thread's
	 *         context class loader
	 * @throws ClassNotFoundException if the class is not found
	 */
	public static Class<?> getClass(final String className) throws ClassNotFoundException {
		return ClassUtils.getClass(className);
	}

	/**
	 * Returns the class represented by {@code className} using the current thread's
	 * context class loader. This implementation supports the syntaxes
	 * "{@code java.util.Map.Entry[]}", "{@code java.util.Map$Entry[]}",
	 * "{@code [Ljava.util.Map.Entry;}", and "{@code [Ljava.util.Map$Entry;}".
	 *
	 * @param className  the class name
	 * @param initialize whether the class must be initialized
	 * @return the class represented by {@code className} using the current thread's
	 *         context class loader
	 * @throws ClassNotFoundException if the class is not found
	 */
	public static Class<?> getClass(final String className, final boolean initialize) throws ClassNotFoundException {
		return ClassUtils.getClass(className, initialize);
	}

	// Public method
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns the desired Method much like {@code Class.getMethod}, however it
	 * ensures that the returned Method is from a public class or interface and not
	 * from an anonymous inner class. This means that the Method is invokable and
	 * doesn't fall foul of Java bug <a href=
	 * "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4071957">4071957</a>).
	 * </p>
	 *
	 * <pre>
	 *  <code>Set set = Collections.unmodifiableSet(...);
	 *  Method method = ClassUtils.getPublicMethod(set.getClass(), "isEmpty",  new Class[0]);
	 *  Object result = method.invoke(set, new Object[]);</code>
	 * </pre>
	 *
	 * @param cls            the class to check, not null
	 * @param methodName     the name of the method
	 * @param parameterTypes the list of parameters
	 * @return the method
	 * @throws NullPointerException  if the class is null
	 * @throws SecurityException     if a security violation occurred
	 * @throws NoSuchMethodException if the method is not found in the given class
	 *                               or if the method doesn't conform with the
	 *                               requirements
	 */
	public static Method getPublicMethod(final Class<?> cls, final String methodName, final Class<?>... parameterTypes)
			throws NoSuchMethodException {

		return ClassUtils.getPublicMethod(cls, methodName, parameterTypes);
	}

	/**
	 * <p>
	 * Converts an array of {@code Object} in to an array of {@code Class} objects.
	 * If any of these objects is null, a null element will be inserted into the
	 * array.
	 * </p>
	 *
	 * <p>
	 * This method returns {@code null} for a {@code null} input array.
	 * </p>
	 *
	 * @param array an {@code Object} array
	 * @return a {@code Class} array, {@code null} if null array input
	 * @since 1.0
	 */
	public static Class<?>[] toClass(final Object... array) {
		return ClassUtils.toClass(array);
	}

	// Short canonical name
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the canonical name minus the package name for an {@code Object}.
	 * </p>
	 *
	 * @param object      the class to get the short name for, may be null
	 * @param valueIfNull the value to return if null
	 * @return the canonical name of the object without the package name, or the
	 *         null value
	 * @since 1.0
	 */
	public static String getShortCanonicalName(final Object object, final String valueIfNull) {
		return ClassUtils.getShortCanonicalName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the canonical class name for a {@code Class}.
	 * </p>
	 *
	 * @param cls the class for which to get the canonical class name; may be null
	 * @return the canonical name of the class, or the empty String
	 * @since 1.0
	 * @see Class#getCanonicalName()
	 */
	public static String getCanonicalName(final Class<?> cls) {
		return ClassUtils.getCanonicalName(cls);
	}

	/**
	 * <p>
	 * Gets the canonical name for a {@code Class}.
	 * </p>
	 *
	 * @param cls         the class for which to get the canonical class name; may
	 *                    be null
	 * @param valueIfNull the return value if null
	 * @return the canonical name of the class, or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getCanonicalName()
	 */
	public static String getCanonicalName(final Class<?> cls, final String valueIfNull) {
		return ClassUtils.getCanonicalName(cls, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the canonical name for an {@code Object}.
	 * </p>
	 *
	 * @param object the object for which to get the canonical class name; may be
	 *               null
	 * @return the canonical name of the object, or the empty String
	 * @since 1.0
	 * @see Class#getCanonicalName()
	 */
	public static String getCanonicalName(final Object object) {
		return ClassUtils.getCanonicalName(object);
	}

	/**
	 * <p>
	 * Gets the canonical name for an {@code Object}.
	 * </p>
	 *
	 * @param object      the object for which to get the canonical class name; may
	 *                    be null
	 * @param valueIfNull the return value if null
	 * @return the canonical name of the object or {@code valueIfNull}
	 * @since 1.0
	 * @see Class#getCanonicalName()
	 */
	public static String getCanonicalName(final Object object, final String valueIfNull) {
		return ClassUtils.getCanonicalName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the canonical name minus the package name from a {@code Class}.
	 * </p>
	 *
	 * @param cls the class for which to get the short canonical class name; may be
	 *            null
	 * @return the canonical name without the package name or an empty string
	 * @since 1.0
	 */
	public static String getShortCanonicalName(final Class<?> cls) {
		return ClassUtils.getShortCanonicalName(cls);
	}

	/**
	 * <p>
	 * Gets the canonical name minus the package name from a String.
	 * </p>
	 *
	 * <p>
	 * The string passed in is assumed to be a canonical name - it is not checked.
	 * </p>
	 *
	 * @param canonicalName the class name to get the short name for
	 * @return the canonical name of the class without the package name or an empty
	 *         string
	 * @since 1.0
	 */
	public static String getShortCanonicalName(final String canonicalName) {
		return ClassUtils.getShortCanonicalName(canonicalName);
	}

	// Package name
	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the package name from the canonical name of an {@code Object}.
	 * </p>
	 *
	 * @param object      the class to get the package name for, may be null
	 * @param valueIfNull the value to return if null
	 * @return the package name of the object, or the null value
	 * @since 1.0
	 */
	public static String getPackageCanonicalName(final Object object, final String valueIfNull) {
		return ClassUtils.getPackageCanonicalName(object, valueIfNull);
	}

	/**
	 * <p>
	 * Gets the package name from the canonical name of a {@code Class}.
	 * </p>
	 *
	 * @param cls the class to get the package name for, may be {@code null}.
	 * @return the package name or an empty string
	 * @since 1.0
	 */
	public static String getPackageCanonicalName(final Class<?> cls) {
		return ClassUtils.getPackageCanonicalName(cls);
	}

	/**
	 * <p>
	 * Gets the package name from the canonical name.
	 * </p>
	 *
	 * <p>
	 * The string passed in is assumed to be a canonical name - it is not checked.
	 * </p>
	 * <p>
	 * If the class is unpackaged, return an empty string.
	 * </p>
	 *
	 * @param canonicalName the canonical name to get the package name for, may be
	 *                      {@code null}
	 * @return the package name or an empty string
	 * @since 1.0
	 */
	public static String getPackageCanonicalName(final String canonicalName) {
		return ClassUtils.getPackageCanonicalName(canonicalName);
	}

	/**
	 * Get an {@link Iterable} that can iterate over a class hierarchy in ascending
	 * (subclass to superclass) order, excluding interfaces.
	 *
	 * @param type the type to get the class hierarchy from
	 * @return Iterable an Iterable over the class hierarchy of the given class
	 * @since 1.0
	 */
	public static Iterable<Class<?>> hierarchy(final Class<?> type) {
		return ClassUtils.hierarchy(type);
	}

	/**
	 * Get an {@link Iterable} that can iterate over a class hierarchy in ascending
	 * (subclass to superclass) order.
	 *
	 * @param type               the type to get the class hierarchy from
	 * @param interfacesBehavior switch indicating whether to include or exclude
	 *                           interfaces
	 * @return Iterable an Iterable over the class hierarchy of the given class
	 * @since 1.0
	 */
	public static Iterable<Class<?>> hierarchy(final Class<?> type, final Interfaces interfacesBehavior) {
		return ClassUtils.hierarchy(type, interfacesBehavior);
	}
}
