package com.parabank.automation.driver;

import com.parabank.automation.config.ConfigManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class BrowserOptionsFactory {

	private static final String WINDOW_SIZE = "--window-size=1920,1080";

	private BrowserOptionsFactory() {
	}

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		options.addArguments(WINDOW_SIZE);

		if (shouldUseHeadlessMode()) {
			options.addArguments("--headless=new");
		} else {
			options.addArguments("--start-maximized");
		}

		if (isGitHubActionsLinuxEnvironment()) {
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
		}

		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();

		if (shouldUseHeadlessMode()) {
			options.addArguments("--headless");
		}

		options.addArguments("--width=1920");
		options.addArguments("--height=1080");

		return options;
	}

	public static EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();

		options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		options.addArguments(WINDOW_SIZE);

		if (shouldUseHeadlessMode()) {
			options.addArguments("--headless=new");
		} else {
			options.addArguments("--start-maximized");
		}

		if (isGitHubActionsLinuxEnvironment()) {
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
		}

		return options;
	}

	private static boolean shouldUseHeadlessMode() {
		return ConfigManager.getInstance().isHeadless() || isGitHubActionsLinuxEnvironment();
	}

	private static boolean isGitHubActionsLinuxEnvironment() {
		String githubActions = System.getenv("GITHUB_ACTIONS");
		String operatingSystem = System.getProperty("os.name", "").toLowerCase();

		return "true".equalsIgnoreCase(githubActions) && operatingSystem.contains("linux");
	}
}