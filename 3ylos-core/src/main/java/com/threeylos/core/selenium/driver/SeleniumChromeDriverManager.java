package com.threeylos.core.selenium.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

@Log4j2
public class SeleniumChromeDriverManager extends SeleniumDriverManager {


    @Override
    protected void createWebDriver() {
        log.debug("Chrome new driver creation in progress... ");
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-popup-blocking");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();

        } catch (Exception e) {
            log.info("Get error in creating driver", e);
        }

    }

}
