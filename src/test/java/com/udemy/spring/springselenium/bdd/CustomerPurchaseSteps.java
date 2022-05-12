package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.SpringBaseTestNGtest;
import com.udemy.spring.springselenium.pages.AppPages;
import com.udemy.spring.springselenium.report.MyExtentReport;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class CustomerPurchaseSteps extends SpringBaseTestNGtest {

    @Autowired
    private AppPages appPages;

    @Autowired
    MyExtentReport myExtentReport;

    private boolean itemsInCartToDeleted;
    private String removedProduct;
    private String productName;

    @And("I click on the cart image")
    public void clickOnCartImage() {
        appPages.customerHomePage.clickCartImageLink();
        myExtentReport.getETest().info("Clicked on Cart Image");
    }

    @And("I view items in my cart and I select a product to remove")
    public void viewItemsInCartAndSelectAProductToRemove() {
        int size = appPages.cartItemListPage.getProductNameListSize();
        myExtentReport.getETest().info("Reviewed List of Products");

        if(size > 0) {
            itemsInCartToDeleted = true;
        } else {
            myExtentReport.getETest().info("There are no items in the cart to delete");
        }

        if(itemsInCartToDeleted) {
            removedProduct = appPages.cartItemListPage.getProductName(0);
            myExtentReport.getETest().info("Selected a Product to Remove from Cart");
        }
    }

    @And("I click on the link remove the item")
    public void clickOnRemoveTheItem() {
        if(itemsInCartToDeleted) {
            appPages.cartItemListPage.clickProductDeleteLink(0);
            myExtentReport.getETest().info("Clicked on Remove Item");
        }
    }

    @Then("the removed product should no longer be displayed in the cart items list")
    public void productShouldNoLongerBeDisplayedInCartItemsList() {
        if(itemsInCartToDeleted) {
            boolean foundRemovedProduct = false;

            int  size = appPages.cartItemListPage.getProductNameListSize();
            for(int i=0;i<size;i++) {
                productName = appPages.cartItemListPage.getProductName(i);
                if(removedProduct.equals(productName)) {
                    foundRemovedProduct = true;
                    break;
                }
            }
            Assert.assertFalse(foundRemovedProduct);
        }
    }

    @And("I view the product list and I select a product to view")
    public void viewProductListAndSelectAProductToView() {
        int size = appPages.productListPage.getProductNameListSize();
        myExtentReport.getETest().info("Reviewed List of Products");

        if(size > 0) {
            appPages.productListPage.clickViewProduct(0);
            myExtentReport.getETest().info("Clicking on View Product");
        } else {
            myExtentReport.getETest().info("There is no products listed to add to the cart.");
        }
    }

    @And("I add the product to my cart")
    public void addTheProductToMyCart() {
        appPages.productPage.clickUpdateCartButton();
        myExtentReport.getETest().info("Clicked on Add Product to Cart");
    }

    @And("I click on the checkout button")
    public void clickOnCheckoutButton() {
        appPages.customerHomePage.clickCheckoutButton();
        myExtentReport.getETest().info("Clicked on Checkout");
    }

    @And("I click on the place order button")
    public void clickOnPlaceOrderButton() {
        appPages.checkoutPage.clickPlaceOrderButton();
        myExtentReport.getETest().info("Clicked on Place Order");
    }

    @Then("the order should be placed")
    public void orderShouldBePlaced() {
        String orderPlacedMessage = appPages.checkoutPage.getOrderPlacedMessage();
        Assert.assertEquals("Your Order has been placed. Thank You for Your Order!!", orderPlacedMessage);
    }

}
