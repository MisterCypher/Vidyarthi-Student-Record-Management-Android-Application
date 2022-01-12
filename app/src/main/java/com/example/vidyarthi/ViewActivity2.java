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

public class ViewActivity2 extends AppCompatActivity {
    ListView myListview2;
    List<extra> studentlist2;
    DatabaseReference studentDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view22);
        myListview2=findViewById(R.id.mylistview2);
        studentlist2=new ArrayList<>();
        studentDbREf= FirebaseDatabase.getInstance().getReference("extra");
        studentDbREf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentlist2.clear();


                for(DataSnapshot studentDatasnap:dataSnapshot.getChildren()){
                    extra extra= studentDatasnap.getValue(extra.class);
                    studentlist2.add(extra);


                }
                ListAdapter2 adapter=new ListAdapter2(ViewActivity2.this,studentlist2);

                myListview2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}