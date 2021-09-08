package com.cucumber.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SentPage extends BasePage{


    public boolean isMailInSentBySubject(String subject){
        waitHelper.wait(sentButtonClicked);
        for (WebElement sentMail : mailBody) {
            if (sentMail.findElement(By.xpath(mailSubject)).getText().equals(subject)) {
                return true;
            }
        }
        return false;
    }
}
