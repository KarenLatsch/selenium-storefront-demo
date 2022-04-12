package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class CustomerAccountPage extends Base {

    @FindBy(css="a[href='/logout/customer']")
    public WebElement logoutLink;

    @FindBy(css="a[href^='/storefront/listproducts/']")
    public WebElement goShopLink;

    @FindBy(css="a[href^='/customer/edit']")
    public WebElement customerInfoLink;

    @FindBy(css="a[href='/change_password/customer']")
    public WebElement changePasswordLink;

    @FindBy(css="a[href^='/creditcard/list']")
    public WebElement creditCardsLink;

    //    my account - remove same page loads

    @FindBy(css="a[href^='/cart/list/'] img[src]")
    public WebElement cartImageLink;

    @FindBy(css="a[href^='/cart/list/']")
    public WebElement itemsInCartLink;

    @FindBy(css="a[href^='/checkoutPage/']")
    public WebElement checkoutButton;

    //    this link may just need to be included in the webElements list
    @FindBy(css="//tbody/tr/td")
    public List<WebElement> orderHistoryList;

    public void clickLogoutLink() {
        this.logoutLink.click();
    }

    public void clickCustomerInfoLink() {
        this.customerInfoLink.click();
    }

    public void clickChangePassword() {
        this.changePasswordLink.click();
    }

    public void clickCreditCardsLink() {
        this.creditCardsLink.click();
    }

    public void clickGoShopLink() {
        this.goShopLink.click();
    }

    public void clickCartImageLink() {
        this.cartImageLink.click();
    }

    public void clickItemsInCart() {
        this.itemsInCartLink.click();
    }

    public void clickCheckoutButton() {
        this.checkoutButton.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
