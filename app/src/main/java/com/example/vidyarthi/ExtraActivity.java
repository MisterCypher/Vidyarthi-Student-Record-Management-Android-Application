package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExtraActivity extends AppCompatActivity {
    EditText cert,sport,semi,course,other;
    Button subbutto;
    DatabaseReference reff1;
    extra extra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        cert=findViewById(R.id.cert);
        sport=findViewById(R.id.sport);
        semi=findViewById(R.id.semi);
        course=findViewById(R.id.course);
        other =findViewById(R.id.other);
        subbutto=findViewById(R.id.submi);
        extra=new extra();
        reff1= FirebaseDatabase.getInstance().getReference().child("extra");
        subbutto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               extra.setCert(cert.getText().toString().trim());
                extra.setSport(sport.getText().toString().trim());
                extra.setSemi(semi.getText().toString().trim());
                extra.setCourse(course.getText().toString().trim());
                extra.setrollextra(other.getText().toString().trim());


                String rolln= other.getText().toString().trim();

                reff1.child(rolln).setValue(extra);
               // reff1.push().setValue(extra);
                Toast.makeText(ExtraActivity.this,"STUDENT ADDED SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });

    }
}