package com.example.heathcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

   @Override
   public void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_home);

       CardView exit = findViewById(R.id.CardViewExit);
       exit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(HomeActivity.this, LoginActivity.class));
           }
       });


       CardView findDoctor = findViewById(R.id.CardViewFindDoctor);
       findDoctor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));

           }
       });
   }
}
