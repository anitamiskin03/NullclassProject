package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import base.TestBase;

import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonPaymentPage;
import pages.AmazonProductDetailsPage;
import pages.AmazonSearchProductsPage;

public class AmazonLoginTest extends TestBase {
	AmazonHomePage amazonHomePage;
	AmazonLoginPage amazonLoginPage;
	AmazonSearchProductsPage amazonSearchProductsPage;
	AmazonProductDetailsPage amazonProductDetailsPage;
	AmazonPaymentPage amazonPaymentPage;
	
	@BeforeClass
	public void SetUp() throws InterruptedException {
		amazonProductDetailsPage=new AmazonProductDetailsPage();
		amazonSearchProductsPage = new AmazonSearchProductsPage();
		amazonHomePage =new AmazonHomePage();
		amazonLoginPage=new AmazonLoginPage();
		
	}
	
	@Test//(priority = 3)
	
	public void amazonLogin() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		
		amazonLoginPage.login();
		amazonPaymentPage = new AmazonPaymentPage();
		amazonPaymentPage.clickOnProceedToPayment();
		
		
	}
}
