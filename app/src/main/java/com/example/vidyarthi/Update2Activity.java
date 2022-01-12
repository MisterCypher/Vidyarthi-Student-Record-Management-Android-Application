package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Update2Activity extends AppCompatActivity {
    Button personalbutton3, academicbutton3,extrabutton3,currentbutton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update3);
        personalbutton3=findViewById(R.id.personal3);
        academicbutton3=findViewById(R.id.academicdetails3);
        extrabutton3=findViewById(R.id.extracurriculardetails3);
        currentbutton3=findViewById(R.id.current3);
        personalbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Update2Activity.this,UpdateActivity.class);
                startActivity(intToMain);
            }
        });
        academicbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Update2Activity.this,UpdateActivity1.class);
                startActivity(intToMain);
            }
        });
        extrabutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Update2Activity.this,UpdateActivity2.class);
                startActivity(intToMain);
            }
        });
        currentbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Update2Activity.this,UpdateActivity3.class);
                startActivity(intToMain);
            }
        });
    }
}