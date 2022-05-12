package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountPage extends Base {

    @FindBy(css="a[href^='/customer/edit']")
    public WebElement customerInfoLink;

    @FindBy(css="a[href='/change_password/customer']")
    public WebElement changePasswordLink;

    @FindBy(css="a[href^='/creditcard/list']")
    public WebElement creditCardsLink;

    public void clickCustomerInfoLink() {
        this.customerInfoLink.click();
    }

    public void clickChangePassword() {
        this.changePasswordLink.click();
    }

    public void clickCreditCardsLink() {
        this.creditCardsLink.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
