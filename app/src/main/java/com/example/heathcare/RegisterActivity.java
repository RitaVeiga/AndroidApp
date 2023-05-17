package com.example.heathcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextEmail, editTextConfirmPassword;
    Button button_Register;
    TextView textview_oldUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextUserEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        button_Register = findViewById(R.id.button_Register);
        textview_oldUser = findViewById(R.id.textView_OldUser);
        button_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirmPassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmPassword) == 0) {
                        if(isValid(password)){
                     Toast.makeText(getApplicationContext(),"Registration sucessful",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 letters, having letter,digit and a symbol", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        textview_oldUser.setOnClickListener(new
            View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            });


    }

    public static boolean isValid(String password) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (password.length() < 8) {
            return false;
        } else {

            for (int p = 0; p < password.length(); p++) {
                if (Character.isLetter(password.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int t = 0; t < password.length(); t++) {
                if (Character.isDigit(password.charAt(t))) {
                    f2 = 1;
                }

            }
            for (int s = 0; s < password.length(); s++) {

                if ((password.charAt(s) >= 33 && password.charAt(s) <= 46) || password.charAt(s) == 64) {
                    f3 = 1;
                }
            }

            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true;
            }
            return false;
        }
    }


}
