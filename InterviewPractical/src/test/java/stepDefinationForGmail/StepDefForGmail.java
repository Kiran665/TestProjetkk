package stepDefinationForGmail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassForGmail.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectsForGmail.ComposeEmail;
import pageObjectsForGmail.LoginPage;
import utilitiesForGmail.UtilitiesGmail;

public class StepDefForGmail extends Baseclass {
	
	
	@Given("Launch Chrome browser and navigate to Gmail login URL")
	public void launch_chrome_browser_and_navigate_to_gmail_login_url() {
		logger=Logger.getLogger("InterviewPractical");//Added logger to project
		PropertyConfigurator.configure("log4j.properties");	//Specifying name of properties
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("**************Launching Browser***************");
		lp=new LoginPage(driver);
		driver.get("https://www.gmail.com"); 
		logger.info("**************Opening URL***************");
	}

	@When("User enters valid email as {string}")
	public void user_enters_valid_email_as(String username) {
		 lp.setUserName(username);	
		 logger.info("**************Providing Email id***************");
	    
	}

	@When("User click on Next")
	public void user_click_on_next() throws InterruptedException {
		Thread.sleep(5000);
		lp.clickNext();
		logger.info("*************clicking on Next after Entering Email id****************");
	}

	@Then("User enter valid password as {string}")
	public void user_enter_valid_password_as(String password) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		  //wait.until(ExpectedConditions.elementToBeClickable(lp.txtPassword));
		Thread.sleep(5000);
		  lp.setPassword(password);
		  logger.info("**************Providing Password***************");
	    
	}

	@Then("User click on Next for login")
	public void user_click_on_next_for_login() {
		lp.clickPasswordNext();
		logger.info("*************clicking on Next after Entering Password ****************");
	}

	@Then("login should be successful alongwith it's verification message and page Title should be {string}")
	public void login_should_be_successful_alongwith_it_s_verification_message_and_page_title_should_be(String string) {
		String title = "Gmail";
		if (driver.getTitle().equals(title)){
		System.out.println("Logged in sucessfully !!!"+driver.getTitle());
		}
		else {
		System.out.println("Unable to loggin :-( "+driver.getTitle());
		}
		logger.info("*************Verifiying login successful or not ****************");
	}
	
	@When("User click on Compose and maximize window")
	public void user_click_on_compose_and_maximize_window() throws InterruptedException {
		ce=new ComposeEmail(driver);
		ce.composeEmailButton();
		Thread.sleep(7000);
	    ce.composeMax();
	    logger.info("*************clicking on compose and maximize window ****************");
	}

	@Then("User enters  recipient email id as {string} email id and write subject and message body")
	public void user_enters_recipient_email_id_as_email_id_and_write_subject_and_message_body(String recipient) throws InterruptedException {
		Thread.sleep(4000);
		ce.enterRecipient(recipient);
		ce.enterSubject();
		ce.enterMessage();
		logger.info("*************enters_recipient email id,subject and message body ****************");
		
	}

	@Then("User click on send")
	public void user_click_on_send() {
	    ce.clickSend();
	    logger.info("*************clicking on send button ****************");
	}

	@Then("User click on Sent items for confirmation and capture it's sccreenshot")
	public void user_click_on_sent_items_for_confirmation_and_capture_it_s_sccreenshot() throws InterruptedException {
		Thread.sleep(2000); 
		ce.clinkSentLink();
		Thread.sleep(10000);
		UtilitiesGmail.screenshote_k(driver, "SentEmail");
		logger.info("*************clicking on sent items to check whether email actually sent or not and capture screenshot as proff ****************");

	}

	@Then("User click on Sign out")
	public void user_click_on_sign_out() {
	    lp.clickLogout();
	    logger.info("*************clicking on logout ****************");
	   
	}

	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
	    logger.info("*************closing browser ****************");
	}
	
	@When("User enters correct email as {string}")
	public void user_enters_correct_email_as(String username1) {
		lp.setUserName(username1);
		logger.info("*************Enter correct email id ****************");
	    
	}

	@When("User click on Next Button to procced further")
	public void user_click_on_next_button_to_procced_further() {
		lp.clickNext(); 
		logger.info("*************clicking on next ****************");
	}


	@Then("User enter incorrect password as {string}")
	public void user_enter_incorrect_password_as(String password1) throws InterruptedException {
		
		  Thread.sleep(7000);
		  lp.setPassword(password1);
		  logger.info("*************Enters incorrect password ****************");
	}

	@Then("User click on Next Button")
	public void user_click_on_next_button() {
		lp.clickPasswordNext();
		logger.info("*************clicking on next button after entering incorrect password ****************");
   
	}

	@Then("login failed alongwith it's error message and capture screenshot")
	public void login_failed_alongwith_it_s_error_message_and_capture_screenshot() throws InterruptedException {
		Thread.sleep(2000);
		lp.getErrorMessage();
		UtilitiesGmail.screenshote_k(driver, "LoginFailed");
		logger.info("*************Geting error message and taking sceenshot as proof ****************");
	  
	}
	@Then("close the browser after user enters invalid password")
	public void close_the_browser_after_user_enters_invalid_password() {
	   driver.close();
	   logger.info("*************Closing browser ****************");
	}



	}
