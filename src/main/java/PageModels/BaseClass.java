package PageModels;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BaseClass {
    private static final String HOME_PAGE_URL = EnvFactory.getInstance().getConfig().getString("HOME_PAGE_URL");
    public static WebDriver driver;
    public static WebDriver Navigate()
    {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
        return driver;
    }

    public static void QuitBrowser()
    {
        driver.quit();
    }

    public static void SwitchToTab(int tabIndex)
    {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(tabIndex));
    }
}
