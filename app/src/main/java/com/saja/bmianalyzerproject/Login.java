package com.saja.bmianalyzerproject;

import static android.text.TextUtils.isEmpty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
//import java.util.TimerTask;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login;
    TextView signup;
    FirebaseAuth mAuth;
    //Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.Button_Login);
        signup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();

     /*   signup.setOnClickListener(v -> {

            startActivity(new Intent(Login.this,Registration.class));
        });*/
        login.setOnClickListener((View.OnClickListener) view -> login(username.getText().toString(), password.getText().toString()));
        signup.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Registration.class)));




    }
    private void login(String userName, String userPassword) {
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
    }
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