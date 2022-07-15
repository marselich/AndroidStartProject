package ru.kalievmars.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        RadioButton add = (RadioButton) findViewById(R.id.add);
//        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
//        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
//        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView result = (TextView) findViewById(R.id.result);

        float x = Integer.parseInt(numOne.getText().toString());
        float y = Integer.parseInt(numTwo.getText().toString());

        float solution = 0;

        switch(radioGroup.getCheckedRadioButtonId()) {
            case R.id.add:
                solution = x + y;
                break;
            case R.id.subtract:
                solution = x - y;
                break;
            case R.id.multiply:
                solution = x * y;
                break;
            case R.id.divide:
                if(y == 0) {
                    Toast.makeText(this, "Number two cannot be zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                solution = x / y;

                break;
        }

        result.setText("The answer is " + solution);
    }

}