package com.threeylos.core.selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import com.threeylos.core.selenium.driver.SeleniumDriverManager;
import com.threeylos.core.util.assertion.UiAssertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.threeylos.core.selenium.config.SeleniumConfig;
import com.threeylos.core.constant.DriverType;
import com.threeylos.core.selenium.driver.SeleniumDriverManagerFactory;
import com.threeylos.core.util.common.FileUtil;
import com.threeylos.core.util.common.StringUtil;


/**
 * @author AbhinitKumar
 *
 */
public abstract class SeleniumBase  extends UiAssertions {

    private static final Logger logger = LogManager.getLogger(SeleniumBase.class);

    private SeleniumDriverManager driverManager;
    private WebDriverWait wait = null;

    protected void init(DriverType driverType) {
        this.driverManager = SeleniumDriverManagerFactory.getDriverManager(driverType);
        this.wait = new WebDriverWait(driverManager.getWebDriver(), Duration.ofMillis(50));
    }

    protected WebDriver getDriver() {
        return driverManager.getWebDriver();
    }

    protected void waitUntilElementVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        logger.debug("Web Element:{} is visible", element.getText());
    }

    protected void launchApp() {
        driverManager.getWebDriver().get(SeleniumConfig.getRootSeleniumUrl());
    }

    protected void launchApp(String urlToOpen) {
        driverManager.getWebDriver().get(SeleniumConfig.getRootSeleniumUrl() + urlToOpen);
    }

    /**
     * Quit current web driver
     */
    protected void quitWebDriver() {
        driverManager.quitWebDriver();

    }

    protected WebElement findElementByXpath(String elmLocatorXpath) {
        return driverManager.getWebDriver().findElement(By.xpath(elmLocatorXpath));
    }

    protected List<WebElement> findElementsByXpath(String elmLocatorXpath) {
        return driverManager.getWebDriver().findElements(By.xpath(elmLocatorXpath));
    }

    protected WebElement findElementByXpath(By byXpath) {
        return driverManager.getWebDriver().findElement(byXpath);
    }

    protected List<WebElement> findElementsByXpath(By byXpath) {
        return driverManager.getWebDriver().findElements(byXpath);
    }

    protected WebElement findElementByCSS(By byCSS) {
        return driverManager.getWebDriver().findElement(byCSS);
    }

    protected List<WebElement> findElementsByCSS(By byCSS) {
        return driverManager.getWebDriver().findElements(byCSS);
    }

    protected WebElement findElementByCSS(String elmLocatorCSS) {
        return driverManager.getWebDriver().findElement(By.cssSelector(elmLocatorCSS));
    }

    protected List<WebElement> findElementsByCSS(String elmLocatorCSS) {
        return driverManager.getWebDriver().findElements(By.cssSelector(elmLocatorCSS));
    }

    protected void clickOnElement(WebElement element, String elementName) {
        this.waitUntilElementVisibility(element);
        element.click();

    }

    public boolean isElementVisible(WebElement element) {
        this.waitUntilElementVisibility(element);
        return element.isDisplayed();
    }

    protected void navigatePage(String navDirection) {
        if (StringUtil.equalsAny(navDirection, "Forward"))
            driverManager.getWebDriver().navigate().forward();
        else
            driverManager.getWebDriver().navigate().back();
    }

    protected void writeInEntryField(String fieldName, WebElement weElm, String inputData) {
        weElm.clear();
        weElm.sendKeys(inputData);
        logger.debug(" {} : was entered with data-{} ", fieldName, inputData);
    }

    protected String getPageTitle() {
        return driverManager.getWebDriver().getTitle();

    }

    protected void javaScriptClick(WebElement element, String elmName) {

        if (element.isEnabled() && element.isDisplayed()) {
            logger.debug("Clicking on element: {} using java script click", elmName);
            ((JavascriptExecutor) driverManager.getWebDriver()).executeScript("arguments[0].click();", element);
        }
    }

    protected void wait(int timeSeconds) throws InterruptedException {
        Thread.sleep(timeSeconds * 1000L);
    }

    protected void waitForElementVisibility(WebElement webElement, long timeOutSeconds) {
        final WebDriverWait wait = new WebDriverWait(driverManager.getWebDriver(), Duration.ofMillis(timeOutSeconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

    public int verifyRecordCountInList(String fieldName, List<WebElement> rows) {
        return rows.size();
    }

    protected void screenshot(String screenShotFileName) {
        try {
            String screenShot = System.getProperty("user.dir") + "/" + screenShotFileName;
            File scrFile = ((TakesScreenshot) driverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtil.copyFile(scrFile, new File(screenShot));
        } catch (WebDriverException | IOException e) {
            logger.error("Get error while take screen shot name: {}", screenShotFileName, e);
        }
    }

    protected void partialScreenshot(String screenShotFileName, WebElement element) {

        try {
            String screenShot = System.getProperty("user.dir") + "/" + screenShotFileName;
            File screen = ((TakesScreenshot) driverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);

            Point p = element.getLocation();

            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();

            BufferedImage img = ImageIO.read(screen);
            BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);
            ImageIO.write(dest, "png", screen);

            FileUtil.copyFile(screen, new File(screenShot));
        } catch (WebDriverException | IOException e) {
            logger.error("Get error while take screen shot name: {}", screenShotFileName, e);
        }

    }

    protected void refresh() {
        driverManager.getWebDriver().navigate().refresh();
    }

    protected void selectByVisibleText(String text, String xpath) {
        Select dropdown = new Select(driverManager.getWebDriver().findElement(By.xpath(xpath)));
        dropdown.deselectAll();
        dropdown.selectByVisibleText(text);

    }

    protected WebElement getFirstSelectedOption(String xpath) {
        Select dropdown = new Select(driverManager.getWebDriver().findElement(By.xpath(xpath)));
        dropdown.deselectAll();
        return dropdown.getFirstSelectedOption();

    }

    protected void switchNewWindow() {
        for (String hNew : driverManager.getWebDriver().getWindowHandles()) {
            driverManager.getWebDriver().switchTo().window(hNew);
        }
    }

    protected void switchBackToFirstWindow() {
        String hBefore = driverManager.getWebDriver().getWindowHandle();
        driverManager.getWebDriver().switchTo().window(hBefore);

    }

    protected void mouseover(String itemXpath, String expressionXpath) {
        Actions action = new Actions(driverManager.getWebDriver());
        WebElement item = driverManager.getWebDriver().findElement(By.xpath(itemXpath));
        WebElement expression = driverManager.getWebDriver().findElement(By.xpath(itemXpath));
        action.moveToElement(item).moveToElement(expression).click().build().perform();

    }

}
