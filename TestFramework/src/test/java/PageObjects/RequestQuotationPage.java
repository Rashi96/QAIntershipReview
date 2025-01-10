package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestQuotationPage {
    WebDriver driver;

    public RequestQuotationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By requestQuotationLink = By.cssSelector("#newquote");
    private By annualMileageField = By.id("quotation_vehicle_attributes_mileage");
    private By estimatedValueField = By.id("quotation_vehicle_attributes_value");
    private By calculateButton = By.cssSelector("input[value='Calculate Premium']");
    private By resetButton = By.cssSelector("#resetquote");
    private By saveButton = By.cssSelector("input[value='Save Quotation']");
    private By banner = By.xpath("//h2[normalize-space()='Request a quotation']");
    private By errorMessage = By.xpath("//*[contains(text(),'Invalid Format')]");
    private By idLabel = By.xpath("//b[normalize-space()='Please write it down for later retrieve']");

    // Actions
    public void navigateToRequestQuotation() {
        driver.findElement(requestQuotationLink).click();
    }

    public boolean isBannerDisplayed() {
        return driver.findElement(banner).isDisplayed();
    }

    public void enterAnnualMileage(String mileage) {
        driver.findElement(annualMileageField).sendKeys(mileage);
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void calculatePremium() {
        driver.findElement(calculateButton).click();
    }

    public void resetForm() {
        driver.findElement(resetButton).click();
    }

    public void saveQuotation() {
        driver.findElement(saveButton).click();
    }

    public boolean isIdDisplayed() {
        return driver.findElement(idLabel).isDisplayed();
    }

    public void fillQuotationForm(String mileage, String estimatedValue) {
        // Fill in fields
        enterAnnualMileage(mileage);
        driver.findElement(estimatedValueField).sendKeys(estimatedValue);
    }

}
