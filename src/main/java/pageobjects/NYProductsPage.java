package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.DriverManager;

/**
 * @author Dineshkumar
 */

public class NYProductsPage extends DriverManager {

	// Webelements of Products Page
	public static final By NEWIN = By.xpath("//*[@id='filter-content']/div[2]/div[1]/div[1]/span");
	public static final By COMING_SOON = By.xpath("//*[@id='filter-content']/div[2]/div[1]/div[2]/span");
	public static final By TIKTOK_TREND = By.xpath("//*[@id='filter-content']/div[2]/div[1]/div[3]/span");
	public static final By SNEAKER = By.xpath("//div[text()='Sneaker low']");
	public static final By SNEAKER_MODEL = By.xpath("//div[text()='Sneaker low']");

	// Constructor for driver instance
	public NYProductsPage() {
		driver = DriverManager.getDriverInstance();
	}

	/**
	 * Validates the visibility of filter elements on the page.
	 * @return true if all filter elements are displayed, false otherwise.
	 */
	public boolean validateFilterElements() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(TIKTOK_TREND));
		return driver.findElement(NEWIN).isDisplayed() && driver.findElement(COMING_SOON).isDisplayed()
				&& driver.findElement(TIKTOK_TREND).isDisplayed();
	}

	/**
	 * Validates the image click and content in the model window.
	 * @return true if model window has the image content, false otherwise.
	 * @throws Exception 
	 */
	public boolean validateImageClick() throws Exception {
		driver.findElement(SNEAKER).click();
		waitForVisibility();
		return driver.findElement(SNEAKER_MODEL).isDisplayed();
	}
}
