package com.cucumber.testng.wait;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cucumber.testng.driver.DriverManager.getDriver;

public class WaitHelper {


    public WaitHelper() {
        wait = new WebDriverWait(getDriver(), 60);
    }

    private final WebDriverWait wait;


    public WebElement wait(WebElement target){
        return wait.until(ExpectedConditions.visibilityOf(target));
    }

    public List<WebElement> wait(List<WebElement> targets){
        return wait.until(ExpectedConditions.visibilityOfAllElements(targets));
    }

    public void refreshPage(){
        getDriver().navigate().refresh();
    }
}

