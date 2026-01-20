package setDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPageObj;
import pageObjects.LandingPageObject;
import utils.TestContextSetup;

public class LandingPageStepDef {
	// public static String LandingPageProductName;
	TestContextSetup testContextSetup;
	LandingPageObject lp;
	CheckOutPageObj cp;

	public LandingPageStepDef(TestContextSetup TestContextSetup) {
		// this.driver = Hooks.driver; // Now driver will be initialized after Hooks
		// runs
		this.testContextSetup = TestContextSetup;
		this.lp = testContextSetup.pageObjectManager.getLandingPageObject();

	}

	@Given("User on website home page")
	public void homePage() {
		// testContextSetup.driver = new ChromeDriver();
		// try {
		// testContextSetup.driver.manage().window().maximize();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("driver setup");
		// testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Now create Landing Page object
		// testContextSetup.initializeDriverAndPages();

		testContextSetup.driver.get(testContextSetup.configFileReader.getUrl());

		System.out.println(lp.getTitleLandingpage() + " Home Page launched");

	}

	@When("User search with shortName {string} and extracted actual name of product")
	public void homepage_product_serach(String productShortName) {
		// search

		lp.searchItem(productShortName);
		// Thread.sleep(1000);

		String extractedName = lp.getSearchProductName(productShortName);
		testContextSetup.LandingPageProductName = extractedName;
		System.out.println("Extracted product: " + extractedName);
	}

	@And("Add {string} items of selected product to cart")
	public void add_selected_product_quantity(String quantity) {
		int q = Integer.parseInt(quantity);
		for (int i = 0; i < q - 1; i++) {
			lp.getIncreaseQuantity();
		}
		System.out.printf("Increased quantity");
		lp.addInAddToCart();
	}

}
