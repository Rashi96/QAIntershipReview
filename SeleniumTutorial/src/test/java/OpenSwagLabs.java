import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class OpenSwagLabs{
    @Test

    public void swagLabsTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        //driver.quit();

    }
}
