package test_01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

public abstract class BaseTest{

    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = BasePage.getDriver();
        driver.get(BasePage.LINK);
        driver.manage().window().maximize();
    }


    @AfterClass
    public void closeDrive() {
        driver.quit();
    }

}
