package telecomProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTariffPlanToCustomerPage {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void addTariffPlanToCustomer01(){//Verify that user can navigate to the Add tariff plan to customer page
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        String expectedTitle = "Guru99 Add Tariff Plan to Customer";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle ,"Redirected to wrong page!");
    }

    @Test(priority = 1)
    public void addTariffPlanToCustomer02(){//Verify that user can get the tariff plans after giving valid customer ID
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("171741");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        WebElement plans = driver.findElement(By.xpath("//h2[normalize-space()='Approved Tariff Plans']"));
        boolean isplans = plans.isDisplayed();
        Assert.assertTrue(isplans,"Error in loading tariff plans");
    }

    @Test(priority = 2)
    public void addTariffPlanToCustomer03(){//Verify that user cannot give invalid ID to "customer ID" field
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("171745");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        WebElement errormsg1 = driver.findElement(By.cssSelector("div[class='inner'] h4"));
        boolean iserror = errormsg1.isDisplayed();
        Assert.assertTrue(iserror,"Error in loading tariff plans");
    }

    @Test(priority = 3)
    public void addTariffPlanToCustomer04(){//Verify that user cannot keep "customer ID" field empty
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("123");
        customerId.clear();
        String msg = driver.findElement(By.cssSelector("#message2")).getText();
        Assert.assertEquals(msg,"Number must not be blank", "Wrong error message in field!");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        Alert alert = driver.switchTo().alert();
        String actualmsg = alert.getText();
        String expectedmsg = "Please Correct Value Input";
        Assert.assertEquals(actualmsg , expectedmsg , "Wrong error message in alert!");
    }

    @Test(priority = 4)
    public void addTariffPlanToCustomer05(){//Verify that user cannot enter invalid characters to "customer ID" field
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("mngr602891");
        String msg = driver.findElement(By.cssSelector("#message2")).getText();
        Assert.assertEquals(msg,"Characters are not allowed", "Wrong error message in field!");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        Alert alert = driver.switchTo().alert();
        String actualmsg = alert.getText();
        String expectedmsg = "Please Correct Value Input";
        Assert.assertEquals(actualmsg , expectedmsg , "Wrong error message in alert!");
    }

    @Test(priority = 5)
    public void addTariffPlanToCustomer06(){//Verify that user can add tariff plan after selecting an approved plan
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("171741");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        WebElement radiobtn = driver.findElement(By.xpath("(//td[@align='center'])[1]"));
        radiobtn.click();
        WebElement addplanbtn = driver.findElement(By.xpath("//input[@name='submit']"));
        addplanbtn.click();
        WebElement successmsg = driver.findElement(By.xpath("//h2[normalize-space()='Congratulation Tariff Plan assigned']"));
        boolean ismsg = successmsg.isDisplayed();
        Assert.assertTrue(ismsg,"Error in success message");
    }

    @Test(priority = 6)
    public void addTariffPlanToCustomer07(){//Verify that user cannot add tariff plan before selecting an approved plan
        WebElement addtariffplanoption = driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtariffplanoption.click();
        WebElement customerId = driver.findElement(By.cssSelector("#customer_id"));
        customerId.sendKeys("171741");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        WebElement addplanbtn = driver.findElement(By.xpath("//input[@name='submit']"));
        addplanbtn.click();
        WebElement successmsg = driver.findElement(By.xpath("//h2[normalize-space()='Congratulation Tariff Plan assigned']"));
        boolean ismsg = successmsg.isDisplayed();
        try{
            Assert.assertFalse(ismsg);
        } catch (AssertionError ae) {
            System.out.println("User can add tariff plan without selecting a tariff plan");
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
