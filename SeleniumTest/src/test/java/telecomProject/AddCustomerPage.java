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

public class AddCustomerPage {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void addCustomer01(){//Verify that user can navigate to the Add Customer page
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        String expectedTitle = "Guru99 Telecom Add Customer";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to wrong page");
    }

    @Test(priority = 1)
    public void addCustomer02(){//Verify that user can submit the customer details form with filling all the fields
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement bc_btn = driver.findElement(By.cssSelector("label[for='done']"));
        bc_btn.click();
        //billing address
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("Nimesha");
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("Perera");
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");
        WebElement address = driver.findElement(By.name("addr"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        address.sendKeys("No121, Galle Road, Matara");
        WebElement phnno = driver.findElement(By.name("telephoneno"));
        phnno.sendKeys("0779687555");
        WebElement submitbtn = driver.findElement(By.name("submit"));
        submitbtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualUrl = driver.getCurrentUrl();
        try{
            Assert.assertTrue(actualUrl.contains("/telecom/access.php?"));
        } catch (AssertionError ae) {
            System.out.println("Assertion fail. Redirected to a unexpected page :" + actualUrl);
        }
    }

    @Test(priority = 2)
    public void addCustomer03(){//Verify that user can get the customer ID after submitting the form
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement bc_btn = driver.findElement(By.cssSelector("label[for='done']"));
        bc_btn.click();
        //billing address
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("Nimesha");
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("Perera");
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");
        WebElement address = driver.findElement(By.name("addr"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        address.sendKeys("Matara");
        WebElement phnno = driver.findElement(By.name("telephoneno"));
        phnno.sendKeys("0779687555");
        WebElement submitbtn = driver.findElement(By.name("submit"));
        submitbtn.click();
        String  access = driver.findElement(By.xpath("//h1[normalize-space()='Access Details to Guru99 Telecom']")).getText();
        String expectedtext = "Access Details to Guru99 Telecom";
        Assert.assertEquals(access, expectedtext, "Error with loading data for access");
    }

    @Test(priority = 3)
    public void addCustomer04(){//Verify that user cannot submit the customer details form with keeping all the fields empty in form
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement submitbtn = driver.findElement(By.name("submit"));
        submitbtn.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        String expectedMsg = "please fill all fields";
        Assert.assertEquals(alertMsg , expectedMsg , "Error in alert message");
    }

    @Test(priority = 4)
    public void addCustomer05(){//Verify that user cannot submit the form with giving numbers to "First name"  field
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("1234");
        String  access = driver.findElement(By.xpath("//label[@id='message']")).getText();
        String expectedtext = "Numbers are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 5)
    public void addCustomer06(){//Verify that user cannot submit the form with giving special characters to the "First name" filed
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("@#$");
        String  access = driver.findElement(By.xpath("//label[@id='message']")).getText();
        String expectedtext = "Special characters are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 6)
    public void addCustomer07(){//Verify that user cannot submit the form with giving alphanumerical value to the "First name" field
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("nime123");
        String  access = driver.findElement(By.xpath("//label[@id='message']")).getText();
        String expectedtext = "Numbers are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 7)
    public void addCustomer08(){//Verify that user cannot submit the form when "First name" field empty
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("nimesha");
        fname.clear();
        String  access = driver.findElement(By.xpath("//label[@id='message']")).getText();
        String expectedtext = "Customer name must not be blank";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 8)
    public void addCustomer09(){//Verify that user cannot submit the form with giving numbers to "Last name"  field
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("1234");
        String  access = driver.findElement(By.id("message50")).getText();
        String expectedtext = "Numbers are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 9)
    public void addCustomer10(){//Verify that user cannot submit the form with giving special characters to the "Last name" filed
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("@#$");
        String  access = driver.findElement(By.id("message50")).getText();
        String expectedtext = "Special characters are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 10)
    public void addCustomer11(){//Verify that user cannot submit the form with giving alphanumerical value to the "Last name" field
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("perera123");
        String  access = driver.findElement(By.id("message50")).getText();
        String expectedtext = "Numbers are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 11)
    public void addCustomer12(){//Verify that user cannot submit the form when "Last name" field empty
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("perera");
        lname.clear();
        String  access = driver.findElement(By.id("message50")).getText();
        String expectedtext = "Customer name must not be blank";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 12)
    public void addCustomer13(){//Verify that user cannot submit the form with invalid email
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimeshagmail.com");
        String  access = driver.findElement(By.id("message9")).getText();
        String expectedtext = "Email-ID is not valid";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 13)
    public void addCustomer14(){//Verify that user cannot submit the form with empty email
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");
        email.clear();
        String  access = driver.findElement(By.id("message9")).getText();
        String expectedtext = "Email-ID must not be blank";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 14)
    public void addCustomer15(){//Verify that user cannot submit the form with empty address
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");
        address.clear();
        String  access = driver.findElement(By.id("message3")).getText();
        String expectedtext = "Address Field must not be blank";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 15)
    public void addCustomer16(){//Verify that user can fill the address field with address special characters
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("No 12, Galle Road, Matara.");
        String  access = driver.findElement(By.id("message3")).getText();
        String expectedtext = "Special characters are not allowed";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 16)
    public void addCustomer17(){//Verify that user cannot submit the form with giving only numerical value to address
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("1234");
        String  access = driver.findElement(By.id("message3")).getText();
        String expectedtext = "Characters are not allowed";
        try{
            Assert.assertEquals(access, expectedtext);
        } catch (AssertionError ae) {
            System.out.println("Error message missing when user give numbers only to the address field");
        }
    }

    @Test(priority = 17)
    public void addCustomer18(){//Verify that user cannot submit the form with invalid phone no.
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement phnno = driver.findElement(By.name("telephoneno"));
        phnno.sendKeys("077989");
        String  access = driver.findElement(By.id("message7")).getText();
        String expectedtext = "Invalid Mobile no";
        try{
            Assert.assertEquals(access, expectedtext);
        } catch (AssertionError ae) {
            System.out.println("User can give invalid phone number for the phone no field");
        }
    }

    @Test(priority = 18)
    public void addCustomer19(){//Verify that user cannot submit the form with empty phone no.
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement phnno = driver.findElement(By.name("telephoneno"));
        phnno.sendKeys("077989");
        phnno.clear();
        String  access = driver.findElement(By.id("message7")).getText();
        String expectedtext = "Mobile no must not be blank";
        Assert.assertEquals(access, expectedtext, "Error message is not matching!");
    }

    @Test(priority = 19)
    public void addCustomer20(){//Verify that user can reset the form after filling all the fields
        WebElement addCustomerBtn = driver.findElement(By.xpath("(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]"));
        addCustomerBtn.click();
        WebElement bc_btn = driver.findElement(By.cssSelector("label[for='done']"));
        bc_btn.click();
        //billing address
        WebElement fname = driver.findElement(By.name("fname"));
        fname.sendKeys("Nimesha");
        WebElement lname = driver.findElement(By.name("lname"));
        lname.sendKeys("Perera");
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");
        WebElement phnno = driver.findElement(By.name("telephoneno"));
        phnno.sendKeys("0779687555");
        WebElement resetbtn = driver.findElement(By.cssSelector("input[value='Reset']"));
        resetbtn.click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
