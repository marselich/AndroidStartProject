package ru.kalievmars.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);

        textView.setText("Hello Andriod");
        textView.setText("Hello Andriod1231312");

        textView.setTextSize(22);

        setContentView(textView);
    }
}