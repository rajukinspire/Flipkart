package testcases;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globallibrary.BaseClass;
import pages.LoginPage;

public class VerifyPage extends BaseClass{
	
	
	LoginPage loginPage=LoginPage.getLoginPage();
	
	@Test
	public void verifyPageTitle(){
		
		
		launchApplication();
		loginPage.loginApplication("rajeshkbit@gmail.com", "powerrajeshk");
		String title=driver.getTitle();
		System.out.println(" Title is "+title);
	
		
		
		
	}
	
	@Test
	public void verifyLogin(){
		
		
		launchApplication();
		loginPage.loginApplication("rajeshkbit@gmail.com", "1122345");
		String title=driver.getTitle();
	
		
		
		
	}
	

	
	

}
