package pages;

import data.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@name='login']")
    private WebElement userName;

    @FindBy(xpath = "//button[@data-testid='enter-password']")
    private WebElement enterPasswordButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void login(){
        waitHelper.wait(userName).sendKeys(Constants.USERNAME);
        waitHelper.highLightElementByName("login");
        waitHelper.pressEnter();
        waitHelper.wait(password).sendKeys(Constants.PASSWORD);
        waitHelper.highLightElementByName("password");
        waitHelper.pressEnter();
    }

}
