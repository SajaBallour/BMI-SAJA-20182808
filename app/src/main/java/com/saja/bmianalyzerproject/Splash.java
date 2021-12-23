package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
//import android.view.View;

import java.util.Timer;
//import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    Button BNext;
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        BNext=findViewById(R.id.next_button);
       BNext.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Login.class)));
/*
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
    }
}