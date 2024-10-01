package com.threeylos.core.selenium.config;

import com.threeylos.core.config.ApplicationProperties;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 *
 */
@Log4j2
public final class SeleniumConfig {

	private SeleniumConfig() {
	}

	private static final String ROOT_SELENIUM_URL;

	static {
		String systemURL = System.getProperty("UI_BASE_URL");
		ROOT_SELENIUM_URL = systemURL == null ? ApplicationProperties.getValue("UI_BASE_URL") : systemURL;

	}

	public static String getRootSeleniumUrl() {
		return ROOT_SELENIUM_URL;
	}

}
