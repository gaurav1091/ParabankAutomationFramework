package com.parabank.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/ui", glue = { "com.parabank.automation.stepdefinitions.ui",
		"com.parabank.automation.hooks" }, plugin = { "pretty",
				"summary" }, tags = "@ui and not @quarantined and not @manual", monochrome = true, publish = false)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true, name = "scenarios")
	public Object[][] scenarios() {
		return super.scenarios();
	}
}