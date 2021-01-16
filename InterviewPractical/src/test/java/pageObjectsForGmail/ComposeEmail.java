package pageObjectsForGmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmail {
WebDriver ldriver;
	
	public ComposeEmail(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//div[@class='z0']/div")
	@CacheLookup
	WebElement composeButton;
	
	@FindBy(xpath="//td//img[2]")
	@CacheLookup
	WebElement composeMaximize;
	
	@FindBy(className="vO")
	@CacheLookup
	WebElement recipints;
	
	
	@FindBy(className="aoT")
	@CacheLookup
	WebElement subject;
	
	@FindBy(className="Am")
	@CacheLookup
	WebElement message;
	
	@FindBy(xpath="//div[text()='Send']")
	@CacheLookup
	WebElement sendButton;
	
	@FindBy(linkText="Sent")
	@CacheLookup
	WebElement sentLink;
	
	
	
	public void composeEmailButton()
	{
		composeButton.click();;
	}
	
	public void composeMax()
	{
		composeMaximize.click();
	}
	
	
	public void enterRecipient(String recipient)
	{
		recipints.sendKeys(recipient);
	}	
	
	public void enterSubject()
	{
		subject.sendKeys("Test");
	}
	public void enterMessage()
	{
		message.sendKeys("Hi" + '\n' +"This email sent while automating compose feature in gmail");
	}
	public void clickSend()
	{
		sendButton.click();   
	}
	public void clinkSentLink()
	{
		sentLink.click();   
	}
	
		
	

}
