package com.example.nhem.weatherapp.forecastWeather.list;

/**
 * Created by NHEM on 20/10/2017.
 */

public class WeatherForecastListJSON {
    private long dt;
    private TempJSON temp;

    public WeatherForecastListJSON(long dt, TempJSON temp) {
        this.dt = dt;
        this.temp = temp;
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
}
