package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

    public WebDriver driver;
    public WebDriverWait wait;

    public LandingPageObject landingPageObject;
    public OfferPageObject offerPageObject;
    public CheckOutPageObj checkOutPageObj;

    public PageObjectManager(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LandingPageObject getLandingPageObject() {
        if (landingPageObject == null) {
            landingPageObject = new LandingPageObject(driver, wait);
        }
        return landingPageObject;
    }

    public OfferPageObject getOfferPageObject() {
        if (offerPageObject == null) {
            offerPageObject = new OfferPageObject(driver, wait);
        }
        return offerPageObject;
    }
    
    public CheckOutPageObj getCheckOutPageObj() {
    	if(checkOutPageObj== null) {
    		checkOutPageObj = new CheckOutPageObj(driver,wait);
    	}
    	return checkOutPageObj;
    }
}
