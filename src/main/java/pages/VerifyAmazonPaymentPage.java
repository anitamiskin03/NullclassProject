package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class VerifyAmazonPaymentPage extends TestBase {

	By backToCartButton = By.xpath("//a[normalize-space()='Back to cart']");
	By deleteItemFromCart = By.xpath("//span[@class='a-icon a-icon-small-trash']");

	

	// To verify Payment page elements
	@FindBy(xpath = "//span[@class='a-color-base a-text-bold'][contains(text(),'Other UPI Apps')]")
	WebElement upiOption;

	@FindBy(xpath = "//span[@class='a-text-bold'][contains(text(),'Net Banking')]")
	WebElement netBankingOption;

	@FindBy(xpath = "//*[@id='subtotals-marketplace-table']/tbody/tr[5]/td[2]")
	WebElement orderTotal;

	@FindBy(xpath = "//*[@id='subtotals-marketplace-table']/tbody/tr[3]/td[2]")
	WebElement totalBefore;

	@FindBy(xpath = "//*[@id='subtotals-marketplace-table']/tbody/tr[2]/td[2]")
	WebElement deliveryCharges;
	
	public VerifyAmazonPaymentPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public boolean isPaymentOptionsDisplayed() throws InterruptedException {
		driver.getCurrentUrl();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement creditCardOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Credit or debit card')]")));
		return creditCardOption.isDisplayed() && upiOption.isDisplayed() && netBankingOption.isDisplayed();
	}

	public void printOrderSummary() {
		System.out.println("Order Total: " + orderTotal.getText());
		System.out.println("Total Before Tax: " + totalBefore.getText());
		System.out.println("Delivery Charges: " + deliveryCharges.getText());
	}

	

}
