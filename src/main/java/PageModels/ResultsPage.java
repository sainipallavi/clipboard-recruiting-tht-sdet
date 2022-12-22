package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BaseClass {

    public ResultsPage SelectSortOption(String optionName) throws Exception {
        var sortSelector = GetSortDropDown().findElement(By.xpath("//a[contains(@class, 'a-dropdown-link') and text() ='"+optionName+"']"));
        sortSelector.click();
        return this;
    }

    public ProductPage SelectSearchResultByIndex(String searchIndex)
    {
        var searchResult = driver.findElement(By.cssSelector("div[data-index='"+searchIndex+"']"));
        searchResult.click();
        SwitchToTab(1);
        return new ProductPage();
    }

    private WebElement GetSortDropDown() throws Exception {
        var sortDropDownicon = driver.findElement(By.id("s-result-sort-select"));
        WebElementExt.ClickByJs(sortDropDownicon, driver);
        var dropdownmenu = driver.findElement(By.cssSelector(".a-list-link"));
        return dropdownmenu;
    }


}
