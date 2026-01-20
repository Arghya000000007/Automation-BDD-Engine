package io.cucumberr.Cucumber_project_1;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/rerun.txt", glue = { "setDefinations",
		"Hooks" }, plugin = { "pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class Failed_scenarios extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
