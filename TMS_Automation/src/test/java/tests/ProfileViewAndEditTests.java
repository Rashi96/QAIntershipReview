package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfileViewAndEditPage;

import java.time.Duration;

public class ProfileViewAndEditTests {
    WebDriver driver;
    ProfileViewAndEditPage p;

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
    public void TC_001(){//Verify that user can navigate to the basic details section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        boolean ActualResult = p.isBasicDetailsBannerAvailable();
        Assert.assertTrue(ActualResult , "Basic Details banner missing");
    }

    @Test(priority = 1)
    public void TC_002(){//Verify that user can navigate to the skills section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToSkills();
        boolean ActualResult = p.isSkillBannerAvailable();
        Assert.assertTrue(ActualResult , "Skills banner missing");
    }

    @Test(priority = 2)
    public void TC_003(){//Verify that user can navigate to the experience details section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToExperience();
        boolean ActualResult = p.isExperienceBannerAvailable();
        Assert.assertTrue(ActualResult , "Experience banner missing");
    }

    @Test(priority = 3)
    public void TC_004(){//Verify that user can navigate to the project details section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToProjects();
        boolean ActualResult = p.isProjectsBannerAvailable();
        Assert.assertTrue(ActualResult , "Project Details banner missing");
    }

    @Test(priority = 4)
    public void TC_005(){//Verify that user can navigate to the education details section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToEducationDetails();
        boolean ActualResult = p.isEducationDetailsBannerAvailable();
        Assert.assertTrue(ActualResult , "Education Details banner missing");
    }

    @Test(priority = 5)
    public void TC_006(){//Verify that user can navigate to the other details section
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToOtherDetails();
        boolean ActualResult = p.isOtherDetailsBannerAvailable();
        Assert.assertTrue(ActualResult , "Other Details banner missing");
    }

    @Test(priority = 6)
    public void TC_007(){//Verify that firstname is mandatory in the basic details page
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillFirstName("");
        boolean ActualResult = p.ErrorMsg();
        Assert.assertTrue(ActualResult , "Error message missing when user keep first name empty");
    }
    @Test(priority = 7)
    public void TC_008() throws InterruptedException {//Verify that user can edit the first name field in basic details page by giving valid text value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillFirstName("ABC");
        Thread.sleep(1000);
        p.clickUpdate();
        boolean ActualResult = p.isSuccessMsgVisible();
        Assert.assertTrue(ActualResult , "Success message missing when user enter text value for first name field");
    }
    @Test(priority = 8)
    public void TC_009(){//Verify that user cannot edit the first name field in basic details page by giving numerical value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillFirstName("123");
        p.clickUpdate();
        boolean ActualResult = p.isSuccessMsgVisible();
        Assert.assertTrue(ActualResult , "Success message missing when user enter text value for first name field");
    }
    @Test(priority = 9)
    public void TC_010(){//Verify that user can edit the last name field in basic details page by giving text value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillLastName("Perera");
        p.clickUpdate();
    }
    @Test(priority = 10)
    public void TC_011(){//Verify that user cannot edit the last name field in basic details page by giving numerical value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillLastName("123");
        p.clickUpdate();
    }
    @Test(priority = 11)
    public void TC_012(){//Verify that user can edit the job title with giving valid text value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillTitle("UI/UX Engineer");
        p.clickUpdate();
    }
    @Test(priority = 12)
    public void TC_013(){//Verify that user cannot edit the job title with giving numerical value
        p = new ProfileViewAndEditPage(driver);
        p.clickEditBtn();
        p.navigateToBasicDetails();
        p.fillTitle("1234");
        p.clickUpdate();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
