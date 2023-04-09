import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationPageTests {

    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }


    @Test(priority = 1, description = "Validate Registration Page Title")
    public void validateRegistrationPageTitle(){
        WebElement registerLink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]"));
        registerLink.click();
        String regiterPageTitle = driver.getTitle();
        String expectedPageTitle = "Register: Mercury Tours";
        Assert.assertEquals(regiterPageTitle,expectedPageTitle);
    }

    @Test(priority = 2, description="To validate registration")
    public void validateUserRegistration(){

        // Test Data
        String firstName = RandomStringUtils.randomAlphabetic(8);
        String lastName = RandomStringUtils.randomAlphabetic(8);
        String phone = "021-111-212-212";
        String email = firstName + "abc.com";
        String city = "Albama";
        String state = "CA";
        String postalCode = "123456";
        String password = RandomStringUtils.randomAlphabetic(8);

        // Navigate to the Register page
        WebElement registerLink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]"));
        registerLink.click();

        WebElement firstNameTextBox = driver.findElement(By.name("firstName"));
        firstNameTextBox.sendKeys(firstName);

        WebElement lastNameTextBox = driver.findElement(By.name("lastName"));
        lastNameTextBox.sendKeys(lastName);

        WebElement phoneTextBox = driver.findElement(By.name("phone"));
        phoneTextBox.sendKeys(phone);

        WebElement emailTextBox = driver.findElement(By.name("userName"));
        emailTextBox.sendKeys(email);

        WebElement addressTextBox = driver.findElement(By.name("address1"));
        addressTextBox.sendKeys("Address 1");

        WebElement cityTextBox = driver.findElement(By.name("city"));
        cityTextBox.sendKeys(city);

        WebElement stateTextBox = driver.findElement(By.name("state"));
        stateTextBox.sendKeys(state);

        WebElement postalCodeTextBox = driver.findElement(By.name("postalCode"));
        postalCodeTextBox.sendKeys(postalCode);

        Select countryDropDown = new Select(driver.findElement(By.name("country")));
        countryDropDown.selectByValue("ARUBA");

        WebElement userNameTextBox = driver.findElement(By.name("email"));
        userNameTextBox.sendKeys("testuser@testuser.com");

        WebElement passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.sendKeys(password);

        WebElement confirmPasswordTextBox = driver.findElement(By.name("confirmPassword"));
        confirmPasswordTextBox.sendKeys(password);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        WebElement registerSuccessMessage = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"));
        String registerSuccessMessageText = registerSuccessMessage.getText();
        String expectedSuccessMessage = "Dear "+firstName+" "+lastName+",";
        Assert.assertEquals(registerSuccessMessageText,expectedSuccessMessage);

    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}
