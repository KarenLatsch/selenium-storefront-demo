package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CheckoutPage extends Base {

    @FindBy(css="button[type='submit']")
    public WebElement placeOrderButton;

    @FindBy(xpath="//h3[contains(text(), 'Your Order has been placed.')]")
    public WebElement orderPlacedMessage;

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
