package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.BreakIterator;

public class DeleteActivity3 extends AppCompatActivity {
    EditText rollnumbe3;
    Button deletebutton;
    DatabaseReference reff;
   current current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete4);

        deletebutton=findViewById(R.id.delete4);
        rollnumbe3=findViewById(R.id.roll4);
        current=new current();
        // reff= FirebaseDatabase.getInstance().getReference("personal").child("stu");
        deletebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rollnumbe3=findViewById(R.id.roll4);
                int rollnumber=Integer.parseInt(rollnumbe3.getText().toString().trim());
                //   String id= rollnumbe.getText().toString().trim();*/
                deletestudent(rollnumber);

                //    reff.child("rollnumber").setValue(null);
            }
        });
    }

    private void deletestudent(int rollnumber) {
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("current").child(String.valueOf(rollnumber));
        reff.removeValue();
        Toast.makeText(DeleteActivity3.this,"STUDENT DELETED SUCCESSFULLY",Toast.LENGTH_LONG).show();
    }




    /*private void deletestudent(String id) {
        DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("personal");
        reff.child(id).removeValue();

        Toast.makeText(DeleteActivity.this,"STUDENT DELETED SUCCESSFULLY",Toast.LENGTH_LONG).show();
    }*/


}