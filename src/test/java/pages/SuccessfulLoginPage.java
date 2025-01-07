package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulLoginPage {

	WebDriver driver;
	
	// WebElement
	@FindBy(xpath="//*[@id=\"loop-container\"]/div/article/div[1]/h1")
	private WebElement ActualTextAfterSuccessfulLogIn;
	
	@FindBy(xpath="//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong")
	private WebElement ActualCongratulationText;
	
	@FindBy(xpath="//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")
	private WebElement logoutButton;
	
	// Constructor
	public SuccessfulLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public String actualTextAfterSuccessfulLogIn()
	{
		return ActualTextAfterSuccessfulLogIn.getText();
	}
	
	public String actualCongratulationText()
	{
		return ActualCongratulationText.getText();
	}
	
	public boolean logoutButtonDisplayed()
	{
		return logoutButton.isDisplayed();
	}
	
	public void clickToLogoutButton()
	{
		logoutButton.click();
	}
	
}
