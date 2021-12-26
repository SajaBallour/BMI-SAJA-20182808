package com.saja.bmianalyzerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.saja.bmianalyzerproject.OOP.Food;

import java.util.HashMap;

public class EditFood extends AppCompatActivity {
    ImageView Photo;
    EditText editName, editCalory;
    Button uploadPhoto,save;
    DatabaseReference Ref;
    String name,calory, key;
    Spinner dropdown_caloryView2;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);
        Ref = FirebaseDatabase.getInstance().getReference().child("BMI").child("Food").child(key);

        editName = findViewById(R.id.editName);
        dropdown_caloryView2 = findViewById(R.id.dropdown_caloryView2);
        editCalory = findViewById(R.id. editCalory);
        save= findViewById(R.id.save);

        Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    key = snapshot.child("key").getValue().toString();
                    Food viewFood = snapshot.getValue(Food.class);
                    editName.setText(viewFood.getName());
                    editCalory.setText(viewFood.getCalory()+"");
                    dropdown_caloryView2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            category = dropdown_caloryView2.getItemAtPosition(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StoreProductInformation();
                SaveProductInfoToDatabase();

                finish();
            }

        });



    }




    private void StoreProductInformation()
    {


        final UploadTask uploadTask = null;
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                String message = e.toString();
                Toast.makeText(EditFood.this, "Error: " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void SaveProductInfoToDatabase()
    {
        name = editName.getText().toString();
        calory = editCalory.getText().toString();

        HashMap<String, Object> ChaletMap = new HashMap<>();
        ChaletMap.put("name", name);
        ChaletMap.put("calory", calory);
        ChaletMap.put("category", category);

        Ref.updateChildren(ChaletMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(EditFood.this, "UpData", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    }
