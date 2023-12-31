package com.example.a19f19312;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //get id for all views
        user=(EditText) findViewById(R.id.ed1);
        pass=(EditText) findViewById(R.id.ed2);
        login=(Button) findViewById(R.id.b1);
        register=(Button) findViewById(R.id.b2);

        // button code for the login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String p = pass.getText().toString();

                // login validation logic
                if (isValidLogin(u, p)) {
                    showToast("Login has been successful");

                    // for the next user activity
                    Intent intent = new Intent(LoginActivity.this, BookingActivity.class);
                    startActivity(intent);
                } else {
                    showToast("Login failed. Invalid Identification.");
                }
            }
        });

        // button code for the register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(obj);
            }
        });
    }


    private boolean isValidLogin(String username, String password) {

        return !username.isEmpty() && !password.isEmpty();
    }

    private void showToast(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }
}