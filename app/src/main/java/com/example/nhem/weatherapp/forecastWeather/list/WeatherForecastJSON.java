package com.example.nhem.weatherapp.forecastWeather.list;

/**
 * Created by NHEM on 21/10/2017.
 */

public class WeatherForecastJSON {
    private int id;
    private String main;
    private String icon;

    public WeatherForecastJSON(int id, String main, String icon) {
        this.id = id;
        this.main = main;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
