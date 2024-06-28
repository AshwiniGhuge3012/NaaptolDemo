package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class ViewProductdDetailsTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView() {
		test = reports.createTest("verifyIfUserIsViewProductDetailsFromQuickView");
		searchProduct("cooker");
		ProductResultPage productResultPage = new ProductResultPage(driver);
		String productName = productResultPage.getProductTitle(1);
		String productPrice = productResultPage.getProductPrice(1);
		productResultPage.moveToDesiredProduct(driver, 1);
		productResultPage.clickOnQuickView(1);
		Assert.assertEquals(productResultPage.getProductNameOnQuickView(), productName);
		Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);
	}

	@Test
	public void verifyIfUserIsViewProductDetailsbydirectclick() throws InterruptedException {
		test = reports.createTest("verifyIfUserIsViewProductDetailsbydirectclick");
		searchProduct("cooker");
		ProductResultPage productResultPage = new ProductResultPage(driver);
		String productName = productResultPage.getProductTitle(1);
		String productPrice = productResultPage.getProductPrice(1);
		productResultPage.moveToDesiredProduct(driver, 1);
		productResultPage.selectDesiredProduct(1);
		switchToChildBrowser();
		Thread.sleep(3000);
		String name = productResultPage.getProductNamebyClick();
		String price = productResultPage.getProductpricebyClick();
		Assert.assertEquals(productResultPage.getProductNamebyClick(), productName);
		Assert.assertEquals(productResultPage.getProductpricebyClick(), productPrice);

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
