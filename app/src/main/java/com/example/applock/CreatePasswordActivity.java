package com.example.applock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1 = findViewById(R.id.editTextTextPassword1);
        editText2 = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 =editText1.getText().toString();
                String text2 =editText2.getText().toString();

                if(text1.equals("") || text2.equals("")){

                    Toast.makeText(CreatePasswordActivity.this,"No Password",Toast.LENGTH_SHORT).show();

                }else{
                    if(text1.equals(text2)){
                        SharedPreferences settings = getSharedPreferences("PRESS",0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("Password",text1);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(CreatePasswordActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}