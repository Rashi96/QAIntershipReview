package TestCases;

import BaseClass.BaseClass;
import PageObjects.PayBillingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayBillingTests extends BaseClass {

    PayBillingPage PB;

    @Test(priority = 0)
    public void payBilling01(){//Verify that user can navigate to the pay billing page
        PB = new PayBillingPage(driver);
        PB.clickPayBillingOption();
        String expectedTitle = "Guru99 Telecom Billing";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to the wrong page");
    }

    @Test(priority = 1)
    public void payBilling02(){//Verify that user can get the billing details after giving valid customer ID
        PB = new PayBillingPage(driver);
        PB.clickPayBillingOption();
        PB.fillCustomerID(customerID);
        PB.clickSubmitBtn();
        boolean isBillingDetails = PB.isBillingDetailsAppear();
        Assert.assertTrue(isBillingDetails, "Error in loading billing details");
    }

    @Test(priority = 2)
    public void payBilling03(){//Verify that user cannot give  ID with invalid characters to "customer ID" field
        PB = new PayBillingPage(driver);
        PB.clickPayBillingOption();
        PB.fillCustomerID("mf171742");
        String errorMsg = PB.getBillingMsg();
        String expectedMsg = "Characters are not allowed";
        Assert.assertEquals(errorMsg , expectedMsg , "Wrong error message");
    }

    @Test(priority = 3)
    public void payBilling04(){//Verify that user cannot give invalid ID to  "customer ID" field
        PB = new PayBillingPage(driver);
        PB.clickPayBillingOption();
        PB.fillCustomerID("171745");
        PB.clickSubmitBtn();
        String actualMsg = PB.getInvalidCustomerIDMsg();
        String expectedMsg = "Please Input Your Correct Customer ID";
        Assert.assertEquals(actualMsg, expectedMsg , "Wrong error message");
    }

    @Test(priority = 4)
    public void payBilling05(){//Verify that user cannot keep "customer ID" field empty
        PB = new PayBillingPage(driver);
        PB.clickPayBillingOption();
        PB.fillCustomerID("171745");
        PB.clearCustomerID();
        String actualMsg = PB.getBillingMsg();
        String expectedMsg = "Number must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg , "Wrong error message");
    }
}
