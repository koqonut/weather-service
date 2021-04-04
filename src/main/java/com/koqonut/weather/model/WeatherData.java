package com.koqonut.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="weatherdata")
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
    @Id
    private String name;
    private int cod;

    
}
