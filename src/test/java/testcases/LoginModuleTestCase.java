package testcases;


public class LoginModuleTestCase extends StartUpAndTearDown {
	
	public void openBrowser()
	{
		startUp();
	}
	
	
	public void LoginPageWithValidUserAndPass()
	{
		LoginPageWithUsernameAndPasswordCombination positiveloginpagetestcases = new LoginPageWithUsernameAndPasswordCombination();
		positiveloginpagetestcases.positiveLoginPageTestCases();
	}
	

	public void closeBrowser()
	{
		tearDown();     
	}
}
