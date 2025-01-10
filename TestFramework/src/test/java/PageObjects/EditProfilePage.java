package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage {
    WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

     By editProfileOption = By.cssSelector("#editprofile");
     By profileBanner = By.xpath("//h1[normalize-space()='Editing user profile']");
     By phoneField = By.id("user_phone");
     By countryField = By.id("user_address_attributes_county");
     By postCodeField = By.id("user_address_attributes_postcode");
     By updateButton = By.cssSelector("input[value='Update User']");

    public void navigateToEditProfile() {
        driver.findElement(editProfileOption).click();
    }

    public boolean isProfileBannerDisplayed() {
        return driver.findElement(profileBanner).isDisplayed();
    }

    public void updateProfile(String phone, String country, String postCode) {
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(postCodeField).sendKeys(postCode);
        driver.findElement(updateButton).click();
    }

    public boolean isErrorDisplayed(String expectedMessage) {
        try {
            WebElement error = driver.findElement(By.xpath("//*[contains(text(),'" + expectedMessage + "')]"));
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//public class EditProfilePage {
//    private WebDriver driver;
//
//    // Locators
//    private By editProfileOption = By.cssSelector("#editprofile");
//    private By editProfileBanner = By.xpath("//h1[normalize-space()='Editing user profile']");
//    private By title = By.id("user_title");
//    private By surname = By.id("user_surname");
//    private By firstName = By.id("user_firstname");
//    private By phone = By.id("user_phone");
//    private By birthYear = By.id("user_dateofbirth_1i");
//    private By birthMonth = By.id("user_dateofbirth_2i");
//    private By birthDate = By.id("user_dateofbirth_3i");
//    private By licenseType = By.id("user_licencetype_t");
//    private By licensePeriod = By.id("user_licenceperiod");
//    private By occupation = By.id("user_occupation_id");
//    private By street = By.id("user_address_attributes_street");
//    private By city = By.id("user_address_attributes_city");
//    private By country = By.id("user_address_attributes_county");
//    private By postcode = By.id("user_address_attributes_postcode");
//    private By updateButton = By.cssSelector("input[value='Update User']");
//
//    // Constructor
//    public EditProfilePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    // Actions
//    public void navigateToEditProfile() {
//        driver.findElement(editProfileOption).click();
//    }
//
//    public boolean isEditProfileBannerDisplayed() {
//        return driver.findElement(editProfileBanner).isDisplayed();
//    }
//
//    public void updateProfile(String titleText, String surnameText, String firstNameText, String phoneText,
//                              String year, String month, String day, String streetText, String cityText,
//                              String countryText, String postcodeText, String occupationText, String licensePeriodText) {
//
//        new Select(driver.findElement(title)).selectByVisibleText(titleText);
//        driver.findElement(surname).sendKeys(surnameText);
//        driver.findElement(firstName).sendKeys(firstNameText);
//        driver.findElement(phone).sendKeys(phoneText);
//
//        new Select(driver.findElement(birthYear)).selectByVisibleText(year);
//        new Select(driver.findElement(birthMonth)).selectByVisibleText(month);
//        new Select(driver.findElement(birthDate)).selectByVisibleText(day);
//        driver.findElement(licenseType).click();
//
//        new Select(driver.findElement(licensePeriod)).selectByVisibleText(licensePeriodText);
//        new Select(driver.findElement(occupation)).selectByVisibleText(occupationText);
//        driver.findElement(street).sendKeys(streetText);
//        driver.findElement(city).sendKeys(cityText);
//        driver.findElement(country).sendKeys(countryText);
//        driver.findElement(postcode).sendKeys(postcodeText);
//        driver.findElement(updateButton).click();
//    }
//
//    public boolean isErrorDisplayed(String errorMessage) {
//        try {
//            WebElement error = driver.findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]"));
//            return error.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}

