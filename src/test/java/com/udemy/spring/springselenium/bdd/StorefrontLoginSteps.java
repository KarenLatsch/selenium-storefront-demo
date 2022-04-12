package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.pages.AppPages;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class StorefrontLoginSteps extends MyExtentReport{

    @Autowired
    private AppPages appPages;

    @Then("the login status as of {string} should be expected")
    public void theLoginStatusAsOfShouldBeExpected(String loginstatus) {
        WebElement myAccount;
        String actualLoginStatus = "Successful";

        try {
            appPages.customerHomePage.clickLogoutLink();
        } catch (Exception e) {
            actualLoginStatus = "Failure";
        }
        Assert.assertNotEquals(loginstatus, actualLoginStatus);
    }

}
