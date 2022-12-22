import PageModels.BaseClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public BaseClass baseClass = new BaseClass();

    @BeforeEach
    public void SetUpTest()
    {
        baseClass.Navigate();
    }

    @AfterEach
    public void TearDownTest()
    {
        baseClass.QuitBrowser();
    }
   
}
