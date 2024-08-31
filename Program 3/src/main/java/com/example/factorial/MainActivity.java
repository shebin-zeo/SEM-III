package com.example.factorial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //First declare all variable 1
    private EditText num1;
    private EditText result;
    private Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Taking all values entered in user interface 2
        num1=findViewById(R.id.num1);
        result=findViewById(R.id.result);
        Calculate=findViewById(R.id.button);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Calculate.setOnClickListener(view -> factorial());
    }
    private void factorial()
    {
        String input1=num1.getText().toString();
        if(input1.isEmpty())
        {
            Toast.makeText(this,"Enter the number ",Toast.LENGTH_LONG);
            return;
        }
        int number;
        try {
           number= Integer.parseInt(input1);

        } catch (NumberFormatException e)
        {
            Toast.makeText(this,"Invalid number",Toast.LENGTH_LONG);
            return;
        }
        if(number<0)
        {
            Toast.makeText(this,"The number should greaterthan zero",Toast.LENGTH_LONG);
            return;
        }
        long factoria=calculate_answer(number);
        result.setText(String.valueOf(factoria));



    }
    private long calculate_answer(int number)
    {
        long result=1;
        for(int i=1;i<=number;i++)
        {
            result *=i;
        }
        return result;

    }

}