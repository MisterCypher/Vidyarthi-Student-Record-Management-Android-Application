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

public class UpdateActivity1 extends AppCompatActivity {
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
                ListAdapter1 adapter1=new ListAdapter1(UpdateActivity1.this,studentlist);

                myListview1.setAdapter(adapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        myListview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               academic academic=studentlist.get(position);
                showUpdateDialog(academic.getTenmarks(),academic.getTwelvemarks(),academic.getGraduationmarks(),academic.getRoll(),academic.getSeatnumber());




                return false;
            }
        });


    }

    private void showUpdateDialog(int upten,int uptwelve,int upgrad,String uproll,int upseat)
    {
        AlertDialog.Builder mDialog= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View mDialogView=inflater.inflate(R.layout.update_dialog1,null);
        mDialog.setView(mDialogView);

        EditText updatenamrks=mDialogView.findViewById(R.id.uptenmarks);
        EditText updatetwelvemarks=mDialogView.findViewById(R.id.uptwelvemarks);
        EditText updategraduation=mDialogView.findViewById(R.id.upgraduationmarks);
        EditText updaterollnumber=mDialogView.findViewById(R.id.uprollnumber1);
        EditText updateseatnumber=mDialogView.findViewById(R.id.upseatnumber);
        Button updatebutton=mDialogView.findViewById(R.id.upsubmit1);


        mDialog.setTitle("Updating"+uptwelve+"record");

        mDialog.show();


        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newtenmarks=updatenamrks.getText().toString();
                String newtwelvemarks=updatetwelvemarks.getText().toString();

                String newgraduation=updategraduation.getText().toString();

                String newrollnumber=updaterollnumber.getText().toString();

                String newseatbutton=updateseatnumber.getText().toString();
                academic academic=new academic();
                // String idii=FirebaseDatabase.getInstance().getReference().child("personal").push().getKey();

                updateData(newtenmarks,newtwelvemarks,newgraduation,newrollnumber,newseatbutton);
                //    String id = FirebaseDatabase.getInstance().getReference("personal").getKey();
                Toast.makeText(UpdateActivity1.this,"STudent Updated",Toast.LENGTH_LONG).show();
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

    private void updateData(String uptenamrks,String uptwelveemarks,String upgrad,String uprollnumber,String upseatnumber)
    {
        academic academic=new academic();


        DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("academic").child(uprollnumber);
        //  String id = Dbreff.child("personal").getKey();







        //String key = Dbreff.child("personal").push().getKey();

        //  personal personal=new personal();
        int upte=Integer.parseInt(uptenamrks.toString().trim());
        int uptw=Integer.parseInt(uptwelveemarks.toString().trim());
        int upg=Integer.parseInt(upgrad.toString().trim());
        int ups=Integer.parseInt(upseatnumber.toString().trim());

        academic.setTenmarks(upte);
        academic.setTwelvemarks(uptw);
        academic.setGraduationmarks(upg);
        //  personal.setRollnumber(rollnumber);
        academic.setRoll(uprollnumber);
        academic.setSeatnumber(ups);

        Dbreff.setValue(academic);

        // Toast.makeText(UpdateActivity.this,id,Toast.LENGTH_LONG).show();
        //Dbreff.child("personal").child(id).push();
   /* DatabaseReference breff=FirebaseDatabase.getInstance().getReference("personal");
    String id = breff.push().getKey();*/
        //DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal").child(id);

        // Dbreff.setValue(personal);

        //Dbreff.setValue(personal);

    }


}