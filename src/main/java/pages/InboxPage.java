package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage {

    @FindBy(xpath = "//span[@class = 'compose-button__txt']")
    private WebElement writeMailButton;


    public InboxPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getUserMailName() {
        waitHelper.wait(userInfoDropDown).click();
        return waitHelper.wait(userMail).getText();
    }

    public void clickWriteMailButton() {
        waitHelper.wait(writeMailButton).click();
    }

}
