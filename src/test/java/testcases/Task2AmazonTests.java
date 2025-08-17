package testcases;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.AmazonGoToCartPage;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonPaymentPage;
import pages.AmazonProductPage;
import pages.AmazonSearchProductsPage;
import pages.VerifyAmazonPaymentPage;
import base.TestBase;

public class Task2AmazonTests extends TestBase {

	AmazonHomePage amazonHomePage;
	AmazonLoginPage amazonLoginPage;
	AmazonSearchProductsPage amazonSearchProductsPage;
	AmazonProductPage product;
	AmazonPaymentPage amazonPaymentPage;
	VerifyAmazonPaymentPage verifyAmazonPaymentPage;
	AmazonGoToCartPage amazonGoToCartPage;

	@BeforeSuite
	public void InitialSetUp() throws InterruptedException {
		// Condition is testing should work only between 6 Pm to 7 Pm

		/*
		 * if (!TimeValidator.isWithinAllowedTimeWindow(18, 19)) { throw new
		 * SkipException("Test skipped: Not within 6 PM to 7 PM window"); }
		 */

		initialization();
		System.out.println("Task 2");
		amazonHomePage = new AmazonHomePage();
		amazonLoginPage = new AmazonLoginPage();
		amazonSearchProductsPage = new AmazonSearchProductsPage();
		amazonGoToCartPage = new AmazonGoToCartPage();
		// product = new AmazonProductPage();
	}
	// Precondition is to be 'Logged In' into the site

	@Test(priority = 0)
	public void UserLogin() throws InterruptedException {
		driver.get(config.getProperty("baseURL"));
		amazonLoginPage.login();

	}

	// Searching for a product
	@Test(priority = 1)
	public void searchForProduct() throws InterruptedException {

		amazonHomePage.selectCategory("Electronics");
		Assert.assertEquals(amazonHomePage.getSelectedCategory(), "Electronics");
		amazonHomePage.searchForProduct("Bluetooth Speaker");
		amazonHomePage.clickOnSearchButton();
		Thread.sleep(2000);

		driver.getCurrentUrl();
	}

	// Adding Product to the cart
	@Test(priority = 2)
	public void AddToCart() throws InterruptedException {

		Thread.sleep(2000);
		amazonSearchProductsPage = new AmazonSearchProductsPage();
		amazonSearchProductsPage.selectProduct();
		amazonSearchProductsPage.addToCart();

	}

	// Making a Payment
	@Test(priority = 3)
	public void AmazonPayment() throws InterruptedException, TimeoutException {

		amazonPaymentPage = new AmazonPaymentPage();
		Thread.sleep(2000);
		driver.getCurrentUrl();
		amazonPaymentPage.clickOnCartButton();
		amazonPaymentPage.clickOnProceedToPayment();
		// select Delivery Address
		AmazonPaymentPage.changeAddress();

		// To check price is greater than 500 Thread.sleep(2000);
		double price = amazonPaymentPage.getSubTotalBeforePayment();

		if (price < 500) {
			throw new SkipException("Price is below ₹500, skipping payment test.");
		}
		amazonGoToCartPage.clearCart();

	}
	
	

}
