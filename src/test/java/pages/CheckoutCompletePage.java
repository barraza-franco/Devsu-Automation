package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	private WebDriver driver;

	private By checkoutLabel = By.xpath("//span[text()='Checkout: Complete!']");
	private By thankYouText = By.xpath("//*[@class='complete-header']");
	private By backHomeButton = By.id("back-to-products");

	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validatePage() {
		return driver.findElement(checkoutLabel).isEnabled();
	}

	public boolean validateText(String text) {
		String actualText = driver.findElement(thankYouText).getText();
        return actualText.equals(text);
	}
	
	public void clickBackHome() {
		driver.findElement(backHomeButton).click();
	}
}
