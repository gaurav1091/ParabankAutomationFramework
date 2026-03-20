package com.parabank.automation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private JsonUtils() {
	}

	public static <T> T readJsonFromFile(String filePath, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(new File(filePath), clazz);
		} catch (IOException exception) {
			throw new RuntimeException("Failed to read JSON file: " + filePath, exception);
		}
	}

	public static <T> T readJsonFromFile(String filePath, TypeReference<T> typeReference) {
		try {
			return OBJECT_MAPPER.readValue(new File(filePath), typeReference);
		} catch (IOException exception) {
			throw new RuntimeException("Failed to read JSON file: " + filePath, exception);
		}
	}
}