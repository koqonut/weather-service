package com.koqonut.weather;

import com.koqonut.weather.services.OpenWeatherMapProvider;
import com.koqonut.weather.services.WeatherProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.secretmanager.SecretManagerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class WeatherServiceApplication {

	@Value("$apiKey")
	private String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



	@Bean
	public WeatherProvider weatherProvider(){
		String key =null;

		if(!StringUtils.hasText(apiKey)){
			key = apiKey;
			log.info("Retrieved apiKey from GKE secrets {}",key);
		}
		if(!StringUtils.hasText(key)){
			key =System.getenv("OPEN_WEATHER_API_KEY");
			log.info("could not retrieve key. Using hardcoded key {}",key);
		}
		return new OpenWeatherMapProvider(key);
	}

}
