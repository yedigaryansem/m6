package test_01;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DraftPage;
import pages.InboxPage;
import pages.LoginPage;
import pages.SentPage;
import popups.SendMailPopUp;
import service.UserCreator;
import util.StringUtils;

public class TestTaskScenario extends BaseTest {

    private final String testText = StringUtils.createRandomMailSubject();

    @Test
    public void loginScenario(){
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage loginPage = new LoginPage();
        loginPage.login(testUser);
        InboxPage inboxPage = new InboxPage();
        Assert.assertEquals(inboxPage.getUserMailName(), testUser.getUsername() + "@mail.ru");
        inboxPage.clickWriteMailButton();
        SendMailPopUp sendMailPopUp = new SendMailPopUp();
        sendMailPopUp.createMailAndSave(testText);
        inboxPage.navigateToDraftsPage();
        DraftPage draftPage = new DraftPage();
        Assert.assertTrue(draftPage.isMailInDraftsBySubject(testText));
        draftPage.clickOnDraftBySubject(testText);
        sendMailPopUp.clickOnSendButton();
        draftPage.waitForSentMailDisappear(testText);
        Assert.assertTrue(draftPage.isMailDisappearedFromDrafts(testText));
        draftPage.navigateToSentPage();
        SentPage sentPage = new SentPage();
        Assert.assertTrue(sentPage.isMailInSentBySubject(testText));
        sentPage.logOut();

    }
}