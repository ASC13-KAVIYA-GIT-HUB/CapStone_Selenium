package com.nykaa.utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class ActionHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    //  Constructor
    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.js = (JavascriptExecutor) driver;
    }

    // ✅ Wait until element is visible
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

   
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ✅ Scroll into view safely
    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // ✅ Move to element (hover)
    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // ✅ Click using JS + screenshot + safe sleep
    public void click(By locator, String screenshotName) throws IOException {
        WebElement element = waitForClickable(locator);
        scrollIntoView(element);

        try {
            js.executeScript("arguments[0].click();", element);
            try {
                Thread.sleep(800); // small pause for UI update
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Screenshots.capture(driver, screenshotName);
            System.out.println("Clicked element: " + locator);
        } catch (Exception e) {
            System.out.println(" Click failed for: " + locator + " -> " + e.getMessage());
            Screenshots.capture(driver, screenshotName + "_Failed");
        }
    }

    // ✅ Type text safely with clear + screenshot
    public void type(By locator, String text, String screenshotName) throws IOException {
        WebElement input = waitForVisible(locator);
        scrollIntoView(input);
        input.clear();
        input.sendKeys(text);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Screenshots.capture(driver, screenshotName);
        System.out.println("Typed text into: " + locator);
    }

    // ✅ Press ENTER key
    public void pressEnter(By locator) {
        WebElement input = waitForVisible(locator);
        input.sendKeys(Keys.ENTER);
    }

    // ✅ Verify element presence (for assertions)
    public boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
