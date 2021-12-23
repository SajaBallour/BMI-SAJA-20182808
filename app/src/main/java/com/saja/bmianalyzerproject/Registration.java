package com.saja.bmianalyzerproject;

//import androidx.annotation.NonNull;
import static com.saja.bmianalyzerproject.R.layout.activity_registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
//import java.util.Timer;
import android.widget.Toast;
//import java.util.TimerTask;
import android.widget.TextView;
//import android.view.View;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Registration extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText repassword;
    private Button create;
    private TextView login;
    //Timer timer;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = findViewById(R.id.name);
        email = findViewById(R.id.E_mail);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.re_password);

        create = findViewById(R.id.Button_Login);
        login = findViewById(R.id.login_text);

        mAuth = FirebaseAuth.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        login.setOnClickListener(view -> startActivity(new Intent(Registration.this, Login.class)));
    }
    private void createUser(){
        String Name =  name.getText().toString().trim();
        String Email =  email.getText().toString().trim();
        String Password =  password.getText().toString().trim();
        // String user_repassword =  repassword.getText().toString();
        if (Email.isEmpty()){
        email.setError("You must enter Email");
        }else if(Password.isEmpty()){
        password.setError("You must enter password");
        }else if(Name.isEmpty()){
        name.setError("You must enter name");
        }else
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                Toast.makeText(Registration.this, "Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Registration.this, Home.class));
            } else {
                Toast.makeText(Registration.this, "error" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();

            }}
        });
}
}

        /* timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Registration.this,Complete_Information.class);
                startActivity(intent);
                finish();
            }
        },5000);*/