package com.cucumber.testng.steps;

import com.cucumber.testng.data.Constants;
import com.cucumber.testng.driver.DriverManager;
import com.cucumber.testng.hooks.DriverHooks;
import com.cucumber.testng.pages.BasePage;
import com.cucumber.testng.pages.InboxPage;
import com.cucumber.testng.pages.LoginPage;
import io.cucumber.core.runtime.BackendServiceLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends DriverHooks {

    private final LoginPage loginPage = new LoginPage();
    private final InboxPage inboxPage = new InboxPage();

    @When("the user opens mail.ru website")
    public void OpensMailRuWebsite() {
        loginPage.openPage();
    }

    @When("the user login to mail.ru")
    public void LoginToMailRu() {
        loginPage.login();
    }

    @When("page with {string} displayed")
    public void verifyPageUsername(String username) {
        Assert.assertEquals(inboxPage.getUserMailName(), username + "@mail.ru");
    }
}
