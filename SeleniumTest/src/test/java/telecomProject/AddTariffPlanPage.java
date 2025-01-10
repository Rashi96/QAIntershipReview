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

public class AddTariffPlanPage {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");
    }

    @Test(priority = 0)
    public void addTariffPlan01(){//Verify that user can navigate to the Add Tariff plan page
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        String currentUrl = driver.getCurrentUrl();
        boolean isurl = currentUrl.contains("addtariffplans.php");
        Assert.assertTrue(isurl , "Navigated to a wrong page!");
    }

    @Test(priority = 1)
    public void addTariffPlan02(){//Verify that user can add tariff plan after filling all the fields with valid values
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement monthlyrental = driver.findElement(By.xpath("(//input[@id='rental1'])[1]"));
        monthlyrental.sendKeys("5000");
        WebElement localminutes = driver.findElement(By.xpath("(//input[@id='local_minutes'])[1]"));
        localminutes.sendKeys("500");
        WebElement interminutes = driver.findElement(By.xpath("(//input[@id='inter_minutes'])[1]"));
        interminutes.sendKeys("200");
        WebElement smspack = driver.findElement(By.xpath("(//input[@id='sms_pack'])[1]"));
        smspack.sendKeys("100");
        WebElement minutescharge = driver.findElement(By.xpath("(//input[@id='minutes_charges'])[1]"));
        minutescharge.sendKeys("1");
        WebElement intercharges = driver.findElement(By.xpath("(//input[@id='inter_charges'])[1]"));
        intercharges.sendKeys("2");
        WebElement smscharges = driver.findElement(By.xpath("(//input[@id='sms_charges'])[1]"));
        smscharges.sendKeys("1");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        WebElement successmsg = driver.findElement(By.cssSelector("div[class='inner'] h2"));
        String actualmsg = successmsg.getText();
        String expectedmsg = "Congratulation you add Tariff Plan";
        Assert.assertEquals(actualmsg , expectedmsg , "Wrong message generated!");
    }

    @Test(priority = 2)
    public void addTariffPlan03(){//Verify that all the fields are mandatory in the add tariff plan form
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitbtn.click();
        Alert alert = driver.switchTo().alert();
        String alerttxt = alert.getText();
        String expectedmsg = "please fill all fields Correct Value";
        Assert.assertEquals(alerttxt , expectedmsg , "Wrong message generated!");
    }

    @Test(priority = 3)
    public void addTariffPlan04(){//Verify that user cannot give special characters for the "Monthly Rental" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement monthlyrental = driver.findElement(By.xpath("(//input[@id='rental1'])[1]"));
        monthlyrental.sendKeys("@#$%");
        String errormsg = driver.findElement(By.cssSelector("#message2")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 4)
    public void addTariffPlan05(){//Verify that user cannot give letters for the "Monthly Rental" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement monthlyrental = driver.findElement(By.xpath("(//input[@id='rental1'])[1]"));
        monthlyrental.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message2")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 5)
    public void addTariffPlan06(){//Verify that user cannot keep "Monthly Rental" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement monthlyrental = driver.findElement(By.xpath("(//input[@id='rental1'])[1]"));
        monthlyrental.sendKeys("abc");
        monthlyrental.clear();
        String errormsg = driver.findElement(By.cssSelector("#message2")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 6)
    public void addTariffPlan07(){//Verify that user cannot give special characters for the "Free Local Minutes" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement localminutes = driver.findElement(By.xpath("(//input[@id='local_minutes'])[1]"));
        localminutes.sendKeys("@#$%");
        String errormsg = driver.findElement(By.cssSelector("#message3")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 7)
    public void addTariffPlan08(){//Verify that user cannot give letters for the "Free Local Minutes" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement localminutes = driver.findElement(By.xpath("(//input[@id='local_minutes'])[1]"));
        localminutes.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message3")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 8)
    public void addTariffPlan09(){//Verify that user cannot keep "Free Local Minutes" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement localminutes = driver.findElement(By.xpath("(//input[@id='local_minutes'])[1]"));
        localminutes.sendKeys("abc");
        localminutes.clear();
        String errormsg = driver.findElement(By.cssSelector("#message3")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 9)
    public void addTariffPlan10(){//Verify that user cannot give special characters for the "Free International Minutes" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement interminutes = driver.findElement(By.xpath("(//input[@id='inter_minutes'])[1]"));
        interminutes.sendKeys("@#$%");
        String errormsg = driver.findElement(By.cssSelector("#message4")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 10)
    public void addTariffPlan11(){//Verify that user cannot give letters for the "Free International Minutes" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement interminutes = driver.findElement(By.xpath("(//input[@id='inter_minutes'])[1]"));
        interminutes.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message4")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 11)
    public void addTariffPlan12(){//Verify that user cannot keep "Free International Minutes" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement interminutes = driver.findElement(By.xpath("(//input[@id='inter_minutes'])[1]"));
        interminutes.sendKeys("abc");
        interminutes.clear();
        String errormsg = driver.findElement(By.cssSelector("#message4")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 12)
    public void addTariffPlan13(){//Verify that user cannot give special characters for the "Free SMS Pack" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smspack = driver.findElement(By.xpath("(//input[@id='sms_pack'])[1]"));
        smspack.sendKeys("@#$");
        String errormsg = driver.findElement(By.cssSelector("#message5")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 13)
    public void addTariffPlan14(){//Verify that user cannot give letters for the "Free SMS Pack" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smspack = driver.findElement(By.xpath("(//input[@id='sms_pack'])[1]"));
        smspack.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message5")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 14)
    public void addTariffPlan15(){//Verify that user cannot keep "Free SMS Pack" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smspack = driver.findElement(By.xpath("(//input[@id='sms_pack'])[1]"));
        smspack.sendKeys("abc");
        smspack.clear();
        String errormsg = driver.findElement(By.cssSelector("#message5")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 15)
    public void addTariffPlan16(){//Verify that user cannot give special characters for the "Local Per Minutes Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement minutescharge = driver.findElement(By.xpath("(//input[@id='minutes_charges'])[1]"));
        minutescharge.sendKeys("@#$");
        String errormsg = driver.findElement(By.cssSelector("#message6")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 16)
    public void addTariffPlan17(){//Verify that user cannot give letters for the "Local Per Minutes Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement minutescharge = driver.findElement(By.xpath("(//input[@id='minutes_charges'])[1]"));
        minutescharge.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message6")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 17)
    public void addTariffPlan18(){//Verify that user cannot keep "Local Per Minutes Charges" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement minutescharge = driver.findElement(By.xpath("(//input[@id='minutes_charges'])[1]"));
        minutescharge.sendKeys("abc");
        minutescharge.clear();
        String errormsg = driver.findElement(By.cssSelector("#message6")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 18)
    public void addTariffPlan19(){//Verify that user cannot give special characters for the "International Per Minutes Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement intercharges = driver.findElement(By.xpath("(//input[@id='inter_charges'])[1]"));
        intercharges.sendKeys("@#$");
        String errormsg = driver.findElement(By.cssSelector("#message7")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 19)
    public void addTariffPlan20(){//Verify that user cannot give letters for the "International Per Minutes Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement intercharges = driver.findElement(By.xpath("(//input[@id='inter_charges'])[1]"));
        intercharges.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message7")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 20)
    public void addTariffPlan21(){//Verify that user cannot keep "International Per Minutes Charges" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement intercharges = driver.findElement(By.xpath("(//input[@id='inter_charges'])[1]"));
        intercharges.sendKeys("abc");
        intercharges.clear();
        String errormsg = driver.findElement(By.cssSelector("#message7")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 21)
    public void addTariffPlan22(){//Verify that user cannot give special characters for the "SMS Per Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smscharges = driver.findElement(By.xpath("(//input[@id='sms_charges'])[1]"));
        smscharges.sendKeys("@#$");
        String errormsg = driver.findElement(By.cssSelector("#message8")).getText();
        String actualmsg = "Special characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 22)
    public void addTariffPlan23(){//Verify that user cannot give letters for the "SMS Per Charges" field
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smscharges = driver.findElement(By.xpath("(//input[@id='sms_charges'])[1]"));
        smscharges.sendKeys("abc");
        String errormsg = driver.findElement(By.cssSelector("#message8")).getText();
        String actualmsg = "Characters are not allowed";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 23)
    public void addTariffPlan24(){//Verify that user cannot keep "SMS Per Charges" field empty
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement smscharges = driver.findElement(By.xpath("(//input[@id='sms_charges'])[1]"));
        smscharges.sendKeys("abc");
        smscharges.clear();
        String errormsg = driver.findElement(By.cssSelector("#message8")).getText();
        String actualmsg = "Number must not be blank";
        Assert.assertEquals(errormsg , actualmsg , "Wrong error message!");
    }

    @Test(priority = 24)
    public void addTariffPlan25(){//Verify that user can reset the form after filling  all the fields in the form
        WebElement tariffplanopt = driver.findElement(By.linkText("Add Tariff Plan"));
        tariffplanopt.click();
        WebElement monthlyrental = driver.findElement(By.xpath("(//input[@id='rental1'])[1]"));
        monthlyrental.sendKeys("5000");
        WebElement localminutes = driver.findElement(By.xpath("(//input[@id='local_minutes'])[1]"));
        localminutes.sendKeys("500");
        WebElement interminutes = driver.findElement(By.xpath("(//input[@id='inter_minutes'])[1]"));
        interminutes.sendKeys("200");
        WebElement smspack = driver.findElement(By.xpath("(//input[@id='sms_pack'])[1]"));
        smspack.sendKeys("100");
        WebElement minutescharge = driver.findElement(By.xpath("(//input[@id='minutes_charges'])[1]"));
        minutescharge.sendKeys("1");
        WebElement intercharges = driver.findElement(By.xpath("(//input[@id='inter_charges'])[1]"));
        intercharges.sendKeys("2");
        WebElement smscharges = driver.findElement(By.xpath("(//input[@id='sms_charges'])[1]"));
        smscharges.sendKeys("1");
        WebElement resetbtn = driver.findElement(By.cssSelector("input[value='Reset']"));
        resetbtn.click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
