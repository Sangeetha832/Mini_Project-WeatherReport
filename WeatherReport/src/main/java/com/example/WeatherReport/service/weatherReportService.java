package com.example.WeatherReport.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherReportService {
	
	private final RestTemplate restTemplate = new RestTemplate();

    public JsonNode getCurrentWeather(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
                "&longitude=" + longitude + "&current_weather=true";

        try {
            return restTemplate.getForObject(url, JsonNode.class);
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
            return null;
	    }
	
    }
}
