package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	// WebElement
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement enterUsername;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement enterPassword;
	
	@FindBy(xpath="//*[@id=\"submit\"]")
	private WebElement clickOnSubmit;
	
	@FindBy(xpath="//*[@id=\"error\"]")
	private WebElement usernamePasswordValidation;
	
	// Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	
	public void enterUsernameField(String username)
	{
		enterUsername.clear();
		enterUsername.sendKeys(username);
	}
	
	public void enterPasswordField(String password)
	{
		enterPassword.clear();
		enterPassword.sendKeys(password);
	}
	
	public void clickOnSubmitButton()
	{
		clickOnSubmit.click();
	}
	
	public String usernamePasswordValidationStatus()
	{
		return usernamePasswordValidation.getText();
	}
	
}
