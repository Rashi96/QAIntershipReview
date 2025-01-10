package BaseClass;

import Utilities.ReadConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    static ReadConfig readconfig = new ReadConfig();
    public static String customerID = readconfig.getCustomerID();
    public static String email = readconfig.getEmail();
    public static WebDriver driver;

    @Parameters({"browser","Url"})
    @BeforeMethod
    public void setup(String browser, String Url)
    {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
        else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.get(Url);
//        driver.get(webUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")+"/screenshots/"+tname+"_"+timeStamp;
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}


