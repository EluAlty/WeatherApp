package com.example.weatherapp.main;

import java.util.Date;

public class Weather {
     private Date date;
     private String condition;
     private int temperature;

     public Weather() {

     }

     public Weather(Date date, String condition, int temperature) {
          this.date = date;
          this.condition = condition;
          this.temperature = temperature;
     }

     public Date getDate() {
          return date;
     }

     public void setDate(Date date) {
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
