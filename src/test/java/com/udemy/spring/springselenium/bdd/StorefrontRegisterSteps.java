package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class StorefrontRegisterSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;

    @Autowired
    MyExtentReport myExtentReport;

    @When("I click on the register to buy")
    public void clickOnRegisterToBuy() {
        appPages.storefrontHomePage.clickRegisterAccountLink();
        myExtentReport.getETest().info("Clicked on Register to Buy");
    }

    @And("I enter in the customer's information")
    public void enterCustomersInformation(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        appPages.storefrontRegisterAccountPage.sendKeysFirstName(dataMap.get("firstName"));
        myExtentReport.getETest().info("Entered in firstName");
        appPages.storefrontRegisterAccountPage.sendKeysLastName(dataMap.get("lastName"));
        myExtentReport.getETest().info("Entered in lastName");
        appPages.storefrontRegisterAccountPage.sendKeysEmail(dataMap.get("email"));
        myExtentReport.getETest().info("Entered in email");
        appPages.storefrontRegisterAccountPage.sendKeysPhoneNumber(dataMap.get("phoneNumber"));
        myExtentReport.getETest().info("Entered in phoneNumber");
        appPages.storefrontRegisterAccountPage.sendKeysAddressLine1(dataMap.get("address1"));
        myExtentReport.getETest().info("Entered in address1");
        appPages.storefrontRegisterAccountPage.sendKeysAddressLine2(dataMap.get("address2"));
        myExtentReport.getETest().info("Entered in address2");
        appPages.storefrontRegisterAccountPage.sendKeysCity(dataMap.get("city"));
        myExtentReport.getETest().info("Entered in city");
        appPages.storefrontRegisterAccountPage.sendKeysState(dataMap.get("state"));
        myExtentReport.getETest().info("Entered in state");
        appPages.storefrontRegisterAccountPage.sendKeysZipCode(dataMap.get("zip"));
        myExtentReport.getETest().info("Entered in zip");
        appPages.storefrontRegisterAccountPage.sendKeysUsername(dataMap.get("username"));
        myExtentReport.getETest().info("Entered in username");
        appPages.storefrontRegisterAccountPage.sendKeysPassword(dataMap.get("password"));
        myExtentReport.getETest().info("Entered in password");
        appPages.storefrontRegisterAccountPage.sendKeysConfirmPassword(dataMap.get("confirmPassword"));
        myExtentReport.getETest().info("Entered in confirmPassword");
    }

    @And("I click on the update button")
    public void clickOnUpdateInfoButton() {
        appPages.storefrontRegisterAccountPage.clickUpdateInfoButton();
        myExtentReport.getETest().info("clicked Update Information");
    }

    @Then("the new account should be {string}")
    public void newAccountShouldBe(String result) {
        String newCustomerPage = "http://localhost:8080/customer/new";
        String editCustomerPage = "http://localhost:8080/customer/edit";
        String accountStatus;

        String currentURL = myDriver.getCurrentURL();
        System.out.println(currentURL);

        if (currentURL.equals(editCustomerPage) || currentURL.equals(newCustomerPage)) {
            accountStatus = "not added";} else {
            accountStatus = "added";
        }
        Assert.assertEquals(accountStatus, result);
    }
}
