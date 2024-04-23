package com.example.weatherapp.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.main.MainActivity;
import com.example.weatherapp.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

     private ActivityLoginBinding binding;
     private FirebaseAuth auth;
     private FirebaseDatabase db;

     private void initFirebase(){
          auth = FirebaseAuth.getInstance();
          db = FirebaseDatabase.getInstance();
     }


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityLoginBinding.inflate(getLayoutInflater());

          initFirebase();

          if(auth.getCurrentUser() != null){
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
          }


          binding.loginBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                    String email = binding.inputEmailEt.toString();
                    String pass = binding.inputPasswordEt.toString();

                    if(email.toString().isEmpty() || pass.isEmpty()){
                         Toast.makeText(getApplicationContext(), "Не все поля заполнены.", Toast.LENGTH_SHORT).show();
                    }else{
                         auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if(task.isSuccessful()){
                                       startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                  }
                              }
                         });
                    }

               }
          });


          binding.createAccountBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
               }
          });

          setContentView(binding.getRoot());
     }
}