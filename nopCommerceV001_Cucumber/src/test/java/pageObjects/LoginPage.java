package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 public WebDriver driver;
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	@FindBy(id="Email")
	WebElement txtemail;
	
	@FindBy(id="Password")
	WebElement txtpwd;
	
	@FindBy(xpath="//button[@class='button-1 login-button']" )
	WebElement txtlogin;
	
	@FindBy(linkText="Logout")
	WebElement txtlogout;
	
	public void setusername(String username) throws InterruptedException
	{
		txtemail.clear();
		txtemail.sendKeys(username);
	/*if(driver.getPageSource().contains("Wrong email")) {
			Thread.sleep(3000);
			driver.close();
		}*/
	}
	public void password(String pass)
	{
		txtpwd.clear();
		txtpwd.sendKeys(pass);
	}
	public void login()
	{
		txtlogin.click();
	}
	
	public void logout()
	{
		txtlogout.click();
	}

}
