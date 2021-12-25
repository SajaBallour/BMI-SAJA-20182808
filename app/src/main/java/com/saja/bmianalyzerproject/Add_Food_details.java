package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Add_Food_details extends AppCompatActivity {
    Timer t;
    EditText name,input_calory,input_category;
    Button save,updatePhoto;
    ImageView arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_details);

        arrow=findViewById(R.id.arrow);
        name=findViewById(R.id.name);
        input_calory=findViewById(R.id.input_calory);
        input_category=findViewById(R.id.input_category);
        save=findViewById(R.id.save);
        updatePhoto=findViewById(R.id.updatePhoto);

        arrow.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Home.class)));
        save.setOnClickListener(view -> { startActivity(new Intent(Add_Food_details.this,Home.class));});





        /*t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Add_Food_details.this, FoodList.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
    }
}