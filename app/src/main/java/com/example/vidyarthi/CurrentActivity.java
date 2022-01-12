package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CurrentActivity extends AppCompatActivity {
    EditText currentbehave,remarksbyin;
    Button subbutton2;
    DatabaseReference reff1;
    current current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        currentbehave=findViewById(R.id.curentbehave);
        remarksbyin=findViewById(R.id.remarksbyin);
        subbutton2=findViewById(R.id.submit4);
        current=new current();
        reff1= FirebaseDatabase.getInstance().getReference().child("current");
        subbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               current.setroll(currentbehave.getText().toString().trim());
                current.setRemarksbyin(remarksbyin.getText().toString().trim());

                String rolln= currentbehave.getText().toString().trim();

                reff1.child(rolln).setValue(current);
              //  reff1.push().setValue(current);
                Toast.makeText(CurrentActivity.this,"STUDENT ADDED SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });

    }
}