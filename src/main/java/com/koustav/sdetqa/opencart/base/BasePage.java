package com.koustav.sdetqa.opencart.base;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // ✅ Logger (one per class – best practice)
    protected final Logger logger =
            LogManager.getLogger(getClass());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("BasePage initialized");
    }

    /* ========================= WAITS ========================= */

    protected void waitForElementVisible(By locator) {
        logger.debug("Waiting for element visibility: {}", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementClickable(By locator) {
        logger.debug("Waiting for element clickable: {}", locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementPresence(By locator) {
        logger.debug("Waiting for element presence: {}", locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForTitleContains(String titleFraction) {
        logger.info("Waiting for title to contain: {}", titleFraction);
        wait.until(ExpectedConditions.titleContains(titleFraction));
    }

    protected void waitForPageLoad() {
        logger.info("Waiting for page to load completely");
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    /* ========================= BASIC ACTIONS ========================= */

//    protected void doClick(By locator) {
//        logger.info("Clicking on element: {}", locator);
//        waitForElementClickable(locator);
//        driver.findElement(locator).click();
//    }
    
    //Action methods always have try catch block so that in log any one can easily under stand the step which is not run
    protected void doClick(By locator) {
        try {
            logger.info("Clicking on element: {}", locator);
            waitForElementClickable(locator);
            driver.findElement(locator).click();
        } catch (Exception e) {
            logger.error("Failed to click on element: {}", locator, e);
            throw e;   // very important
        }
    }

    protected void doSendKeys(By locator, String value) {
        logger.info("Entering text into element: {}", locator);
        waitForElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String doGetText(By locator) {
        logger.info("Getting text from element: {}", locator);
        waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        logger.info("Checking visibility of element: {}", locator);
        waitForElementVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    protected String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Current page title: {}", title);
        return title;
    }

    /* ========================= DROPDOWN ========================= */

    protected void selectByVisibleText(By locator, String text) {
        logger.info("Selecting '{}' from dropdown: {}", text, locator);
        waitForElementVisible(locator);
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    /* ========================= JAVASCRIPT ========================= */

    protected void scrollIntoView(By locator) {
        logger.info("Scrolling to element: {}", locator);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void jsClick(By locator) {
        logger.warn("Performing JS click on element: {}", locator);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    /* ========================= ACTIONS (MOUSE) ========================= */

    protected void hover(By locator) {
        logger.info("Hovering over element: {}", locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    /* ========================= ALERTS ========================= */

    protected Alert waitForAlert() {
        logger.info("Waiting for alert to be present");
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        logger.info("Accepting alert");
        waitForAlert().accept();
    }

    protected String getAlertText() {
        String alertText = waitForAlert().getText();
        logger.info("Alert text: {}", alertText);
        return alertText;
    }

    /* ========================= FRAMES ========================= */

    protected void switchToFrame(By locator) {
        logger.info("Switching to frame: {}", locator);
        waitForElementPresence(locator);
        driver.switchTo().frame(driver.findElement(locator));
    }

    protected void switchToDefaultContent() {
        logger.info("Switching back to default content");
        driver.switchTo().defaultContent();
    }

    /* ========================= WINDOWS ========================= */

    protected void switchToWindowByTitle(String title) {
        logger.info("Switching to window with title: {}", title);
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                logger.info("Switched to window: {}", title);
                break;
            }
        }
    }

    /* ========================= NAVIGATION ========================= */

    protected void refreshPage() {
        logger.info("Refreshing the page");
        driver.navigate().refresh();
    }
}
