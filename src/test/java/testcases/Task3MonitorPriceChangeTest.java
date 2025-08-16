package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import util.EmailSender;

public class Task3MonitorPriceChangeTest extends TestBase{
	
	AmazonHomePage amazonHomePage;
	AmazonProductPage productPage;
	final String productUrl = "https://www.amazon.in/dp/B0D6Y7Y3N3?th=1"; // Example URL
    final double priceThreshold = 63901.00;
	
	@BeforeClass
	public void intialSetUp() throws InterruptedException{
		//initialization();
		System.out.println("Task 3");
		amazonHomePage = new AmazonHomePage();
		productPage=new AmazonProductPage();
		driver.get(productUrl);
		
	}
	
	@Test
	public void checkPriceAndNotify() {
		double price=productPage.getProductPrice();
		System.out.println("Current Price: ₹" + price);
		
		if(price<priceThreshold) {
			EmailSender.sendEmail("Price Alert: Amazon Product Drop!","The price has dropped to ₹" + price + ". Buy now at: " + productUrl );

		}
	}

}
