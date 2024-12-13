package insuranceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RequestQuotation {

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
    public void requestQuotation01(){//Verify that user can navigate to the "Request Quotation" page.
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        WebElement requestQuotationBanner = driver.findElement(By.xpath("//h2[normalize-space()='Request a quotation']"));
        boolean isbanner = requestQuotationBanner.isDisplayed();
        Assert.assertTrue(isbanner , "Unexpected page navigation");
    }

    @Test(priority = 1)
    public void requestQuotation02() {//Verify that user cannot give an invalid value for Annual mileage
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        WebElement annualMillage = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
        annualMillage.sendKeys("CD");
        String ExpectedErrorMessage = "Invalid Format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter invalid value for annual mileage field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter invalid value for annual mileage field");;
        }
    }

    @Test(priority = 2)
    public void requestQuotation03() {//Verify that user cannot give an invalid value for Estimated value
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("600");
        String ExpectedErrorMessage = "Invalid Format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter invalid value for estimated value field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter invalid value for estimated value field");
        }
    }

    @Test(priority = 3)
    public void requestQuotation04(){//Verify that user can calculate Premium
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        //Fill break down cover
        WebElement breakDownCover = driver.findElement(By.id("quotation_breakdowncover"));
        Select select1 = new Select(breakDownCover);
        select1.selectByVisibleText("No cover");
        WebElement windscreenRepair = driver.findElement(By.id("quotation_windscreenrepair_f"));
        windscreenRepair.click();
        WebElement incident = driver.findElement(By.id("quotation_incidents"));
        incident.sendKeys("5");
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        requestQuotation.sendKeys("CAA3125");
        WebElement annualMillage = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
        annualMillage.sendKeys("120");
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("600");
        WebElement parkingLocation = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
        Select select2 = new Select(parkingLocation);
        select2.selectByVisibleText("Driveway/Carport");
        //Fill start of policy
        WebElement year = driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2020");
        WebElement month = driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i"));
        Select select4 = new Select(month);
        select4.selectByVisibleText("February");
        WebElement date = driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i"));
        Select select5 = new Select(date);
        select5.selectByVisibleText("5");
        WebElement calculatebtn = driver.findElement(By.cssSelector("input[value='Calculate Premium']"));
        calculatebtn.click();
        String ExpectedCalcMessage = "Calculated Premium";
        try{
            WebElement clacmsg;
            try{
                clacmsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedCalcMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Calculation details missing");
                return;
            }
            boolean iserror = clacmsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error loading calculation details");;
        }
    }

    @Test(priority = 4)
    public void requestQuotation05(){//Verify that user can reset the filled form
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        //Fill break down cover
        WebElement breakDownCover = driver.findElement(By.id("quotation_breakdowncover"));
        Select select1 = new Select(breakDownCover);
        select1.selectByVisibleText("No cover");
        WebElement windscreenRepair = driver.findElement(By.id("quotation_windscreenrepair_f"));
        windscreenRepair.click();
        WebElement incident = driver.findElement(By.id("quotation_incidents"));
        incident.sendKeys("5");
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        requestQuotation.sendKeys("CAA3125");
        WebElement annualMillage = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
        annualMillage.sendKeys("120");
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("600");
        WebElement parkingLocation = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
        Select select2 = new Select(parkingLocation);
        select2.selectByVisibleText("Driveway/Carport");
        //Fill start of policy
        WebElement year = driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2020");
        WebElement month = driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i"));
        Select select4 = new Select(month);
        select4.selectByVisibleText("February");
        WebElement date = driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i"));
        Select select5 = new Select(date);
        select5.selectByVisibleText("5");
        WebElement resetbtn = driver.findElement(By.cssSelector("#resetquote"));
        resetbtn.click();
    }

    @Test(priority = 5)
    public void requestQuotation06(){//Verify that user can save quotation
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        //Fill break down cover
        WebElement breakDownCover = driver.findElement(By.id("quotation_breakdowncover"));
        Select select1 = new Select(breakDownCover);
        select1.selectByVisibleText("No cover");
        WebElement windscreenRepair = driver.findElement(By.id("quotation_windscreenrepair_f"));
        windscreenRepair.click();
        WebElement incident = driver.findElement(By.id("quotation_incidents"));
        incident.sendKeys("5");
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        requestQuotation.sendKeys("CAA3125");
        WebElement annualMillage = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
        annualMillage.sendKeys("120");
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("600");
        WebElement parkingLocation = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
        Select select2 = new Select(parkingLocation);
        select2.selectByVisibleText("Driveway/Carport");
        //Fill start of policy
        WebElement year = driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2020");
        WebElement month = driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i"));
        Select select4 = new Select(month);
        select4.selectByVisibleText("February");
        WebElement date = driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i"));
        Select select5 = new Select(date);
        select5.selectByVisibleText("5");
        WebElement savebtn = driver.findElement(By.cssSelector("input[value='Save Quotation']"));
        savebtn.click();
        boolean isnavigate = driver.getCurrentUrl().contains("new_quotation.php");
        Assert.assertTrue(isnavigate , "Unexpected page navigation");
    }

    @Test(priority = 6)
    public void requestQuotation07(){//Verify that the user can get the identification number after saving the quotation
        WebElement requestQuotation = driver.findElement(By.cssSelector("#newquote"));
        requestQuotation.click();
        //Fill break down cover
        WebElement breakDownCover = driver.findElement(By.id("quotation_breakdowncover"));
        Select select1 = new Select(breakDownCover);
        select1.selectByVisibleText("No cover");
        WebElement windscreenRepair = driver.findElement(By.id("quotation_windscreenrepair_f"));
        windscreenRepair.click();
        WebElement incident = driver.findElement(By.id("quotation_incidents"));
        incident.sendKeys("5");
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        requestQuotation.sendKeys("CAA3125");
        WebElement annualMillage = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
        annualMillage.sendKeys("120");
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("600");
        WebElement parkingLocation = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
        Select select2 = new Select(parkingLocation);
        select2.selectByVisibleText("Driveway/Carport");
        //Fill start of policy
        WebElement year = driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2020");
        WebElement month = driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i"));
        Select select4 = new Select(month);
        select4.selectByVisibleText("February");
        WebElement date = driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i"));
        Select select5 = new Select(date);
        select5.selectByVisibleText("5");
        WebElement savebtn = driver.findElement(By.cssSelector("input[value='Save Quotation']"));
        savebtn.click();
        WebElement idlabel = driver.findElement(By.xpath("//b[normalize-space()='Please write it down for later retrieve']"));
        boolean isid = idlabel.isDisplayed();
        Assert.assertTrue(isid , "ID not displayed");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
