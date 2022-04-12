package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CheckoutPage extends Base {

    @FindBy(css="input[id='firstName']")
    public WebElement firstName;

    @FindBy(css="input[id='lastName']")
    public WebElement lastName;

    @FindBy(css="input[id='email']")
    public WebElement email;

    @FindBy(css="input[id='lastName']")
    public WebElement phoneNumber;

    @FindBy(css="input[id='shippingAddress.addressLine1']")
    public WebElement address1;

    @FindBy(css="input[id='shippingAddress.addressLine2']")
    public WebElement address2;

    @FindBy(css="input[id='shippingAddress.city']")
    public WebElement city;

    @FindBy(css="input[id='shippingAddress.state']")
    public WebElement state;

    @FindBy(css="input[id='shippingAddress.zipCode']")
    public WebElement zipCode;

//    The creditcard name is not edible

    @FindBy(css="input[id='displayCardNumber']")
    public WebElement creditCardNumber;

    @FindBy(css="input[id='displayExpMonth']")
    public WebElement creditCardExpMonth;

    @FindBy(css="input[id='displayExpYear']")
    public WebElement creditCardExpYear;

    @FindBy(css="input[id='displayVerificationCode']")
    public WebElement creditCardVerificationCode;

    @FindBy(css="button[type='submit']")
    public WebElement placeOrderButton;

    @FindBy(xpath="//h3[contains(text(), 'Your Order has been placed.')]")
    public WebElement orderPlacedMessage;

    public void sendKeysFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void sendKeysLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void sendKeysEmail(String email) {
        this.email.sendKeys(email);
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

//    CreditCard Number is not edible

    public void sendKeysCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber.sendKeys(creditCardNumber);
    }

    public void sendKeysCreditCardExpMonth(String creditCardExpMonth) {
        this.creditCardExpMonth.sendKeys(creditCardExpMonth);
    }

    public void sendKeysCreditCardExpYear(String creditCardExpYear) {
        this.creditCardExpYear.sendKeys(creditCardExpYear);
    }

    public void sendKeysCreditCardVerificationCode(String creditCardVerificationCode) {
        this.creditCardVerificationCode.sendKeys(creditCardVerificationCode);
    }

    public void clickPlaceOrderButton() {
        this.placeOrderButton.click();
    }

    public String getOrderPlacedMessage() {
        return this.orderPlacedMessage.getText();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
