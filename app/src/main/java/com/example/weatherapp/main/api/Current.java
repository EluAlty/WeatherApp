package com.example.weatherapp.main.api;


// Current Weather
public class Current {
     private int cloud;
     private Condition condition;
     private double feelslikeC;
     private double feelslikeF;
     private double gustKph;
     private double gustMph;
     private int humidity;
     private int isDay;
     private String lastUpdated;
     private int lastUpdatedEpoch;
     private double precipIn;
     private double precipMm;
     private double pressureIn;
     private double pressureMb;
     private double temp_c;
     private double tempF;
     private double uv;
     private double visKm;
     private double visMiles;
     private int windDegree;
     private String windDir;
     private double windKph;
     private double windMph;

     public Current(int cloud, Condition condition, double feelslikeC, double feelslikeF, double gustKph, double gustMph, int humidity, int isDay, String lastUpdated, int lastUpdatedEpoch, double precipIn, double precipMm, double pressureIn, double pressureMb, double temp_c, double tempF, double uv, double visKm, double visMiles, int windDegree, String windDir, double windKph, double windMph) {
          this.cloud = cloud;
          this.condition = condition;
          this.feelslikeC = feelslikeC;
          this.feelslikeF = feelslikeF;
          this.gustKph = gustKph;
          this.gustMph = gustMph;
          this.humidity = humidity;
          this.isDay = isDay;
          this.lastUpdated = lastUpdated;
          this.lastUpdatedEpoch = lastUpdatedEpoch;
          this.precipIn = precipIn;
          this.precipMm = precipMm;
          this.pressureIn = pressureIn;
          this.pressureMb = pressureMb;
          this.temp_c = temp_c;
          this.tempF = tempF;
          this.uv = uv;
          this.visKm = visKm;
          this.visMiles = visMiles;
          this.windDegree = windDegree;
          this.windDir = windDir;
          this.windKph = windKph;
          this.windMph = windMph;
     }

     public int getCloud() {
          return cloud;
     }

     public void setCloud(int cloud) {
          this.cloud = cloud;
     }

     public Condition getCondition() {
          return condition;
     }

     public void setCondition(Condition condition) {
          this.condition = condition;
     }

     public double getFeelslikeC() {
          return feelslikeC;
     }

     public void setFeelslikeC(double feelslikeC) {
          this.feelslikeC = feelslikeC;
     }

     public double getFeelslikeF() {
          return feelslikeF;
     }

     public void setFeelslikeF(double feelslikeF) {
          this.feelslikeF = feelslikeF;
     }

     public double getGustKph() {
          return gustKph;
     }

     public void setGustKph(double gustKph) {
          this.gustKph = gustKph;
     }

     public double getGustMph() {
          return gustMph;
     }

     public void setGustMph(double gustMph) {
          this.gustMph = gustMph;
     }

     public int getHumidity() {
          return humidity;
     }

     public void setHumidity(int humidity) {
          this.humidity = humidity;
     }

     public int getIsDay() {
          return isDay;
     }

     public void setIsDay(int isDay) {
          this.isDay = isDay;
     }

     public String getLastUpdated() {
          return lastUpdated;
     }

     public void setLastUpdated(String lastUpdated) {
          this.lastUpdated = lastUpdated;
     }

     public int getLastUpdatedEpoch() {
          return lastUpdatedEpoch;
     }

     public void setLastUpdatedEpoch(int lastUpdatedEpoch) {
          this.lastUpdatedEpoch = lastUpdatedEpoch;
     }

     public double getPrecipIn() {
          return precipIn;
     }

     public void setPrecipIn(double precipIn) {
          this.precipIn = precipIn;
     }

     public double getPrecipMm() {
          return precipMm;
     }

     public void setPrecipMm(double precipMm) {
          this.precipMm = precipMm;
     }

     public double getPressureIn() {
          return pressureIn;
     }

     public void setPressureIn(double pressureIn) {
          this.pressureIn = pressureIn;
     }

     public double getPressureMb() {
          return pressureMb;
     }

     public void setPressureMb(double pressureMb) {
          this.pressureMb = pressureMb;
     }

     public double getTemp_c() {
          return temp_c;
     }

     public void setTemp_c(double temp_c) {
          this.temp_c = temp_c;
     }

     public double getTempF() {
          return tempF;
     }

     public void setTempF(double tempF) {
          this.tempF = tempF;
     }

     public double getUv() {
          return uv;
     }

     public void setUv(double uv) {
          this.uv = uv;
     }

     public double getVisKm() {
          return visKm;
     }

     public void setVisKm(double visKm) {
          this.visKm = visKm;
     }

     public double getVisMiles() {
          return visMiles;
     }

     public void setVisMiles(double visMiles) {
          this.visMiles = visMiles;
     }

     public int getWindDegree() {
          return windDegree;
     }

     public void setWindDegree(int windDegree) {
          this.windDegree = windDegree;
     }

     public String getWindDir() {
          return windDir;
     }

     public void setWindDir(String windDir) {
          this.windDir = windDir;
     }

     public double getWindKph() {
          return windKph;
     }

     public void setWindKph(double windKph) {
          this.windKph = windKph;
     }

     public double getWindMph() {
          return windMph;
     }

     public void setWindMph(double windMph) {
          this.windMph = windMph;
     }
}