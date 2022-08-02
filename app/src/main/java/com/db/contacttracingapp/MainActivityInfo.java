package com.db.contacttracingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityInfo extends AppCompatActivity {

    Button btSave;
    EditText edFirstName , edPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

        btSave = findViewById(R.id.btSave);
        edFirstName = findViewById(R.id.edFirstName);
        edPhoneNum = findViewById(R.id.edPhoneNum);


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFirstName=edFirstName.getText().toString();
                String strPhoneNum = edPhoneNum.getText().toString();
            }
        });

        };


    https://contacttracingapp-6be87-default-rtdb.firebaseio.com/


    }