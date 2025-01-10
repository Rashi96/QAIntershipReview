package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPlanToCustomerPage {

    WebDriver driver;

    //constructor
    public AddTariffPlanToCustomerPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //Locators
    @FindBy(linkText = "Add Tariff Plan to Customer") WebElement AddTariffPlanOption;
    @FindBy(css = "input[value='submit']") WebElement SubmitBtn;
    @FindBy(xpath = "//input[@name='submit']") WebElement AddPlanBtn;
    @FindBy(xpath = "(//td[@align='center'])[1]") WebElement SelectPlanRadioBtn;

    @FindBy(css = "#customer_id") WebElement CustomerID;
    @FindBy(xpath = "//h2[normalize-space()='Approved Tariff Plans']") WebElement ApprovedTariffPlan;

    @FindBy(css = "div[class='inner'] h4") WebElement InvalidCustomerIDMsg;
    @FindBy(css = "#message2") WebElement CustomerIDMsg;
    @FindBy(xpath = "//h2[normalize-space()='Congratulation Tariff Plan assigned']") WebElement AddPlanMsg;

    //Methods
    public void clickAddTariffPlanOption(){
        AddTariffPlanOption.click();
    }
    public void fillCustomerID(String customerId){
        CustomerID.sendKeys(customerId);
    }
    public void clearCustomerID(){
        CustomerID.clear();
    }
    public void clickSubmitBtn(){
        SubmitBtn.click();
    }
    public boolean isApprovedTariffPlanAppear(){
        return ApprovedTariffPlan.isDisplayed();
    }
    public String getInvalidCustomerIDMsg(){
        return InvalidCustomerIDMsg.getText();
    }
    public String getCustomerIDMsg(){
        return CustomerIDMsg.getText();
    }
    public void clickSelectPlanRadioBtn(){
        SelectPlanRadioBtn.click();
    }
    public void clickAddPlanBtn(){
        AddPlanBtn.click();
    }
    public boolean isAddPlanMsgAppear(){
        return AddPlanMsg.isDisplayed();
    }
}
