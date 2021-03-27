package com.koqonut.weather.controller;

import java.util.Optional;

import com.koqonut.weather.model.WeatherData;
import com.koqonut.weather.services.WeatherProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/weather")
@Log4j2
public class WeatherController {

    @Autowired
    private WeatherProvider weatherProvider;

    @GetMapping(params = { "latitude","longitude" })
    public ResponseEntity<WeatherData> weatherByCoordinates(@RequestParam String latitude,
                                    @RequestParam String longitude){

      
        log.info("Querying for lat  {}; long- {}",latitude,longitude);
        try{
            Optional<WeatherData> weatherdata = weatherProvider.getWeather(latitude, longitude);
            if(weatherdata.isPresent()){
                return new ResponseEntity<WeatherData>(weatherdata.get(), HttpStatus.OK);
            }
        }catch(Exception ex){
            log.error("Couldnt process request "+ex);

        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = { "city"})
    public ResponseEntity<WeatherData>  weatherByCoordinates(@RequestParam String city){
        log.info("Querying for city {}",city);
        try{
            Optional<WeatherData> weatherdata = weatherProvider.getWeather(city);
            if(weatherdata.isPresent()){
                return new ResponseEntity<WeatherData>(weatherdata.get(), HttpStatus.OK);
            }
        }catch(Exception ex){
            log.error("Couldnt process request "+ex);

        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
