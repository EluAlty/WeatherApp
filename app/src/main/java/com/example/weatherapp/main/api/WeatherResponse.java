package com.example.weatherapp.main.api;

public class WeatherResponse {
     private Current current;
     private Forecast forecast;
     private Location location;

     public WeatherResponse(Current current, Forecast forecast, Location location) {
          this.current = current;
          this.forecast = forecast;
          this.location = location;
     }

     public Current getCurrent() {
          return current;
     }

     public void setCurrent(Current current) {
          this.current = current;
     }

     public Forecast getForecast() {
          return forecast;
     }

     public void setForecast(Forecast forecast) {
          this.forecast = forecast;
     }

     public Location getLocation() {
          return location;
     }

     public void setLocation(Location location) {
          this.location = location;
     }
}

