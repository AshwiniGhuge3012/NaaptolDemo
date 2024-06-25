package test;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;
import org.testng.annotations.Test;

import pojo.Browser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import pom.NaaptolHomePage;

@Listeners(test.Listeners.class)

public class ProductSearchTest extends BaseTest {


	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsAbleRoSerachProduct() {
		
	searchProduct("toys");
	naptolHomePage.clickOnSearch();
	Assert.assertTrue(driver.getTitle().contains("toys"));
	Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed()>0);
		
	}
	
	
	
	@Test
    public void verifyIfUserIsAbletologin() {
	NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
    naaptolHomePage.clickOnLoginOrRegister();
	
	
	Assert.assertTrue(naaptolHomePage.IsLoginOrRegisterPopupdisplayed());
	Assert.assertTrue(naaptolHomePage.IsLoginOrRegisterTextdisplayed());
	
   }
	
    @Test
    public void verifyIfUserIsAbleToTrackorder() {
	NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
	naaptolHomePage.clickOnTrackOrder();
	naaptolHomePage.istrackordertitleDisplayed();
	naaptolHomePage.EnterorderID("12345");
	Assert.assertEquals(true, naaptolHomePage.istrackordertitleDisplayed());
	
   }
    
   @Test
    public void verifyIfUserisabletoaccessshoppingcategories() {
	NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
    naaptolHomePage.viewShoppingCategories(driver);
	Assert.assertTrue(naaptolHomePage.isListItemDisplayed());
	
  }
   
   @AfterMethod
   
	public void closeNaaptol () {
		driver.close();

  }

}
