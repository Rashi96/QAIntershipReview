package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileViewAndEditPage {
    WebDriver driver;

    //constructor
    public ProfileViewAndEditPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(xpath = "//tbody/tr[7]/td[7]/div[1]/div[1]/button[1]/button[1]/div[1]")WebElement EditBtn;

    @FindBy(xpath = "//button[text()='Basic Details']") WebElement BasicDetails;
    @FindBy(xpath = "//button[text()='Skills']") WebElement Skills;
    @FindBy(xpath = "//button[text()='Experience']") WebElement Experience;
    @FindBy(xpath = "//button[text()='Projects']") WebElement Projects;
    @FindBy(xpath = "//button[text()='Education Details']") WebElement Education;
    @FindBy(xpath = "//button[text()='Other Details']") WebElement OtherDetails;

    @FindBy(xpath = "//h1[text()='Basic Details']") WebElement BasicDetailsBanner;
    @FindBy(xpath = "//h1[text()='Skills']") WebElement SkillsBanner;
    @FindBy(xpath = "//h1[text()='Experience']") WebElement ExperienceBanner;
    @FindBy(xpath = "//h1[text()='Projects']") WebElement ProjectsBanner;
    @FindBy(xpath = "//h1[text()='Education Details']") WebElement EducationDetailsBanner;
    @FindBy(xpath = "//h1[text()='Other Details']") WebElement OtherDetailsBanner;

    @FindBy(id = "firstName")WebElement FirstName;
    @FindBy(xpath = "//span[text()='First name is required']")WebElement errormsg;
    @FindBy(xpath = "//button[text()='Update']")WebElement UpdateBtn;
    @FindBy(xpath = "//div[text()='Basic details has been added successfully']")WebElement SuccessMsg;
    @FindBy(id = "lastName")WebElement LastName;
//    @FindBy(id = "email")WebElement Email;
    @FindBy(id = "primaryPosition")WebElement Position;

    //action method
    public void clickEditBtn(){
        EditBtn.click();
    }
    public void navigateToBasicDetails(){
        BasicDetails.click();
    }
    public boolean isBasicDetailsBannerAvailable(){
        return BasicDetailsBanner.isDisplayed();
    }

    public void navigateToSkills(){
        Skills.click();
    }
    public boolean isSkillBannerAvailable(){
        return SkillsBanner.isDisplayed();
    }

    public void navigateToExperience(){
        Experience.click();
    }
    public boolean isExperienceBannerAvailable(){
        return ExperienceBanner.isDisplayed();
    }

    public void navigateToProjects(){
        Projects.click();
    }
    public boolean isProjectsBannerAvailable(){
        return ProjectsBanner.isDisplayed();
    }

    public void navigateToEducationDetails(){
        Education.click();
    }
    public boolean isEducationDetailsBannerAvailable(){
        return EducationDetailsBanner.isDisplayed();
    }

    public void navigateToOtherDetails(){
        OtherDetails.click();
    }
    public boolean isOtherDetailsBannerAvailable(){
        return OtherDetailsBanner.isDisplayed();
    }
    public void fillFirstName(String value){
        FirstName.sendKeys(value);
    }
    public void fillLastName(String value){
        LastName.sendKeys(value);
    }
    public void fillTitle(String value){
        Position.sendKeys(value);
    }
    public void clickUpdate(){
        UpdateBtn.click();
    }
    public boolean isSuccessMsgVisible(){
        return SuccessMsg.isDisplayed();
    }
    public boolean ErrorMsg(){
        return errormsg.isDisplayed();
    }

}
