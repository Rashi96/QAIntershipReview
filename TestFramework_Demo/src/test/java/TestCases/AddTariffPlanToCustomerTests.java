package TestCases;

import BaseClass.BaseClass;
import PageObjects.AddTariffPlanToCustomerPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTariffPlanToCustomerTests extends BaseClass {

    AddTariffPlanToCustomerPage ATP;

    @Test(priority = 0)
    public void addTariffPlanToCustomer01(){//Verify that user can navigate to the Add tariff plan to customer page
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        String expectedTitle = "Guru99 Add Tariff Plan to Customer";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle ,"Redirected to wrong page!");
    }

    @Test(priority = 1)
    public void addTariffPlanToCustomer02(){//Verify that user can get the tariff plans after giving valid customer ID
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID(customerID);
        ATP.clickSubmitBtn();
        boolean isTariffPlans = ATP.isApprovedTariffPlanAppear();
        Assert.assertTrue(isTariffPlans,"Error in loading tariff plans");
    }

    @Test(priority = 2)
    public void addTariffPlanToCustomer03(){//Verify that user cannot give invalid ID to "customer ID" field
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID("616945");
        ATP.clickSubmitBtn();
        String actualMsg = ATP.getInvalidCustomerIDMsg();
        String expectedMsg = "Please Input Your Correct Customer ID";
        Assert.assertEquals(actualMsg , expectedMsg , "Missing Error Message when User enter an invalid Customer Id");
    }

    @Test(priority = 3)
    public void addTariffPlanToCustomer04(){//Verify that user cannot keep "customer ID" field empty
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID("616945");
        ATP.clearCustomerID();
        String actualMsg = ATP.getCustomerIDMsg();
        String expectedMsg = "Number must not be blank";
        Assert.assertEquals(actualMsg, expectedMsg , "Wrong error message in field!");
        ATP.clickSubmitBtn();
        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        String expectedAlertMsg = "Please Correct Value Input";
        Assert.assertEquals(actualAlertMsg , expectedAlertMsg, "Wrong error message in alert!");
    }

    @Test(priority = 4)
    public void addTariffPlanToCustomer05(){//Verify that user cannot enter invalid characters to "customer ID" field
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID("mngr602891");
        String actualMsg = ATP.getCustomerIDMsg();
        String expectedMsg = "Characters are not allowed";
        Assert.assertEquals(actualMsg, expectedMsg , "Wrong error message in field!");
        ATP.clickSubmitBtn();
        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        String expectedAlertMsg = "Please Correct Value Input";
        Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "Wrong error message in alert!");
    }

    @Test(priority = 5)
    public void addTariffPlanToCustomer06(){//Verify that user can add tariff plan after selecting an approved plan
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID(customerID);
        ATP.clickSubmitBtn();
        ATP.clickSelectPlanRadioBtn();
        ATP.clickAddPlanBtn();
        boolean isAddPlanMsg = ATP.isAddPlanMsgAppear();
        Assert.assertTrue(isAddPlanMsg,"Error in success message");
    }

    @Test(priority = 6)
    public void addTariffPlanToCustomer07(){//Verify that user cannot add tariff plan before selecting an approved plan
        ATP = new AddTariffPlanToCustomerPage(driver);
        ATP.clickAddTariffPlanOption();
        ATP.fillCustomerID(customerID);
        ATP.clickSubmitBtn();
        ATP.clickAddPlanBtn();
        boolean isAddPlanMsg = ATP.isAddPlanMsgAppear();
        Assert.assertFalse(isAddPlanMsg,"User can add tariff plan without selecting a tariff plan");
    }
}
