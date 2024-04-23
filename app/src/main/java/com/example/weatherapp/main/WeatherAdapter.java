package com.example.weatherapp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
     private Context context;
     List<Weather> weathers;


     @NonNull
     @Override
     public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View weatherItems = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
          return new WeatherViewHolder(weatherItems);
     }

     @Override
     public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
          holder.date.setText(weathers.get(position).getDate()+"");
          holder.temperature.setText(weathers.get(position).getTemperature()+"");
          holder.condition.setText(weathers.get(position).getCondition()+"");
     }


     @Override
     public int getItemCount() {
          return 6;
     }



     public static class WeatherViewHolder extends RecyclerView.ViewHolder{
          CardView cardView;
          TextView  date, temperature, condition;

          public WeatherViewHolder(@NonNull View itemView) {
               super(itemView);
               cardView = itemView.findViewById(R.id.this_week_weather_card);
               date = itemView.findViewById(R.id.week_date);
               temperature = itemView.findViewById(R.id.week_temperature);
               condition = itemView.findViewById(R.id.week_condition);
          }
     }
}
