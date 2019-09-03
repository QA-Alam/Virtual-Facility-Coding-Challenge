package virtualfacilityExtentReport;

import com.relevantcodes.extentreports.LogStatus;

import virtualfacility.qa.page.BasePage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

 
public class Retry implements IRetryAnalyzer {
 
    private int count = 0;
    private static int maxTry = 0; //Run the failed test 2 times
 
         @Override
         public boolean retry(ITestResult iTestResult) {
         if (!iTestResult.isSuccess()) {                      //Check if test not succeed
         if (count < maxTry) {                            //Check if max try count is reached
         count++;                                     //Increase the maxTry count by 1
         iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
         extendReportsFailOperations(iTestResult);    //ExtentReports fail operations
         return true;                                 //Tells TestNG to re-run the test
         }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
        }
 
        public void extendReportsFailOperations (ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BasePage) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
        ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        }}
