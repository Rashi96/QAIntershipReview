package TestCases;

import BaseClass.BaseClass;
import PageObjects.LoginPage;
import PageObjects.RequestQuotationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RequestQuotationTest extends BaseClass {

    LoginPage loginPage;
    RequestQuotationPage requestQuotationPage;

    @BeforeMethod
    public void login() {
        loginPage = new LoginPage(driver);
        requestQuotationPage = new RequestQuotationPage(driver);

        // Perform login
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test(priority = 0)
    public void verifyNavigationToRequestQuotation() {
        requestQuotationPage.navigateToRequestQuotation();
        Assert.assertTrue(requestQuotationPage.isBannerDisplayed(), "Unexpected page navigation");
    }

    @Test(priority = 1)
    public void verifyInvalidAnnualMileage() {
        requestQuotationPage.navigateToRequestQuotation();
        requestQuotationPage.enterAnnualMileage("CD");
        Assert.assertTrue(requestQuotationPage.isErrorMessageDisplayed(), "Invalid Annual Mileage");
    }

    @Test(priority = 2)
    public void verifyCalculatePremium() {
        requestQuotationPage.navigateToRequestQuotation();
        requestQuotationPage.fillQuotationForm("120", "600");
        requestQuotationPage.calculatePremium();
        Assert.assertTrue(requestQuotationPage.isIdDisplayed(), "Calculation details not displayed");
    }

    @Test(priority = 3)
    public void verifyFormReset() {
        requestQuotationPage.navigateToRequestQuotation();
        requestQuotationPage.fillQuotationForm("120", "600");
        requestQuotationPage.resetForm();
    }

    @Test(priority = 4)
    public void verifySaveQuotation() {
        requestQuotationPage.navigateToRequestQuotation();
        requestQuotationPage.fillQuotationForm("120", "600");
        requestQuotationPage.saveQuotation();
        Assert.assertTrue(requestQuotationPage.isIdDisplayed(), "Quotation ID not displayed after saving");
    }
}
