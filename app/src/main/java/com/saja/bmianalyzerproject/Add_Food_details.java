package com.saja.bmianalyzerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.saja.bmianalyzerproject.OOP.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Add_Food_details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Timer t;

    ImageView arrow;
    Button uploadPhoto,save;
    private String saveCurrentDate, saveCurrentTime;
    String name,category,calory, key;

    private String chaletRandomKey, downloadImageUrl;

    private DatabaseReference Ref;
    private ProgressDialog loadingBar;
    FirebaseAuth mAuth;
    private FirebaseDatabase database;
    EditText ed_name_food,ed_calory;

    String[] country = { " Fruit and vegetables", "Starchy food", "Dairy", "Protein", "Fat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_details);
        arrow.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Home.class)));
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        Ref = FirebaseDatabase.getInstance().getReference("BMI");
        loadingBar = new ProgressDialog(this);

        Spinner spin =  findViewById(R.id.spinner_category);
        ed_name_food =  findViewById(R.id.name);
        ed_calory =  findViewById(R.id.input_calory);
        save =  findViewById(R.id.save);
        uploadPhoto =  findViewById(R.id.updatePhoto);
        spin.setOnItemSelectedListener(Add_Food_details.this);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = spin.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateProductData();
            }
        });
    }
    private void ValidateProductData() {
        name = ed_name_food.getText().toString();
        calory = ed_calory.getText().toString();


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please write name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(category)) {
            Toast.makeText(this, "Please write category", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(calory)) {
            Toast.makeText(this, "Please write calory", Toast.LENGTH_SHORT).show();
        } else {
            StoreProductInformation();
        }
    }


    private void StoreProductInformation() {
        loadingBar.setMessage("we are adding the new Food");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        chaletRandomKey = saveCurrentDate + " " + saveCurrentTime;

        final UploadTask uploadTask = null;

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message = e.toString();
                Toast.makeText(Add_Food_details.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        });
    }

    private void SaveProductInfoToDatabase() {
            HashMap<String, Object> ChaletMap = new HashMap<>();
            ChaletMap.put("name", name);
            ChaletMap.put("calory", calory+" cal /g");
            ChaletMap.put("category", category);
            ChaletMap.put("date", saveCurrentDate);
            ChaletMap.put("time", saveCurrentTime);
            ChaletMap.put("key", key);

            key = FirebaseDatabase.getInstance().getReference("Users").push().getKey();
            Ref=database.getReference("BMI");
            Ref.child("Food").child(key).updateChildren(ChaletMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                loadingBar.dismiss();
                                Toast.makeText(Add_Food_details.this, "added successfully..", Toast.LENGTH_SHORT).show();

                            } else {
                                loadingBar.dismiss();
                                String message = task.getException().toString();
                                Toast.makeText(Add_Food_details.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

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
