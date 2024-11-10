package com.example.grid_layout;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result; // Storing the result
    StringBuilder input=new StringBuilder(); // take series of input string its diffrent from normal string
    double value1=0; // store the first value
    String operator=""; // store the operator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

        //For getting number with button id
        int[] Button_Id = {R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9};
        for (int id : Button_Id) {
            findViewById(id).setOnClickListener(v -> NumberCheck(v));

        }


        int[] operator_Id = {R.id.badd, R.id.bsub, R.id.bmul, R.id.bdiv};
        for (int id : operator_Id) {

            findViewById(id).setOnClickListener(v -> operatorCheck(v));
        }
       findViewById(R.id.bclr).setOnClickListener(v -> clear());
        findViewById(R.id.beq).setOnClickListener(v -> equal());
    }

    private void NumberCheck(View view)
    {
        String number=((Button)view).getText().toString();
        input.append(number);
        result.setText(input.toString());

    }
    private void operatorCheck(View view)
    {
        if(input.length() >0)
        {
            value1=Double.parseDouble(input.toString());
            operator=((Button)view).getText().toString();
            input.setLength(0);
        }

    }

    private void equal()
    {
        double value2=Double.parseDouble(input.toString());
        double resultValue=0;
        switch (operator)
        {
            case "+" : resultValue=value1+value2;break;
            case "-" : resultValue=value1-value2;break;
            case "*" : resultValue=value1*value2;break;
            case "/" : resultValue=value1/value2;break;

        }
        result.setText(String.valueOf(resultValue));


    }

    private void clear()
    {
        input.setLength(0);
        operator="";
        value1=0;
        result.setText("0");



    }










}