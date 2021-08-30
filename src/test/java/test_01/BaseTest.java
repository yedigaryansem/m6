package test_01;

import java.net.MalformedURLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.BasePage;
import util.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest{

    private WebDriver driver;
    String nodeURL;

    @BeforeClass
    public void setRemoteDriver() throws MalformedURLException{
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            nodeURL = "http://192.168.224.217:4444/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = BasePage.getDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(BasePage.LINK);
    }


    @AfterClass
    public void closeDrive() {
        driver.quit();
    }

}
