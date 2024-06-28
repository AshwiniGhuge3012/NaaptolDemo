package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parametrization;

public class LoginPage {

	@FindBy(xpath = "(//input[@class='input-new'])[4]")
	private WebElement mobileNumber;
	@FindBy(xpath = "(//input[@value='Continue'])[2]")
	private WebElement clickContinue;
	@FindBy(xpath = "(//input[@class='btn-login btn-blueBg'])[4]")
	private WebElement submit;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterMobileNumber() throws EncryptedDocumentException, IOException {
		String mobilenum = Parametrization.getTestData(3, 0, "Sheet1");
		mobileNumber.sendKeys(mobilenum);
	}

	public void clickOnContinue() {
		clickContinue.click();
	}

	public void clickOnSubmit() {
		submit.click();
	}

}