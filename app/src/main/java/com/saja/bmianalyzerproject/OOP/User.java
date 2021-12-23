/*package com.saja.bmianalyzerproject.OOP;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.saja.bmianalyzerproject.R;

import java.util.ArrayList;

public class User {

    private ArrayList<BMIRecord> records;
    private ArrayList<Food> foods;
    private String name,email,password;
    public  static User user;
    private FirebaseAuth mAuth;
    public User(String name, String email, String password, String re_password, AppCompatActivity context) throws UserInfoException {
        if(!name.matches("[A-Za-z \\s]+")) throw new UserInfoException("name");
        if(!email.matches("[A-Za-z][\\w]{0,31}@[\\w]{2,10}\\.com")) throw new UserInfoException("email");
        if(!password.equals(re_password))throw new UserInfoException("re_password");
        if(password.length()<3)throw new UserInfoException("re_password");
        this.name=name;
        this.password=password;
        this.email=email;
        FireBaseConnection.registration(this,context);
    }

    public User() {

        this.records = new ArrayList<BMIRecord>();
        records.add(new BMIRecord(80, 170, "9/12/2021", "Normal"));
        records.add(new BMIRecord(70, 190, "9/1/2021", "Normal"));
        records.add(new BMIRecord(50, 150, "1/5/2021", "Normal"));
        this.foods= new ArrayList<Food>();
        foods.add(new Food("Salamon", "Fish", "22 cal/g", R.drawable.salamon));
        foods.add(new Food("Rais", "Carbohydrates", "30 cal/g",R.drawable.raise));
        foods.add(new Food("Apple", "Fruit", "4 cal/g",R.drawable.apple));
        foods.add(new Food("Orange", "Fruit", "2 cal/g",R.drawable.orange));
    }

    public FirebaseAuth getmAuth(){return  mAuth;}
    public void setmAuth(FirebaseAuth mAuth){this.mAuth=mAuth;   }

    public User(String email,String password){
        this.email=email;
        this.password=password; }

    public ArrayList<BMIRecord> getRecords() {
        return records;
    }
    public ArrayList<Food> getFood() {
        return foods;
    }

    public String getEmail() {return email; }

    public String getPassword() {return password; }

    public String getName() {return  name; }


    public int getHomeMassege() {
        return 1;
    }

    public boolean isNewUser() {
    }

    public void updateLists(DataSnapshot dataSnapshot, AppCompatActivity context) {
    }
}
*/