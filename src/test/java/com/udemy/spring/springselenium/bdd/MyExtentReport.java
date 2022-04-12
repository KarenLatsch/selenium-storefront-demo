package com.udemy.spring.springselenium.bdd;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.BeforeAll;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;


public class MyExtentReport {
    ExtentReports extent;

    public void configExtentReports(){
        String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("My Storefront Demo Test Report");
        reporter.config().setDocumentTitle("My Storfront Demo Test Report");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Operating System", "Windows 10");
        extent.setSystemInfo("Tested by", "Karen");
    }

    public void flushReport(){
        extent.flush();
    }
}
