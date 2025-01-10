package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillingPage {
    WebDriver driver;

    //constructor
    public PayBillingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //Locators
    @FindBy(partialLinkText = "Pay Billing") WebElement PayBillingOption;
    @FindBy(css = "input[value='submit']") WebElement SubmitBtn;

    @FindBy(xpath = "//input[@id='customer_id']") WebElement CustomerID;

    @FindBy(xpath = "//h1[normalize-space()='Pay Billing']") WebElement BillingDetails;
    @FindBy(css = "#message2") WebElement PayBillingMsg;
    @FindBy(css = "div[class='inner'] h4") WebElement InvalidCustomerIDMsg;

    //Methods
    public void clickPayBillingOption(){
        PayBillingOption.click();
    }
    public void fillCustomerID(String customerID){
        CustomerID.sendKeys(customerID);
    }
    public void clearCustomerID(){
        CustomerID.clear();
    }
    public void clickSubmitBtn(){
        SubmitBtn.click();
    }
    public boolean isBillingDetailsAppear(){
        return BillingDetails.isDisplayed();
    }
    public String getBillingMsg(){
        return PayBillingMsg.getText();
    }
    public String getInvalidCustomerIDMsg(){
        return InvalidCustomerIDMsg.getText();
    }
}
