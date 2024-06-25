package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy (xpath = "(//input[@class='input-new'])[4]")private WebElement mobileNumber;
    @FindBy (xpath ="(//input[@value='Continue'])[2]")private WebElement Continue ;
    @FindBy (xpath ="(//input[@class='btn-login btn-blueBg'])[4]")private WebElement submit;
    
    
    
    
    public LoginPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    	
     }
     public void EnterMobileNumber(String number) {
    	 
     mobileNumber.sendKeys(number);
	//return number;
    }
     public void ClickonContinue() {
    	 
    	 Continue.click();
    }
     
     public void ClickonSubmit() {
    	 submit.click();
     }
}