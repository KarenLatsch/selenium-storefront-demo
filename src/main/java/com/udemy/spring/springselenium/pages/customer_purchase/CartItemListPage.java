package com.udemy.spring.springselenium.pages.customer_purchase;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class CartItemListPage extends Base {

    @FindBy(css="a[href='/logout/customer']")
    public WebElement logoutLink;

    @FindBy(css="a[href^='/storefront/listproducts/']")
    public WebElement goShop;

    @FindBy(css="a[href^='/storefront/viewaccount/']")
    public WebElement myAccountLink;

    @FindBy(css="a[href^='/cart/list/'] img[src]")
    public WebElement cartImageLink;

    @FindBy(css="a[href^='/cart/list/']")
    public WebElement itemsInCartLink;

    @FindBy(css="a[href^='/checkoutPage/']")
    public WebElement checkoutButton;

    @FindBy(css="input[value='Clear My Cart']")
    public WebElement ClearMyCartButton;

    @FindBy(xpath="//tbody/tr/td[1]/img")
    public List<WebElement> productImageList;

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> productNameList;

    @FindBy(xpath="//tbody/tr/td[3]")
    public List<WebElement> productDescList;

    @FindBy(xpath="//tbody/tr/td[4]")
    public List<WebElement> productPriceList;

    @FindBy(xpath="//tbody/tr/td[5]")
    public List<WebElement> productQtyList;

    @FindBy(xpath="//tbody/tr/td[6]")
    public List<WebElement> totalAmountList;

    @FindBy(xpath="//tbody/tr/td[7]/a")
    public List<WebElement> productEditLinkList;

    @FindBy(xpath="//tbody/tr/td[8]/form/input")
    public List<WebElement> productDeleteLinkList;
    public int getProductNameListSize() {
        return this.productNameList.size();
    }

    public String getProductName(int i) {
        return this.productNameList.get(i).getText();
    }
    public String getProductDesc(int i) {
        return this.productDescList.get(i).getText();
    }

    public int getProductDescListSize(){
        return this.productDescList.size();
    }
    public String getProductPrice(int i) {
        return this.productPriceList.get(i).getText();
    }

    public String getTotalAmount(int i) {
        return this.totalAmountList.get(i).getText();
    }

    public void clickProductEditLink(int i){
        this.productEditLinkList.get(i).click();
    }

    public void clickProductDeleteLink(int i) {
        this.productDeleteLinkList.get(i).click();
    }

    public int getProductQty(int i) {
        int qty = Integer.parseInt(this.productQtyList.get(i).getText());
        return qty;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
