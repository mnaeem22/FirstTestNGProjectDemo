import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    @Test(priority=1)
    public void verifyHomepageTitle() {

        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void loginTest() {
        //Login Page
        WebElement userNameTextField = driver.findElement(By.name("userName"));
        userNameTextField.sendKeys("test");
        WebElement passwordTextField = driver.findElement(By.name("password"));
        passwordTextField.sendKeys("test");
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
        //Dashboard
        WebElement successMessageHeading = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"));
        String actualSuccessMessageHeadingText = successMessageHeading.getText();
        String expectedSuccessMessageHeadingText = "Login Successfully";
        Assert.assertEquals(actualSuccessMessageHeadingText,expectedSuccessMessageHeadingText);

    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}