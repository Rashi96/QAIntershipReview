package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    @Given("User navigate to the OrangeHRM application")
    public void userNavigateToTheOrangeHRMApplication() {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(driver.getTitle());
    }

    @Given("User enter the username")
    public void userEnterTheUsername() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    }
    @Given("User enter the password")
    public void userEnterThePassword() {
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
    }
    @When("user click on the login button")
    public void userClickOnTheLoginButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
    @Then("Login should be success")
    public void loginShouldBeSuccess() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        driver.quit();
    }
    @Given("User enter invalid username")
    public void userEnterInvalidUsername() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Nimesha");
    }
    @Then("Login should be fail")
    public void loginShouldBeFail() {
        driver.quit();
    }
}
