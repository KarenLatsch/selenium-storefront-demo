package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CartItemPage extends Base {

    @FindBy(css="img[src^='/images/productPage']")
    public WebElement productImage;

    @FindBy(xpath="//div/p[1]")
    public WebElement productName;

//    COME BACK TO
//    @FindBy(CSS="??????")
//    public WebElement productDesc;


//    COME BACK TO
//    @FindBy(CSS="??????")
//    public WebElement productPrice;

    @FindBy(css="input[id='quantity']")
    public WebElement productQty;

//    COME BACK TO
//    @FindBy(CSS="??????")
//    public WebElement totalAmount;

    @FindBy(xpath="//button[text()='Update Cart']")
    public WebElement UpdateCartButton;

    public void sendKeysProductQty(String qty) {
        this.productQty.sendKeys(qty);
    }

    public void clickUpdateCartButton() {
        this.UpdateCartButton.click();
    }




    @Override
    public boolean isAt() {
        return false;
    }
}
