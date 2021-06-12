package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private EditText amountEditText;
    private Button convertButton;

    private void initialise() {
        amountEditText = findViewById(R.id.amountEditText);
        convertButton = findViewById(R.id.convertButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        convertButton.setOnClickListener(v -> {
            String dollarAmount = amountEditText.getText().toString();
            Double amount = Double.parseDouble(dollarAmount);
            Double usdToInr = 73.23; // 1 USD to INR exchange value, as of 12th June, 2021.
            Double inrValue = amount * usdToInr;
            // Rounding up Double value to 2 decimal places.
            inrValue = BigDecimal.valueOf(inrValue).setScale(2, RoundingMode.HALF_UP).doubleValue();
            Toast.makeText(MainActivity.this,
                    "$ " + dollarAmount + " is " + "₹ " + inrValue.toString(),
                    Toast.LENGTH_LONG).show();
        });
    }
}