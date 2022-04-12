package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class ProductListPage extends Base {

    @FindBy(xpath="//tbody/tr/td[1]/img")
    public List<WebElement> productImageList;

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> productNameList;

    @FindBy(xpath="//tbody/tr/td[3]")
    public List<WebElement> productDescList;

    @FindBy(xpath="//tbody/tr/td[4]")
    public List<WebElement> productPriceList;

    @FindBy(xpath="//tbody/tr/td[5]/a")
    public List<WebElement> productViewList;

    public int getProductNameListSize() {
        return this.productNameList.size();
    }

    public String getProductName(int i) {
        return this.productNameList.get(i).getText();
    }

    public void clickViewProduct(int i) {
       this.productViewList.get(i).click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
