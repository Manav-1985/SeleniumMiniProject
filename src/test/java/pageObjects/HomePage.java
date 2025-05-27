package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}

	
	//Element
	@FindBy(xpath = "//span[normalize-space()='Men']")
	WebElement btnMen ;
	@FindBy(xpath = "//a[@id='ui-id-17']//span[contains(text(),'Tops')]")
	WebElement btnTops  ;
	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')] ")
	WebElement btnJackets ;
	
	//Action
	 public void navigateToMenJackets() {
		// TODO Auto-generated method stub
		 action.moveToElement(btnMen).perform();
		 action.moveToElement(btnTops).perform();
		 action.moveToElement(btnJackets).click().perform();
	 }
	
	
	
	
	
}
