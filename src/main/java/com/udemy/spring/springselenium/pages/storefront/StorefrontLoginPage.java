package com.udemy.spring.springselenium.pages.storefront;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class StorefrontLoginPage extends Base {

    @FindBy(css="input[id='username']")
    public WebElement username;

    @FindBy(css="input[id='password']")
    public WebElement password;

    @FindBy(css="button[value='Login']")
    public WebElement loginButton;

    public void sendKeysUsername(String username) {
        this.username.sendKeys(username);
    }

    public void sendKeysPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
               loginButton.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
