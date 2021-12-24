package com.example.ex10_both_activity_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent1 = getIntent();

        Log.d("액티비티 테스트", "세컨트임!!");

        int num1 = intent1.getIntExtra("Num1", 0);
        int num2 = intent1.getIntExtra("Num2", 0);
        String op1 = intent1.getStringExtra("Op1");

        int result = 0;
        if(op1.equals("+"))
        {
            result = num1 + num2;
        }
        else if(op1.equals("-"))
        {
            result = num1 - num2;
        }
        else if(op1.equals("*"))
        {
            result = num1 * num2;
        }
        else if(op1.equals("/"))
        {
            result = num1 / num2;
        }

        Button btn1 = findViewById(R.id.btnReturn);
        final int finalResult = result;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                intent2.putExtra("Result" , finalResult);

                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }
}









