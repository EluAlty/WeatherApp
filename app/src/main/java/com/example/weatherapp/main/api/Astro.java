package com.example.weatherapp.main.api;

public class Astro {
     private int isMoonUp;
     private int isSunUp;
     private int moonIllumination;
     private String moonPhase;
     private String moonrise;
     private String moonset;
     private String sunrise;
     private String sunset;

     public Astro(int isMoonUp, int isSunUp, int moonIllumination, String moonPhase, String moonrise, String moonset, String sunrise, String sunset) {
          this.isMoonUp = isMoonUp;
          this.isSunUp = isSunUp;
          this.moonIllumination = moonIllumination;
          this.moonPhase = moonPhase;
          this.moonrise = moonrise;
          this.moonset = moonset;
          this.sunrise = sunrise;
          this.sunset = sunset;
     }

     public int getIsMoonUp() {
          return isMoonUp;
     }

     public void setIsMoonUp(int isMoonUp) {
          this.isMoonUp = isMoonUp;
     }

     public int getIsSunUp() {
          return isSunUp;
     }

     public void setIsSunUp(int isSunUp) {
          this.isSunUp = isSunUp;
     }

     public int getMoonIllumination() {
          return moonIllumination;
     }

     public void setMoonIllumination(int moonIllumination) {
          this.moonIllumination = moonIllumination;
     }

     public String getMoonPhase() {
          return moonPhase;
     }

     public void setMoonPhase(String moonPhase) {
          this.moonPhase = moonPhase;
     }

     public String getMoonrise() {
          return moonrise;
     }

     public void setMoonrise(String moonrise) {
          this.moonrise = moonrise;
     }

     public String getMoonset() {
          return moonset;
     }

     public void setMoonset(String moonset) {
          this.moonset = moonset;
     }

     public String getSunrise() {
          return sunrise;
     }

     public void setSunrise(String sunrise) {
          this.sunrise = sunrise;
     }

     public String getSunset() {
          return sunset;
     }

     public void setSunset(String sunset) {
          this.sunset = sunset;
     }
}
