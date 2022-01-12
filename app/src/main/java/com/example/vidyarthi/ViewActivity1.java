package com.example.vidyarthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class ViewActivity1 extends AppCompatActivity {
    ListView myListview1;
    List<academic> studentlist;
    DatabaseReference studentDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        myListview1=findViewById(R.id.mylistview1);
        studentlist=new ArrayList<>();
        studentDbREf= FirebaseDatabase.getInstance().getReference("academic");
        studentDbREf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentlist.clear();


                for(DataSnapshot studentDatasnap:dataSnapshot.getChildren()){
                    academic academic= studentDatasnap.getValue(academic.class);
                    studentlist.add(academic);


                }
                ListAdapter1 adapter1=new ListAdapter1(ViewActivity1.this,studentlist);

                myListview1.setAdapter(adapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}