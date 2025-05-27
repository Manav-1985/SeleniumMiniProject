package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage extends BasePage{


	public FinalPage(WebDriver driver, Properties p)  {
		super(driver, p);
		// TODO Auto-generated constructor stub
	

	}

	By confmessage =By.xpath("//span[@class='base']");
	public String getOrderConfirmationMessage() {
		
		String actualmsg=driver.findElement(confmessage).getText();
		
		return actualmsg;
	}

}
