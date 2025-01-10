package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import BaseClass.BaseClass;
public class Reporting implements ITestListener {

    public ExtentSparkReporter sparkReporter;//UI of the report
    public ExtentReports extent;//Populate common information of the report
    public ExtentTest test;//crate test case entries in the report and update status of the test methods

    String repName;
    public void onStart(ITestContext context){

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-"+timeStamp+".html";
        sparkReporter = new ExtentSparkReporter( "./reports/"+repName);

        sparkReporter.config().setDocumentTitle("Automation Report of Guru99");
        sparkReporter.config().setReportName("Functional Testing of Telecom Project");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application" , "Guru99");
        extent.setSystemInfo("Computer Name" , "localhost");
        extent.setSystemInfo("Environment" , "QA");
        extent.setSystemInfo("User Name" , System.getProperty("user.name"));
        extent.setSystemInfo("Tester Name" , "Nimesha");
        extent.setSystemInfo("os" , "Windows10");
        extent.setSystemInfo("Browser Name" , "Chrome");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.PASS , "Test case Passed is : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.FAIL , "Test case Failed : " + result.getName());
        test.log(Status.INFO , result.getThrowable().getMessage());

        try{
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }catch (IOException e1){
            e1.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case Skipped is : " + result.getName());
        test.log(Status.INFO,result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"/reports/"+repName;
        File exetentReport = new File(pathOfExtentReport);

        try{
            Desktop.getDesktop().browse(exetentReport.toURI());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
