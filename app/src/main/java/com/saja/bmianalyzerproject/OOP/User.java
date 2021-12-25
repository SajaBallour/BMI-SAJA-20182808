package com.saja.bmianalyzerproject.OOP;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class User {
    private final ArrayList<BMIRecord> records;
    public static User user;
    private FirebaseAuth mAuth;
    private boolean male;
    public User(){
        this.records= new ArrayList<>();
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));

    }
    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }
    public  boolean isMale() {return male;}

    public static User getUser() {
        return user;
    }
    public String getGender(){ return this.isMale()?"Male":"Female";}
    //public boolean setGender(){ return this.setMale(gender().equalsIgnoreCase("Male"));}





    public ArrayList<BMIRecord> getRecords(){
        return records;
    }
}
