package com.cucumber.testng.popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.testng.pages.BasePage;

import static com.cucumber.testng.driver.DriverManager.getDriver;

public class SendMailPopUp extends BasePage {


    @FindBy(xpath = "//input[contains(@class, 'container--H9L5q')and not(contains(@name,'Subject'))]")
    private WebElement address;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subject;

    @FindBy(xpath = "//div[@role ='textbox']")
    private WebElement mailBody;

    @FindBy(xpath = "//span[contains(@class,'e button2_hover-support ')]//span[@class='button2__wrapper']//span")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'_w')]//div[contains(@class,'com')]//span[contains(@class,'_p')]//span[contains(@class,'w')]")
    private WebElement sendButton;

    @FindBy(xpath = "//button[@com.cucumber.testng.data-promo-id='collapse']")
    private WebElement rollUpdButton;

    @FindBy(xpath = "//div[@class = 'layer__controls']//span[@class='button2__wrapper']")
    private WebElement closePupUpButton;

    public SendMailPopUp() {
        PageFactory.initElements(getDriver(), this);
    }

    private void rollUpMail() {
        waitHelper.wait(rollUpdButton).click();
    }

    private void clickOnSaveButtonAndRollUpMail() {
        waitHelper.wait(saveButton).click();
        rollUpMail();
    }

    public void clickOnSendButton() {
        waitHelper.wait(sendButton).click();
        waitHelper.wait(closePupUpButton).click();
    }

    public void createMailAndSave(String text) {

        waitHelper.wait(address).sendKeys(text);
        waitHelper.wait(subject).sendKeys(text);
        waitHelper.wait(mailBody).sendKeys(text);
        clickOnSaveButtonAndRollUpMail();
    }
}
