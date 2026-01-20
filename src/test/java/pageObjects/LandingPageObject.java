package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObject {
	public WebDriver driver;
	public WebDriverWait wait;

	public LandingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private By search = By.cssSelector("form[method='get'] > .search-keyword");
	private By serachProductName = By.cssSelector("h4.product-name");
	private By increaseQuantity = By.cssSelector(".increment");
	private By addToCartButton = By.cssSelector(".product-action button");

	public void searchItem(String productShortName) {
		driver.findElement(search).sendKeys(productShortName);
	}

	public String getSearchProductName(String productShortName) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				serachProductName,
				productShortName));
		String extractedName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				serachProductName)).getText().split("-")[0].trim();
		return extractedName;
	}

	public void getIncreaseQuantity() {
		wait.until(ExpectedConditions.elementToBeClickable(increaseQuantity)).click();
	}

	public void addInAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
		;
	}

	public String getTitleLandingpage() {
		return driver.getTitle();
	}

}
