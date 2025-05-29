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

	By confmessage =By.xpath("//div//h1[@class='page-title']//span[@class='base']");

	public String getOrderConfirmationMessage() {
		WebElement msg = driver.findElement(confmessage);
		wait.until(ExpectedConditions.visibilityOf(msg));

		// Normalize whitespace and remove special invisible characters
		String actualmsg = msg.getText().replace("\u00A0", " ") // non-breaking space
				.replaceAll("\\s+", " ") // multiple spaces to one
				.trim();

		System.out.println("Actual Message: '" + actualmsg + "'");
		return actualmsg;
	}

}
