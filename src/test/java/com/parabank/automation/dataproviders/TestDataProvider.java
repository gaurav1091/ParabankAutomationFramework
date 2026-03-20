package com.parabank.automation.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.function.Function;

public final class TestDataProvider {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private TestDataProvider() {
	}

	public static <T> T getTestDataByKey(String filePath, TypeReference<List<T>> typeReference,
			Function<T, String> keyExtractor, String key) {
		List<T> dataList = readList(filePath, typeReference);

		return dataList.stream().filter(data -> keyExtractor.apply(data).equalsIgnoreCase(key)).findFirst().orElseThrow(
				() -> new RuntimeException("No test data found for key: " + key + " in file: " + filePath));
	}

	public static <T> List<T> readList(String filePath, TypeReference<List<T>> typeReference) {
		try {
			return OBJECT_MAPPER.readValue(new File(filePath), typeReference);
		} catch (Exception exception) {
			throw new RuntimeException("Failed to read test data file: " + filePath, exception);
		}
	}
}