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

public class EditProfilePage {

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
    public void editProfile01(){//Verify that user can navigate to the "Edit Profile" page.
        WebElement editProfileOpt = driver.findElement(By.cssSelector("#editprofile"));
        editProfileOpt.click();
        WebElement editprofilebanner = driver.findElement(By.xpath("//h1[normalize-space()='Editing user profile']"));
        boolean isbanner = editprofilebanner.isDisplayed();
        Assert.assertTrue(isbanner , "Unexpected page navigation");
    }

    @Test(priority = 1)
    public void editProfile02(){//Verify that user can update user profile
        WebElement editProfileOpt = driver.findElement(By.cssSelector("#editprofile"));
        editProfileOpt.click();
        //Edit birthDate
        WebElement title = driver.findElement(By.id("user_title"));
        Select select1 = new Select(title);
        select1.selectByVisibleText("Miss");
        WebElement surname = driver.findElement(By.id("user_surname"));
        surname.sendKeys("Rashmitha");
        WebElement firstname = driver.findElement(By.id("user_firstname"));
        firstname.sendKeys("Minoli");
        WebElement phnno = driver.findElement(By.id("user_phone"));
        phnno.sendKeys("0706959277");
        //Fill birth year
        WebElement birthYear = driver.findElement(By.id("user_dateofbirth_1i"));
        Select select2 = new Select(birthYear);
        select2.selectByVisibleText("1989");
        //Fill birth month
        WebElement birthMonth = driver.findElement(By.id("user_dateofbirth_2i"));
        Select select3 = new Select(birthMonth);
        select3.selectByVisibleText("March");
        //Fill birth date
        WebElement birthDate = driver.findElement(By.id("user_dateofbirth_3i"));
        Select select4 = new Select(birthDate);
        select4.selectByVisibleText("21");
        WebElement licensetype = driver.findElement(By.id("user_licencetype_t"));
        licensetype.click();
        //select license period
        WebElement licenceperiod = driver.findElement(By.id("user_licenceperiod"));
        Select select5 = new Select(licenceperiod);
        select5.selectByVisibleText("4");
        //select occupation
        WebElement occupation = driver.findElement(By.id("user_occupation_id"));
        Select select6 = new Select(occupation);
        select6.selectByVisibleText("Doctor");
        WebElement street = driver.findElement(By.id("user_address_attributes_street"));
        street.sendKeys("Galle Road");
        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("Matara");
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("Sri Lanka");
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("81000");
        WebElement updatebtn = driver.findElement(By.cssSelector("input[value='Update User']"));
        updatebtn.click();
        WebElement profileOpt = driver.findElement(By.cssSelector("#profile"));
        String value = profileOpt.getAttribute("aria-selected");
        try{
            Assert.assertEquals(value , "true");
        } catch (AssertionError ae) {
            System.out.println("Not navigated to the profile page after updating the profile details");;
        }
    }

    @Test(priority = 2)
    public void editpPofile03(){//Verify that user cannot enter an invalid phone number format in the "Phone" field.
        WebElement editProfileOpt = driver.findElement(By.cssSelector("#editprofile"));
        editProfileOpt.click();
        WebElement phnno = driver.findElement(By.id("user_phone"));
        phnno.sendKeys("070abcdefg255");
        String ExpectedErrorMessage = "Invalid Phone Number";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter invalid phone number to the phone number field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter invalid phone number to the phone number field");;
        }
    }

    @Test(priority = 3)
    public void editProfile04(){//Verify that user cannot enter a numerical value for the "Country" field.
        WebElement editProfileOpt = driver.findElement(By.cssSelector("#editprofile"));
        editProfileOpt.click();
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("67890");
        String ExpectedErrorMessage = "Invalid format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter numerical value to the country field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter numerical value to the country field");;
        }
    }

    @Test(priority = 4)
    public void editProfile05(){//Verify that user cannot enter a alphabetical value for the "Post code" field.
        WebElement editProfileOpt = driver.findElement(By.cssSelector("#editprofile"));
        editProfileOpt.click();
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("67890");
        String ExpectedErrorMessage = "Invalid format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter alphabetical value to the post code field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter alphabetical value to the post code field");;
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
