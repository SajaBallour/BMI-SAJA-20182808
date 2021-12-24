package com.saja.bmianalyzerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;

public class Login extends AppCompatActivity {
    EditText Username;
    EditText Password;
    Button Login;
    TextView Signup;
    FirebaseAuth mAuth;
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username=findViewById(R.id.username);
        Password =findViewById(R.id.password);
        Login =findViewById(R.id.Button_Login);
        Signup =findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
        Login.setOnClickListener(view ->{
            login();
        });
        Signup.setOnClickListener(view -> {

            startActivity(new Intent(Login.this,Registration.class));
        });

    }

    private void login() {
        String username =  Username.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (TextUtils.isEmpty(username)){
            Username.setError("You must enter Username");
           Username.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            Password.setError("You must enter Password");
            Password.requestFocus();
        }else {

            mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        checkEmail();
                    }else{
                        Toast.makeText(Login.this, "Login Error: "+task.getException().getLocalizedMessage() + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }

    }
    private void checkEmail(){
        FirebaseUser users=FirebaseAuth.getInstance().getCurrentUser();
        if(users.isEmailVerified()){
            Toast.makeText(this,"Verify the Email Id",Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            finish();
        }
        else {
            Username.getText().clear();
            Password.getText().clear();
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
        }
    }


    /*private void login(String userName, String userPassword) {
        if(username.getText().toString().equals("saja") && password.getText().toString().equals("saja")){
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
        }
        else {
            if (isEmpty(userName))
                username.setError("You must enter username to login!");
            if (isEmpty(userPassword))
                password.setError("You must enter Password to login!");
        }
    }*/
    /*
    t = new Timer();
        t.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(Login.this, Registration.class);
            startActivity(intent);
            finish();
        }
    },5000);*/


}