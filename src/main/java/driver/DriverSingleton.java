package driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){

        if (null == driver){
            IDriverCreator creator;
            switch (System.getProperty("browser")){
                case "firefox":{
                    creator = new FirefoxCreator();
                }
                default:{
                    creator = new ChromeCreator();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
