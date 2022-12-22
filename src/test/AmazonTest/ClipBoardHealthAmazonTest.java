import PageModels.AmazonMainMenu;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClipBoardHealthAmazonTest extends BaseTest {
    AmazonMainMenu mainMenu = new AmazonMainMenu();
    @Tag("smokeTest")
    @DisplayName("This test navigates Amazon's Main menu to select, sort and finally verify 'About This Item' section of the 2nd Search search Result of High Priced Samsung Televisions.")
    @Test
    void Test() throws Exception {
        boolean isAboutThisItemTextPresent = mainMenu.OpenHamburgerMenu()
                .ClickMenuItem("TV, Appliances, Electronics")
                .ClickSubMenuItem("Televisions")
                .SelectCheckBoxByName("Samsung")
                .SelectSortOption("Price: High to Low")
                .SelectSearchResultByIndex("1")
                .GetAboutThisItemText();
        Assert.isTrue(isAboutThisItemTextPresent, "About This Item section for the selected product is not available.");
    }
}
