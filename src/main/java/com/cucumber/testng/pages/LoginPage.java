package com.cucumber.testng.pages;

import com.cucumber.testng.data.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.cucumber.testng.driver.DriverManager.getDriver;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@name='login']")
    private WebElement userName;

    @FindBy(xpath = "//button[@com.cucumber.testng.data-testid='enter-password']")
    private WebElement enterPasswordButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@com.cucumber.testng.data-testid='login-to-mail']")
    private WebElement loginButton;


    public void login(){
        waitHelper.wait(userName).sendKeys(Constants.USERNAME);
        waitHelper.wait(enterPasswordButton).click();
        waitHelper.wait(password).sendKeys(Constants.PASSWORD);
        waitHelper.wait(loginButton).click();
    }
    public void openPage(){
        getDriver().get(BasePage.LINK);
    }

}
