package com.threeylos.core.selenide.driver;

import com.codeborne.selenide.Configuration;
import com.threeylos.core.selenide.config.SelenideConfig;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * @author AbhinitKumar
 *
 */
@Log4j2
public class SelenideChromeDriverManager extends SelenideDriverManager {

    private boolean isHeadless;

    @Override
    protected void setDriverProperty() {
        log.debug("Chrome Driver property are being set");
        Configuration.timeout = SelenideConfig.getTimeOut();// default 5000
        Configuration.pageLoadTimeout = SelenideConfig.getPageLoadTimeOut();// default 5000
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-popup-blocking");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        // Configuration.browserSize="1000x1000";

    }

    public boolean isHeadless() {
        return isHeadless;
    }

    public void setHeadless(boolean headless) {
        isHeadless = headless;
    }
}
