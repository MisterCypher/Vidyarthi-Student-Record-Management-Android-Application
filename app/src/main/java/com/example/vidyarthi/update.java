package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class update extends AppCompatActivity {
    EditText currentbehave,remarksbyin;
    Button done;
    current current;
    DatabaseReference studentDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abcd);
        done=findViewById(R.id.done);
        currentbehave=findViewById(R.id.tvcurrentbehav);
        remarksbyin=findViewById(R.id.tvremarksbyi);
        studentDbREf= FirebaseDatabase.getInstance().getReference("current");
        current=new current();
        //studentDbREf= FirebaseDatabase.getInstance().getReference().child("current");





        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                current.setroll(currentbehave.getText().toString().trim());
                current.setRemarksbyin(remarksbyin.getText().toString().trim());



                studentDbREf.push().setValue(current);
                Toast.makeText(update.this,"STUDENT UPDATED SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });

    }
}