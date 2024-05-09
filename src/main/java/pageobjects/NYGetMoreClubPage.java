package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.DriverManager;

/**
 * @author Dineshkumar
 */

public class NYGetMoreClubPage extends DriverManager {
	// Webelements of Get More Club page
	public static final By TEXT_IN_IMAGE = By.xpath("//div[2]/div[1]/div/div[1]/h2");
	public static final By ANMELDEN_BUTTON = By.xpath("//*[@id='app']/div/div/div/div[1]/div[2]/div[2]/button[1]");
	public static final By REGISTRIEREN_BUTTON = By.xpath("//*[@id='app']/div/div/div/div[1]/div[2]/div[2]/button[2]");

	// Constructor for driver instance
	public NYGetMoreClubPage() {
		driver = DriverManager.getDriverInstance();
	}

	/**
	 * Validates the text displayed within an image element on the page.
	 * @return The text displayed within the image, after trimming whitespace.
	 */

	public String validateTextInImage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_IN_IMAGE));
		String textInImage = driver.findElement(TEXT_IN_IMAGE).getText();
		return textInImage.trim();

	}

	/**
	 * Validates the presence and visibility of "Anmelden" and "Registrieren" buttons on the page.
	 * @return True if both "Anmelden" and "Registrieren" buttons are displayed false otherwise.
	 */

	public boolean validateRegisterAndAnmelden() {
		String anmelden = driver.findElement(ANMELDEN_BUTTON).getText();
		String register = driver.findElement(REGISTRIEREN_BUTTON).getText();
		System.out.println("The text in Anmelden Button is - " + anmelden);
		System.out.println("The text in Register Button is - " + register);
		return driver.findElement(ANMELDEN_BUTTON).isDisplayed()
				&& driver.findElement(REGISTRIEREN_BUTTON).isDisplayed();
	}
}
