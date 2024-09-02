package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Motivation;

public class ApiCall {

	Random random = new Random();
	
	private final String BASE_URL = "http://localhost:3000/" + random.nextInt(0,31);
	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;
	HttpResponse<String> httpResponse;
	Motivation motivation;
	
	public ApiCall() {
		httpClient = HttpClient.newHttpClient(); 
		objectMapper = new ObjectMapper();
	}

	public Motivation getData() {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(BASE_URL))
			.GET()
			.build();
		
		
		try {
			httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.getLocalizedMessage();
		}
		
		if(httpResponse == null) {
			return null;
		}
		
		try {
			motivation = objectMapper.readValue(httpResponse.body(),Motivation.class);
		} catch (JsonProcessingException e) {
			e.getLocalizedMessage();
		}
		
		return motivation;
	}
}
