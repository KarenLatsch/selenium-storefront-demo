package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class CustomerHomePage extends Base {

    @FindBy(xpath="//p[contains(text(),'Greetings')]" )
    public WebElement customerGreeting;

    @FindBy(css="a[href='/logout/customer']")
    public WebElement logoutLink;

//    Go Shop should be removed takes you to the same page

    @FindBy(css="a[href^='/storefront/viewaccount/']")
    public WebElement myAccountLink;

    @FindBy(css="a[href^='/cart/list/'] img[src]")
    public WebElement cartImageLink;

    @FindBy(css="a[href^='/cart/list/']")
    public WebElement itemsInCartLink;

    @FindBy(xpath="//a/b/p")
    public WebElement getItemsInCartLinkDisplayed;

    @FindBy(css="a[href^='/checkout/']")
    public WebElement checkoutButton;

    @FindBy(css="//tbody/tr/td")
    public List<WebElement> productsToBuyList;


    public boolean customerGreetingIsDisplayed(){
        return this.customerGreeting.isDisplayed();
    }

    public void clickLogoutLink() {
        this.logoutLink.click();
    }

    public void clickMyAccountLink() {
        this.myAccountLink.click();
    }

    public boolean myAccountLinkIsDisplayed(){
        return this.myAccountLink.isDisplayed();
    }

    public void clickCartImageLink() {
        this.cartImageLink.click();
    }

    public void clickItemsInCartLink() {
        this.getItemsInCartLinkDisplayed.click();
    }

    public boolean itemsInCartLinkIsDisplayed() {
        return this.getItemsInCartLinkDisplayed.isDisplayed();
    }

    public void clickCheckoutButton() {
        this.checkoutButton.click();
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
