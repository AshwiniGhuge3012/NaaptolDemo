package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {
	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productNameOnQuickView;
	@FindBy (xpath = "//div[@id='square_Details']//span[@class='offer-price']")private WebElement productPriceOnQuickView;
	@FindBy (xpath = "//a[@id='cart-panel-button-0']") private WebElement clickToBuy;
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productNameOnQuickView.getText();
	}
	
	public double getProductPrice() {
		String [] p =	productPriceOnQuickView.getText().split(" ");
		//return p[0];
		
    	 return Double.parseDouble(removeCommaFromString(p[0]));

	}
	
	public double getShippingPrice() {
		String [] p =	productPriceOnQuickView.getText().split(" ");
		//return p[2];
		return Double.parseDouble(removeCommaFromString(p[2]));
	}
	
	public void clickOnBuyButton() {
		clickToBuy.click();
	}


}
