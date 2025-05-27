package stepDefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import utility.BrowserHandle;

public class Hooks {
	WebDriver driver;
	Properties p;

	@Before
	public void setup() {
		driver = BrowserHandle.getDriver();
		driver.get(p.getProperty("BaseUrl"));

	}

}
