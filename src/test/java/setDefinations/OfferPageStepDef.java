package setDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OfferPageObject;

import utils.TestContextSetup;

public class OfferPageStepDef {
	// String LandingPageProductName;
	String OfferPageProductName;
	OfferPageObject offp;
	TestContextSetup testContextSetup;

	public OfferPageStepDef(TestContextSetup TestContextSetup) {
		// this.driver = Hooks.driver; // Now driver will be initialized after Hooks
		// runs

		this.testContextSetup = TestContextSetup;
		this.offp = testContextSetup.pageObjectManager.getOfferPageObject();

	}

	@Then("User search with same short name {string} in offer page if product exist")
	public void offerpage_product_page(String productShortName) {

		String parent = testContextSetup.driver.getWindowHandle();

		offp.clickOfferPage();
		// Set<String> handles = driver.getWindowHandles();
		// Iterator<String> it = handles.iterator();
		// String parentWindow = it.next();
		// String childWindow = it.next();

		// driver.switchTo().window(childWindow);
		testContextSetup.genericUtils.switchToChildWindow(parent);
		offp.searchItem(productShortName);
		String extractedName = offp.getSearchProductName(productShortName);

		OfferPageProductName = extractedName;
		System.out.println("Extracted product: " + extractedName);
	}

	@Then("Validate if product name in landing and offer page is same")
	public void validate_names() {
		Assert.assertEquals(OfferPageProductName, testContextSetup.LandingPageProductName);
	}

}
