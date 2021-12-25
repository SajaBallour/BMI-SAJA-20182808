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

import java.util.Timer;

public class Registration extends AppCompatActivity {

    EditText Name,Email,Password,RePassword;
    Button Create;
    TextView Login;
    Timer timer;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name = findViewById(R.id.name);
        Email = findViewById(R.id.E_mail);
        Password = findViewById(R.id.password);
        RePassword = findViewById(R.id.re_password);
        Login=findViewById(R.id.login_text);
        Create = findViewById(R.id.create);
        mAuth = FirebaseAuth.getInstance();

        Create.setOnClickListener(view ->{
            AddNewUser();

        });

        Login.setOnClickListener(view -> {
            startActivity(new Intent(Registration.this,Login.class));
        });
    }

    private void AddNewUser() {
        String name =  Name.getText().toString();
        String email =  Email.getText().toString();
        String password =  Password.getText().toString();
        String repassword =  RePassword.getText().toString();

        if(TextUtils.isEmpty(name)){
            Name.setError("You must enter Username");
            Name.requestFocus();
        }else if (TextUtils.isEmpty(email)){
            Email.setError("You must enter Email");
            Email.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            Password.setError("You must enter password");
            Password.requestFocus();
        }else if(TextUtils.isEmpty(repassword)){
            RePassword.setError("You must enter Re-Password");
            RePassword.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Registration.this,"Successful" ,Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Registration.this,CompleteInformation.class));
                    }else {
                        Toast.makeText(Registration.this,"error" + task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
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