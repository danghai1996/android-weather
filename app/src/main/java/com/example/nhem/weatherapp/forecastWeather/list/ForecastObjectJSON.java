package com.example.nhem.weatherapp.forecastWeather.list;

import java.util.List;

/**
 * Created by NHEM on 20/10/2017.
 */

public class ForecastObjectJSON {
    private List<WeatherForecastListJSON> list;

    public ForecastObjectJSON(List<WeatherForecastListJSON> list) {
        this.list = list;
    }

    public List<WeatherForecastListJSON> getList() {
        return list;
    }

    public void setList(List<WeatherForecastListJSON> list) {
        this.list = list;
    }
}
