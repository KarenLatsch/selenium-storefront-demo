package com.udemy.spring.springselenium.flow;

import com.udemy.spring.springselenium.configuration.WaitFactory;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@ScenarioScope
@Component
public class MyDriver  {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WaitFactory waitFactory;

    public void getStorefrontHomePage() {
        driver.get("http://localhost:8080/storefront/listproducts");
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public WebDriverWait getDriverWait(){
        return waitFactory.getWait();
    }

    @PreDestroy
    public void tearDown(){
        driver.quit();
    }

}
