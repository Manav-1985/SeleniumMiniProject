package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalPage extends BasePage{


	public FinalPage(WebDriver driver, Properties p)  {
		super(driver, p);
		// TODO Auto-generated constructor stub
	

	}

	By confmessage =By.xpath("//span[@class='base'and contains(text(),'Thank')]");
	public String getOrderConfirmationMessage() {
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confmessage));
		String actualmsg=message.getText();
		
		return actualmsg;
	}

}
