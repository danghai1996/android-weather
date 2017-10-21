package com.example.nhem.weatherapp.forecastWeather.list;

import java.util.List;

/**
 * Created by NHEM on 20/10/2017.
 */

public class ListJSON {
    private long dt;
    private TempJSON temp;
    private List<WeatherForecastJSON> weather;

    public ListJSON(long dt, TempJSON temp, List<WeatherForecastJSON> weather) {
        this.dt = dt;
        this.temp = temp;
        this.weather = weather;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public TempJSON getTemp() {
        return temp;
    }

    public void setTemp(TempJSON temp) {
        this.temp = temp;
    }

    public List<WeatherForecastJSON> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherForecastJSON> weather) {
        this.weather = weather;
    }
}
