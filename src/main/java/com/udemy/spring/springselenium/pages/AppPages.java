package com.udemy.spring.springselenium.pages;

import com.udemy.spring.springselenium.pages.customer_info.*;
import com.udemy.spring.springselenium.pages.customer_purchase.*;
import com.udemy.spring.springselenium.pages.storefront.StorefrontHomePage;
import com.udemy.spring.springselenium.pages.storefront.StorefrontLoginPage;
import com.udemy.spring.springselenium.pages.storefront.StorefrontRegisterAccountPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppPages {

    @Autowired
    public StorefrontHomePage storefrontHomePage;

    @Autowired
    public StorefrontLoginPage storefrontLoginPage;

    @Autowired
    public StorefrontRegisterAccountPage storefrontRegisterAccountPage;

    @Autowired
    public CustomerAccountPage customerAccountPage;

    @Autowired
    public CustomerChangePasswordPage customerChangePasswordPage;

    @Autowired
    public CustomerCreditCardPage customerCreditCardPage;

    @Autowired
    public CustomerCreditCardListPage customerCreditCardListPage;

    @Autowired
    public CustomerHomePage customerHomePage;

    @Autowired
    public CustomerInfoPage customerInfoPage;

    @Autowired
    public CartItemListPage cartItemListPage;

    @Autowired
    public CheckoutPage checkoutPage;

    @Autowired
    public ProductPage productPage;

    @Autowired
    public ProductListPage productListPage;

}
