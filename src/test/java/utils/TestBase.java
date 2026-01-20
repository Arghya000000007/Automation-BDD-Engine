package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private WebDriver driver;

	public WebDriver webDrivermanager(String browserName) {
		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome")) { // <-- Use actual browser name
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else {
				throw new RuntimeException("Browser not supported: " + browserName);
			}
			try {
				driver.manage().window().maximize();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("driver setup");
		}

		return driver;
	}

	public void tearDownDriver() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed successfully");
		}
	}
}
