//package tests;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//
//public class ExtentReportManager {
//
//
//    public ExtentSparkReporter sparkReporter;//UI of the report
//    public ExtentReports extent;//Populate common information of the report
//    public ExtentTest test;//crate test case entries in the report and update status of the test methods
//
//    public void onStart(ITestContext context){
//        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/testReport.html");
//
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//
//        extent.setSystemInfo("Computer Name" , "localhost");
//        extent.setSystemInfo("Environment" , "QA");
//        extent.setSystemInfo("Tester Name" , "Nimesha");
//        extent.setSystemInfo("os" , "Windows10");
//        extent.setSystemInfo("Browser Name" , "Chrome");
//    }
//
//    public void onTestSuccess(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.log(Status.PASS , "Test case Passed is : " + result.getName());
//    }
//
//    public void onTestFailure(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.log(Status.FAIL , "Test case Failed cause is : " + result.getName());
//        test.log(Status.FAIL , "Test case Failed cause is : " + result.getThrowable());
//    }
//
//    public void onTestSkipped(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.log(Status.SKIP, "Test case Skipped is : " + result.getName());
//    }
//
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//}
