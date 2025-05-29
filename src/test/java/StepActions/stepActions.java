package StepActions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.PaymentPage;

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
	
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
	FinalPage finalPage;

	public stepActions() {
		driver = BrowserHandle.getDriver();
		p = BrowserHandle.p;
		frontpage = new FrontPage(driver, p);
		loginPage = new LoginPage(driver, p);
		homePage = new HomePage(driver, p);
		shoppingPage = new ShoppingPage(driver, p);
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
	
//	public void sorting() {
//		shoppingPage.sortingbyprice();	
//	}

	public void selectAllJackets() {
		shoppingPage.selectAllProductsAndAddToCart();
	}

	public double sumOfPrices() {
		return shoppingPage.getTotalPriceOfAllProducts();
	}

	public void verifyCartCountMatchesSelection() throws InterruptedException, AssertionError { 
		int itemselected=shoppingPage.getitemSelected();
		int cartcount=shoppingPage.getCartCount();
	    if(itemselected!= cartcount) {
	         throw new AssertionError("Cart count " + shoppingPage.getCartCount() + " does not match selected products " + shoppingPage.getitemSelected());
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

	public void fillPersonalDetailsAndContinue() throws InterruptedException {
		checkoutPage.fillPersonalDetails();
	}

	public void verifyPaymentInfoShippingInfoVisibility() {
		if (!paymentPage.isOrderSummaryDisplayed() || !paymentPage.isShippingInfoDisplayed()
			) {
			throw new AssertionError("Order Summary , shipping info and totalPrice not displayed");
		}
	}
	
//	public void verifyItemTotal() {
//		if(shoppingPage.getTotalPriceOfAllProducts()!=paymentPage.getItemsTotal()) {
//			Assert.assertTrue(false,"Total prices does not match");
//		}
//		else {
//			Assert.assertTrue(true,"Total price of items matches");
//		}
//			
//	}


	public void clickPlaceOrder() throws InterruptedException {
		paymentPage.checkBillingSameAsShipping();
		paymentPage.clickPlaceOrder().click();
	}

	public void verifyOrderConfirmationMessage() {
		
		
		String expectedMessage = p.getProperty("Confirmationmsg");
		String actualMessage = finalPage.getOrderConfirmationMessage();
		

		if (!actualMessage.equals(expectedMessage)) {
			Assert.assertTrue(false);
		} else {
			System.out.println("order has been placed");
			Assert.assertTrue(true);
			
		}
	}


	

	

	


}
