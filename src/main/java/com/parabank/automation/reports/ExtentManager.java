package com.parabank.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.parabank.automation.config.ConfigManager;
import com.parabank.automation.config.EnvironmentManager;

public final class ExtentManager {

	private static volatile ExtentReports extentReports;
	private static String reportFilePath;

	private ExtentManager() {
	}

	public static ExtentReports getInstance() {
		if (extentReports == null) {
			synchronized (ExtentManager.class) {
				if (extentReports == null) {
					extentReports = createInstance();
				}
			}
		}
		return extentReports;
	}

	private static ExtentReports createInstance() {
		reportFilePath = ReportPathManager.getReportFilePath();

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
		sparkReporter.config().setReportName("ParaBank Automation Execution Report");
		sparkReporter.config().setDocumentTitle("ParaBank Automation Report");
		sparkReporter.config().setTimeStampFormat("dd MMM yyyy HH:mm:ss");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Framework", "Selenium Java Cucumber TestNG");
		extent.setSystemInfo("Environment", EnvironmentManager.getCurrentEnvironment());
		extent.setSystemInfo("Browser", ConfigManager.getInstance().getBrowser());
		extent.setSystemInfo("Headless", String.valueOf(ConfigManager.getInstance().isHeadless()));
		extent.setSystemInfo("Parallel Mode", ConfigManager.getInstance().getParallelMode());
		extent.setSystemInfo("Thread Count", String.valueOf(ConfigManager.getInstance().getThreadCount()));
		extent.setSystemInfo("Data Provider Thread Count",
				String.valueOf(ConfigManager.getInstance().getDataProviderThreadCount()));
		extent.setSystemInfo("Base URL", ConfigManager.getInstance().getBaseUrl());

		return extent;
	}

	public static String getReportFilePath() {
		return reportFilePath;
	}

	public static void flushReport() {
		if (extentReports != null) {
			synchronized (ExtentManager.class) {
				if (extentReports != null) {
					extentReports.flush();
					ReportPathManager.copyAsLatestReport(reportFilePath);
				}
			}
		}
	}
}