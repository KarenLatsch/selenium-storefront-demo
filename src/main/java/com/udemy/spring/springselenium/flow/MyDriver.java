package com.udemy.spring.springselenium.flow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyDriver  {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

//    @Value("${application.storefrontHomePage.url}")
//    private String storefrontHomePageURL;

    public void getStorefrontHomePage() {
        driver.get("http://localhost:8080/storefront/listproducts");
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public WebDriver setup(){
        return new ChromeDriver();
    }

    public void tearDown(){
        driver.quit();
    }

}
