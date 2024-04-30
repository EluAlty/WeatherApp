package com.example.weatherapp.main.ui;

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
     private List<Weather> weatherList;

     public WeatherAdapter(Context context, List<Weather> weatherList) {
          this.context = context;
          this.weatherList = weatherList;
     }

     @NonNull
     @Override
     public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
          return new WeatherViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

          Weather weather = weatherList.get(position);

          holder.dateTextView.setText(weather.getDate());
          holder.temperatureTextView.setText(String.valueOf(weather.getTemperature()));
          holder.conditionTextView.setText(weather.getCondition().getText());


     }

     @Override
     public int getItemCount() {
          return weatherList.size();
     }

     public static class WeatherViewHolder extends RecyclerView.ViewHolder {
          TextView dateTextView;
          TextView temperatureTextView;
          TextView conditionTextView;

          public WeatherViewHolder(@NonNull View itemView) {
               super(itemView);
               dateTextView = itemView.findViewById(R.id.week_date);
               temperatureTextView = itemView.findViewById(R.id.week_temperature);
               conditionTextView = itemView.findViewById(R.id.week_condition);
          }
     }


     public void updateData(List<Weather> newWeatherList) {
          this.weatherList.clear();
          this.weatherList.addAll(newWeatherList);
          notifyDataSetChanged();
     }
}
