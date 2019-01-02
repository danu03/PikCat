package com.danusuhendra.pikcat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingUp extends AppCompatActivity {

    Button      btn_sign_up;
    TextView    txt_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUp.this, SignIn.class);
                startActivity(intent);
            }
        });

        txt_sign_in = (TextView) findViewById(R.id.txt_sign_in);
        txt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUp.this, SignIn.class);
                startActivity(intent);
            }
        });

    }
}
