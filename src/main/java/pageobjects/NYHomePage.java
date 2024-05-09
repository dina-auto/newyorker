package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.DriverManager;

/**
 * @author Dineshkumar
 */
public class NYHomePage extends DriverManager{
	
	//Webelements of Newyorker Home Page
	  public static final By GO_BUTTON =  By.xpath("//button");
	  public static final By HERREN_IMAGE = By.xpath("//a[2]/*[@class='label'][text()='Herren']");
	  public static final By CLOSE_REGISTRATION = By.xpath("//*[@id='x-close']");
	  public static final By HAMBURGER_MENU = By.xpath("//div[1]/hamburger-menu");
	  public static final By ROOT_COOKIE_BANNER = By.tagName("cookie-banner");
	  public static final By ANMELDEN_BUTTON_MODEL_WINDOW = By.xpath("//*[@id='interstitial-main']/div[3]/div[1]/button");
	  public static final By REGISTER_BUTTON_MODEL_WINDOW = By.xpath("//*[@id='interstitial-main']/div[3]/div[2]/button");
	  public static final By ROOT_MORE_BUTTON = By.xpath("//*[@id='fashion']/main/item-fader/fader-item");
	  public static final By MORE_BUTTON = By.cssSelector("a > div > div > div > div.item-actions > a");
	  public static final By ROOT_NEWS_LETTER = By.xpath("//*[@id='newsletter']");
	  public static final By NEWS_LETTER = By.cssSelector("div > div > div.text-container > div.newsletter-header");
	  public static final By ROOT_PRODUCTS = By.xpath("//*[@id='fashion']/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]");
	  public static final By ROOT_GET_MORE_CLUB = By.xpath("//*[@href='/get-more-club/']");
	  public static final By ROOT_VOUCHERS = By.xpath("//*[@href='/gutschein/']");
	  WebDriverWait wait;
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	
	  //Constructor for driver instance
	public NYHomePage() {
		 driver = DriverManager.getDriverInstance();
	}
	
	/**
	 * Clicks the "Go" button and selects the "Herren" (men's) image.
	 * Waits for the "Go" button to be visible before clicking.
	 */	
	public void clickGoAndSelectHerren() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(GO_BUTTON));
		driver.findElement(GO_BUTTON).click();
		driver.findElement(HERREN_IMAGE).click();
	}

	/**
	 * Accepts cookies by clicking the "Accept" button on the cookie banner.
	 * Uses JavaScript to locate and click the button within the shadow DOM.
	 */
	public void accecptCookies() {
		WebElement cookieBanner = driver.findElement(ROOT_COOKIE_BANNER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement accecptCookies = (WebElement) js.executeScript("return document.querySelector(\"#fashion > cookie-banner\").shadowRoot.querySelector(\"div > div.cookie-banner-controls > button:nth-child(1)\")", cookieBanner);
		js.executeScript("arguments[0].click();", accecptCookies);
	}
	
	/**
	 * Validates the presence of "Anmelden" and "Register" buttons in the registration model window.
	 * @return true if both buttons are displayed, false otherwise
	 */
	public boolean validateButtonsInRegistration() {
		 return driver.findElement(ANMELDEN_BUTTON_MODEL_WINDOW).isDisplayed()&&
				 driver.findElement(REGISTER_BUTTON_MODEL_WINDOW).isDisplayed();
	}
	
	//Close the Registration model window
	public void closeRegistrationModel() {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_REGISTRATION));
		driver.findElement(CLOSE_REGISTRATION).click();
	}
		
	/**
	 * Validates the presence of "More" buttons on the Home page.
	 * @return The text displayed
	 */
	public String validatePresenceOfMoreButton() {
		 WebElement moreHomePage = driver.findElement(ROOT_MORE_BUTTON).getShadowRoot()
	    	   		.findElement(MORE_BUTTON);
	    String btnText =  moreHomePage.getText();
	    System.out.println("Home page More Button Text "+btnText);
	    return btnText;
	   
	}
	/**
	 * Validates the presence of News Letter on the Home page.
	 * @return The text displayed
	 */
	public String validatePresenceOfNewsLetter() {
		 WebElement elementHomePage = driver.findElement(ROOT_NEWS_LETTER).getShadowRoot()
		    		.findElement(NEWS_LETTER);
		    String newsLetterText = elementHomePage.getText();
		    System.out.println("Home News Letter text " +newsLetterText);
		    return newsLetterText;
	}
	
	//Click on the Hamburger Menu
	public void clickHamburgerMenu() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(HAMBURGER_MENU));
		driver.findElement(HAMBURGER_MENU).click();
		System.out.println("Clicked the Hamburger Menu");
	}
	
	//Clicks on the "Products" link in the Hamburger menu.
	public void clickProducts() throws Exception {
		WebElement productRoot = driver.findElement(ROOT_PRODUCTS);
		WebElement product = (WebElement)js.executeScript("return document.querySelector(\"#fashion > div.fashion-header > div.left-items > hamburger-menu > div.menu.active > div.menu-content > div.menu-links-1 > menu-item:nth-child(2)\").shadowRoot.querySelector(\"a > slot\")",productRoot);
		js.executeScript("arguments[0].click();", product);  
		System.out.println("Selected **Products** from the categories list");
		waitForVisibility();
	}
	
	//Clicks on the "Get More Club" link in the Hamburger menu.
	public void clickGetMoreClub() throws Exception {
		 WebElement gmc = driver.findElement(ROOT_GET_MORE_CLUB).getShadowRoot().findElement(By.cssSelector("a"));
		 js.executeScript("arguments[0].click();", gmc);
		 System.out.println("Selected **Get More Club** from the categories list");
		 waitForVisibility();
	}
	
	//Clicks on the "Vouchers" link in the Hamburger menu.
	public void clickVouchers() throws Exception {
		WebElement voucher = driver.findElement(ROOT_VOUCHERS).getShadowRoot().findElement(By.cssSelector("a"));
		 js.executeScript("arguments[0].click();", voucher);
		 System.out.println("Selected **Vouchers** from the categories list");
		 waitForVisibility();
	}
}
