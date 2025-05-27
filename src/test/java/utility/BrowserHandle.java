package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserHandle {

	public static WebDriver driver;
	public static Properties p;

	public BrowserHandle() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

		FileInputStream file = new FileInputStream(path);
		p = new Properties();
		p.load(file);

		// selecting the browser
		String browsername = p.getProperty("BrowserName");

		switch (browsername.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Browser Not Supported");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static WebDriver getDriver() {
		return driver;

	}

}
