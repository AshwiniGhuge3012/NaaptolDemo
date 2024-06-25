package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationDetailsPage extends BasePage{
	
	@FindBy (xpath= "//select[@name='fktitle_id']")private WebElement Title;
	@FindBy (xpath="//input[@name='firstName']")private WebElement firstName;
	@FindBy (xpath="//input[@name='lastName']")private WebElement lasttName;
    @FindBy (xpath="//input[@name='mobile']")private WebElement mobileNumber;
    @FindBy (xpath = "//ul [@class='verticalslider_tabs']//li")private  List< WebElement> paymentOptions ;
    @FindBy (xpath = "//input[@name='terms-condition-panel']")private WebElement termsandPrivacyPolicy;
    @FindBy (xpath = "(//a[@href='javascript:void(0);'])[2]")private WebElement placeOrder;
    @FindBy (xpath ="//a[text()='Save & Proceed']")private WebElement saveAndProceed;
    @FindBy (xpath ="(//a[@class='button_2'])")private WebElement shipAddress;
    @FindBy  (xpath = "//a[text()='Step 2: Select Payment Option']")private WebElement paymentOption;
    
    
 public RegistrationDetailsPage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
 public void selectTitle() {
	 Select select = new Select(Title);
	 select.selectByValue("2");
	 
 }
 public  void EnterFirstName(String firstname) {
	 
	  firstName.sendKeys(firstname);
 }
 
 public void EnterLastname(String lastname) {
	 
	lasttName.sendKeys(lastname);
 }
 
 public void EnterMobileNumber(String number) {
	 mobileNumber.sendKeys(number);

 }
 
 
  public void selectpaymentOptions(int index) {
	  paymentOptions.get(index).click();
	  
  }	  
  
  public boolean IsPaymentOptionsDisplayed() {
	  
	 return  ((WebElement) paymentOptions).isDisplayed();
  }
	public void checkTermsandPrivacyPolicy() {
		termsandPrivacyPolicy.click();
		
	}
	
	public void ClickHereToPlaceOrder() {
		placeOrder.click();
	}
	 public void ClickonSaveandProceed() {
		 saveAndProceed.click();
	 } 
	 public void ShipToThisAddress() {
		 shipAddress.click();
	 } 
	 
	 public boolean isPaymentOptionDisplayed(){
		 return paymentOption.isDisplayed();
		 
		 
	 }

  }
 

 
 
 
 
 
 
 
 
