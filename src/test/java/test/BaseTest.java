package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.NaaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import pom.RegistrationDetailsPage;

public class BaseTest {
	
	public static WebDriver driver;
	public NaaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
	public ProductDetailsPage productDetailPage;
	public CartPage cartPage;
	public LoginPage loginPage;
	public RegistrationDetailsPage regDetails ;
	  
	public   ExtentReports reports;
	public static ExtentTest  test;
	   
	
	public void switchToChildBrowser() {
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		while(i.hasNext()) {
		driver.switchTo().window(i.next());
		}
		
		
	}
	
	public void searchProduct(String s) {
		naptolHomePage =new NaaptolHomePage(driver);
		naptolHomePage.enterProductToSearch(s);
		naptolHomePage.clickOnSearch();
	}
 
			
			
	 
			
			
			
		

	}
