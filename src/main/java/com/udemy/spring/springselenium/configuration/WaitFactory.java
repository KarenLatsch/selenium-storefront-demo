package com.udemy.spring.springselenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFactory {
    private WebDriver webDriver;
    private int timeout;

    public WaitFactory(WebDriver webDriver, int timeout) {
        this.webDriver = webDriver;
        this.timeout = timeout;
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
    }
}
