package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeCreator implements IDriverCreator{

    private static WebDriver driver;

    @Override
    public WebDriver CreateWebDriver() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }
}
