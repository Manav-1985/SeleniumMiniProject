package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingPage extends BasePage {
	public ShoppingPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}

	List<Double> prices = new ArrayList<Double>();
	// Arrays of XPaths for each box
	String[] sizeXPaths = { "//div[@class='swatch-opt-430']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-414']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-398']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-382']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-366']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-350']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-334']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-318']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-302']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-286']//div[@id='option-label-size-143-item-167']",
			"//div[@class='swatch-opt-270']//div[@id='option-label-size-143-item-167']" };

	String[] colorXPaths = { "//div[@class='swatch-opt-430']//div[@id='option-label-color-93-item-50']",
			"//div[@class='swatch-opt-414']//div[@id='option-label-color-93-item-53']",
			"//div[@class='swatch-opt-398']//div[@id='option-label-color-93-item-53']",
			"//div[@class='swatch-opt-382']//div[@id='option-label-color-93-item-53']",
			"//div[@class='swatch-opt-366']//div[@id='option-label-color-93-item-56']",
			"//div[@id='option-label-color-93-item-59']", "//div[@id='option-label-color-93-item-52']",
			"//div[@class='swatch-opt-318']//div[@id='option-label-color-93-item-58']",
			"//div[@class='swatch-opt-302']//div[@id='option-label-color-93-item-50']",
			"//div[@class='swatch-opt-286']//div[@id='option-label-color-93-item-56']",
			"//div[@class='swatch-opt-270']//div[@id='option-label-color-93-item-58']" };

	String[] addXPaths = { "//li[1]//form[1]//button[1]//span[1]", "//li[2]//form[1]//button[1]//span[1]",
			"//li[3]//form[1]//button[1]//span[1]", "//li[4]//form[1]//button[1]//span[1]",
			"//li[5]//form[1]//button[1]", "//li[6]//form[1]//button[1]//span[1]",
			"//li[7]//form[1]//button[1]//span[1]", "//li[8]//form[1]//button[1]//span[1]",
			"//li[9]//form[1]//button[1]//span[1]", "//li[10]//form[1]//button[1]//span[1]",
			"//li[11]//form[1]//button[1]//span[1]" };

	String[] boxXPaths = { "//div[@class='column main']//li[1]", "//div[@class='column main']//li[2]",
			"//div[@class='column main']//li[3]", "//div[@class='column main']//li[4]",
			"//div[@class='column main']//li[5]", "//div[@class='column main']//li[6]",
			"//div[@class='column main']//li[7]", "//div[@class='column main']//li[8]",
			"//div[@class='column main']//li[9]", "//div[@class='column main']//li[10]",
			"//div[@class='column main']//li[11]" };

	// xpath for the confirmation message
	By confirmationMessage = By.xpath("//div[@class='message-success success message']");
	// common x path for price
	By totalitems = By.xpath("//span[@class='counter-number']");
	// xpath for remove button
	By RemoveButton=By.xpath("//div//div//div[@class='product actions']//div[@class='secondary']");
	//steps to reach the cart page
	By cartIcon = By.xpath("//a[@class='action showcart']");
	By checkoutButton = By.xpath("//button[@id='top-cart-btn-checkout']");
	public int productSelected = 0;

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
			productSelected++;

			System.out.println("Box " + (index + 1) + " added to cart.");

		} catch (Exception e) {
			System.out.println("Failed to process Box " + (index + 1) + ": " + e.getMessage());
		}

	}
	// getting total number of items

	public int getitemSelected() {
		return productSelected;
	}

	// adding items to cart
	public void selectAllProductsAndAddToCart() {
		for (int i = 0; i < boxXPaths.length; i++) {
			selectAndAddProduct(i);
		}
	}

	// getting the total price for all the items
	public double getTotalPriceOfAllProducts() {
		double total = 0.0;

		List<WebElement> priceElements = driver
				.findElements(By.xpath("//span[@class='normal-price']//span[@class='price']"));

		for (WebElement priceEl : priceElements) {
			String priceText = priceEl.getText().replaceAll("[^\\d.]", ""); // Remove currency symbols, etc.
			if (!priceText.isEmpty()) {
				total += Double.parseDouble(priceText);
			}
		}

		return total;
	}

//	    getting the number of total of items added to the cart 
	public int getCartCount() throws InterruptedException {
		Thread.sleep(10000);
		WebElement totalItemsCount = driver.findElement(totalitems);
		int totalItems = Integer.parseInt(totalItemsCount.getText());
		return totalItems;
	}
	
	public boolean getStatusOfRemoveButton() {
		try {
		WebElement removebutton =driver.findElement(RemoveButton);
		return removebutton.isDisplayed();
		}
		catch(NoSuchElementException e){//try catch to handle the exception the element not found 
			System.out.println("Remove button not found:"+e.getMessage());
			return false;
		}
		
		
	}
	

	public void clickCheckout() {
		driver.findElement(cartIcon).click();
		//wait until checkout button is there to be clicked
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
		
	}

}