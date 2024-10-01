package com.threeylos.core.util.common;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang3.LocaleUtils;

/**
 * <p>
 * Operations to assist when working with a {@link Locale}.
 * </p>
 *
 * <p>
 * This class tries to handle {@code null} input gracefully. An exception will
 * not be thrown for a {@code null} input. Each method documents its behaviour
 * in more detail.
 * </p>
 *
 * @since 1.0
 * @author AbhinitKumar
 */
public class LocaleUtil {

	/**
	 * <p>
	 * {@code LocaleUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code LocaleUtils.toLocale("en_GB");}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public LocaleUtil() {
		super();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to a Locale.
	 * </p>
	 *
	 * <p>
	 * This method takes the string format of a locale and creates the locale object
	 * from it.
	 * </p>
	 *
	 * <pre>
	 *   LocaleUtils.toLocale("")           = new Locale("", "")
	 *   LocaleUtils.toLocale("en")         = new Locale("en", "")
	 *   LocaleUtils.toLocale("en_GB")      = new Locale("en", "GB")
	 *   LocaleUtils.toLocale("en_001")     = new Locale("en", "001")
	 *   LocaleUtils.toLocale("en_GB_xxx")  = new Locale("en", "GB", "xxx")   (#)
	 * </pre>
	 *
	 * <p>
	 * (#) The behaviour of the JDK variant constructor changed between JDK1.3 and
	 * JDK1.4. In JDK1.3, the constructor upper cases the variant, in JDK1.4, it
	 * doesn't. Thus, the result from getVariant() may vary depending on your JDK.
	 * </p>
	 *
	 * <p>
	 * This method validates the input strictly. The language code must be
	 * lowercase. The country code must be uppercase. The separator must be an
	 * underscore. The length must be correct.
	 * </p>
	 *
	 * @param str the locale String to convert, null returns null
	 * @return a Locale, null if null input
	 * @throws IllegalArgumentException if the string is an invalid format
	 * @see Locale#forLanguageTag(String)
	 */
	public static Locale toLocale(final String str) {
		return LocaleUtils.toLocale(str);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains the list of locales to search through when performing a locale
	 * search.
	 * </p>
	 *
	 * <pre>
	 * localeLookupList(Locale("fr", "CA", "xxx"))
	 *   = [Locale("fr", "CA", "xxx"), Locale("fr", "CA"), Locale("fr")]
	 * </pre>
	 *
	 * @param locale the locale to start from
	 * @return the unmodifiable list of Locale objects, 0 being locale, not null
	 */
	public static List<Locale> localeLookupList(final Locale locale) {
		return LocaleUtils.localeLookupList(locale);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains the list of locales to search through when performing a locale
	 * search.
	 * </p>
	 *
	 * <pre>
	 * localeLookupList(Locale("fr", "CA", "xxx"), Locale("en"))
	 *   = [Locale("fr", "CA", "xxx"), Locale("fr", "CA"), Locale("fr"), Locale("en"]
	 * </pre>
	 *
	 * <p>
	 * The result list begins with the most specific locale, then the next more
	 * general and so on, finishing with the default locale. The list will never
	 * contain the same locale twice.
	 * </p>
	 *
	 * @param locale        the locale to start from, null returns empty list
	 * @param defaultLocale the default locale to use if no other is found
	 * @return the unmodifiable list of Locale objects, 0 being locale, not null
	 */
	public static List<Locale> localeLookupList(final Locale locale, final Locale defaultLocale) {
		return LocaleUtils.localeLookupList(locale, defaultLocale);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains an unmodifiable list of installed locales.
	 * </p>
	 *
	 * <p>
	 * This method is a wrapper around {@link Locale#getAvailableLocales()}. It is
	 * more efficient, as the JDK method must create a new array each time it is
	 * called.
	 * </p>
	 *
	 * @return the unmodifiable list of available locales
	 */
	public static List<Locale> availableLocaleList() {
		return LocaleUtils.availableLocaleList();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains an unmodifiable set of installed locales.
	 * </p>
	 *
	 * <p>
	 * This method is a wrapper around {@link Locale#getAvailableLocales()}. It is
	 * more efficient, as the JDK method must create a new array each time it is
	 * called.
	 * </p>
	 *
	 * @return the unmodifiable set of available locales
	 */
	public static Set<Locale> availableLocaleSet() {
		return LocaleUtils.availableLocaleSet();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the locale specified is in the list of available locales.
	 * </p>
	 *
	 * @param locale the Locale object to check if it is available
	 * @return true if the locale is a known locale
	 */
	public static boolean isAvailableLocale(final Locale locale) {
		return LocaleUtils.isAvailableLocale(locale);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains the list of languages supported for a given country.
	 * </p>
	 *
	 * <p>
	 * This method takes a country code and searches to find the languages available
	 * for that country. Variant locales are removed.
	 * </p>
	 *
	 * @param countryCode the 2 letter country code, null returns empty
	 * @return an unmodifiable List of Locale objects, not null
	 */
	public static List<Locale> languagesByCountry(final String countryCode) {
		return LocaleUtils.languagesByCountry(countryCode);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Obtains the list of countries supported for a given language.
	 * </p>
	 *
	 * <p>
	 * This method takes a language code and searches to find the countries
	 * available for that language. Variant locales are removed.
	 * </p>
	 *
	 * @param languageCode the 2 letter language code, null returns empty
	 * @return an unmodifiable List of Locale objects, not null
	 */
	public static List<Locale> countriesByLanguage(final String languageCode) {
		return LocaleUtils.countriesByLanguage(languageCode);
	}

}
