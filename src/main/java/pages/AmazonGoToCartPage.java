package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.ScreenshotUtil;

public class AmazonGoToCartPage extends TestBase {

	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));

	public void goToCart() {
		driver.findElement(By.id("nav-cart-count-container")).click();
		// ScreenshotUtil.takeScreenshot(driver, "CartPage");
	}

	public double calculateTotalCartPrice() {
		List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span"));
		double total = 0.0;
		for (WebElement price : prices) {
			String clean = price.getText().replace(",", "").replace("₹", "").trim();
			total += Double.parseDouble(clean);
		}
		ScreenshotUtil.takeScreenshot(driver, "TotalCartPrice");
		return total;
	}

	public void clearCart() throws TimeoutException, InterruptedException {
		driver.findElement(By.id("nav-logo-sprites")).click();
		driver.findElement(By.id("nav-cart-count-container")).click();
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//input[@value='Delete']"));
		System.out.println(deleteButtons.size());
		while (!deleteButtons.isEmpty()) {

			for (WebElement deleteBtn : deleteButtons) {
				wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
				break;
			}

			// Wait and re-fetch the list after one item is removed
			if (deleteButtons.size() == 1)
				break;
			else {
				String refresh = driver.getCurrentUrl();
				driver.get(refresh);

				Thread.sleep(2000);
				// wait.until(ExpectedConditions
				// .visibilityOfAllElements(driver.findElements(By.xpath("//input[@value='Delete']"))));
				deleteButtons = driver.findElements(By.xpath("//input[@value='Delete']"));
			}

		}

	}
}
