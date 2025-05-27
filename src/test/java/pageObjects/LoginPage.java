package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	
	public LoginPage(WebDriver driver, Properties p) {
		super(driver, p);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement txtPwd;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement btnSignin;
	
	

	public void login() {
		// TODO Auto-generated method stub
		txtEmail.sendKeys(p.getProperty("Email"));	
		txtPwd.sendKeys(p.getProperty("Password"));
		btnSignin.click();
	}
}
