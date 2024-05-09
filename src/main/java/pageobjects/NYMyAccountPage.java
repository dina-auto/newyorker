package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.DriverManager;
/**
 * @author Dineshkumar
 */
public class NYMyAccountPage extends DriverManager {
	// Webelements of My Account Page
	public static final By ABOUT_YOU_TEXT = By.xpath("//h3[1]");
	public static final By BIRTH_DATE = By.xpath("//form/div[3]/div/div/flatpickr/input");

	// Constructor for driver instance
	public NYMyAccountPage() {
		driver = DriverManager.getDriverInstance();
	}

	/**
	 * Validates the birth date field.
	 * 
	 * @return The placeholder text of the birth date field.
	 */

	public String validateBirthDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_YOU_TEXT));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		String aboutText = driver.findElement(ABOUT_YOU_TEXT).getText();
		System.out.println("The Header Text for Date Field Section - " + aboutText);
		String birthDateText = driver.findElement(BIRTH_DATE).getAttribute("placeholder");
		System.out.println("Place holder text in side Birth Date Field is -" + birthDateText);
		return birthDateText;
	}

}
