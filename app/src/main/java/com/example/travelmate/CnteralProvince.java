package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CnteralProvince extends AppCompatActivity {
    Button BTN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnteral_province);


        BTN3 = findViewById(R.id.btn3);


        BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Sri+Dalada+Maligawa,+Kandy/@7.2936923,80.6000393,13z/data=!3m1!4b1!4m9!4m8!1m0!1m5!1m1!1s0x3ae3662db149fbf5:0x8165d70ac115e887!2m2!1d80.641325!2d7.293609!3e0?authuser=0&entry=ttu");
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}