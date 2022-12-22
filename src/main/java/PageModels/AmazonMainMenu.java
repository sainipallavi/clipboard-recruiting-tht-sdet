package PageModels;
import org.openqa.selenium.By;

public class AmazonMainMenu extends BaseClass {

    public AmazonMainMenu OpenHamburgerMenu() throws Exception {
        var menuSelector = BaseClass.driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        menuSelector.click();
        var mainMenuContainer = By.cssSelector("#hmenu-content");
        WebElementExt.WaitUntilElementIsVisible(mainMenuContainer,true);
        return this;
    }

    public AmazonMainMenu ClickMenuItem(String menuName) throws Exception {
        var menuItem = BaseClass.driver.findElement(By.xpath("//a[@class= 'hmenu-item']//div[text()= '"+menuName+"']"));
        WebElementExt.ScrollTo(menuItem, BaseClass.driver);
        menuItem.click();
        var subMenuContainer = By.cssSelector(".hmenu.hmenu-visible");
        WebElementExt.WaitUntilElementIsVisible(subMenuContainer,true);
        return this;
    }

    public TelevisionPage ClickSubMenuItem(String menuName) throws Exception {
        var menuItem = BaseClass.driver.findElement(By.xpath("//a[@class= 'hmenu-item' and text()= '"+menuName+"']"));
        WebElementExt.ScrollTo(menuItem, BaseClass.driver);
        menuItem.click();
        WebElementExt.WaitUntilElementIsVisible(By.cssSelector(".a-container"),true);
        return new TelevisionPage();
    }
}

