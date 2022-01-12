package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AcademicActivity extends AppCompatActivity {
    EditText tenmark,twelvemark,graduationmark,rollnumber,seatnumbe;
    Button subbutton1;
 DatabaseReference reff1;
   academic academic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        tenmark=findViewById(R.id.tenmarks);
        twelvemark=findViewById(R.id.twelvemarks);
        graduationmark=findViewById(R.id.graduationmarks);
        rollnumber=findViewById(R.id.rollnumberrrr);
        seatnumbe =findViewById(R.id.seatnumber);
        subbutton1=findViewById(R.id.submit1);
      academic=new academic();
     reff1= FirebaseDatabase.getInstance().getReference().child("academic");
        subbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tenmarks=Integer.parseInt(tenmark.getText().toString().trim());
                int twelvemarks=Integer.parseInt(twelvemark.getText().toString().trim());
                int graduationmarks=Integer.parseInt(graduationmark.getText().toString().trim());
                int seatnumber=Integer.parseInt(seatnumbe.getText().toString().trim());

                academic.setRoll(rollnumber.getText().toString().trim());

                academic.setTenmarks(tenmarks);
                academic.setTwelvemarks(twelvemarks);
                academic.setGraduationmarks(graduationmarks);
               academic.setSeatnumber(seatnumber);


                String rolln= rollnumber.getText().toString().trim();

                reff1.child(rolln).setValue(academic);
              // reff1.push().setValue(academic);
                Toast.makeText(AcademicActivity.this,"STUDENT ADDED SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });

    }
}