package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPageObject {
	public WebDriver driver;
	public WebDriverWait wait;

	public OfferPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private By offerPage = By.cssSelector("a[href*='offers']");
	private By search = By.id("search-field");
	private By searchProductName = By.cssSelector("tr>td:nth-of-type(1)");

	public void clickOfferPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(offerPage)).click();
	}

	public void searchItem(String productShortName) {
		driver.findElement(search).sendKeys(productShortName);
	}

	public String getSearchProductName(String productShortName) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(searchProductName, productShortName));
		String extractedName = wait.until(ExpectedConditions.visibilityOfElementLocated(searchProductName)).getText();
		return extractedName;
	}
}
