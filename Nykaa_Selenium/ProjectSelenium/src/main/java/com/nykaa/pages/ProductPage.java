package com.nykaa.pages;

import org.openqa.selenium.*;
import java.io.IOException;
import java.util.Set;
import com.nykaa.utilities.ActionHelper;
import com.nykaa.utilities.Screenshots;

public class ProductPage {
    WebDriver driver;
    ActionHelper helper;

    By firstProduct = By.cssSelector(".css-xrzmfa");
    By addToBagButton = By.cssSelector(".btn-text");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ActionHelper(driver);
    }

    public void selectFirstProduct() throws IOException {
        helper.click(firstProduct, "SelectFirstProduct");

        // Switch to new product tab
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            driver.switchTo().window(tab);
        }
        System.out.println(" Switched to product tab");
        Screenshots.capture(driver, "SwitchedToProductTab");
    }

    public void addToBag() throws IOException {
        helper.click(addToBagButton, "ClickAddToBag");
        System.out.println(" Added product to bag");
    }
}
