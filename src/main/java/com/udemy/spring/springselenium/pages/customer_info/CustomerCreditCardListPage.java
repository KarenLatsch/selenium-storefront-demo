package com.udemy.spring.springselenium.pages.customer_info;

import com.udemy.spring.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerCreditCardListPage extends Base {

    @FindBy(xpath="//tbody/tr/td[1]")
    public List<WebElement> cardTypeList;

    @FindBy(xpath="//tbody/tr/td[2]")
    public List<WebElement> cardNumberList;

    @FindBy(xpath="//tbody/tr/td[3]/a[1]")
    public List<WebElement> editLinkList;

    @FindBy(xpath="//tbody/tr/td[4]/form/input")
    public List<WebElement> deleteLinkList;

    @FindBy(css="a[href='/creditcard/new']")
    public WebElement addCreditCardLink;

    public int getCardTypeListSize() {
        return this.cardTypeList.size();
    }

    public int getCardNumberListSize() {
        return this.cardNumberList.size();
    }

    public String getCardType(int i) {
        return this.cardTypeList.get(i).getText();
    }

    public String getCardNumber(int i) {
        return this.cardNumberList.get(i).getText();
    }

    public void  clickEditLink(int i) {
        this.editLinkList.get(i).click();
    }

    public void  clickDeleteLink(int i) {
        this.deleteLinkList.get(i).click();
    }

    public void clickAddCreditCardLink() {
        this.addCreditCardLink.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
