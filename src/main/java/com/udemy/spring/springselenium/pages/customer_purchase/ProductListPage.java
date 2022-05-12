package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductListPage extends Base {

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> productNameList;

    @FindBy(xpath="//tbody/tr/td[5]/a")
    public List<WebElement> productViewList;

    public int getProductNameListSize() {
        return this.productNameList.size();
    }

    public void clickViewProduct(int i) {
       this.productViewList.get(i).click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
