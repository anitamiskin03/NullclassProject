package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AmazonProductPage extends TestBase {

	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(2000));
	By addToCartBtn = By.xpath("//*[@id=\"add-to-cart-button\"]");

	public AmazonProductPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public void addToCart() {

		driver.findElement(addToCartBtn).click();
	}

	public double getProductPrice() {
		String priceText=driver.findElement(By.cssSelector("span[class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay'] span[class='a-price-whole']")).getText();
		System.out.println(priceText);
		String correctPrice=priceText.replace("₹", "").replace(",", "").trim();
		return Double.parseDouble(correctPrice);
	}
}
