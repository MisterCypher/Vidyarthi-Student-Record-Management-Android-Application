package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class View2Activity extends AppCompatActivity {
    Button personalbutton1, academicbutton1,extrabutton1,currentbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        personalbutton1=findViewById(R.id.personal1);
        academicbutton1=findViewById(R.id.academicdetails1);
        extrabutton1=findViewById(R.id.extracurriculardetails1);
        currentbutton1=findViewById(R.id.current1);
      personalbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(View2Activity.this,ViewActivity.class);
                startActivity(intToMain);
            }
        });
       academicbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(View2Activity.this,ViewActivity1.class);
                startActivity(intToMain);
            }
        });
        extrabutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(View2Activity.this,ViewActivity2.class);
                startActivity(intToMain);
            }
        });
        currentbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(View2Activity.this,ViewActivity3.class);
                startActivity(intToMain);
            }
        });
    }
}