package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CustomerInfoPage extends Base{

    @FindBy(css="input[id='firstName']")
    public WebElement firstName;

    @FindBy(css="input[id='lastName']")
    public WebElement lastName;

    @FindBy(css="input[id='email']")
    public WebElement email;

    @FindBy(css="input[id='phoneNumber']")
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

    @FindBy(css="input[id='username']")
    public WebElement username;

    @FindBy(css="button[type='submit']")
    public WebElement updateInfoButton;

    public void sendKeysFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void sendKeysLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void sendKeysEmail(String email) {
        this.email.sendKeys(email);
    }

    public void sendKeysPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
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

    public void sendKeysUser(String username) {
        this.username.sendKeys(username);
    }

    public void clickUpdateInfoButton() {
        this.updateInfoButton.click();
    }

    public void clearAllFields() {
        this.firstName.clear();
        this.lastName.clear();
        this.email.clear();
        this.phoneNumber.clear();
        this.address1.clear();
        this.address2.clear();
        this.city.clear();
        this.state.clear();
        this.zipCode.clear();
        this.username.clear();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
