package com.example.vidyarthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
    ListView myListview;
    List<personal> studentlist;
    DatabaseReference studentDbREf;
    DatabaseReference Dbreff;
TextView tvfname;
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
                ListAdapter adapter=new ListAdapter(UpdateActivity.this,studentlist);

                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        myListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               personal personal =studentlist.get(position);
               showUpdateDialog(personal.getId(),personal.getFullname(),personal.getMothersname(),personal.getRollnumber(),personal.getEmail(),personal.getCollegeemail(),personal.getBloodgroup(),personal.getHobbies());




                return false;
            }
        });


    }

    private void showUpdateDialog(String id,String upfullname,String upmothersname,String uprollnumber,String upemail,String upcollegeemail,String upbloodgroup,String uphobbies)
    {
        AlertDialog.Builder mDialog= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View mDialogView=inflater.inflate(R.layout.update_dialog,null);
        mDialog.setView(mDialogView);

        EditText updatefullname=mDialogView.findViewById(R.id.upfullname);
        EditText updatemothersname=mDialogView.findViewById(R.id.upmothersname);
        EditText updaterollnumber=mDialogView.findViewById(R.id.uprollnumber);
        EditText updateemail=mDialogView.findViewById(R.id.upemail);
        EditText updatecollegeemail=mDialogView.findViewById(R.id.upcollegeemail);
        EditText updatebloodgroup=mDialogView.findViewById(R.id.upbloodgroup);
        EditText updatehobbies=mDialogView.findViewById(R.id.uphobbies);
        Button updatebutton=mDialogView.findViewById(R.id.upsubmit);


        mDialog.setTitle("Updating"+upfullname+"record");

        mDialog.show();


        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

String newfullname=updatefullname.getText().toString();
                String newmothersname=updatemothersname.getText().toString();

                String newrollnumber=updaterollnumber.getText().toString();

                String newemail=updateemail.getText().toString();

                String newcollegeemail=updatecollegeemail.getText().toString();
                String newbloodgroup=updatebloodgroup.getText().toString();

                String newhobbies=updatehobbies.getText().toString();
personal personal=new personal();
              // String idii=FirebaseDatabase.getInstance().getReference().child("personal").push().getKey();
                String idii=personal.getId();
       updateData(newfullname,newmothersname,newrollnumber,newemail,newcollegeemail,newbloodgroup,newhobbies);
            //    String id = FirebaseDatabase.getInstance().getReference("personal").getKey();
                Toast.makeText(UpdateActivity.this,"STudent Updated",Toast.LENGTH_LONG).show();
              //  tvfname.setText(personal.getFullname());
               /* TextView tvfname= findViewById(R.id.tvfname);
                String tvfm= tvfname.getText().toString().trim();*/
                /*DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal");
                String id = Dbreff.push().getKey();
                Log.d("ID",id);*/

               /* DatabaseReference breff=FirebaseDatabase.getInstance().getReference("personal").child(id);
                //  String id = Dbreff.child("personal").getKey();
                personal personal=new personal();



               /* map.put("/users/" + currentUserId + "/score/", 23);
                map.put("/user_detail_profile/" + currentUserId + "/claps/", 45);
                map.put("/user_detail_profile/" + currentUserId + "/comments/", 8);
             //   fbDbRefRoot.updateChildren(map);


                //String key = Dbreff.child("personal").push().getKey();

                //  personal personal=new personal();
                personal.setFullname(upfullname);
                personal.setMothersname(upmothersname);
                personal.setRollnumber(uprollnumber);
                //  personal.setRollnumber(rollnumber);
                personal.setEmail(upemail);
                personal.setCollegeemail(upcollegeemail);
                personal.setHobbies(uphobbies);
                personal.setBloodgroup(upbloodgroup);
               Map<String, Object> map = new HashMap<>();
                map.put("/personal/" + tvfname + "/name/", upfullname);
                breff.setValue(personal);*/
              //  Toast.makeText(UpdateActivity.this,id,Toast.LENGTH_LONG).show();

            }
        });
    }

private void updateData(String upfullname,String upmothersname,String uprollnumber,String upemail,String upcollegeemail,String upbloodgroup,String uphobbies)
{
    personal personal=new personal();


    DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal").child(uprollnumber);
  //  String id = Dbreff.child("personal").getKey();







   //String key = Dbreff.child("personal").push().getKey();

  //  personal personal=new personal();
    personal.setFullname(upfullname);
    personal.setMothersname(upmothersname);
    personal.setRollnumber(uprollnumber);
    //  personal.setRollnumber(rollnumber);
   personal.setEmail(upemail);
    personal.setCollegeemail(upcollegeemail);
    personal.setHobbies(uphobbies);
    personal.setBloodgroup(upbloodgroup);

    Dbreff.setValue(personal);

  // Toast.makeText(UpdateActivity.this,id,Toast.LENGTH_LONG).show();
    //Dbreff.child("personal").child(id).push();
   /* DatabaseReference breff=FirebaseDatabase.getInstance().getReference("personal");
    String id = breff.push().getKey();*/
    //DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal").child(id);

   // Dbreff.setValue(personal);

    //Dbreff.setValue(personal);

}


}