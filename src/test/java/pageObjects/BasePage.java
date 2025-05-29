package pageObjects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	    protected WebDriver driver;
	    protected Properties p;
	    protected Actions action;
	    protected WebDriverWait wait;

	    // Constructor
	    public BasePage(WebDriver driver, Properties p) {
	        this.driver = driver;
	        this.p = p;
	        this.action = new Actions(driver);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    
	}
