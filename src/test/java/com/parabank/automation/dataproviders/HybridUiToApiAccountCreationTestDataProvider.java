package com.parabank.automation.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.parabank.automation.models.HybridUiToApiAccountCreationTestData;

import java.util.List;

public final class HybridUiToApiAccountCreationTestDataProvider {

	private static final String FILE_PATH = "src/test/resources/testdata/hybridUiToApiAccountCreation.json";

	private HybridUiToApiAccountCreationTestDataProvider() {
	}

	public static HybridUiToApiAccountCreationTestData getByKey(String key) {
		return TestDataProvider.getTestDataByKey(FILE_PATH,
				new TypeReference<List<HybridUiToApiAccountCreationTestData>>() {
				}, HybridUiToApiAccountCreationTestData::getKey, key);
	}
}