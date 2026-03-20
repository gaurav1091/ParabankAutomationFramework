package com.parabank.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.parabank.automation.stepdefinitions.ui",
		"com.parabank.automation.stepdefinitions.api", "com.parabank.automation.stepdefinitions.hybrid",
		"com.parabank.automation.hooks" }, plugin = { "pretty",
				"summary" }, tags = "@regression and not @quarantined and not @manual", monochrome = true, publish = false)
public class RegressionTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}