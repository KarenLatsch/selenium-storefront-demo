package com.udemy.spring.springselenium.bdd;

import com.aventstack.extentreports.ExtentTest;
import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class StorefrontLoginSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    MyExtentReport myExtentReport;


    @Then("the login status as of {string} should be expected")
    public void theLoginStatusAsOfShouldBeExpected(String loginstatus) {
        WebElement myAccount;
        String actualLoginStatus = "Successful";

        try {
            appPages.customerHomePage.clickLogoutLink();
            myExtentReport.getETest().info("Clicked on Logout");
        } catch (Exception e) {
            actualLoginStatus = "Failure";

        }

        try {
            Assert.assertNotEquals(loginstatus, actualLoginStatus);
        } catch (Exception e){
            myExtentReport.getETest().fail("Actual Login Status is Differs from Expected Status");
        }

    }

}
