package com.koqonut.weather;

import com.koqonut.weather.services.OpenWeatherMapProvider;
import com.koqonut.weather.services.WeatherProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public WeatherProvider weatherProvider(){
		String key = System.getenv("OPEN_WEATHER_API_KEY");
		if(!StringUtils.hasText(key)){
			log.info("could not retrieve key. Using hardcoded key");
			key ="1daf44beffaacc0fa5826e2e49b2216c";

		}
		return new OpenWeatherMapProvider(key);
	}

}
