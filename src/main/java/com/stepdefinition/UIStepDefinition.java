package com.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.CaptureScreenshot;
import framework.DriverManager;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import pageobjects.NYGetMoreClubPage;
import pageobjects.NYHomePage;
import pageobjects.NYLoginPage;
import pageobjects.NYMyAccountPage;
import pageobjects.NYProductsPage;
import pageobjects.NYVoucherPage;

public class UIStepDefinition {
	// Instance for the Page Object Classes
	NYHomePage homePage;
	NYLoginPage loginPage;
	NYMyAccountPage myAccountPage;
	NYProductsPage productsPage;
	NYGetMoreClubPage getMoreClubPage;
	NYVoucherPage vouchersPage;

	@Given("^I want to launch NewYorker home page$")
	public void i_want_to_launch_NewYorker_home_page() throws Throwable {

		DriverManager driverManager = new DriverManager();
		driverManager.getDriver();
		if (homePage == null)
			homePage = new NYHomePage();
		System.out.println("Successfully Launched the Newyorker Home Page");
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "HomePage");
	}

	@When("^I click Go select Herren and accecpt the cookies$")
	public void i_click_Go_select_Herren_and_accecpt_the_cookies() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		homePage.clickGoAndSelectHerren();
		System.out.println("Selected HERREN From Home page");
		homePage.accecptCookies();
		System.out.println("Accecpted the Cookies");
	}

	@When("^I close the Registration model window$")
	public void i_close_the_Registration_model_window() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "Registration_Model_Window");
		Assert.assertEquals(true, homePage.validateButtonsInRegistration());
		System.out.println("***Validated the presence of Anmelden and Register button in Registration Model Window***");
		homePage.closeRegistrationModel();
		System.out.println("Closed the Registration Model Window");
	}

	@Then("^I validate NewYorker Men Home page elements$")
	public void i_validate_NewYorker_Men_Home_page_elements() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		Assert.assertEquals(homePage.validatePresenceOfMoreButton(), "MEHR");
		System.out.println("***Validated - Home Page MEHR Button and the Text successfully*** ");
		Assert.assertEquals(homePage.validatePresenceOfNewsLetter(), "Hey, stay in touch with us.");
		System.out.println("***Validated - Home Page News Letter Text successfully*** ");
	}

	@When("^I click Hamburger menu and select Products$")
	public void i_click_Hamburger_menu_and_select_Products() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		homePage.clickHamburgerMenu();
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "HamburgerMenu");
		homePage.clickProducts();
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "ProductsPage");
	}

	@Then("^I validate the elements in products page$")
	public void i_validate_the_elements_in_products_page() throws Throwable {
		if (productsPage == null)
			productsPage = new NYProductsPage();
		Assert.assertEquals(true, productsPage.validateFilterElements());
		System.out.println("***Validated Products page Filter Elements NEW IN, COMING SOON TIK TOK Successfully***");
		Assert.assertEquals(true, productsPage.validateImageClick());
		System.out.println("***Validated Products page Image Click and Value in the model window Successfully***");
	}

	@When("^I login to the portal$")
	public void i_login_to_the_portal() throws Throwable {
		if (loginPage == null)
			loginPage = new NYLoginPage();
		loginPage.clickUserProfile();
		loginPage.loginToPortal();
	}

	@When("^I navigate to MyAccount$")
	public void i_navigate_to_MyAccount() throws Throwable {
		if (loginPage == null)
			loginPage = new NYLoginPage();
		loginPage.clickUserProfile();
		loginPage.navigateToMyAccount();
	}

	@Then("^I validate the Date of Birth field$")
	public void i_validate_the_Date_of_Birth_field() throws Throwable {
		if (myAccountPage == null)
			myAccountPage = new NYMyAccountPage();
		Assert.assertEquals("Geburtsdatum", myAccountPage.validateBirthDate().trim());
		System.out.println("***Validated Birth date field and the text inside the field successfully***");
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "MyAccountPage");
	}

	@When("^I click Hamburger menu and select Get More Club$")
	public void i_click_Hamburger_menu_and_select_Get_More_Club() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		homePage.clickHamburgerMenu();
		homePage.clickGetMoreClub();
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "GetMoreClubPage");
	}

	@Then("^I validate the elements in Get More Club page$")
	public void i_validate_the_elements_in_Get_More_Club_page() throws Throwable {
		if (getMoreClubPage == null)
			getMoreClubPage = new NYGetMoreClubPage();
		Assert.assertEquals(true, getMoreClubPage.validateRegisterAndAnmelden());
		Assert.assertEquals("MITGLIED WERDEN", getMoreClubPage.validateTextInImage());
		System.out.println(
				"Get More Club page Anmelden and Register button and a text inside an image is validated Successfully");
	}

	@When("^I click Hamburger menu and select Vouchers$")
	public void i_click_Hamburger_menu_and_select_Vouchers() throws Throwable {
		if (homePage == null)
			homePage = new NYHomePage();
		homePage.clickHamburgerMenu();
		homePage.clickVouchers();
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "VouchersPage");
	}

	@When("^I navigate to the flow of buy vouchers$")
	public void i_navigate_to_the_flow_of_buy_vouchers() throws Throwable {
		if (vouchersPage == null)
			vouchersPage = new NYVoucherPage();
		vouchersPage.buyVoucherAndNavigateToAddressPage();
		vouchersPage.enterAddressDetails();
	}

	@Then("^I validate the elements in Vouchers payment page$")
	public void i_validate_the_elements_in_Vouchers_payment_page() throws Throwable {
		if (vouchersPage == null)
			vouchersPage = new NYVoucherPage();
		Assert.assertEquals(true, vouchersPage.validatePaymentPage());
		System.out.println("Vouchers Payment Page elements Paypal and Credit card validated successfully");
		CaptureScreenshot.getScreenshot(DriverManager.getDriverInstance(), "VouchersPaymentPage");
	}

	@Then("^I logout from the portal$")
	public void i_logout_from_the_portal() throws Throwable {
		if (loginPage == null)
			loginPage = new NYLoginPage();
		loginPage.clickUserProfile();
		loginPage.logoutFromPortal();
		System.out.println("Logged out of the portal successfully");
	}
}
