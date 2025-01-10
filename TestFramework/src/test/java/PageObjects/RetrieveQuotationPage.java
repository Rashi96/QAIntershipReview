package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetrieveQuotationPage {
    private WebDriver driver;

    // Locators
    private By retrieveQuotationTab = By.cssSelector("#retrieve");
    private By idField = By.xpath("//input[@placeholder='identification number']");
    private By retrieveButton = By.id("getquote");
    private By quotationDetails = By.xpath("//font[normalize-space()='Retrieve Quotation']");

    // Constructor
    public RetrieveQuotationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void navigateToRetrieveQuotation() {
        driver.findElement(retrieveQuotationTab).click();
    }

    public void enterIdentificationNumber(String id) {
        driver.findElement(idField).sendKeys(id);
    }

    public void clickRetrieveButton() {
        driver.findElement(retrieveButton).click();
    }

    public boolean isQuotationDetailsDisplayed() {
        WebElement details = driver.findElement(quotationDetails);
        return details.isDisplayed();
    }

    public String getRetrieveQuotationTabAttribute(String attribute) {
        return driver.findElement(retrieveQuotationTab).getAttribute(attribute);
    }
}
