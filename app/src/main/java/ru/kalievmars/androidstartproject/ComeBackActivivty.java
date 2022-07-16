package ru.kalievmars.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComeBackActivivty extends AppCompatActivity {

    EditText sendBackEditText;
    Button sendBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back_activivty);

        sendBackEditText = findViewById(R.id.sendBackTextEdit);
        sendBackBtn = findViewById(R.id.sendBackBtn);

        sendBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("tv", sendBackEditText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}