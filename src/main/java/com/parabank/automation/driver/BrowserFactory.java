package com.parabank.automation.driver;

import com.parabank.automation.enums.BrowserType;
import com.parabank.automation.exceptions.DriverInitializationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class BrowserFactory {

	private BrowserFactory() {
	}

	public static WebDriver createDriver(BrowserType browserType) {
		switch (browserType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(BrowserOptionsFactory.getChromeOptions());

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(BrowserOptionsFactory.getFirefoxOptions());

		case EDGE:
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver(BrowserOptionsFactory.getEdgeOptions());

		default:
			throw new DriverInitializationException("Unsupported browser type: " + browserType);
		}
	}
}