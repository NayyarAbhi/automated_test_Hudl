package com.automatedtest.hudl.basepage;

import com.automatedtest.hudl.infrastructure.driver.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    private static final String CONFIGFILEPATH = "src/test/resources/config.properties";
    public static Properties properties;

    /**
     * initializing driver
     */
    public BasePage() {
        this.driver = Setup.driver;
    }


    /** loading properties file
     * */
    static {
        File file = new File(CONFIGFILEPATH);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Page Operation related methods
     */
    public void click(WebElement webElement) {
        webElement.click();
    }

    public void clearText(WebElement webElement) {
        webElement.clear();
    }

    public void sendKeys(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }


    /**
     * Element Validation Related Methods
     */
    public boolean isElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public boolean isElementEnabled(WebElement webElement) {
        return webElement.isEnabled();
    }

    public boolean isElementSelected(WebElement webElement) {
        return webElement.isSelected();
    }


    /**
     * Browser Window Related Methods
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public String getWindowTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    /**
     * Wait Related Methods
     */
    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void waitTillElementIsVisible(int timeout, WebElement webElement) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = " element wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void waitTillElementIsClickable(int timeout, WebElement webElement) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(webElement);
        String timeoutMessage = " element wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }
}
