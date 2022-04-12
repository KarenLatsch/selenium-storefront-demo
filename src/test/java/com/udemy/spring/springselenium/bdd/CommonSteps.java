package com.udemy.spring.springselenium.bdd;

import com.aventstack.extentreports.ExtentTest;
import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;


@SpringBootTest
@CucumberContextConfiguration
public class CommonSteps extends MyExtentReport{

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;

    @Lazy
    @Autowired
    private ApplicationContext applicationContext;

    ExtentTest eTest;


    @After
    public void flushExtentReport(){
//        this.applicationContext.getBean(WebDriver.class).quit();
        flushReport();
    }

    @Before
    public void createExtentReport(){
        configExtentReports();
    }



    @Given("I navigate to the StoreFront Demo home page {string}")
    public void navigateToStoreFrontDemoHomePage(String testName) {
        eTest = extent.createTest( testName + " has start");
        myDriver.getStorefrontHomePage();
        eTest.info("Navigating to Storefront Home page");
    }

    @When("I click on the login link")
    public void clickLogin() {
        clickLogout();
        appPages.storefrontHomePage.clickloginLink();
        eTest.info("Clicking Login Link");

    }

    public void clickLogout (){
        try {
            appPages.customerHomePage.clickLogoutLink();
            eTest.info("Clicking Logout Link");
        } catch (Exception e) {
        }
    }

    @And("I then enter in username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        appPages.storefrontLoginPage.sendKeysUsername(username);
        eTest.info("Entering in Username");
        appPages.storefrontLoginPage.sendKeysPassword(password);
        eTest.info("Entering in Password");
    }

    @And("I click on the login button")
    public void ClickLoginButton() {
        appPages.storefrontLoginPage.clickLoginButton();
        eTest.info("Clicking Login Button");
    }

}
