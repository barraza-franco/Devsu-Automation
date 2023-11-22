package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
	private WebDriver driver;

	private By checkoutLabel = By.xpath("//span[text()='Checkout: Your Information']");
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postalCodeInput = By.id("postal-code");
	private By continueButton = By.id("continue");

	public CheckoutInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validatePage() {
		return driver.findElement(checkoutLabel).isEnabled();
	}

	public void completeCheckoutData(String firstName, String lastName, String postalCode) {
		driver.findElement(firstNameInput).sendKeys(firstName);
		driver.findElement(lastNameInput).sendKeys(lastName);
		driver.findElement(postalCodeInput).sendKeys(postalCode);
		driver.findElement(continueButton).click();
	}
}
