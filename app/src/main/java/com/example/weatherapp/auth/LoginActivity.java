package com.example.weatherapp.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.R;
import com.example.weatherapp.databinding.ActivityLoginBinding;
import com.example.weatherapp.main.MainActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

     private ActivityLoginBinding binding;

     private FirebaseAuth auth;




     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityLoginBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());

          initFirebase();


          if (auth.getCurrentUser() != null){
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
          }

          binding.createAccountBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
               }
          });

          binding.loginBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    String email = binding.inputEmailEt.getText().toString();
                    String passwd = binding.inputPasswordEt.getText().toString();
                    if (!isFieldsEmpty(email, passwd)){
                         binding.emailLayout.setErrorEnabled(false);
                         binding.passwordLayout.setErrorEnabled(false);
                         signIn(email, passwd);
                    }
               }
          });


     }

     private void initFirebase(){
          auth = FirebaseAuth.getInstance();
     }

     private void signIn(String email, String passwd){
          auth.signInWithEmailAndPassword(email, passwd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()){
                                   FirebaseUser firebaseUser = auth.getCurrentUser();
                                   if (firebaseUser != null) {
                                        String uid = firebaseUser.getUid();
                                        SharedPreferences sp = getSharedPreferences("Sign", MODE_PRIVATE);
                                        sp.edit().putString("UID", uid).apply();
                                        sp.edit().putString("email", email).apply();
                                        sp.edit().putString("passwd", passwd).apply();

                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                   }
                              } else {
                                   try {
                                        throw task.getException();
                                   } catch (FirebaseAuthInvalidCredentialsException ex) {
                                        Toast.makeText(LoginActivity.this,
                                                  getString(R.string.error_invalid_pass_or_email),
                                                  Toast.LENGTH_SHORT).show();
                                   } catch (Exception ex) {
                                        Log.d("signInException",  ex.getMessage());
                                   }
                              }
                         }
                    });
     }

     private boolean isFieldsEmpty(String email, String passwd){
          binding.emailLayout.setErrorEnabled(false);
          binding.passwordLayout.setErrorEnabled(false);
          boolean isFieldsEmpty = false;

          if (TextUtils.isEmpty(email)){
               binding.emailLayout.setErrorEnabled(true);
               binding.emailLayout.setError(getString(R.string.error_empty_field));
               isFieldsEmpty = true;
          }

          if (TextUtils.isEmpty(passwd)){
               binding.passwordLayout.setErrorEnabled(true);
               binding.passwordLayout.setError(getString(R.string.error_empty_field));
               isFieldsEmpty = true;
          }

          return  isFieldsEmpty;
     }

     @Override
     protected void onDestroy() {
          super.onDestroy();
          binding = null;
     }
}

