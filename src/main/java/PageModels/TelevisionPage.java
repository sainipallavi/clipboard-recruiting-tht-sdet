package PageModels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TelevisionPage extends BaseClass {

    public ResultsPage SelectCheckBoxByName(String checkboxName) throws Exception {
        var checkboxSelector = GetRefinementsSections().findElement(By.xpath("//span[text()[contains(., '"+checkboxName+"')]]/preceding-sibling::div"));
        WebElementExt.ScrollTo(checkboxSelector, driver);
        checkboxSelector.click();
        WebElementExt.WaitUntilElementIsVisible(By.xpath("//span[text()='RESULTS']"), true);
        return new ResultsPage();
    }
    private WebElement GetRefinementsSections()
    {
        var refinementsMenuSelector = driver.findElement(By.id("s-refinements"));
        return refinementsMenuSelector;
    }
}
