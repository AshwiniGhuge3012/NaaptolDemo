package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptolHomePage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class ProductSearchTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();

	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserIsAbleRoSerachProduct() {
		test = reports.createTest("verifyIfUserIsAbleRoSerachProduct");
		searchProduct("toys");
		naptolHomePage.clickOnSearch();
		Assert.assertTrue(driver.getTitle().contains("toys"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed() > 0);

	}

	@Test
	public void verifyIfUserIsAbletologin() {
		test = reports.createTest("verifyIfUserIsAbletologin");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnLoginOrRegister();
		Assert.assertTrue(naaptolHomePage.isLoginOrRegisterPopupdisplayed());
		Assert.assertTrue(naaptolHomePage.isLoginOrRegisterTextdisplayed());

	}

	@Test
	public void verifyIfUserIsAbleToTrackorder() {
		test = reports.createTest("verifyIfUserIsAbleToTrackorder");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnTrackOrder();
		naaptolHomePage.istrackordertitleDisplayed();
		naaptolHomePage.enterOrderID("12345");
		Assert.assertEquals(true, naaptolHomePage.istrackordertitleDisplayed());

	}

	@Test
	public void verifyIfUserisabletoaccessshoppingcategories() {
		test = reports.createTest("verifyIfUserisabletoaccessshoppingcategories");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naaptolHomePage.isListItemDisplayed());

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
