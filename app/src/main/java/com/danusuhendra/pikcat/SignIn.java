package com.danusuhendra.pikcat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.AuthResult;


import java.text.DateFormatSymbols;

public class SignIn extends AppCompatActivity {

    private EditText tv_email, tv_pwd;
    //private FirebaseAuthException auth;
    private Button btnSignIn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignIn.this, MainActivity.class));
            finish();
        }

        tv_email = (EditText) findViewById(R.id.tv_email);
        tv_pwd = (EditText) findViewById(R.id.tv_pwd);
        btnSignIn = (Button) findViewById(R.id.btn_signin);

        auth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tv_email.getText().toString();
                final String password = tv_pwd.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(getApplicationContext(), "Masukkan Email Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(getApplicationContext(), "Masukkan Password Anda", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    if (password.length() < 6) {
                                        tv_pwd.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(SignIn.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                        });

            }
        });

    }
}