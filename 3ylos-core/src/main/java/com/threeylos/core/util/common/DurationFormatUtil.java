package com.threeylos.core.util.common;

import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * <p>
 * Duration formatting utilities and constants. The following table describes
 * the tokens used in the pattern language for formatting.
 * </p>
 * <table border="1">
 * <caption>Pattern Tokens</caption>
 * <tr>
 * <th>character</th>
 * <th>duration element</th>
 * </tr>
 * <tr>
 * <td>y</td>
 * <td>years</td>
 * </tr>
 * <tr>
 * <td>M</td>
 * <td>months</td>
 * </tr>
 * <tr>
 * <td>d</td>
 * <td>days</td>
 * </tr>
 * <tr>
 * <td>H</td>
 * <td>hours</td>
 * </tr>
 * <tr>
 * <td>m</td>
 * <td>minutes</td>
 * </tr>
 * <tr>
 * <td>s</td>
 * <td>seconds</td>
 * </tr>
 * <tr>
 * <td>S</td>
 * <td>milliseconds</td>
 * </tr>
 * <tr>
 * <td>'text'</td>
 * <td>arbitrary text content</td>
 * </tr>
 * </table>
 *
 * <b>Note: It's not currently possible to include a single-quote in a
 * format.</b> <br>
 * Token values are printed using decimal digits. A token character can be
 * repeated to ensure that the field occupies a certain minimum size. Values
 * will be left-padded with 0 unless padding is disabled in the method
 * invocation.
 * 
 * @since 1.0
 * @author AbhinitKumar
 */
public class DurationFormatUtil {

	/**
	 * <p>
	 * DurationFormatUtils instances should NOT be constructed in standard
	 * programming.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	private DurationFormatUtil() {

	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Formats the time gap as a string.
	 * </p>
	 *
	 * <p>
	 * The format used is ISO 8601-like: {@code HH:mm:ss.SSS}.
	 * </p>
	 *
	 * @param durationMillis the duration to format
	 * @return the formatted duration, not null
	 * @throws java.lang.IllegalArgumentException if durationMillis is negative
	 */
	public static String formatDurationHMS(final long durationMillis) {
		return DurationFormatUtils.formatDurationHMS(durationMillis);
	}

	/**
	 * <p>
	 * Formats the time gap as a string.
	 * </p>
	 *
	 * <p>
	 * The format used is the ISO 8601 period format.
	 * </p>
	 *
	 * <p>
	 * This method formats durations using the days and lower fields of the ISO
	 * format pattern, such as P7D6TH5M4.321S.
	 * </p>
	 *
	 * @param durationMillis the duration to format
	 * @return the formatted duration, not null
	 * @throws java.lang.IllegalArgumentException if durationMillis is negative
	 */
	public static String formatDurationISO(final long durationMillis) {
		return DurationFormatUtils.formatDurationISO(durationMillis);
	}

	/**
	 * <p>
	 * Formats the time gap as a string, using the specified format, and padding
	 * with zeros.
	 * </p>
	 *
	 * <p>
	 * This method formats durations using the days and lower fields of the format
	 * pattern. Months and larger are not used.
	 * </p>
	 *
	 * @param durationMillis the duration to format
	 * @param format         the way in which to format the duration, not null
	 * @return the formatted duration, not null
	 * @throws java.lang.IllegalArgumentException if durationMillis is negative
	 */
	public static String formatDuration(final long durationMillis, final String format) {
		return DurationFormatUtils.formatDuration(durationMillis, format);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Formats the time gap as a string.
	 * </p>
	 *
	 * <p>
	 * The format used is the ISO 8601 period format.
	 * </p>
	 *
	 * @param startMillis the start of the duration to format
	 * @param endMillis   the end of the duration to format
	 * @return the formatted duration, not null
	 * @throws java.lang.IllegalArgumentException if startMillis is greater than
	 *         endMillis
	 */
	public static String formatPeriodISO(final long startMillis, final long endMillis) {
		return DurationFormatUtils.formatPeriodISO(startMillis, endMillis);
	}

	/**
	 * <p>
	 * Formats the time gap as a string, using the specified format. Padding the
	 * left hand side of numbers with zeroes is optional.
	 *
	 * @param startMillis the start of the duration
	 * @param endMillis   the end of the duration
	 * @param format      the way in which to format the duration, not null
	 * @return the formatted duration, not null
	 * @throws java.lang.IllegalArgumentException if startMillis is greater than
	 *         endMillis
	 */
	public static String formatPeriod(final long startMillis, final long endMillis, final String format) {
		return DurationFormatUtils.formatPeriod(startMillis, endMillis, format);
	}

}
