package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonProductDetailsPage;

public class AmazonProductDetailsTest extends TestBase {

	AmazonProductDetailsPage amazonProductDetailsPage;
	AmazonHomePage amazonHomePage;

	@BeforeClass
	public void setUp() {
		amazonProductDetailsPage = new AmazonProductDetailsPage();
		amazonHomePage = new AmazonHomePage();
	}

	@Test(priority = 1)
	public void verifyProductDetails() {
		amazonProductDetailsPage = new AmazonProductDetailsPage();
		String productTitle = "Noise Diva 2 Fashion Smart Watch for Women - Sleekest Dial, 36mm AMOLED Display, Snug Fit, Improved Female Cycle Tracker, BT Calling, Sleep Tracking, AI Voice Assistant, Password Protection-Rose Link";
		String productPrice = "4,999";
		System.out.println(productPrice);
		Assert.assertEquals(amazonProductDetailsPage.getSearchedProductTitle(), productTitle);
		Assert.assertEquals(amazonProductDetailsPage.getSearchedProductPrice(), productPrice);
		amazonProductDetailsPage.clickOnAddToCart();

	}

}
