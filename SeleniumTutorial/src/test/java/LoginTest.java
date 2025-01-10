import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the ChromeDriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }
    @Test
    public void testValidLogin() {
        // Locate username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Enter valid credentials
        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPass");
        loginButton.click();

        // Validate successful login
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed(), "Login should succeed for valid credentials.");
    }
    @Test
    public void testInvalidLogin() {
        // Locate username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Enter invalid credentials
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("wrongPass");
        loginButton.click();

        // Validate unsuccessful login
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Login should fail for invalid credentials.");
    }

    @AfterClass
    public void close() {
        // Close the browser
            driver.quit();
        }
    }


