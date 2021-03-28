package com.koqonut.weather;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.koqonut.weather.services.OpenWeatherMapProvider;
import com.koqonut.weather.services.WeatherProvider;

import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class WeatherServiceApplication {

	@Value("${OPEN_WEATHER_MAP_API_KEY}")
	private String apiKey;

	@Value("${OPEN_WEATHER_MAP_API_KEY}")
	private byte[] apiKeybytes;

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



	@Bean
	public WeatherProvider weatherProvider(){
		log.info("OPEN_WEATHER_MAP_API_KEY  key {}",apiKey);

		if(!StringUtils.hasText(apiKey)){
			apiKey =System.getenv("OPEN_WEATHER_MAP_API_KEY");
			log.info("could not retrieve key. Using hardcoded key {}.",apiKey);
		}
		return new OpenWeatherMapProvider(apiKey);
	}

}
