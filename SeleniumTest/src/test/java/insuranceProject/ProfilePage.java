package insuranceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePage {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
    }

    @Test(priority = 0)
    public void profile01(){//Verify that user can navigate to the "Profile" page.
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.sendKeys("nimeshamadhushani100@gmail.com");
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("1999nime*");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitbtn.click();
        WebElement profileOpt = driver.findElement(By.cssSelector("#profile"));
        profileOpt.click();
        String value = profileOpt.getAttribute("aria-selected");
        Assert.assertEquals(value , "true" , "Profile option is not selected");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
