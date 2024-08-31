package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText phoneEditText;
    private RadioGroup genderGroup;
    private CheckBox interest1CheckBox;
    private CheckBox interest2CheckBox;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details_activity);

        // Initialize UI elements
        nameEditText = findViewById(R.id.name);
        phoneEditText = findViewById(R.id.phone);
        genderGroup = findViewById(R.id.gender_group);
        interest1CheckBox = findViewById(R.id.interest1);
        interest2CheckBox = findViewById(R.id.interest2);
        registerButton = findViewById(R.id.register_button);

        // Set click listener for register button
        registerButton.setOnClickListener(v -> {
            // Gather user details
            String name = nameEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedGenderId);
            String gender = selectedGender != null ? selectedGender.getText().toString() : "Not Specified";
            boolean interest1 = interest1CheckBox.isChecked();
            boolean interest2 = interest2CheckBox.isChecked();

            // Prepare details to show
            Intent intent = new Intent(UserDetailsActivity.this, ShowDetailsActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("PHONE", phone);
            intent.putExtra("GENDER", gender);
            intent.putExtra("INTEREST1", interest1);
            intent.putExtra("INTEREST2", interest2);
            startActivity(intent);
        });
    }
}
