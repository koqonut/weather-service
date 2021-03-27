package com.koqonut.weather.services;

import java.util.Optional;

import com.koqonut.weather.model.WeatherData;

import lombok.NonNull;

public interface WeatherProvider {

    Optional<WeatherData> getWeather(@NonNull String lattitude, @NonNull String longitude);
    Optional<WeatherData> getWeather(@NonNull String cityName);
    
}
