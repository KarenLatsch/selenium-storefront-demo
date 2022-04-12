package com.udemy.spring.springselenium.runner;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.udemy.spring.springselenium.bdd"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
