package com.cucumber.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.testng",
        features = "src/main/java/com/cucumber/testng/features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
