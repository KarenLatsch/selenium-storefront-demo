package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartItemListPage extends Base {

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> productNameList;

    @FindBy(xpath="//tbody/tr/td[8]/form/input")
    public List<WebElement> productDeleteLinkList;

    public int getProductNameListSize() {
        return this.productNameList.size();
    }

    public String getProductName(int i) {
        return this.productNameList.get(i).getText();
    }

    public void clickProductDeleteLink(int i) {
        this.productDeleteLinkList.get(i).click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
