package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    //constructor
        public LoginPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver , this);
        }

    //locators
        @FindBy(xpath = "//input[@id='identifier-field']")WebElement email;
        @FindBy(xpath = "//input[@id='password-field']")WebElement password;
        @FindBy(xpath = "//button[normalize-space()='Continue']")WebElement continueBtn;

    //action methods
    public void GiveEmail(){
        email.sendKeys("tt7470309@gmail.com");
    }

    public void GivePassword(){
        password.sendKeys("123nime*");
    }

    public void ClickContinueBtn(){
        continueBtn.click();
    }
}
