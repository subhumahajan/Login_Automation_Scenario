package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CapturedScreenshots;
import utilities.ReadPropertyFile;

public class StartUpAndTearDown {

	public static WebDriver driver;
    public static CapturedScreenshots capturedscreenshots;

	ReadPropertyFile readpropertyfile = new ReadPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
	
	public void startUp()
	{
		String browser = readpropertyfile.getProperty("Browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			Reporter.log("Invalid Browser Name");
		}
		
		driver.manage().window().maximize();
		driver.get(readpropertyfile.getProperty("Url"));
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
}
