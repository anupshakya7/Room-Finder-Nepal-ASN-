package com.example.roomfindernepalasn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login_Page extends AppCompatActivity {
    EditText Email,Password;
    Button btnLogin,btnRegister;
    private TextView forgotPassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        Email=(EditText)findViewById(R.id.eAddress);
        Password=(EditText) findViewById(R.id.pWord);
        btnLogin=(Button)findViewById(R.id.loginBtn);
        btnRegister=(Button)findViewById(R.id.registerBtn);
        forgotPassword=(TextView)findViewById(R.id.tvForgetPassword);

        firebaseAuth=FirebaseAuth.getInstance();

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this,PasswordActivity.class));
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String email=Email.getText().toString().trim();
                final String password=Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login_Page.this, "Enter Your Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login_Page.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(Password.length()<8){
                    Toast.makeText(Login_Page.this,"Password Too Short",Toast.LENGTH_SHORT).show();
                    return;
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_Page.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                    Toast.makeText(Login_Page.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                    finish();


                                } else {
                                    Toast.makeText(Login_Page.this,"Login Failed or User Not Available",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Signup_Page.class));
            }
        });
    }

}
