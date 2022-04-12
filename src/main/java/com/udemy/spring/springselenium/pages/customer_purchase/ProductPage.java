package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ProductPage extends Base {

    @FindBy(css="img[src^='/images/']")
    public WebElement productImage;

    @FindBy(css="input[id='quantity']")
    public WebElement productQty;

    @FindBy(xpath="//button[text()='Add to Cart!']")
    public WebElement updateCartButton;

    public void clickUpdateCartButton() {
        this.updateCartButton.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
