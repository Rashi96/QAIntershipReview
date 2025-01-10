package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.EditProfilePage;
import PageObjects.LoginPage;
import BaseClass.BaseClass;

public class EditProfilePageTest extends BaseClass {

    @Test(priority = 1)
    public void verifyNavigationToEditProfile() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToEditProfile();
        Assert.assertTrue(editProfilePage.isProfileBannerDisplayed(), "Failed to navigate to Edit Profile page.");
    }

    @Test(priority = 2)
    public void verifyProfileUpdate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToEditProfile();
        editProfilePage.updateProfile("0706959277", "Sri Lanka", "81000");
    }

    @Test(priority = 3)
    public void verifyInvalidPhoneNumber() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToEditProfile();
        editProfilePage.updateProfile("invalidPhone", "", "");
        Assert.assertTrue(editProfilePage.isErrorDisplayed("Invalid Phone Number"), "Error message for invalid phone not displayed.");
    }

    @Test(priority = 4)
    public void verifyNumericalCountryField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToEditProfile();
        editProfilePage.updateProfile("", "12345", "");
        Assert.assertTrue(editProfilePage.isErrorDisplayed("Invalid format"), "Error message for numerical country not displayed.");
    }

    @Test(priority = 5)
    public void verifyAlphabeticalPostCode() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToEditProfile();
        editProfilePage.updateProfile("", "", "abcd");
        Assert.assertTrue(editProfilePage.isErrorDisplayed("Invalid format"), "Error message for alphabetical postcode not displayed.");
    }
}


