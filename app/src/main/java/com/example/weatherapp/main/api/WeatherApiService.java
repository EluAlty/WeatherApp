package com.example.weatherapp.main.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
     @GET("forecast.json")
     Call<WeatherResponse> getWeatherData(
               @Query("key") String apiKey,
               @Query("q") String location,
               @Query("days") int days,
               @Query("aqi") String aqi,
               @Query("alerts") String alerts,
               @Query("lang") String language
     );
}

