package globallibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	

	public static WebDriver driver;
	public static ExtentReports reports=new ExtentReports("./Reports/testresults.html",true);
	public static ExtentTest logger=new ExtentTest("Reports","First Prog");
	Properties prop=new Properties();
	
	public BaseClass(){
		try {
			FileInputStream fis=new FileInputStream("./configaration/config.properties");
			
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	public void launchApplication(){
		
		if(prop.getProperty("browser").equals("ff")){
			System.out.println("launching browser");
			driver=new FirefoxDriver();
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
		}
		
		
	}
	

	@BeforeTest
	public void open(){
	
		System.out.println(" Task Started");
		
	}
	
	@AfterTest
	public void close(){
		System.out.println(" Task Completed");
		logger.log(LogStatus.PASS, "Verified the login page");
		reports.endTest(logger);
		reports.flush();
	}

}
