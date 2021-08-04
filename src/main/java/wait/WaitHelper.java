package wait;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 60);
    }

    private final WebDriverWait wait;


    public WebElement wait(WebElement target){
        return wait.until(ExpectedConditions.visibilityOf(target));
    }

    public List<WebElement> wait(List<WebElement> targets){
        return wait.until(ExpectedConditions.visibilityOfAllElements(targets));
    }

    public void refreshPage(){
        this.driver.navigate().refresh();
    }
}

