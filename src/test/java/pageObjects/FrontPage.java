package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FrontPage extends BasePage {

	
	public FrontPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}


	//Elements
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement Signin;

	public void clickSignIn() {
		// TODO Auto-generated method stub
		Signin.click();
	}
}
