/*package com.nykaa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    static String projectpath = System.getProperty("user.dir");

    public static ExtentReports getinstance() {
        if (extent == null) {
            String reportpath = projectpath + "\\src\\test\\resources\\Reports\\NykaaReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
*/
package com.nykaa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;
    static String projectpath = System.getProperty("user.dir");

    public static ExtentReports getinstance() {
        if (extent == null) {
            String reportFolder = projectpath + "\\src\\test\\resources\\Reports";
            new File(reportFolder).mkdirs(); // make sure folder exists

            String reportPath = reportFolder + "\\NykaaReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
