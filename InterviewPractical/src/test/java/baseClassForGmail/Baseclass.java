package baseClassForGmail;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjectsForGmail.ComposeEmail;
import pageObjectsForGmail.LoginPage;

public class Baseclass {
	public WebDriver driver;
	public LoginPage lp;
	public ComposeEmail ce;
	public static Logger logger;

}
