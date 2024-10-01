package com.threeylos.core.util.common;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.AnnotationUtils;

/**
 * <p>
 * Helper methods for working with {@link Annotation} instances.
 * </p>
 *
 * <p>
 * This class contains various utility methods that make working with
 * annotations simpler.
 * </p>
 *
 * <p>
 * {@link Annotation} instances are always proxy objects; unfortunately dynamic
 * proxies cannot be depended upon to know how to implement certain methods in
 * the same manner as would be done by "natural" {@link Annotation}s. The
 * methods presented in this class can be used to avoid that possibility. It is
 * of course also possible for dynamic proxies to actually delegate their e.g.
 * {@link Annotation#equals(Object)}/{@link Annotation#hashCode()}/
 * {@link Annotation#toString()} implementations to {@link AnnotationUtils}.
 * </p>
 *
 * <p>
 * #ThreadSafe#
 * </p>
 *
 * @since 1.0
 * @author AbhinitKumar
 */
public class AnnotationUtil {

	/**
	 * <p>
	 * {@code AnnotationUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used statically.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public AnnotationUtil() {
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if two annotations are equal using the criteria for equality presented
	 * in the {@link Annotation#equals(Object)} API docs.
	 * </p>
	 *
	 * @param a1 the first Annotation to compare, {@code null} returns {@code false}
	 *           unless both are {@code null}
	 * @param a2 the second Annotation to compare, {@code null} returns
	 *           {@code false} unless both are {@code null}
	 * @return {@code true} if the two annotations are {@code equal} or both
	 *         {@code null}
	 */
	public static boolean equals(final Annotation a1, final Annotation a2) {
		return AnnotationUtils.equals(a1, a2);
	}

	/**
	 * <p>
	 * Generate a hash code for the given annotation using the algorithm presented
	 * in the {@link Annotation#hashCode()} API docs.
	 * </p>
	 *
	 * @param a the Annotation for a hash code calculation is desired, not
	 *          {@code null}
	 * @return the calculated hash code
	 * @throws RuntimeException      if an {@code Exception} is encountered during
	 *                               annotation member access
	 * @throws IllegalStateException if an annotation method invocation returns
	 *                               {@code null}
	 */
	public static int hashCode(final Annotation a) {
		return AnnotationUtils.hashCode(a);
	}

	/**
	 * <p>
	 * Generate a string representation of an Annotation, as suggested by
	 * {@link Annotation#toString()}.
	 * </p>
	 *
	 * @param a the annotation of which a string representation is desired
	 * @return the standard string representation of an annotation, not {@code null}
	 */
	public static String toString(final Annotation a) {
		return AnnotationUtils.toString(a);

	}

	/**
	 * <p>
	 * Checks if the specified type is permitted as an annotation member.
	 * </p>
	 *
	 * <p>
	 * The Java language specification only permits certain types to be used in
	 * annotations. These include {@link String}, {@link Class}, primitive types,
	 * {@link Annotation}, {@link Enum}, and single-dimensional arrays of these
	 * types.
	 * </p>
	 *
	 * @param type the type to check, {@code null}
	 * @return {@code true} if the type is a valid type to use in an annotation
	 */
	public static boolean isValidAnnotationMemberType(Class<?> type) {
		return AnnotationUtils.isValidAnnotationMemberType(type);
	}

}
