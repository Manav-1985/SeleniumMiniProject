package StepActions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.FrontPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingPage;
import utility.BrowserHandle;

public class MagnetoActions {
	
	    WebDriver driver;
	    Properties p;

	    // Page Object instances
	    FrontPage frontpage;
	    LoginPage loginPage;
	    HomePage homePage;
	    ShoppingPage shoppingPage;
	    CartPage cartPage;
	    CheckoutPage checkoutPage;

	    // To keep track of selected products prices
	    private List<Double> selectedProductPrices;

	    public MagnetoActions() {
	        driver = BrowserHandle.getDriver();
	        frontpage = new FrontPage(driver, p);
	        loginPage = new LoginPage(driver,p);
	        homePage = new HomePage(driver,p);
	        shoppingPage = new ShoppingPage(driver,p);
	        cartPage = new CartPage();
	        checkoutPage = new CheckoutPage();
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
			shoppingPage.getTotalPriceOfAllProducts();
		}

	    public void verifyCartCount() {
	        int cartCount = shoppingPage.getCartCount();
	        if(cartCount != selectedProductPrices.size()) {
	            throw new AssertionError("Cart count " + cartCount + " does not match selected products " + selectedProductPrices.size());
	        }
	    }

	    public void verifyRemoveOptionsInCart() {
	        shoppingPage.openCart();
	        boolean allHaveRemove = cartPage.verifyRemoveOptionForAllItems();
	        if(!allHaveRemove) {
	            throw new AssertionError("Not all items have remove option");
	        }
	    }

	    public void proceedToCheckout() {
	        cartPage.clickCheckout();
	    }

	    public void fillPersonalDetailsAndContinue() {
	        String firstname = System.getProperty("firstname");
	        String lastname = System.getProperty("lastname");
	        String zipcode = System.getProperty("zipcode");
	        checkoutPage.fillPersonalDetails(firstname, lastname, zipcode);
	        checkoutPage.clickContinue();
	    }

	    public void verifyPaymentShippingAndTotal() {
	        if(!checkoutPage.isPaymentInfoDisplayed() || 
	           !checkoutPage.isShippingInfoDisplayed() ||
	           !checkoutPage.isTotalDisplayed()) {
	            throw new AssertionError("Payment info, shipping info or total not displayed");
	        }
	    }

	    public void verifyItemTotal() {
	        double itemTotal = checkoutPage.getItemTotal();
	        double sumOfSelected = selectedProductPrices.stream().mapToDouble(Double::doubleValue).sum();

	        if(Math.abs(itemTotal - sumOfSelected) > 0.01) { // Allow small float differences
	            throw new AssertionError("Item total " + itemTotal + " does not match sum of selected products " + sumOfSelected);
	        }
	    }

	    public void clickFinish() {
	        checkoutPage.clickFinish();
	    }

	    public void verifyOrderConfirmationMessage() {
	        String expectedMessage = "Thank you for your order!\nYour order has been dispatched, and will arrive just as fast as the pony can get there!";
	        String actualMessage = checkoutPage.getOrderConfirmationMessage();

	        if(!actualMessage.equals(expectedMessage)) {
	            throw new AssertionError("Order confirmation message does not match.\nExpected: " + expectedMessage + "\nActual: " + actualMessage);
	        }
	    }

		

		

		

	
	}

}
