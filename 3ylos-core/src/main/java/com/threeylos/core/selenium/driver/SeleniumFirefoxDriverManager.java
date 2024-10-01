package com.threeylos.core.selenium.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


/**
 * @author AbhinitKumar
 *
 */
public class SeleniumFirefoxDriverManager  extends SeleniumDriverManager {
	
	@Override
	protected void createWebDriver() {
		FirefoxOptions options = new FirefoxOptions();
		// TODO set the all chrome option.
		this.driver = new FirefoxDriver(options);

	}

}
