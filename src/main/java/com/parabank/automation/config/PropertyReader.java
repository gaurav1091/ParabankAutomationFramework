package com.parabank.automation.config;

import com.parabank.automation.exceptions.ConfigFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {

	private PropertyReader() {
	}

	public static Properties loadProperties(String filePath) {
		Properties properties = new Properties();

		try (InputStream inputStream = new FileInputStream(filePath)) {
			properties.load(inputStream);
		} catch (IOException exception) {
			throw new ConfigFileException("Unable to load properties file: " + filePath, exception);
		}

		return properties;
	}
}