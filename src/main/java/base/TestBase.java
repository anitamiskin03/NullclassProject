package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import util.ConfigReader;

public class TestBase {

	protected static WebDriver driver = null;
	protected static ConfigReader config;

	public TestBase() {
		config = new ConfigReader();
	}


	public static void initialization() {
		String browserName = config.getProperty("browser");
		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "Path");
			getdriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(config.getProperty("baseURL"));
	}

	public static WebDriver getdriver() {
		// TODO Auto-generated method stub
		if (driver == null) {
			driver = new ChromeDriver();
			return driver;
		} else {
			return driver;
		}
	}

	/*
	 * @AfterClass public void tearDown() { if (driver != null) { driver.quit(); } }
	 */

}
