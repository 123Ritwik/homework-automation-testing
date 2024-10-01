package com.threeylos.core.selenium.driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


/**
 * @author AbhinitKumar
 *
 */
public class SeleniumEdgeDriverManager extends SeleniumDriverManager {

	@Override
	protected void createWebDriver() {
		EdgeOptions options = new EdgeOptions();
		// TODO set the all chrome option.
		this.driver = new EdgeDriver(options);

	}

}
