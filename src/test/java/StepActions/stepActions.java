package StepActions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.PaymentPage;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.FinalPage;
import pageObjects.FrontPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingPage;
import utility.BrowserHandle;

public class stepActions {

	WebDriver driver;
	Properties p;

	// Page Object instances
	FrontPage frontpage;
	LoginPage loginPage;
	HomePage homePage;
	ShoppingPage shoppingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
	FinalPage finalPage;

	// To keep track of selected products prices
	private List<Double> selectedProductPrices;

	public stepActions() {
		driver = BrowserHandle.getDriver();
		p = BrowserHandle.p;
		frontpage = new FrontPage(driver, p);
		loginPage = new LoginPage(driver, p);
		homePage = new HomePage(driver, p);
		shoppingPage = new ShoppingPage(driver, p);
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage(driver, p);
		paymentPage =new PaymentPage(driver, p);
		finalPage= new FinalPage(driver, p);
	}

	public void openUrlAndClickSignIn() {
		driver.get(p.getProperty("BaseUrl"));
		frontpage.clickSignIn();
	}

	public void logInWithValidCredentials() {
		loginPage.login();
	}

	public void navigateToMenJackets() {
		homePage.navigateToMenJackets();
	}

	public void selectAllJackets() {
		shoppingPage.selectAllProductsAndAddToCart();
	}

	public double sumOfPrices() {
		return shoppingPage.getTotalPriceOfAllProducts();
	}

	public void verifyCartCount() throws InterruptedException, AssertionError { 
	    if(shoppingPage.getitemSelected()!= shoppingPage.getCartCount()) {
	         throw new AssertionError("Cart count " + shoppingPage.getCartCount() + " does not match selected products " + shoppingPage.getitemSelected());
	    }
	    else {
	       	System.out.println("****Count Verified****");
	    }
	}    

	public void verifyRemoveOptionsInCart() {
		boolean hasRemove =shoppingPage.getStatusOfRemoveButton();
		if(!hasRemove) {
	        throw new AssertionError("Remove button is not present for the cart item.");
	     }
	}
	
	public void proceedToCheckout() {
		shoppingPage.clickCheckout();
	}

	public void fillPersonalDetailsAndContinue() {
		checkoutPage.fillPersonalDetails();
	}

	public void verifyPaymentInfoShippingInfoAndPriceVisibility() {
		if (!paymentPage.isPaymentInfoDisplayed() || !paymentPage.isShippingInfoDisplayed()
				|| !paymentPage.isTotalPriceDisplayed()) {
			throw new AssertionError("Payment info, shipping info or total not displayed");
		}
	}

	public void verifyItemTotal() {
		double itemstotalprice = paymentPage.getItemsTotal();
		double shippingprice =paymentPage.getShippingTotal();
		double totalprice=paymentPage.getCartTotal();
		if (totalprice!=shippingprice+itemstotalprice) {
			throw new AssertionError("Items Total is not Correct");
		}
	}

	public void clickPlaceOrder() {
		paymentPage.clickPlaceOrder().click();
	}

	public void verifyOrderConfirmationMessage() {
		String expectedMessage = p.getProperty("Confirmationmsg");
		String actualMessage = finalPage.getOrderConfirmationMessage();

		if (!actualMessage.equals(expectedMessage)) {
			throw new AssertionError("Order confirmation message does not match.\nExpected: " + expectedMessage
					+ "\nActual: " + actualMessage);
		}
	}

	

	


}
