package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    lp=new LoginPage(driver);      
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) throws InterruptedException {
	    
	    lp.setusername(email);
	    lp.password(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
	    lp.login();
	    Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again")) {
			driver.close();
			Assert.assertTrue(false);
			
		}else {
			Assert.assertEquals(title, driver.getTitle());		
			}
			
		}
	    
	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
	    lp.logout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}

}
