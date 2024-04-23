package com.example.weatherapp.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weatherapp.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

     private ActivityRegisterBinding binding;
     private FirebaseAuth auth;
     private FirebaseDatabase db;

     private void initFirebase() {
          auth = FirebaseAuth.getInstance();
          db = FirebaseDatabase.getInstance();
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityRegisterBinding.inflate(getLayoutInflater());

          initFirebase();


          binding.registerBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    String email = binding.inputEmailEt.toString();
                    String pass = binding.inputPasswordEt.toString();
                    String againPass = binding.inputPasswordAgainEt.toString();





               }
          });

          setContentView(binding.getRoot());


     }



     private boolean validatePassword(String passwd) {
          boolean hasNums = false;
          boolean hasLetters = false;

          for (int i = 0; i < passwd.length(); i++) {
               if ((passwd.charAt(i) >= 'A' && passwd.charAt(i) <= 'Z')
                         || (passwd.charAt(i) >= 'a' && passwd.charAt(i) <= 'z')) {
                    hasLetters = true;
                    break;
               }
          }

          for (int i = 0; i < passwd.length(); i++) {
               if (passwd.charAt(i) >= '0' && passwd.charAt(i) <= '9') {
                    hasNums = true;
               }
          }

          return hasNums && hasLetters;
     }



     private boolean isFieldsEmpty(String email, String passwd, String repeatPasswd){

          binding.emailLayout.setErrorEnabled(false);
          binding.inputPasswordEt.setErrorEnabled(false);
          binding.passwordRepeatLayout.setErrorEnabled(false);
          boolean isFieldsEmpty = false;

          if (TextUtils.isEmpty(email.trim())){
               binding.emailLayout.setErrorEnabled(true);
               binding.emailLayout.setError(getString(R.string.error_empty_field));
               isFieldsEmpty = true;
          }

          if (TextUtils.isEmpty(passwd.trim())){
               binding.inputPasswordEt.setErrorEnabled(true);
               binding.inputPasswordEt.setError(getString(R.string.error_empty_field));
               isFieldsEmpty = true;

          }
          if (TextUtils.isEmpty(repeatPasswd.trim())){
               binding.passwordRepeatLayout.setErrorEnabled(true);
               binding.passwordRepeatLayout.setError(getString(R.string.error_empty_field));
               isFieldsEmpty = true;
          }


          return  isFieldsEmpty;
     }
}