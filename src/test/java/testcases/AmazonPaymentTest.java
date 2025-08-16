package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import pages.AmazonPaymentPage;

public class AmazonPaymentTest {
	AmazonHomePage amazonHomePage;
	AmazonPaymentPage AmazonPaymentPage;
	@BeforeTest
	public void SetUp() throws InterruptedException {
		
		amazonHomePage = new AmazonHomePage();
		AmazonPaymentPage = new AmazonPaymentPage();

	}
	@Test(priority = 4)
	public void AmazonPaymentDetails() throws InterruptedException {
		pages.AmazonPaymentPage.changeAddress();
	}

}
