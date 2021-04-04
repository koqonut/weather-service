package com.koqonut.weather.repository;

import com.koqonut.weather.model.WeatherData;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherDataRepository extends MongoRepository<WeatherData,String>{
    
}
