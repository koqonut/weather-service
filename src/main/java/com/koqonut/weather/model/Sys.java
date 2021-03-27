package com.koqonut.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sys {
    private int type;
    private long id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

}
