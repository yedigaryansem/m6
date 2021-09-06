package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxCreator implements IDriverCreator{

    private static WebDriver driver;

    @Override
    public WebDriver CreateWebDriver() {
        WebDriverManager.chromedriver().setup();
        return driver = new FirefoxDriver();
    }
}
