package com.threeylos.core.selenium.driver;

import com.threeylos.core.constant.DriverType;

/**
 * @author AbhinitKumar
 */
public class SeleniumDriverManagerFactory {

    /**
     * Get specific driver
     *
     * @return SeleniumDriverManager
     */
    public static SeleniumDriverManager getDriverManager(DriverType driverType) {
        return switch (driverType) {
            case EDGE -> new SeleniumEdgeDriverManager();
            case FIREFOX -> new SeleniumFirefoxDriverManager();
            default -> new SeleniumChromeDriverManager();
        };
    }

}
