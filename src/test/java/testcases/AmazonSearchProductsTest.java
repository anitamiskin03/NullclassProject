package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonProductDetailsPage;
import pages.AmazonSearchProductsPage;

public class AmazonSearchProductsTest extends TestBase {
	AmazonHomePage amazonHomePage;
	AmazonSearchProductsPage amazonSearchProductsPage;
	AmazonProductDetailsPage amazonProductDetailsPage;
	// AmazonLoginPage amazonLoginPage;

	
	@BeforeSuite
	public void setUp()throws InterruptedException {
		initialization();
		amazonProductDetailsPage=new AmazonProductDetailsPage();
		amazonSearchProductsPage = new AmazonSearchProductsPage();
		amazonHomePage = new AmazonHomePage();
	}

	@Test(priority = 0)
	public void searchForAProduct() throws InterruptedException {
	amazonHomePage.selectCategory("Electronics");
	Assert.assertEquals(amazonHomePage.getSelectedCategory(), "Electronics");
	amazonHomePage.searchForProduct("female smartwatch");
	amazonHomePage.clickOnSearchButton(); 
	Thread.sleep(2000); 
	String productLabel = amazonSearchProductsPage.getPageLabelForSearchedProduct();
	System.out.println(productLabel);
	Assert.assertNotEquals(amazonSearchProductsPage.getPageLabelForSearchedProduct(), "Search Result not Found");
	System.out.println("ProductLabel=" + productLabel);
	amazonSearchProductsPage.clickOnProduct();
	
	}
	
	

	
}
