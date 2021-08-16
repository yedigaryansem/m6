package drivers;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriver {

    protected static WebDriver driver;

    public static WebDriver setRemoteDriver(URL url, DesiredCapabilities capabilities){
        driver = new RemoteWebDriver(url, capabilities);
        return driver;
    }

    public static WebDriver getRemoteDriver(){
        return driver;
    }
}
