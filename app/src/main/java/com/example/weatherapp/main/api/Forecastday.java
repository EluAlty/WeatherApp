package com.example.weatherapp.main.api;


import java.util.List;

public class Forecastday {
     private Astro astro;
     private String date;
     private int dateEpoch;
     private Day day;
     private List<Hour> hour;

     public Forecastday(Astro astro, String date, int dateEpoch, Day day, List<Hour> hour) {
          this.astro = astro;
          this.date = date;
          this.dateEpoch = dateEpoch;
          this.day = day;
          this.hour = hour;
     }

     public Astro getAstro() {
          return astro;
     }

     public void setAstro(Astro astro) {
          this.astro = astro;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public int getDateEpoch() {
          return dateEpoch;
     }

     public void setDateEpoch(int dateEpoch) {
          this.dateEpoch = dateEpoch;
     }

     public Day getDay() {
          return day;
     }

     public void setDay(Day day) {
          this.day = day;
     }

     public List<Hour> getHour() {
          return hour;
     }

     public void setHour(List<Hour> hour) {
          this.hour = hour;
     }
}

