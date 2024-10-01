package com.threeylos.core.selenium.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author AbhinitKumar
 *
 */
public abstract class SeleniumDriverManager {

	private static final Logger logger = LogManager.getLogger(SeleniumDriverManager.class);

	protected WebDriver driver;

	protected abstract void createWebDriver();

	/**
	 * Quit current web driver
	 */
	public void quitWebDriver() {
		if (null != driver) {
			logger.debug("Driver quit is starting...");
			driver.quit();
			driver = null;
			logger.debug("Driver quit succesful");
		}

	}

	/**
	 * 
	 * Create new web driver
	 * 
	 * @return WebDriver
	 */
	public WebDriver getWebDriver() {

		if (null == driver) {
			logger.debug("New web driver creation has been started");
			createWebDriver();
			logger.debug("New web driver created succesful");
		}

		return driver;

	}

}
