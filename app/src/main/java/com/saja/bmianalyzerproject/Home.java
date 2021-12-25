package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.saja.bmianalyzerproject.OOP.Adapter;
import com.saja.bmianalyzerproject.OOP.BMIRecord;
import com.saja.bmianalyzerproject.OOP.User;

import java.util.ArrayList;
import java.util.Timer;

public class Home extends AppCompatActivity {
    Timer t;
    TextView logout;
    FirebaseAuth mAuth;
    RecyclerView recyclerView;
    ArrayList<BMIRecord> records;
    Adapter recordAdapter;
    Button add_record;
    Button add_food;
    Button view_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.Logout);
        add_record = findViewById(R.id.add_record_button);
        add_food = findViewById(R.id.add_food_button);
        view_food = findViewById(R.id.view_food_button);
        add_record.setOnClickListener(view -> btn_AddBMIRecord());
        add_food.setOnClickListener(view -> btn_AddFoodDetails());

        mAuth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.recyclerView);
        records = (new User()).getRecords();

        recordAdapter = new Adapter(Home.this, records);
        recyclerView.setAdapter(recordAdapter);

        logout.setOnClickListener( view -> {
            mAuth.signOut();
            startActivity(new Intent(Home.this,Login.class));

        });


    }

    public void btn_AddBMIRecord() {
        Intent intent = new Intent(Home.this, AddBMIRecord.class);
        startActivity(intent);
    }

    public void btn_AddFoodDetails() {
        Intent intent = new Intent(Home.this, Add_Food_details.class);
        startActivity(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();
        checkBMIChange();
    }

    private void checkBMIChange() {
    }

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
