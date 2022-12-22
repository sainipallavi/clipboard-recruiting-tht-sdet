package PageModels;
import org.openqa.selenium.By;

public class ProductPage extends BaseClass {

    public boolean GetAboutThisItemText()
    {
        var sectionSelector = BaseClass.driver.findElement(By.id("feature-bullets"));
        var sectionHeader = sectionSelector.findElement(By.cssSelector("h1")).getText();
        var sectionContents = sectionSelector.findElement(By.cssSelector(".a-list-item")).getText();
        System.out.println(sectionContents);
        return sectionHeader.equals("About this item");
    }
}
