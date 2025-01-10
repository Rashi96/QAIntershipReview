package TestCases;

import BaseClass.BaseClass;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseClass {

    @Test(priority = 0)
    public void verifyUserCanNavigateToProfile() {
        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        // Perform actions
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        profilePage.navigateToProfile();

        // Assertion
        Assert.assertTrue(profilePage.isProfileOptionSelected(), "Profile option is not selected");
    }
}
