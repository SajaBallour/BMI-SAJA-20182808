package com.saja.bmianalyzerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saja.bmianalyzerproject.OOP.Adapter;
import com.saja.bmianalyzerproject.OOP.Food;

import java.util.ArrayList;
import java.util.Timer;

public class FoodList extends AppCompatActivity {
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_food_list);

        RecyclerView list_food;
        final Adapter[] adapter = new Adapter[1];
        Food Food = null;
        DatabaseReference Ref;
        ArrayList<com.saja.bmianalyzerproject.OOP.Food> models;
            setContentView(R.layout.activity_food_list);

            list_food = findViewById(R.id.list_food);
            Ref = FirebaseDatabase.getInstance().getReference().child("BMI").child("Food");

            models = new ArrayList<>();
            list_food.setLayoutManager(new LinearLayoutManager(FoodList.this));


            Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    models.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                       models.add(Food);

                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


        /*t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(FoodList.this, EditFood.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
    }
