package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	private WebDriver driver;

	private By checkoutLabel = By.xpath("//span[text()='Checkout: Overview']");
	private By bikeLightElement = By.id("item_0_title_link");
	private By backpackElement = By.id("item_4_title_link");
	private By finishButton = By.id("finish");

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validatePage() {
		return driver.findElement(checkoutLabel).isEnabled();
	}

	public boolean validateAddedProducts() {
		return driver.findElement(bikeLightElement).isEnabled() 
			&& driver.findElement(backpackElement).isEnabled();
	}
	
	public void clickFinish() {
		driver.findElement(finishButton).click();
	}
}
