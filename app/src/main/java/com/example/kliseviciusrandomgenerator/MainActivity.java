package com.example.kliseviciusrandomgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText inputText1;
    private EditText inputText2;
    private EditText inputText3;
    private Button btn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText1 = findViewById(R.id.inputText1);
        inputText2 = findViewById(R.id.inputText2);
        inputText3 = findViewById(R.id.inputText3);
        btn = findViewById(R.id.btn);
        result = findViewById((R.id.result));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer num1 = Integer.parseInt(inputText1.getText().toString());
                    Integer num2 = Integer.parseInt(inputText2.getText().toString());
                    Integer num3 = Integer.parseInt(inputText3.getText().toString());
                    Integer[] ats = randomGenerator(num1,num2,num3);
                    result.setText("Your lucky numbers: " + Arrays.toString(ats));
                }catch (NumberFormatException ignored){

                }

            }
        });
    }

    private Integer[] randomGenerator(Integer num1, Integer num2, Integer num3) {
        Integer[] randomArr = new Integer[num1];
        for (Integer i = 0; i< randomArr.length; i++) {
            randomArr[i] = Integer.valueOf(randomNumber(num2,num3).intValue());
        }
        return randomArr;

    }

    private Double randomNumber(Integer num2, Integer num3) {


        return ((Math.random() * (num3 - num2)) + num2);

    }
}