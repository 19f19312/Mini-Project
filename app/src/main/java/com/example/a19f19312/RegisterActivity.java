package com.example.a19f19312;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText name, pass, email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // getting id for all views
        name = findViewById(R.id.e1);
        pass = findViewById(R.id.e2);
        email = findViewById(R.id.e3);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mn = name.getText().toString();
                String ps = pass.getText().toString();
                String em = email.getText().toString();

                if (isValidRegistration(mn, ps, em)) {
                    // Successful registration: this is where the user adds the logic for registration.
                    showToast("Registration is successful");


                    Intent obj1 = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(obj1);
                } else {
                    showToast("Registration failed.");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private boolean isValidRegistration(String username, String password, String email) {

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            // The registration process will be deemed unsuccessful if any fields are left unfilled.
            return false;
        }


        return true; // Consider the registration successful if all validation is successful.
    }
}