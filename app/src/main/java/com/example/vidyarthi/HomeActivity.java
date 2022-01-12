package com.example.vidyarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
Button btnLogout, addbutton,viewbutton,updatebutton,deletebutton,contactbutton;
FirebaseAuth mFirebaseAuth;
private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout=findViewById(R.id.logout);
        addbutton =findViewById(R.id.add);
        viewbutton =findViewById(R.id.view);
        updatebutton =findViewById(R.id.update);
        deletebutton =findViewById(R.id.delete);
        contactbutton=findViewById(R.id.login);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intToMain);
            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(HomeActivity.this,AddActivity.class);
                startActivity(intToMain);
            }
        });
        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(HomeActivity.this,View2Activity.class);
                startActivity(intToMain);
            }
        });
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(HomeActivity.this,Update2Activity.class);
                startActivity(intToMain);
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(HomeActivity.this,Delete2Activity.class);
                startActivity(intToMain);
            }
        });
       contactbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToMain=new Intent(HomeActivity.this,Contactus.class);
                startActivity(intToMain);
            }
        });



    }
}