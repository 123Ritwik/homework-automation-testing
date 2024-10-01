package com.threeylos.core.selenide.driver;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AbhinitKumar
 */
@Log4j2
public abstract class SelenideDriverManager {

	private static final Logger logger = LogManager.getLogger(SelenideDriverManager.class);

	protected abstract void setDriverProperty();

	/**
	 * Quit current web driver
	 */
	public void quitWebDriver() {

	}

	/**
	 * Create new web driver
	 *
	 * @return WebDriver
	 */
	public void initiateDriver() {

		logger.debug("New web driver creation has been started");
		setDriverProperty();
		logger.debug("New web driver created successful");

	}

}
