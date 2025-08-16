package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonShoppingCartPage;

public class AmazonShoppingCartTest extends TestBase {

	AmazonHomePage amazonHomePage;
	AmazonShoppingCartPage amazonShoppingCartPage;

	@BeforeTest
	public void SetUp() throws InterruptedException {
		
		amazonHomePage = new AmazonHomePage();
		amazonShoppingCartPage = new AmazonShoppingCartPage();

	}


	@Test(priority = 2)
	public void goToCart() throws InterruptedException {
		amazonShoppingCartPage.clickOnCartButton();
		amazonShoppingCartPage.getSubTotalBeforePayment();
		//amazonShoppingCartPage.clickOnProceedToPayment();
		
		
		
	}

	

}
