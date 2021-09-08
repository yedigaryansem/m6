package test_01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.testng.pages.BasePage;

import static com.cucumber.testng.driver.DriverManager.getDriver;

public abstract class BaseTest{

    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = getDriver();
        driver.manage().window().maximize();
    }


    @AfterClass
    public void closeDrive() {
        driver.quit();
    }

}
