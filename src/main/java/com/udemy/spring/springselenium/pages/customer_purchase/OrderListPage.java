package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class OrderListPage extends Base {

    @FindBy(xpath="//tbody/tr/td[1]")
    public List<WebElement> orderNumber;

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> orderDate;

    @FindBy(xpath="//tbody/tr/td[3]")
    public List<WebElement> shipTo;

    @FindBy(xpath="//tbody/tr/td[4]")
    public List<WebElement> orderTotal;

    @FindBy(xpath="//tbody/tr/td[5]")
    public List<WebElement> orderStatus;

    @FindBy(xpath="//tbody/tr/td[6]/a")
    public List<WebElement> viewOrderList;




    @Override
    public boolean isAt() {
        return false;
    }
}
