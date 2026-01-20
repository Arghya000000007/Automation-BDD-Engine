package setDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPageObj;
import utils.TestContextSetup;

public class ChcekOutPagePageStepDef {
	// public static String LandingPageProductName;
	TestContextSetup testContextSetup;
	CheckOutPageObj cp;

	public ChcekOutPagePageStepDef(TestContextSetup TestContextSetup) {
		// this.driver = Hooks.driver; // Now driver will be initialized after Hooks
		// runs
		this.testContextSetup = TestContextSetup;
		this.cp = testContextSetup.pageObjectManager.getCheckOutPageObj();
	}

	@Then("User proceeds to checkout and validate the {string} items in checkout page")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String productShortName) {
		// Write code here that turns the phrase above into concrete actions

		cp.goToCart();
		cp.proceedCheckOut();

		String parent = testContextSetup.driver.getWindowHandle();
		testContextSetup.genericUtils.switchToChildWindow(parent);

		String productFullName = cp.getSearchProductName(productShortName);
		Assert.assertTrue(
				productFullName.contains(productShortName));

	}

	@And("Verify user has ability to use promo code and plcae the order")
	public void verify_user_has_ability_to_use_promo_code_and_plcae_the_order() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cp.searchInputPromo("PROMO123");
		cp.applyPromoBtn();
		Thread.sleep(2000);
		cp.applyPlacedOrder();

		cp.getChooseCountry();
		cp.getSelectAgree();
		cp.getProceed();
		Thread.sleep(2000);
	}

}
