package com.nykaa.pages;

import org.openqa.selenium.*;
import java.io.IOException;
import com.nykaa.utilities.ActionHelper;

public class HomePage {
    WebDriver driver;
    ActionHelper helper;

    By searchBox = By.xpath("//input[contains(@placeholder, 'Search')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ActionHelper(driver);
    }

    public void searchProduct(String productName) throws IOException {
        helper.type(searchBox, productName, "SearchProduct");
        helper.pressEnter(searchBox);
        System.out.println("Searching for: " + productName);
    }
}
