package com.example.weatherapp.main.ui;

import com.example.weatherapp.main.api.Condition;

public class Weather {
     private String date;
     private double temperature;
     private Condition condition;

     public Weather(String date, int temperature, Condition condition) {
          this.date = date;
          this.temperature = temperature;
          this.condition = condition;
     }

     public Weather() {

     }


     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public double getTemperature() {
          return temperature;
     }

     public void setTemperature(double temperature) {
          this.temperature = temperature;
     }

     public Condition getCondition() {
          return condition;
     }

     public void setCondition(Condition condition) {
          this.condition = condition;
     }
}
