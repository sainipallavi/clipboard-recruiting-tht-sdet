package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementExt{

    public static boolean WaitUntilElementIsVisible(By locator, boolean exceptionOnTimeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, 5);
        var success = true;

        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(Exception exception)
        {
            if(exceptionOnTimeout)
            {
                throw new Exception(exception.getMessage());
            }

            success = false;
        }

        return success;
    }

    public static void ScrollTo(WebElement element, WebDriver driver) throws Exception {
        var scroller = (JavascriptExecutor) driver;
        if(scroller == null)
        {
            return;
        }

        try
        {
            var actions = new Actions(driver);
            scroller.executeScript("arguments[0].scrollIntoView();", element);
            actions.moveToElement(element).perform();
            actions.release(element);
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }

    public static void ClickByJs(WebElement element, WebDriver driver)
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", element);
    }
}
