package pageObjects;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	By nxtbtn =By.cssSelector("button[data-role='opc-continue']");

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
		System.out.println("Clicking Next button...");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(nxtbtn)).click();


		




	}
}