package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.PanelUI;

public class DashboardPage {

    WebDriver driver;

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(xpath = "//tbody/tr[6]/td[1]/button[1]")
    WebElement SelectedCV;//Dinushi Gamage's Resume

    @FindBy(xpath = "//tbody/tr[7]/td[1]/button[1]")
    WebElement SelectCV1;//Shehan's Resume

    @FindBy(xpath = "//button[text() = ' Wishlist']")
    WebElement WishlistSelection;

    @FindBy(id="TestNimesha")
    WebElement Wishlist1;

    @FindBy(id = "TestNimesha02")
    WebElement Wishlist2;

    @FindBy(xpath = "//div[text()='Candidates added successfully!']")
    WebElement AddedToWishlistMsg;

    @FindBy(xpath = "(//div[@class='fill-content-tertiary stroke-black h-5 w-5'])[18]")
    WebElement ViewBtn;//Pasindu Rupasinghe's Resume

    @FindBy(xpath = "//p[@class='text-3xl font-bold mb-2 text-white mt-8']")
    WebElement IsViewCV;

    @FindBy(xpath = "(//div[@class='fill-content-tertiary stroke-black h-5 w-5'])[17]")
    WebElement EditBtn;

    @FindBy(xpath = "//h1[@class='text-xl font-bold px-5 mt-4']")
    WebElement IsEditCv;

    @FindBy(xpath = "//input[@placeholder='Search here']")
    WebElement SearchBtn;

    //action methods
    public void selectOneCV(){
        SelectedCV.click();
    }
    public void selectSetOfCV(){
        SelectedCV.click();
        SelectCV1.click();
    }
    public String isCheckedCV(){
        return SelectedCV.getAttribute("data-state");
    }

    public String isCheckedCV1(){
        return SelectCV1.getAttribute("data-state");
    }

    public void selectWishlistBtn(){
        WishlistSelection.click();
    }
    public void selectOneWishlist(){
        Wishlist1.click();
    }
    public void selectSetOfWishlist(){
        Wishlist1.click();
        Wishlist2.click();
    }
    public boolean AddToWishListMsgAppear(){
        return AddedToWishlistMsg.isDisplayed();
    }
    public void viewResume(){
        ViewBtn.click();
    }
    public boolean isViewCV(){
        return IsViewCV.isDisplayed();
    }
    public void editResume(){
        EditBtn.click();
    }
    public boolean isEditCV(){
        return IsEditCv.isDisplayed();
    }
    public void searchWithText(){
        SearchBtn.sendKeys("Engineer");
    }
    public void searchWithNumber(){
        SearchBtn.sendKeys("076");
    }

}
