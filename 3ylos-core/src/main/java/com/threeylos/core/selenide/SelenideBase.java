package com.threeylos.core.selenide;

import com.codeborne.selenide.*;
import com.threeylos.core.selenide.config.SelenideConfig;
import com.threeylos.core.selenide.driver.SelenideDriverManager;
import com.threeylos.core.selenide.driver.SelenideDriverManagerFactory;
import com.threeylos.core.util.assertion.UiAssertions;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author AbhinitKumar
 */
@Log4j2
public class SelenideBase extends UiAssertions {


    private static Boolean getScreenshot;

    protected void init(String driverType) {
        SelenideDriverManager driverManager = SelenideDriverManagerFactory.initiateDriver(driverType);
        Configuration.baseUrl = SelenideConfig.getRootUrl();
        Configuration.screenshots = SelenideConfig.isScreenshot();
        Configuration.reportsFolder = SelenideConfig.getReportFolderPath();

    }

    protected void launchApp() {
        open();
    }

    protected void launchApp(String urlToOpen) {
        open(urlToOpen);
    }

    protected void quit() {
        closeWebDriver();
    }

    protected void close() {
        closeWindow();
    }

    protected String getPageTitle() {
        return WebDriverRunner.getWebDriver()
                .getTitle();
    }

    protected SelenideElement findElementByXpath(String elmLocatorXpath) {
        return $(By.xpath(elmLocatorXpath));
    }

    protected SelenideElement findElementById(String elmLocator) {
        return $(By.id(elmLocator));
    }

    protected ElementsCollection findElementsByXpath(String elmLocatorXpath) {
        return $$(By.xpath(elmLocatorXpath));
    }

    protected ElementsCollection findElementsById(String elmLocator) {
        return $$(By.id(elmLocator));
    }

    protected void onClick(SelenideElement element) {
        element.shouldBe(enabled, visible);
        element.click();
    }

    protected void waitUntil(ElementsCollection element, WebElementsCondition elementsCondition) {
        element.shouldBe(elementsCondition, Duration.of(10, SECONDS));
    }

    protected void waitUntil(SelenideElement element, WebElementCondition condition, Duration time) {
        element.shouldBe(condition, time);
    }
}
