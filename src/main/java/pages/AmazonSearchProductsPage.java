package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AmazonSearchProductsPage extends TestBase {
	@FindBy(xpath = "//span[contains(text(),'Noise Diva 2 Fashion Smart Watch for Women - Sleekest Dial, 36mm AMOLED Display')]")
	WebElement searchedProductsPageLabel;

	// Create instance for WebDriverWait
	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(2000));
	Set<String> newWindows;
	String parentWindow;

	public AmazonSearchProductsPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public String getPageLabelForSearchedProduct() {
		return searchedProductsPageLabel.getText();
	}

	public void clickOnProduct() {

		parentWindow = getdriver().getWindowHandle();
		// System.out.println("Parent="+driver.getCurrentUrl());
		searchedProductsPageLabel.click();
		newWindows = driver.getWindowHandles();
		// System.out.println("new="+driver.getCurrentUrl());

		for (String window : newWindows) {
			if (!parentWindow.equalsIgnoreCase(window)) {
				getdriver().switchTo().window(window);
				getdriver().getCurrentUrl();
				break;
			}
		}

	}

	public void selectProduct() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> products = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listitem']//h2//span")));

		switchToNewWindow();
		products.get(3).click();
		switchToNewWindow();

	}

	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("add-to-cart-button")));
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();
		// To close the popup Window
		AmazonPopupHandler handle = new AmazonPopupHandler();
		handle.handleAddToCartPopup();
		driver.getCurrentUrl();
	}

	public void switchToNewWindow() {
		String parentWindow = getdriver().getWindowHandle(); // Current window
		Set<String> allWindows = getdriver().getWindowHandles(); // All open windows

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window); // Switch to the new one
				break;
			}
		}
	}
}
