package insuranceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RetreiveQuotationPage {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.sendKeys("nimeshamadhushani100@gmail.com");
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("1999nime*");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitbtn.click();
    }

    @Test(priority = 0)
    public void retrieveQuotation01(){//Verify that user can navigate to the "Retrieve Quotation" page.
        WebElement retrieveQuotation = driver.findElement(By.cssSelector("#retrieve"));
        retrieveQuotation.click();
        String value = retrieveQuotation.getAttribute("aria-selected");
        Assert.assertEquals(value , "true" , "Profile option is not selected");
    }

    @Test(priority = 1)
    public void retrieveQuotation02(){//Verify that user can retrieve the saved quotation
        WebElement retrieveQuotation = driver.findElement(By.cssSelector("#retrieve"));
        retrieveQuotation.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement idField = driver.findElement(By.xpath("//input[@placeholder='identification number']"));
        idField.sendKeys("42339");
        WebElement retreivebtn = driver.findElement(By.id("getquote"));
        retreivebtn.click();
        WebElement quotationDetails = driver.findElement(By.xpath("//font[normalize-space()='Retrieve Quotation']"));
        boolean isshow = quotationDetails.isDisplayed();
        Assert.assertTrue(isshow,"Unexpected page loaded!");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
