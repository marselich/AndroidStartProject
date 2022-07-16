package ru.kalievmars.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Calculator extends AppCompatActivity {

    private  static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private  static final String LifecycleTag = "LIFECYCLE";

    EditText numOne, numTwo;
    TextView result;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm onCreate() and I'm started");
        setContentView(R.layout.activity_calculator);



        final Button calculate = (Button) findViewById(R.id.calc);

//        // Context training
//        TextView textView = new TextView(this);
//        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), );
//
//        // доступ из класса Activity -- наследник Context
//        getSystemService(LAYOUT_INFLATER_SERVICE);
//
//            // Shared prefs доступ с использованием контекста приложения
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);


        // intent (намерения) - посылка, используется для создания или открытия новых окон, даже других приложений (например камера в смартфоне)
        // бывают явные и неявные. Явные = это конкретные приложения (открой именно ТУ камеру), неявные = приложения на выбор удовлетворяющие одинаковым критериям (открыть любой браузер из доступных)


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "button pushed");
                try {
                    calculateAnswer();
                } catch (Exception e) {
                        // прерывание
//                    e.printStackTrace();
//                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    finish();
                        // востановление
                    e.printStackTrace();
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    dropFields();
                }
//                catch (IOException e) {
//                    Toast.makeText(Calculator.this, "Here io error", Toast.LENGTH_SHORT).show();
//                    finish();
//                } catch(ArithmeticException e) {
//                    Toast.makeText(Calculator.this, "Here arithmetic error", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
                Intent i = new Intent(Calculator.this, MainActivity.class); // написать письмо
//                startActivity(i); // отправить его
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart() and I'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop() and I'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I'm onDestroy() and I'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause() and I'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume() and I'm started");
    }


    private void dropFields() {
        numOne.setText("0");
        numTwo.setText("0");
        RadioButton rb = (RadioButton) radioGroup.getChildAt(0);
        rb.setChecked(true);
        result.setText("Your answer will displayed here");
    }

    private void calculateAnswer() throws ArithmeticException, IOException {


//        try {
//         //   int a = 25/ 0;
//
//            throw new ArithmeticException("I am generated exception");
//
//        } catch (ArithmeticException e) {
////            e.printStackTrace();
//            Toast.makeText(this, "There is a problem inside an app", Toast.LENGTH_SHORT).show();
//            finish();
//        }


        numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        RadioButton add = (RadioButton) findViewById(R.id.add);
//        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
//        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
//        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        result = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been founded");

        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();

        double x = 0;
        double y = 0;

        if(!num1.equals("") && num1 != null) {
            x = Double.parseDouble(num1);
        } else {
            Toast.makeText(this, "Number one is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!num2.equals("") && num2 != null) {
            y = Double.parseDouble(num2);
        } else {
            Toast.makeText(this, "Number two is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "x = " + x + " y = " + y);

        double solution = 0;

        switch(radioGroup.getCheckedRadioButtonId()) {
            case R.id.add:
                Log.d(LogcatTag, "Operation is add");
                solution = x + y;
                break;
            case R.id.subtract:
                Log.d(LogcatTag, "Operation is sub");
                solution = x - y;
                break;
            case R.id.multiply:
                Log.d(LogcatTag, "Operation is multiply");
                solution = x * y;
                break;
            case R.id.divide:
                Log.d(LogcatTag, "Operation is divide");
                if(y == 0) {
                    Toast.makeText(this, "Number two cannot be zero", Toast.LENGTH_SHORT).show();
                    Log.e(LogcatTag, "Number two cannot be zero");
                    return;
                }
                solution = x / y;

                break;
        }

        Log.d(LogcatTag, "The result of operations is: " + solution);

        //Log.wtf(); // what a Terrible Failre == error

        result.setText("The answer is " + solution);

        switch ((int)Math.random() * 2) {
            case 0: throw new ArithmeticException("I am generated arithmetic exception");
            case 1: throw new IOException("I am generated ioException exception");
        }


    }

}