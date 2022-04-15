package com.udemy.spring.springselenium;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

@SpringBootTest
public class SpringBaseTestNGtest extends AbstractTestNGSpringContextTests {

    @BeforeSuite
    public void testBefore(){
        System.out.println("Before all");
    }
}
