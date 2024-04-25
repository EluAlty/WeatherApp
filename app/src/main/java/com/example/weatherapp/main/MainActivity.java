package com.example.weatherapp.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.main.api.WeatherApiService;
import com.example.weatherapp.main.api.WeatherResponse;
import com.example.weatherapp.main.ui.Weather;
import com.example.weatherapp.main.ui.WeatherAdapter;

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
     private List<Weather> weatherList;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityMainBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());

          recyclerView = binding.thisWeekWeatherRv;
          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
          recyclerView.setLayoutManager(layoutManager);


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


                         WeatherResponse.CurrentWeather currentWeather = weatherResponse.getCurrent();
                         Weather todayWeather = new Weather();
                         todayWeather.setTemperature(currentWeather.getTemperature());
                         todayWeather.setCondition(currentWeather.getCondition().getConditionText());
                         todayWeather.setDate(currentWeather.getLastUpdated());
                         setTodayWeather(todayWeather);


                         List<Weather> forecastWeatherList = weatherResponse.getForecast().getWeatherList();


                         weatherAdapter = new WeatherAdapter(MainActivity.this, forecastWeatherList);
                         recyclerView.setAdapter(weatherAdapter);
                    } else {
                         Log.d("sdasdasf", String.valueOf(response.errorBody() ));
                         Log.d("sdasdasf", String.valueOf(response.code() ));
                    }
               }

               @Override
               public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    Log.d("sdasdasf", t.getMessage());
               }
          });

     }

     private void setTodayWeather(Weather todayWeather) {
          if (todayWeather != null) {

               binding.todayDate.setText(todayWeather.getDate());
               binding.todayTemperature.setText(String.valueOf(todayWeather.getTemperature()));
               binding.todayCondition.setText(todayWeather.getCondition());
          }
     }
}
