package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends  BasePage{

	public CheckoutPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}

	
		// TODO Auto-generated method stub
		
		By firstname= By.xpath("//input[@name='firstname']");
		By lastname=By.xpath("//input[@name='lastname']");
		By company=By.xpath("//input[@name='company']");
		//address streetline
		By streetaddressline1= By.xpath("//input[@name='street[0]']");
		By streetaddressline2= By.xpath("//input[@name='street[1]']");
		By streetaddressline3= By.xpath("//input[@name='street[2]']");
		//city
		By city= By.xpath("//input[@name='city']");
		//country
		By country= By.xpath("//select//option[@data-title=' "+p.getProperty("Country")+" ']");
		//state from the dropdown
    	By state=By.xpath("//select//option[@data-title='"+p.getProperty("State")+"']");
		//postcode
		By zipcode= By.xpath("//input[@name='postcode']");
		//phoneno
		By telephone= By.xpath("//input[@name='telephone']");
		
		//total price
		By totalprice =By.xpath("//span[@class='price']//span[@class='price']");
		
		
//		click next
		By nextbutton=By.xpath("//span[normalize-space()='Next']");
		
		
		
		public void fillPersonalDetails() {
			
			
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys(p.getProperty("FirstName"));
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(p.getProperty("LastName"));
		driver.findElement(lastname).sendKeys(p.getProperty("Email"));
		driver.findElement(company).sendKeys(p.getProperty("Company"));
		driver.findElement(lastname).sendKeys(p.getProperty("LastName"));
		driver.findElement(streetaddressline1).sendKeys(p.getProperty("AddressLine1"));
		driver.findElement(streetaddressline2).sendKeys(p.getProperty("AddressLine2"));
		driver.findElement(streetaddressline3).sendKeys(p.getProperty("AddressLine3"));
		
		By countryOption=By.xpath("//select//option[@data-title='"+p.getProperty("Country")+"']");
		wait.until(ExpectedConditions.elementToBeClickable(countryOption)).click();
		
		driver.findElement(By.xpath("//select//option[@data-title='"+p.getProperty("State")+"']")).click();
		driver.findElement(city).sendKeys(p.getProperty("City"));
		driver.findElement(zipcode).sendKeys(p.getProperty("Zipcode"));
		driver.findElement(telephone).sendKeys(p.getProperty("PhoneNo"));
		driver.findElement(nextbutton).click();
		
	}



		


	

}
