package com.example.a19f19312;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {
    private EditText ETD;
    private Button buttonDate;
    private TextView textViewDate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        // get ids for the views
        ETD=findViewById(R.id.ETD);
        buttonDate = findViewById(R.id.ButtonDate);
        textViewDate = findViewById(R.id.TVD);

       buttonDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               trimAndDisplayDate();
               Intent intent = new Intent(BookingActivity.this, styleActivity.class);
               startActivity(intent);
           }
       });
    }
    private void trimAndDisplayDate() {
        String inputDate = ETD.getText().toString().trim();


        // Display the date in the TextView
        textViewDate.setText("The appointment Date is: " + inputDate);

    }
}