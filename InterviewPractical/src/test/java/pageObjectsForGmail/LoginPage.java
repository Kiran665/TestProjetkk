package pageObjectsForGmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//input[@id='identifierId']")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	@CacheLookup
	public WebElement btnnext;
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(xpath="//div[@id='passwordNext']")
	@CacheLookup
	public WebElement pwdNext ;
	
	@FindBy(xpath="//img[@class='gb_Da gbii']")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[@id='gb_71']")
	@CacheLookup
	WebElement lnkLogout1;//span[contains(text(),'Wrong password. Try again or click Forgot password')]
	
	
	@FindBy(xpath="//span[contains(text(),'Wrong password. Try again or click Forgot password')]")
	@CacheLookup
	WebElement errorMessage;
	
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void clickNext()
	{
		btnnext.click();
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void clickPasswordNext()
	{
		pwdNext.click();
	}	
	
	public void clickLogout()
	{
		lnkLogout.click();
		lnkLogout1.click();
	}
	public void getErrorMessage()
	{
		System.out.println(errorMessage.getText());
	}
	
	
	

}
