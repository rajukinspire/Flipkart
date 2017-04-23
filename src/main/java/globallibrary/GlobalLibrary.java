package globallibrary;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

public class GlobalLibrary extends BaseClass{
	

	
	

	public static void setText(String Description, String locator, String textToFeed) {
		
		
		WebElement element=null;

		try { 
			logger.log(LogStatus.INFO, "Entering the text " + textToFeed + " on " + locator);
			element=driver.findElement(By.xpath(locator));
			element.clear();
			element.sendKeys(textToFeed);

			passStep(locator + "is feed with text " + textToFeed + " in the UI. " + Description);
		} catch (Exception e) {

			failStep(locator + "is not feed with the text in the UI");
		}

	}

	public static void clickObject(String Descrption, String locator) {

		WebElement element = getLocator(locator);

		try {
			if (element != null) {
				logger.log(LogStatus.INFO, " Doing Click event on " + locator);
				element.click();
				passStep(locator + " is clicked in the UI. " + Descrption);

			} else {

				failStep(locator + " is not displayed in the UI");
			}
		} catch (Exception e) {

			failStep(locator + "is not is displayed in the UI but not Clickable");
		}

	}

	public static void waitForElementToLoad(String locator, int timeInSec) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(getLocator(locator)));
			passStep("Element " + locator + "is loaded now");

		} catch (Exception e) {

			failStep("Element " + locator + "is not loaded in the application");

		}

	}

	public void objectPresence(String description, String locator) {

		WebElement element = getLocator(locator);

		try {
			if (element != null) {

				logger.log(LogStatus.INFO, locator + " is present in the UI " + description);
				passStep(description);
			} else
				failStep(locator + " is not present in the UI " + description);
		} catch (Exception e) {

			failStep(locator + " is not present in the UI " + description);

		}

	}
	
	public void objectAbsence(String description, String locator) {

		WebElement element = getLocator(locator);

		try {
			if (element == null) {

				logger.log(LogStatus.INFO, locator + " is not present in the UI " + description);
				passStep(description);
			} else
				failStep(locator + " is  present in the UI " + description);
		} catch (Exception e) {

			failStep(locator + " is  present in the UI " + description);

		}

	}

	public static WebElement getLocator(String locator) {

		WebElement element = null;

		logger.log(LogStatus.INFO, "Searching for web element  " + locator);

		try {

			if (driver.findElement(By.xpath(locator)).isDisplayed() && (driver.findElement(By.xpath(locator))).isEnabled()) {

				logger.log(LogStatus.INFO, locator + " is loaded and Visible in the Application ");
				element = driver.findElement(By.xpath(locator));

			}

			else {

				// severe
				logger.log(LogStatus.FAIL, locator + " is not loaded and Visible in the Application ");

			}

		} catch (Exception e) {

			logger.log(LogStatus.FAIL, locator + " locator is absent in the UI");

		}
		return element;
	}

	public static void passStep(String descripton) {

		logger.log(LogStatus.PASS, descripton);

	}

	public static void failStep(String descripton) {

		// add severe logger
		// add screen shot
		logger.log(LogStatus.FAIL, descripton);
		throw new AssertionError(descripton);

	}

}
