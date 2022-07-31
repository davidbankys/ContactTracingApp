package com.db.contacttracingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity<button> extends AppCompatActivity {
        Button button1;
        ListView listView;
        ArrayList<String> list;
        ArrayAdapter<String> arrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listviewy);
        button1 = findViewById(R.id.button_one);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
        android.R.layout.simple_list_item_1,list);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MainActivityInfo.class);
                startActivity(intent);
                
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }

        });

        }
}
