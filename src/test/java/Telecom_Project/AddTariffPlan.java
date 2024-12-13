package Telecom_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTariffPlan {

    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");

    }

    @Test
    public void TC_001(){ // Verify that user can navigate to the Add Tariff plan page
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");
    }

}
