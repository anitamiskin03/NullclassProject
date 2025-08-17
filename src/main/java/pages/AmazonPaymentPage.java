package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.ScreenshotUtil;

public class AmazonPaymentPage extends TestBase {
	By cartButton = By.id("nav-cart-count");
	By proceedToBuyButton = By.xpath("//input[@name='proceedToRetailCheckout']");
	

	public AmazonPaymentPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public void clickOnCartButton() {
		driver.findElement(cartButton).click();
	}

	public double getSubTotalBeforePayment() {
		WebElement price = driver.findElement(By.xpath("//td[@class='a-color-base a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']"));
		String priceText = price.getText().replace("₹", "").replace(",", "").trim();
		return Double.parseDouble(priceText);
	}

	public void clickOnProceedToPayment() {
		// TODO Auto-generated method stub
		driver.findElement(proceedToBuyButton).click();
		//ScreenshotUtil.takeScreenshot(driver, "Payment");

	}

	public static void changeAddress() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(text(),'Change')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='checkout-primary-continue-button-id']/span/input")));
		System.out.println(driver.findElement(By.xpath("//*[@id='checkout-primary-continue-button-id']/span/input")).getText());
		driver.findElement(By.xpath("//*[@id='checkout-primary-continue-button-id']/span/input")).click();
		ScreenshotUtil.takeScreenshot(driver, "Payment");
	}
}
