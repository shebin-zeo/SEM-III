package com.example.birthday_wish;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private TextView textView;
    private boolean isImage1Visible = false; // Track which image is currently visible

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);

        // Handle window insets for edge-to-edge mode
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up the click listener to toggle images and header
        imageView1.setOnClickListener(v -> toggleImages());
        imageView2.setOnClickListener(v -> toggleImages());
    }

    private void toggleImages() {
        if (isImage1Visible) {
            // Hide the first image and show the second image
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE); // Show the header
        } else {
            // Hide the second image and show the first image
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
            textView.setVisibility(View.GONE); // Hide the header
        }
        // Toggle the state
        isImage1Visible = !isImage1Visible;
    }
}
