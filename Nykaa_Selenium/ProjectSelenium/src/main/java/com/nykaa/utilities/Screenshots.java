/*package com.nykaa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

    static String projectpath = System.getProperty("user.dir");

    public static String capture(WebDriver driver, String stepName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        String dest = projectpath + "\\src\\test\\resources\\Screenshots\\" + stepName + "_" + timestamp + ".png";

        File destfile = new File(dest);
        FileUtils.copyFile(src, destfile);

        return dest;
    }
}*/
package com.nykaa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

    static String projectpath = System.getProperty("user.dir");

    public static String capture(WebDriver driver, String stepName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        String screenshotFolder = projectpath + "\\src\\test\\resources\\Screenshots";
        new File(screenshotFolder).mkdirs(); //create folder if not exist

        String dest = screenshotFolder + "\\" + stepName + "_" + timestamp + ".png";
        File destFile = new File(dest);
        FileUtils.copyFile(src, destFile);

        return dest;
    }
}
