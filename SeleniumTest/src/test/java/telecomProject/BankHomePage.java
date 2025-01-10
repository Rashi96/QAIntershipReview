package telecomProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankHomePage {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void bankHome01(){//Verify that user can log in to the system with giving proper email
        WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
        email.sendKeys("nimeshamadhushani100@gmail.com");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitbtn.click();
        String expectedtext = "Access details to demo site.";
        String actualtest = driver.findElement(By.xpath("//h2[normalize-space()='Access details to demo site.']")).getText();
        Assert.assertEquals(actualtest , expectedtext ,"Error in loading access details page");
    }

    @Test(priority = 1)
    public void bankHome02(){//Verify that user cannot log in to the system with invalid email
        WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
        email.sendKeys("123");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitbtn.click();
        String expectedtext = "Email ID is not valid";
        String actualtest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(actualtest , expectedtext ,"Missing error message when email is invalid");
    }

    @Test(priority = 2)
    public void bankHome03(){//Verify that user cannot login to the system with empty email
        WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
        email.sendKeys("");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitbtn.click();
        String expectedtext = "Email ID must not be blank";
        String actualtest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(actualtest , expectedtext ,"Missing error message when email is empty");
    }

    @Test(priority = 3)
    public void bankHome04(){//Verify that user can navigate to the telecom project page
        WebElement telecomProjectOption = driver.findElement(By.xpath("//a[normalize-space()='Telecom Project']"));
        telecomProjectOption.click();
        String expectedTitle = "Guru99 Telecom";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to wrong page");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
