package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class AddActivity extends AppCompatActivity {
Button personalbutton, academicbutton,extrabutton,currentbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         personalbutton=findViewById(R.id.personal);
         academicbutton=findViewById(R.id.academicdetails);
         extrabutton=findViewById(R.id.extracurriculardetails);
         currentbutton=findViewById(R.id.current);

        personalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(AddActivity.this,PersonActivity.class);
                startActivity(intToMain);
            }
        });
        academicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(AddActivity.this,AcademicActivity.class);
                startActivity(intToMain);
            }
        });
     extrabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(AddActivity.this,ExtraActivity.class);
                startActivity(intToMain);
            }
        });
        currentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(AddActivity.this,CurrentActivity.class);
                startActivity(intToMain);
            }
        });
       
    }
}