package com.nykaa.pages;

import org.openqa.selenium.*;
import java.io.IOException;
import com.nykaa.utilities.ActionHelper;

public class CartPage {
    WebDriver driver;
    ActionHelper helper;

    By bagIcon = By.id("header-bag-icon");
    By proceedButton = By.cssSelector(".css-1l90yrs");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ActionHelper(driver);
    }

    public void openBag() throws IOException {
        helper.click(bagIcon, "OpenBag");
        System.out.println("Opened shopping bag");
    }

    public void proceedToCheckout() throws IOException {
        helper.click(proceedButton, "ProceedToCheckout");
        System.out.println("Proceeded to checkout");
    }
}
