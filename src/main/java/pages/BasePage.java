package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitHelper;

public abstract class BasePage {

    @FindBy(xpath = "//span[contains(@class, 'ph-project__user-name')]")
    protected WebElement userInfoDropDown;

    @FindBy(xpath = "//div[contains(@class, 'ph-desc')]")
    protected WebElement userMail;

    @FindBy(xpath = "//a[@href='/sent/']")
    protected WebElement sentButton;

    @FindBy(xpath = "//div[@class='llc__container']")
    protected List<WebElement> mailBody;

    @FindBy(xpath = "//a[@rel='nofollow']")
    protected WebElement loggOutButton;

    @FindBy(xpath = "//div[@class='dataset-letters']")
    protected WebElement dataSet;

    @FindBy(xpath = "//a[@href='/drafts/']")
    protected WebElement draftsButton;

    @FindBy(xpath = "//a[@class = 'nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0'][@href='/drafts/']")
    protected WebElement draftsButtonClicked;

    @FindBy(xpath = "//a[@class = 'nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0'][@href='/sent/']")
    protected WebElement sentButtonClicked;

    protected final String mailSubject = ".//span[@class='ll-sj__normal']";

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected static final WebDriver driver = new ChromeDriver();
    protected final WaitHelper waitHelper = new WaitHelper(driver);
    public static final String LINK = "https://mail.ru/";

    public static WebDriver getDriver() {
        return driver;
    }

    public void navigateToSentPage(){
        waitHelper.wait(sentButton).click();
    }

    public void navigateToDraftsPage() {
        waitHelper.wait(draftsButton).click();
    }

    public void logOut(){
        waitHelper.wait(userInfoDropDown).click();
        waitHelper.wait(loggOutButton).click();
    }

    protected void waitContent(){
        waitHelper.wait(dataSet);
    }
}
