package com.udemy.spring.springselenium.pages;

import com.udemy.spring.springselenium.flow.MyDriver;
import com.udemy.spring.springselenium.pages.customer_info.*;
import com.udemy.spring.springselenium.pages.customer_purchase.*;
import com.udemy.spring.springselenium.pages.storefront.StorefrontHomePage;
import com.udemy.spring.springselenium.pages.storefront.StorefrontLoginPage;
import com.udemy.spring.springselenium.pages.storefront.StorefrontRegisterAccountPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AppPages {

    @Lazy
    @Autowired
    public StorefrontHomePage storefrontHomePage;

    @Lazy
    @Autowired
    public StorefrontLoginPage storefrontLoginPage;

    @Lazy
    @Autowired
    public StorefrontRegisterAccountPage storefrontRegisterAccountPage;

    @Lazy
    @Autowired
    public CustomerAccountPage customerAccountPage;

    @Lazy
    @Autowired
    public CustomerChangePasswordPage customerChangePasswordPage;

    @Lazy
    @Autowired
    public CustomerCreditCardPage customerCreditCardPage;

    @Lazy
    @Autowired
    public CustomerCreditCardListPage customerCreditCardListPage;

    @Lazy
    @Autowired
    public CustomerHomePage customerHomePage;

    @Lazy
    @Autowired
    public CustomerInfoPage customerInfoPage;

    @Lazy
    @Autowired
    public CartItemPage cartItemPage;

    @Lazy
    @Autowired
    public CartItemListPage cartItemListPage;

    @Lazy
    @Autowired
    public CheckoutPage checkoutPage;

    @Lazy
    @Autowired
    public OrderListPage orderListPage;

    @Lazy
    @Autowired
    public ProductPage productPage;

    @Lazy
    @Autowired
    public ProductListPage productListPage;


}
