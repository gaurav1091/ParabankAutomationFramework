package com.parabank.automation.config;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	public static final String CONFIG_FILE_PATH = "src/test/resources/config/";
	public static final String FRAMEWORK_CONFIG_FILE = "framework.properties";

	public static final String QA_CONFIG_FILE = "qa.properties";
	public static final String STAGE_CONFIG_FILE = "stage.properties";
	public static final String DEV_CONFIG_FILE = "dev.properties";

	public static final String REPORTS_FOLDER = "test-output/reports/";
	public static final String SCREENSHOTS_FOLDER = "test-output/screenshots/";

	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String EDGE = "edge";

	public static final int DEFAULT_EXPLICIT_WAIT = 20;
	public static final int DEFAULT_IMPLICIT_WAIT = 5;
	public static final int DEFAULT_PAGE_LOAD_TIMEOUT = 30;
	public static final int DEFAULT_SCRIPT_TIMEOUT = 30;

	public static final int DEFAULT_SMART_WAIT_POLLING_MILLIS = 500;
	public static final int DEFAULT_RESILIENT_FIND_RETRIES = 2;
	public static final int DEFAULT_RESILIENT_FIND_DELAY_MILLIS = 300;

	public static final int DEFAULT_API_CONNECT_TIMEOUT_SECONDS = 15;
	public static final int DEFAULT_API_READ_TIMEOUT_SECONDS = 30;
}