/*
package com.saja.bmianalyzerproject.OOP;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.saja.bmianalyzerproject.OOP.User;
import com.saja.bmianalyzerproject.CompleteInformation;
import com.saja.bmianalyzerproject.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;


import java.util.Date;

public class FireBaseConnection {


    public static void registration(@NonNull User user, AppCompatActivity context) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        user.setmAuth(mAuth);
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    creatUserDate(context, user);
                } else {
                    Toast.makeText(context, "Error,can't add User on firebase:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void login_user(AppCompatActivity context) {
        try {
            User.user.setmAuth(FirebaseAuth.getInstance());
            User.user.getmAuth().signInWithEmailAndPassword(User.user.getEmail(), User.user.getPassword()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        User.user.setmAuth(FirebaseAuth.getInstance());
                        addListenerForUserUpdate(context);
                        DB.getCurrentUserName().child("login").setValue(new Date().toString());
                        Intent x;
                        if (User.user.isNewUser())
                            x = new Intent(context, CompleteInformation.class);
                        else
                            x = new Intent(context, Home.class);
                        context.startActivity(x);
                        context.finish();
                    } else {
                        Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        ;
                    }
                }


            });

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    private static void addListenerForUserUpdate(AppCompatActivity context) {
        DB.getCurrentUserData().addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User.user.updateLists(dataSnapshot,context);
                Home.checkBMIChange();
            }

            @Override
            public void  onCancelled(DatabaseError error){}
        });
    }
    public static void  addFood(BMIFood foods){
        String key=DB.getCurrentUserBMIFood().push().getKey();
        foods.setId(key);
        DB.getCurrentUserBMIFood().child(key).setValue(foods);
    }
    public static void  removeFood(BMIFood food){
        DB.getCurrentUserBMIFood().child(food.getId()).removeValue();
    }
    public static void addBMIRecord(BMIRecord records) {
        String key=DB.getCurrentUserBMIRecord().push().getKey();
        records.setId(key);
        DB.getCurrentUserBMIRecord().child(key).setValue(records); }
    public static void removeBMIRecord(BMIRecord record){
        DB.getCurrentUserBMIRecord().child(record.getId()).removeValue();
    }


    public static class DB {
        public static DatabaseReference getUser() {
            return FirebaseDatabase.getInstance().getReference("Users");
        }

        public static DatabaseReference getCurrentUserData() {
            return getUser().child(User.user.getmAuth().getCurrentUser().getUid());
        }

        public static DatabaseReference getCurrentUserBMIFood() {
            return getCurrentUserData().child("Food");
        }

        public static DatabaseReference getCurrentUserBMIRecord() {
            return getCurrentUserData().child("Record");
        }

        public static DatabaseReference getCurrentUserName() {
            return getCurrentUserData().child("name");
        }
        public static DatabaseReference getCurrentUserBirthDay() {
            return getCurrentUserData().child("birthday");
        }
        public static DatabaseReference getCurrentUserGender() {
            return getCurrentUserData().child("gender");
        }
    }
    public static void logout(){User.user.getmAuth().signOut();}


    private static void creatUserDate(AppCompatActivity context, User user) {
        try {
            DB.getCurrentUserName().setValue(user.getName()).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context, "Failed to create User record:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(@NonNull Void aVoid) {
                    move(context);
                }
            });
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    public static void move(AppCompatActivity context) {

    }

    public static void completeUserData(User user) {
    }

    public static void createUserData(AppCompatActivity context, User user) {
    }


}*/