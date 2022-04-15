package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class CustomerAccountSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;

    @Autowired
    MyExtentReport myExtentReport;

    private int size;
    private String cardType;
    private String cardNumber;
    private String newCardNumber;
    private String deletedCardNumber;

    @And("I click on the my account link")
    public void clickOnMyAccount() {
        appPages.customerHomePage.clickMyAccountLink();
        myExtentReport.getETest().info("Clicked My Account Link");
    }

    @And("I click on the change password link")
    public void clickOnChangePassword() {
        appPages.customerAccountPage.clickChangePassword();
        myExtentReport.getETest().info("Clicked on Change Password");
    }

    @And("I enter in current password {string} and new password {string} and confirm password {string}")
    public void enterNewPassword(String password, String newpassword, String confirmedpassword) {
        appPages.customerChangePasswordPage.sendKeysCurrentPassword(password);
        myExtentReport.getETest().info("Entered in Current Password");
        appPages.customerChangePasswordPage.sendKeysNewPassword(newpassword);
        myExtentReport.getETest().info("Entered in New Password");
        appPages.customerChangePasswordPage.sendKeysConfirmPassword(confirmedpassword);
        myExtentReport.getETest().info("Entered in Confirm Password");
    }

    @And("I click on the change password button")
    public void clickChangePasswordButton() {
        appPages.customerChangePasswordPage.clickChangePasswordButton();
        myExtentReport.getETest().info("Clicked on Change Password");
    }

    @Then("the password should be {string}")
    public void passwordChangeResults(String result) {
        String customerChangePasswordPage = "http://localhost:8080/change_password/customer";
        String passwordChanged = "changed";
        String currentURL = myDriver.getCurrentURL();

        if (currentURL.equals(customerChangePasswordPage)) {
            passwordChanged = "not changed";
        }

        try {
            Assert.assertEquals(passwordChanged, result);
        } catch (Exception e){
            myExtentReport.getETest().fail("The Status of a Changed Password Differs from Expected Results");
        }
    }

    @And("I click on the customer information link")
    public void clickOnCustomerInfo() {
        appPages.customerAccountPage.clickCustomerInfoLink();
        myExtentReport.getETest().info("Clicked on Customer Information");
    }

    @And("I enter the following customer data")
    public void enterCustomerData(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        appPages.customerInfoPage.clearAllFields();

        appPages.customerInfoPage.sendKeysFirstName(dataMap.get("firstName"));
        myExtentReport.getETest().info("Entered in firstName");
        appPages.customerInfoPage.sendKeysLastName(dataMap.get("lastName"));
        myExtentReport.getETest().info("Entered in lastName");
        appPages.customerInfoPage.sendKeysEmail(dataMap.get("email"));
        myExtentReport.getETest().info("Entered in email");
        appPages.customerInfoPage.sendKeysPhoneNumber(dataMap.get("phoneNumber"));
        myExtentReport.getETest().info("Entered in phoneNumber");
        appPages.customerInfoPage.sendKeysAddressLine1(dataMap.get("address1"));
        myExtentReport.getETest().info("Entered in address1");
        appPages.customerInfoPage.sendKeysAddressLine2(dataMap.get("address2"));
        myExtentReport.getETest().info("Entered in address2");
        appPages.customerInfoPage.sendKeysCity(dataMap.get("city"));
        myExtentReport.getETest().info("Entered in city");
        appPages.customerInfoPage.sendKeysState(dataMap.get("state"));
        myExtentReport.getETest().info("Entered in state");
        appPages.customerInfoPage.sendKeysZipCode(dataMap.get("zip"));
        myExtentReport.getETest().info("Entered in zip");
        appPages.customerInfoPage.sendKeysUser(dataMap.get("username"));
        myExtentReport.getETest().info("Entered in username");
    }

    @And("I click on the update information button")
    public void clickOnUpdateInfoButton() {
        appPages.customerInfoPage.clickUpdateInfoButton();
        myExtentReport.getETest().info("Clicked on Update Information Button");
    }

    @Then("the customer's information should be {string}")
    public void customersInformationResults(String expectedResult) {
        String customerInformationPage = "http://localhost:8080/customer/edit";
        String customerUpdated;

        String currentURL = myDriver.getCurrentURL();
        String currentURL2 = currentURL.substring(0,35);

        if (currentURL2.equals(customerInformationPage)) {
            customerUpdated = "not changed";} else {
            customerUpdated = "changed";
        }

        try {
            Assert.assertEquals(customerUpdated, expectedResult);
        } catch (Exception e){
            myExtentReport.getETest().fail("The Status of Customer's Updated Information Differs from Expected Results");
        }
    }

    @And("I click on the credit cards link")
    public void clickOnCreditCards() {
        appPages.customerAccountPage.clickCreditCardsLink();
        myExtentReport.getETest().info("Clicked on Credit Cards");
    }

    @And("I verify there is a credit card listed")
    public void verifyCreditCardListed () {
        size = appPages.customerCreditCardListPage.getCardTypeListSize();
        myExtentReport.getETest().info("Reviewed on Credit Card List");
        if(size >= 1) {
            cardType = appPages.customerCreditCardListPage.getCardType(0);
            myExtentReport.getETest().info("Saved Credit Card Type Displayed");
            cardNumber = appPages.customerCreditCardListPage.getCardNumber(0);
            myExtentReport.getETest().info("Saved Credit Card Number Displayed");
        }
    }

    @And("I click on the credit card edit link")
    public void clickOnCreditCardEdit() {
        if(size >= 1) {
            appPages.customerCreditCardListPage.clickEditLink(0);
            myExtentReport.getETest().info("Clicked on Credit Card Edit");
        }
    }

    @Then("the card type and card number should match the information from the credit card list")
    public void validateCardTypeAndCardNumberMatchCreditCardList() {

        if(size >=1) {
           String editCardType = appPages.customerCreditCardPage.getSelectedCardType();
            try {
                Assert.assertEquals(editCardType, cardType);
            } catch (Throwable e){
//                CHECK HERE!!!!!!!!!! NOT Showing on Report
                 myExtentReport.getETest().fail("Credit Card Type does not match Card Type");
            }

           String editCardNumber = appPages.customerCreditCardPage.getCardNumber();
            try {
                Assert.assertEquals(editCardNumber, cardNumber);
            } catch (Throwable e){
//                CHECK HERE!!!!!!!!!! NOT Showing on Report
                myExtentReport.getETest().fail("Credit Card Number does not match Card Number");
            }
        }
    }

    @And("I click on the add credit card link")
    public void clickOnAddCreditCard() {
        appPages.customerCreditCardListPage.clickAddCreditCardLink();
        myExtentReport.getETest().info("Clicked on Add Credit Card");
    }

    @And("I enter in the following credit card information")
    public void enterCreditCardInformation(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        appPages.customerCreditCardPage.sendKeysFirstName(dataMap.get("firstName"));
        myExtentReport.getETest().info("Entered in firstName");
        appPages.customerCreditCardPage.sendKeysLastName(dataMap.get("lastName"));
        myExtentReport.getETest().info("Entered in lastName");
        appPages.customerCreditCardPage.sendKeysAddressLine1(dataMap.get("address1"));
        myExtentReport.getETest().info("Entered in address1");
        appPages.customerCreditCardPage.sendKeysAddressLine2(dataMap.get("address2"));
        myExtentReport.getETest().info("Entered in address2");
        appPages.customerCreditCardPage.sendKeysCity(dataMap.get("city"));
        myExtentReport.getETest().info("Entered in city");
        appPages.customerCreditCardPage.sendKeysState(dataMap.get("state"));
        myExtentReport.getETest().info("Entered in state");
        appPages.customerCreditCardPage.sendKeysZipCode(dataMap.get("zip"));
        myExtentReport.getETest().info("Entered in zip");
        appPages.customerCreditCardPage.sendKeysCreditCardType(dataMap.get("creditCardType"));
        myExtentReport.getETest().info("Entered in creditCardType");
        appPages.customerCreditCardPage.sendKeysCardNumber(dataMap.get("cardNumber"));
        myExtentReport.getETest().info("Entered in cardNumber");
        appPages.customerCreditCardPage.sendKeysExpirationMonth(dataMap.get("expMonth"));
        myExtentReport.getETest().info("Entered in expMonth");
        appPages.customerCreditCardPage.sendKeysExpirationYear(dataMap.get("expYear"));
        myExtentReport.getETest().info("Entered in expYear");
        appPages.customerCreditCardPage.sendKeysVerificationCode(dataMap.get("verificationCode"));
        myExtentReport.getETest().info("Entered in verificationCode");
        newCardNumber = ("XXXXXXXXXXXX" + dataMap.get("cardNumber").substring(11, 15));
    }

    @And("I click on the update credit card information button")
    public void clickOnUpdateCreditCardButton() {
        appPages.customerCreditCardPage.clickUpdateCreditCardButton();
        myExtentReport.getETest().info("Clicked on Update Credit Card");
    }

    @Then("the new credit card should be added to the customer's credit list")
    public void newCreditCardShouldBeAdded() {
        boolean foundNewCard = false;

        size = appPages.customerCreditCardListPage.getCardTypeListSize();
        for(int i=0;i<size;i++) {
            cardNumber = appPages.customerCreditCardListPage.getCardNumber(i);
            if(newCardNumber.equals(cardNumber)) {
                foundNewCard = true;
                break;
            }
        }

        try {
            Assert.assertTrue(foundNewCard);
        } catch (Exception e){
            myExtentReport.getETest().fail("New Credit Card was Not Added to the Credit Card List");
        }
    }

    @And("I view the credit card list and I select a card number to delete")
    public void viewListAndSelectACardNumberToDelete() {
        size = appPages.customerCreditCardListPage.getCardNumberListSize();
        myExtentReport.getETest().info("Reviewed Credit Card List");

        if(size >= 1) {
            deletedCardNumber = appPages.customerCreditCardListPage.getCardNumber(0);
            myExtentReport.getETest().info("Deleted a Credit Card from List");
        }
    }

    @And("I click on the delete link for selected credit card")
    public void clickOnDeleteForSelectedCreditCard() {
        if(size >= 1) {
            appPages.customerCreditCardListPage.clickDeleteLink(0);
            myExtentReport.getETest().info("Clicked on Delete");
        }
    }

    @Then("the deleted credit card should no longer be displayed in the list")
    public void deletedCreditCardShouldNoLongerBeDisplayed() {

        boolean cardNumberDeleted = true;
        int newSize = appPages.customerCreditCardListPage.getCardNumberListSize();

        if(size >= 1) {
            for(int i=0;i<newSize;i++){
                appPages.customerCreditCardListPage.getCardNumber(i);
                if(deletedCardNumber.equals(cardNumber)) {
                    cardNumberDeleted = false;
                    break;
                }
            }

            try {
                Assert.assertTrue(cardNumberDeleted);
            } catch (Exception e){
                myExtentReport.getETest().fail("Credit Card was not Deleted");
            }
        } else {
                myExtentReport.getETest().info("No credit cards listed to delete");
        }
    }
}
