package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

import java.time.Duration;

public class AmazonPopupHandler extends TestBase{

    

    public AmazonPopupHandler() {
    	PageFactory.initElements(getdriver(), this);
    }

    public void handleAddToCartPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the "Added to Cart" popup to appear
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"hctp-attach-side-sheet\"]")
            ));

            // Optional: Verify text
            //String confirmationText = popup.getText();
            //System.out.println("Popup Text: " + confirmationText);

            
            // close the popup by clicking "X"
            WebElement closeButton = driver.findElement(By.xpath("//*[@aria-label='Exit this panel and return to the product page.']"));
            closeButton.click();

        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
    }
}

