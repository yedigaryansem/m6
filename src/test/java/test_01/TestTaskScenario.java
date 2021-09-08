//package test_01;
//
//import java.util.Random;
//
//import com.cucumber.testng.data.Constants;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import com.cucumber.testng.pages.DraftPage;
//import com.cucumber.testng.pages.InboxPage;
//import com.cucumber.testng.pages.LoginPage;
//import com.cucumber.testng.pages.SentPage;
//import com.cucumber.testng.popups.SendMailPopUp;
//
//public class TestTaskScenario extends BaseTest {
//    Random random = new Random();
//    private final String testText = "a" + random.nextInt(4000) +  "@a.a";
//
//    @Test
//    public void loginScenario(){
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.login();
//        InboxPage inboxPage = new InboxPage();
//        Assert.assertEquals(inboxPage.getUserMailName(), Constants.USERNAME + "@mail.ru");
//        inboxPage.clickWriteMailButton();
//        SendMailPopUp sendMailPopUp = new SendMailPopUp();
//        sendMailPopUp.createMailAndSave(testText);
//        inboxPage.navigateToDraftsPage();
//        DraftPage draftPage = new DraftPage();
//        Assert.assertTrue(draftPage.isMailInDraftsBySubject(testText));
//        draftPage.clickOnDraftBySubject(testText);
//        sendMailPopUp.clickOnSendButton();
//        Assert.assertTrue(draftPage.isMailDisappearedFromDrafts(testText));
//        draftPage.navigateToSentPage();
//        SentPage sentPage = new SentPage();
//        Assert.assertTrue(sentPage.isMailInSentBySubject(testText));
//        sentPage.logOut();
//
//    }
//}