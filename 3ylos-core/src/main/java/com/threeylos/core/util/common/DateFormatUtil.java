package com.threeylos.core.util.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * <p>
 * Date and time formatting utilities and constants.
 * </p>
 *
 * <p>
 * Formatting is performed using the thread-safe
 * {@link org.apache.commons.lang3.time.FastDateFormat} class.
 * </p>
 *
 * <p>
 * Note that the JDK has a bug wherein calling Calendar.get(int) will override
 * any previously called Calendar.clear() calls. See LANG-755.
 * </p>
 *
 * @since 1.0
 * 
 * @author AbhinitKumar
 */
public class DateFormatUtil {

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * DateFormatUtils instances should NOT be constructed in standard programming.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	private DateFormatUtil() {

	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern using the UTC time zone.
	 * </p>
	 *
	 * @param millis  the date to format expressed in milliseconds
	 * @param pattern the pattern to use to format the date, not null
	 * @return the formatted date
	 */
	public static String formatUTC(final long millis, final String pattern) {
		return DateFormatUtils.formatUTC(millis, pattern);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern using the UTC time zone.
	 * </p>
	 *
	 * @param date    the date to format, not null
	 * @param pattern the pattern to use to format the date, not null
	 * @return the formatted date
	 */
	public static String formatUTC(final Date date, final String pattern) {
		return DateFormatUtils.formatUTC(date, pattern);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern using the UTC time zone.
	 * </p>
	 *
	 * @param millis  the date to format expressed in milliseconds
	 * @param pattern the pattern to use to format the date, not null
	 * @param locale  the locale to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String formatUTC(final long millis, final String pattern, final Locale locale) {
		return DateFormatUtils.formatUTC(millis, pattern, locale);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern using the UTC time zone.
	 * </p>
	 *
	 * @param date    the date to format, not null
	 * @param pattern the pattern to use to format the date, not null
	 * @param locale  the locale to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String formatUTC(final Date date, final String pattern, final Locale locale) {
		return DateFormatUtils.formatUTC(date, pattern, locale);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern.
	 * </p>
	 *
	 * @param millis  the date to format expressed in milliseconds
	 * @param pattern the pattern to use to format the date, not null
	 * @return the formatted date
	 */
	public static String format(final long millis, final String pattern) {
		return DateFormatUtils.format(millis, pattern);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern.
	 * </p>
	 *
	 * @param date    the date to format, not null
	 * @param pattern the pattern to use to format the date, not null
	 * @return the formatted date
	 */
	public static String format(final Date date, final String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * <p>
	 * Formats a calendar into a specific pattern.
	 * </p>
	 *
	 * @param calendar the calendar to format, not null
	 * @param pattern  the pattern to use to format the calendar, not null
	 * @return the formatted calendar
	 * @see FastDateFormat#format(Calendar)
	 * @since 2.4
	 */
	public static String format(final Calendar calendar, final String pattern) {
		return DateFormatUtils.format(calendar, pattern);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern in a time zone.
	 * </p>
	 *
	 * @param millis   the time expressed in milliseconds
	 * @param pattern  the pattern to use to format the date, not null
	 * @param timeZone the time zone to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String format(final long millis, final String pattern, final TimeZone timeZone) {
		return DateFormatUtils.format(millis, pattern, timeZone);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern in a time zone.
	 * </p>
	 *
	 * @param date     the date to format, not null
	 * @param pattern  the pattern to use to format the date, not null
	 * @param timeZone the time zone to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String format(final Date date, final String pattern, final TimeZone timeZone) {
		return DateFormatUtils.format(date, pattern, timeZone);
	}

	/**
	 * <p>
	 * Formats a calendar into a specific pattern in a time zone.
	 * </p>
	 *
	 * @param calendar the calendar to format, not null
	 * @param pattern  the pattern to use to format the calendar, not null
	 * @param timeZone the time zone to use, may be <code>null</code>
	 * @return the formatted calendar
	 * @see FastDateFormat#format(Calendar)
	 * @since 2.4
	 */
	public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone) {
		return DateFormatUtils.format(calendar, pattern, timeZone);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern in a locale.
	 * </p>
	 *
	 * @param millis  the date to format expressed in milliseconds
	 * @param pattern the pattern to use to format the date, not null
	 * @param locale  the locale to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String format(final long millis, final String pattern, final Locale locale) {
		return DateFormatUtils.format(millis, pattern, locale);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern in a locale.
	 * </p>
	 *
	 * @param date    the date to format, not null
	 * @param pattern the pattern to use to format the date, not null
	 * @param locale  the locale to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String format(final Date date, final String pattern, final Locale locale) {
		return DateFormatUtils.format(date, pattern, locale);
	}

	/**
	 * <p>
	 * Formats a calendar into a specific pattern in a locale.
	 * </p>
	 *
	 * @param calendar the calendar to format, not null
	 * @param pattern  the pattern to use to format the calendar, not null
	 * @param locale   the locale to use, may be <code>null</code>
	 * @return the formatted calendar
	 * @see FastDateFormat#format(Calendar)
	 * @since 2.4
	 */
	public static String format(final Calendar calendar, final String pattern, final Locale locale) {
		return DateFormatUtils.format(calendar, pattern, locale);
	}

	/**
	 * <p>
	 * Formats a date/time into a specific pattern in a time zone and locale.
	 * </p>
	 *
	 * @param millis   the date to format expressed in milliseconds
	 * @param pattern  the pattern to use to format the date, not null
	 * @param timeZone the time zone to use, may be <code>null</code>
	 * @param locale   the locale to use, may be <code>null</code>
	 * @return the formatted date
	 */
	public static String format(final long millis, final String pattern, final TimeZone timeZone, final Locale locale) {
		return DateFormatUtils.format(millis, pattern, timeZone, locale);
	}

}
