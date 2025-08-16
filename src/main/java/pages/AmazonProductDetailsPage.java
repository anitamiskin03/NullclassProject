package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class AmazonProductDetailsPage extends TestBase {

	
	@FindBy(xpath = "//div[@id='titleSection']") WebElement searchedProductTitle;
	@FindBy(xpath = "//*[@id=\"corePriceDisplay_desktop_feature_div\"]//span[@class='a-price-whole']")WebElement searchedProductPrice;
	@FindBy(xpath = "(//div[@id='rightCol']//input[@id='add-to-cart-button'])[2]")WebElement addToCartButton;
	
	public AmazonProductDetailsPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public String getSearchedProductTitle() {
		// TODO Auto-generated method stub
		return searchedProductTitle.getText();
	}

	public String getSearchedProductPrice() {
		// TODO Auto-generated method stub
		return searchedProductPrice.getText();
	}
	
	public void clickOnAddToCart() {
		// TODO Auto-generated method stub
		addToCartButton.click();
		
	}
	
	

}
