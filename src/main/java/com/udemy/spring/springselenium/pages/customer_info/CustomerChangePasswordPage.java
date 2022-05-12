package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CustomerChangePasswordPage extends Base {

    @FindBy(css="input[id='currentPassword']")
    public WebElement currentPassword;

    @FindBy(css="input[id='newPassword']")
    public WebElement newPassword;

    @FindBy(css="input[id='confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(css="button[value='Login']")
    public WebElement changePasswordButton;

    public void sendKeysCurrentPassword(String currentPassword) {
        this.currentPassword.sendKeys(currentPassword);
    }

    public void sendKeysNewPassword(String newPassword) {
        this.newPassword.sendKeys(newPassword);
    }

    public void sendKeysConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void clickChangePasswordButton() {
        this.changePasswordButton.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
