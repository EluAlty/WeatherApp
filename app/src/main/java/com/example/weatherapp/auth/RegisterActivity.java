package com.example.weatherapp.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weatherapp.R;
import com.example.weatherapp.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

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
          setContentView(binding.getRoot());

          initFirebase();

          binding.backToLoginBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
               }
          });

          binding.registerBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    String email = binding.inputEmailEt.getText().toString().trim();
                    String pass = binding.inputPasswordEt.getText().toString();
                    String againPass = binding.inputPasswordAgainEt.getText().toString();

                    if (!isFieldsEmpty(email, pass, againPass)) {
                         if (validatePassword(pass)) {
                              if (pass.equals(againPass)) {
                                   registerUser(email, pass );
                              } else {
                                   Toast.makeText(RegisterActivity.this, getString(R.string.error_password_mismatch), Toast.LENGTH_SHORT).show();
                              }
                         } else {
                              Toast.makeText(RegisterActivity.this, getString(R.string.error_weak_password), Toast.LENGTH_SHORT).show();
                         }
                    }
               }
          });
     }

     private boolean validatePassword(String passwd) {
          boolean hasNums = false;
          boolean hasLetters = false;

          for (int i = 0; i < passwd.length(); i++) {
               if ((passwd.charAt(i) >= 'A' && passwd.charAt(i) <= 'Z')
                         || (passwd.charAt(i) >= 'a' && passwd.charAt(i) <= 'z')) {
                    hasLetters = true;
                    break;
               } else{
                    binding.passwordLayout.setErrorEnabled(true);
                    binding.passwordLayout.setError(getString(R.string.error_weak_password_letters));
               }
          }

          for (int i = 0; i < passwd.length(); i++) {
               if (passwd.charAt(i) >= '0' && passwd.charAt(i) <= '9') {
                    hasNums = true;
               }
          }

          return hasNums && hasLetters;
     }

     private boolean isFieldsEmpty(String email, String passwd, String repeatPasswd) {
          boolean isFieldsEmpty = false;

          if (TextUtils.isEmpty(email.trim())) {
               binding.emailLayout.setErrorEnabled(true);
               binding.emailLayout.setError(getString(R.string.error_empty_email));
               isFieldsEmpty = true;
          } else {
               binding.emailLayout.setErrorEnabled(false);
          }

          if (TextUtils.isEmpty(passwd.trim())) {
               binding.passwordLayout.setErrorEnabled(true);
               binding.passwordLayout.setError(getString(R.string.error_empty_password));
               isFieldsEmpty = true;
          } else {
               binding.passwordLayout.setErrorEnabled(false);
          }

          if (TextUtils.isEmpty(repeatPasswd.trim()) && !isFieldsEmpty) {
               binding.inputPasswordAgain.setErrorEnabled(true);
               binding.inputPasswordAgain.setError(getString(R.string.error_empty_password_repeat));
               isFieldsEmpty = true;
          } else {
               binding.inputPasswordAgain.setErrorEnabled(false);
          }

          return isFieldsEmpty;
     }



     private void registerUser(String email, String password) {
          auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()) {
                                   String userId = auth.getCurrentUser().getUid();
                                   DatabaseReference userRef = db.getReference("Users").child(userId);

                                   User user = new User(
                                             userId,
                                             userRef.getKey(),
                                             email
                                   );

                                   userRef.setValue(user)
                                             .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                  @Override
                                                  public void onComplete(@NonNull Task<Void> task) {
                                                       if (task.isSuccessful()) {
                                                            Toast.makeText(RegisterActivity.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                                                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                                       } else {
                                                            Toast.makeText(RegisterActivity.this, "Произошла ошибка при сохранении данных пользователя", Toast.LENGTH_SHORT).show();
                                                       }
                                                  }
                                             });
                              }
                         }
                    }).addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                              if (e instanceof FirebaseAuthUserCollisionException) {
                                   Toast.makeText(getApplicationContext(),
                                             "Пользователь с таким Email уже существует",
                                             Toast.LENGTH_SHORT).show();
                              } else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                   FirebaseAuthInvalidCredentialsException exception = (FirebaseAuthInvalidCredentialsException) e;
                                   if (exception.getErrorCode().equals("ERROR_INVALID_EMAIL")) {
                                        Toast.makeText(getApplicationContext(),
                                                  "Введите корректный Email",
                                                  Toast.LENGTH_SHORT).show();

                                   } else if (exception.getErrorCode().equals("ERROR_WEAK_PASSWORD")) {
                                        Toast.makeText(getApplicationContext(),
                                                  "Пароль должен содержать как минимум 6 символов",
                                                  Toast.LENGTH_SHORT).show();
                                   }
                              }
                         }
                    });
     }


}