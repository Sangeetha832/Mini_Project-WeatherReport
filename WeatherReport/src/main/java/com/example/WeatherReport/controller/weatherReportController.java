package com.example.WeatherReport.controller;

import com.example.WeatherReport.service.weatherReportService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherReportController {
	   
	
	@Autowired
	private weatherReportService weatherService;

	@GetMapping("/weather")
    public JsonNode getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        JsonNode weatherData = weatherService.getCurrentWeather(latitude, longitude);
        if (weatherData != null) {
            return weatherData;
        }
        return JsonNodeFactory.instance.nullNode();
	}

}
