package com.udemy.spring.springselenium.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyExtentReport {
    ExtentReports extent;

    ExtentTest eTest;


    @PostConstruct
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

    public ExtentTest getETest() {
        return eTest;
    }

    public ExtentTest createTest(String testName, String scenario){
        eTest = extent.createTest( testName + " - " + scenario);
        return eTest;
    }

    @PreDestroy
    public void flushReport(){
        extent.flush();
    }
}
