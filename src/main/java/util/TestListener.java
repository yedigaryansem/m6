package util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private final Logger log = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult){
        saveScreenshot();
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                    + getCurrentTimeAsString() + ".png"));
        }catch (IOException e){
            log.error("Failed To Save ScreenShot: " + e.getLocalizedMessage());
        }
    }

    public String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public Logger getLog(){
        return this.log;
    }
}
