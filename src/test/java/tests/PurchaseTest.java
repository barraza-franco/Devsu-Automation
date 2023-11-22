package tests;

import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTest extends BaseTest {

	@Test
	@Description("Test de compra de 2 items")
	public void purchaseTwoItems() {
		loginAndNavigateToHomePage();
		addItemsToCart();
		goToShoppingCart();
		doCheckoutAndCompleteData();
		validateAddedProductsAndFinishPurchase();
	}

	@Step("Iniciar sesión y navegar a la página de inicio")
	private void loginAndNavigateToHomePage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();
		loginPage.login("standard_user", "secret_sauce");

		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.validatePage(), "The login was not successful.");
	}

	@Step("Agregar items al carrito")
	private void addItemsToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.selectBackpack();
		homePage.selectBikeLightButton();
		assertTrue(homePage.backpackWasAdded(), "The backpack was not added.");
		assertTrue(homePage.bikeLightWasAdded(), "The bike light was not added.");
	}

	@Step("Ir al carrito de compras")
	private void goToShoppingCart() {
		HomePage homePage = new HomePage(driver);
		homePage.goToShoppingCart();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		assertTrue(shoppingCartPage.validatePage(), "Error validating the shopping cart.");
	}

	@Step("Hacer el checkout y completar datos")
	private void doCheckoutAndCompleteData() {
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.clickCheckout();
		CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
		assertTrue(checkoutInformationPage.validatePage(), "Error validating the checkout information page.");

		checkoutInformationPage.completeCheckoutData("Franco", "Barraza", "1313");

		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		assertTrue(checkoutOverviewPage.validatePage(), "Error validating the checkout overview page.");
	}

	@Step("Validar productos agregados y finalizar compra")
	private void validateAddedProductsAndFinishPurchase() {
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		assertTrue(checkoutOverviewPage.validateAddedProducts(), "Error validating the checkout overview page.");
		checkoutOverviewPage.clickFinish();

		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		assertTrue(checkoutCompletePage.validateText("Thank you for your order!"), "Error validating the finish text.");
	}

}
