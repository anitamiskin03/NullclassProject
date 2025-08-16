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
		driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();
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

	public void clearCart(){
		
		  try { // Wait until cart is loaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		  "sc-active-cart")));
		  
		  // Loop until cart is empty
		  while (true) { List<WebElement> deleteButtons =
		  driver.findElements(By.xpath("//input[@value='Delete']"));
		  
		  if (deleteButtons.isEmpty()) { System.out.println("Cart is already empty!");
		  break; }
		  
		  // Click first delete button 
		  deleteButtons.get(0).click();
		  
		  // Wait for cart update after deletion
		  wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
		  Thread.sleep(1000); // small buffer for animation 
		  }
		  
		  System.out.println("Cart cleared successfully!");
		  
		  } catch (Exception e) { System.out.println("Error while clearing cart: " +
		  e.getMessage()); }
		 

		/*
		 * try { List<WebElement> deleteButtons = driver .findElements(By.
		 * xpath("//input[@value='Delete' or contains(@aria-label, 'Delete')]"));
		 * 
		 * while (!deleteButtons.isEmpty()) { for (WebElement deleteBtn : deleteButtons)
		 * { // deleteBtn.click();
		 * wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click(); //
		 * After deletion, break to re-fetch the updated list break; } //
		 * deleteButtons=driver.findElements(By.xpath("//input[@value='Delete' or //
		 * contains(@aria-label, 'Delete')]"));
		 * 
		 * // Wait and re-fetch the list after one item is removed
		 * wait.until(ExpectedConditions.invisibilityOfAllElements(
		 * driver.findElements(By.xpath("//input[@value='Delete'")))); } } catch
		 * (Exception e) { System.out.println("Error while clearing cart: " +
		 * e.getMessage()); }
		 */

	}
}
