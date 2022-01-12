package com.example.vidyarthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

public class UpdateActivity2 extends AppCompatActivity {
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
                ListAdapter2 adapter=new ListAdapter2(UpdateActivity2.this,studentlist2);

                myListview2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListview2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                extra extra =studentlist2.get(position);
                showUpdateDialog(extra.getCert(),extra.getSport(),extra.getCourse(),extra.getSemi(),extra.getrollextra());




                return false;
            }
        });


    }

    private void showUpdateDialog(String cert,String sport,String course,String seminar,String rollunmber)
    {
        AlertDialog.Builder mDialog= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View mDialogView=inflater.inflate(R.layout.update_dialog2,null);
        mDialog.setView(mDialogView);

        EditText updatecert=mDialogView.findViewById(R.id.upcert);
        EditText updatesport=mDialogView.findViewById(R.id.upsport);
        EditText updatecourse=mDialogView.findViewById(R.id.upcourse);
        EditText updateseminar=mDialogView.findViewById(R.id.upseminar);
        EditText updaterollnumber=mDialogView.findViewById(R.id.uprollnumber2);
        Button updatebutton=mDialogView.findViewById(R.id.upsubmit2);


        mDialog.setTitle("Updating"+sport+"record");

        mDialog.show();


        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newcert=updatecert.getText().toString();
                String newsport=updatesport.getText().toString();

                String newrollnumber=updaterollnumber.getText().toString();

                String newcourse=updatecourse.getText().toString();

                String newseminar=updateseminar.getText().toString();
                extra extra=new extra();
                // String idii=FirebaseDatabase.getInstance().getReference().child("personal").push().getKey();
                //String idii=personal.getId();
                updateData(newcert,newsport,newcourse,newseminar,newrollnumber);
                //    String id = FirebaseDatabase.getInstance().getReference("personal").getKey();
                Toast.makeText(UpdateActivity2.this,"STudent Updated",Toast.LENGTH_LONG).show();
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

    private void updateData(String upcert,String upsport,String upcourse,String upsemi,String uprollnumber)
    {
        extra extra=new extra();


        DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("extra").child(uprollnumber);
        //  String id = Dbreff.child("personal").getKey();







        //String key = Dbreff.child("personal").push().getKey();

        //  personal personal=new personal();
        extra.setCert(upcert);
        extra.setSport(upsport);
        extra.setSemi(upsemi);
        //  personal.setRollnumber(rollnumber);
        extra.setCourse(upcourse);
        extra.setrollextra(uprollnumber);


        Dbreff.setValue(extra);

        // Toast.makeText(UpdateActivity.this,id,Toast.LENGTH_LONG).show();
        //Dbreff.child("personal").child(id).push();
   /* DatabaseReference breff=FirebaseDatabase.getInstance().getReference("personal");
    String id = breff.push().getKey();*/
        //DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal").child(id);

        // Dbreff.setValue(personal);

        //Dbreff.setValue(personal);

    }


}