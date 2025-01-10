package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;

    // Locators
    private By profileOption = By.cssSelector("#profile");

    // Constructor
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void navigateToProfile() {
        driver.findElement(profileOption).click();
    }

    public boolean isProfileOptionSelected() {
        WebElement profileElement = driver.findElement(profileOption);
        String value = profileElement.getAttribute("aria-selected");
        return value.equals("true");
    }
}
