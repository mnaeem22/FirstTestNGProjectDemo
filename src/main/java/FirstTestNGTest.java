import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGTest {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {

        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}