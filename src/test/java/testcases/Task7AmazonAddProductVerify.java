package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonGoToCartPage;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonPopupHandler;
import pages.AmazonProductPage;
import pages.AmazonProfilePage;
import pages.AmazonSearchProductsPage;
import pages.TimeValidator;
import util.ConfigReader;

public class Task7AmazonAddProductVerify extends TestBase {
	AmazonHomePage amazonHomePage;
	AmazonLoginPage amazonLoginPage;
	AmazonSearchProductsPage amazonSearchProductsPage;
	AmazonProductPage product;
	AmazonGoToCartPage amazonGoToCartPage;
	

	@BeforeClass
	public void InitialSetUp() throws InterruptedException {
		// Condition is testing should work only between 6 Pm to 7 Pm

		/*
		 * if (!TimeValidator.isWithinAllowedTimeWindow(18, 19)) { throw new
		 * SkipException("Test skipped: Current time not within 6 PM - 7 PM."); }
		 */
		//initialization();
		System.out.println("Task 7");
		amazonHomePage = new AmazonHomePage();
		amazonLoginPage = new AmazonLoginPage();
		amazonSearchProductsPage = new AmazonSearchProductsPage();
		amazonGoToCartPage = new AmazonGoToCartPage();
		
	}

	@Test(priority = 0)
	public void loginAndVerifyUsername() {
		driver.get(config.getProperty("baseURL"));
		amazonLoginPage.login();

		String username = amazonLoginPage.getLoggedInUsername();
		System.out.println("UserName:" + username);
		Assert.assertTrue(username.matches("^[a-zA-Z0-9]+$"), "Username must not have special characters");
		Assert.assertEquals(username.length(), 10, "Username must be 10 characters long");
		System.out.println("user name Verified");
		driver.findElement(By.xpath("//*[@id='a-popover-1']/div/header/button")).click();

	}

	@Test(priority = 1)
	public void addProductsAndVerifyPrice() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(2000);
		String[] productKeywords = { "laptop bag", "bottle", "running shoes", "notebook" };
		for (String keyword : productKeywords) {
			Thread.sleep(2000);
			amazonHomePage.searchForProduct(keyword);
			amazonHomePage.clickOnSearchButton();
			amazonSearchProductsPage.selectProduct();
			amazonSearchProductsPage.addToCart();
		}
		Thread.sleep(2000);
		driver.getCurrentUrl();
		amazonGoToCartPage.goToCart();
		double totalPrice = amazonGoToCartPage.calculateTotalCartPrice();
		Assert.assertTrue(totalPrice > 2000.0, "Total cart price must be more than ₹2000");
		amazonGoToCartPage.goToCart();
	}
	

}
