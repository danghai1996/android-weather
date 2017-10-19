package com.example.nhem.weatherapp.utils;

import com.example.nhem.weatherapp.Conts;
import com.example.nhem.weatherapp.GetWeatherService;
import com.example.nhem.weatherapp.RetrofitFactory;

/**
 * Created by NHEM on 20/10/2017.
 */

public class Utils {
    public static GetWeatherService getWeatherService() {
        return RetrofitFactory.getInstance(Conts.BASE_URL).create(GetWeatherService.class);
    }
}
