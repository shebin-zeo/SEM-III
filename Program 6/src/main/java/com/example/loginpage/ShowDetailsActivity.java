package com.example.loginpage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailsActivity extends AppCompatActivity {

    private TextView detailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details_activity);

        // Initialize UI element
        detailsTextView = findViewById(R.id.details_text);

        // Retrieve and display user details
        String name = getIntent().getStringExtra("NAME");
        String phone = getIntent().getStringExtra("PHONE");
        String gender = getIntent().getStringExtra("GENDER");
        boolean interest1 = getIntent().getBooleanExtra("INTEREST1", false);
        boolean interest2 = getIntent().getBooleanExtra("INTEREST2", false);

        // Format details
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(name).append("\n");
        details.append("Phone: ").append(phone).append("\n");
        details.append("Gender: ").append(gender).append("\n");
        details.append("Interest 1: ").append(interest1 ? "Yes" : "No").append("\n");
        details.append("Interest 2: ").append(interest2 ? "Yes" : "No").append("\n");

        // Display details
        detailsTextView.setText(details.toString());
    }
}
