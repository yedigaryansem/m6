package com.cucumber.testng.hooks;

import com.cucumber.testng.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotHook {

    @After
    private void takeScreenshot(Scenario scenario){
        scenario.write(DriverManager.getDriver().getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png", scenario.getName());
    }
}
