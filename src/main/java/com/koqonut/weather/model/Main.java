package com.koqonut.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Main {
    private float temp;
    private float feels_like;
    private float temp_min;
    private float pressure;
    private float humidity;

}
