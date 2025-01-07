package utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SetAndEndExtentReport extends CapturedScreenshots {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    ITestResult resukt;
    
    
    public void onStart() {
        String reportName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" +reportName);
        

        sparkReporter.config().setDocumentTitle("Login Page Automation Report");
        sparkReporter.config().setReportName("Login Page Valid and Invalid Scenarios");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);

        extentReports.setSystemInfo("Computer Name", "localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("OS", "Windows");
        extentReports.setSystemInfo("Browser Name", "Chrome");
    }

    public void onTestStart(String methodName) {
        extentTest = extentReports.createTest(methodName);
    }

    public void onTestSuccess(String methodName) {
        extentTest.log(Status.PASS, "Test Passed: " + methodName);
    }

    public void onTestFailure(ITestResult resukt)
	{
    	extentTest = extentReports.createTest(resukt.getName());
    	extentTest.log(Status.FAIL, "On Test Failure: "+resukt.getName());
		String imagepath = new CapturedScreenshots().getScreenshot(resukt.getName());
		try
		{
			extentTest.addScreenCaptureFromPath(imagepath);
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}
    
    public void onTestSkipped(String methodName) {
        extentTest.log(Status.SKIP, "Test Skipped: " + methodName);
    }

	public void onFinish(String methodname)
	{
		extentTest = extentReports.createTest(methodname);
		extentReports.flush();
	}
}
