package TestCases;

import BaseClass.BaseClass;
import PageObjects.BankHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankHomeTests extends BaseClass {

    BankHomePage BHP;

    @Test(priority = 0)
    public void bankHome01(){
        BHP = new BankHomePage(driver);
        BHP.setEmail(email);
        BHP.clickSubmitBtn();
        String expectedText = "Access details to demo site.123";
        String actualTest = BHP.textOfSuccessMsg();
        Assert.assertEquals(actualTest , expectedText ,"Unable to load the access details page");
    }
    @Test(priority = 1)
    public void bankHome02(){//Verify that user cannot log in to the system with invalid email
        BHP = new BankHomePage(driver);
        BHP.setEmail("123");
        BHP.clickSubmitBtn();
        String expectedText = BHP.textOfErrorMsg();
        String actualTest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(actualTest , expectedText ,"Error message missing when user enter an invalid email");
    }
    @Test(priority = 2)
    public void bankHome03(){//Verify that user cannot log in to the system with empty email
        BHP = new BankHomePage(driver);
        BHP.setEmail("");
        BHP.clickSubmitBtn();
        String expectedText = "Email ID must not be blank";
        String actualTest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(actualTest , expectedText ,"Error message missing when email field is empty");
    }
    @Test(priority = 3)
    public void bankHome04(){//Verify that user can navigate to the telecom project page
        BHP = new BankHomePage(driver);
        BHP.navigateToTelecomProject();
        String expectedTitle = "Guru99 Telecom";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle , "Redirected to wrong page");
    }
}
