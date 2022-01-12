package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PersonActivity extends AppCompatActivity {
EditText fullname,mothersname,roll,email,collegeemail,bloodgroup,hobbies;
Button submit;
public DatabaseReference reff;
public personal personal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        fullname=findViewById(R.id.fullname);
        mothersname=findViewById(R.id.mothersname);
        roll=findViewById(R.id.rollnumber);
        email=findViewById(R.id.email);
        collegeemail=findViewById(R.id.collegeemail);
        bloodgroup=findViewById(R.id.bloodgroup);
        hobbies=findViewById(R.id.hobbies);
        submit=findViewById(R.id.submit);
        personal=new personal();
        String number =roll.toString().trim();
reff= FirebaseDatabase.getInstance().getReference().child("personal");
        String di=reff.toString().trim();
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      //  int rollnumber=Integer.parseInt(roll.getText().toString().trim());

        //personal.setId(di);
        personal.setFullname(fullname.getText().toString().trim());
        personal.setMothersname(mothersname.getText().toString().trim());
         personal.setRollnumber(roll.getText().toString().trim());
      //  personal.setRollnumber(rollnumber);
       personal.setEmail(email.getText().toString().trim());
        personal.setCollegeemail(collegeemail.getText().toString().trim());
        personal.setHobbies(hobbies.getText().toString().trim());
        personal.setBloodgroup(bloodgroup.getText().toString().trim());
     /*   String fname= fullname.getText().toString().trim();
        String mname= mothersname.getText().toString().trim();
        String rolln= roll.getText().toString().trim();
        String emaill= email.getText().toString().trim();
        String cmail= collegeemail.getText().toString().trim();
        String hob= hobbies.getText().toString().trim();
        String bg= bloodgroup.getText().toString().trim();
        personal personal=new personal(fname,mname,rolln,emaill,cmail,hob,bg);*/


        String rolln= roll.getText().toString().trim();

        reff.child(rolln).setValue(personal);

        Toast.makeText(PersonActivity.this,"STUDENT ADDED SUCCESSFULLY",Toast.LENGTH_LONG).show();
       /* Intent intToMain=new Intent(PersonActivity.this,AcademicActivity.class);
        startActivity(intToMain);*/
    }
});
    }
}