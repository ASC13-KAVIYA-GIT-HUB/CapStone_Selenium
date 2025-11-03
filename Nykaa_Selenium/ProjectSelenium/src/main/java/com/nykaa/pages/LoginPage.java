package com.nykaa.pages;

import org.openqa.selenium.*;
import java.io.IOException;
import com.nykaa.utilities.ActionHelper;

public class LoginPage {
    WebDriver driver;
    ActionHelper helper;

    By signInButton = By.xpath("//button[contains(., 'Sign in') or contains(., 'Login')]");
    By mobileEmailOption = By.xpath("//button[contains(., 'Sign in with Mobile / Email')]");
    By mobileField = By.xpath("//input[@type='tel' or @placeholder='Enter Phone Number']");
    
    By getOtpButton = By.className("css-15q5a8e");
    //By getOtpButton = By.xpath("//button[contains(., 'Send OTP') or contains(., 'Get OTP')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ActionHelper(driver);
    }

    public void openNykaa() {
        driver.get("https://www.nykaa.com/");
        System.out.println("Opened Nykaa homepage");
    }

    public void loginWithMobile(String phoneNumber) throws IOException, InterruptedException {
        helper.click(signInButton, "ClickSignIn");
        helper.click(mobileEmailOption, "SelectMobileLogin");
        helper.type(mobileField, phoneNumber, "EnterMobileNumber");
        helper.click(getOtpButton, "ClickGetOtp");
        System.out.println("OTP sent — Enter it Manually within 30 seconds...");
        Thread.sleep(30000);
    }
}

