package com.example.weatherapp.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.main.api.Condition;
import com.example.weatherapp.main.api.Current;
import com.example.weatherapp.main.api.Day;
import com.example.weatherapp.main.api.Forecastday;
import com.example.weatherapp.main.api.WeatherApiService;
import com.example.weatherapp.main.api.WeatherResponse;
import com.example.weatherapp.main.ui.Weather;
import com.example.weatherapp.main.ui.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
     private static final String API_KEY = "1bd1ab75f65e4520b6c41240242504";
     private static final String BASE_URL = "https://api.weatherapi.com/v1/";

     private ActivityMainBinding binding;
     private RecyclerView recyclerView;
     private WeatherAdapter weatherAdapter;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityMainBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());

          recyclerView = binding.thisWeekWeatherRv;
          recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

          fetchWeatherData();
     }

     private void fetchWeatherData() {
          Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

          WeatherApiService apiService = retrofit.create(WeatherApiService.class);

          Call<WeatherResponse> call = apiService.getWeatherData(API_KEY, "Almaty", 7, "no", "no", "ru");

          call.enqueue(new Callback<WeatherResponse>() {
               @Override
               public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                         WeatherResponse weatherResponse = response.body();

                         List<Forecastday> forecastdayList = weatherResponse.getForecast().getForecastday();
                         List<Weather> forecastWeatherList = new ArrayList<>();

                         Current currentWeather = weatherResponse.getCurrent();
                         Weather todayWeather = new Weather();
                         todayWeather.setDate("Today");


                         todayWeather.setTemperature( (int) currentWeather.getTemp_c() );
                         todayWeather.setCondition(currentWeather.getCondition() );

                         forecastWeatherList.add(todayWeather);

                         for (Forecastday forecastday : forecastdayList) {
                              Weather weather = new Weather();
                              weather.setDate(forecastday.getDate());

                              Day day = forecastday.getDay();
                              Log.d("фывфыв", "Temperature ----- " + day.getAvgtemp_c());


                              if (day != null) {
                                   int avgTempC = (int) day.getAvgtemp_c();
                                   Condition condition = day.getCondition();

                                   Log.d("фывфыв", "Temperature: " + avgTempC);

                                   weather.setTemperature(avgTempC);
                                   weather.setCondition(condition);
                              }

                              forecastWeatherList.add(weather);
                         }

                         updateWeatherAdapter(forecastWeatherList);
                         setTodayWeather(forecastWeatherList.get(0));

                    } else {
                         Log.e("фывфыв123", "" + response.code());

                    }
               }

               @Override
               public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    Log.e("фывфыв123", t.toString(), t);
                    Toast.makeText(MainActivity.this, "Failed to fetch weather data", Toast.LENGTH_SHORT).show();
               }
          });
     }

     private void updateWeatherAdapter(List<Weather> forecastWeatherList) {
          if (weatherAdapter == null) {
               weatherAdapter = new WeatherAdapter(MainActivity.this, forecastWeatherList);
               recyclerView.setAdapter(weatherAdapter);
          } else {
               weatherAdapter.updateData(forecastWeatherList);
          }
     }
     private void setTodayWeather(Weather todayWeather) {
          binding.todayDate.setText(todayWeather.getDate());
          binding.todayTemperature.setText(String.valueOf(todayWeather.getTemperature()));
          binding.todayCondition.setText(todayWeather.getCondition().getText());
     }
}
