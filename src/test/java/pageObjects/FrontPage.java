package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FrontPage extends BasePage {

	
	public FrontPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
	//Elements
//	WebElement Signin=driver.findElement(By.xpath("//div[@data-ui-id='page-title-wrapper']//h1//span[text()='Thank you for your purchase!']"));

	public void clickSignIn() {
		WebElement Signin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign In')]")));
		Signin.click();
	}
}
