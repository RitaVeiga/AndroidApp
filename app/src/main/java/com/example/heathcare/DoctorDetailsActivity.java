package com.example.heathcare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String [][] doctorDetails1={
            {"Doctor Name: João Rodrigues","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Ana Pires","Hospital Adress:Vila Real Hospital","Experience:16 y","Mobile phone:912005678","300"},
            {"Doctor Name: Sofia Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Tiago Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}, {"Doctor Name: Julia Silva","Hospital Adress:Porto Hospital","Experience:6 year","Mobile phone:912309678","300"}

    };
    private String [][] doctorDetails2={
            {"Doctor Name: Rodrigo Rodrigues","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Filipe Pires","Hospital Adress:Vila Real Hospital","Experience:16 y","Mobile phone:912005678","300"},
            {"Doctor Name: Francisco Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Julio Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}, {"Doctor Name: Julia Silva","Hospital Adress:Porto Hospital","Experience:6 year","Mobile phone:912309678","300"}

    };
    private String [][] doctorDetails3={
            {"Doctor Name: Manuel Rodrigues","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Alexandre Pires","Hospital Adress:Vila Real Hospital","Experience:14 y","Mobile phone:912005678","300"},
            {"Doctor Name: Sonia Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Rui Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}, {"Doctor Name: Julia Silva","Hospital Adress:Porto Hospital","Experience:6 year","Mobile phone:912309678","300"}

    };
    private String [][] doctorDetails4={
            {"Doctor Name: Constanca Rodrigues","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Pedro Pires","Hospital Adress:Vila Real Hospital","Experience:9 y","Mobile phone:912005678","300"},
            {"Doctor Name: Joana Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Vitoria Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"},
            {"Doctor Name: Julia Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}
    };
    private String [][] doctorDetails5={
            {"Doctor Name: José Rodrigues","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Teresa Pires","Hospital Adress:Vila Real Hospital","Experience:30 y","Mobile phone:912005678","300"},
            {"Doctor Name: Gustavo Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Sandra Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"},
            {"Doctor Name: Andreia Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}
    };
    private String [][] doctorDetails6={
            {"Doctor Name: Dora Santos","Hospital Adress:Bragança Hospital","Experience:1 y","Mobile phone:912345678","300"},
            {"Doctor Name: Anabela Rodrigues","Hospital Adress:Vila Real Hospital","Experience:2 y","Mobile phone:912005678","300"},
            {"Doctor Name: Sergio Leite","Hospital Adress:Gaia Hospital","Experience:21 y","Mobile phone:9123412678","300"},
            {"Doctor Name: Jorge Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"},
            {"Doctor Name: Gorete Silva","Hospital Adress:Porto Hospital","Experience:6 y","Mobile phone:912309678","300"}

    };

    ArrayList list;
    SimpleAdapter sa;
    TextView textViewDoctorDetails;
    Button button;
    String [][]doctor_details={};
    HashMap<String,String> item;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        textViewDoctorDetails = findViewById(R.id.textViewDoctorDetailsName);
        button = findViewById(R.id.buttonDoctorDetailsBack);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        textViewDoctorDetails.setText(title);

      if (title.compareTo("Surgeon") == 0)
            doctor_details = doctorDetails1;
         else
            if (title.compareTo("Dietician") == 0)
                doctor_details = doctorDetails2;
             else
                if (title.compareTo("Dentist") == 0)
                    doctor_details = doctorDetails4;
                 else
                    if (title.compareTo("Cardiologist") == 0)
                        doctor_details = doctorDetails5;
                     else
                        if (title.compareTo("Family Physicians") == 0)
                            doctor_details = doctorDetails6;





                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i= new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class);
                            startActivity(i);
                        }

                    });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5","Fee:"+ doctor_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.activity_multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5", "line6"}
                , new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView listViewDoctorDetails = findViewById(R.id.listViewDoctorDetails);
        listViewDoctorDetails.setAdapter(sa);


    }
        }
