package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage{
	private WebDriver driver;
	
	private By yourCartLabel = By.xpath("//span[text()='Your Cart']");
	private By checkoutButton = By.id("checkout");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validatePage() {
		return driver.findElement(yourCartLabel).isDisplayed();
	}

	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}
}
