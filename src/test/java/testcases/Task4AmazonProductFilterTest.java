package testcases;

import java.time.Duration;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonProductFilterPage;
import pages.TimeValidator;
import util.ScreenshotUtil;

public class Task4AmazonProductFilterTest extends TestBase {
	AmazonHomePage amazonHomePage;

	@BeforeMethod
	public void initialSetUp() throws InterruptedException {

		if (!TimeValidator.isWithinAllowedTimeWindow(15, 18)) {
			throw new SkipException("Test skipped: Not within 3 PM to 6 PM window");
		}

		System.out.println("Task 4");
		amazonHomePage = new AmazonHomePage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(config.getProperty("baseURL"));
	}

	@Test
	public void amazonProductFilter() throws InterruptedException {
		AmazonProductFilterPage filterPage = new AmazonProductFilterPage();

		amazonHomePage.searchForProduct("laptop bag");
		amazonHomePage.clickOnSearchButton();
		filterPage.checkPriceAbove2000();
		filterPage.checkCustomerRatingAbove4();
		filterPage.selectBrandNameStartWithC();
		ScreenshotUtil.takeScreenshot(driver, "Product_Filter");

	}

}
