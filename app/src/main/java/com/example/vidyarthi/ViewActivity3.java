package com.example.vidyarthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class ViewActivity3 extends AppCompatActivity {
    ListView myListview3;
    TextView currentbehave,remarksbyin;
    Button done;
    List<current> studentlist3;
    current current;
    DatabaseReference studentDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view3);
        myListview3=findViewById(R.id.mylistview3);
        done=findViewById(R.id.done);
        currentbehave=findViewById(R.id.tvcurrentbehave);
        remarksbyin=findViewById(R.id.remarksbyin);
        studentlist3=new ArrayList<>();
        studentDbREf= FirebaseDatabase.getInstance().getReference("current");
        studentDbREf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentlist3.clear();


                for(DataSnapshot studentDatasnap:dataSnapshot.getChildren()){
                    current current= studentDatasnap.getValue(current.class);
                    studentlist3.add(current);


                }
                ListAdapter3 adapter=new ListAdapter3(ViewActivity3.this,studentlist3);


                myListview3.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

  /* done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDbREf= FirebaseDatabase.getInstance().getReference().child("current");
                current=new current();
                current.setCurrentbehave(currentbehave.getText().toString().trim());
                current.setRemarksbyin(remarksbyin.getText().toString().trim());



                studentDbREf.push().setValue(current);
                Toast.makeText(ViewActivity3.this,"STUDENT UPDATED SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });*/


    }
}