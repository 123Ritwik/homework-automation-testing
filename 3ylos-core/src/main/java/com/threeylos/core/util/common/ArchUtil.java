package com.threeylos.core.util.common;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;

/**
 * An utility class for the os.arch System Property. The class defines methods
 * for identifying the architecture of the current JVM.
 * <p>
 * Important: The os.arch System Property returns the architecture used by the
 * JVM not of the operating system.
 * </p>
 * 
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class ArchUtil {

	/**
	 * Returns a {@link Processor} object of the current JVM.
	 *
	 * <p>
	 * Important: The os.arch System Property returns the architecture used by the
	 * JVM not of the operating system.
	 * </p>
	 *
	 * @return A {@link Processor} when supported, else <code>null</code>.
	 */
	public static Processor getProcessor() {
		return ArchUtils.getProcessor();
	}

	/**
	 * Returns a {@link Processor} object the given value {@link String}. The
	 * {@link String} must be like a value returned by the os.arch System Property.
	 *
	 * @param value A {@link String} like a value returned by the os.arch System
	 *              Property.
	 * @return A {@link Processor} when it exists, else <code>null</code>.
	 */
	public static Processor getProcessor(final String value) {
		return ArchUtils.getProcessor(value);
	}

}
