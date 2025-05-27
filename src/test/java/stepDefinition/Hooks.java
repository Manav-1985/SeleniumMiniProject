package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import utility.BrowserHandle;

public class Hooks {
	WebDriver driver;
	Properties p;

	@Before
	public void setup() throws IOException {
		new BrowserHandle();
		driver = BrowserHandle.getDriver();
		p=BrowserHandle.p;
		driver.get(p.getProperty("BaseUrl"));

	}

}
