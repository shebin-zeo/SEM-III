package com.example.event_handling;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private EditText result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        result=findViewById(R.id.result);
        button=findViewById(R.id.button);
        // Set up button click listener
        button.setOnClickListener(v -> {
            // Retrieve values from EditText fields
            String num1Str = num1.getText().toString();
            String num2Str = num2.getText().toString();

            // Check if input fields are not empty
            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                try {
                    // Convert strings to integers
                    int number1 = Integer.parseInt(num1Str);
                    int number2 = Integer.parseInt(num2Str);

                    // Calculate result
                    int sum = number1 + number2;

                    // Display result
                    result.setText(String.valueOf(sum));
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    result.setText("Error");
                }
            } else {
                // Handle empty fields
                result.setText("Please enter numbers");
            }
        });
    }
}