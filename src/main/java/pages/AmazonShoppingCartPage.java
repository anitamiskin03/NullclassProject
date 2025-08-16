package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AmazonShoppingCartPage extends TestBase {
	By cartButton = By.id("nav-cart-count");
	By proceedToBuyButton = By.xpath("//input[@name='proceedToRetailCheckout']");
	By backToCartButton = By.xpath("//a[normalize-space()='Back to cart']");
	By deleteItemFromCart = By.xpath("//span[@class='a-icon a-icon-small-trash']");

	public AmazonShoppingCartPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public void clickOnCartButton() {
		driver.findElement(cartButton).click();
	}

	public double getSubTotalBeforePayment() {
		WebElement price = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span"));
		String priceText = price.getText().replace("₹", "").replace(",", "").trim();
		return Double.parseDouble(priceText);
	}

	public void clickOnProceedToPayment() {
		// TODO Auto-generated method stub
		driver.findElement(proceedToBuyButton).click();

	}

	public void clickOnDeleteButton() {
		// TODO Auto-generated method stub
		driver.findElement(deleteItemFromCart).click();
	}

	public void clickOnBackToCartButton() {
		// TODO Auto-generated method stub
		driver.findElement(backToCartButton).click();
	}

}
