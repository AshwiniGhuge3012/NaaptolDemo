package pom;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolHomePage {

	
	@FindBy (xpath ="//a[@href='#LoginBox']")private WebElement loginOrRegister;
	@FindBy (xpath ="//div[@class='fancybox-skin']")private WebElement loginOrRegisterPopup;
	@FindBy (xpath ="//p[@class='heading']")private WebElement loginOrRegisterText;

	@FindBy (xpath ="//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy (xpath ="//div[@class='cate_head']") private WebElement shoppingCategories;
	@FindBy (xpath ="//input[@id='header_search_text']")private WebElement searchField;
	@FindBy (xpath ="(//div[@class='search']//a)[2]") private WebElement search;
	@FindBy (xpath ="(//a[@id='cart-panel-link'])[2]") private WebElement cart;
	@FindBy (xpath ="//div[@id='mainMenuContent']//ul//li[1]//a//span") private WebElement listItem;
	@FindBy (xpath ="//div[@class='grid_Square ']") private List<WebElement> productList;
	@FindBy (xpath ="//h2[text()='Track Order']")private WebElement Trackordertitle;
	@FindBy (xpath = "//input[@id='orderId']")private WebElement OrderID;
	
	//WebDriver driver;

	public  NaaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginOrRegister() {
		loginOrRegister.click();
	}
	public boolean IsLoginOrRegisterPopupdisplayed() {
		return loginOrRegisterPopup.isDisplayed();
	}
	public boolean IsLoginOrRegisterTextdisplayed() {
	return	loginOrRegisterText.isDisplayed();
	}
	
	
	public void clickOnTrackOrder() {
		trackOrder.click();
	}
	public boolean istrackordertitleDisplayed() {
		return Trackordertitle.isDisplayed();
	}
	
	public void EnterorderID(CharSequence no){ 
		
		 OrderID.sendKeys(no);
	}
	
	public void viewShoppingCategories(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategories);
		actions.perform();
	}
	
	public void enterProductToSearch(String product) {
		searchField.sendKeys(product);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public boolean isListItemDisplayed() {
		return listItem.isDisplayed();
	}
	
	public int getNumberOfProductDisplayed() {
		return productList.size();
	}
}




