package com.threeylos.core.selenide.config;


import com.threeylos.core.config.ApplicationProperties;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 */
@Log4j2
public final class SelenideConfig {

	private SelenideConfig() {}

	private static final String UI_BASE_URL = "ui-base-url";
	private static final String ROOT_SELENIUM_URL;

	private static final boolean IS_SCREENSHOT;

	private static final String REPORT_PATH;

	private static final long TIMEOUT;

	private static final long PAGE_LOAD_TIMEOUT;

	static {
		String systemURL = System.getenv("UI_BASE_URL");
		ROOT_SELENIUM_URL = systemURL == null ? ApplicationProperties.getValue("UI_BASE_URL") : systemURL;
		IS_SCREENSHOT =
		        System.getenv("IS_SCREENSHOT") != null && Boolean.parseBoolean(ApplicationProperties.getValue("IS_SCREENSHOT"));
		REPORT_PATH = System.getenv("REPORT_PATH") == null ? "build/reports/selenide-reports"
		        : ApplicationProperties.getValue("REPORT_PATH");
		PAGE_LOAD_TIMEOUT = System.getenv("PAGE_LOAD_TIMEOUT") == null ? 5000
		        : Long.parseLong(ApplicationProperties.getValue("PAGE_LOAD_TIMEOUT"));
		TIMEOUT = System.getenv("TIMEOUT") == null ? 5000 : Long.parseLong(ApplicationProperties.getValue("TIMEOUT"));

	}

	public static String getRootUrl() {
		return ROOT_SELENIUM_URL;
	}

	public static boolean isScreenshot() {
		return IS_SCREENSHOT;
	}

	public static String getReportFolderPath() {
		return REPORT_PATH;
	}

	public static long getTimeOut() {
		return PAGE_LOAD_TIMEOUT;
	}

	public static long getPageLoadTimeOut() {
		return TIMEOUT;
	}
}
