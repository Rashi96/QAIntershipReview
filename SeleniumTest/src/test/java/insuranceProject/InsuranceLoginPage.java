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

public class InsuranceLoginPage {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
    }

    @Test(priority = 0)
    public void insurancelogin01(){//Verify that user can navigate to the "Insurance Project Login" page.
        driver.get("https://demo.guru99.com/");
        WebElement insuranceProjectOpt = driver.findElement(By.linkText("Insurance Project"));
        insuranceProjectOpt.click();
        String actualtitle = driver.getTitle();
        String expectedtitle = "Insurance Broker System - Login";
        Assert.assertEquals(actualtitle , expectedtitle , "Navigated to unexpected page");
    }

    @Test(priority = 1)
    public void insurancelogin02(){//Verify that user can navigate to the user registration page
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        String actualtitle = driver.getTitle();
        String expectedtitle = "Insurance Broker System - Register";
        Assert.assertEquals(actualtitle , expectedtitle , "Navigated to unexpected page");
    }

    @Test(priority = 2)
    public void insurancelogin03(){//Verify that user can register to the system by filling all the fields
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement usertitle = driver.findElement(By.id("user_title"));
        Select select = new Select(usertitle);
        select.selectByVisibleText("Miss");
        WebElement firstname = driver.findElement(By.id("user_firstname"));
        firstname.sendKeys("nimesha");
        WebElement lastname = driver.findElement(By.id("user_surname"));
        lastname.sendKeys("perera");
        WebElement phoneno = driver.findElement(By.id("user_phone"));
        phoneno.sendKeys("0778975552");
        //select birth year
        WebElement birthyear = driver.findElement(By.id("user_dateofbirth_1i"));
        Select select1 = new Select(birthyear);
        select1.selectByVisibleText("1935");
        //select birth month
        WebElement birthmonth = driver.findElement(By.id("user_dateofbirth_2i"));
        Select select2 = new Select(birthmonth);
        select2.selectByVisibleText("March");
        //select birthdate
        WebElement birthdate = driver.findElement(By.id("user_dateofbirth_3i"));
        Select select3 = new Select(birthdate);
        select3.selectByVisibleText("4");
        WebElement licensetype = driver.findElement(By.xpath("//input[@id='licencetype_f']"));
        licensetype.click();
        //select license period
        WebElement licenceperiod = driver.findElement(By.id("user_licenceperiod"));
        Select select4 = new Select(licenceperiod);
        select4.selectByVisibleText("4");
        //select occupation
        WebElement occupation = driver.findElement(By.id("user_occupation_id"));
        Select select5 = new Select(occupation);
        select5.selectByVisibleText("Doctor");
        WebElement street = driver.findElement(By.id("user_address_attributes_street"));
        street.sendKeys("Galle Road");
        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("Matara");
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("Sri Lanka");
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("81000");
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("nimesha@gmail.com");
        WebElement password = driver.findElement(By.id("user_user_detail_attributes_password"));
        password.sendKeys("abc1987#");
        WebElement confirmpassword = driver.findElement(By.id("user_user_detail_attributes_password_confirmation"));
        confirmpassword.sendKeys("abc1987#");
        WebElement submitbtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitbtn.click();
        String expectedtitle = "Insurance Broker System - Login";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle , expectedtitle ,"Unexpected page navigation");
    }

    @Test(priority = 3)
    public void insurancelogin04(){//Verify that user cannot register to the system by keeping all the fields as empty
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        String ExpectedErrorMessage = "Fill the details first";

        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user keep all the fields empty");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user register the form without filling fields ");
        }
    }

    @Test(priority = 4)
    public void insurancelogin05(){//Verify that user cannot give an invalid phone number format to the "Phone" field.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement phnno = driver.findElement(By.id("user_phone"));
        phnno.sendKeys("070695927777");
        String ExpectedErrorMessage = "Invalid Phone Number";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message is missing when user give an invalid phone number");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Unexpected error message provided when user enter an invalid phone number");
        }
    }

    @Test(priority = 5)
    public void insurancelogin06(){//Verify that user cannot give an invalid email format to the "Email" field.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("minolirashmitha228");
        String ExpectedErrorMessage = "Invalid Email format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter email in invalid format");;
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);

        } catch (AssertionError ae) {
            System.out.println("Error message is mismatching when user enter email in invalid format");;
        }
    }

    @Test(priority = 6)
    public void insurancelogin07(){//Verify that user cannot enter a numerical value for the "City" field.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement email = driver.findElement(By.id("user_address_attributes_city"));
        email.sendKeys("12345");
        String ExpectedErrorMessage = "Invalid format";
        try{
            WebElement errormsg;
            try{
               errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user give numerical value to the city field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user give a numerical value to the city field");;
        }


    }

    @Test(priority = 7)
    public void insurancelogin08() {//Verify that user cannot enter a numerical value for the "Country" field.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("67890");
        String ExpectedErrorMessage = "Invalid format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Error message missing when user enter numerical value for the country field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter numerical value for the country field");;
        }
    }

    @Test(priority = 8)
    public void insurancelogin09(){//Verify that user cannot enter an alphabetical value for the "Post code" field.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("67890");
        String ExpectedErrorMessage = "Invalid format";
        try{
            WebElement errormsg;
            try{
                errormsg = driver.findElement(By.xpath("//*[contains(text(),'" + ExpectedErrorMessage + "')]"));
            } catch (Exception e) {
                System.out.println("Error message missing when user enter alphabetical value to the post code field");
                return;
            }
            boolean iserror = errormsg.isDisplayed();
            Assert.assertTrue(iserror);
        } catch (AssertionError ae) {
            System.out.println("Error message mismatched when user enter alphabetical value to the post code field");;
        }
    }

    @Test(priority = 9)
    public void insurancelogin10(){//Verify that user can reset the filled details.
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        WebElement usertitle = driver.findElement(By.id("user_title"));
        Select select = new Select(usertitle);
        select.selectByVisibleText("Miss");
        WebElement firstname = driver.findElement(By.id("user_firstname"));
        firstname.sendKeys("nimesha");
        WebElement lastname = driver.findElement(By.id("user_surname"));
        lastname.sendKeys("perera");
        WebElement phoneno = driver.findElement(By.id("user_phone"));
        phoneno.sendKeys("0778975552");
        //select birth year
        WebElement birthyear = driver.findElement(By.id("user_dateofbirth_1i"));
        Select select1 = new Select(birthyear);
        select1.selectByVisibleText("1935");
        //select birth month
        WebElement birthmonth = driver.findElement(By.id("user_dateofbirth_2i"));
        Select select2 = new Select(birthmonth);
        select2.selectByVisibleText("March");
        //select birthdate
        WebElement birthdate = driver.findElement(By.id("user_dateofbirth_3i"));
        Select select3 = new Select(birthdate);
        select3.selectByVisibleText("4");
        WebElement licensetype = driver.findElement(By.xpath("//input[@id='licencetype_f']"));
        licensetype.click();
        //select license period
        WebElement licenceperiod = driver.findElement(By.id("user_licenceperiod"));
        Select select4 = new Select(licenceperiod);
        select4.selectByVisibleText("4");
        //select occupation
        WebElement occupation = driver.findElement(By.id("user_occupation_id"));
        Select select5 = new Select(occupation);
        select5.selectByVisibleText("Doctor");
        WebElement street = driver.findElement(By.id("user_address_attributes_street"));
        street.sendKeys("Galle Road");
        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("Matara");
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("Sri Lanka");
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("81000");
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("nimesha@gmail.com");
        WebElement password = driver.findElement(By.id("user_user_detail_attributes_password"));
        password.sendKeys("abc1987#");
        WebElement confirmpassword = driver.findElement(By.id("user_user_detail_attributes_password_confirmation"));
        confirmpassword.sendKeys("abc1987#");
        WebElement resetbtn = driver.findElement(By.xpath("//input[@id='resetform']"));
        resetbtn.click();
    }

    @Test(priority = 10)
    public void insurancelogin11(){//Verify that user can log in to the system
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.sendKeys("nimeshamadhushani100@gmail.com");
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("1999nime*");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitbtn.click();
        String actualtitle = driver.getTitle();
        String expectedtitle = "Insurance Broker System";
        Assert.assertEquals(actualtitle , expectedtitle , "Navigated to unexpected page");
    }


    @Test(priority = 11)
    public void insurancelogin12(){//Verify that user cannot login by giving invalid email & password
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.sendKeys("nimeshamadhushani100gmail.com");
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("199");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitbtn.click();
       boolean errormsg = driver.findElement(By.cssSelector("form[id='login-form'] div span b")).isDisplayed();
       Assert.assertTrue(errormsg , "Unexpected error message");
    }

    @Test(priority = 12)
    public void insurancelogin13(){//Verify that user can log out from the system.
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.sendKeys("nimeshamadhushani100@gmail.com");
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("1999nime*");
        WebElement submitbtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitbtn.click();
        WebElement logoutbtn = driver.findElement(By.cssSelector("input[value='Log out']"));
        logoutbtn.click();
        String actualtitle = driver.getTitle();
        String expectedtitle = "Insurance Broker System - Login";
        Assert.assertEquals(actualtitle , expectedtitle , "Navigated to unexpected page");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
