package com.example.weatherapp.main.api;

public class Condition {
     private int code;
     private String icon;
     private String text;
     public Condition(int code, String icon, String text) {
          this.code = code;
          this.icon = icon;
          this.text = text;
     }

     public int getCode() {
          return code;
     }

     public void setCode(int code) {
          this.code = code;
     }

     public String getIcon() {
          return icon;
     }

     public void setIcon(String icon) {
          this.icon = icon;
     }

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }
}
