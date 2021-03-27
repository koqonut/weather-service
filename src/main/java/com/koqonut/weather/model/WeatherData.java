package com.koqonut.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherData {

    private Coord coord;
    @JsonProperty(value = "weather")
    private List<Weather> weatherList;
    private String base;
    private Main main;
    private long visiblility;
    private Wind wind;
    private Sys sys;
    private long dt;
    private long timezone;
    private long id;
    private String name;
    private int cod;

    
}
