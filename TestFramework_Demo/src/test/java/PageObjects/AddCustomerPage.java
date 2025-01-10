package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;

    //constructor
    public AddCustomerPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //Locators
    @FindBy(xpath = "(//a[@href='addcustomer.php'][normalize-space()='Add Customer'])[1]") WebElement AddCustomerBtn;
    @FindBy(css = "label[for='done']") WebElement BackgroundCheckBtn;
    @FindBy(name = "submit") WebElement SubmitBtn;
    @FindBy(css = "input[value='Reset']") WebElement ResetBtn;

    @FindBy(xpath = "//label[@id='message']") WebElement MessagesOfFirstName;
    @FindBy(id = "message50") WebElement MessagesOfLastName;
    @FindBy(id = "message9") WebElement MessagesOfEmail;
    @FindBy(id = "message3") WebElement MessagesOfAddress;
    @FindBy(id = "message7") WebElement MessagesOfTelephoneNo;

    @FindBy(name = "fname") WebElement FirstName;
    @FindBy(name = "lname") WebElement LastName;
    @FindBy(name = "emailid") WebElement Email;
    @FindBy(name = "addr") WebElement Address;
    @FindBy(name = "telephoneno") WebElement TelephoneNo;
    @FindBy(xpath = "//h1[normalize-space()='Access Details to Guru99 Telecom']") WebElement AccessDetails;

    //Methods
    public void clickAddCustomerBtn(){
        AddCustomerBtn.click();
    }
    public void clickBackgroundCheckBtn(){
        BackgroundCheckBtn.click();
    }
    public void clickSubmitBtn(){
        SubmitBtn.click();
    }
    public void clickResetBtn(){
        ResetBtn.click();
    }
    public void fillFirstName(String fname){
        FirstName.sendKeys(fname);
    }
    public void clearFirstName(){
        FirstName.clear();
    }
    public void fillLastName(String lname){
        LastName.sendKeys(lname);
    }
    public void clearLastName(){
        LastName.clear();
    }
    public void fillEmail(String email){
        Email.sendKeys(email);
    }
    public void clearEmail(){
        Email.clear();
    }
    public void fillAddress(String address){
        Address.sendKeys(address);
    }
    public void clearAddress(){
        Address.clear();
    }
    public void fillTelephoneNo(String telephoneno){
        TelephoneNo.sendKeys(telephoneno);
    }
    public void clearTelephoneNo(){
        TelephoneNo.clear();
    }
    public String getAccessDetails(){
        return AccessDetails.getText();
    }
    public String getMessageOfFirstName(){
        return MessagesOfFirstName.getText();
    }
    public String getMessageOfLastName(){
        return MessagesOfLastName.getText();
    }
    public String getMessageOfEmail(){
        return MessagesOfEmail.getText();
    }
    public String getMessageOfAddress(){
        return MessagesOfAddress.getText();
    }
    public String getMessageOfTelephoneNo(){
        return MessagesOfTelephoneNo.getText();
    }
}
