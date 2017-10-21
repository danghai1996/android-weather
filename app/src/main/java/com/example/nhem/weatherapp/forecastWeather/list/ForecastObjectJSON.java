package com.example.nhem.weatherapp.forecastWeather.list;

import java.util.List;

/**
 * Created by NHEM on 20/10/2017.
 */

public class ForecastObjectJSON {
    private List<ListJSON> list;

    public ForecastObjectJSON(List<ListJSON> list) {
        this.list = list;
    }

    public List<ListJSON> getList() {
        return list;
    }

    public void setList(List<ListJSON> list) {
        this.list = list;
    }
}
