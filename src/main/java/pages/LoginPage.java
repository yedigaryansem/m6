package pages;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners(TestListener.class)
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

    public void login(User user) {
        log.info("Login into mail");
        waitHelper.wait(userName).sendKeys(user.getUsername());
        waitHelper.highLightElementByName("login");
        waitHelper.pressEnter();
        waitHelper.wait(password).sendKeys(user.getPassword());
        waitHelper.highLightElementByName("password");
        waitHelper.pressEnter();
    }

}
