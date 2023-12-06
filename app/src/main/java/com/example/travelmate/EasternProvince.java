package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EasternProvince extends AppCompatActivity {
    Button BTN4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_province);

        BTN4 = findViewById(R.id.btn5);


        BTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Arugam+Bay+Beach/@6.8404913,81.7955621,13z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3ae5a2d27b6fafbf:0xc6efd6b59df5db34!2m2!1d81.8368478!2d6.8404078!3e0?authuser=0&entry=ttu");
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}