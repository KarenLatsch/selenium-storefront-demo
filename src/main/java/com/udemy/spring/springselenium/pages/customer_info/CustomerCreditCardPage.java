package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CustomerCreditCardPage extends Base {

    @FindBy(css="a[href^='/storefront/viewaccount/']")
    public WebElement myAccountLink;

    @FindBy(css="input[id='firstName']")
    public WebElement firstName;

    @FindBy(css="input[id='lastName']")
    public WebElement lastName;

    @FindBy(css="input[id='billingAddress.addressLine1']")
    public WebElement address1;

    @FindBy(css="input[id='billingAddress.addressLine2']")
    public WebElement address2;


    @FindBy(css="input[id='billingAddress.city']")
    public WebElement city;

    @FindBy(css="input[id='billingAddress.state']")
    public WebElement state;

    @FindBy(css="input[id='billingAddress.zipCode']")
    public WebElement zipCode;

    @FindBy(css="option[selected='selected']")
    public WebElement selectedCreditCardType;

    @FindBy(css="select[id='creditCardType']")
    public WebElement creditCardType;

    @FindBy(css="input[id='cardNumber']")
    public WebElement cardNumber;

    @FindBy(css="input[id='expirationMonth']")
    public WebElement expirationMonth;

    @FindBy(css="input[id='expirationYear']")
    public WebElement ExpirationYear;

    @FindBy(css="input[id='verificationCode']")
    public WebElement verificationCode;

    @FindBy(css="button[type='submit']")
    public WebElement updateCreditCardButton;


    public void clickMyAccountLink() {
        this.myAccountLink.click();
    }

    public void sendKeysFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void sendKeysLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void sendKeysAddressLine1(String addressLine1) {
        this.address1.sendKeys(addressLine1);
    }

    public void sendKeysAddressLine2(String addressLine2) {
        this.address2.sendKeys(addressLine2);
    }

    public void sendKeysCity(String city) {
        this.city.sendKeys(city);
    }
    public void sendKeysState(String state) {
        this.state.sendKeys(state);
    }
    public void sendKeysZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    public void sendKeysCreditCardType(String creditCardType) {
        this.creditCardType.sendKeys(creditCardType);
    }
    public void sendKeysCardNumber(String cardNumber) {
        this.cardNumber.sendKeys(cardNumber);
    }
    public void sendKeysExpirationMonth(String expirationMonth) {
        this.expirationMonth.sendKeys(expirationMonth);
    }
    public void sendKeysExpirationYear(String expirationYear) {
        this.ExpirationYear.sendKeys(expirationYear);
    }
    public void sendKeysVerificationCode(String verificationCode) {
        this.verificationCode.sendKeys(verificationCode);
    }
    public void clickUpdateCreditCardButton() {
        this.updateCreditCardButton.click();
    }

    public String getSelectedCardType(){
        return this.selectedCreditCardType.getText();
    }

    public String getCardNumber(){
        return this.cardNumber.getAttribute("placeholder");
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
