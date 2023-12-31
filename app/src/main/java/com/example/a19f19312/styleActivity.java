package com.example.a19f19312;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class styleActivity extends AppCompatActivity {
    private CheckBox ForHair, ForBeard;
    private Button btnConfirmAppointment, closebutton;
    private TextView txSelectedServices;

    // Prices for services
    private static final double PRICE_HAIR = 2.000;
    private static final double PRICE_BEARD = 1.000;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        ForHair = findViewById(R.id.Hair);
        ForBeard = findViewById(R.id.Beard);
        btnConfirmAppointment = findViewById(R.id.ConfirmAppointment);
        txSelectedServices = findViewById(R.id.SelectedServices);
        closebutton=findViewById(R.id.CloseBtn);

        btnConfirmAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedServices();
            }
        });

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code for close application
                CloseApp();
            }

            private void CloseApp() {
                finishAffinity();
            }
        });
    }
    

    private void displaySelectedServices() {
        StringBuilder selectedServices = new StringBuilder(" Selected Services: ");

        double totalCost = 0.0;

        if (ForHair.isChecked()) {
            selectedServices.append("Hair (OMR").append(PRICE_HAIR).append(") ");
            totalCost += PRICE_HAIR;
        }

        if (ForBeard.isChecked()) {
            selectedServices.append("Beard (OMR").append(PRICE_BEARD).append(") ");
            totalCost += PRICE_BEARD;
        }

        // Remove the trailing space if no services are selected
        if (selectedServices.toString().equals("Selected Services: ")) {
            selectedServices = new StringBuilder("No services has been selected");
        } else {
            // Add the total cost information
            selectedServices.append("\nTotal Cost: OMR").append(totalCost);
        }

        // Display the selected services and total cost in the TextView
        txSelectedServices.setText(selectedServices.toString());
    }
}