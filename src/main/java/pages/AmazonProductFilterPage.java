package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AmazonProductFilterPage extends TestBase {
	
	public AmazonProductFilterPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public void checkCustomerRatingAbove4() throws InterruptedException {
		//method to filter product according to customer rating should be above 4
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='p_72/1318476031']/span/div")).click();
		
	}

	public void checkPriceAbove2000() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Best XPath-based locators
	    WebElement minPrice = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//input[@name='low-price']")));
	    WebElement maxPrice = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//input[@name='high-price']")));
	    WebElement goButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//input[@class='a-button-input']")));

	    // Scroll to price section
	    js.executeScript("arguments[0].scrollIntoView(true);", minPrice);
	    Thread.sleep(500);

	    // Use JS to set values (avoids interactability issues)
	    js.executeScript("arguments[0].value='2000';", minPrice);
	    System.out.println("price is updated");
	    js.executeScript("arguments[0].value='50000';", maxPrice);

	    // Scroll to and click "Go"
	    js.executeScript("arguments[0].scrollIntoView(true);", goButton);
	    Thread.sleep(500);
	    goButton.click();
	}

	public void selectBrandNameStartWithC() {
		driver.findElement(By.cssSelector("a[aria-label='See more, Brands']")).click();
		List<WebElement> brandItems = driver.findElements(By.xpath("//ul[@id='filter-p_123']//span[@class='a-list-item']"));

		for (WebElement item : brandItems) {
		    String brandName =item.getText();
		    System.out.println(brandName);

		    if (brandName != null && brandName.startsWith("C")) {
		        System.out.println("Clicking brand: " + brandName);
		        
		        item.click(); // Click the full <li> element
		        break;
		    }
		}

	    
		
	}
	
	

}
