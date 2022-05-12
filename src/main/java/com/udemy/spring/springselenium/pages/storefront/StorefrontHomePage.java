package com.udemy.spring.springselenium.pages.storefront;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class StorefrontHomePage extends Base {

    @FindBy(css="a[href='/login/customer']")
    public WebElement loginLink;

    @FindBy(css="a[href='/customer/new']")
    public WebElement registerAccountLink;

    public void clickloginLink() {
        loginLink.click();
    }

    public void clickRegisterAccountLink() {
        registerAccountLink.click();
    }


    @Override
    public boolean isAt() {
        return true;
    }
}
