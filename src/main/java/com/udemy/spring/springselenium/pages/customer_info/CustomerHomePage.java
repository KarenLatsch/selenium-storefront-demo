package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CustomerHomePage extends Base {

    @FindBy(css="a[href='/logout/customer']")
    public WebElement logoutLink;

    @FindBy(css="a[href^='/storefront/viewaccount/']")
    public WebElement myAccountLink;

    @FindBy(css="a[href^='/cart/list/'] img[src]")
    public WebElement cartImageLink;

    @FindBy(css="a[href^='/checkout/']")
    public WebElement checkoutButton;

    public void clickLogoutLink() {
        this.logoutLink.click();
    }

    public void clickMyAccountLink() {
        this.myAccountLink.click();
    }

    public void clickCartImageLink() {
        this.cartImageLink.click();
    }

    public void clickCheckoutButton() {
        this.checkoutButton.click();
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
