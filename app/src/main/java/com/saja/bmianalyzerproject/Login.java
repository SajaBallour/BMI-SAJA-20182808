package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class Login extends AppCompatActivity {
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    t = new Timer();
        t.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(Login.this, Registration.class);
            startActivity(intent);
            finish();
        }
    },5000);
}
}