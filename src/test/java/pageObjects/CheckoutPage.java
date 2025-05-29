//package pageObjects;
//
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class CheckoutPage extends  BasePage{
//
//	public CheckoutPage(WebDriver driver, Properties p) {
//		super(driver, p);
//		// TODO Auto-generated constructor stub
//	}
//
//	
//		// TODO Auto-generated method stub
//		
//		By firstname= By.xpath("//input[@name='firstname']");
//		By lastname=By.xpath("//input[@name='lastname']");
//		By company=By.xpath("//input[@name='company']");
//		//address streetline
//		By streetaddressline1= By.xpath("//input[@name='street[0]']");
//		By streetaddressline2= By.xpath("//input[@name='street[1]']");
//		By streetaddressline3= By.xpath("//input[@name='street[2]']");
//		//city
//		By city= By.xpath("//input[@name='city']");
//		//country
//		By country= By.xpath("//select//option[@data-title=' "+p.getProperty("Country")+" ']");
//		//state from the dropdown
//    	By state=By.xpath("//select//option[@data-title='"+p.getProperty("State")+"']");
//		//postcode
//		By zipcode= By.xpath("//input[@name='postcode']");
//		//phoneno
//		By telephone= By.xpath("//input[@name='telephone']");
//		
//		//total price
//		By totalprice =By.xpath("//span[@class='price']//span[@class='price']");
//		
//		
////		click next
//		By nextbutton=By.xpath("//span[normalize-space()='Next']");
//		
//		
//		
//		public void fillPersonalDetails() {
//			
//			
//		driver.findElement(firstname).clear();
//		driver.findElement(firstname).sendKeys(p.getProperty("FirstName"));
//		driver.findElement(lastname).clear();
//		driver.findElement(lastname).sendKeys(p.getProperty("LastName"));
//		driver.findElement(lastname).sendKeys(p.getProperty("Email"));
//		driver.findElement(company).sendKeys(p.getProperty("Company"));
//		driver.findElement(lastname).sendKeys(p.getProperty("LastName"));
//		driver.findElement(streetaddressline1).sendKeys(p.getProperty("AddressLine1"));
//		driver.findElement(streetaddressline2).sendKeys(p.getProperty("AddressLine2"));
//		driver.findElement(streetaddressline3).sendKeys(p.getProperty("AddressLine3"));
//		
//		By countryOption=By.xpath("//select//option[@data-title='"+p.getProperty("Country")+"']");
//		wait.until(ExpectedConditions.elementToBeClickable(countryOption)).click();
//		
//		driver.findElement(By.xpath("//select//option[@data-title='"+p.getProperty("State")+"']")).click();
//		driver.findElement(city).sendKeys(p.getProperty("City"));
//		driver.findElement(zipcode).sendKeys(p.getProperty("Zipcode"));
//		driver.findElement(telephone).sendKeys(p.getProperty("PhoneNo"));
//		driver.findElement(nextbutton).click();
//		
//	}	
//
//}

package pageObjects;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver, Properties p) {
		super(driver, p);
	}

	// Locators
	By firstname = By.xpath("//input[@name='firstname']");
	By lastname = By.xpath("//input[@name='lastname']");
	By company = By.xpath("//input[@name='company']");
	By streetaddressline1 = By.xpath("//input[@name='street[0]']");
	By streetaddressline2 = By.xpath("//input[@name='street[1]']");
	By streetaddressline3 = By.xpath("//input[@name='street[2]']");
	By city = By.xpath("//input[@name='city']");
	By zipcode = By.xpath("//input[@name='postcode']");
	By telephone = By.xpath("//input[@name='telephone']");
	//By nextbutton = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button");

	// Helper method to fill a field
	private void fillField(By locator, String fieldName, String value) {
		System.out.println("Waiting for " + fieldName + " field to be visible...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Filling " + fieldName + " with value: " + value);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public void fillPersonalDetails() throws InterruptedException {
		fillField(firstname, "First Name", p.getProperty("FirstName"));
		fillField(lastname, "Last Name", p.getProperty("LastName"));
		fillField(company, "Company", p.getProperty("Company"));
		fillField(streetaddressline1, "Address Line 1", p.getProperty("AddressLine1"));
		fillField(streetaddressline2, "Address Line 2", p.getProperty("AddressLine2"));
		fillField(streetaddressline3, "Address Line 3", p.getProperty("AddressLine3"));
		fillField(city, "City", p.getProperty("City"));
		fillField(zipcode, "Zipcode", p.getProperty("Zipcode"));
		fillField(telephone, "Phone No", p.getProperty("PhoneNo"));

		// Select country and state using dynamic locators
		By countryOption = By.xpath("//select//option[@data-title='" + p.getProperty("Country") + "']");
		System.out.println("Waiting for Country option to be clickable...");
		wait.until(ExpectedConditions.elementToBeClickable(countryOption)).click();

		By stateOption = By.xpath("//select//option[@data-title='" + p.getProperty("State") + "']");
		System.out.println("Waiting for State option to be clickable...");
		wait.until(ExpectedConditions.elementToBeClickable(stateOption)).click();

		// Click on Next

	
			
		
		By nextButton = By.cssSelector("button[data-role='opc-continue']");

		System.out.println("Clicking Next button...");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();


		//wait.until(ExpectedConditions.elementToBeClickable(nextbutton)).click();

		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='billing-address-same-as-shipping-checkmo']"))).click();






	}
}