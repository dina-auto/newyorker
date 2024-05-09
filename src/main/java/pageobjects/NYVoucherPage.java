package pageobjects;

import java.util.Map;

import org.openqa.selenium.By;

import framework.DriverManager;
import framework.ExcelDataReader;

/**
 * @author Dineshkumar
 */
public class NYVoucherPage extends DriverManager {
	// Webelements of Vouchers page
	public static final By BUY_VOUCHERS_BUTTON = By.xpath("//div/button");
	public static final By BUY_20_EURO = By.xpath("//router-view/div/div/div[1]/div[1]");
	public static final By ADD_TO_KART_BUTTON = By.xpath("//div/button");
	public static final By CHECKOUT_BUTTON = By.xpath("//div/button");
	public static final By FIRST_NAME_TEXTBOX = By.xpath("//input[@name='firstname']");
	public static final By LAST_NAME_TEXTBOX = By.xpath("//input[@name='lastname']");
	public static final By EMAIL_TEXTBOX = By.xpath("//input[@name='email']");
	public static final By STREET_TEXTBOX = By.xpath("//input[@name='street']");
	public static final By POSTAL_CODE_TEXTBOX = By.xpath("//input[@name='postal-code']");
	public static final By CITY_TEXTBOX = By.xpath("//input[@name='city']");
	public static final By NEXT_BUTTON = By.xpath("//div/button[@type='submit']");
	public static final By PAYMENT_PAYPAL = By.xpath("//input[@value='PAYPAL']");
	public static final By PAYMENT_CREDITCARD = By.xpath("//input[@value='CreditCard']");
	public static final By VOUCHER_VALUE_IN_PAYMENT_PAGE = By
			.xpath("//*[@id='gift-card-client']/div/div[3]/shopping-cart/div/div/table/tbody/tr[1]/td[2]");
	public static final By DUMMY_BUTTON = By.xpath("//div/button[2]");

	public String selectedEuro = null;
	public String euroValueInPayment = null;

	// Constructor for driver instance
	public NYVoucherPage() {
		driver = DriverManager.getDriverInstance();
	}

	/**
	 * Buys a voucher and navigates to the address page.
	 */
	public void buyVoucherAndNavigateToAddressPage() throws Exception {

		driver.findElement(BUY_VOUCHERS_BUTTON).click();
		driver.findElement(BUY_20_EURO).click();
		waitForVisibility();
		selectedEuro = driver.findElement(BUY_20_EURO).getText().trim();
		System.out.println("Selected voucher value is - " + selectedEuro);
		driver.findElement(ADD_TO_KART_BUTTON).click();
		waitForVisibility();
		driver.findElement(CHECKOUT_BUTTON).click();
		waitForVisibility();
		driver.findElement(DUMMY_BUTTON).click();
	}

	/**
	 * Getting the input from Excel data and enters the value in the address page.
	 */
	public void enterAddressDetails() throws Exception {
		// Read values from Excel
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx";
		Map<String, String> testData = ExcelDataReader.readExcel(filePath);
		// Input data from excel for the Address Details
		String firstNameValue = testData.get("First Name");
		String lastnameValue = testData.get("Last Name");
		String emailValue = testData.get("Email");
		String streetValue = testData.get("Street");
		String postalCodeValue = testData.get("Postal Code");
		String cityValue = testData.get("City");
		driver.findElement(FIRST_NAME_TEXTBOX).sendKeys(firstNameValue);
		waitForVisibility();
		driver.findElement(LAST_NAME_TEXTBOX).sendKeys(lastnameValue);
		driver.findElement(EMAIL_TEXTBOX).sendKeys(emailValue);
		waitForVisibility();
		driver.findElement(STREET_TEXTBOX).sendKeys(streetValue);
		driver.findElement(POSTAL_CODE_TEXTBOX).sendKeys(postalCodeValue);
		driver.findElement(CITY_TEXTBOX).sendKeys(cityValue);
		waitForVisibility();
		driver.findElement(NEXT_BUTTON).click();
	}

	/**
	 * Validates the elements on the payment page.
	 * @return true if the PayPal and Credit Card payment options are displayed otherwise, false.
	 * @throws Exception 
	 */
	public boolean validatePaymentPage() throws Exception {
		waitForVisibility();
		return driver.findElement(PAYMENT_PAYPAL).isDisplayed() && driver.findElement(PAYMENT_CREDITCARD).isDisplayed();
	}
}
