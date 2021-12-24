package com.example.ex10_both_activity_calc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("액티비티 테스트", "11111");

        EditText edt1 = findViewById(R.id.edtNum1);
        EditText edt2 = findViewById(R.id.edtNum2);
        RadioGroup rg1 = findViewById(R.id.rdoGroup);
        Button btn1 = findViewById(R.id.btnNewActivity);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), SecondActivity.class);

                intent1.putExtra("Num1", Integer.parseInt(edt1.getText().toString()));
                intent1.putExtra("Num2", Integer.parseInt(edt2.getText().toString()));

                Log.d("액티비티 테스트", "2222");

                switch (rg1.getCheckedRadioButtonId())
                {
                    case R.id.rdoAdd:
                        intent1.putExtra("Op1", "+");
                        break;
                    case R.id.rdoSub:
                        intent1.putExtra("Op1", "-");
                        break;
                    case R.id.rdoMul:
                        intent1.putExtra("Op1", "*");
                        break;
                    case R.id.rdoDiv:
                        intent1.putExtra("Op1", "/");
                        break;
                }


                startActivityForResult(intent1, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {

            int result = data.getIntExtra("Result", 0);
            Toast.makeText(getApplicationContext(), "결과:"+result, Toast.LENGTH_SHORT).show();

            Log.d("액티비티 테스트", "지대로 돌려받았다--->" + result);
        }
    }
}