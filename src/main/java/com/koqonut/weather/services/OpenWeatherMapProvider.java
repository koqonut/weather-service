package com.koqonut.weather.services;

import java.util.Optional;

import com.koqonut.weather.model.WeatherData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OpenWeatherMapProvider implements WeatherProvider {
    private final String apiKey;
    private final String apiBase = "https://api.openweathermap.org/data/2.5/weather?";
    private final String queryByCity = "https://api.openweathermap.org/data/2.5/weather?q=";
   // private final String apiForecast = "http://api.openweathermap.org/data/2.5/forecast?q=";

    @Autowired
    private RestTemplate restTemplate;

    public OpenWeatherMapProvider(String key) {
        this.apiKey = key;
    }

    @Override
    public Optional<WeatherData> getWeather(String latitude, String longitude) {
        if(!StringUtils.hasText(latitude) || !StringUtils.hasText(longitude)){
            throw new IllegalArgumentException("Lattitude "+ latitude +" and longitude "+ longitude+" cannot be empty");
        }
        StringBuilder sb = new StringBuilder(apiBase);
        sb.append("lat=").append(latitude).append("&lon=").append(longitude).append("&appid=").append(apiKey);

        String query = sb.toString();

        try {
            log.info("Quering {}", sb.toString());
            ResponseEntity<WeatherData> response = restTemplate.getForEntity(query, WeatherData.class);
            log.info("Query response header {} , body {}", response.getHeaders(), response.getBody());
            return Optional.of(response.getBody());

        } catch (Exception ex) {
            log.error("error querrying {}", ex);
        }

        return Optional.empty();
    }

    public Optional<WeatherData> getWeather(String city) {

        if(!StringUtils.hasText(city)){
            throw new IllegalArgumentException("City cannot be empty");
        }

        StringBuilder sb = new StringBuilder(queryByCity);
        sb.append(city).append("&appid=").append(apiKey);

        String query = sb.toString();

        try {
            log.info("Quering {}", sb.toString());
            ResponseEntity<WeatherData> response = restTemplate.getForEntity(query, WeatherData.class);
            log.info("Query response header {} , body {}", response.getHeaders(), response.getBody());
            return Optional.of(response.getBody());

        } catch (Exception ex) {
            log.error("error querrying {}", ex);
        }

        return Optional.empty();
    }
}