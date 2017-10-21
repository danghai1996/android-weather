package com.example.nhem.weatherapp;

import com.example.nhem.weatherapp.dailyWeather.MainObjectJSON;
import com.example.nhem.weatherapp.forecastWeather.list.ForecastObjectJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NHEM on 13/10/2017.
 */

public interface GetWeatherService {
    @GET("data/2.5/weather")
    Call<MainObjectJSON> getWeatherData(@Query("q") String city, @Query("APPID") String appId);

    @GET("data/2.5/forecast/daily")
    Call<ForecastObjectJSON> getWeatherForecastData(@Query("q") String city, @Query("APIKEY") String apiKey);
}
