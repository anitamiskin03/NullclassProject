package testcases;

import java.time.Duration;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonValidProductAndVerifyPage;
import pages.TimeValidator;

public class Task6AmazonValidProductAndVerifyTest extends TestBase {

	AmazonHomePage amazonHomePage;

	@BeforeMethod
	public void initialSetUp() throws InterruptedException {

		if (!TimeValidator.isWithinAllowedTimeWindow(15, 18)) {
			throw new SkipException("Test skipped: Not within 3 PM to 6 PM window");
		}

		System.out.println("Task 6");
		amazonHomePage = new AmazonHomePage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(config.getProperty("baseURL"));
	}

	// Select Valid Product and verify the product page detail
	@Test
	public void amazonSelectValidProductVerify() throws InterruptedException {
		AmazonValidProductAndVerifyPage verifyProductPage = new AmazonValidProductAndVerifyPage();

		// Search for the product
		amazonHomePage.searchForProduct("laptop bag");
		amazonHomePage.clickOnSearchButton();
		verifyProductPage.selectValidProduct();
		verifyProductPage.verifySelectedProduct();

	}
}
