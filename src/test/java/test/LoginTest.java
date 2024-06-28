package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
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
import utility.Reports;

@Listeners(test.Listeners.class)

public class LoginTest extends BaseTest {
@BeforeTest
	public void ConfigureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserisableToLogin() throws InterruptedException, EncryptedDocumentException, IOException {

		test = reports.createTest("verifyIfUserisableToLogin");
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
		Thread.sleep(15000);
		loginPage.clickOnSubmit();
	}

	@AfterMethod
	public void closeNaaptol() {
		driver.close();

	}

	@AfterTest
	public void publishReports() {
		reports.flush();
	}
}
