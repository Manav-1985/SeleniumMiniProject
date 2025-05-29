package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}
	//Locators
	By ordersummary= By.xpath("//div[@class='opc-block-summary']");
	By shippinginfo =By.xpath("//div[@class='ship-to']//div[@class='shipping-information-content']");
	By mastertotal =By.xpath("//table[@class='data table table-totals']//tbody//tr[3]//td//strong//span");
//	By shippingtotal=By.xpath("//tbody//tr[@class='totals shipping excl']//td[@class='amount']//span[@class='price']");
	By itemtotal=By.xpath("//table[@class='data table table-totals']//tbody//tr[1]//td//span");
	By btnplaceorder=By.xpath("//button[@title='Place Order']");
	By billingSameAsShippingCheckbox = By.xpath("//*[@id='billing-address-same-as-shipping-checkmo']");
	//Methods
	public boolean isOrderSummaryDisplayed() {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ordersummary)));
			return driver.findElement(ordersummary).isDisplayed();
	}	



	public boolean isShippingInfoDisplayed() {
		return driver.findElement(ordersummary).isDisplayed();
		
	}

	public boolean isTotalPriceDisplayed() {
		// TODO Auto-generated method stub
		return driver.findElement(mastertotal).isDisplayed();
	}



//	public double getMasterTotal() {
//	 String totalPriceText =driver.findElement(mastertotal).getText().replaceAll("[^\\d.]", "");
//		if(totalPriceText.isEmpty()) {
//			 throw new RuntimeException("Item total String not found or could not be parsed.");
//		}
//		Double totalprice=Double.parseDouble(totalPriceText);
//		return totalprice;
//		
//	}
//	public double getShippingTotal() {
//		String shippingPriceText =driver.findElement(shippingtotal).getText().replaceAll("[^\\d.]", "");
//		Double shippingprice=Double.parseDouble(shippingPriceText);
//		return shippingprice;
//	}
	
	public double getItemsTotal() {
		String itemsPriceText =driver.findElement(itemtotal).getText().replaceAll("[^\\d.]", "");
		Double itemstotalprice=Double.parseDouble(itemsPriceText);
		return itemstotalprice;
	}
	
	public WebElement clickPlaceOrder() {
		WebElement Placeorder=driver.findElement(btnplaceorder);
		return Placeorder;
	}
	
	public void checkBillingSameAsShipping() throws InterruptedException {

		//Wait until payment info block is visible to ensure payment page is loaded
//		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentinfo));
        Thread.sleep(5000);
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(billingSameAsShippingCheckbox));

		if (!checkbox.isSelected()) {
			System.out.println("Checkbox is not selected. Clicking it.");
			checkbox.click();
		} else {
			System.out.println("Checkbox is already selected.");
		}
	}


}
