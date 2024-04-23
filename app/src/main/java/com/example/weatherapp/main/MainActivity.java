package com.example.weatherapp.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     private ActivityMainBinding binding;
     private RecyclerView recyclerView;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);

          setContentView(binding.getRoot());
     }


     private void setWeekWeather(){
          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);

          binding.thisWeekWeatherRv.setLayoutManager(layoutManager);






          WeatherAdapter weeksAdapter = new WeatherAdapter(getApplicationContext(), );
          binding.weeksCard.setAdapter(weeksAdapter);
     }





}