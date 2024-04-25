package com.example.weatherapp.main.ui;

import java.util.Date;

public class Weather {
     private String date;
     private String condition;
     private int temperature;

     public Weather() {

     }

     public Weather(String date, String condition, int temperature) {
          this.date = date;
          this.condition = condition;
          this.temperature = temperature;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public String getCondition() {
          return condition;
     }

     public void setCondition(String condition) {
          this.condition = condition;
     }

     public int getTemperature() {
          return temperature;
     }

     public void setTemperature(int temperature) {
          this.temperature = temperature;
     }
}
