package com.example.heathcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindDoctorActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

    CardView back=findViewById(R.id.CardViewBack);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
        }
    });

    CardView surgeon= findViewById(R.id.CardViewSurgeon);
    surgeon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
           it.putExtra("Title","Surgeon");
           startActivity(it);
        }
    });

        CardView dietician= findViewById(R.id.CardViewDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("Title","Dietician");
                startActivity(it);
            }
        });

        CardView dentist= findViewById(R.id.CardViewDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("Title","Dentist");
                startActivity(it);
            }
        });
        CardView cardiologist= findViewById(R.id.CardViewCardiology);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("Title","Cardiologist");
                startActivity(it);
            }
        });

        CardView family_physicians= findViewById(R.id.CardViewFamilyPhysicians);
        family_physicians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("Title","Family Physicians");
                startActivity(it);
            }
        });
}}
