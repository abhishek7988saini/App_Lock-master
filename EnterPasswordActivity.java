package com.example.applock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Button button1;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings = getSharedPreferences("PRESS",0);
        password = settings.getString("password","");

        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                if (text.equals("unlock")){
                    Intent intent = new Intent(getApplicationContext(),image1.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(EnterPasswordActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CreatePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}