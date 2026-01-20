package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPageObj {
	public WebDriver driver;
	public WebDriverWait wait;

	public CheckOutPageObj(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private By cart = By.cssSelector(".cart-icon img[alt='Cart']");
	private By checkOut = By
			.xpath("//div[@id='root']/div[@class='container']/header/div[@class='container']//button[@type='button']");
	private By productName = By.cssSelector(".product-name");
	private By searchPromo = By.cssSelector(".promoCode");
	private By promoBtn = By.cssSelector(".promoBtn");
	// private By placedOrder =
	// By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']//button[.='Place
	// Order']");
	private By placedOrder = By.xpath("//button[contains(text(),'Place Order')]");
	private By chooseCountry = By.cssSelector("select");
	private By selectAgree = By.cssSelector(".chkAgree");
	// private By proceed =
	// By.xpath("//div[@id='root']/div[@class='container']//div[@class='wrapperTwo']/button[.='Proceed']");
	private By proceed = By.xpath("//button[contains(text(),'Proceed')]");

	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
	}

	public void proceedCheckOut() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOut)).click();
	}

	public String getSearchProductName(String shortName) {
		String fullProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText()
				.split("-")[0].trim();
		return fullProductName;
	}

	public void searchInputPromo(String search) {
		WebElement promoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchPromo));
		promoInput.sendKeys(search);
	}

	public void applyPromoBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(promoBtn)).click();
	}

	public void applyPlacedOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(placedOrder)).click();
	}

	public void getChooseCountry() {
		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(chooseCountry));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText("India");
	}

	public void getSelectAgree() {
		wait.until(ExpectedConditions.elementToBeClickable(selectAgree)).click();
	}

	public void getProceed() {
		wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();
	}

}
