package com.nykaa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.nykaa.utilities.ExtentManager;
import com.nykaa.utilities.Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class Base {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getinstance();
    }

    @BeforeMethod
    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Screenshots.capture(driver, result.getName());
            test.fail("Test Failed: " + result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshotPath = Screenshots.capture(driver, result.getName());
            test.pass("Test Passed")
                .addScreenCaptureFromPath(screenshotPath);
        }

        driver.quit();
    }
    
    
    @AfterSuite
    public void closeReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

