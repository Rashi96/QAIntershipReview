package TestCases;

import BaseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import  PageObjects.RetrieveQuotationPage;

public class RetrieveQuotationTest extends BaseClass {
    public LoginPage loginPage;
    public RetrieveQuotationPage retrieveQuotationPage;

    @BeforeMethod
    public void login() {

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        retrieveQuotationPage = new RetrieveQuotationPage(driver);

        // Log in to the application
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test(priority = 0)
    public void testNavigateToRetrieveQuotation() {
        // Verify that the user can navigate to the Retrieve Quotation page
        retrieveQuotationPage.navigateToRetrieveQuotation();
        String isSelected = retrieveQuotationPage.getRetrieveQuotationTabAttribute("aria-selected");
        Assert.assertEquals(isSelected, "true", "Retrieve Quotation tab is not selected");
    }

    @Test(priority = 1)
    public void testRetrieveSavedQuotation() {
        // Verify that the user can retrieve a saved quotation
        retrieveQuotationPage.navigateToRetrieveQuotation();
        retrieveQuotationPage.enterIdentificationNumber("42339");
        retrieveQuotationPage.clickRetrieveButton();
        boolean isDisplayed = retrieveQuotationPage.isQuotationDetailsDisplayed();
        Assert.assertTrue(isDisplayed, "Quotation details are not displayed");
    }

}
