package com.example.weatherapp.main.api;

import com.example.weatherapp.main.ui.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
     @SerializedName("current")
     private CurrentWeather current;

     public CurrentWeather getCurrent() {
          return current;
     }

     public void setCurrent(CurrentWeather current) {
          this.current = current;
     }

     public static class CurrentWeather {
          @SerializedName("temp_c")
          private double temperature;

          @SerializedName("condition")
          private ConditionInfo condition;

          @SerializedName("last_updated")
          private String lastUpdated;

          public int getTemperature() {
               return (int) temperature;
          }

          public void setTemperature(double temperature) {
               this.temperature = temperature;
          }

          public ConditionInfo getCondition() {
               return condition;
          }

          public void setCondition(ConditionInfo condition) {
               this.condition = condition;
          }

          public String getLastUpdated() {
               return lastUpdated;
          }

          public void setLastUpdated(String lastUpdated) {
               this.lastUpdated = lastUpdated;
          }
     }

     public static class ConditionInfo {
          @SerializedName("text")
          private String conditionText;

          public String getConditionText() {
               return conditionText;
          }

          public void setConditionText(String conditionText) {
               this.conditionText = conditionText;
          }
     }

     @SerializedName("forecast")
     private Forecast forecast;

     public Forecast getForecast() {
          return forecast;
     }

     public void setForecast(Forecast forecast) {
          this.forecast = forecast;
     }

     public static class Forecast {
          @SerializedName("forecastday")
          private List<Weather> weatherList;

          public List<Weather> getWeatherList() {
               return weatherList;
          }

          public void setWeatherList(List<Weather> weatherList) {
               this.weatherList = weatherList;
          }
     }
}

