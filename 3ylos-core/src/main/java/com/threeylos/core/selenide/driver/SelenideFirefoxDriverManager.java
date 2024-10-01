package com.threeylos.core.selenide.driver;

import com.codeborne.selenide.Configuration;
import com.threeylos.core.selenide.config.SelenideConfig;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author AbhinitKumar
 */
@Log4j2
public class SelenideFirefoxDriverManager extends SelenideDriverManager {
    private boolean isHeadless;

    @Override
    protected void setDriverProperty() {
        log.debug("Firefox Driver property are being set");
        Configuration.timeout = SelenideConfig.getTimeOut();// default 5000
        Configuration.pageLoadTimeout = SelenideConfig.getPageLoadTimeOut();// default 5000
        FirefoxOptions firefoxOptionsOptions = new FirefoxOptions();
        firefoxOptionsOptions.addArguments("disable-infobars");
        firefoxOptionsOptions.addArguments("--disable-extensions");
        firefoxOptionsOptions.addArguments("--disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptionsOptions);
        Configuration.browserCapabilities = capabilities;
    }

    public boolean isHeadless() {
        return isHeadless;
    }

    public void setHeadless(boolean headless) {
        isHeadless = headless;
    }
}
