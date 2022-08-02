package com.db.contacttracingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.db.contacttracingapp.data.ContactDataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityInfo extends AppCompatActivity {

    Button btSave;
    EditText edFirstName , edPhoneNum;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public long lngContactID=0;
    ContactDataClass contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

        btSave = findViewById(R.id.btSave);
        edFirstName = findViewById(R.id.edFirstName);
        edPhoneNum = findViewById(R.id.edPhoneNum);
        firebaseDatabase = FirebaseDatabase.getInstance(" https://contacttracingapp-6be87-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference().child("ContactApp");
        contact = new ContactDataClass();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // on below line we are setting data in our firebase database.
                if(snapshot.exists())

                    lngContactID=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // displaying a failure message on below line.
                Toast.makeText(MainActivityInfo.this, "Fail to add Course..", Toast.LENGTH_SHORT).show();
            }
        });




        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFirstName=edFirstName.getText().toString();
                String strPhoneNum = edPhoneNum.getText().toString();
                contact.setStrName(strFirstName);
                contact.setStrMobNum(strPhoneNum);
                databaseReference.child(String.valueOf(lngContactID + 1)).setValue(contact);
                Toast.makeText(MainActivityInfo.this, "Contact Saved", Toast.LENGTH_SHORT).show();
                // starting a main activity.
                startActivity(new Intent(MainActivityInfo.this, MainActivity.class));
            }
        });

        };



    }