package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankHomePage {
    WebDriver driver;

    //constructor
    public BankHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //Locators
    @FindBy(xpath = "//input[@name='emailid']") WebElement Email;
    @FindBy(xpath = "//input[@name='btnLogin']") WebElement SubmitBtn;
    @FindBy(xpath = "//h2[normalize-space()='Access details to demo site.']") WebElement SuccessMsg;
    @FindBy(css = "#message9") WebElement ErrorMsg;
    @FindBy(xpath = "//a[normalize-space()='Telecom Project']") WebElement TelecomProjectOption;

    //Methods
    public void setEmail(String email){
        Email.sendKeys(email);
    }
    public void clickSubmitBtn(){
        SubmitBtn.click();
    }
    public String textOfSuccessMsg(){
        return SuccessMsg.getText();
    }
    public String textOfErrorMsg(){
        return ErrorMsg.getText();
    }
    public void navigateToTelecomProject(){
        TelecomProjectOption.click();
    }
}
