package com.cucumber.testng.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cucumber.testng.driver.DriverManager.getDriver;


public class RegistrationPage extends BasePage {


    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    private final String link = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&dsh=S1326161970%3A1628084887649064&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp";
    private final Random random = new Random();

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameBox;

    @FindBy(xpath = "//select[@id='gender']")
    private WebElement genderDropDown;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameBox;

    @FindBy(xpath = "//input[@name='Passwd']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@name='ConfirmPasswd']")
    private WebElement reEnterPasswordBox;

    @FindBy(xpath = "//div[@id='accountDetailsNext']/div/button/span")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='day']")
    private WebElement dayInput;

    @FindBy(xpath = "//input[@name='year']")
    private WebElement yearInput;

    @FindBy(xpath = "//select[@id='month']")
    private WebElement monthDropDown;

    private final String option = ".//option[@value='1']";

    private void fillFirstName() {
        waitHelper.wait(firstNameBox).sendKeys("firstname" + random.nextInt(4000));
    }

    private void fillLastName() {
        waitHelper.wait(lastNameBox).sendKeys("lastname" + random.nextInt(4000));
    }

    private void chooseGender() {
        waitHelper.wait(genderDropDown).click();
        waitHelper.wait(genderDropDown.findElement(By.xpath(option))).click();
    }

    private void fillUserName() {
        waitHelper.wait(userNameBox).sendKeys("Vs3r9am3" + random.nextInt(4000));
    }

    private void fillPassword() {
        String password = "pAsSw0rd" + random.nextInt(4000);
        waitHelper.wait(passwordBox).sendKeys(password);
        waitHelper.wait(reEnterPasswordBox).sendKeys(password);
    }

    private void clickNextButton() {
        waitHelper.wait(nextButton).click();
    }

    public void register() {
        fillFirstName();
        fillLastName();
        fillUserName();
        fillPassword();
        clickNextButton();
        chooseGender();
    }

    public String getLink() {
        return this.link;
    }

}
