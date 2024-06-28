package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import pom.RegistrationDetailsPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class RegistrationDetailsTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserAbletoEnterShippingAddress()
			throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("verifyIfUserAbletoEnterShippingAddress");
		searchProduct("cooker");
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailsPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
		cartPage.DeliveryproceedtoCheckout();
		switchToChildBrowser();
		loginPage = new LoginPage(driver);
		loginPage.enterMobileNumber();
		loginPage.clickOnContinue();
		Thread.sleep(30000);
		loginPage.clickOnSubmit();
		switchToChildBrowser();
		regDetails = new RegistrationDetailsPage(driver);
		regDetails.selectTitle();
		regDetails.enterFirstName();
		regDetails.enterLastname();
		regDetails.enterAddress();
		regDetails.enterLandmark();
		regDetails.enterPincode();
		regDetails.enterMobileNumber();
		Thread.sleep(2000);
		regDetails.clickOnSaveandProceed();
		regDetails.ShipToThisAddress();
	}

	@Test
	public void verifyIfUserisableToPlaceOrder() throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("verifyIfUserisableToPlaceOrder");
		searchProduct("cooker");
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailsPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
		cartPage.DeliveryproceedtoCheckout();
		switchToChildBrowser();
		loginPage = new LoginPage(driver);
		loginPage.enterMobileNumber();
		loginPage.clickOnContinue();
		Thread.sleep(30000);
		loginPage.clickOnSubmit();
		switchToChildBrowser();
		regDetails = new RegistrationDetailsPage(driver);
		regDetails.selectTitle();
		regDetails.enterFirstName();
		regDetails.enterLastname();
		regDetails.enterAddress();
		regDetails.enterLandmark();
		regDetails.enterPincode();
		regDetails.enterMobileNumber();
		Thread.sleep(2000);
		regDetails.clickOnSaveandProceed();
		regDetails.ShipToThisAddress();
		Thread.sleep(2000);
		regDetails.selectPaymentOptions(0);
		Thread.sleep(2000);
		// regDetails.checkTermsandPrivacyPolicy();
		// Thread.sleep(2000);
		// regDetails.ClickHereToPlaceOrder();
		Assert.assertTrue(regDetails.isPaymentOptionDisplayed());
	}

	@AfterMethod
	public void closeNaaptol() {
		driver.close();

	}

	@AfterTest
	public void publishReport() {
		reports.flush();
	}

}
