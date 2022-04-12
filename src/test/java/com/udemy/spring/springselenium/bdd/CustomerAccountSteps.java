package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.AppPages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class CustomerAccountSteps extends MyExtentReport{

    @Autowired
    private AppPages appPages;

    @Autowired
    public MyDriver myDriver;


    private int size;
    private String cardType;
    private String cardNumber;
    private String newCardNumber;
    private String deletedCardNumber;


    @And("I click on the my account link")
    public void clickOnMyAccount() {
        appPages.customerHomePage.clickMyAccountLink();
    }

    @And("I click on the change password link")
    public void clickOnChangePassword() {
        appPages.customerAccountPage.clickChangePassword();
    }

    @And("I enter in current password {string} and new password {string} and confirm password {string}")
    public void enterNewPassword(String password, String newpassword, String confirmedpassword) {
        appPages.customerChangePasswordPage.sendKeysCurrentPassword(password);
        appPages.customerChangePasswordPage.sendKeysNewPassword(newpassword);
        appPages.customerChangePasswordPage.sendKeysConfirmPassword(confirmedpassword);
    }

    @And("I click on the change password button")
    public void clickChangePasswordButton() {
        appPages.customerChangePasswordPage.clickChangePasswordButton();
    }

    @Then("the password should be {string}")
    public void passwordChangeResults(String result) {
        String customerChangePasswordPage = "http://localhost:8080/change_password/customer";
        String passwordChanged = "changed";
        String currentURL = myDriver.getCurrentURL();

        if (currentURL.equals(customerChangePasswordPage)) {
            passwordChanged = "not changed";
        }
        System.out.println("User password " + passwordChanged);
        Assert.assertEquals(passwordChanged, result);
    }

    @And("I click on the customer information link")
    public void clickOnCustomerInfo() {
        appPages.customerAccountPage.clickCustomerInfoLink();
    }

    @And("I enter the following customer data")
    public void enterCustomerData(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        appPages.customerInfoPage.clearAllFields();

        appPages.customerInfoPage.sendKeysFirstName(dataMap.get("firstName"));
        appPages.customerInfoPage.sendKeysLastName(dataMap.get("lastName"));
        appPages.customerInfoPage.sendKeysEmail(dataMap.get("email"));
        appPages.customerInfoPage.sendKeysPhoneNumber(dataMap.get("phoneNumber"));
        appPages.customerInfoPage.sendKeysAddressLine1(dataMap.get("address1"));
        appPages.customerInfoPage.sendKeysAddressLine2(dataMap.get("address2"));
        appPages.customerInfoPage.sendKeysCity(dataMap.get("city"));
        appPages.customerInfoPage.sendKeysState(dataMap.get("state"));
        appPages.customerInfoPage.sendKeysZipCode(dataMap.get("zip"));
        appPages.customerInfoPage.sendKeysUser(dataMap.get("username"));
    }

    @And("I click on the update information button")
    public void clickOnUpdateInfoButton() {
        appPages.customerInfoPage.clickUpdateInfoButton();
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
        Assert.assertEquals(customerUpdated, expectedResult);
        System.out.println(customerUpdated.equals(expectedResult));
        System.out.println(customerUpdated);
        System.out.println(customerInformationPage);
        System.out.println(currentURL2);
        System.out.println(expectedResult);
    }

    @And("I click on the credit cards link")
    public void clickOnCreditCards() {
        appPages.customerAccountPage.clickCreditCardsLink();
    }

    @And("I verify there is a credit card listed")
    public void verifyCreditCardListed () {
        size = appPages.customerCreditCardListPage.getCardTypeListSize();
        if(size >= 1) {
            cardType = appPages.customerCreditCardListPage.getCardType(0);
            cardNumber = appPages.customerCreditCardListPage.getCardNumber(0);
        }
    }

    @And("I click on the credit card edit link")
    public void clickOnCreditCardEdit() {
        if(size >= 1) {
            appPages.customerCreditCardListPage.clickEditLink(0);
        }
    }

    @Then("the card type and card number should match the information from the credit card list")
    public void validateCardTypeAndCardNumberMatchCreditCardList() {

        if(size >=1) {
           String editCardType = appPages.customerCreditCardPage.getSelectedCardType();
           Assert.assertEquals(editCardType, cardType);

           String editCardNumber = appPages.customerCreditCardPage.getCardNumber();
           Assert.assertEquals(editCardNumber, cardNumber);
        }
    }

    @And("I click on the add credit card link")
    public void clickOnAddCreditCard() {
        appPages.customerCreditCardListPage.clickAddCreditCardLink();
    }

    @And("I enter in the following credit card information")
    public void enterCreditCardInformation(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        appPages.customerCreditCardPage.sendKeysFirstName(dataMap.get("firstName"));
        appPages.customerCreditCardPage.sendKeysLastName(dataMap.get("lastName"));
        appPages.customerCreditCardPage.sendKeysAddressLine1(dataMap.get("address1"));
        appPages.customerCreditCardPage.sendKeysAddressLine2(dataMap.get("address2"));
        appPages.customerCreditCardPage.sendKeysCity(dataMap.get("city"));
        appPages.customerCreditCardPage.sendKeysState(dataMap.get("state"));
        appPages.customerCreditCardPage.sendKeysZipCode(dataMap.get("zip"));
        appPages.customerCreditCardPage.sendKeysCreditCardType(dataMap.get("creditCardType"));
        appPages.customerCreditCardPage.sendKeysCardNumber(dataMap.get("cardNumber"));
        appPages.customerCreditCardPage.sendKeysExpirationMonth(dataMap.get("expMonth"));
        appPages.customerCreditCardPage.sendKeysExpirationYear(dataMap.get("expYear"));
        appPages.customerCreditCardPage.sendKeysVerificationCode(dataMap.get("verificationCode"));
        newCardNumber = ("XXXXXXXXXXXX" + dataMap.get("cardNumber").substring(11, 15));
    }

    @And("I click on the update credit card information button")
    public void clickOnUpdateCreditCardButton() {
        appPages.customerCreditCardPage.clickUpdateCreditCardButton();
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
        System.out.println(newCardNumber);
        Assert.assertTrue(foundNewCard);
    }

    @And("I view the credit card list and I select a card number to delete")
    public void viewListAndSelectACardNumberToDelete() {
        size = appPages.customerCreditCardListPage.getCardNumberListSize();

        if(size >= 1) {
            deletedCardNumber = appPages.customerCreditCardListPage.getCardNumber(0);
        }
    }

    @And("I click on the delete link for selected credit card")
    public void clickOnDeleteForSelectedCreditCard() {
        if(size >= 1) {
            appPages.customerCreditCardListPage.clickDeleteLink(0);
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
            Assert.assertTrue(cardNumberDeleted);
        } else {
            System.out.println("No credit cards listed to delete");
        }
    }
}
