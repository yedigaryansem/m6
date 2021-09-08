package com.cucumber.testng.driver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private final static String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private static final int IMPLICIT_WAIT_TIME = 5;
    private static final int PAGE_LOAD = 20;
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager(){
    }

    public static void setDriver(){

        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD, TimeUnit.SECONDS);
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver(){
        return webDriverThreadLocal.get();
    }

    public static void quitDriver(){
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });

    }
}
