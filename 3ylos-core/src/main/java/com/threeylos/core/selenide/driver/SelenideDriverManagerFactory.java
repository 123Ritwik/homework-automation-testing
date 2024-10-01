package com.threeylos.core.selenide.driver;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 */
@Log4j2
public class SelenideDriverManagerFactory {

    /**
     * Get specific driver
     * @return SeleniumDriverManager
     */
    public static SelenideDriverManager initiateDriver(String driverType) {

        SelenideDriverManager driverManager;
        Configuration.browser = driverType;
        driverManager = switch (driverType) {
            case "edge" -> new SelenideEdgeDriverManager();
            case "firefox" -> new SelenideFirefoxDriverManager();
            default -> new SelenideChromeDriverManager();
        };

        return driverManager;

    }

}
