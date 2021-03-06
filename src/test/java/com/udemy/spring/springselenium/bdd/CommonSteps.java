package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

@CucumberContextConfiguration
public class CommonSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;

    @Autowired
    MyExtentReport myExtentReport;

    String scenarioName;

    @Before
    public void getScenarioName(Scenario scenario){
        scenarioName = scenario.getName();
    }

    @Given("I navigate to the StoreFront Demo home page")
    public void navigateToStoreFrontDemoHomePage() {
        myExtentReport.createTest(scenarioName);
        myDriver.getStorefrontHomePage();
        myExtentReport.getETest().info("Navigated to Storefront Home page");
    }

    @When("I click on the login link")
    public void clickLogin() {
        myDriver.getDriverWait();
        clickLogout();
        myDriver.getDriverWait();
        appPages.storefrontHomePage.clickloginLink();
        myExtentReport.getETest().info("Clicked on Login");
    }

    public void clickLogout (){
        try {
            appPages.customerHomePage.clickLogoutLink();
            myExtentReport.getETest().info("Clicked on Logout");
        } catch (Exception e) {
        }
    }

    @And("I then enter in username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        appPages.storefrontLoginPage.sendKeysUsername(username);
        myExtentReport.getETest().info("Entered in Username");
        appPages.storefrontLoginPage.sendKeysPassword(password);
        myExtentReport.getETest().info("Entered in Password");
    }

    @And("I click on the login button")
    public void ClickLoginButton() {
        appPages.storefrontLoginPage.clickLoginButton();
        myExtentReport.getETest().info("Clicked on Login Button");
    }

    @AfterTest
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            myExtentReport.getETest().fail("Test Case Failed is "+result.getName());
            myExtentReport.getETest().fail("Test Case Failed is "+result.getThrowable());
        }
    }

}
