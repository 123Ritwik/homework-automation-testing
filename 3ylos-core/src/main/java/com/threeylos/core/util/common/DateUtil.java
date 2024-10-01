package com.threeylos.core.util.common;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * <p>
 * A suite of utilities surrounding the use of the {@link java.util.Calendar}
 * and {@link java.util.Date} object.
 * </p>
 *
 * <p>
 * DateUtils contains a lot of common methods considering manipulations of Dates
 * or Calendars. Some methods require some extra explanation. The truncate,
 * ceiling and round methods could be considered the Math.floor(), Math.ceil()
 * or Math.round versions for dates This way date-fields will be ignored in
 * bottom-up order. As a complement to these methods we've introduced some
 * fragment-methods. With these methods the Date-fields will be ignored in
 * top-down order. Since a date without a year is not a valid date, you have to
 * decide in what kind of date-field you want your result, for instance
 * milliseconds or days.
 * </p>
 * <p>
 * Several methods are provided for adding to {@code Date} objects, of the form
 * {@code addXXX(Date date, int amount)}. It is important to note these methods
 * use a {@code Calendar} internally (with default timezone and locale) and may
 * be affected by changes to daylight saving time (DST).
 * </p>
 *
 * @author AbhinitKumar
 */
public final class DateUtil {

	private DateUtil() {
	}

