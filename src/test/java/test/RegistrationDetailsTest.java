package test;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import pom.RegistrationDetailsPage;

@Listeners(test.Listeners.class)


public class RegistrationDetailsTest extends BaseTest {
	
	
	@BeforeTest
	public void openApplication() {
		driver = Browser.launchApplication();
	}
	 @Test
	public void verifyIfUserAbletoEnterShippingAddress() throws InterruptedException {
		
		
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
	    loginPage.EnterMobileNumber("9922939375");
		loginPage.ClickonContinue();
		Thread.sleep(30000);
        loginPage.ClickonSubmit();


        switchToChildBrowser();
		regDetails = new RegistrationDetailsPage(driver);
		regDetails.selectTitle();
		regDetails.EnterFirstName("Ashwini");
		regDetails.EnterLastname("Ghuge");
		
		Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
		actions.sendKeys("Bhekrai Nagar");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("HP Petrol Pump");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("411028");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        regDetails.EnterMobileNumber("9922939375");
        Thread.sleep(2000);
        
        Thread.sleep(2000);
		regDetails.ClickonSaveandProceed();
        regDetails.ShipToThisAddress();		
	 }
	 
        
        
        @Test
        public void verifyIfUserisableToPlaceOrder() throws InterruptedException {
        	
        	
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
    	    loginPage.EnterMobileNumber("9922939375");
    		loginPage.ClickonContinue();
    		Thread.sleep(30000);
            loginPage.ClickonSubmit();


            switchToChildBrowser();
    		regDetails = new RegistrationDetailsPage(driver);
    		regDetails.selectTitle();
    		regDetails.EnterFirstName("Ashwini");
    		regDetails.EnterLastname("Ghuge");
    		
    		Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB);
    		actions.sendKeys("Bhekrai Nagar");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("HP Petrol Pump");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("411028");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
            regDetails.EnterMobileNumber("9922939375");
            Thread.sleep(2000);
            
            Thread.sleep(2000);
    		regDetails.ClickonSaveandProceed();
            regDetails.ShipToThisAddress();		
		    Thread.sleep(2000);
	        regDetails.selectpaymentOptions(0);	
	        Thread.sleep(2000);;
	        //regDetails.checkTermsandPrivacyPolicy();
	        //Thread.sleep(2000);
	        //regDetails.ClickHereToPlaceOrder();	
	   
             Assert.assertTrue(regDetails.isPaymentOptionDisplayed());
	}
	
	 
	 @AfterMethod
	   
		public void closeNaaptol () {
			driver.close();

   }

	
	
		}


  