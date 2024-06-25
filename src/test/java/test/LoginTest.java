package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;

@Listeners(test.Listeners.class)


public class LoginTest extends BaseTest {   
	@BeforeMethod
	
	public void openApplication() {
		
		driver=Browser.launchApplication();
		
	}
	
	@Test
	
	public void verifyIfUserisableToLogin() throws InterruptedException {
		
		searchProduct("cooker");
	    productResultPage = new ProductResultPage(driver);
	    productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		
		productDetailPage = new ProductDetailsPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
        cartPage.DeliveryproceedtoCheckout();
		switchToChildBrowser();

		loginPage=new LoginPage(driver);
	    loginPage.EnterMobileNumber("9588611541");
		loginPage.ClickonContinue();
		Thread.sleep(15000);
        loginPage.ClickonSubmit();
	}
	@AfterMethod
	   
	public void closeNaaptol () {
		driver.close();

}


}
