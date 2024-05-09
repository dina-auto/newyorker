package pageobjects;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import framework.DriverManager;
import framework.EnvironmentManager;
/**
 * @author Dineshkumar
 */
public class NYLoginPage extends DriverManager{
	//WebElements of Login Page
	public static final By ROOT_USERPROFILE = By.xpath("//customer-widget");
	public static final By USERPROFILE = By.cssSelector("div.customer-widget");
	public static final By USERNAME_TXT = By.cssSelector("div.customer-menu.no-login.active > div.email-input > input[type=email]");
	public static final By PASSWORD_TXT = By.cssSelector("div.customer-menu.no-login.active > div.password-input > input[type=password]");
	public static final By LOGIN_BTN = By.cssSelector("div.customer-menu.no-login.active > div.buttons > button");
	public static final By MYACCOUNT_LINK = By.cssSelector("div.customer-menu.active > div.menu-items > a:nth-child(1) > span");
	public static final By LOGOUT_LINK = By.cssSelector("div.customer-menu.active > div.menu-items > button > span");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Constructor for driver instance
	public NYLoginPage() {
		 driver = DriverManager.getDriverInstance();
	}

	/**
	 * Clicks on the user profile.
	 * @throws Exception if unable to click on the user profile
	 */
	public void clickUserProfile() throws Exception {
		WebElement userProfile = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(USERPROFILE);
		 js.executeScript("arguments[0].click();", userProfile);
		 System.out.println("Clicked the User Profile");
		 waitForVisibility();
			}
	/**
	 * Logs in to the portal using the credentials from the environment manager.
	 * @throws Exception if unable to log in to the portal
	 */
	public void loginToPortal() throws Exception {
		String uName = EnvironmentManager.getDetails("Username");
		WebElement userName = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(USERNAME_TXT);
		 js.executeScript("arguments[0].click();", userName);
		 userName.sendKeys(uName);
		 System.out.println("Entered the username in the Login page ");
		 waitForVisibility();
		 byte[] decodedBytes1 = Base64.getDecoder().decode(EnvironmentManager.getDetails("Password"));
			String actPassword = new String(decodedBytes1);
		 WebElement passWord = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(PASSWORD_TXT);
		 js.executeScript("arguments[0].click();", passWord);
		 js.executeScript("arguments[0].value=arguments[1]", passWord,actPassword);
		 passWord.clear();
		 passWord.sendKeys(actPassword);
		 System.out.println("Entered the Password in the Login page ");
		 waitForVisibility();
		 WebElement loginButton = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(LOGIN_BTN);
		 js.executeScript("arguments[0].click();", loginButton);
		 System.out.println("Logged in to the application successfully");
		 waitForVisibility();

	}
	//Click on My Account link from User Profile menu
	public void navigateToMyAccount() {
		 WebElement myAccount = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(MYACCOUNT_LINK);
		 js.executeScript("arguments[0].click();", myAccount);
		 System.out.println("Selected **My Account** from the User Profile list");
		 	}

	//Click on logout link from the User Profile menu
	public void logoutFromPortal() throws Exception {
		 WebElement logout = driver.findElement(ROOT_USERPROFILE).getShadowRoot().
				 findElement(LOGOUT_LINK);
		 js.executeScript("arguments[0].click();", logout);
		 waitForVisibility();
	}
}
