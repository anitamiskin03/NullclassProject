package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AmazonProfilePage extends TestBase {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(2000));

	public AmazonProfilePage(WebDriver driver) {
		//PageFactory.initElements(getdriver(), this);
		this.driver = TestBase.getdriver();
	}
	By nameLocator = By.xpath("//*[@id='NAME_SUBTITLE' or @Name='Name']");
    //By emailLocator = By.xpath("//input[contains(@value,'@')]");
    By mobileLocator = By.xpath("//*[@id='MOBILE_NUMBER_SUBTITLE']");
    By editLinks = By.xpath("//a[contains(text(),'Edit') or contains(text(),'Change')]");

    public String getDisplayedName() {
        return driver.findElement(nameLocator).getText();
    }

	/*
	 * public String getDisplayedEmail() { return
	 * driver.findElement(emailLocator).getAttribute("value"); }
	 */

    public String getDisplayedMobile() {
    	//System.out.println(driver.findElement(mobileLocator).getText().trim().replace("+91", ""));
        return driver.findElement(mobileLocator).getText().trim().replace("+91", "");
    }

    public boolean areEditLinksVisible() {
        return driver.findElements(editLinks).size() > 0;
    }
    
   
}


