package telecomProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayBillingPage {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void payBilling01(){//Verify that user can navigate to the pay billing page
        WebElement PayBillingOpt = driver.findElement(By.ByName.partialLinkText("Pay Billing"));
        PayBillingOpt.click();
        String expectedTitle = "Guru99 Telecom Billing";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to the wrong page");
    }

    @Test(priority = 1)
    public void payBilling02(){//Verify that user can get the billing details after giving valid customer ID
        WebElement PayBillingOpt = driver.findElement(By.ByName.partialLinkText("Pay Billing"));
        PayBillingOpt.click();
        WebElement customerID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        customerID.sendKeys("171741");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        boolean isbillingdetails = driver.findElement(By.xpath("//h1[normalize-space()='Pay Billing']")).isDisplayed();
        Assert.assertTrue(isbillingdetails , "Error in loading billing details");
    }

    @Test(priority = 2)
    public void payBilling03(){//Verify that user cannot give  ID with invalid characters to "customer ID" field
        WebElement PayBillingOpt = driver.findElement(By.ByName.partialLinkText("Pay Billing"));
        PayBillingOpt.click();
        WebElement customerID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        customerID.sendKeys("mf171742");
        String errormsg = driver.findElement(By.cssSelector("#message2")).getText();
        String expectedmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , expectedmsg , "Wrong error message");
    }

    @Test(priority = 3)
    public void payBilling04(){//Verify that user cannot give invalid ID to  "customer ID" field
        WebElement PayBillingOpt = driver.findElement(By.ByName.partialLinkText("Pay Billing"));
        PayBillingOpt.click();
        WebElement customerID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        customerID.sendKeys("171745");
        WebElement submitbtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitbtn.click();
        String msg = driver.findElement(By.cssSelector("div[class='inner'] h4")).getText();
        String expectedmsg = "Please Input Your Correct Customer ID";
        Assert.assertEquals(msg , expectedmsg , "Wrong error message");
    }

    @Test(priority = 4)
    public void payBilling05(){//Verify that user cannot keep "customer ID" field empty
        WebElement PayBillingOpt = driver.findElement(By.ByName.partialLinkText("Pay Billing"));
        PayBillingOpt.click();
        WebElement customerID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        customerID.sendKeys("171745");
        customerID.clear();
        String msg = driver.findElement(By.cssSelector("#message2")).getText();
        String expectedmsg = "Number must not be blank";
        Assert.assertEquals(msg , expectedmsg , "Wrong error message");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
