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

public class ViewActivity extends AppCompatActivity {
ListView myListview;
List<personal> studentlist;
DatabaseReference studentDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
   myListview=findViewById(R.id.mylistview);
   studentlist=new ArrayList<>();
   studentDbREf= FirebaseDatabase.getInstance().getReference("personal");
   studentDbREf.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           studentlist.clear();


           for(DataSnapshot studentDatasnap:dataSnapshot.getChildren()){
              personal personal= studentDatasnap.getValue(personal.class);
              studentlist.add(personal);


          }
ListAdapter adapter=new ListAdapter(ViewActivity.this,studentlist);

myListview.setAdapter(adapter);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError error) {

       }
   });
    }
}