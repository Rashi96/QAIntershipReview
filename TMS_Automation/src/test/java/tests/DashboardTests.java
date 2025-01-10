package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class DashboardTests {
    WebDriver driver;
    DashboardPage DB;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://wireapps-tms-dev.vercel.app/sign-in");
        LoginPage lp = new LoginPage(driver);
        lp.GiveEmail();
        lp.GivePassword();
        lp.ClickContinueBtn();
        driver.get("https://wireapps-tms-dev.vercel.app/admin/dashboard");
    }
    @Test(priority = 0)
    public void selectOneCV(){
         DB = new DashboardPage(driver);
         DB.selectOneCV();
         String ActualValue = DB.isCheckedCV();
         String ExpectedValue = "checked";
         Assert.assertEquals(ActualValue , ExpectedValue , "The CV is unable to check");
    }

    @Test(priority = 1)
    public void deselectOneCV(){
        DB = new DashboardPage(driver);
        DB.selectOneCV();
        DB.selectOneCV();
        String ActualValue = DB.isCheckedCV();
        String ExpectedValue = "unchecked";
        Assert.assertEquals(ActualValue , ExpectedValue , "The CV is unable to deselect");
    }

    @Test(priority = 2)
    public void deselectSetOfCV(){
        DB = new DashboardPage(driver);
        DB.selectSetOfCV();
        DB.selectSetOfCV();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String ActualValue = DB.isCheckedCV();
        String ActualValue1 = DB.isCheckedCV1();
        String ExpectedValue = "unchecked";
        Assert.assertEquals(ActualValue , ExpectedValue , "The Dinusha's CV is unable to deselect");
        Assert.assertEquals(ActualValue1 , ExpectedValue ,"The Shehan's CV is unable to deselect" );
    }

    @Test(priority = 3)
    public void TC_008(){//Verify that user can add one particular resume to the wishlist
        DB = new DashboardPage(driver);
        DB.selectOneCV();
        DB.selectWishlistBtn();
        DB.selectOneWishlist();
        boolean ActualResult = DB.AddToWishListMsgAppear();
        Assert.assertTrue(ActualResult , "Message missing when user add a Resume to the particular wishlist ");
    }
    @Test(priority = 4)
    public void TC_009(){//Verify that user can add resumes to the set of wishlists
        DB = new DashboardPage(driver);
        DB.selectOneCV();
        DB.selectWishlistBtn();
        DB.selectSetOfWishlist();
        boolean ActualResult = DB.AddToWishListMsgAppear();
        Assert.assertTrue(ActualResult , "Message missing when user add Resume to the set of wishlists ");
    }

    @Test(priority = 4)
    public void TC_010(){//Verify that user can redirect to the  edit profile page by click on "edit" option
        DB = new DashboardPage(driver);
        DB.editResume();
        boolean ActualResult = DB.isEditCV();
        Assert.assertTrue(ActualResult , "User cannot edit the resume");
    }

    @Test(priority = 4)
    public void TC_011(){//Verify that user can view the resume by click on "view" option
        DB = new DashboardPage(driver);
        DB.viewResume();
        boolean ActualResult = DB.isViewCV();
        Assert.assertTrue(ActualResult , "User cannot view the resume");
    }

    @Test(priority = 4)
    public void TC_012(){//Verify that user can search for alphabetical value
        DB = new DashboardPage(driver);
        DB.searchWithText();
    }

    @Test(priority = 4)
    public void TC_013(){//Verify that user can search for numerical values
        DB = new DashboardPage(driver);
        DB.searchWithNumber();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
