package com.parabank.automation.hooks;

import com.parabank.automation.config.ConfigManager;
import com.parabank.automation.driver.DriverFactory;
import com.parabank.automation.reports.ExtentManager;
import com.parabank.automation.reports.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.stream.Collectors;

public class __ExistingTestHooksAdapter {

	@Before(order = 0)
	public void startScenarioReport(Scenario scenario) {
		ExtentTestManager.setTest(ExtentManager.getInstance().createTest(scenario.getName()));

		ExtentTestManager.info("Scenario execution started.");
		ExtentTestManager.info("Thread ID: " + Thread.currentThread().getId());
		ExtentTestManager.info("Browser: " + ConfigManager.getInstance().getBrowser());
		ExtentTestManager
				.info("Environment: " + com.parabank.automation.config.EnvironmentManager.getCurrentEnvironment());
		ExtentTestManager.info("Base URL: " + ConfigManager.getInstance().getBaseUrl());

		Collection<String> tags = scenario.getSourceTagNames();
		if (tags != null && !tags.isEmpty()) {
			String joinedTags = tags.stream().sorted().collect(Collectors.joining(", "));
			ExtentTestManager.info("Scenario Tags: " + joinedTags);
		} else {
			ExtentTestManager.info("Scenario Tags: None");
		}
	}

	@Before(order = 1)
	public void setUp(Scenario scenario) {
		WebDriver driver = DriverFactory.initializeDriver();
		driver.get(ConfigManager.getInstance().getBaseUrl());
		ExtentTestManager.info("Application launched successfully.");
	}

	@After(order = 1)
	public void updateScenarioStatus(Scenario scenario) {
		String sanitizedScenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_");

		if (scenario.isFailed()) {
			ExtentTestManager.fail("Scenario failed: " + scenario.getName());
			ExtentTestManager.captureAndAttachFailureScreenshot("scenario_failure_" + sanitizedScenarioName);
		} else {
			ExtentTestManager.pass("Scenario passed: " + scenario.getName());
			ExtentTestManager.captureAndAttachPassScreenshot("scenario_pass_" + sanitizedScenarioName);
		}
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {
		DriverFactory.quitDriver();
		ExtentTestManager.unload();
	}
}