package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{
	private WebDriver driver;
	
	private By shoppingCartButton = By.id("shopping_cart_container");
	private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
	private By addBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
	private By removeBackpackButton = By.id("remove-sauce-labs-backpack");
	private By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validatePage() {
		return driver.findElement(shoppingCartButton).isEnabled();
	}

	public void selectBackpack() {
		driver.findElement(addBackpackButton).click();
	}
	
	public void selectBikeLightButton() {
		driver.findElement(addBikeLightButton).click();
	}
	
	public boolean backpackWasAdded() {
		return driver.findElement(removeBackpackButton).isDisplayed();
	}
	
	public boolean bikeLightWasAdded() {
		return driver.findElement(removeBikeLightButton).isDisplayed();
	}
	
	public void goToShoppingCart() {
		driver.findElement(shoppingCartButton).click();
	}
}
