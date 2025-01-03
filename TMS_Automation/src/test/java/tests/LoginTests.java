package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://wireapps-tms-dev.vercel.app/sign-in");
    }

    @Test
    public void valid_login() {
        LoginPage lp = new LoginPage(driver);
        lp.GiveEmail();
        lp.GivePassword();
        lp.ClickContinueBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
