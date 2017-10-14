package com.example.nhem.weatherapp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NHEM on 13/10/2017.
 */

public interface GetWeatherService {
    @GET("data/2.5/weather")
    Call<MainObjectJSON> getWeatherData(@Query("q") String city, @Query("APPID") String appId);

}
