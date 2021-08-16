package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DraftPage extends BasePage {

    public DraftPage() {
        super();
    }

    public boolean isMailInDraftsBySubject(String subject) {
        waitHelper.wait(draftsButtonClicked);
        for (WebElement draft : mailBody) {
            if (draft.findElement(By.xpath(mailSubject)).getText().equals(subject)) {
                return true;
            }
        }
        return false;
    }

    public By getMailBuySubject(String subject) {
        waitHelper.wait(draftsButtonClicked);
        for (WebElement draft : mailBody) {
            if (draft.findElement(By.xpath(mailSubject)).getText().equals(subject)) {
                return By.xpath(mailSubject);
            }
        }
        return null;
    }

    public void waitForSentMailDisappear(String subject){
        waitHelper.waitUntilElementToBeDisappeared(getMailBuySubject(subject), subject);
    }


    public void clickOnDraftBySubject(String subject){
        waitHelper.wait(draftsButtonClicked);
        for (WebElement draft : mailBody) {
            waitHelper.wait(draft);
            if (draft.findElement(By.xpath(mailSubject)).getText().equals(subject)) {
                draft.click();
            }
        }
    }

    public boolean isMailDisappearedFromDrafts(String subject){
        waitHelper.wait(draftsButtonClicked);
        for (WebElement draft : mailBody) {
            waitHelper.wait(draft);
            if (draft.findElement(By.xpath(mailSubject)).getText().equals(subject)) {
                return false;
            }
        }
        return true;

    }
}
