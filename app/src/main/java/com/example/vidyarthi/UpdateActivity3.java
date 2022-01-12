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

public class UpdateActivity3 extends AppCompatActivity {
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
                ListAdapter3 adapter=new ListAdapter3(UpdateActivity3.this,studentlist3);


                myListview3.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        myListview3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               current current =studentlist3.get(position);
                showUpdateDialog(current.getroll(),current.getRemarksbyin());




                return false;
            }
        });


    }

    private void showUpdateDialog(String roll,String remark)
    {
        AlertDialog.Builder mDialog= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View mDialogView=inflater.inflate(R.layout.update_dialog3,null);
        mDialog.setView(mDialogView);

        EditText updaterollnumber=mDialogView.findViewById(R.id.uprollnumber3);
        EditText updateremarksbyin=mDialogView.findViewById(R.id.upremarksbyin);
        Button updatebutton3=mDialogView.findViewById(R.id.upsubmit3);



        mDialog.setTitle("Updating"+remark+"record");

        mDialog.show();


        updatebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newrollnumber=updaterollnumber.getText().toString();
                String newremarksbyin=updateremarksbyin.getText().toString();

                current current=new current();
                // String idii=FirebaseDatabase.getInstance().getReference().child("personal").push().getKey();
                //String idii=personal.getId();
                updateData(newrollnumber,newremarksbyin);
                //    String id = FirebaseDatabase.getInstance().getReference("personal").getKey();
                Toast.makeText(UpdateActivity3.this,"STudent Updated",Toast.LENGTH_LONG).show();
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

    private void updateData(String uprollnumber,String upremarksbyin)
    {
        current current=new current();


        DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("current").child(uprollnumber);
        //  String id = Dbreff.child("personal").getKey();







        //String key = Dbreff.child("personal").push().getKey();

        //  personal personal=new personal();
        current.setroll(uprollnumber);
        current.setRemarksbyin(upremarksbyin);


        Dbreff.setValue(current);

        // Toast.makeText(UpdateActivity.this,id,Toast.LENGTH_LONG).show();
        //Dbreff.child("personal").child(id).push();
   /* DatabaseReference breff=FirebaseDatabase.getInstance().getReference("personal");
    String id = breff.push().getKey();*/
        //DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("personal").child(id);

        // Dbreff.setValue(personal);

        //Dbreff.setValue(personal);

    }


}