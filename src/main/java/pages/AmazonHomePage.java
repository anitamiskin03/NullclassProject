package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class AmazonHomePage extends TestBase{
	//WebDriver driver;
	
	public AmazonHomePage() {
		//this.driver = TestBase.getdriver();
		PageFactory.initElements(getdriver(), this);
	}

	By searchBox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");
	By searchcategory = By.id("searchDropdownBox");

	public void selectCategory(String category) {
		WebElement dropdown = driver.findElement(searchcategory);
		Select select = new Select(dropdown);
		//dropdown.click();
		select.selectByVisibleText(category);
	}

	public String getSelectedCategory() {
		// TODO Auto-generated method stub
		return "Electronics";
	}

	public void searchForProduct(String product) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(product);

	}

	public void clickOnSearchButton() {
		// TODO Auto-generated method stub
		driver.findElement(searchButton).click();
	}
	
	
	

	

}
