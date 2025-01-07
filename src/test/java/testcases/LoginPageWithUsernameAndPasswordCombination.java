package testcases;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.SuccessfulLoginPage;
import utilities.ReadPropertyFile;
import utilities.ReadXLSXFile;

public class LoginPageWithUsernameAndPasswordCombination extends StartUpAndTearDown {

	LoginPage loginpage = new LoginPage(driver);
	ReadPropertyFile readpropertyfile = new ReadPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
	ReadXLSXFile readxlsxfile = new ReadXLSXFile();
	SoftAssert softassert = new SoftAssert();
	SuccessfulLoginPage successfulloginpage = new SuccessfulLoginPage(driver);
	
	public void positiveLoginPageTestCases()
	{
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdatafiles\\testdata.xlsx";
		String[][] userCredential = readxlsxfile.readXLSXFile(filepath,"valid");
		for(String[] Credential:userCredential)
		{
			String username = Credential[0];
			String password = Credential[1];
			String type = Credential[2];
			
			loginpage.enterUsernameField(username);
			loginpage.enterPasswordField(password);
			loginpage.clickOnSubmitButton();
			
			if(username.equals("student") & password.equals("Password123") & type.equalsIgnoreCase("Valid"))
			{
				String ActualUrl = driver.getCurrentUrl();
				softassert.assertEquals(readpropertyfile.getProperty("ExpectedUrl"), ActualUrl, "URL SUCCESSFULLY MATCHED");
				Reporter.log("Actual Url: "+ActualUrl, true);
				Reporter.log("URL SUCCESSFULLY MACTHED", true);
				
				softassert.assertEquals(readpropertyfile.getProperty("ExpectedTextAfterSuccessfulLogIn"), successfulloginpage.actualTextAfterSuccessfulLogIn());
				Reporter.log("Login Page Text: "+successfulloginpage.actualTextAfterSuccessfulLogIn(), true);
				Reporter.log("LOGIN PAGE TEXT SUCCESSFULLY MACTHED", true);
				
				softassert.assertEquals(readpropertyfile.getProperty("ExpectedCongratulationText"), successfulloginpage.actualCongratulationText());
				Reporter.log("Congratulation Text:: "+successfulloginpage.actualCongratulationText(), true);
				Reporter.log("CONGRATULATION TEXT SUCCESSFULLY MACTHED", true);
				
				Reporter.log("Logout Button Visible: "+successfulloginpage.logoutButtonDisplayed(), true);
				Reporter.log("Logout Button Is Displayed", true);
				Reporter.log("VALID USERNAME AND PASSWORD", true);
				Reporter.log(" ", true);
				successfulloginpage.clickToLogoutButton();	

			}
			
			else if(username.equals("student") & password.equals("Password1234") & type.equalsIgnoreCase("invalid"))
			{
				softassert.assertEquals(readpropertyfile.getProperty("ExpectedPasswordValidationText"), loginpage.usernamePasswordValidationStatus());
				Reporter.log("Password Validation Is: "+loginpage.usernamePasswordValidationStatus(), true);
				Reporter.log("INVALID PASSWORD VALIDATION SUCCESSFULLY MATCHED", true);
				Reporter.log("VALID USERNAME AND INVALID PASSWORD", true);
				Reporter.log(" ", true);
			
			}
			else if(username.equals("student-1") & password.equals("Password123") & type.equalsIgnoreCase("Invalid"))
			{
				softassert.assertEquals(readpropertyfile.getProperty("ExpectedUsernameValidationText"), loginpage.usernamePasswordValidationStatus());
				Reporter.log("Username Validation Is: "+loginpage.usernamePasswordValidationStatus(), true);
				Reporter.log("INVALID USER VALIDATION SUCCESSFULLY MATCHED", true);
				Reporter.log("INVALID USERNAME AND VALID PASSWORD", true);
				Reporter.log(" ", true);
					
			}
			softassert.assertAll();			
		}
		
		
	}	
}
