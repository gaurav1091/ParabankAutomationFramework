package com.parabank.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/api", glue = { "com.parabank.automation.stepdefinitions.api",
		"com.parabank.automation.hooks" }, plugin = { "pretty",
				"summary" }, tags = "@api and not @manual", monochrome = true, publish = false)
public class ApiTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}