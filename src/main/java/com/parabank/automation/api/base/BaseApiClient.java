package com.parabank.automation.api.base;

import com.parabank.automation.config.ConfigManager;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class BaseApiClient {

	private final HttpClient httpClient;

	public BaseApiClient() {
		this.httpClient = ApiRequestSpecification.buildHttpClient();
	}

	protected HttpResponse<String> sendGet(String relativePath) {
		return sendGet(relativePath, null);
	}

	protected HttpResponse<String> sendGet(String relativePath, Map<String, String> headers) {
		HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
				.uri(ApiRequestSpecification.buildUri(relativePath))
				.timeout(Duration.ofSeconds(ConfigManager.getInstance().getApiReadTimeoutSeconds())).GET();

		if (headers != null && !headers.isEmpty()) {
			headers.forEach((key, value) -> {
				if (key != null && value != null && !value.trim().isEmpty()) {
					requestBuilder.header(key, value);
				}
			});
		}

		HttpRequest request = requestBuilder.build();

		try {
			return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException exception) {
			throw new RuntimeException("GET API call failed for path: " + relativePath, exception);
		} catch (InterruptedException exception) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("GET API call interrupted for path: " + relativePath, exception);
		}
	}
}