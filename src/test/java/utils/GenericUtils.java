package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToChildWindow(String parent) {
		for (String window : driver.getWindowHandles()) {
			if (!window.equalsIgnoreCase(parent)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
	}
}
