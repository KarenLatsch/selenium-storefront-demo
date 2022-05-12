package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends Base {

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
