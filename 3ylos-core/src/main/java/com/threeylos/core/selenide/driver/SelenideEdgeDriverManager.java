package com.threeylos.core.selenide.driver;

import com.codeborne.selenide.Configuration;
import com.threeylos.core.selenide.config.SelenideConfig;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author AbhinitKumar
 */
@Log4j2
public class SelenideEdgeDriverManager extends SelenideDriverManager {


    @Override
    protected void setDriverProperty() {
        log.debug("Edge Driver property are being set");
        Configuration.timeout = SelenideConfig.getTimeOut();// default 5000
        Configuration.pageLoadTimeout = SelenideConfig.getPageLoadTimeOut();// default 5000
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("requireWindowFocus", true);
        Configuration.browserVersion = "9";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        edgeOptions.merge(capabilities);
        Configuration.browserCapabilities = capabilities;
    }
}
