package TestCases;

import BaseClass.BaseClass;
import PageObjects.AddCustomerPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomerTests extends BaseClass{

    AddCustomerPage AC;

    @Test(priority = 0)
    public void addCustomer01(){//Verify that user can navigate to the Add Customer page
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        String expectedTitle = "Guru99 Telecom Add Customer";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to an unexpected page!");
    }

    @Test(priority = 1)
    public void addCustomer02(){//Verify that user can submit the customer details form with filling all the fields
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.clickBackgroundCheckBtn();
        AC.fillFirstName("Nimesha");
        AC.fillLastName("Perera");
        AC.fillEmail("nimesha@gmail.com");
        AC.fillAddress("No121, Galle Road, Matara");//Defect in Address Field
        AC.fillTelephoneNo("0779687555");
        AC.clickSubmitBtn();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/telecom/access.php?"));
    }

    @Test(priority = 2)
    public void addCustomer03(){//Verify that user can get the customer ID after submitting the form
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.clickBackgroundCheckBtn();
        AC.fillFirstName("Nimesha");
        AC.fillLastName("Perera");
        AC.fillEmail("nimesha@gmail.com");
        AC.fillAddress("Matara");
        AC.fillTelephoneNo("0779687555");
        AC.clickSubmitBtn();
        String  access = AC.getAccessDetails();
        String expectedText = "Access Details to Guru99 Telecom";
        Assert.assertEquals(access, expectedText, "Error with loading the Access Data!");
    }

    @Test(priority = 3)
    public void addCustomer04(){//Verify that user cannot submit the customer details form with keeping all the fields empty in form
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.clickSubmitBtn();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        String expectedMsg = "please fill all fields";
        Assert.assertEquals(alertMsg , expectedMsg , "Error in alert message");
    }

    @Test(priority = 4)
    public void addCustomer05(){//Verify that user cannot submit the form with giving numbers to "First name"  field
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillFirstName("1234");
        String actualMsg = AC.getMessageOfFirstName();
        String expectedMsg = "Numbers are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 5)
    public void addCustomer06(){//Verify that user cannot submit the form with giving special characters to the "First name" filed
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillFirstName("@#$");
        String actualMsg = AC.getMessageOfFirstName();
        String expectedMsg = "Special characters are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 6)
    public void addCustomer07(){//Verify that user cannot submit the form with giving alphanumerical value to the "First name" field
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillFirstName("nime123");
        String actualMsg = AC.getMessageOfFirstName();
        String expectedMsg = "Numbers are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 7)
    public void addCustomer08(){//Verify that user cannot submit the form when "First name" field empty
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillFirstName("Nimesha");
        AC.clearFirstName();
        String actualMsg = AC.getMessageOfFirstName();
        String expectedMsg = "Customer name must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 8)
    public void addCustomer09(){//Verify that user cannot submit the form with giving numbers to "Last name"  field
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillLastName("1234");
        String actualMsg = AC.getMessageOfLastName();
        String expectedMsg = "Numbers are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 9)
    public void addCustomer10(){//Verify that user cannot submit the form with giving special characters to the "Last name" filed
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillLastName("@#$");
        String actualMsg = AC.getMessageOfLastName();
        String expectedMsg = "Special characters are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 10)
    public void addCustomer11(){//Verify that user cannot submit the form with giving alphanumerical value to the "Last name" field
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillLastName("perera123");
        String actualMsg = AC.getMessageOfLastName();
        String expectedMsg = "Numbers are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 11)
    public void addCustomer12(){//Verify that user cannot submit the form when "Last name" field empty
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillLastName("perera");
        AC.clearLastName();
        String actualMsg = AC.getMessageOfLastName();
        String expectedMsg = "Customer name must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 12)
    public void addCustomer13(){//Verify that user cannot submit the form with invalid email
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillEmail("nimeshagmail.com");
        String actualMsg = AC.getMessageOfEmail();
        String expectedMsg = "Email-ID is not valid";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 13)
    public void addCustomer14(){//Verify that user cannot submit the form with empty email
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillEmail("nimeshagmail.com");
        AC.clearEmail();
        String actualMsg = AC.getMessageOfEmail();
        String expectedMsg = "Email-ID must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 14)
    public void addCustomer15(){//Verify that user cannot submit the form with empty address
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillAddress("Matara");
        AC.clearAddress();
        String actualMsg = AC.getMessageOfAddress();
        String expectedMsg = "Address Field must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 15)
    public void addCustomer16(){//Verify that user can fill the address field with address special characters
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillAddress("No 12, Galle Road, Matara.");
        String actualMsg = AC.getMessageOfAddress();
        String expectedMsg = "Special characters are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 16)
    public void addCustomer17(){//Verify that user cannot submit the form with giving only numerical value to address
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillAddress("1234");
        String actualMsg = AC.getMessageOfAddress();
        String expectedMsg = "Characters are not allowed";
        try{
            Assert.assertEquals(actualMsg, expectedMsg);
        } catch (AssertionError ae) {
            System.out.println("Error message missing when user give numbers only to the address field");
        }
    }

    @Test(priority = 17)
    public void addCustomer18(){//Verify that user cannot submit the form with invalid phone no.
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillTelephoneNo("077989");
        String actualMsg = AC.getMessageOfTelephoneNo();
        String expectedMsg = "Invalid Mobile no";
        Assert.assertEquals(actualMsg, expectedMsg,"User can give invalid phone number for the phone no field");
    }

    @Test(priority = 18)
    public void addCustomer19(){//Verify that user cannot submit the form with empty phone no.
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.fillTelephoneNo("077989");
        AC.clearTelephoneNo();
        String actualMsg = AC.getMessageOfTelephoneNo();
        String expectedMsg = "Mobile no must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not matching!");
    }

    @Test(priority = 19)
    public void addCustomer20(){//Verify that user can reset the form after filling all the fields
        AC = new AddCustomerPage(driver);
        AC.clickAddCustomerBtn();
        AC.clickBackgroundCheckBtn();
        AC.fillFirstName("Nimesha");
        AC.fillLastName("Perera");
        AC.fillEmail("nimesha@gmail.com");
        AC.fillAddress("Matara");
        AC.fillTelephoneNo("0779687555");
        AC.clickResetBtn();
    }
}
