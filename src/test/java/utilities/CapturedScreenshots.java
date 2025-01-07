package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import testcases.StartUpAndTearDown;

public class CapturedScreenshots extends StartUpAndTearDown {
	public static String timeStamp;
	
	static {
       timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }
	
	public String getScreenshot(String methodName) 
	{
        String screenshotPath = (System.getProperty("user.dir")+"\\screenshots")+File.separator+methodName+"-"+timeStamp+".png";

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File trgFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, trgFile);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Failed to capture screenshot: " + e.getMessage(), true);
        }
        return screenshotPath;
    }
}
