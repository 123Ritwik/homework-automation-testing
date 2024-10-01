package com.threeylos.core.util.common;

import java.util.regex.Pattern;

/**
 * @author AbhinitKumar
 *
 */
public final class RegexPatternUtil {

	private final static String PHONE_PATTERN = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";

	private final static String IND_VEC_PATTERN = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";

	private final static String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	private final static String DIGIT = "^[0-9]+$";

	private RegexPatternUtil() {

	}

	public static void main(String[] args) {
		System.out.println(isDigit("1237"));
	}

	/**
	 * This method use for compile Regex and match.
	 * 
	 * @param pattern as {@link String} eg: {@linkplain #EMAIL_PATTERN}
	 * @param text    as {@link String}
	 * @return {@link Boolean}
	 */
	private static boolean getPatternMatcher(String pattern, String text) {
		if (text == null || text.isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		return p.matcher(text).matches();
	}

	/**
	 * Check for string value must be digit. </br>
	 * 
	 * <h1>Using regex {@link #DIGIT}
	 * <h1>
	 * 
	 * @param digit :{@literal String}
	 * @return {@link Boolean}
	 */
	public static boolean isDigit(String digit) {
		return getPatternMatcher(DIGIT, digit);

	}

	/**
	 * @param phoneNumber
	 * @return {@link Boolean}
	 */
	public static boolean isPhoneNumber(String phoneNumber) {
		return getPatternMatcher(PHONE_PATTERN, phoneNumber);

	}

	public static boolean isEmail(String email) {
		return getPatternMatcher(EMAIL_PATTERN, email);

	}

	public static boolean isIndiaVehicle(String vehicle) {
		return getPatternMatcher(IND_VEC_PATTERN, vehicle);

	}

}
