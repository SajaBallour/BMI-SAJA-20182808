package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    Timer t;
    TextView logout;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.Logout);
        mAuth = FirebaseAuth.getInstance();
        logout.setOnClickListener( view -> {
            mAuth.signOut();
            startActivity(new Intent(Home.this,Login.class));

        });

        /*t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Home.this, AddBMIRecord.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
    }
}