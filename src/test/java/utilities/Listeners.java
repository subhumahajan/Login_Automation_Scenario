package utilities;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class Listeners extends CapturedScreenshots implements ITestListener {

    SetAndEndExtentReport setAndEndExtentReport = new SetAndEndExtentReport();

    public void onStart(ITestContext context)
	{
    	setAndEndExtentReport.onStart();
		Reporter.log("- On Test Start",true);
	}
	
	public void onTestStart(ITestResult resukt)
	{
		setAndEndExtentReport.onTestStart(resukt.getName());
		Reporter.log("- On Test Start",true);
	}
	
	public void onTestSuccess(ITestResult resukt)
	{
		setAndEndExtentReport.onTestSuccess(resukt.getName());
		Reporter.log("- On Test Success",true);
	}
	
	public void onTestFailure(ITestResult resukt)
	{
		setAndEndExtentReport.onTestFailure(resukt);
		Reporter.log("- On Test Failure",true);
	}
	
	public void onTestSkipped(ITestResult resukt)
	{
		setAndEndExtentReport.onTestSkipped(resukt.getName());
		Reporter.log("- On Test Skipped",true);
	}
	
	public void onFinish(ITestContext context)
	{
		setAndEndExtentReport.onFinish(context.getName());
		Reporter.log("- On Finish",true);
	}
}
