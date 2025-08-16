package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class AmazonValidProductAndVerifyPage extends TestBase{

	WebDriverWait wait;
	
	public void selectValidProduct() throws InterruptedException  {
		// TODO Auto-generated method stub
		// Get list of product titles
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> titles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//a[@class=\"a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal\"]/h2/span")));
        

        boolean productClicked = false;
        for (WebElement title : titles) {
            String productName = title.getText().trim();
            if (productName.isEmpty()) continue;

            // Ignore if starts with A/B/C/D
            if (productName.matches("^[A-Da-d].*")) {
                continue;
            }
            
			// Check for category: Go to parent and read its content
			WebElement parent = title.findElement(By.xpath("./ancestor::div[@data-component-type='s-search-result']"));
			String fullText = parent.getText().toLowerCase();

			if (fullText.contains("electronics")) {
				continue;
			}

			// Scroll into view and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", title);
			Thread.sleep(1000); // avoid click interception
			title.click();
			productClicked = true;
			break;
		}

        Assert.assertTrue(productClicked, "No suitable product found.");

        // Switch to new tab if opened
        for (String win : driver.getWindowHandles()) {
            driver.switchTo().window(win);
        }
	}

	public void verifySelectedProduct() {
		//  Verify product details
		
		//To verify Product Title
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
        Assert.assertTrue(productTitle.isDisplayed(), "Product title not found");
        System.out.println("ProductTitle: "+productTitle.getText());

        //To Verify Price
        WebElement price = driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]//span[@class='a-price-whole']"));
        Assert.assertTrue(price.isDisplayed(), "Product price not found");
        System.out.println("Product Price: "+price.getText());

        //To verify "Add to cart" button
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart button not found");
        
        
        WebElement availabilty = driver.findElement(By.id("availability"));
        System.out.println(availabilty.getText());
        Assert.assertTrue(availabilty.getText().trim().contains("In stock"), "Product not in stock");
        
        WebElement image=driver.findElement(By.id("landingImage"));
        String src=image.getAttribute("src");
        Assert.assertTrue(image.isDisplayed() && src !=null && !src.isEmpty(), "Product image is not loaded properly");
        
        WebElement rating=driver.findElement(By.xpath("//span[@id='acrPopover']"));
        Assert.assertTrue(rating.getAttribute("title").contains("out of 5 stars"), "Rating is not displayed properly");
        System.out.println("Rating: " + rating.getAttribute("title"));
        
        WebElement reviewCount=driver.findElement(By.id("acrCustomerReviewText"));
        Assert.assertTrue(reviewCount.getText().toLowerCase().contains("rating")||reviewCount.getText().toLowerCase().contains("review"), "Review count missing");
        System.out.println("Review Count: " + reviewCount.getText());
        
        System.out.println("Product Page Verified Successfully");

		
	}

}
