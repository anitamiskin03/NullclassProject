package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.ScreenshotUtil;

public class AmazonLoginPage extends TestBase {
	//WebDriver driver;
	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(2000));

	public AmazonLoginPage() {
		PageFactory.initElements(getdriver(), this);
		//this.driver = TestBase.getdriver();

	}

	By logIn = By.id("nav-link-accountList");
	String user = config.getProperty("username");
	By continueButton = By.className("a-button-input");
	String password = config.getProperty("password");
	By signIn = By.id("signInSubmit");

	public void login() {
		driver.findElement(logIn).click();
		driver.findElement(By.id("ap_email_login")).sendKeys(user);
		driver.findElement(continueButton).click();
		driver.get(driver.getCurrentUrl());
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(signIn).click();

		ScreenshotUtil.takeScreenshot(driver, "Login");
	}

	//By accountLink = By.xpath("//span[text()='Account & Lists']");

	public void goToYourAccount() {
		driver.findElement(By.xpath("//span[contains(text() ,'Account & Lists')]")).click();
	}
	
	public String getLoggedInUsername() {
		driver.findElement(By.xpath("//*[contains(text(), 'Account & Lists')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Login & security')]")).click();
		WebElement user = driver.findElement(By.id("NAME_SUBTITLE"));
		return user.getText().trim().replaceAll("\\s+", "");
	}

	/*
	 * public String getLoggedInUsername() {
	 * 
	 * By nameLocator =
	 * By.xpath("//input[@id='customer-name' or @name='customerName']"); By
	 * emailLocator = By.xpath("//input[contains(@value,'@')]"); By mobileLocator =
	 * By.xpath("//input[@type='tel']"); By editLinks =
	 * By.xpath("//a[contains(text(),'Edit') or contains(text(),'Change')]");
	 * 
	 * 
	 * driver.findElement(By.
	 * xpath("//button[@aria-label='Expand Account and Lists']")).click();
	 * driver.findElement(By.xpath("//div[@cursor='pointer']")).click(); WebElement
	 * user= driver.findElement(By.
	 * xpath("//div[contains(@class, 'profile-detail-primary')]"));
	 * 
	 * WebElement user = driver .findElement(By.
	 * xpath("//div[@class='sc-dLMFU sc-ikkxIA EZIgf kpsBEL profile-detail-primary']"
	 * ));
	 * 
	 * return user.getText().trim().replaceAll("\\s+", ""); }
	 */

}
