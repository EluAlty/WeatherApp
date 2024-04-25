package com.example.weatherapp.auth;

public class User {
     private String uid;
     private String email;
     private String key;
     private String password;

     public User(){

     }

     public User(String uid, String email, String key) {
          this.uid = uid;
          this.key = key;
          this.email = email;
     }


     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getUid() {
          return uid;
     }

     public void setUid(String uid) {
          this.uid = uid;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getKey() {
          return key;
     }

     public void setKey(String key) {
          this.key = key;
     }
}
