package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class StorefrontLoginSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    MyExtentReport myExtentReport;


    @Then("the login status as of {string} should be expected")
    public void theLoginStatusAsOfShouldBeExpected(String loginstatus) {
        String actualLoginStatus = "Successful";

        try {
            appPages.customerHomePage.clickLogoutLink();
            myExtentReport.getETest().info("Clicked on Logout");
        } catch (Exception e) {
            actualLoginStatus = "Failure";
        }
        Assert.assertNotEquals(loginstatus, actualLoginStatus);
    }

}
