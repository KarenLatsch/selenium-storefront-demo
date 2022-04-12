package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class StorefrontRegisterSteps extends MyExtentReport{

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;

    @When("I click on the register to buy")
    public void clickOnRegisterToBuy() {
        appPages.storefrontHomePage.clickRegisterAccountLink();
    }

    @And("I enter in the customer's information")
    public void enterCustomersInformation(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        appPages.storefrontRegisterAccountPage.sendKeysFirstName(dataMap.get("firstName"));
        appPages.storefrontRegisterAccountPage.sendKeysLastName(dataMap.get("lastName"));
        appPages.storefrontRegisterAccountPage.sendKeysEmail(dataMap.get("email"));
        appPages.storefrontRegisterAccountPage.sendKeysPhoneNumber(dataMap.get("phoneNumber"));
        appPages.storefrontRegisterAccountPage.sendKeysAddressLine1(dataMap.get("address1"));
        appPages.storefrontRegisterAccountPage.sendKeysAddressLine2(dataMap.get("address2"));
        appPages.storefrontRegisterAccountPage.sendKeysCity(dataMap.get("city"));
        appPages.storefrontRegisterAccountPage.sendKeysState(dataMap.get("state"));
        appPages.storefrontRegisterAccountPage.sendKeysZipCode(dataMap.get("zip"));
        appPages.storefrontRegisterAccountPage.sendKeysUsername(dataMap.get("username"));
        appPages.storefrontRegisterAccountPage.sendKeysPassword(dataMap.get("password"));
        appPages.storefrontRegisterAccountPage.sendKeysConfirmPassword(dataMap.get("confirmPassword"));
    }

    @And("I click on the update button")
    public void clickOnUpdateInfoButton() {
        appPages.storefrontRegisterAccountPage.clickUpdateInfoButton();
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
