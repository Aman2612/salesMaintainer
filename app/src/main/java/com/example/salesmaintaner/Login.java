package com.example.salesmaintaner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText username,password;
    Button login;
    FirebaseAuth auth;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.sign_in_button);
        bar = findViewById(R.id.progressBar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bar.setVisibility(View.VISIBLE);
                auth = FirebaseAuth.getInstance();
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Empty email or password.",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            bar.setVisibility(View.GONE);
                            if(!task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Unable to sign in",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),SalesActivity.class));
                            }
                        }
                    });
                }


            }
        });
    }
}
