package pom;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Parametrization;

public class RegistrationDetailsPage extends BasePage {

	@FindBy(xpath = "//select[@name='fktitle_id']")
	private WebElement title;
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileNumber;
	@FindBy(xpath = "//ul [@class='verticalslider_tabs']//li")
	private List<WebElement> paymentOptions;
	@FindBy(xpath = "//input[@name='terms-condition-panel']")
	private WebElement termsandPrivacyPolicy;
	@FindBy(xpath = "(//a[@href='javascript:void(0);'])[2]")
	private WebElement placeOrder;
	@FindBy(xpath = "//a[text()='Save & Proceed']")
	private WebElement saveAndProceed;
	@FindBy(xpath = "(//a[@class='button_2'])")
	private WebElement shipAddress;
	@FindBy(xpath = "//a[text()='Step 2: Select Payment Option']")
	private WebElement paymentOption;
	@FindBy(xpath = "")
	private WebElement address;
	@FindBy(xpath = "")
	private WebElement landmark;
	@FindBy(xpath = "")
	private WebElement pincode;

	public RegistrationDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectTitle() {
		Select select = new Select(title);
		select.selectByValue("2");
	}

	public String enterFirstName() throws EncryptedDocumentException, IOException {
		String Name = Parametrization.getTestData(0, 0, "Sheet1");
		firstName.sendKeys(Name);
		return Name;
	}

	public void enterLastname() throws EncryptedDocumentException, IOException {
		String last = Parametrization.getTestData(0, 1, "Sheet1");
		lastName.sendKeys(last);
	}

	public void enterMobileNumber() throws EncryptedDocumentException, IOException {
		String mobilenum = Parametrization.getTestData(3, 0, "Sheet1");
		mobileNumber.sendKeys(mobilenum);
	}

	public void enterAddress() throws EncryptedDocumentException, IOException {
		String Add = Parametrization.getTestData(1, 0, "Sheet1");
		address.sendKeys(Add);
	}

	public void enterPincode() throws EncryptedDocumentException, IOException {
		String PIN = Parametrization.getTestData(2, 0, "Sheet1");
		pincode.sendKeys(PIN);
	}

	public void enterLandmark() throws EncryptedDocumentException, IOException {
		String mark = Parametrization.getTestData(4, 0, "Sheet1");
		landmark.sendKeys(mark);
	}

	public void selectPaymentOptions(int index) {
		paymentOptions.get(index).click();
	}

	public boolean IsPaymentOptionsDisplayed() {
		return ((WebElement) paymentOptions).isDisplayed();
	}

	public void checkTermsandPrivacyPolicy() {
		termsandPrivacyPolicy.click();
	}

	public void clickHereToPlaceOrder() {
		placeOrder.click();
	}

	public void clickOnSaveandProceed() {
		saveAndProceed.click();
	}

	public void ShipToThisAddress() {
		shipAddress.click();
	}

	public boolean isPaymentOptionDisplayed() {
		return paymentOption.isDisplayed();

	}

}
