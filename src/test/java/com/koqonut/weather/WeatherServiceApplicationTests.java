package com.koqonut.weather;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = { "OPEN_WEATHER_MAP_API_KEY=xyz" })
class WeatherServiceApplicationTests {


	@Test
	void contextLoads() {
	}

}
