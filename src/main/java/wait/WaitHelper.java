package wait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
        this.action = new Actions(this.driver);
        this.js = (JavascriptExecutor) driver;
    }

    private final WebDriverWait wait;
    private final Actions action;
    private final JavascriptExecutor js;

    public WebElement wait(WebElement target) {
        return wait.until(ExpectedConditions.visibilityOf(target));
    }

    public List<WebElement> wait(List<WebElement> targets) {

        return wait.until(ExpectedConditions.visibilityOfAllElements(targets));
    }

    public void pressEnter() {
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void pressCtrlEnter() {
        action.sendKeys(Keys.CONTROL, Keys.ENTER).build().perform();
    }

    public void waitUntilElementToBeDisappeared(By target, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(target, text));

    }

    public void highLightElementByName(String name){
        js.executeScript(String.format("document.getElementsByName(\"%s\")[0].style.border='2px solid red';", name));
        js.executeScript(String.format("document.getElementsByName(\"%s\")[0].style.background='yellow';",name));
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
    }
}

