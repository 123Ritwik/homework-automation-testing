package com.threeylos.core.util.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;

/**
 * <p>
 * Assists with the serialization process and performs additional functionality
 * based on serialization.
 * </p>
 *
 * <ul>
 * <li>Deep clone using serialization
 * <li>Serialize managing finally and IOException
 * <li>Deserialize managing finally and IOException
 * </ul>
 *
 * <p>
 * This class throws exceptions for invalid {@code null} inputs. Each method
 * documents its behaviour in more detail.
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
public class SerializationUtil {

	/**
	 * <p>
	 * SerializationUtils instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code SerializationUtils.clone(object)}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 * 
	 * @since 1.0
	 */
	public SerializationUtil() {
		super();
	}

	// Clone
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Deep clone an {@code Object} using serialization.
	 * </p>
	 *
	 * <p>
	 * This is many times slower than writing clone methods by hand on all objects
	 * in your object graph. However, for complex object graphs, or for those that
	 * don't support deep cloning this can be a simple alternative implementation.
	 * Of course all the objects must be {@code Serializable}.
	 * </p>
	 *
	 * @param        <T> the type of the object involved
	 * @param object the {@code Serializable} object to clone
	 * @return the cloned object
	 * @throws SerializationException (runtime) if the serialization fails
	 */
	public static <T extends Serializable> T clone(final T object) {
		return SerializationUtils.clone(object);
	}

	/**
	 * Performs a serialization roundtrip. Serializes and deserializes the given
	 * object, great for testing objects that implement {@link Serializable}.
	 *
	 * @param     <T> the type of the object involved
	 * @param msg the object to roundtrip
	 * @return the serialized and deserialized object
	 * @since 1.0
	 */
	public static <T extends Serializable> T roundtrip(final T msg) {
		return SerializationUtils.roundtrip(msg);
	}

	// Serialize
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Serializes an {@code Object} to the specified stream.
	 * </p>
	 *
	 * <p>
	 * The stream will be closed once the object is written. This avoids the need
	 * for a finally clause, and maybe also exception handling, in the application
	 * code.
	 * </p>
	 *
	 * <p>
	 * The stream passed in is not buffered internally within this method. This is
	 * the responsibility of your application if desired.
	 * </p>
	 *
	 * @param obj          the object to serialize to bytes, may be null
	 * @param outputStream the stream to write to, must not be null
	 * @throws IllegalArgumentException if {@code outputStream} is {@code null}
	 * @throws SerializationException   (runtime) if the serialization fails
	 */
	public static void serialize(final Serializable obj, final OutputStream outputStream) {
		SerializationUtils.serialize(obj, outputStream);
	}

	/**
	 * <p>
	 * Serializes an {@code Object} to a byte array for storage/serialization.
	 * </p>
	 *
	 * @param obj the object to serialize to bytes
	 * @return a byte[] with the converted Serializable
	 * @throws SerializationException (runtime) if the serialization fails
	 */
	public static byte[] serialize(final Serializable obj) {
		return SerializationUtils.serialize(obj);
	}

	// Deserialize
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Deserializes an {@code Object} from the specified stream.
	 * </p>
	 *
	 * <p>
	 * The stream will be closed once the object is written. This avoids the need
	 * for a finally clause, and maybe also exception handling, in the application
	 * code.
	 * </p>
	 *
	 * <p>
	 * The stream passed in is not buffered internally within this method. This is
	 * the responsibility of your application if desired.
	 * </p>
	 *
	 * <p>
	 * If the call site incorrectly types the return value, a
	 * {@link ClassCastException} is thrown from the call site. Without Generics in
	 * this declaration, the call site must type cast and can cause the same
	 * ClassCastException. Note that in both cases, the ClassCastException is in the
	 * call site, not in this method.
	 * </p>
	 *
	 * @param             <T> the object type to be deserialized
	 * @param inputStream the serialized object input stream, must not be null
	 * @return the deserialized object
	 * @throws IllegalArgumentException if {@code inputStream} is {@code null}
	 * @throws SerializationException   (runtime) if the serialization fails
	 */
	public static <T> T deserialize(final InputStream inputStream) {
		return SerializationUtils.deserialize(inputStream);
	}

	/**
	 * <p>
	 * Deserializes a single {@code Object} from an array of bytes.
	 * </p>
	 *
	 * <p>
	 * If the call site incorrectly types the return value, a
	 * {@link ClassCastException} is thrown from the call site. Without Generics in
	 * this declaration, the call site must type cast and can cause the same
	 * ClassCastException. Note that in both cases, the ClassCastException is in the
	 * call site, not in this method.
	 * </p>
	 *
	 * @param            <T> the object type to be deserialized
	 * @param objectData the serialized object, must not be null
	 * @return the deserialized object
	 * @throws IllegalArgumentException if {@code objectData} is {@code null}
	 * @throws SerializationException   (runtime) if the serialization fails
	 */
	public static <T> T deserialize(final byte[] objectData) {
		return SerializationUtils.deserialize(objectData);
	}

}
