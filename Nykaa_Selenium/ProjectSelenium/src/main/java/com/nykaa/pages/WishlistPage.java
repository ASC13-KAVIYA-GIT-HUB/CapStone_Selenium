package com.nykaa.pages;

import org.openqa.selenium.*;
import com.nykaa.utilities.ActionHelper;
import java.io.IOException;

public class WishlistPage {
    WebDriver driver;
    ActionHelper helper;

    By firstProduct = By.cssSelector(".css-xrzmfa");
    By wishlistButton = By.cssSelector(".wishlist_button_text.css-17jex54");

    
    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        helper = new ActionHelper(driver);
    }

    public void addToWishlist() throws IOException {
        WebElement product = helper.waitForVisible(firstProduct);
        helper.hover(product);
        helper.click(wishlistButton, "AddToWishlist");
    }
}
