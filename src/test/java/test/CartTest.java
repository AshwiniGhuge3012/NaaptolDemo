package test;

import java.util.Iterator;

import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import org.testng.annotations.Listeners;


@Listeners(test.Listeners.class)
public class CartTest extends BaseTest {
	
	
	
	
	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyAddToCartFromOrderDeatils()
	{
		
		searchProduct("cooker");
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		
		productDetailPage = new ProductDetailsPage(driver);
		String ExpectedName = productDetailPage.getProductName();
		double ExpectedPrice = productDetailPage.getProductPrice();
		double ExpectedShippingPrice = productDetailPage.getShippingPrice();
		productDetailPage.clickOnBuyButton();
		cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1);
		Assert.assertEquals(cartPage.getProductName(0), ExpectedName);
		Assert.assertEquals(cartPage.getProductPrice(1), ExpectedPrice);
		Assert.assertEquals(cartPage.getShippingPrice(1), ExpectedShippingPrice);	
	}

    @Test

    public void VerifyAddtocartbyaddingtwoproducts() throws InterruptedException {
	
	searchProduct("cooker");
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	//Thread.sleep(2000);
	switchToChildBrowser();
	
	productDetailPage = new ProductDetailsPage(driver);
	String ExpectedName = productDetailPage.getProductName();
	double ExpectedPrice = productDetailPage.getProductPrice();
	double ExpectedShippingPrice = productDetailPage.getShippingPrice();
	productDetailPage.clickOnBuyButton();
	cartPage = new CartPage(driver);
	cartPage.ClosethePopup();
	
	
	searchProduct("toys");
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	switchToChildBrowser();
	
    productDetailPage = new ProductDetailsPage(driver);
	String ExpectedName1 = productDetailPage.getProductName();
	double ExpectedPrice1 = productDetailPage.getProductPrice();
	double ExpectedShippingPrice1 = productDetailPage.getShippingPrice();
	productDetailPage.clickOnBuyButton();
	
	//cooker
	Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 2);
	Assert.assertEquals(cartPage.getProductName(1), ExpectedName);
	Assert.assertEquals(cartPage.getProductPrice(2), ExpectedPrice);
	Assert.assertEquals(cartPage.getShippingPrice(2), ExpectedShippingPrice);	
    //Toys
	Assert.assertEquals(cartPage.getProductName(0), ExpectedName1);
	Assert.assertEquals(cartPage.getProductPrice(1), ExpectedPrice1);
	Assert.assertEquals(cartPage.getShippingPrice(1), ExpectedShippingPrice1);	


}	
	
	
   @Test

   public void VerifyByRemovingproductsfromCart() throws InterruptedException {
	
	searchProduct("cooker");
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	//Thread.sleep(2000);
	switchToChildBrowser();
	
	productDetailPage = new ProductDetailsPage(driver);
	productDetailPage.clickOnBuyButton();
	cartPage = new CartPage(driver);
    cartPage.ClosethePopup();
	
	
	searchProduct("toys");
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	switchToChildBrowser();
	
    productDetailPage = new ProductDetailsPage(driver);
	productDetailPage.clickOnBuyButton();
	
	
	int Q1=cartPage.getNumberOfProductsInCart();
	System.out.println(Q1);
	cartPage.Removeitemfromcart();
	
	Thread.sleep(2000);
	
	int Q2=cartPage.getNumberOfProductsInCart();
	System.out.println(Q2);
	
	Assert.assertNotEquals(Q1,Q2);
	
	}

   @Test
   public void verifyAmountsInCart() {
	naptolHomePage =new NaaptolHomePage(driver);
	naptolHomePage.enterProductToSearch("cooker");
	naptolHomePage.clickOnSearch();
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	switchToChildBrowser();
	productDetailPage = new ProductDetailsPage(driver);
	productDetailPage.clickOnBuyButton();
	cartPage = new CartPage(driver);
    cartPage.ClosethePopup();
	
	
	naptolHomePage.enterProductToSearch("toys");
	naptolHomePage.clickOnSearch();
	productResultPage = new ProductResultPage(driver);
	productResultPage.selectDesiredProduct(0);
	switchToChildBrowser();
	
    productDetailPage = new ProductDetailsPage(driver);
	productDetailPage.clickOnBuyButton();
     
	
	Assert.assertEquals(cartPage.getOrderAmount(1), (cartPage.getProductPrice(1)+cartPage.getShippingPrice(1)));
	Assert.assertEquals(cartPage.getOrderAmount(2), (cartPage.getProductPrice(2)+cartPage.getShippingPrice(2)));
  
	Assert.assertEquals(cartPage.getTotalAmount(0), (cartPage.getOrderAmount(1)+cartPage.getOrderAmount(2)));

	
}
   
   
   @AfterMethod
	   
		public void closeNaaptol () {
			driver.close();

   }
}
	
	
	
	
	
	
	
	
	
	
	


