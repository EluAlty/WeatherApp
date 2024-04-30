package com.example.weatherapp.main.api;

public class Day {
     private int avgHumidity;
     private double avgtemp_c;
     private double avgTempF;
     private double avgVisKm;
     private double avgVisMiles;
     private Condition condition;
     private int dailyChanceOfRain;
     private int dailyChanceOfSnow;
     private int dailyWillItRain;
     private int dailyWillItSnow;
     private double maxTempC;
     private double maxTempF;
     private double maxWindKph;
     private double maxWindMph;
     private double minTempC;
     private double minTempF;
     private double totalPrecipIn;
     private double totalPrecipMm;
     private double totalSnowCm;
     private double uv;

     public Day(int avgHumidity, double avgtemp_c, double avgTempF, double avgVisKm, double avgVisMiles, Condition condition, int dailyChanceOfRain, int dailyChanceOfSnow, int dailyWillItRain, int dailyWillItSnow, double maxTempC, double maxTempF, double maxWindKph, double maxWindMph, double minTempC, double minTempF, double totalPrecipIn, double totalPrecipMm, double totalSnowCm, double uv) {
          this.avgHumidity = avgHumidity;
          this.avgtemp_c = avgtemp_c;
          this.avgTempF = avgTempF;
          this.avgVisKm = avgVisKm;
          this.avgVisMiles = avgVisMiles;
          this.condition = condition;
          this.dailyChanceOfRain = dailyChanceOfRain;
          this.dailyChanceOfSnow = dailyChanceOfSnow;
          this.dailyWillItRain = dailyWillItRain;
          this.dailyWillItSnow = dailyWillItSnow;
          this.maxTempC = maxTempC;
          this.maxTempF = maxTempF;
          this.maxWindKph = maxWindKph;
          this.maxWindMph = maxWindMph;
          this.minTempC = minTempC;
          this.minTempF = minTempF;
          this.totalPrecipIn = totalPrecipIn;
          this.totalPrecipMm = totalPrecipMm;
          this.totalSnowCm = totalSnowCm;
          this.uv = uv;
     }

     public Day() {

     }


     public int getAvgHumidity() {
          return avgHumidity;
     }

     public void setAvgHumidity(int avgHumidity) {
          this.avgHumidity = avgHumidity;
     }

     public double getAvgtemp_c() {
          return avgtemp_c;
     }

     public void setAvgtemp_c(double avgtemp_c) {
          this.avgtemp_c = avgtemp_c;
     }

     public double getAvgTempF() {
          return avgTempF;
     }

     public void setAvgTempF(double avgTempF) {
          this.avgTempF = avgTempF;
     }

     public double getAvgVisKm() {
          return avgVisKm;
     }

     public void setAvgVisKm(double avgVisKm) {
          this.avgVisKm = avgVisKm;
     }

     public double getAvgVisMiles() {
          return avgVisMiles;
     }

     public void setAvgVisMiles(double avgVisMiles) {
          this.avgVisMiles = avgVisMiles;
     }

     public Condition getCondition() {
          return condition;
     }

     public void setCondition(Condition condition) {
          this.condition = condition;
     }

     public int getDailyChanceOfRain() {
          return dailyChanceOfRain;
     }

     public void setDailyChanceOfRain(int dailyChanceOfRain) {
          this.dailyChanceOfRain = dailyChanceOfRain;
     }

     public int getDailyChanceOfSnow() {
          return dailyChanceOfSnow;
     }

     public void setDailyChanceOfSnow(int dailyChanceOfSnow) {
          this.dailyChanceOfSnow = dailyChanceOfSnow;
     }

     public int getDailyWillItRain() {
          return dailyWillItRain;
     }

     public void setDailyWillItRain(int dailyWillItRain) {
          this.dailyWillItRain = dailyWillItRain;
     }

     public int getDailyWillItSnow() {
          return dailyWillItSnow;
     }

     public void setDailyWillItSnow(int dailyWillItSnow) {
          this.dailyWillItSnow = dailyWillItSnow;
     }

     public double getMaxTempC() {
          return maxTempC;
     }

     public void setMaxTempC(double maxTempC) {
          this.maxTempC = maxTempC;
     }

     public double getMaxTempF() {
          return maxTempF;
     }

     public void setMaxTempF(double maxTempF) {
          this.maxTempF = maxTempF;
     }

     public double getMaxWindKph() {
          return maxWindKph;
     }

     public void setMaxWindKph(double maxWindKph) {
          this.maxWindKph = maxWindKph;
     }

     public double getMaxWindMph() {
          return maxWindMph;
     }

     public void setMaxWindMph(double maxWindMph) {
          this.maxWindMph = maxWindMph;
     }

     public double getMinTempC() {
          return minTempC;
     }

     public void setMinTempC(double minTempC) {
          this.minTempC = minTempC;
     }

     public double getMinTempF() {
          return minTempF;
     }

     public void setMinTempF(double minTempF) {
          this.minTempF = minTempF;
     }

     public double getTotalPrecipIn() {
          return totalPrecipIn;
     }

     public void setTotalPrecipIn(double totalPrecipIn) {
          this.totalPrecipIn = totalPrecipIn;
     }

     public double getTotalPrecipMm() {
          return totalPrecipMm;
     }

     public void setTotalPrecipMm(double totalPrecipMm) {
          this.totalPrecipMm = totalPrecipMm;
     }

     public double getTotalSnowCm() {
          return totalSnowCm;
     }

     public void setTotalSnowCm(double totalSnowCm) {
          this.totalSnowCm = totalSnowCm;
     }

     public double getUv() {
          return uv;
     }

     public void setUv(double uv) {
          this.uv = uv;
     }
}
