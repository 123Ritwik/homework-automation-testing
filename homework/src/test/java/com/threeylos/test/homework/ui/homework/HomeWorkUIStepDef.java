package com.threeylos.test.homework.ui.homework;

import static org.testng.Assert.assertEquals;

import lombok.extern.log4j.Log4j2;

import com.threeylos.core.constant.DriverType;
import com.threeylos.core.selenium.SeleniumBase;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;

@Log4j2
public class HomeWorkUIStepDef extends SeleniumBase {

	@After
	public void closeWebDriver() {
		quitWebDriver();
	}

	@Given("Launch the admin-web")
	public void lunchAdminWeb() throws Exception {
		init(DriverType.CHROME);
		log.info("Chrome is launching..");
		launchApp();
	}

	@Given("Verify page title")
	public void verifyTitle() throws Exception {
		assertEquals("", "");
		log.info("Verified: Actual Page title :: {} ", getPageTitle());
	}

}
