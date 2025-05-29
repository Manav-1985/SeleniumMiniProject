package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ShoppingPage extends BasePage {
	public ShoppingPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}

	// Arrays of XPaths for each box
	String[] sizeXPaths = { "//div[@class='swatch-opt-430']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-414']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-398']//div[@id='option-label-size-143-item-167']"};
//			"//div[@class='swatch-opt-382']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-366']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-350']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-334']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-318']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-302']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-286']//div[@id='option-label-size-143-item-167']",
//			"//div[@class='swatch-opt-270']//div[@id='option-label-size-143-item-167']" };

	String[] colorXPaths =  {
	        "//div[@class='swatch-opt-430']//div[@id='option-label-color-93-item-50']",
	        "//div[@class='swatch-opt-414']//div[@id='option-label-color-93-item-53']",
	        "//div[@class='swatch-opt-398']//div[@id='option-label-color-93-item-53']",
//	        "//div[@class='swatch-opt-382']//div[@id='option-label-color-93-item-53']",
//	        "//div[@class='swatch-opt-366']//div[@id='option-label-color-93-item-56']",
//	        "//div[@id='option-label-color-93-item-59']",
//	        "//div[@id='option-label-color-93-item-52']",
//	        "//div[@class='swatch-opt-318']//div[@id='option-label-color-93-item-58']",
//	        "//div[@class='swatch-opt-302']//div[@id='option-label-color-93-item-50']",
//	        "//div[@class='swatch-opt-286']//div[@id='option-label-color-93-item-56']",
//	        "//div[@class='swatch-opt-270']//div[@id='option-label-color-93-item-58']"
	    };

	String[] addXPaths = {
	        "//li[1]//form[1]//button[1]//span[1]",
	        "//li[2]//form[1]//button[1]//span[1]",
	        "//li[3]//form[1]//button[1]//span[1]"
//	        "//li[4]//form[1]//button[1]//span[1]",
//	        "//li[5]//form[1]//button[1]",
//	        "//li[6]//form[1]//button[1]//span[1]",
//	        "//li[7]//form[1]//button[1]//span[1]",
//	        "//li[8]//form[1]//button[1]//span[1]",
//	        "//li[9]//form[1]//button[1]//span[1]",
//	        "//li[10]//form[1]//button[1]//span[1]",
//	        "//li[11]//form[1]//button[1]//span[1]"
	    };

	String[] boxXPaths = {
	        "//div[@class='column main']//li[1]",
	        "//div[@class='column main']//li[2]",
	        "//div[@class='column main']//li[3]"};
//	        "//div[@class='column main']//li[4]",
//	        "//div[@class='column main']//li[5]",
//	        "//div[@class='column main']//li[6]",
//	        "//div[@class='column main']//li[7]",
//	        "//div[@class='column main']//li[8]",
//	        "//div[@class='column main']//li[9]",
//	        "//div[@class='column main']//li[10]",
//	        "//div[@class='column main']//li[11]"
//	    };
	
		String[] priceXPaths = { 
				"//span[contains(text(),'$42.00')]",
				"//span[@id='product-price-430']//span[@class='price'][normalize-space()='$45.00']",
				"//span[@id='product-price-302']//span[@class='price'][normalize-space()='$47.00']"};
//				"//span[@id='product-price-414']//span[@class='price'][normalize-space()='$49.00']"
//				"//span[@id='product-price-286']//span[@class='price'][normalize-space()='$51.00']",
//				"//span[@id='product-price-398']//span[@class='price'][normalize-space()='$56.99']",
//				"//span[@id='product-price-382']//span[@class='price'][normalize-space()='$60.00']",
//				"//span[@id='product-price-350']//span[@class='price'][normalize-space()='$65.00']",
//				"//span[@id='product-price-366']//span[@class='price'][normalize-space()='$66.00']",
//				"//span[@id='product-price-318']//span[@class='price'][normalize-space()='$72.00']",
//				"//span[@id='product-price-334']//span[@class='price'][normalize-space()='$99.00']" };
	// xpath for the confirmation message
	By confirmationMessage = By.xpath("//div[@class='message-success success message']");
	// common x path for price
	By totalitems = By.xpath("//span[@class='counter-number']");
	// xpath for remove button
	By RemoveButton=By.xpath("//div//div//div[@class='product actions']//div[@class='secondary']");
	//steps to reach the cart page
	By cartIcon = By.xpath("//a[@class='action showcart']");
	By checkoutButton = By.xpath("//button[@id='top-cart-btn-checkout']");
	By sorting =By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]");
	By filterbyprice=By.xpath("//select[@id='sorter']/option[@value='price']");

	
	public int noOfProductsSelected = 0;
	
//	public void sortingbyprice() {
//		driver.findElement(sorting).click();
//		driver.findElement(filterbyprice).click();
//	 
//	 
//	}

	
	// Action
	public void selectAndAddProduct(int index) {
		try {
			// Click Size
			driver.findElement(By.xpath(sizeXPaths[index])).click();

			// Click Color
			driver.findElement(By.xpath(colorXPaths[index])).click();

			// Hover on Box
			WebElement box = driver.findElement(By.xpath(boxXPaths[index]));
			action.moveToElement(box).perform();

			// Wait for Add button to be visible and click
			WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addXPaths[index])));
			addBtn.click();

			// Wait for confirmation
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
			noOfProductsSelected++;

			System.out.println("Box " + (index + 1) + " added to cart.");

		} catch (Exception e) {
			System.out.println("Failed to process Box " + (index + 1) + ": " + e.getMessage());
		}

	}
	// getting total number of items

	public int getitemSelected() {
		return noOfProductsSelected;
	}

	// adding items to cart
	public void selectAllProductsAndAddToCart() {
		for (int i = 0; i < boxXPaths.length; i++) {
			selectAndAddProduct(i);
		}
	}

	// getting the total price for all the items
	public double getTotalPriceOfAllProducts() {
		double totalPrice = 0.0;

		for (String xpath : priceXPaths) {
			try {
				WebElement priceElement = driver.findElement(By.xpath(xpath));
				String priceText = priceElement.getText();

				String numericPrice = priceText.replaceAll("[^0-9.]", "");
				double price = Double.parseDouble(numericPrice);
				totalPrice += price;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found for XPath: " + xpath);
			} catch (NumberFormatException e) {
				System.out.println("Price format error for XPath: " + xpath);
			}
		}

		System.out.println("Total Price: $" + totalPrice);
		return totalPrice;
	}
	
//  getting the number of total of items added to the cart 
	public int getCartCount() throws InterruptedException {
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(16));
		wait.until(ExpectedConditions.textToBe(totalitems, "3"));
	    // Once the count is 3, return it
	    return Integer.parseInt(driver.findElement(totalitems).getText().trim());
	}
	
	public boolean getStatusOfRemoveButton() {
		try {
			// Open cart
			driver.findElement(cartIcon).click();

			// Get all remove buttons
			List<WebElement> removeButtons = driver.findElements(RemoveButton);

			// Check if all remove buttons are displayed
			for (WebElement button : removeButtons) {
				if (!button.isDisplayed()) {
					System.out.println("One or more remove buttons are not visible.");
					return false;
				}
			}

			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			return false;

		} catch (WebDriverException e) {
			System.out.println("WebDriver error occurred: " + e.getMessage());
			return false;
		}

	}
	

	public void clickCheckout() {
		//wait until checkout button is there to be clicked
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
		
	}

}