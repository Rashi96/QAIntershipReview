package TestCases;

import BaseClass.BaseClass;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    @Test(priority = 0)
    public void verifyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Verify Login success
        boolean isProfileOptionVisible = driver.findElement(By.cssSelector("profile")).isDisplayed();
        Assert.assertTrue(isProfileOptionVisible, "Login failed: Profile option is not visible");
    }
}

// Verify Login success
//boolean isProfileOptionVisible = driver.findElement(By.cssSelector("#profile")).isDisplayed();
//Assert.assertTrue(isProfileOptionVisible, "Login failed: Profile option is not visible");