package ru.kalievmars.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_C = 1;
    EditText et;
    TextView tv;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button:
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, ToInfActivity.class);
                String eText = et.getText().toString();
                i.putExtra("et", eText);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, ComeBackActivivty.class);
                startActivityForResult(i, REQ_C);
                break;
        }
    }


//    @Override
//    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//
//        return true;
//    }
}