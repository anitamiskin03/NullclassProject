package testcases;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonProfilePage;
import pages.TimeValidator;

public class Task5AmazonUserProfileTest extends TestBase {
	AmazonHomePage amazonHomePage;
	AmazonLoginPage amazonLoginPage;

	@BeforeClass
	public void InitialSetUp() throws InterruptedException {
		// Condition is testing should work only between 12 Pm to 3 Pm

		/*
		 * if (!TimeValidator.isWithinAllowedTimeWindow(12, 15)) { throw new
		 * SkipException("Test skipped: Current time not within 12 PM - 3 PM."); }
		 */

		initialization();
		System.out.println("Task 5");
		amazonHomePage = new AmazonHomePage();
		amazonLoginPage = new AmazonLoginPage();
	}

	@Test(priority = 0)
	public void UserLogin() throws InterruptedException {
		driver.get(config.getProperty("baseURL"));
		amazonLoginPage.login();

	}

	// user profile details are displayed correctly.User profile Name should not
	// contain characters (A, C, G, I, L, K).
	@Test(priority = 1)
	public void validateProfileAndNameCharacters() {

		amazonLoginPage.goToYourAccount();
		
		driver.findElement(By.xpath("//*[contains(text(), 'Login & security')]")).click();
		AmazonProfilePage amazonProfilePage = new AmazonProfilePage(driver);

		Assert.assertNotNull(amazonProfilePage.getDisplayedName(), "Name is missing");
		// Assert.assertTrue(amazonProfilePage.getDisplayedEmail().contains("@"), "Email
		// is invalid");
		Assert.assertTrue(amazonProfilePage.getDisplayedMobile().matches("[0-9]{10}"), "Mobile number format invalid");
		Assert.assertTrue(amazonProfilePage.areEditLinksVisible(), "Edit links are not visible");

		// Validate the Profile Name
		String profileName = amazonProfilePage.getDisplayedName().trim();
		Pattern pattern = Pattern.compile("[ACGILK]", Pattern.CASE_INSENSITIVE);
		boolean InvalidName = pattern.matcher(profileName).find();
		if (!InvalidName) {
			System.out.println("✅ Profile name is valid: " + profileName);
			// You can now continue with further steps like navigating to cart, etc.
		} else {
			Assert.fail("❌ Profile name contains disallowed characters: A, C, G, I, L, K");
		}

	}

}