	/**
	 * Adds a number of days to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param days the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addDay(Date date, int days) {
		return DateUtils.addDays(date, days);

	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of years to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addYears(final Date date, final int amount) {
		return DateUtils.addYears(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of months to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addMonths(final Date date, final int amount) {
		return DateUtils.addMonths(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of weeks to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addWeeks(final Date date, final int amount) {
		return DateUtils.addWeeks(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of days to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addDays(final Date date, final int amount) {
		return DateUtils.addDays(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of hours to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addHours(final Date date, final int amount) {
		return DateUtils.addHours(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of minutes to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addMinutes(final Date date, final int amount) {
		return DateUtils.addMinutes(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of seconds to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addSeconds(final Date date, final int amount) {
		return DateUtils.addSeconds(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of milliseconds to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException if the date is null
	 */
	public static Date addMilliseconds(final Date date, final int amount) {
		return DateUtils.addMilliseconds(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the years field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setYears(final Date date, final int amount) {
		return DateUtils.setYears(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the months field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setMonths(final Date date, final int amount) {
		return DateUtils.setMonths(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the day of month field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setDays(final Date date, final int amount) {
		return DateUtils.setDays(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the hours field to a date returning a new object. Hours range from 0-23.
	 * The original {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setHours(final Date date, final int amount) {
		return DateUtils.setHours(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the minute field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setMinutes(final Date date, final int amount) {
		return DateUtils.setMinutes(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the seconds field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setSeconds(final Date date, final int amount) {
		return DateUtils.setSeconds(date, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Sets the milliseconds field to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 *
	 * @param date   the date, not null
	 * @param amount the amount to set
	 * @return a new {@code Date} set with the specified value
	 * @throws IllegalArgumentException if the date is null
	 * @since 2.4
	 */
	public static Date setMilliseconds(final Date date, final int amount) {
		return DateUtils.setMilliseconds(date, amount);
	}

	/**
	 * <p>
	 * Returns the number of milliseconds within the fragment. All datefields
	 * greater than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the milliseconds of any date will only return the number of
	 * milliseconds of the current second (resulting in a number between 0 and 999).
	 * This method will retrieve the number of milliseconds for any fragment. For
	 * example, if you want to calculate the number of milliseconds past today, your
	 * fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will be all
	 * milliseconds of the past hour(s), minutes(s) and second(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a SECOND field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.SECOND as fragment will return
	 * 538</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.SECOND as fragment will return
	 * 538</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10538 (10*1000 + 538)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in milliseconds)</li>
	 * </ul>
	 *
	 * @param date     the date to work with, not null
	 * @param fragment the {@code Calendar} field part of date to calculate
	 * @return number of milliseconds within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInMilliseconds(final Date date, final int fragment) {
		return DateUtils.getFragmentInMilliseconds(date, fragment);
	}

	/**
	 * <p>
	 * Returns the number of seconds within the fragment. All datefields greater
	 * than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the seconds of any date will only return the number of seconds of the
	 * current minute (resulting in a number between 0 and 59). This method will
	 * retrieve the number of seconds for any fragment. For example, if you want to
	 * calculate the number of seconds past today, your fragment is Calendar.DATE or
	 * Calendar.DAY_OF_YEAR. The result will be all seconds of the past hour(s) and
	 * minutes(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a SECOND field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10 (equivalent to deprecated date.getSeconds())</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10 (equivalent to deprecated date.getSeconds())</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 26110 (7*3600 + 15*60 + 10)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in seconds)</li>
	 * </ul>
	 *
	 * @param date     the date to work with, not null
	 * @param fragment the {@code Calendar} field part of date to calculate
	 * @return number of seconds within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInSeconds(final Date date, final int fragment) {
		return DateUtils.getFragmentInSeconds(date, fragment);
	}

	/**
	 * <p>
	 * Returns the number of minutes within the fragment. All datefields greater
	 * than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the minutes of any date will only return the number of minutes of the
	 * current hour (resulting in a number between 0 and 59). This method will
	 * retrieve the number of minutes for any fragment. For example, if you want to
	 * calculate the number of minutes past this month, your fragment is
	 * Calendar.MONTH. The result will be all minutes of the past day(s) and
	 * hour(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a MINUTE field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will
	 * return 15 (equivalent to deprecated date.getMinutes())</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will
	 * return 15 (equivalent to deprecated date.getMinutes())</li>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 15</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 435 (7*60 + 15)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in minutes)</li>
	 * </ul>
	 *
	 * @param date     the date to work with, not null
	 * @param fragment the {@code Calendar} field part of date to calculate
	 * @return number of minutes within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInMinutes(final Date date, final int fragment) {
		return DateUtils.getFragmentInMinutes(date, fragment);
	}

	/**
	 * <p>
	 * Returns the number of hours within the fragment. All datefields greater than
	 * the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the hours of any date will only return the number of hours of the
	 * current day (resulting in a number between 0 and 23). This method will
	 * retrieve the number of hours for any fragment. For example, if you want to
	 * calculate the number of hours past this month, your fragment is
	 * Calendar.MONTH. The result will be all hours of the past day(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a HOUR field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 7 (equivalent to deprecated date.getHours())</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 7 (equivalent to deprecated date.getHours())</li>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 7</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 127 (5*24 + 7)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in hours)</li>
	 * </ul>
	 *
	 * @param date     the date to work with, not null
	 * @param fragment the {@code Calendar} field part of date to calculate
	 * @return number of hours within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInHours(final Date date, final int fragment) {
		return DateUtils.getFragmentInHours(date, fragment);
	}

	/**
	 * <p>
	 * Returns the number of days within the fragment. All datefields greater than
	 * the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the days of any date will only return the number of days of the
	 * current month (resulting in a number between 1 and 31). This method will
	 * retrieve the number of days for any fragment. For example, if you want to
	 * calculate the number of days past this year, your fragment is Calendar.YEAR.
	 * The result will be all days of the past month(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a DAY field will return
	 * 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 28, 2008 with Calendar.MONTH as fragment will return 28
	 * (equivalent to deprecated date.getDay())</li>
	 * <li>February 28, 2008 with Calendar.MONTH as fragment will return 28
	 * (equivalent to deprecated date.getDay())</li>
	 * <li>January 28, 2008 with Calendar.YEAR as fragment will return 28</li>
	 * <li>February 28, 2008 with Calendar.YEAR as fragment will return 59</li>
	 * <li>January 28, 2008 with Calendar.MILLISECOND as fragment will return 0 (a
	 * millisecond cannot be split in days)</li>
	 * </ul>
	 *
	 * @param date     the date to work with, not null
	 * @param fragment the {@code Calendar} field part of date to calculate
	 * @return number of days within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInDays(final Date date, final int fragment) {
		return DateUtils.getFragmentInDays(date, fragment);
	}

	/**
	 * <p>
	 * Returns the number of milliseconds within the fragment. All datefields
	 * greater than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the milliseconds of any date will only return the number of
	 * milliseconds of the current second (resulting in a number between 0 and 999).
	 * This method will retrieve the number of milliseconds for any fragment. For
	 * example, if you want to calculate the number of seconds past today, your
	 * fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will be all
	 * seconds of the past hour(s), minutes(s) and second(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a MILLISECOND field
	 * will return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.SECOND as fragment will return
	 * 538 (equivalent to calendar.get(Calendar.MILLISECOND))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.SECOND as fragment will return
	 * 538 (equivalent to calendar.get(Calendar.MILLISECOND))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10538 (10*1000 + 538)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in milliseconds)</li>
	 * </ul>
	 *
	 * @param calendar the calendar to work with, not null
	 * @param fragment the {@code Calendar} field part of calendar to calculate
	 * @return number of milliseconds within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInMilliseconds(final Calendar calendar, final int fragment) {
		return DateUtils.getFragmentInMilliseconds(calendar, fragment);
	}

	/**
	 * <p>
	 * Returns the number of seconds within the fragment. All datefields greater
	 * than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the seconds of any date will only return the number of seconds of the
	 * current minute (resulting in a number between 0 and 59). This method will
	 * retrieve the number of seconds for any fragment. For example, if you want to
	 * calculate the number of seconds past today, your fragment is Calendar.DATE or
	 * Calendar.DAY_OF_YEAR. The result will be all seconds of the past hour(s) and
	 * minutes(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a SECOND field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10 (equivalent to calendar.get(Calendar.SECOND))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return
	 * 10 (equivalent to calendar.get(Calendar.SECOND))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 26110 (7*3600 + 15*60 + 10)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in seconds)</li>
	 * </ul>
	 *
	 * @param calendar the calendar to work with, not null
	 * @param fragment the {@code Calendar} field part of calendar to calculate
	 * @return number of seconds within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInSeconds(final Calendar calendar, final int fragment) {
		return DateUtils.getFragmentInSeconds(calendar, fragment);
	}

	/**
	 * <p>
	 * Returns the number of minutes within the fragment. All datefields greater
	 * than the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the minutes of any date will only return the number of minutes of the
	 * current hour (resulting in a number between 0 and 59). This method will
	 * retrieve the number of minutes for any fragment. For example, if you want to
	 * calculate the number of minutes past this month, your fragment is
	 * Calendar.MONTH. The result will be all minutes of the past day(s) and
	 * hour(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a MINUTE field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will
	 * return 15 (equivalent to calendar.get(Calendar.MINUTES))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will
	 * return 15 (equivalent to calendar.get(Calendar.MINUTES))</li>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 15</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 435 (7*60 + 15)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in minutes)</li>
	 * </ul>
	 *
	 * @param calendar the calendar to work with, not null
	 * @param fragment the {@code Calendar} field part of calendar to calculate
	 * @return number of minutes within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInMinutes(final Calendar calendar, final int fragment) {
		return DateUtils.getFragmentInMinutes(calendar, fragment);
	}

	/**
	 * <p>
	 * Returns the number of hours within the fragment. All datefields greater than
	 * the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the hours of any date will only return the number of hours of the
	 * current day (resulting in a number between 0 and 23). This method will
	 * retrieve the number of hours for any fragment. For example, if you want to
	 * calculate the number of hours past this month, your fragment is
	 * Calendar.MONTH. The result will be all hours of the past day(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a HOUR field will
	 * return 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 7 (equivalent to calendar.get(Calendar.HOUR_OF_DAY))</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will
	 * return 7 (equivalent to calendar.get(Calendar.HOUR_OF_DAY))</li>
	 * <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 7</li>
	 * <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return
	 * 127 (5*24 + 7)</li>
	 * <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will
	 * return 0 (a millisecond cannot be split in hours)</li>
	 * </ul>
	 *
	 * @param calendar the calendar to work with, not null
	 * @param fragment the {@code Calendar} field part of calendar to calculate
	 * @return number of hours within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInHours(final Calendar calendar, final int fragment) {
		return DateUtils.getFragmentInHours(calendar, fragment);
	}

	/**
	 * <p>
	 * Returns the number of days within the fragment. All datefields greater than
	 * the fragment will be ignored.
	 * </p>
	 *
	 * <p>
	 * Asking the days of any date will only return the number of days of the
	 * current month (resulting in a number between 1 and 31). This method will
	 * retrieve the number of days for any fragment. For example, if you want to
	 * calculate the number of days past this year, your fragment is Calendar.YEAR.
	 * The result will be all days of the past month(s).
	 * </p>
	 *
	 * <p>
	 * Valid fragments are: Calendar.YEAR, Calendar.MONTH, both Calendar.DAY_OF_YEAR
	 * and Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND and
	 * Calendar.MILLISECOND A fragment less than or equal to a DAY field will return
	 * 0.
	 * </p>
	 *
	 * <ul>
	 * <li>January 28, 2008 with Calendar.MONTH as fragment will return 28
	 * (equivalent to calendar.get(Calendar.DAY_OF_MONTH))</li>
	 * <li>February 28, 2008 with Calendar.MONTH as fragment will return 28
	 * (equivalent to calendar.get(Calendar.DAY_OF_MONTH))</li>
	 * <li>January 28, 2008 with Calendar.YEAR as fragment will return 28
	 * (equivalent to calendar.get(Calendar.DAY_OF_YEAR))</li>
	 * <li>February 28, 2008 with Calendar.YEAR as fragment will return 59
	 * (equivalent to calendar.get(Calendar.DAY_OF_YEAR))</li>
	 * <li>January 28, 2008 with Calendar.MILLISECOND as fragment will return 0 (a
	 * millisecond cannot be split in days)</li>
	 * </ul>
	 *
	 * @param calendar the calendar to work with, not null
	 * @param fragment the {@code Calendar} field part of calendar to calculate
	 * @return number of days within the fragment of date
	 * @throws IllegalArgumentException if the date is <code>null</code> or fragment
	 *                                  is not supported
	 * @since 2.4
	 */
	public static long getFragmentInDays(final Calendar calendar, final int fragment) {
		return DateUtils.getFragmentInDays(calendar, fragment);
	}

	/**
	 * Determines if two calendars are equal up to no more than the specified most
	 * significant field.
	 *
	 * @param cal1  the first calendar, not <code>null</code>
	 * @param cal2  the second calendar, not <code>null</code>
	 * @param field the field from {@code Calendar}
	 * @return <code>true</code> if equal; otherwise <code>false</code>
	 * @throws IllegalArgumentException if any argument is <code>null</code>
	 * @see #truncate(Calendar, int)
	 * @see #truncatedEquals(Date, Date, int)
	 * @since 3.0
	 */
	public static boolean truncatedEquals(final Calendar cal1, final Calendar cal2, final int field) {
		return DateUtils.truncatedEquals(cal1, cal2, field);
	}

	/**
	 * Determines if two dates are equal up to no more than the specified most
	 * significant field.
	 *
	 * @param date1 the first date, not <code>null</code>
	 * @param date2 the second date, not <code>null</code>
	 * @param field the field from {@code Calendar}
	 * @return <code>true</code> if equal; otherwise <code>false</code>
	 * @throws IllegalArgumentException if any argument is <code>null</code>
	 * @see #truncate(Date, int)
	 * @see #truncatedEquals(Calendar, Calendar, int)
	 * @since 3.0
	 */
	public static boolean truncatedEquals(final Date date1, final Date date2, final int field) {
		return DateUtils.truncatedEquals(date1, date2, field);

	}

}
