package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testcases.LoginModuleTestCase;

public class LoginPageAutomation extends LoginModuleTestCase{

	
	@BeforeClass
	public void open_browser()
	{
		openBrowser();
	}
	
	@Test(priority=1, retryAnalyzer=utilities.RetryMechanism.class)
	public void login_page_with_valid_user_and_pass()
	{
		LoginPageWithValidUserAndPass();
	}
	
	@AfterClass
	public void close_browser()
	{
		closeBrowser();
	}
	
	
}
