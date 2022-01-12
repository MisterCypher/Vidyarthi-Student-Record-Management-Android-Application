package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delete2Activity extends AppCompatActivity {
    Button personalbutton2, academicbutton2,extrabutton2,currentbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete2);
        personalbutton2=findViewById(R.id.personal2);
        academicbutton2=findViewById(R.id.academicdetails2);
        extrabutton2=findViewById(R.id.extracurriculardetails2);
        currentbutton2=findViewById(R.id.current2);
        personalbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Delete2Activity.this,DeleteActivity.class);
                startActivity(intToMain);
            }
        });
        academicbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Delete2Activity.this,DeleteActivity1.class);
                startActivity(intToMain);
            }
        });
        extrabutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Delete2Activity.this,DeleteActivity2.class);
                startActivity(intToMain);
            }
        });
        currentbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(Delete2Activity.this,DeleteActivity3.class);
                startActivity(intToMain);
            }
        });
    }
}